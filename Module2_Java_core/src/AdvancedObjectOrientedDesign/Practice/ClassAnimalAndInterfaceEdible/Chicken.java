package AdvancedObjectOrientedDesign.Practice.ClassAnimalAndInterfaceEdible;

public class Chicken extends Animal {
    @Override
    String makeSound() {
        return "chip chip";
    }

    @Override
    public String howToEat() {
        return "Could be fried";
    }
}
