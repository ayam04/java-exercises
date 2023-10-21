public class bank2 {
    public interface Account{
        void display();
        public int balance;
        public String number;
    }

    public static class SavingsAccount implements Account{
        int balance = Account.balance;
        


    }
}
