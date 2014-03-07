package container;

import java.util.*;

public class Range {

	/*#1*/private char[] range={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q'
			,'r','s','t','u','v','w','x','y','z'};
	/*#2*/private char[] RANGE={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'
			,'R','S','T','U','V','W','X','Y','Z'};
	/*#3*/private char [] rangeint={'0','1','2','3','4','5','6','7','8','9'};
	
	private int RangeFrom=0;  //this keeps track of the beginning to end
	private int Rangeto=0;
	private int arrayNum;
	
	public Range(char A,char B)
	{
		//System.out.println("this is the value of A="+A);
		//System.out.println("this is the value of B="+B);
		
		
		if(Character.isDigit(A)==true)
		{
			
			for(int f=0;f<rangeint.length;++f)
			{				
				if( A==rangeint[f])
				{
					RangeFrom = f;
				}
				if( B==rangeint[f])
				{
					Rangeto=f;
				}
			}
			arrayNum=3;
		}
		else if(Character.isUpperCase(A)==true) 
		{
			for(int i=0;i<RANGE.length;++i)
			{
				//System.out.println("the character in array are"+RANGE[i]);
				if(A==RANGE[i])
				{
					RangeFrom=i;
				}
				if(B==RANGE[i])
				{
					Rangeto=i;
				}
			}
			arrayNum=2;
		}
		else if(Character.isLowerCase(A)==true)
		{
			for(int x=0;x<range.length;++x)
			{
				if(A==range[x])
				{
					RangeFrom=x;
				}
				if(B==range[x])
				{
					Rangeto=x;
				}
			}
			arrayNum = 1;

		}
		//System.out.println("RangeFrom="+RangeFrom+"Rangeto="+Rangeto+" arrayNum="+arrayNum);

		
	}
	public char getRandomCharacter()
	{//return a random character according to the range give.
		//Random randomGenerator = new Random();
		
		int index= RangeFrom + (int)(Math.random()*((Rangeto-RangeFrom)+1));
		
		if(arrayNum==1)
		{
			return range[index];
		}
		else if(arrayNum==2)
		{
			return RANGE[index];
		}
		else if(arrayNum==3)
		{
			//System.out.println("this is the random index generated:"+index);
			return rangeint[index]; 

		}
			
		return '*';
	}

		
}//end of class Range
