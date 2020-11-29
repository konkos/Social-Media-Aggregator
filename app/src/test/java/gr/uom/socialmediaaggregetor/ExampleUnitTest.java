package gr.uom.socialmediaaggregetor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private String url1 = "http://twitter.com/search?q=%CE%A0%CE%B1%CF%81%CE%B9%CF%83%CE%B9";
    private String url2 = "http://twitter.com/search?q=%CF%85%CF%80%CE%B5%CF%81%CE%BF%CF%87%CE%B7";
    private String url3 = "http://twitter.com/search?q=%23kalytera";
    private String charSequence1,charSequence2,charSequence3;

    @Before
    public void setUp() throws Exception {
        charSequence1 = url1.subSequence(28, url1.length()).toString();
        charSequence2 = url2.subSequence(28, url2.length()).toString();

        charSequence3 = url3.subSequence(28, url3.length()).toString();
    }


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void correctSubsequenceFromUrl(){
        assertEquals(charSequence1,"%CE%A0%CE%B1%CF%81%CE%B9%CF%83%CE%B9");
        assertEquals(charSequence2,"%CF%85%CF%80%CE%B5%CF%81%CE%BF%CF%87%CE%B7");
        assertEquals(charSequence3,"%23kalytera");
    }
}