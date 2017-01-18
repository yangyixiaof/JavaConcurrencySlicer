package test.examples;

import static org.evosuite.shaded.org.mockito.Mockito.*;

import static org.evosuite.runtime.MockitoExtension.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.CsrfPreventionFilter;

import org.evosuite.runtime.ViolatedAssumptionAnswer;



public class test_examples_CsrfPreventionFilter_TestCase1 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CsrfPreventionFilter.LruCache<Object> csrfPreventionFilter_LruCache0=new CsrfPreventionFilter.LruCache<Object>(0);
                    CsrfPreventionFilter.LruCache<String> csrfPreventionFilter_LruCache1=new CsrfPreventionFilter.LruCache<String>(0);
                    boolean boolean0=csrfPreventionFilter_LruCache0.contains(csrfPreventionFilter_LruCache1);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
