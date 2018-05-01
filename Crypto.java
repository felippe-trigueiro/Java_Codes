/* 
This program encrypt a message using the caesar algorithm.
*/

import java.util.regex.Pattern;

public class Crypto {
    public static void main(String args[]) {
        String aux = "";
        aux = encryptString("Por favor, nao incomode", 1, 2);
        System.out.println(aux);
    }
    
    //Normalize the text removing the white spaces and all the punctuation
    public static String normalizeText(String inMessage) {
        String correctMessage = "";
        
        correctMessage = inMessage.replaceAll("\\p{Punct}", "");
        correctMessage = correctMessage.replaceAll("\\p{Space}", "");
        correctMessage = correctMessage.toUpperCase();

        return correctMessage;
    }

    //Receives a normalized String and return the encrypted one
    public static String caesarify(String toEncMessage, int shiftValue) {
        String enCryptedMessage = "", auxString = "";
        String alphabet = shiftAlphabet(0);
        String shiftedAlphabet = shiftAlphabet(shiftValue);
        int oAlphaPosition = 0;

        for (int i = 0; i < toEncMessage.length(); i++){
            //character position in the normal alphabet (ABCD...)
            oAlphaPosition = alphabet.indexOf(toEncMessage.substring(i, i+1));
            auxString =  toEncMessage.replaceAll(toEncMessage.substring(i, i+1), shiftedAlphabet.substring(oAlphaPosition, oAlphaPosition+1));
            enCryptedMessage += auxString.substring(i, i+1);
        }

        return enCryptedMessage;    
    }

    public static String groupify(String encMessage, int letPerGroup) {
        String temp = "";
        int messageLength = encMessage.length();
        int numChunks = messageLength/letPerGroup;
        int modMessage = messageLength%letPerGroup;
        boolean flag = false;
        
        if (messageLength%letPerGroup != 0) {
            numChunks += modMessage;
            flag = true;
        }

        for (int i = 0; i < numChunks; i++) {            
            if (i != (numChunks - 1)) {  
                temp += encMessage.substring(i*letPerGroup, letPerGroup+i*letPerGroup);
                temp += " ";
            }
            else if (i == (numChunks - 1) && flag) {
                temp += encMessage.substring(i*letPerGroup, i*letPerGroup+modMessage);
                for (int k = 0; k < (letPerGroup - modMessage); k++) 
                    temp += "x";   
            }
        }

        return temp;
    }

    //This function receives an shift value and return the alphabet shifted by that value
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String encryptString(String toEncMessage, int shiftValue, int chunkSize) {
        String aux = "";

        aux = normalizeText(toEncMessage);
        aux = caesarify(aux, shiftValue);
        aux = groupify(aux, chunkSize);

        return aux;
    }

}
