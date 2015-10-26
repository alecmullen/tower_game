package gamesrc;

public class Bank {
	
	int value;
	
	public Bank(int principal)
	{
		value = principal;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void decrement(int dec)
	{
		value -= dec;
	}
}
