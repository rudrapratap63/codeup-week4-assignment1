/*
This Class is used to do operation of conversion and calculations using cli
Owner -> Rudra Pratap Singh
Date -> 25/09/2024
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class BaseConverterAndCalculatorCLI {
    static DecimalFormat decimalFormat = new DecimalFormat("#"); 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(Constant.CLI_WELCOME);
        System.out.println(Constant.CLI_USAGE);
        System.out.println(Constant.CLI_EXAMPLE);
        while (true) {
            System.out.print("\nEnter your command: ");
            String cliInput = input.nextLine().trim();
            if (cliInput.equalsIgnoreCase("exit")) {
                System.out.println(Constant.CLI_EXIT_MESSAGE);
                break;
            }
            try {
                String[] inputParts = cliInput.split("\\s+");
                if (inputParts.length != 5 || !inputParts[0].equalsIgnoreCase("convert") || !inputParts[3].equalsIgnoreCase("to")) {
                    System.out.println(Constant.INVALID_COMMAND_FORMAT);
                    System.out.println(Constant.CLI_USAGE);                 
                    continue;
                }
                int inputBase = Integer.parseInt(inputParts[1]);
                String number = inputParts[2];
                number = number.toUpperCase();
                int outputBase = Integer.parseInt(inputParts[4]);
                if (inputBase < 2 || inputBase > 36 || outputBase < 2 || outputBase > 36) {
                    System.out.println(Constant.INVALID_BASE_RANGE);        
                    continue;
                }
                double decimalResult = binaryConversions.convertToDecimal(number, inputBase);
                if (decimalResult == -1) {
                    System.out.println(Constant.CONVERSION_TO_DECIMAL_FAILED);    
                    continue;
                }
                String outputResult = binaryConversions.convertFromDecimal(decimalFormat.format(decimalResult), outputBase);
                if (outputResult.equals("")) {
                    System.out.println(Constant.CONVERSION_FROM_DECIMAL_FAILED);
                    continue;
                }
                System.out.println("Result: " + outputResult);
            } catch (NumberFormatException exception) {
                System.out.println(Constant.INVALID_NUMBER_FORMAT);
            } catch (Exception exception) {
                System.out.println(Constant.UNEXPECTED_ERROR + exception.getMessage());
            }
        }
        input.close();
    }
}
