package test.examples;

import static org.evosuite.shaded.org.mockito.Mockito.*;

import static org.evosuite.runtime.MockitoExtension.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.CsrfPreventionFilter;

import org.evosuite.runtime.ViolatedAssumptionAnswer;



public class test_examples_CsrfPreventionFilter_TestCase3 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpServletResponse httpServletResponse0=mock(HttpServletResponse.class,new ViolatedAssumptionAnswer());
                    doReturn((String)null).when(httpServletResponse0).encodeURL(anyString());
                    CsrfPreventionFilter.CsrfResponseWrapper csrfPreventionFilter_CsrfResponseWrapper0=new CsrfPreventionFilter.CsrfResponseWrapper(httpServletResponse0,"~;JN");
                    String string0=csrfPreventionFilter_CsrfResponseWrapper0.encodeURL((String)null);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
