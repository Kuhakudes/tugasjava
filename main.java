import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine();

            tugas.User user = new tugas.User(nama);

            tugas.TrainDatabase.showTrains();

            System.out.print("\nPilih nomor kereta: ");
            int pilihan = input.nextInt();

            tugas.Ticket ticket = tugas.TrainDatabase.getTicketByIndex(pilihan);

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
                throw new IllegalArgumentException("Metode pembayaran tidak valid!");
            }

            tugas.Transaction trx = new tugas.Transaction(user, ticket, payment);
            trx.process();

        } catch (InputMismatchException e) {

            System.out.println("\n⚠️ Input harus angka!");

        } catch (IllegalArgumentException e) {

            System.out.println("\n⚠️ " + e.getMessage());

        } catch (Exception e) {

            System.out.println("\n⚠️ Error: " + e.getMessage());

        } finally {

            input.close();
            System.out.println("\nProgram selesai.");
        }
    }
}