import java.util.ArrayList;
import java.util.Scanner;

class ATM{
    // Fields to store the balance, PIN, and transaction history
    private float Balance;
     private int PIN = 1234;
     private ArrayList<String> transactionHistory = new ArrayList<>();

     // Method to check the PIN entered by the user
    public void checkPin(){
         System.out.println("Enter your pin: ");
         Scanner sc = new Scanner(System.in);
         int enteredpin = sc.nextInt();
         if(enteredpin == PIN){
             menu(); // if PIN is correct, display the menu
         }else{
             System.out.println("Incorrect PIN. Please try again.");
             checkPin(); // If PIN is incorrect, prompt for PIN again
         }
     }
    // Method to display the menu and handle user choices
    public void menu(){
         System.out.println("Welcome to the ATM");
         System.out.println("1. Account Balance Inquiry");
         System.out.println("2. Cash Withdrawal");
         System.out.println("3. Cash Deposit");
         System.out.println("4. PIN Change");
         System.out.println("5. Transaction History");
         System.out.println("6. Exit");
         System.out.print("Choose an option: ");

         Scanner sc = new Scanner(System.in);
         int choice = sc.nextInt();

        // Handle the user's menu choice
         if(choice == 1){
             checkBalance();
         } else if (choice == 2) {
             cashWithdraw();
         } else if (choice==3) {
             cashDeposit();
         } else if (choice==4) {
             changePIN();
         } else if (choice==5) {
             transHistory();
         }else if (choice == 6){
             System.out.println("Thank you for Using ATM. GoodBye!");
             return; // Exit the program
         }else{
             System.out.println("Enter a valid Option\n");
             menu();//Invalid choice, prompt again
         }
     }

    // Method to check and display the current balance
    public void checkBalance(){
         System.out.println("Current Balance: "+Balance+"\n");
         transactionHistory.add("Checked balance:"+Balance);
         menu();
     }

    // Method to withdraw cash from the account
    public void cashWithdraw(){
         System.out.print("Enter Amount to Withdraw: ");
         Scanner sc = new Scanner(System.in);
         float amount = sc.nextFloat();
         if(amount>Balance){
             System.out.println("Insufficient Balance\n");
         }else{
             Balance = Balance - amount;
             System.out.print("Money Withdraw Successful\n");
             System.out.println("Remaining Balance: "+ Balance);
             transactionHistory.add("Withdrew: -"+amount);

         }
         menu();// return to the menu
     }

    // Method to deposit cash into the account
    public void cashDeposit(){
         System.out.print("Enter Amount for Deposit: ");
         Scanner sc = new Scanner(System.in);
         float amount = sc.nextFloat();
         Balance = Balance + amount;
         System.out.print("Money Deposit Successful\n");
        System.out.println("Updated Balance: "+ Balance);
         transactionHistory.add("Deposited: +"+ amount);
         menu();
     }

    // Method to change the PIN
     public void changePIN(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter current PIN: ");
         int currentPin = sc.nextInt();
         if(currentPin == PIN){
             System.out.print("Enter new PIN: ");
             int newPin = sc.nextInt();
             PIN = newPin;
             System.out.println("PIN successfully changed.\n");
             transactionHistory.add("Changed PIN");
         }else{
             System.out.println("Incorrect current PIN.\n");
         }
         checkPin(); // After changing PIN, prompt for PIN again
     }

    // Method to display the transaction history
     public void transHistory(){
         System.out.println("Transaction History:");
         for(String transaction : transactionHistory){
             System.out.println(transaction+"\n");
         }
         menu();
     }
}
public class ATMMachine {
    public static void main(String[] args) {
        System.out.println("Welcome to ATM Machine.");
        System.out.println("Created By Akshit Goyal.");
        ATM atm = new ATM();
        atm.checkPin(); // Start by checking the user PIN
    }
}
