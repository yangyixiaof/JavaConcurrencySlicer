package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase19 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets.Num_Of_Seats_Sold=(-3410);
                    Airlinetickets airlinetickets0=new Airlinetickets("U.RC(USKdJk","4H,[l#ymyI0?D2#P");
                    Airlinetickets.Num_Of_Seats_Sold=1;
                    airlinetickets0.checkResult("","YL4");
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
