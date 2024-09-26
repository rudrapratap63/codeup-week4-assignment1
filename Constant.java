/*
This class will contain all the hard coded or the constant values.
Program Owner -> Rudra Pratap Singh
Date -> 25/09/2024
 */
public class Constant {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";

    public static final String ERROR_DIVISION_BY_ZERO = RED + "Error: Division by zero." + RESET;
    public static final String ENTER_VALID_DECIMAL_NUMBER = RED + "Error: Please enter a valid decimal number." + RESET;
    public static final String INPUT_IN_RIGHT_FORMAT = RED + "Error: Please enter input in the right format." + RESET;
    public static final String ENTER_ONLY_POSITIVE_INTEGER = RED + "Error: Please enter only positive integers." + RESET;
    public static final String OVERFLOW_OCCURED = RED + "Error: Overflow occurred!" + RESET;
    public static final String INVALID_COMMAND_FORMAT = RED + "Error: Invalid command format." + RESET;
    public static final String INVALID_BASE_RANGE = RED + "Error: Base must be between 2 and 36." + RESET;
    public static final String CONVERSION_TO_DECIMAL_FAILED = RED + "Error: Conversion to decimal failed." + RESET;
    public static final String CONVERSION_FROM_DECIMAL_FAILED = RED + "Error: Conversion from decimal failed." + RESET;
    public static final String INVALID_NUMBER_FORMAT = RED + "Error: Invalid number format." + RESET;
    public static final String INVALID_OPERATOR_FORMAT = RED + "Error: Invalid operator format." + RESET;
    public static final String UNEXPECTED_ERROR = RED + "Error: An unexpected error occurred: " + RESET;

    public static final String CLI_WELCOME = CYAN + "Welcome to the Base Converter CLI!" + RESET;
    public static final String CLI_USAGE_FOR_CONVERSION = CYAN + "Usage: convert [Input_Base] [Number] to [Output_Base]" + RESET;
    public static final String CLI_USAGE_FOR_CALCULATION = CYAN + "Usage: [operation] [Base1] [Number1] to [Base2] [Number2]" + RESET;
    public static final String CLI_EXAMPLE = CYAN + "Example: convert 16 1CABCDF to 10" + RESET;
    public static final String CLI_ADD_EXAMPLE = CYAN + "Example: add 16 A to 2 1010 \nExample: add hexadecimal A to binary 1010" + RESET;
    public static final String CLI_SUBTRACT_EXAMPLE = CYAN + "Example: subtract 16 A to 2 1010 \nExample: subtract hexadecimal A to binary 1010" + RESET;
    public static final String CLI_MULTIPLY_EXAMPLE = CYAN + "Example: multiply 16 A to 2 1010 \nExample: multiply hexadecimal A to binary 1010" + RESET;
    public static final String CLI_DIVIDE_EXAMPLE = CYAN + "Example: divide 16 A to 2 1010 \nExample: divide hexadecimal A to binary 1010" + RESET;
    public static final String CLI_EXIT_MESSAGE = CYAN + "Exiting the Base Converter CLI. Goodbye!" + RESET;
}
