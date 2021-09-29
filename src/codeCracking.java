import java.util.Scanner;

public class codeCracking {
    public static void main(String[] args) {
        //System.out.println(returnEncodedCypherFormatted(numberCypherEncoder("abc")));

        String userInput = "1;2;3;4;5";
        String[] userInputToStringArray = userInput.split(";");


    }
}
    /*
    static void runNumberCypherEncoder(){
        System.out.println("Please provide the string you would like to encode");
        Scanner scanner = new Scanner(System.in);
        String stringToEncode = scanner.nextLine();
        System.out.print(stringToEncode+" encoded is: ");
        printEncodedCypherFormatted(numberCypherEncoder(stringToEncode));
    }

    static int[] numberCypherEncoder(String stringToEncode) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøå ";
        char[] stringToCharArray = stringToEncode.toCharArray();

        String encodedString = "";
        int[] encodedArray = new int[stringToEncode.length()];

        for (int i = 0; i < stringToEncode.length(); i++) {
            String charToEncode = stringToCharArray[i] + "";
            int indexOfCharToEncode = alphabet.indexOf(charToEncode) + 1;
            int encodedChar = indexOfCharToEncode;
            encodedArray[i] = encodedChar;
        }
        return encodedArray;
    }

    static void printEncodedCypherFormatted(int[]encodedString){
        for (int currentInteger : encodedString) {
            System.out.print(currentInteger);
            if (currentInteger!=encodedString.length){
                System.out.print(";");
            }
        }
        System.out.print("\n");
    }

    static String returnEncodedCypherFormatted(int[]encodedString){
        String returned="";
        for (int currentInteger : encodedString) {
            returned+=currentInteger;
            if (currentInteger!=encodedString.length){
                returned+=";";
            }
        }
        return returned;
    }

    static String numberCypherDecoder(int[] arrayToDecode) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøå ";
        String cypherDecoded = "";
        for (int i = 0; i < arrayToDecode.length; i++) {
            char charDecoded = alphabet.charAt(arrayToDecode[i]-1);
            cypherDecoded += charDecoded;
        }
        return cypherDecoded;



    static char caesarCharacterEncoder(char character, int shift){
        String alphabet ="abcdefghijklmnopqrstuvwxyzæøå";
        String charToString =character+"";
        String charToStringLowercase = charToString.toLowerCase();
        int indexOfCharInAlphabet = alphabet.indexOf(charToStringLowercase);
        return alphabet.charAt(((indexOfCharInAlphabet)+shift)%29);

    }
}

     */
