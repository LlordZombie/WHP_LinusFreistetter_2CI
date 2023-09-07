import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 4, 5, 5, 6, 7, 8, 9, 5};
        System.out.println(countIntervall(3, 5, arr));
        System.out.println("extractIntervall(3,5,arr) = " + Arrays.toString(extractIntervall(3, 5, arr)));
        System.out.println("removeBadCharsIgnoreCase(\"<Hallo Welt !123>\",\"abcdefghijklmnOPQRSTUVWXZY \") = " + removeBadCharsIgnoreCase("<Hallo Welt !123>", "abcdefghijklmnOPQRSTUVWXZY "));
        System.out.println(isValidVarName("notvalid"));
        System.out.println(toInt('3'));
        System.out.println("isDateTTMMYY(\"311292\") = " + isDateTTMMYY("011292"));
    }

    public static int countIntervall(int min, int max, int[] a) {
        int rInt = 0;
        for (int j : a) {
            if (j <= max && j >= min) {
                rInt++;
            }
        }
        return rInt;
    }

    public static int[] extractIntervall(int min, int max, int[] a) {
        ArrayList<Integer> rIntsList = new ArrayList<>();
        for (int j : a) {
            if (j <= max && j >= min) {
                rIntsList.add(j);
            }
        }
        return rIntsList.stream().mapToInt(i -> i).toArray();
    }

    public static String removeBadCharsIgnoreCase(String original, String validChars) {
        String originalLowercase = original.toLowerCase();
        String validCharsLowercase = validChars.toLowerCase();
        StringBuilder rString = new StringBuilder();
        for (int i = 0; i < originalLowercase.length(); i++) {
            String currentChar = String.valueOf(originalLowercase.charAt(i));
            if (validCharsLowercase.contains(currentChar)) {
                rString.append(original.charAt(i));
            }
        }
        return rString.toString();
    }

    public static boolean isValidVarName(String varName) {
        return ((!varName.isBlank()) && (varName.equals(removeBadCharsIgnoreCase(varName, "abcdefghijklmnopqrstuvwxzy_"))) && (Character.isLowerCase(varName.charAt(0))) && (Character.isLetter(varName.charAt(varName.length() - 1))));
    }

    public static int toInt(char digit) {
        try {
            return Integer.parseInt(String.valueOf(digit));
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean isDateTTMMYY(String date){
        if (date.length()!=6){
            return false;
        }
        if ()
        for (int i = 0; i < date.length(); i++) {
            if (!Character.isDigit(date.charAt(i))){
                return false;
            }
        }
        int month = Integer.parseInt(date.substring(2,4));
        int tag = Integer.parseInt(date.substring(0,2));
        if (month<1||month>12){
            return false;
        }
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                if (tag < 1 || tag > 31) {
                    return false;
                }
            }
            case 4, 6, 9, 11 -> {
                if (tag < 1 || tag > 30) {
                    return false;
                }
            }
            case 2 -> {
                if (tag < 1 || tag > 29) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValidAustrianSVNR(String svnr){
        if (svnr.length()!=10){
            int
        }
    }
}