function dataCheck(){
	var userpwd  = document.getElementById("userpwd");
	var username = document.getElementById("username");
	var hobby    = document.getElementsByClassName("hobby");
	var age 	 = document.getElementById("age");
 	var phone1	 = document.getElementById("phone1").value;
	var phone2	 = document.getElementById("phone2");
	var addr1 	 = document.getElementById("addr1").value;
	var addr2 	 = document.getElementById("addr2");
	 
		
	if(userpwd.value.length <3 || userpwd.value.length >10){
		alert("비밀번호는 3~10자로 입력해주세요.");
		userpwd.select();
		userpwd.focus();
		return false;
	}
	
	if(username.value.trim().length == 0){
		alert("이름을 입력하세요.");
		username.select();
		username.focus();
		return false;
	}
	
 	var h = "";
	for(var i=0; i<hobby.length; i++){
		if(hobby[i].checked)
			h += hobby[i].value + " ";
	}
	document.getElementById("hobby").value = h;

	if(isNaN(age.value)){
		alert("나이는 숫자만 입력해주세요.");
		age.select();
		age.focus();
		return false;
	}
	var phone = phone1 + phone2.value;
	document.getElementById("phone").value = phone;
	
	var address = addr1+" "+addr2.value;
	document.getElementById("address").value = address;
	
	return true;
}

//ID 중복확인 창 열기
function idCheckOpen(){
	window.open("idCheck", "newidwindow", "top=200,left=300,width=400,height=400");
}

function home(){
	location.href = "home2";
}
