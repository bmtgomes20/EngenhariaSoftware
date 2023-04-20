package group_b;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testInt() {
    	assertEquals(3, App.soma(1,2));
    	//assertEquals(3, App.soma(1,2)); o numero 3 é a solução que esperamos, e a "App.soma(1,2)" é a função que queremos testar
    	//existem inumeros asserts temos que optar consoante a função que queremos testar
    	//quando damos "run" na seta do canto superior esquerdo, clicamos na função que pretendemos ver se deu certo neste caso
    	//seria a função "testInt" e caso esta verde quer dizer que está a funcionar
    	
    }
}
