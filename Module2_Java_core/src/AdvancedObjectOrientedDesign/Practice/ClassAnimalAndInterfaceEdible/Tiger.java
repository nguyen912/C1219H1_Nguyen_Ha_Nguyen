package AdvancedObjectOrientedDesign.Practice.ClassAnimalAndInterfaceEdible;

public class Tiger extends Animal {
    @Override
    String makeSound() {
        return "gaooooooooooo";
    }

    @Override
    public String howToEat() {
        return "Can't eat!";
    }
}
