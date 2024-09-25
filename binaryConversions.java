/*
This Class is used to do all the conversions of anyToDecimal and decimalToAny
Owner -> Rudra Pratap Singh
Date -> 25/09/2024
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class binaryConversions {
    static double decimalConversionResult;    
    static String baseConversionResult;

    // Convert any base number (e.g., binary, octal) to decimal
    // Input - String, Integer
    // Return - Double
    public static double convertToDecimal(String number, int base) {
        String baseNumber = number;
        String[] numberParts = baseNumber.split("\\.");
        decimalConversionResult = 0.0;
        if (!isInFormat(numberParts[0], base)) {
            System.out.println(Constant.INPUT_IN_RIGHT_FORMAT);
            return -1;
        }
        if (numberParts.length == 2 && !isInFormat(numberParts[1], base)) {
            System.out.println(Constant.INPUT_IN_RIGHT_FORMAT);
            return -1;
        }
        if (numberParts[0].contains("-")) {
            System.out.println(Constant.ENTER_ONLY_POSITIVE_INTEGER);
            return -1;
        }
        if (numberParts.length > 2) {
            System.out.println(Constant.ENTER_VALID_DECIMAL_NUMBER);
            return -1;
        }
        double integerPart = convertIntegerPartToDecimal(numberParts[0], base);
        double fractionalPart = 0.0;
        if (numberParts.length == 2) {
            fractionalPart = convertFractionalPartToDecimal(numberParts[1], base);
        }
        decimalConversionResult = integerPart + fractionalPart;
        return decimalConversionResult;
    }
    
    // This function convert Input Number's Integer part to decimal 
    // Input - String, Integer
    // Return - Double
    public static double convertIntegerPartToDecimal(String number, int base) {
        double decimalValue = 0.0;
        int length = number.length();
        long power = 1;  
        for (int i = length - 1; i >= 0; i--) {
            char digitCharacter = number.charAt(i);
            long digitValue = (digitCharacter >= '0' && digitCharacter <= '9') ? digitCharacter - '0' : digitCharacter - 55;
            decimalValue += digitValue * power;
            power *= base;
        }
        return decimalValue;
    }
    
    // This function convert Input Number's Fractional part to decimal 
    // Input - String, Integer
    // Return - Double
    public static double convertFractionalPartToDecimal(String number, int base) {
        double decimalValue = 0.0;
        double power = base;  
        for (int i = 0; i < number.length(); i++) {
            char digitChar = number.charAt(i);
            long digitValue = (digitChar >= '0' && digitChar <= '9') ? digitChar - '0' : digitChar - 55;
            decimalValue += digitValue / power;
            power *= base;
        }
        return decimalValue;
    }

    // Convert a decimal number to any base
    // Input - String, Integer
    // Return - String
    public static String convertFromDecimal(String number, int base) {
        String decimalNumber = number;
        String[] numberParts = decimalNumber.split("\\.");
        baseConversionResult = "";
        if (numberParts.length > 2) {
            return Constant.ENTER_VALID_DECIMAL_NUMBER;
        }
        baseConversionResult = convertIntegerPartFromDecimal(Long.parseLong(numberParts[0]), base);
        if (numberParts.length == 2) {
            if(!isInFormat(numberParts[1], base)){
                return Constant.INPUT_IN_RIGHT_FORMAT;
            }
            convertFractionalPartFromDecimal(numberParts[1], base);
        }
        return baseConversionResult;
    }

    // Helper method: Convert the integer part of a decimal number to any base
    // Input - Long, Integer
    // Return - String
    public static String convertIntegerPartFromDecimal(long number, int base) {
        String convertedValue = "";
        while (number > 0) {
            long remainder = number % base;
            char digit = (remainder > 9) ? (char) (remainder + 55) : (char) (remainder + '0');
            convertedValue = digit + convertedValue;  
            number = number / base;
        }
        return convertedValue.isEmpty() ? "0" : convertedValue;  // Handle 0 case
    }

    // Helper method: Convert the fractional part of a decimal number to any base
    // Input - String, Integer
    public static void convertFractionalPartFromDecimal(String number, int base) {
        baseConversionResult += ".";  
        double fractionalValue = Double.parseDouble("0." + number);
        for (int i = 0; i < 5; i++) {  
            fractionalValue *= base;
            int digit = (int) fractionalValue;
            if (digit > 9) {
                baseConversionResult += (char) (digit + 55);  
            } else {
                baseConversionResult += digit;  
            }
            fractionalValue -= digit;
            if (fractionalValue == 0) {
                break;
            }
        }
    }

    // Reverse a string
    public static String reverseString(String originalString){ 
        String reverseString = ""; 
        for (int i = originalString.length() - 1; i >= 0; i--) {
            reverseString += originalString.charAt(i);
        }
        return reverseString; 
    } 
    
    // Check the input number is in right format or not according to base
    // Input - String, Integer
    // Return - Boolean
    public static boolean isInFormat(String InputNumber, int base){
        String regex = (base <=8) ? "[0-" + (base-1) + "]+" : Constant.HEXADECIMAL_REGEX_FORMAT;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(InputNumber);
        return matcher.matches() ;
    }
}


