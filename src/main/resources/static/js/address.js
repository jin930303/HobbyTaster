function searchAddress() {
    new daum.Postcode({
        oncomplete: function(data) {
            document.getElementById("address").value=data.address;
            document.getElementById("postnum").value=data.zonecode;
            var inputda=document.getElementById("detailaddress");
            inputda.readOnly=false;
        }
    }).open();
}

function cancelAddress() {
    var inputpn=document.getElementById("postnum");
    inputpn.value="";
    var inputad=document.getElementById("address");
    inputad.value="";
    var inputda=document.getElementById("detailaddress");
    inputda.value="";
    inputda.readOnly=true;
}