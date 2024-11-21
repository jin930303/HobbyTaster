$(document).ready(function () {
    var isnicknameAvailable = false;
    var isfullphoneAvailable = false;

    // 닉네임 중복 확인
    $("#nncf").click(function () {
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
            success: function (data) {
                if (data == "ok") {
                    alert("사용 가능한 닉네임입니다.");
                    isnicknameAvailable = true;
                } else {
                    alert("이미 사용중인 닉네임입니다.");
                    isnicknameAvailable = false;
                    $("#nickname").focus();
                }
            }
        });
    });
    // 전화번호 중복 확인
    $("#pncf").click(function () {
        var phonemid = $("#phonemid").val();
        var phoneend = $("#phoneend").val();
        var phoneRegex = /^[0-9]{4}$/;
        if (phonemid.trim() === "" || phoneend.trim() === "") {
            alert('전화번호를 입력해주세요.');
            $("#phonemid").focus();
            return;
        }
        if (!phoneRegex.test(phonemid) || !phoneRegex.test(phoneend)) {
            alert('전화번호 형식이 올바르지 않습니다.');
            return;
        }
        var fullphone = "010-" + phonemid + "-" + phoneend;
        $.ajax({
            type: "post",
            url: "phonecheck",
            data: { "fullphone": fullphone },
            async: true,
            success: function (data) {
                if (data == "ok") {
                    alert("사용 가능한 전화번호입니다.");
                    isfullphoneAvailable = true;
                } else {
                    alert("이미 사용중인 전화번호입니다.");
                    isfullphoneAvailable = false;
                    $("#phonemid").focus();
                }
            }
        });
    });

    // 폼 유효성 검사
    window.validateForm = function () {
        if (!isnicknameAvailable) {
            alert("닉네임 중복 확인을 완료해주세요.");
            $("#nickname").focus();
            return false;
        }
        if (!isfullphoneAvailable) {
            alert("전화번호 중복 확인을 완료해주세요.");
            $("#phonemid").focus();
            return false;
        }
        return true;
    };
});