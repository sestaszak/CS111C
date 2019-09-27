
public class HomeworkM1Driver {

	public static void main(String[] args) {
		String s1 = "janeeyre@email.com";
		String s2 = "markdarcy@gmail.abc";
		String s3 = "dr.frankenstein@monster.com";
		String s4 = "!@abc.xyz";
		String s5 = "@abc.xyz";
		String s6 = "abc.com";
		String s7 = "j@com";
		String s8 = "jm@gmail.comm";
		String s9 = "jm@gmail.hi";
		String s10 = "jm@gmail.z";
		String s11 = "abcdef";
		String[] tests = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11};
		boolean[] results = {true, true, true, true, false, false, false, false, false, false, false};
		for(int i=0; i<tests.length; i++) {
			System.out.println(isValidEmail(tests[i]) +
					" : " + results[i] + " for " + tests[i]
					);
		}

	}

	public static boolean isValidEmail(String testEmail){
//        rule for valid email:
//        it contains the @ symbol with at least one character before it
//        it contains a period (.)
//        there are exactly three characters after the last period

		char[] emailChars = testEmail.toCharArray();
		boolean atSym = false;
		boolean periodExist = false;
		boolean threeCharAfter = false;

		for(int i=1; i<emailChars.length; i++){
			if(emailChars[i]=='@'){
				atSym = true;
			}
			if(emailChars[i]=='.'){
				periodExist = true;
				int nCharAfter =0;
				for(int j=i+1; j<emailChars.length; j++){
					char c = emailChars[j];
					if(Character.isLetterOrDigit(c)){
						nCharAfter += 1;
					}
				}
				threeCharAfter = (nCharAfter==3);

//				char chn1 = emailChars[i+1];
//				char chn2 = emailChars[i+2];
//				char chn3 = emailChars[i+3];
//
//				threeCharAfter = (Character.isLetterOrDigit(chn1) & Character.isLetterOrDigit(chn2) & Character.isLetterOrDigit(chn3));
			}

		}

		return (atSym & periodExist & threeCharAfter);
	}

}
