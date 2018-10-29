package dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import VO.Board;

public interface BoardMapper {
	public int updateHits(Board vo);
	public List<Board> selectAll(String searchKeyword,RowBounds rb);
	public int insertBoard(Board vo);
	public Board boardinfo(Board vo);
	public int getTotal();
}
