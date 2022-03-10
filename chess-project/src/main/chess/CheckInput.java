package chess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
	
	public static boolean checkCoordinateValidity(String input){
		Pattern pattern = Pattern.compile("[0-7]['a'-'i']");
		Matcher valid = pattern.matcher(input);
		if (valid.matches()) {
			return true;
		}
		return false;
	}
}
