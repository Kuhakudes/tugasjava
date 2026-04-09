import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();

        tugas.User user = new tugas.User(nama);

        // tampilkan kereta
        tugas.TrainDatabase.showTrains();

        System.out.print("\nPilih nomor kereta: ");
        int pilihan = input.nextInt();

        tugas.Ticket ticket = tugas.TrainDatabase.getTicketByIndex(pilihan);

        if (ticket == null) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        System.out.println("\nMetode Pembayaran:");
        System.out.println("1. E-Wallet");
        System.out.println("2. Kartu Kredit");
        System.out.print("Pilih: ");
        int metode = input.nextInt();

        tugas.Payment payment;

        if (metode == 1) {
            payment = new tugas.EWalletPayment();
        } else if (metode == 2) {
            payment = new tugas.CreditCardPayment();
        } else {
            System.out.println("Metode tidak valid!");
            return;
        }

        tugas.Transaction trx = new tugas.Transaction(user, ticket, payment);
        trx.process();

        input.close();
    }
}