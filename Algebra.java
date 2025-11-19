// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		
		int sum = x1;
		while (x2 != 0) {
			if (x2 < 0){
				sum--;
				x2++;
			}
			else {
			sum++;	
			x2--;
			}	
		}	
			return sum;		
	}
		


	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum  = x1;
		while (x2 != 0){
			if (x2 <0){
				sum++;
				x2++;
			}
			else {
				sum--;
				x2--;
			}
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
			int sum = 0;
		if (x1 == 0 || x2 == 0){ //  מקרה שבו אחד המספרים אפס מחזיר תוצאה אפס
				return sum;
			}

		 if ( x1>0 && x2>0){ // מקרה שבו שני המספרים  חיוביים
			for (int i = 0; i <x2; i++){
				sum = plus (sum,x1);
			}	
		}
			else if (x1 <0 && x2<0) { // מקרה שבו שני המספרים שליליים
		    x1 = minus(0,x1);
		    x2 = minus(0,x2);
			for (int i = x2; i > 0; i--){
				sum = plus (sum,x1);
			}		
		}
			else if (x1 <0 && x2 >0){ // מקרה שבו איקס 1 שלילי ואיקס 2 חיובי
				for (int i = 0; i <x2; i++){
				sum = plus (sum,x1);
				}
			}
			else if (x1 >0 && x2< 0){ // מקרה שבו איקס 2 שלילי ואיקס 1 חיובי
				for (int i = 0; i <x1; i++){
				sum = plus (sum,x2);
				}
			}

		return sum;
	}


	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) { // השתמשתי בסימן מודולו ואסור 
			int sum =1;
		if (n == 0) {
	    	return 1; 
		}
		else if (x ==0){
			return 0;
		}
		else if (x > 0){ // בסיס חיובי 
			for (int i =1; i<=n; i++){
				sum = times(sum,x);
			}
		}
		else if (x<0){
		   if (mod(n,2) == 0){ // בסיס שלילי מעריך זוגי אז תוצאה חיובית
		       	for (int i =1; i<=n; i++){
				sum = times(sum,x);
			}
		   } 
		   else { // בסיס שלילי מעריך אי זוגי אז תוצאה שלילית
		       for (int i =1; i<=n; i++){
				sum = times(sum,x);
		    	}
		   }    	    
		}
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int counter = 0;
		if (x2 == 0){
			return 0;
		}
		else if (x1 == x2){
			return 1;
		}
		else if (x1 >x2 && x1 > 0 && x2>0){
			for (int i =1; x1>=times(i,x2); i++) {				
				counter++;
			}
		}
		else if (x1 <x2 && x1 > 0 && x2>0){
			return 0;
		}
		else if (x1< 0 && x2<0 && x1 > x2){
			return 0;
		}
		else if (x1< 0 && x2<0 && x1 < x2){
			for (int i =1; x1<=times(i,x2); i++) {				
				counter++;
			}	
		}
		else if (x1 < 0 && x2> 0 && minus(0,x1) > x2){
			for (int i =1; minus(0,x1)>=times(i,x2); i++) {				
				counter++;
			}	
			counter = minus(0,counter);
		}
		else if (x1 < 0 && x2> 0 && minus(0,x1) < x2){
			return 0;
		}
		else if (x1 > 0 && x2 < 0 && minus(0,x2) < x1){
			for (int i =1; x1>=times(i,minus(0,x2)); i++) {				
				counter++;
			}
				counter = minus(0,counter);
		}
			else if (x1 > 0 && x2 < 0 && minus(0,x2) > x1){
				return 0;
		}
		// פער רק באם יש לי קלט של מספר אחד חיובי ואחד שלילי
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		//int Times12 = times(x1,x2);
		int x3 = div(x1,x2);
		int x4 = times(x2,x3);
		int x5 = minus(x1,x4);
		return x5;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) { // אמור לעבוד לערכים שיש להם שורש שלם
		int ans = 0;
		for(int i=1;x>=times(i,i); i++){
			ans = i;
			if (times(i,i) == x){
			}
		}
		return ans;
	}	  	  
}