package Part2;

public class CheckingAccount extends Account{
	
	//create a constructor that takes a parameter of type long called amt 
	CheckingAccount(long amt) {
		//call the constructor of the super class with parameters "checking" and amt 
		//use super("checking", amt)
		super("checking", amt);
	}
	
	//create a function called withdraw of type void that take an long amt as parameter
	void withdraw(long amt) {
		//this function should call the setAmount function of class Account with the parameter (amount - amt)
		//the variable amount belongs to class Account, why is it accessible here?
		setAmount(amount - amt);
		
	
		//Note: You could also use setAmount(getAmount() - amt)
		
	}
	

	
}