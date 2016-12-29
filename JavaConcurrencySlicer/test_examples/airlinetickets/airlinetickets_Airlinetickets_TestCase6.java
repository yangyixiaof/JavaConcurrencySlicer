package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase6 {

    public static void main(String[] args) throws Exception {
        Airlinetickets.Num_Of_Seats_Sold=(-1862);
        final String[] stringArray0=new String[9];
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets.main(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets.main(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
