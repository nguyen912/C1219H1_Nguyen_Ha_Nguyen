let MyDate = function(day,month,year) {
    this.day = day;
    this.month = month;
    this.year = year;
    this.getDay = function() {
        return this.day;
    }
    this.getMonth = function() {
        return this.month;
    }
    this.getYear = function() {
        return this.year;
    }
    this.setDay = function(day) {
        this.day  = day;
    }
    this.setMonth = function(month) {
        this.month  = month;
    }
    this.setYear = function(year) {
        this.year = year;
    }
    this.setDate = function (day,month,year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    this.toString = function (day,month,year) {
        return this.day + '/' + this.month + '/' + this.year;
    }
};

let date = new MyDate(13,1,2020);
let day = date.getDay();
let month = date.getMonth();
let year = date.getYear();
alert(day + "/" + month + "/" + year);

date.setDay(10);
date.setMonth(10);
date.setYear(2019);

let day1 = date.getDay();
let month1 = date.getMonth();
let year1 = date.getYear();
alert(day1 + "/" + month1 + "/" + year1);

date.setDate(9,12,1998);
let day2 = date.getDay();
let month2 = date.getMonth();
let year2 = date.getYear();

let date1 = date.toString(day2,month2,year2);
alert(date1);
