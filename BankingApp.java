import java.util.*;

class Account {
    private int accountNumber;
    private String name, email, phone;
    private double balance;

    public Account(int accNum, String name, double balance, String email, String phone) {
        this.accountNumber = accNum;
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.phone = phone;
    }

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
        System.out.println("Balance: " + balance);
    }

    public void withdraw(double amt) {
        if (amt > 0 && balance >= amt) balance -= amt;
        else System.out.println("Invalid/Insufficient funds");
        System.out.println("Balance: " + balance);
    }

    public void show() {
        System.out.println("Acc#: " + accountNumber + " | Name: " + name + " | Bal: " + balance);
    }

    public void update(String email, String phone) {
        this.email = email; this.phone = phone;
        System.out.println("Contact updated.");
    }

    public int getAccountNumber() { return accountNumber; }
}

public class BankingApp {
    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextAcc = 1000;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Show 5.Update 6.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> create();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> show();
                case 5 -> update();
                case 6 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void create() {
        sc.nextLine();
        System.out.print("Name: "); String n = sc.nextLine();
        System.out.print("Deposit: "); double d = sc.nextDouble(); sc.nextLine();
        System.out.print("Email: "); String e = sc.nextLine();
        System.out.print("Phone: "); String p = sc.nextLine();
        accounts.add(new Account(nextAcc++, n, d, e, p));
        System.out.println("Account created!");
    }

    static Account find(int num) {
        for (Account a : accounts) if (a.getAccountNumber() == num) return a;
        return null;
    }

    static void deposit() {
        System.out.print("Acc#: "); int n = sc.nextInt();
        Account a = find(n); if (a != null) { System.out.print("Amt: "); a.deposit(sc.nextDouble()); }
        else System.out.println("Not found");
    }

    static void withdraw() {
        System.out.print("Acc#: "); int n = sc.nextInt();
        Account a = find(n); if (a != null) { System.out.print("Amt: "); a.withdraw(sc.nextDouble()); }
        else System.out.println("Not found");
    }

    static void show() {
        System.out.print("Acc#: "); int n = sc.nextInt();
        Account a = find(n); if (a != null) a.show(); else System.out.println("Not found");
    }

    static void update() {
        System.out.print("Acc#: "); int n = sc.nextInt(); sc.nextLine();
        Account a = find(n);
        if (a != null) {
            System.out.print("New Email: "); String e = sc.nextLine();
            System.out.print("New Phone: "); String p = sc.nextLine();
            a.update(e, p);
        } else System.out.println("Not found");
    }
}
