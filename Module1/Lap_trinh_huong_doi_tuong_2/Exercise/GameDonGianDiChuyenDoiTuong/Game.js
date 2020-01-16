function Hero(image, top, left, size,speed){
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;
    this.speed = speed;
    this.getHeroElement = function(){
        return '<img width="'+ this.size + '"' +
            ' height="'+ this.size + '"' +
            ' src="' + this.image +'"' +
            ' style="top: '+this.top+'px; left:'+this.left+'px;position:absolute;" />';
    }

    this.moveRight = function(){
        this.left += this.speed;
        console.log('ok: ' + this.left);
    }
    this.moveLeft = function () {
        this.left -= this.speed;
        console.log('ok: ' + this.left);
    }
    this.moveTop = function(){
        this.top -= this.speed;
        console.log('ok: ' + this.top);
    }
    this.moveDown = function(){
        this.top += this.speed;
        console.log('ok: ' + this.top);
    }

}

let hero = new Hero('pikachu.png', 20, 30, 200, 200);
let up = false;
let down = false;
let right = true;
let left = false;
function start(){
    if (right) {
        hero.moveRight();
        if (hero.left >= window.innerWidth - hero.size){
            right = false;
            down = true;
        }
    }
    if (left) {
        hero.moveLeft();
        if (hero.left < 0) {
            left = false;
            up = true;
        }
    }
    if (up) {
        hero.moveTop();
        if (hero.top < 0){
            up = false;
            right = true;
        }
    }
    if (down) {
        hero.moveDown();
        if (hero.top >= window.innerHeight - hero.size){
            down = false;
            left = true;
        }
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 500)
}

start();