let result = document.getElementById("result1");
let status = document.getElementsByName("status1");
let draftMessenger = document.getElementById("draft");
let sentMessenger = document.getElementById("sent");
let receivedMessenger = document.getElementById("receive");
let messenger = document.getElementById("mess");
let Mobile = function (pin,draftMessenger,receivedMessenger,sentMessenger,status) {
    this.draftMessenger = new Array();
    this.receivedMessenger = new Array();
    this.sentMessenger = new Array();

    this.getPin = function () {
        return this.pin;
    }
    this.getDraftMessenger = function () {
        return this.draftMessenger;
    }
    this.getReceivedMessenger = function () {
        return this.receivedMessenger;
    }
    this.getSentMessenger = function () {
        return this.sentMessenger;
    }
    this.getStatus = function () {
        return this.status;
    }

    this.setPin = function (pin) {
        this.pin = pin;
    }
    this.setDraftMessenger = function (draftMessenger) {
        this.draftMessenger = draftMessenger;
    }
    this.setReceivedMessenger = function (receivedMessenger) {
        this.receivedMessenger = receivedMessenger;
    }
    this.setSentMessenger = function (sentMessenger) {
        this.sentMessenger = sentMessenger;
    }
    this.setStatus = function (status) {
        this.status = status;
    }

    this.checkStatus = function () {
        if (this.status == true) {
            return result.innerText = "The phone is on.";
        }
        else {
            return result.innerText = "The phone is off.";
        }
    }

    // this.changeStatus = function () {
    //     if (status1.value[0] === "on") {
    //         this.setStatus(true);
    //     }
    //     else if (status1.value[1] === "off"){
    //         this.setStatus(false);
    //     }
    // }

    this.chargePin = function () {
        let percent = new Array();
        for (let i = 0; i <= 100; i++) {
            percent.push(i);
        }
        result.innerText = percent.join(".");
    }

    this.writingMessenger = function () {
        this.draftMessenger.innerText = messenger.value;
    }

    this.receiveMessenger = function () {

    }
    this.sendMessenger = function () {

    }

    this.viewReceivedMessenger = function () {

    }

    this.viewSentMessenger = function () {

    }

}
let phone1 = new Mobile();
result.innerText = phone1.checkStatus();
