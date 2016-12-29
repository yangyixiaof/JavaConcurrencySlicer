package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase11 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets.Num_Of_Seats_Sold=0;
                    Airlinetickets.Num_Of_Seats_Sold=(-295);
                    String[] stringArray0=new String[2];
                    stringArray0[0]="XY@}8X}t*UEVm+zVF1";
                    stringArray0[1]="[(>BV nnW;HRFS8J%]w";
                    Airlinetickets.main(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
