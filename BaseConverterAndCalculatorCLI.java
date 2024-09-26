/*
This Class is used to do operation of conversion and calculations using cli
Owner -> Rudra Pratap Singh
Date -> 25/09/2024
*/
import java.text.DecimalFormat;
import java.util.Scanner;
public class BaseConverterAndCalculatorCLI {
    static DecimalFormat decimalFormat = new DecimalFormat("#.######");
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(Constant.CLI_WELCOME);
        System.out.println(Constant.CLI_USAGE_FOR_CONVERSION);
        System.out.println(Constant.CLI_USAGE_FOR_CALCULATION);
        System.out.println(Constant.CLI_EXAMPLE);
        System.out.println(Constant.CLI_ADD_EXAMPLE);
        System.out.println(Constant.CLI_SUBTRACT_EXAMPLE);
        System.out.println(Constant.CLI_MULTIPLY_EXAMPLE);
        System.out.println(Constant.CLI_DIVIDE_EXAMPLE);
        while (true) {
            System.out.print("\nEnter your command: ");
            String cliInput = input.nextLine().trim();
            if (cliInput.equalsIgnoreCase("exit")) {
                System.out.println(Constant.CLI_EXIT_MESSAGE);
                break;
            }
            try {
                String[] inputParts = cliInput.split("\\s+");
                if (inputParts.length == 5 && inputParts[0].equalsIgnoreCase("convert") && inputParts[3].equalsIgnoreCase("to")) {
                    handleConversion(inputParts);
                }
                else if (inputParts.length == 7 && (inputParts[0].equalsIgnoreCase("add") || 
                                                     inputParts[0].equalsIgnoreCase("subtract") || 
                                                     inputParts[0].equalsIgnoreCase("multiply") || 
                                                     inputParts[0].equalsIgnoreCase("divide"))) {
                    handleBaseSpecificArithmetic(inputParts);
                }
                else if (inputParts.length == 6 && (inputParts[0].equalsIgnoreCase("add") || 
                                                     inputParts[0].equalsIgnoreCase("subtract") || 
                                                     inputParts[0].equalsIgnoreCase("multiply") || 
                                                     inputParts[0].equalsIgnoreCase("divide"))) {
                handleArithmetic(inputParts);
                } else {
                    System.out.println(Constant.INVALID_COMMAND_FORMAT);
                    System.out.println(Constant.CLI_USAGE_FOR_CONVERSION);
                    System.out.println(Constant.CLI_USAGE_FOR_CALCULATION);
                }
            } catch (Exception exception) {
                System.out.println(Constant.UNEXPECTED_ERROR + exception.getMessage());
            }
        }
        input.close();
    }

    // Handle the 'convert' command and make conversion
    // Input - String Array
    private static void handleConversion(String[] inputParts) {
        int inputBase = Integer.parseInt(inputParts[1]);  
        String number = inputParts[2].toUpperCase();      
        String outputBaseStr = inputParts[4];             
        int outputBase;
        try {
            outputBase = Integer.parseInt(outputBaseStr);
        } catch (NumberFormatException e) {
            outputBase = getBaseFromString(outputBaseStr);
        }
        if (inputBase < 2 || inputBase > 36 || outputBase < 2 || outputBase > 36) {
            System.out.println(Constant.INVALID_BASE_RANGE);
            return;
        }
        double decimalResult = binaryConversions.convertToDecimal(number, inputBase);
        if (decimalResult == -1) {
            System.out.println(Constant.CONVERSION_TO_DECIMAL_FAILED);
            return;
        }
        String outputResult = binaryConversions.convertFromDecimal(decimalFormat.format(decimalResult), outputBase);
        if (outputResult.equals("")) {
            System.out.println(Constant.CONVERSION_FROM_DECIMAL_FAILED);
            return;
        }
        System.out.println("Result in Decimal: " + decimalResult);
        System.out.println("Result in base " + outputBase + ": " + outputResult);
    }
    
    // Handle the 'add' or 'divide' command for direct base 2 or base 16 
    // Input - String Array
    private static void handleBaseSpecificArithmetic(String[] inputParts) {
        String operation = inputParts[0];
        int base1 = Integer.parseInt(inputParts[1]);
        String num1 = inputParts[2];
        String num2 = inputParts[5];
        if (!inputParts[4].equalsIgnoreCase("to")) {
            System.out.println(Constant.INVALID_COMMAND_FORMAT);
            return;
        }
        performOperation(operation, base1, num1, base1, num2);
    }

    // Handle operations like 'add binary 1101 to binary 1100' or 'divide hexadecimal 1A to binary 1011'
    // Input - String Array
    private static void handleArithmetic(String[] inputParts) {
        String operation = inputParts[0];
        String base1Str = inputParts[1];
        String num1 = inputParts[2].toUpperCase();
        String base2Str = inputParts[4];
        String num2 = inputParts[5].toUpperCase();
        if (!inputParts[3].equalsIgnoreCase("to")) {
            System.out.println(Constant.INVALID_COMMAND_FORMAT);
            return;
        }
        int base1 = getBaseFromString(base1Str);
        int base2 = getBaseFromString(base2Str);
        if (base1 == -1) {
            try {
                base1 = Integer.parseInt(base1Str);
            } catch (NumberFormatException e) {
                System.out.println(Constant.INVALID_COMMAND_FORMAT);
                return;
            }
        }
        if (base2 == -1) {
            try {
                base2 = Integer.parseInt(base2Str);
            } catch (NumberFormatException e) {
                System.out.println(Constant.INVALID_COMMAND_FORMAT);
                return;
            }
        }
        performOperation(operation, base1, num1, base2, num2);
    }

    // Get the base from the string representation (binary, hexadecimal, etc.)
    // Input - Integer
    // Return - String
    private static int getBaseFromString(String baseString) {
        switch (baseString.toLowerCase()) {
            case "binary":
                return 2;
            case "octal":
                return 8;
            case "decimal":
                return 10;
            case "hexadecimal":
                return 16;
            default:
                return -1; 
        }
    }

    // Perform the arithmetic operation
    // Input - String, Integer
    private static void performOperation(String operation, int base1, String num1, int base2, String num2) {
        double decimalNum1 = binaryConversions.convertToDecimal(num1, base1);
        double decimalNum2 = binaryConversions.convertToDecimal(num2, base2);
        if (decimalNum1 == -1 || decimalNum2 == -1) {
            System.out.println(Constant.CONVERSION_TO_DECIMAL_FAILED);
            return;
        }
        double result = 0;
        switch (operation.toLowerCase()) { 
            case "add":
                result = decimalNum1 + decimalNum2;
                break;
            case "subtract":
                result = decimalNum1 - decimalNum2;
                break;
            case "multiply":
                result = decimalNum1 * decimalNum2;
                break;
            case "divide":
                if (decimalNum2 == 0) {
                    System.out.println(Constant.ERROR_DIVISION_BY_ZERO);
                    return;
                }
                result = decimalNum1 / decimalNum2;
                break;
            default:
                System.out.println(Constant.INVALID_OPERATOR_FORMAT);
                return;
        }
        String outputResultBase1 = binaryConversions.convertFromDecimal(decimalFormat.format(result), base1);
        String outputResultBase2 = binaryConversions.convertFromDecimal(decimalFormat.format(result), base2);
        if (outputResultBase1.equals("") || outputResultBase2.equals("")) {
            System.out.println(Constant.CONVERSION_FROM_DECIMAL_FAILED);
            return;
        }
        String resulString = decimalFormat.format(result);
        if (base1 == base2) {
            if (base1 == 10) {
                System.out.println("Result in Decimal: " + resulString);
            } else {
                System.out.println("Result in base " + base1 + ": " + outputResultBase1);
            }
        } else {
            System.out.println("Result in Decimal: " + resulString);
            System.out.println("Result in base " + base1 + ": " + outputResultBase1);
            System.out.println("Result in base " + base2 + ": " + outputResultBase2);
        }
    }
}
