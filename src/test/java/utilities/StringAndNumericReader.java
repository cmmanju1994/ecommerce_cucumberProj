package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class StringAndNumericReader {

	 public String randomeString() {
	 		String generatedString=RandomStringUtils.randomAlphabetic(5);
	 		return generatedString;
	 	}
	 	
	 	
	 	public String randomeNumber() {
	 		String generatedString=RandomStringUtils.randomNumeric(10);
	 		return generatedString;
	 	}
	 	
	 		
	 	public String randomAlphaNumeric() {
	 	String str=RandomStringUtils.randomAlphabetic(5);
	 	 String num=RandomStringUtils.randomNumeric(10);
	 	return str+num;
	 	}
}
