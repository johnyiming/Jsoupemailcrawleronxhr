package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void whenMatchesTenDigitsNumberWhitespacesDotHyphen_thenCorrect() {
        List phoneNumbers = new ArrayList();
        phoneNumbers.add("633256521");
        phoneNumbers.add("6329654521");
        phoneNumbers.add("985632156");

        String regex = "^\\d{9}$";

        Pattern pattern = Pattern.compile(regex);

        for(Object email : phoneNumbers)
        {
            Matcher matcher = pattern.matcher((CharSequence) email);
            System.out.println(email +" : "+ matcher.matches());
        }
    }

}


