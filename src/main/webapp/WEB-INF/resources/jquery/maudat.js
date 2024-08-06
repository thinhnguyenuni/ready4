jQuery(function () {
	$('.select2').select2();
    $("button[type='reset']").on("click", function () {
    $("span[id*='errors']").text("");
    $("div[class*='error']").text("");
    $(this).closest("form").find("input").removeAttr("value");
  });
  const id = $("#inputID");
  const number = $("#inputNumber");
  const chuSoHuu = $("#inputMaChuSoHuu");
  const maDoThi = $("#inputMaDoThi");
  const price = $("#inputPrice");
  const width = $("#inputWidth");
  const length = $("#inputLength");
  const errorID = $("#errorID");
  const errorNumber = $("#errorNumber");
  const errorWidth = $("#errorWidth");
  const errorLength = $("#errorLength");
  const errorChuSoHuu = $("#errorMaChuSoHuu");
  const errorMaDoThi = $("#errorMaDoThi");
  const errorPrice = $("#errorPrice");
  const idRegEx = /^MD\d{3}$/;
  const maChuSoHuuRegEx = /^KH\d{3}$/;
  const maDoThiRegEx = /^KDT\d{2}$/;
   const numberRegEx = /^[1-9]\d*$/;
 /* const phoneRegEx = /^(090|091|\(84\)\+90|\(84\)\+91)\d{7}$/;
  const emailRegEx = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;*/
   $("#inputForm").on("submit", function (e) {
    e.preventDefault();
    if (
      !validateID(id) |
      !validateNumber(number) |
      !validateChuSoHuu(chuSoHuu) |
      !validateMaDoThi(maDoThi)	|
      !validatePrice(price)|
      !validateWidth(width)	|
      !validateLength(length)
    ) {
      return;
    }
    this.submit();
  });
 function validateID(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorID.text("Trường không được để trống");
      return false;
    }
    if (!idRegEx.test(value)) {
      errorID.text("Nhập không đúng định dạng (MDxxx)");
      return false;
    }
    errorID.text("");
    return true;
  }
   function validateChuSoHuu(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorChuSoHuu.text("Trường không được để trống");
      return false;
    }
    if (!maChuSoHuuRegEx.test(value)) {
      errorChuSoHuu.text("Nhập không đúng định dạng (KHxxx)");
      return false;
    }
    errorChuSoHuu.text("");
    return true;
  }
  function validateMaDoThi(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorMaDoThi.text("Trường không được để trống");
      return false;
    }
    if (!maDoThiRegEx.test(value)) {
      errorMaDoThi.text("Nhập không đúng định dạng (KDTxx)");
      return false;
    }
    errorMaDoThi.text("");
    return true;
  }
 function validatePrice(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorPrice.text("Trường không được để trống");
      return false;
    }
     if (!numberRegEx.test(value)) {
      errorPrice.text("Giá gốc phải là số nguyên dương");
      return false;
    }
    errorPrice.text("");
    return true;
  }
   function validateWidth(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorWidth.text("Trường không được để trống");
      return false;
    }
     if (!numberRegEx.test(value)) {
      errorWidth.text("Chiều rộng phải là số nguyên dương");
      return false;
    }
    errorWidth.text("");
    return true;
  }
    function validateLength(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorLength.text("Trường không được để trống");
      return false;
    }
     if (!numberRegEx.test(value)) {
      errorLength.text("Chiều dài phải là số nguyên dương");
      return false;
    }
    errorLength.text("");
    return true;
  }
   function validateNumber(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorNumber.text("Trường không được để trống");
      return false;
    }
     if (!numberRegEx.test(value)) {
      errorNumber.text("Số mẫu đất phải là số nguyên dương");
      return false;
    }
    errorNumber.text("");
    return true;
  }
  function validateName(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorName.text("Trường không được để trống");
      return false;
    }
    errorName.text("");
    return true;
  }
  function validateDate(selector) {
    const value = selector.val().trim();
    if (value == "") {
      errorDate.text("Trường không được để trống");
      return false;
    }
   const inputDate = new Date(selector.val().trim());
   const currentDate = new Date();
   currentDate.setHours(7, 0, 0, 0);
   if (currentDate<inputDate) {
	  errorDate.text("Ngày không được lớn hơn ngày hiện tại");
      return false;
      }
    errorDate.text("");
    return true;
  }
   
});