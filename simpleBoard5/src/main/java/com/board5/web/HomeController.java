package com.board5.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import VO.Board;
import VO.Member;
import dao.BoardMapper;
import dao.MemberMapper;
import util.PageNavigator;


@Controller
public class HomeController {
	@Autowired
	SqlSession session;
	
	final int countPerPage = 10;
	final int pagePerGroup = 5;
	private static final String UPLOADPATH="C:\\\\fileupload";
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		
		return "home";
	}
	
	@RequestMapping(value = "/memberjoin", method = RequestMethod.GET)
	public String join1() {
		
		return "join";
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String join2(String userid, Member vo, Model model) {
		System.out.println(vo);
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		mapper.insertMember(vo);
		
		
		return "home";
	}
	/*@RequestMapping(value = "/checkid", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String userid){
		int count = 0;
		
		return "bb";
	}*/
	@RequestMapping(value = "/memberlogin", method = RequestMethod.GET)
	public String login1(/*Member member, HttpSession hsession*/) {
		
		/*Member result = mapper.findMember(member);
		
		hsession.setAttribute("userid", result.getUserid() );*/
		
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login2(Member vo, HttpSession hsession) {
		System.out.println(vo);
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		Member result = mapper.login(vo);
		hsession.setAttribute("userid", result.getUserid());
		
		
		return "home";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String login3(Member vo, HttpSession hsession) {
		
		hsession.invalidate();
		
		return "home";
	}
	@RequestMapping(value = "/listboard", method = RequestMethod.GET)
	public String board1(@RequestParam(value="page", defaultValue="1") int page,Model model,String searchKeyword) {
		List<Board> boardlist = new ArrayList<Board>();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int total = mapper.getTotal();
		
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
		
		RowBounds rb = new RowBounds(navi.getStartRecord(), navi.getCountPerPage());
		boardlist = mapper.selectAll(searchKeyword,rb);
		
		System.out.println(boardlist);
		model.addAttribute("boardList", boardlist);
		model.addAttribute("navi", navi);
		return "board";
	}
	/*@RequestMapping(value ="/listboard", method=RequestMethod.POST)
	public String board(@RequestParam(value="page", defaultValue="1") int page, Model model) {
		
		List<Board> boardList = new ArrayList<Board>();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		int total = mapper.getTotal();
		
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
		
		RowBounds rb = new RowBounds(navi.getStartRecord(), navi.getCountPerPage());
		boardList = mapper.selectAll(rb);
		
		model.addAttribute("boardList",boardList);
		model.addAttribute("navi",navi);
		
		return "board";
		
	}*/
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	public String board2() {
		
		return "boardwrite";
	}
	@RequestMapping(value = "/golist", method = RequestMethod.POST)
	public String board3() {
		
		return "redirect:/listboard";
	}
	@RequestMapping(value = "/boardwrite", method = RequestMethod.POST)
	public String board4(Model model, Board vo, HttpSession hsession, MultipartFile uploadfile) {
		System.out.println(vo);
		
		String userId = (String) hsession.getAttribute("userid");
		
		vo.setUserId(userId);
		
		System.out.println(uploadfile.getOriginalFilename());
		if(uploadfile!=null) {
			UUID uuid = UUID.randomUUID();
			String originalFile = uploadfile.getOriginalFilename();
			String saveName = uuid+"_"+uploadfile.getOriginalFilename();
			vo.setOriginalFile(originalFile);
			vo.setSavedFile(saveName);
		
			File file = new File(UPLOADPATH, saveName);
		
		try {
			uploadfile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.insertBoard(vo);
		
		return "redirect:/listboard";
	}
	@RequestMapping(value = "/boardinfo", method = RequestMethod.GET)
	public String boardinfo(Board vo, Model model,HttpSession hsession) {
		System.out.println(vo);
		Board boardinfo = new Board();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		boardinfo = mapper.boardinfo(vo);
		mapper.updateHits(vo);
		model.addAttribute("boardinfo",boardinfo);
		
		
		return "boardinfo";
	}
	@RequestMapping(value = "/infoboard", method = RequestMethod.POST)
	public String boardinfo2() {
	
		
		return "redirect:/listboard";
	}
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public void download(Board vo, Model model, HttpServletResponse response) {
		Board boardInfo = new Board();
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		boardInfo = mapper.boardinfo(vo);
		
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(boardInfo.getOriginalFile(),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fullPath = UPLOADPATH+"\\\\"+boardInfo.getSavedFile();
		FileInputStream fis = null;  
		ServletOutputStream sos = null; 
		
		try {
			fis = new FileInputStream(fullPath);
			sos = response.getOutputStream();
			FileCopyUtils.copy(fis, sos);
			fis.close();
			sos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
