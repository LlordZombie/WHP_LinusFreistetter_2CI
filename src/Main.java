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
		System.out.println("isDateTTMMYY(\"310592\") = " + isDateTTMMYY("310592"));
		System.out.println("isDateTTMMYY(\"280250\") = " + isDateTTMMYY("280250"));
		System.out.println("isDateTTMMYY(\"300250\") = " + isDateTTMMYY("300250"));
		System.out.println("isDateTTMMYY(\"nodate\") = " + isDateTTMMYY("nodate"));
		System.out.println("isDateTTMMYY(\"001260\") = " + isDateTTMMYY("001260"));
		System.out.println("isDateTTMMYY(\"310499\") = " + isDateTTMMYY("310499"));
		System.out.println("isValidAustrianSVNR(\"3747220566\") = " + isValidAustrianSVNR("3747220566"));
		System.out.println("isValidAustrianSVNR(\"1237221105\") = " + isValidAustrianSVNR("1237221105"));
		System.out.println("isValidAustrianSVNR(\"3748220566\") = " + isValidAustrianSVNR("3748220566"));
		System.out.println("isValidAustrianSVNR(\"374722056_\") = " + isValidAustrianSVNR("374722056_"));
		System.out.println("isValidAustrianSVNR(\"374722056\") = " + isValidAustrianSVNR("374722056"));
		System.out.println("isValidAustrianSVNR(\"3747310266\") = " + isValidAustrianSVNR("3747310266"));
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
		try {return Integer.parseInt(String.valueOf(digit));}
		catch (Exception e) {return -1;}
	}

	public static int getMonthLength(int month) {
		return switch (month) {
			case 1, 3, 5, 7, 8, 10, 12 -> 31;
			case 2 -> 29;
			default -> 30;
		};
	}
	public static boolean isDateTTMMYY(String date) {
		try {return (date.matches("\\d+") && date.length() == 6 && (Integer.parseInt(date.substring(2,4))>=1&&Integer.parseInt(date.substring(2,4))<=12)&&(Integer.parseInt(date.substring(0,2))>0&&Integer.parseInt(date.substring(0, 2)) <= getMonthLength(Integer.parseInt(date.substring(2,4)))));
		} catch (NumberFormatException e) {return false;}
	}

	public static boolean isValidAustrianSVNR(String svnr) {
		return (svnr.length() == 10) && (svnr.matches("\\d+")) && (isDateTTMMYY(svnr.substring(4))) && ((toInt(svnr.charAt(0)) * 3 + toInt(svnr.charAt(1)) * 7 + toInt(svnr.charAt(2)) * 9 + toInt(svnr.charAt(4)) * 5 + toInt(svnr.charAt(5)) * 8 + toInt(svnr.charAt(6)) * 4 + toInt(svnr.charAt(7)) * 2 + toInt(svnr.charAt(8)) + toInt(svnr.charAt(9)) * 6) % 11 == (toInt(svnr.charAt(3))));
	}
}