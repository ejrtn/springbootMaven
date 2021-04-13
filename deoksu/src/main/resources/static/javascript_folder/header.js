
// 회원가입위에 마우스 올리거나 내리면 발생하는 함수
function join(a){
	if(a==1)
		$("#join").css("background-color","#9e9e9e8c");
	else
		$("#join").css("background-color","");
}

// ID&PW찾기위에 마우스 올리거나 내리면 발생하는 함수
function idpw(a){
	if(a==1)
		$("#idpw").css("background-color","#9e9e9e8c");
	else
		$("#idpw").css("background-color","");
}

// 내정보찾기위에 마우스 올리거나 내리면 발생하는 함수
function info(a){
	if(a==1)
		$("#info").css("background-color","#9e9e9e8c");
	else
		$("#info").css("background-color","");
}

// 	모달창 띄우는 함수
function modal_open(a){
//	a변수의 값은 html_overlap의 폴더 안의 파일 중 어떤 값인지 분류하는 변수
	$("#user_modal").load("html_overlap/"+a+"_modal.html")
	document.getElementById("user_modal").style.display="block";
}

//	모달창 닫기 버튼
function modal_close(){
	$("#user_modal").css("display","none");
}

//	모달 내용 바꾸기
function modal_change(a){
	$("#user_modal").load("html_overlap/"+a+"_modal.html")
}


// 패스워드 8자이상이고, 대문자, 소문자, 특수문자 숫자 포함 확인 함수
function chkPW(pw){
	var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	
	if(false === reg.test(pw)) {
		return "다시"
	}else {
		return "통과"
	}
}

$(function(){
//  해더 html 불러오기
	$("#header").load("html_overlap/header.html")
})



// ID 중복 확인
function idcheck(){
	id=$("#text_id").val()
	$.ajax({
		url: "idcheck",
		type: 'POST',
		data: {"id":id},
		success: function (data) {
			console.log(data)
			if(data!="")
				alert("중복된 ID 입니다");
		    else{
			  	alert(data+" 사용 가능합니다.");
			  	$("#btn_id").val("확인완료")
			}
		},
		error: function (error) {
			   console.error(error);
		}
	});
}

// 회원가입 완료
function joinok(){
	name = $("#text_name").val();
	id = $("#text_id").val();
	pw = $("#text_pw").val();
	pwc = $("#text_pwc").val();
	email = $("#text_email").val();
	key = $("#key_result").val();
	if($("#btn_id").val()=="확인완료"){
		if(pw==pwc){
			if(chkPW(pw)!="통과"){
				alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
			}else{
				if(key=="통과"){
					$.ajax({
						url: "joinok",
						type: 'POST',
						data: {"name":name,"id":id,"pw":pw,"email":email},
						success: function (data) {
//							모달창 닫기
							modal_close('join');
						},
						error: function (error) {
						    console.error(error);
						}
					});
				}else{
					alert("이메일 인증 해주세요");
				}
			}
		}else{
			alert("비밀번호 다시 입력해주세요");
			pw = $("#text_pw").val("");
			pwc = $("#text_pwc").val("");
		}
	}else{
		alert("중복 체크 해주세요")
	}
}

// 내정보
function myinfo(){
	$.ajax({
		url: "myinfo",
		type: 'POST',
		success: function (data) {
			s = data.split("/")
			$("#info_text_name").val(s[0]);		// 이름
			$("#info_text_id").val(s[1]);		// ID
			$("#info_text_email").val(s[2]);	// 이메일
			$("#key_result").val("")
		},
		error: function (error) {
			console.error(error);
		}
	});
}

// 내정보 변경
function info_change(){
	id=$("#info_text_id").val();
	pw=$("#info_text_ingpw").val();
	repw=$("#info_text_pw").val();
	repwc=$("#info_text_pwc").val();
	email=$("#info_text_email").val();
	if(repwc == repw){
		if(chkPW(pw)!="통과"){
			alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
		}else{
			$.ajax({
				url: "myinfochange",
				type: 'POST',
				data: {"id":id,"pw":pw,"repw":repw,"email":email},
				success: function (data) {
					alert(data);
				},
				error: function (error) {
					console.error(error);
				}
			});
		}
	}else{
		alert("비밀번호가 다릅니다.");
	}
}

// 로그인
function login(){
	id = $("#login_id").val();
	pw = $("#login_pw").val();
	$.ajax({
		url: "login",
		type: 'POST',
		data: {"id":id,"pw":pw},
		success: function (data) {
			
			if(data==""){
				alert("");
			}else{
				$("#session").val(data);
				$("#login_id").css("display","none");
				$("#login_pw").css("display","none");
				$("#login_btn").css("display","none");
				$("#login_id").val("");
				$("#login_pw").val("");
				$("#logout_label").text(data+"님 로그인");
				$("#logout_label").css("display","");
				$("#logout_btn").css("display","");
				$("#info").css("display","");
			}
		},
		error: function (error) {
			console.error(error);
		}
	});
}

// 로그아웃
function logout(){
	$("#login_id").css("display","");
	$("#login_pw").css("display","");
	$("#login_btn").css("display","");
	$("#logout_label").css("display","none");
	$("#logout_btn").css("display","none");
	$("#info").css("display","none");
	$("#session").val("")
}

// 이메일
function email(){
	$.ajax({
		url: "email",
		type: 'POST',
		data: {"email":$("#text_email").val()},
		success: function (data) {
			$("#key_result").val(data);
		},
		error: function (error) {
			console.error(error);
		}
	});
}
// 이메일 인증키 확인 함수
function keycheck(){
	if($("#key_result").val()==$("#text_key").val()){
		$("#key_result").val("통과")
	}else{
		console.log($("#key_result").val());
	}
}

function find(a){
	var data;
	var eamil;
	var name;
	var id;
	if(a=='id'){
		name = $("#id_text_name").val();
		email = $("#id_text_email").val();
		data = {"name":name,"email":email,"type":a}
	}else{
		name = $("#pw_text_name").val();
		id = $("#pw_text_name").val();
		email = $("#pw_text_email").val();
		data = {"name":name,"id":id,"email":email,"type":a}
	}
	$.ajax({
		url: "find",
		type: 'POST',
		data: data,
		success: function (data) {
			if(a=="id")
				alert("id : "+data)
			else
				alert(data)
		},
		error: function (error) {
			console.error(error);
		}
	});
}

