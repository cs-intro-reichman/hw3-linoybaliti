/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1); // ניקוי
		str2 = preProcess(str2); // ניקוי
		boolean Answer = false;
		
		if (str1.length() != str2.length()){
			return false;
		}
		for (int i=0;i<str1.length();i++){
			for(int j=0;j<str1.length();j++){
				if(str1.charAt(i) == str2.charAt(j) ){
					// פה נתקעתי כי אני רוצה להשמיד את התווים שמצאתי מ 2 המערכים בעצם ליצור חדש כי זה סטרינג
				}
				else {
					// return false;
				}
			}
		}
		return Answer;
	}
		
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
	String NewStr ="";
	for (int i =0; i< str.length(); i++){
		if (str.charAt(i) == '!'||str.charAt(i) == '@'||str.charAt(i) == '#'||str.charAt(i) == '$'||
		  str.charAt(i) == '%'||str.charAt(i) == '^'||str.charAt(i) == '&'||str.charAt(i) == '*'||
		  str.charAt(i) == ')'||str.charAt(i) == '('||str.charAt(i) == ' '||str.charAt(i) == '0'||
		  str.charAt(i) == '1'||str.charAt(i) == '2'||str.charAt(i) == '3'||str.charAt(i) == '4'||
		  str.charAt(i) == '5'||str.charAt(i) == '6'||str.charAt(i) == '7'||str.charAt(i) == '8'||
		  str.charAt(i) == '9' || str.charAt(i) == '?'|| str.charAt(i) == '<'|| str.charAt(i) == '>'){
		}
		else {
				char lowerCaseChar = Character.toLowerCase(str.charAt(i));
				NewStr += lowerCaseChar;
			//	NewStr += str.charAt(i);
		}
	}
		return NewStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		str = preProcess(str); // יעבוד אחרי שפרי פרוסס יעבוד 
		String NewStr = ""; // הגדרת מערך חדש
		for (int i=0; i<str.length(); i++){
			int rand = (int) (Math.random() *str.length() -1) ;
			NewStr = NewStr + str.charAt(rand); // += להכניס את האות במיקום הרנדום למערך החדש שיצרתי
			str = str.substring(0,rand) + str.substring(rand +1,str.length()); // עדכון הסטירנג המקורי
		} 
		return NewStr;
	}
}
