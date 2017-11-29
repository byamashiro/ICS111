package Part2;

public class AccountMain{
   public static void main(String[] args)
   {
	   //Create an object of class SavingsAccount called sa passing 10000 as parameter
	   SavingsAccount sa = new SavingsAccount(10000);
      
      //Print the account name
      //Try using println("account name: " + sa.name); you'll get an error, why?
      //Try using System.out.println("account name: " + sa.getName()); this works, why?
	   System.out.println("account name: " + sa.getName());
      
      
      //Print the initial amount available in the account
      //Try using println("initial amount: " + sa.amount);
	   System.out.println("initial amount: " + sa.amount);

      //Also try println("initial amount: " + sa.getAmount());
      //In this case, both will work, why?
	   System.out.println("initial amount: " + sa.getAmount());
     
	   
      
      //call the deposit function using the object sa with parameter 5000
	   sa.deposit(5000);
      
      //Print the new amount after deposit (you can use either way to access the amount value discussed above)
	   System.out.println("new amount after deposit: " + sa.amount);
      

      
      //Create an object of class CheckingAccount called ca with 20000 as parameter
	   CheckingAccount ca = new CheckingAccount(20000);
      
      //Print out the account name as above
	   System.out.println("account name: " + ca.getName());
      
      //Print out the initial amount in the account using both ways as discussed above
	   System.out.println("initial amount: " + ca.amount);
	   System.out.println("initial amount: " + ca.getAmount());
	   
      
      //call the deposit function for object ca with passing parameter 6000
	   ca.deposit(6000);
     
      //Print out the new amount after deposit
	   System.out.println("new amount after deposit: " + ca.amount);
      
      
      //call the withdraw function for object ca with parameter 3000
	   ca.withdraw(3000);
      
      //Print out the new amount after withdrawal
	   System.out.println("new amount after withdrawal: " + ca.amount);
      
   }
}
