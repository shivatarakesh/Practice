package practice.DataDrivenTeting;

public class AlphaNumericRandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=20;
		//choose a character random from this string
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		
		//create string buffer size of alphanumeric string
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<n;i++) {
			
			//generate a random number between 0 to alphanumeric string length
			int index=(int)(AlphaNumericString.length()*Math.random());
			
			//add character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		System.out.println(sb);

	}

}
