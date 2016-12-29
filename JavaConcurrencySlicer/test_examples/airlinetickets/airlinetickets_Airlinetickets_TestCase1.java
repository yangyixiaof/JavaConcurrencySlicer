package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase1 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets.Num_Of_Seats_Sold=(-3410);
                    String[] stringArray0=new String[3];
                    Airlinetickets.main(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
