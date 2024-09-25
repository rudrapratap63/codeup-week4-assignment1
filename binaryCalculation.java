/*
This Class is used to do all the 4 binaryCalulation for respective base
Owner -> Rudra Pratap Singh
Date -> 25/09/2024
 */
import java.text.DecimalFormat;
public class binaryCalculation {
    static DecimalFormat df = new DecimalFormat("#");
    public static String addition(String firstInput, String secondInput, int base) {
        try {
            double firstNumber = binaryConversions.convertToDecimal(firstInput, base);
            double secondNumber = binaryConversions.convertToDecimal(secondInput, base);
            if (firstNumber == -1 || secondNumber == -1) {
                return "";
            }
            double result = firstNumber + secondNumber;
            if (Double.isInfinite(result)) {
                return Constant.OVERFLOW_OCCURED;
            }
            String decimalResult = df.format(result);
            return decimalResult;
        } catch (ArithmeticException e) {
            return Constant.OVERFLOW_OCCURED;
        }
    }

    public static String subtraction(String firstInput, String secondInput, int base) {
        try {
            double firstNumber = binaryConversions.convertToDecimal(firstInput, base);
            double secondNumber = binaryConversions.convertToDecimal(secondInput, base);
            if (firstNumber == -1 || secondNumber == -1) {
                return "";
            }
            double result = firstNumber - secondNumber;
            if (Double.isInfinite(result)) {
                return Constant.OVERFLOW_OCCURED;
            }
            String decimalResult = df.format(result);
            return decimalResult;
        } catch (ArithmeticException e) {
            return Constant.OVERFLOW_OCCURED;
        }
    }

    public static String multiplication(String firstInput, String secondInput, int base) {
        try {
            double firstNumber = binaryConversions.convertToDecimal(firstInput, base);
            double secondNumber = binaryConversions.convertToDecimal(secondInput, base);
            if (firstNumber == -1 || secondNumber == -1) {
                return "";
            }
            double result = firstNumber * secondNumber;
            if (Double.isInfinite(result)) {
                return Constant.OVERFLOW_OCCURED;
            }
            String decimalResult = df.format(result);
            return decimalResult;
        } catch (ArithmeticException e) {
            return Constant.OVERFLOW_OCCURED;
        }
    }

    public static String division(String firstInput, String secondInput, int base) {
        try {
            double firstNumber = binaryConversions.convertToDecimal(firstInput, base);
            double secondNumber = binaryConversions.convertToDecimal(secondInput, base);
            if (firstNumber == -1 || secondNumber == -1) {
                return "";
            }
            if (secondNumber == 0) {
                System.out.println(Constant.ERROR_DIVISION_BY_ZERO);
                return "";
            }
            double result = firstNumber / secondNumber;
            if (Double.isInfinite(result)) {
                return Constant.OVERFLOW_OCCURED;
            }
            String decimalResult = df.format(result);
            return decimalResult;
        } catch (ArithmeticException e) {
            return Constant.OVERFLOW_OCCURED;
        }
    }
}
