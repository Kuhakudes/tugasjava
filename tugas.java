
public class tugas {

    // ===== ABSTRACT CLASS =====
    static abstract class Ticket {

        private String trainName;
        private double basePrice;

        public Ticket(String trainName, double basePrice) {
            this.trainName = trainName;
            this.basePrice = basePrice;
        }

        public String getTrainName() {
            return trainName;
        }

        public double getBasePrice() {
            return basePrice;
        }

        public abstract double calculatePrice();
    }

    // ===== INHERITANCE + POLYMORPHISM =====
    static class EconomyTicket extends Ticket {

        public EconomyTicket(String trainName, double basePrice) {
            super(trainName, basePrice);
        }

        @Override
        public double calculatePrice() {
            return getBasePrice();
        }
    }

    static class BusinessTicket extends Ticket {

        public BusinessTicket(String trainName, double basePrice) {
            super(trainName, basePrice);
        }

        @Override
        public double calculatePrice() {
            return getBasePrice() + 50000;
        }
    }

    // ===== INTERFACE =====
    interface Payment {

        void pay(double amount);
    }

    // ===== IMPLEMENTASI =====
    static class CreditCardPayment implements Payment {

        public void pay(double amount) {
            System.out.println("Pembayaran via Kartu Kredit: Rp " + amount);
        }
    }

    static class EWalletPayment implements Payment {

        public void pay(double amount) {
            System.out.println("Pembayaran via E-Wallet: Rp " + amount);
        }
    }

    // ===== USER =====
    static class User {

        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // ===== TRANSACTION =====
    static class Transaction {

        private User user;
        private Ticket ticket;
        private Payment payment;

        public Transaction(User user, Ticket ticket, Payment payment) {
            this.user = user;
            this.ticket = ticket;
            this.payment = payment;
        }

        public void process() {
            double price = ticket.calculatePrice();

            System.out.println("=== DETAIL TRANSAKSI ===");
            System.out.println("Nama User   : " + user.getName());
            System.out.println("Kereta      : " + ticket.getTrainName());
            System.out.println("Total Harga : Rp " + price);

            payment.pay(price);

            System.out.println("Status      : BERHASIL");
        }
    }

}
