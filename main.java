
public class main {

    public static void main(String[] args) {

        tugas.User user = new tugas.User("opik");

        tugas.Ticket ticket = new tugas.BusinessTicket("Argo ngawi", 150000);

        tugas.Payment payment = new tugas.EWalletPayment();

        tugas.Transaction trx = new tugas.Transaction(user, ticket, payment);
        trx.process();
    }
}
