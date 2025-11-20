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
		str1 = preProcess(str1);
    str2 = preProcess(str2);

    if (str1.length() != str2.length()) {
        return false;
    }
    
    // יוצרים מערך בגודל 26 (לאותיות a-z)
    int[] counts = new int[26];

    // שלב 1: סופרים את התווים ב-str1
    for (int i = 0; i < str1.length(); i++) {
        // 'a' - 'a' = 0; 'b' - 'a' = 1, וכו'.
        counts[str1.charAt(i) - 'a']++; 
    }

    // שלב 2: מפחיתים את התווים מ-str2
    for (int i = 0; i < str2.length(); i++) {
        counts[str2.charAt(i) - 'a']--;
    }

    // שלב 3: אם יש ספירה שאינה 0, יש חוסר התאמה
    for (int count : counts) {
        if (count != 0) {
            return false;
        }
    }
    
    return true;
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
		str = preProcess(str); 
    char[] arr = str.toCharArray();
    int n = arr.length;
    if (n == 0) {
        return "";
    }
    StringBuilder newStr = new StringBuilder();
    int currentLength = n;
    for (int i = 0; i < n; i++) {
        int randIndex = (int) (Math.random() * currentLength); 
        newStr.append(arr[randIndex]);
        arr[randIndex] = arr[currentLength - 1];
        currentLength--;
    } 
    return newStr.toString();
	}
}
