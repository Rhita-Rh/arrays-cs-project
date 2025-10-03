package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000];
    int i =0; //index of transactions array

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if(amount<=0){
            System.out.println("The deposit is unsuccessful!");
        }
        else{
            currentBalance += amount;
            transactions[i] = amount;
            i++;
            System.out.println(name + " has deposited the amount: " + amount + ". His new balance is: " + currentBalance);
        }
    }

    public void withdraw(double amount){
        if(amount<=0 || amount>currentBalance){
            System.out.println("The withdrawal is unsuccessful!");
        }
        else{
            currentBalance -= amount;
            transactions[i] = -amount;
            i++;
            System.out.println(name + " has withdrawed the amount: " + amount + ". His new balance is: " + currentBalance);
        }
    }

    public void displayTransactions(){
        System.out.println("All transactions recorded are: ");
        for(int j =0; j<i; j++){  // i is the variable with which we track the length of transactions
            System.out.println(transactions[j]);
        }
    }

    public void displayBalance(){
        System.out.println("The current balance is: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
