package oncall.util;

import java.util.regex.Pattern;

public class Parser {
    public static String[] splitComma(String allocatedSchedule) {
        return allocatedSchedule.split(Pattern.quote(","));
    }
}
