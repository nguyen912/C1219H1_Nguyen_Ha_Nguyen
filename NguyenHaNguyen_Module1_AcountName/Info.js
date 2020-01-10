let name = "Nguyen Ha Nguyen";
let idCard = "123456789";
let birth = "09/12/1998";
let email = "nguyen@gmail.com";
let add = "123 PCT Đà Nẵng";
let customer = "Gold";
let discount = "10";
let guests = "2";
let rentDay = "2";
let service = "House";
let room = "Normal";
let checkValidate = false;

let option = prompt(
    "1. Show customer information.\n" +
    "2. Edit customer information.\n" +
    "3. Show the amount to be paid after discount.");

switch (option) {
    case "1":
        alert(
            "CUSTOMER INFORMATION\n" +
            "Name: " + name + "\n" +
            "ID card: " + idCard + "\n" +
            "Birthday: " + birth + "\n" +
            "Email: " + email + "\n" +
            "Address: " + add + "\n" +
            "Customer type: " + customer + "\n" +
            "Discount: " + discount + "\n" +
            "The number of guests: " + guests + "\n" +
            "The number of days rented: " + rentDay + "\n" +
            "Service type: " + service + "\n" +
            "Room type: " + room
        );
        break;

    case "2":
        let chooseEdit = prompt(
            "Choose Customer Information You Want To Edit\n" +
            "1. Name: " + name + "\n" +
            "2. ID card: " + idCard + "\n" +
            "3. Birthday: " + birth + "\n" +
            "4. Email: " + email + "\n" +
            "5. Address: " + add + "\n" +
            "6. Customer type: " + customer + "\n" +
            "7. Discount: " + discount + "\n" +
            "8. The number of guests: " + guests + "\n" +
            "9. The number of days rented: " + rentDay + "\n" +
            "10. Service type: " + service + "\n" +
            "11. Room type: " + room);
        switch (chooseEdit) {
            case "1":
                name = prompt("Enter name you want to edit: ");
                break;
            case "2":
                do {
                    checkValidate = true;
                    idCard = parseInt(prompt("Enter ID you want to edit: "));
                    if (isNaN(idCard)) {
                        continue;
                    }
                    idCard = Number.parseFloat(idCard);
                    if (!Number.isInteger(idCard)) {
                        continue;
                    }
                    if (idCard >= 100000000 && idCard <= 999999999) {
                        checkValidate = true;
                    }
                while (!checkValidate);
                }
                break;
            case "3":
                do {
                    checkValidate = false;
                    birth = prompt("Enter birthday you want to edit: ");
                    if (birth.charAt(2)!=='/' || birth.charAt(5)!=='/') {
                        alert("Vui long thu lai");
                        continue;
                    }
                    let day = birth.substring(0,2);
                    let month = birth.substring(3,5);
                    let year = birth.substring(6,10);
                    if (!isNaN(day) && !isNaN(month) && !isNaN(year)) {
                        day = Number.parseFloat(day);
                        month = Number.parseFloat(month);
                        year = Number.parseFloat(year);
                        if (Number.isInteger(day) && Number.isInteger(month) && Number.isInteger(year)) {
                            if (day > 0 && day < 32 && month <13 && month > 0 && year >= 1960 & year <= 2019) {
                                checkValidate = true;
                            }
                        }
                    }
                    if (checkValidate) {
                        alert("Vui long nhap lai");
                    }
                }
                while (!checkValidate);
                break;
            case "4":
                do {
                    alert("Địa chỉ email phải đúng theo định dạng abc@abc.abc");
                    email = prompt("Enter email you want to edit: ");
                }
                while ((email.indexOf("@") == -1 || email.indexOf(".") == -1) ||
                        email.indexOf("@") > email.indexOf("."));
                break;
            case "5":
                add = prompt("Enter address you want to edit: ");
                break;
            case "6":
                customer = prompt("Enter customer type you want to edit: ");
                break;
            case "7":
                do {
                    checkValidate = false;
                    discount = prompt("Enter discount you want to edit: ");
                    if (!isNaN(discount)) {
                        discount = Number.parseFloat(discount);
                        if (discount >= 0) {
                            checkValidate = true;
                        }
                    }
                    if (!checkValidate) {
                        alert("Vui long thu lai");
                    }
                }
                while (!checkValidate);
                break;
            case "8":
                do {
                checkValidate = false;
                guests = prompt("Enter the number of guests you want to edit: ");
                if (!isNaN(guests)) {
                    guests = Number.parseFloat(guests);
                    if (guests >= 0 && Number.isInteger(guests)) {
                        checkValidate = true;
                    }
                }
                if (!checkValidate) {
                    alert("Vui long nhap lai");
                }
            }
            while (!checkValidate);

                break;
            case "9":
                do {
                    checkValidate = false;
                    rentDay = prompt("Enter the number of days rented you want to edit: ");
                    if (!isNaN(rentDay)) {
                        rentDay = Number.parseFloat(rentDay);
                        if (rentDay >= 0 && Number.isInteger(rentDay)) {
                            checkValidate = true;
                        }
                    }
                    if (!checkValidate) {
                        alert("Vui long nhap lai");
                    }
                }
                while (!checkValidate);
                break;
            case "10":
                service = prompt("Enter name you want to edit: ");
                break;
            case "11":
                room = prompt("Enter name you want to edit: ");
            default:
                alert("Failed");

        }
        alert(
            "CUSTOMER INFORMATION AFTER EDITING\n" +
            "Name: " + name + "\n" +
            "ID card: " + idCard + "\n" +
            "Birthday: " + birth + "\n" +
            "Email: " + email + "\n" +
            "Address: " + add + "\n" +
            "Customer type: " + customer + "\n" +
            "Discount: " + discount + "\n" +
            "The number of guests: " + guests + "\n" +
            "The number of days rented: " + rentDay + "\n" +
            "Service type: " + service + "\n" +
            "Room type: " + room
        );
        break;

    case "3":
        pay();
}

function pay() {
    let serviceVal;
    switch (service) {
        case "Villa": serviceVal = 500;
            break;
        case "House": serviceVal = 300;
            break;
        case "Room": serviceVal = 100;
    }

    let total = serviceVal*parseInt(rentDay)*(1-parseInt(discount)/100);

    if (add.search("Đà Nẵng") != -1) {
        total -= 20;
    }
    if (add.search("Huế") != -1) {
        total -= 10;
    }
    if (add.search("Quảng Nam") != -1) {
        total -= 5;
    }

    if (rentDay >= 7) {
        total -= 30;
    }
    if (rentDay >= 5 && rentDay < 7) {
        total -= 20;
    }
    if (rentDay >= 2 && rentDay <= 4) {
        total -= 10;
    }

    switch (customer) {
        case "Diamond":
            total -= 15;
            break;
        case "Platinum":
            total -= 10;
            break;
        case "Gold":
            total -= 5;
            break;
        case "Sliver":
            total -= 2;
    }

    let currentYear = new Date().getFullYear();
    let birthYear = new Date(birth).getFullYear();
    let age = currentYear - birthYear;

    if (age > 30 && add.search("Đà Nẵng") != -1) {
        total -= 2;
    }
    if (age >= 20 && age <= 30 && add.search("Đà Nẵng") != -1) {
        total -= 1;
    }

    alert("Total: " + total + "$");
}