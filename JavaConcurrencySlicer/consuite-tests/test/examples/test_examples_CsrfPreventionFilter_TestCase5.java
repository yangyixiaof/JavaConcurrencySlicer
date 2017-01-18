package test.examples;

import static org.evosuite.shaded.org.mockito.Mockito.*;

import static org.evosuite.runtime.MockitoExtension.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.CsrfPreventionFilter;

import org.evosuite.runtime.ViolatedAssumptionAnswer;



public class test_examples_CsrfPreventionFilter_TestCase5 {

    public static void main(String[] args) throws Exception {
        final CsrfPreventionFilter csrfPreventionFilter0=new CsrfPreventionFilter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    csrfPreventionFilter0.setNonceCacheSize((-938));
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    csrfPreventionFilter0.setNonceCacheSize(240);
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
