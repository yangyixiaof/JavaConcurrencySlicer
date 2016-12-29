package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase13 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets.Num_Of_Seats_Sold=0;
                    Airlinetickets.Num_Of_Seats_Sold=(-295);
                    Airlinetickets airlinetickets0=new Airlinetickets("[(>BV nnW;HRFS8J%]w","[(>BV nnW;HRFS8J%]w");
                    airlinetickets0.Num_of_tickets_issued=(-295);
                    airlinetickets0.go("-N");
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
