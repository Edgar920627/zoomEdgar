/**
 * formSubmit() 회원가입 필수항목 검사 checkid(id) 회원가입 아이디 중복검사
 * 
 * if (frm.id.value.length < 4 || frm.id.value.length > 16) { alert("아이디는 4자 이상
 * 16자 이하로 입력해주세요."); frm.id.focus(); return false; }
 * 
 * 
 */
var check = false;

function formSubmit() {

	var form = document.joinForm;

	if (form.user_id.value.length < 4 || form.user_id.value.length > 16) {
		alert("아이디는 4자 이상 16자 이하로 입력해주세요.");
		frm.id.focus();
		return false;
	}

	if ('' == form.user_id.value || !check) {
		alert('아이디를 확인해주세요.');
		form.user_id.focus();
		return false;

	} else if ('' == form.user_pw.value) {
		alert('비밀번호를 입력해주세요.');
		form.user_pw.focus();
		return false;

		var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@#$%^*-]).{8,}$/;
		var hangle_check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

		if (!reg.test(frm.user_pw.value)) {
			alert("비밀번호는 8자 이상, 숫자,대문자,소문자,특수문자를 모두 포함해야 합니다.");
			return false;
		} else if (/(\w)\1\1\1/.test(frm.user_pw.value)) {
			alter("같은 문자를 4번 이상 사용하실 수 없습니다.");
			return false;
		} else if (frm.user_pw.value.search(/\s/) != -1) {
			alert("비밀번호에 공백이 있습니다.")
			return false;
		} else if (hangle_check.test(frm.user_pw.value)) {
			alert("비밀번호에 한글은 사용할 수 없습니다.")
			return false;
		}

	} else if ('' == form.user_name.value) {
		alert('이름을 입력해주세요.');
		form.user_name.focus();
		return false;

	} else if ('' == form.user_email.value) {
		alert('이메일를 입력해주세요.');
		form.user_email.focus();
		return false;
	}

	form.submit();
}

function checkid(id) {
	
	var idRegExp = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사

	
	check = false;
	


	if (id == "") {
		$("#idCheck_text").text("아이디를 작성해주세요.");

	} else if (!idRegExp.test(id)) {
		$("#idCheck_text").text("대소문자만 입력해주세요.");
		
	} else if (id.length < 4 || id.length > 11 ) {
		$("#idCheck_text").text("아이디를 4~12자까지 입력해주세요.");


	} else {
		$.ajax({
			url : contextPath + "/member/MemberCheckIdOk.me?id=" + id,
			type : 'get',
			dataType : 'text',
			success : function(data) {
				if (data.trim() == 'ok') {
					$("#idCheck_text").text("사용할 수 있는 아이디입니다.");
					check = true;
				} else {
					$("#idCheck_text").text("중복된 아이디입니다.");
				}
			},
			error : function() {
				console.log("오류");
			}
		})
	}
}

$("input[name='user_id']").keyup(function(event) {
	var id = $("input[name='user_id']").val();
	checkid(id);
})
