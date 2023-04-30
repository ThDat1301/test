
public class MyBigNumber {
	public static String sum(String stn1, String stn2) {
		
		int stn1Length = stn1.length();
		int stn2Length = stn2.length();
		int rangeOfStn;
		char[] stn1CharArr = null;
		char[] stn2CharArr = null;
		int result = 0;
		int memoNum = 0;
		String resultStr = "";
		if (stn1Length > stn2Length) {
			
			stn1CharArr = new char[stn1Length];
			stn2CharArr = new char[stn1Length];
			rangeOfStn = stn1Length - stn2Length;
			
			for (int i = 0; i < stn1.length(); i++) {
		
				if (i < rangeOfStn) {
					stn1CharArr[i] = stn1.charAt(i);
					stn2CharArr[i] = '0';
				}
				else {
					stn1CharArr[i] = stn1.charAt(i);
					stn2CharArr[i] = stn2.charAt(i - rangeOfStn);
				}
			}
		}
		else if (stn2Length > stn1Length) {
			
			stn1CharArr = new char[stn2Length];
			stn2CharArr = new char[stn2Length];
			rangeOfStn = stn2Length - stn1Length;
			for (int i = 0; i < stn2.length(); i++) {
				
				if (i < rangeOfStn) {
					stn2CharArr[i] = stn2.charAt(i);
					stn1CharArr[i] = '0';
				}
				else {
					stn2CharArr[i] = stn2.charAt(i);
					stn1CharArr[i] = stn1.charAt(i - rangeOfStn);
				}
			} 
		}
		else {
			stn1CharArr = new char[stn1Length];
			stn2CharArr = new char[stn1Length];
			for (int i = 0; i < stn1Length; i++) {
				stn1CharArr[i] = stn1.charAt(i);
				stn2CharArr[i] = stn2.charAt(i);
			}
		}
		
		for (int i = stn1CharArr.length - 1; i >= 0; i--) {
			result = Integer.parseInt(String.valueOf(stn1CharArr[i])) + Integer.parseInt(String.valueOf(stn2CharArr[i])) + memoNum;
			
			if (result >= 10 && i != 0) {
				memoNum = result / 10;
				result %= 10;
			}
			
			else {
				memoNum = 0;
			}
			resultStr += String.valueOf(result);
			System.out.println(new StringBuilder(resultStr).reverse().toString());
		}
		
		return new StringBuilder(resultStr).reverse().toString()
;
	}
}
