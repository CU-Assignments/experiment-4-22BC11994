class TicketBookingSystem {
    private int availableSeats;

    public TicketBookingSystem(int seats) {
        this.availableSeats = seats;
    }

    public synchronized void bookTicket(String customerType) {
        if (availableSeats > 0) {
            System.out.println(customerType + " is booking a seat. Seats left: " + (availableSeats - 1));
            availableSeats--;
            System.out.println("Booking successful for " + customerType + ". Seats left: " + availableSeats);
        } else {
            System.out.println("No available seats for " + customerType);
        }
    }
}

class Customer extends Thread {
    private TicketBookingSystem ticketBookingSystem;
    private String customerType;

    public Customer(TicketBookingSystem ticketBookingSystem, String customerType) {
        this.ticketBookingSystem = ticketBookingSystem;
        this.customerType = customerType;
    }

    @Override
    public void run() {
        ticketBookingSystem.bookTicket(customerType);
    }
}

public class TicketBookingMain {

    public static void main(String[] args) {
   
        TicketBookingSystem ticketBookingSystem = new TicketBookingSystem(5);

        Customer customer1 = new Customer(ticketBookingSystem, "VIP Customer 1");
        Customer customer2 = new Customer(ticketBookingSystem, "VIP Customer 2");
        Customer customer3 = new Customer(ticketBookingSystem, "Regular Customer 1");
        Customer customer4 = new Customer(ticketBookingSystem, "Regular Customer 2");
        Customer customer5 = new Customer(ticketBookingSystem, "Regular Customer 3");
        Customer customer6 = new Customer(ticketBookingSystem, "VIP Customer 3");

        customer1.setPriority(Thread.MAX_PRIORITY);  
        customer2.setPriority(Thread.MAX_PRIORITY); 
        customer3.setPriority(Thread.NORM_PRIORITY); 
        customer4.setPriority(Thread.NORM_PRIORITY); 
        customer5.setPriority(Thread.NORM_PRIORITY); 
        customer6.setPriority(Thread.MAX_PRIORITY);  

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
        customer6.start();

        try {
         
            customer1.join();
            customer2.join();
            customer3.join();
            customer4.join();
            customer5.join();
            customer6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
