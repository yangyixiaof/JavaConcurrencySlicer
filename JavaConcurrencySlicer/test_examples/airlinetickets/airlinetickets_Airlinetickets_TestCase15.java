package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase15 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets.Num_Of_Seats_Sold=(-1875);
                    Airlinetickets airlinetickets0=new Airlinetickets("V';`W","");
                    airlinetickets0.Num_of_tickets_issued=5000;
                    airlinetickets0.go("s");
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
