public class Calculator {
    public static double calculate(double first_operand, double second_operand, String operator) {
        double result = 0;
        switch (operator) {
            case "plus":
                result = first_operand + second_operand;
                break;
            case "minus":
                result = first_operand - second_operand;
                break;
            case "multiply":
                result = first_operand * second_operand;
                break;
            case "divide":
                if (second_operand != 0) {
                    result = first_operand / second_operand;
                }
                else {
                    throw new RuntimeException("Can't divide by zero");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
        return result;
    }
}
