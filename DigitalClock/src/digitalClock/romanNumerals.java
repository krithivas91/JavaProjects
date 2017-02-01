package digitalClock;
public class romanNumerals {
	public String getNumeral(int n) //gets the hr/min/sec
	{
		String roman="";
		while (n>=50)
		{
			roman = roman + "L";
			n = n - 50;
		}
		while (n>=40)
		{
			roman = roman + "XL";
			n = n - 40;
		}
		while (n>=10)
		{
			roman = roman + "X";
			n = n - 10;
		}
		while(n>=9) 
		{
			roman = roman + "IX";
			n = n - 9;
		}
		while(n>=5)
		{
			roman = roman + "V";
			n = n - 5;
		}
		while(n>=4)
		{
			roman = roman + "IV";
			n = n - 4;
			
		}
		while(n>=1)
		{
			roman = roman + "I";
			n = n - 1;
		}
		return roman;
	}
}
