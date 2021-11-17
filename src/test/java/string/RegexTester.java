package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexTester {

    @Test
    public void testRegexPatterns() {

        String regex = "$^|[a-z0-9]{2}";

        Assertions.assertTrue("".matches(regex));
        Assertions.assertTrue("ab".matches(regex));
        Assertions.assertTrue("10".matches(regex));

        Assertions.assertFalse("abc".matches(regex));
        Assertions.assertFalse("1".matches(regex));

        
        regex = "[a-z0-9]{2}";
        Assertions.assertTrue("ab".matches(regex));
        Assertions.assertTrue("10".matches(regex));

        Assertions.assertFalse("".matches(regex));
        Assertions.assertFalse("abc".matches(regex));
        Assertions.assertFalse("1".matches(regex));
    }

}