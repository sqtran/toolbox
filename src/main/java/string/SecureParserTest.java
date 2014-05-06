package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecureParserTest {

    private static Logger logger = LoggerFactory.getLogger(SecureParserTest.class);

    private static String testdata = "[SECURE] [   WARN   ] -  [http-8443-10:AuthenticationManagerImplOverride@95] - AuthenticationHandler: [username: steve]";

    private static String testdata2 = "[SECURE] [INFO ] -  [http-8443-10:AuthenticationManagerImplOverride@95] - AuthenticationHandler: [username: steve]";

    private static String testdata3 = "[SECURE] [FATAL ] -  [http-8443-10:AuthenticationManagerImplOverride@95] - AuthenticationHandler: [username: steve]";

    private static String testdata4 = "[SECURE] [FATAL] -  [http-8443-10:AuthenticationManagerImplOverride@95] - AuthenticationHandler: [username: steve]";

    public static void main(String ... args) {

        String log4jLevels = "[ ]*(ALL|DEBUG|INFO|WARN|ERROR|FATAL)[ ]*";
        String loggingLevelRegex = "\\[" + log4jLevels + "\\]";

        Pattern p = Pattern.compile(loggingLevelRegex);
        System.out.println("pattern = " + p.toString());

        Matcher m = p.matcher(testdata);
        String results = m.find() ? stripFirstAndLastCharacter(m.group()).trim() : "???????????????";
        System.out.println("log level = [" + results + "]");

        m = p.matcher(testdata2);
        results = m.find() ? stripFirstAndLastCharacter(m.group()).trim() : "???????????????";
        System.out.println("log level = [" + results + "]");

        m = p.matcher(testdata3);
        results = m.find() ? stripFirstAndLastCharacter(m.group()).trim() : "???????????????";
        System.out.println("log level = [" + results + "]");

        m = p.matcher(testdata4);
        results = m.find() ? stripFirstAndLastCharacter(m.group()).trim() : "???????????????";
        System.out.println("log level = [" + results + "]");

        logger.info("hello world info");
        logger.debug("hello world debug");
        logger.warn("hello world warn");
        logger.error("hello world error");
    }

    public static String stripFirstAndLastCharacter(String token) {
        return token.substring(1, token.length() - 1);
    }

}