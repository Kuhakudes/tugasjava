import java.util.*;

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

    // ===== INHERITANCE =====
    static class EconomyTicket extends Ticket {
        public EconomyTicket(String trainName, double basePrice) {
            super(trainName, basePrice);
        }

        public double calculatePrice() {
            return getBasePrice();
        }
    }

    static class BusinessTicket extends Ticket {
        public BusinessTicket(String trainName, double basePrice) {
            super(trainName, basePrice);
        }

        public double calculatePrice() {
            return getBasePrice() + 50000;
        }
    }

    // ===== INTERFACE =====
    interface Payment {
        void pay(double amount);
    }

    static class EWalletPayment implements Payment {
        public void pay(double amount) {
            System.out.println("Pembayaran via E-Wallet: Rp " + amount);
        }
    }

    static class CreditCardPayment implements Payment {
        public void pay(double amount) {
            System.out.println("Pembayaran via Kartu Kredit: Rp " + amount);
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

    // ===== DATABASE KERETA (LIST biar bisa pakai nomor) =====
    static class TrainDatabase {

        private static List<Ticket> trains = new ArrayList<>();

        static {
            trains.add(new BusinessTicket("Argo Ngawi", 150000));
            trains.add(new EconomyTicket("Matarmaja", 100000));
            trains.add(new BusinessTicket("Bima", 200000));
        }

        public static void showTrains() {
            System.out.println("\n=== DAFTAR KERETA ===");
            for (int i = 0; i < trains.size(); i++) {
                System.out.println((i + 1) + ". " + trains.get(i).getTrainName());
            }
        }

        public static Ticket getTicketByIndex(int index) {
            if (index < 1 || index > trains.size()) {
                return null;
            }
            return trains.get(index - 1);
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

            System.out.println("\n=== DETAIL TRANSAKSI ===");
            System.out.println("Nama User   : " + user.getName());
            System.out.println("Kereta      : " + ticket.getTrainName());
            System.out.println("Total Harga : Rp " + price);

            payment.pay(price);

            System.out.println("Status      : BERHASIL");
        }
    }
}