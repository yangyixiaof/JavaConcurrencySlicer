package test.examples;

import static org.evosuite.shaded.org.mockito.Mockito.*;

import static org.evosuite.runtime.MockitoExtension.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.CsrfPreventionFilter;

import org.evosuite.runtime.ViolatedAssumptionAnswer;



public class test_examples_CsrfPreventionFilter_TestCase2 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CsrfPreventionFilter csrfPreventionFilter0=new CsrfPreventionFilter();
                    csrfPreventionFilter0.setEntryPoints("4L,=*uy");
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
