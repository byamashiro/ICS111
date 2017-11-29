package Part2;

public class Account {
	//NOTE: In inherited classes, the protected and default (no specifier) access specifiers work the same 
	//when working in the same package
	
	//private variables
	//can only be accessed by the members of the class
	private String name;
	protected long amount;

	Account(String name, long amount)
	{
	   this.name = name;
	   setAmount(amount);
	}
	
	//when a certain amount is deposited, the amount in the account has to change
	void deposit(long amount)
	{
	   this.amount += amount;
	}
	
	//since name cannot be directly accessed in the other classes, 
	//we create a function for getting the value of name
	String getName()
	{
	   return name;
	}
	
	long getAmount()
	{
	   return amount;
	}
	
	//a function to set the amount of the Account to a given value
	void setAmount(long amount)
	{
	   this.amount = amount;
	}
}
