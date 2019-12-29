let name = prompt("Mời nhập họ và tên khách hàng: ");
let idCard = prompt("Mời nhập số CMND: ");
let birthday = prompt("Mời nhập ngày/tháng/năm sinh: ");
let email = prompt("Mời nhập địa chỉ email: ");
let address = prompt("Mời nhập địa chỉ nhà: ");
let customerType = prompt("Mời nhập loại khách hàng: ");
let discount = prompt("Mời nhập giảm giá: ");
let amount = prompt("Mời nhập số lượng đi kèm: ");
let rentDay = parseInt(prompt("Mời nhập số ngày thuê: "));
let service = prompt("Mời nhập loại dịch vụ: ");
let roomLevel = prompt("Mời nhập loại phòng: ");
let total = 500 * rentDay * (1 - parseFloat(discount) /100);

alert(
    "THÔNG TIN KHÁCH HÀNG\n" +
    "Tên: " + name +
    "\nSố CMND: " + idCard +
    "\nNgày/tháng/năm sinh: " + birthday +
    "\nEmail: " + email +
    "\nĐịa chỉ: " + address +
    "\nLoại khách hàng: " + customerType +
    "\nGiảm giá: " + discount +
    "\nSố lượng đi kèm: " + amount +
    "\nSố ngày thuê: " + rentDay +
    "\nLoại dịch vụ: " + service +
    "\nLoại phòng: " + roomLevel +
    "\nTổng tiền: " + total
)