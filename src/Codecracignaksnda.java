import java.util.Locale;
import java.util.Scanner;

public class Codecracignaksnda {
    public static void main(String[] args) {
    }

    static String numberCypherEncoder(String stringToEncode) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøå ";
        String stringToEncodeLowercase = stringToEncode.toLowerCase();
        char[] stringToCharArray = stringToEncodeLowercase.toCharArray();

        String encodedString = "";
        int[] encodedArray = new int[stringToEncodeLowercase.length()];

        for (int i = 0; i < stringToEncodeLowercase.length(); i++) {
            String charToEncode = stringToCharArray[i] + "";
            int indexOfCharToEncode = alphabet.indexOf(charToEncode) + 1;
            int encodedChar = indexOfCharToEncode;
            encodedArray[i] = encodedChar;
        }

        String arrayToFormattedString = "";

        int[] counter = new int[encodedArray.length];

        for (int currentInteger : encodedArray) {
            arrayToFormattedString += currentInteger+";";
        }
        return arrayToFormattedString;
    }

    static void runNumberCypherEncoder(){
        System.out.println("Please provide the string you would like to encode:");
        Scanner scanner = new Scanner(System.in);
        String stringToEncode = scanner.nextLine();
        System.out.print(stringToEncode.toLowerCase()+" encoded is: "+numberCypherEncoder(stringToEncode));
    }

    static String numberCypherDecoder(int[] arrayToDecode) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøå ";
        String cypherDecoded = "";
        for (int i = 0; i < arrayToDecode.length; i++) {
            char charDecoded = alphabet.charAt(arrayToDecode[i] - 1);
            cypherDecoded += charDecoded;
        }
        return cypherDecoded;
    }
}
