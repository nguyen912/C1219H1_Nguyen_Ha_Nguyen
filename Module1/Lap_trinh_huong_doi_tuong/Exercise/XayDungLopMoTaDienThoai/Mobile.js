let name1 = document.getElementById("name1");
let name2 = document.getElementById("name2");
let pst1 = document.getElementById("pin1");
let pst2 = document.getElementById("pin2");
let mst1 = document.getElementsByName("mst1");
let mst2 = document.getElementsByName("mst2");
let mstn1 = document.getElementById("mstn1");
let mbox1 = document.getElementById("box1");
let result = document.getElementById("result");
class Mobile {
    constructor(name,pin) {
        this.name = name;
        this.pin = 100;
        this.draftMessenger = [];
        this.receivedMessenger = [];
        this.sentMessenger = [];
    }
    getName() {
        return this.name;
    }
    getPin() {
        return this.pin;
    }
    getDraftMessenger() {
        return this.draftMessenger;
    }
    getReceiveMessenger() {
        return this.receivedMessenger;
    }
    getSentMessenger() {
        return this.sentMessenger;
    }
    setName(newName) {
        this.name = name;
    }
    setPin(newPin) {
        this.pin = newPin;
    }
    setDraftMessenger(newDraftMessenger) {
        this.draftMessenger = newDraftMessenger;
    }
    setReceivedMessenger(newReceivedMessenger) {
        this.receivedMessenger = newReceivedMessenger;
    }
    setSentMessenger(newSentMessenger) {
        this.sentMessenger = newSentMessenger;
    }
    checkPinStatus() {
        if (this.getPin() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    checkPhoneStatus(mst) {
        for (let i = 0; i < 2; i++) {
            if (mst[i].checked === "On") {
                return true;
            }
        }
    }
    switchPhone() {
        this.setPin(this.getPin()-1);
        !this.checkPhoneStatus();
    }
    chargePin() {

    }
    typeMessenger() {
        this.setPin(this.getPin()-1);
        return result.innerText = "Draft Messenger: " + mbox1.value;
    }
    receiveMessenger() {

    }
    sendMessenger() {

    }
    viewReceivedMessenger() {

    }
    viewSentMessenger() {

    }
}
let phone1 = new Mobile("NOKIA",);
name1.innerText = phone1.getName();
pst1.innerText = phone1.getPin();
if (phone1.checkPhoneStatus(mst1) === true) {

}
else {
    phone1.switchPhone();
}
let phone2 = new Mobile("IPHONE",);
name2.innerText = phone2.getName();
pst2.innerText = phone2.getPin();