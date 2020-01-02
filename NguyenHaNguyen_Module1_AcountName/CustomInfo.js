let name = document.getElementById("name");
let idCard = document.getElementById("idCard");
let birth = document.getElementById("birth");
let email = document.getElementById("email");
let add = document.getElementById("add");
let custom = document.getElementById("cusType");
let discount = document.getElementById("dis");
let nog = document.getElementById("nog");
let nor = document.getElementById("nor");
let service = document.getElementById("service");
let room = document.getElementById("room");

let outName = document.getElementById("outName");
let outID = document.getElementById("outID");
let outBirth = document.getElementById("outBirth");
let outEmail = document.getElementById("outEmail");
let outAdd = document.getElementById("outAdd");
let outCus = document.getElementById("outCus");
let outDis = document.getElementById("outDis");
let outNog = document.getElementById("outNog");
let outNor = document.getElementById("outNor");
let outService = document.getElementById("outService");
let outRoom = document.getElementById("outRoom");

function inputInfo() {
    outName.innerText = "Name: " + name.value;
    outID.innerText = "ID: " + idCard.value;
    outBirth.innerText = "Birthday: " + birth.value;
    outEmail.innerText = "Email: " + email.value;
    outAdd.innerText = "Address: " + add.value;
    outCus.innerText = "Customer type: " + custom.value;
    outDis.innerText = "Discount: " + discount.value + "%";
    outNog.innerText = "Number of guests: " + nog.value;
    outNor.innerText = "Number of days rented: " + nor.value;
    outService.innerText = "Service: " + service.value;
    outRoom.innerText = "Room type: " + room.value;
    pay();
}

let outTotal = document.getElementById("outTotal");
let total;
function pay() {
    let serviceVal;
    switch (service.value) {
        case "Villa": serviceVal = 500;
        case "House": serviceVal = 300;
        case "Room": serviceVal = 100;
    }
    total = serviceVal*parseInt(nor.value)*(1-parseInt(discount.value)/100);
    outTotal.innerText = "Total: " + total + "$";
}
// Số tiền phải trả  = giá loại dịch vụ X số ngày X ( 1 – giảm giá/100 )
// Bảng giá:
//     -	Villa 500$/ 1 ngày
// -	House 300$/1 ngày
// -	Room: 100$/1 ngày
