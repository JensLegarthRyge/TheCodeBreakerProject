import java.util.Scanner;

public class TheCodeBreaker {
    public static void main(String[] args) {
        printGameTitle();

        System.out.println("Would you like to encode or decode?");
        System.out.println("Press D to decode, press E to encode");
        String userChoiceDecodeOrEncode = getInput();

        if (userChoiceDecodeOrEncode.equalsIgnoreCase("d")){
            getChoiceCaesarOrNumber();
            String userChoiceCaesarOrNumber = getInput();
            if (userChoiceCaesarOrNumber.equalsIgnoreCase("n")){
                runNumberCypherDecoder();
            } else if (userChoiceCaesarOrNumber.equalsIgnoreCase("c")){
                runCaesarCypherDecoder();
            }

        } else if (userChoiceDecodeOrEncode.equalsIgnoreCase("e")){
            getChoiceCaesarOrNumber();
            String userChoiceCaesarOrNumber = getInput();
            if (userChoiceCaesarOrNumber.equalsIgnoreCase("c")){
                runCaesarCypherEncoder();
            } else if (userChoiceCaesarOrNumber.equalsIgnoreCase("n")){
                runNumberCypherEncoder();
            }
        }
    }

    static void printGameTitle(){
        System.out.println("######################################################" +
                "######################################################" +
                "######################################################");
        System.out.println("######################################################################## THE CODE BREAKER " +
                "########################################################################");
        System.out.println("######################################################" +
                "######################################################" +
                "######################################################");
        System.out.println();
    }

    static void getChoiceCaesarOrNumber(){
        System.out.println();
        System.out.println("Would you like to use Caesar Cypher or Number Cypher?");
        System.out.println("Press C to use Caesar Cypher or N to use Number Cypher");
    }

    static String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static void runNumberCypherEncoder(){
        System.out.println();
        System.out.println("Please input the text to encode");
        String stringToEncode = getInput();
        String yourShiftedInputIs = stringToEncode+" encoded is ";
        System.out.print(yourShiftedInputIs);
        int[]encodedArray=numberCypherEncoder(stringToEncode);
        formatEncodedNumberCypher(encodedArray);
    }
    static int[] numberCypherEncoder(String stringToEncode) {
        //Define the alphabet
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøå !?,.;:-";

        //Turn the string to charArray + to lowercase
        String stringToEncodeLowercase = stringToEncode.toLowerCase();
        char[] stringToCharArray = stringToEncodeLowercase.toCharArray();

        //Creating new integer array according to the length of the string input
        int[] encodedArray = new int[stringToEncodeLowercase.length()];

        //Creating loop to fill in the array, runs while i is less than length of word
        for (int i = 0; i < stringToEncodeLowercase.length(); i++) {

            //Character to encode has to be a string to make use of 'indexOf' + "" to fit string requirements
            String charToEncode = stringToCharArray[i]+"";

            //Create the integer that fills the array, +1 for readability corresponding to alphabet
            int indexOfCharToEncode = alphabet.indexOf(charToEncode) + 1;
            //Fill out the array
            encodedArray[i] = indexOfCharToEncode;
        }

        return encodedArray;
    }
    public static void formatEncodedNumberCypher(int[]encodedString) {
        for (int currentInteger : encodedString) {
            System.out.print(currentInteger + ";");
        }
        System.out.println();
    }

    static void runCaesarCypherEncoder(){
        System.out.println();
        System.out.println("Please input the text to encode");
        String stringToEncode = getInput();
        System.out.println("Please input your desired shift value");
        Scanner scanner = new Scanner(System.in);
        int shiftValue = scanner.nextInt();
        String yourShiftedInputIs = stringToEncode+" shifted by "+shiftValue+" is ";
        System.out.print(yourShiftedInputIs);
        System.out.print(caesarCypherEncoder(stringToEncode,shiftValue));
    }
    static char[] caesarCypherEncoder(String stringToEncode, int shift) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøå !?,.;:-";

        //Turn the string to charArray + to lowercase
        String stringToEncodeLowercase = stringToEncode.toLowerCase();
        char[] stringToCharArray = stringToEncodeLowercase.toCharArray();

        //Creating new char array according to the length of the string input
        char[] encodedArray = new char[stringToEncodeLowercase.length()];

        //Creating loop to fill in the array, runs while i is less than length of word
        for (int i = 0; i < stringToEncodeLowercase.length(); i++) {
            String charToEncode = stringToCharArray[i] + "";
            int indexOfCharToEncode = alphabet.indexOf(charToEncode);
            encodedArray[i] = alphabet.charAt(((indexOfCharToEncode)+shift)%alphabet.length());
        }
        return encodedArray;
    }

    static void runNumberCypherDecoder(){
        System.out.println();
        System.out.println("Please input the numbers to decode seperated by semicolons (e.g. \"1;12;15;12\"");
        String userInput = getInput();
        String[]userInputToStringArray = userInput.split(";");
        int stringArrayLength = userInputToStringArray.length;
        int [] arrayToDecode = new int[stringArrayLength];
        for (int i = 0; i < stringArrayLength; i++) {
            arrayToDecode[i]=Integer.parseInt(userInputToStringArray[i]);
        }
        System.out.println(numberCypherDecoder(arrayToDecode));
    }
    static String numberCypherDecoder(int[] arrayToDecode) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøå !?,.;:-";
        String cypherDecoded = "";
        for (int i = 0; i < arrayToDecode.length; i++) {
            char charDecoded = alphabet.charAt(arrayToDecode[i] - 1);
            cypherDecoded += charDecoded;
        }
        return cypherDecoded;
    }

    static void runCaesarCypherDecoder(){
        System.out.println();
        System.out.println("Please input the text to decode");
        String stringToEncode = getInput();
        System.out.println("Please input the shift value supplied for decoding");
        Scanner scanner = new Scanner(System.in);
        int shiftValue = scanner.nextInt();
        String yourShiftedInputIs = stringToEncode+" decoded is ";
        System.out.print(yourShiftedInputIs);
        System.out.print(caesarCypherDecoder(stringToEncode,shiftValue));
    }
    static char[] caesarCypherDecoder(String stringToDecode, int shift){
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøå !?,.;:-";

        //Turn the string to charArray + to lowercase
        String stringToDecodeLowercase = stringToDecode.toLowerCase();
        char[] stringToCharArray = stringToDecodeLowercase.toCharArray();

        //Creating new char array according to the length of the string input
        char[] decodedArray = new char[stringToDecodeLowercase.length()];
        //Creating loop to fill in the array, runs while i is less than length of word
        for (int i = 0; i < stringToDecodeLowercase.length(); i++) {
            String charToDecode = stringToCharArray[i] + "";
            int indexOfCharToDecode = alphabet.indexOf(charToDecode);
            int indexOfCharToDecodeShifted = indexOfCharToDecode-shift;

            if (indexOfCharToDecodeShifted<0){
                indexOfCharToDecodeShifted+=alphabet.length();
            }
            decodedArray[i] = alphabet.charAt(indexOfCharToDecodeShifted%alphabet.length());
        }
        return decodedArray;
    }
}
