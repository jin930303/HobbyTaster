function toggleCustomDomain(select) {
    const customDomainInput = document.getElementById("customDomain");
    if (select.value === "custom") {
        customDomainInput.style.display = "inline";
        customDomainInput.focus();
        customDomainInput.oninput = () => {
            select.value = customDomainInput.value;
        };
    } else {
        customDomainInput.style.display = "none";
        customDomainInput.value = ""; // 초기화
    }
}