    var isNicknameAvailable = false;
    var isIdAvailable = false;
	var isemailAvailable = false;
	var isPhoneAvailable = false;

    $(document).ready(function() {
        $("#idcf").click(function() {
            var id = $("#id").val();
            var idRegex = /^[a-zA-Z0-9]{4,12}$/;
            if (!idRegex.test(id)) {
                alert('아이디는 4자 이상 12자 이하의 영문자 또는 숫자만 가능합니다');
                $("#id").focus();
                return;
            }
            $.ajax({
                type: "post",
                url: "idcheck",
                data: { "id": id },
                async: true,
                success: function(data) {
                    if (data == "ok") {
                        alert("사용 가능한 아이디입니다.");
                        isIdAvailable = true;
                    } else {
                        alert("이미 사용중인 아이디입니다.");
                        isIdAvailable = false;
                        $("#id").focus();
                    }
                }
            });
        });

        $("#nncf").click(function() {
            var nickname = $("#nickname").val();
            if (nickname.trim() === "") {
                alert('닉네임을 입력해주세요');
                $("#nickname").focus();
                return;
            }
            $.ajax({
                type: "post",
                url: "nicknamecheck",
                data: { "nickname": nickname },
                async: true,
                success: function(data) {
                    if (data == "ok") {
                        alert("사용 가능한 닉네임입니다.");
                        isNicknameAvailable = true;
                    }
                    else {
                        alert("이미 사용중인 닉네임입니다.");
                        isNicknameAvailable = false;
                        $("#nickname").focus();
                    }
                }
            });
        });

        $("#emcf").click(function() {
            var email = $("#email").val();
            var domain = $("#domain").val();
            if ($("#email").val().trim() === "") {
                alert('이메일을 입력해 주세요');
                $("#email").focus();
                return;
            }


            var fullemail = email+domain; // 전체 전화번호 조합

            $.ajax({
                type: "post",
                url: "emailcheck",
                data: { "fullemail": fullemail },
                async: true,
                success: function(data) {
                    if (data == "ok") {
                        alert("사용 가능한 이메일입니다.");
                        isemailAvailable = true;
                    }
                    else {
                        alert("이미 사용중인 이메일입니다.");
                        isemailAvailable = false;
                        $("#email").focus();
                    }
                }
            });
        });

        $("#pncf").click(function() {
            var phonemid = $("#phonemid").val();
            var phoneend = $("#phoneend").val();
            var phoneRegex = /^[0-9]{4}$/; // 전화번호 형식 체크 (4자리 숫자)

            if (phonemid.trim() === "" || phoneend.trim() === "") {
                alert('전화번호를 입력해주세요.');
                $("#phone0").focus();
                return;
            }

            if (!phoneRegex.test(phonemid)) {
                alert('전화번호 중간자리는 4자리 숫자만 가능합니다.');
                $("#phone1").focus();
                return;
            }
            if (!phoneRegex.test(phoneend)) {
                alert('전화번호 뒷자리는 4자리 숫자만 가능합니다.');
                $("#phone2").focus();
                return;
            }

            var fullphone = "010-"+ phonemid + "-" + phoneend; // 전체 전화번호 조합

            $.ajax({
                type: "post",
                url: "phonecheck", // 서버에서 처리할 URL
                data: { "fullphone": fullphone },
                async: true,
                success: function(data) {
                    if (data == "ok") {
                        alert("사용 가능한 전화번호입니다.");
                        isPhoneAvailable = true; // 전화번호 사용 가능 플래그
                    }
                    else {
                        alert("이미 사용중인 전화번호입니다.");
                        isPhoneAvailable = false; // 전화번호 사용 불가 플래그
                        $("#phonemid").focus();
                    }
                }
            });
        });

    });