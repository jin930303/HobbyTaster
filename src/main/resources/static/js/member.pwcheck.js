let passwordChecked = false;  // 비밀번호 확인 상태를 추적하는 변수

// 비밀번호의 유효성 검사 함수
function checkPasswordValidity(password) {
    const passwordPattern = /^(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*])[a-z\d!@#$%^&*]{8,16}$/;
    return passwordPattern.test(password);  // 8~16자, 소문자, 숫자, 특수문자 포함 여부
}

function checkPasswordMatch() {
    const pw = document.getElementById("pw").value;
    const pwcf = document.getElementById("pwcf").value;
    const pwError = document.getElementById("pwError");
    const pwcfError = document.getElementById("pwcfError");

    // 비밀번호 유효성 체크
    if (!checkPasswordValidity(pw)) {
        pwError.textContent = "비밀번호는 8~16자, 소문자, 숫자, 특수문자를 포함해야 합니다.";
        passwordChecked = false;  // 비밀번호 확인이 안 됨
        document.getElementById("submitBtn").disabled = true;  // 회원가입 버튼 비활성화
        return false;  // 비밀번호가 유효하지 않으면 진행 중단
    } else {
        pwError.textContent = "";  // 유효성 오류 메시지 초기화
    }

    // 비밀번호 확인이 일치하는지 체크
    if (pw !== pwcf) {
        pwcfError.textContent = "비밀번호가 일치하지 않습니다.";
        passwordChecked = false;  // 비밀번호 확인이 안 됨
        document.getElementById("submitBtn").disabled = true;  // 회원가입 버튼 비활성화
        return false;  // 비밀번호 일치하지 않으면 진행 중단
    } else {
        pwcfError.textContent = "비밀번호가 일치합니다.";
        passwordChecked = true;  // 비밀번호 확인이 됨
        document.getElementById("submitBtn").disabled = false;  // 회원가입 버튼 활성화
    }

    return true;
}

function validateForm() {
    if (!passwordChecked) {
        alert("비밀번호를 확인해주세요.");
        return false;  // 비밀번호가 일치하지 않으면 폼 제출을 막음
    }

    return true;  // 비밀번호가 일치하면 폼 제출 허용
}