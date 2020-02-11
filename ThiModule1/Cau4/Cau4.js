function Students(index,name,birthday,avgScore) {
    this.index = index;
    this.name = name;
    this.birthday = birthday;
    this.avgScore = avgScore;
    this.getStudentLevel = function () {
        if (this.avgScore > 8) {
            return "Gioi";
        }
        else if (this.avgScore >= 6.5) {
            return "Kha";
        }
        else if (this.avgScore >=5) {
            return "Trung binh";
        }
        else if (this.avgScore >= 3.5) {
            return "Yeu";
        }
        else {
            return "Kem";
        }
    }
}
let nguyen = new Students("01","Nguyen Ha Nguyen","09/12/98",8.1);
document.write(nguyen.index + "||" + nguyen.name + "||" + nguyen.birthday + "||"
    + nguyen.avgScore + "||" + nguyen.getStudentLevel() + "<br>");
let ha = new Students("02","Nguyen Ngoc Ha","09/03/98",4);
document.write(ha.index + "||" + ha.name + "||" + ha.birthday + "||"
    + ha.avgScore + "||" + ha.getStudentLevel() + "<br>");