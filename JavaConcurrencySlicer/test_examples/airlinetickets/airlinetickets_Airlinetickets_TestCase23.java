package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase23 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets.Num_Of_Seats_Sold=(-176);
                    Airlinetickets airlinetickets0=new Airlinetickets("","< ");
                    airlinetickets0.Num_of_tickets_issued=926;
                    airlinetickets0.go("");
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
