//let roomType = document.getElementById("roomType").value;
//let result = document.getElementById("result")
function getInfo() {
  let result;
  let name = document.getElementById("name");
  let idCard = document.getElementById("idCard");
  let birthday = document.getElementById("birthday");
  let email = document.getElementById("email");
  let address = document.getElementById("address");
  let customerType = document.getElementById("customerType");
  let discount = parseInt(document.getElementById("discount")).value;
  let amount = document.getElementById("amount");
  let rentDay = document.getElementById("rentDay").value;
  let service = document.getElementById("service").value;
  let roomLevel = document.getElementById("roomLevel");

  let total = document.getElementById("total");
  let r_name = document.getElementById("r_name");
  let r_id = document.getElementById("r_id");
  let r_birthday = document.getElementById("r_birth");
  let r_email = document.getElementById("r_email");
  let r_add = document.getElementById("r_add");
  let r_cusType = document.getElementById("r_cusType");
  let r_discount = document.getElementById("r_discount");
  let r_amount = document.getElementById("r_amount");
  let r_rentDay = document.getElementById("r_rentDay");
  let r_service = document.getElementById("r_service");
  let r_room = document.getElementById("r_room");

  r_name.innerText = name.value;
  r_id.innerText = idCard.value;
  r_birthday.innerText = birthday.value;
  r_email.innerText = email.value;
  r_add.innerText = address.value;
  r_cusType.innerText = customerType.value;
  r_discount.innerText = discount.value;
  r_amount.innerText = amount.value;
  r_rentDay.innerText = rentDay.value;
  r_service.innerText = service.value;
  r_room.innerText = roomLevel.value;

  switch (service) {
    case "villa": result = 500;
    break;
    case "house": result = 300;
    break;
    case "room": result = 100;
    break;
    default:
      break;
  }

  total = result*rentDay*(1-discount/100);
}
// // -	Villa 500$/ 1 ngày
// // -	House 300$/1 ngày
// // -	Room: 100$/1 ngày
// <!--tên, số CMND, ngày tháng năm sinh, email, địa chỉ, loại Customer (Diamond, Platinum, Gold,
// Silver, Member), giảm giá,-->
// <!--số lượng đi kèm, số ngày thuê, loại dịch vụ (Villa, House, Room), loại phòng thuê
// (Vip, Business,  Normal).-->
