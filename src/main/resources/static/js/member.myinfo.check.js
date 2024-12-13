$(document).ready(function () {
    var isnicknameAvailable = false;

    // 닉네임 중복 확인
    $("[id^='nncf']").click(function () {
        var nickname = $(this).prev('input').val(); // 버튼 앞의 input 값을 가져옵니다.
        if (nickname.trim() === "") {
            alert('닉네임을 입력해주세요');
            $(this).prev('input').focus();  // nickname input을 포커스
            return;
        }
        var nicknameId = $(this).attr('id').split('_')[1];  // 고유 id 추출
        $.ajax({
            type: "post",
            url: "/nicknamecheck", // 경로 수정
            data: { "nickname": nickname },
            async: true,
            success: function (data) {
                if (data == "ok") {
                    alert("사용 가능한 닉네임입니다.");
                    isnicknameAvailable = true;
                } else {
                    alert("이미 사용중인 닉네임입니다.");
                    isnicknameAvailable = false;
                    $("#" + nicknameId).focus();  // nickname input을 포커스
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
        return true;
    };
});