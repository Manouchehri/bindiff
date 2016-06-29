package org.jfree.util;

public class StringUtils
{
    public static boolean startsWithIgnoreCase(final String s, final String s2) {
        return s.length() >= s2.length() && s.regionMatches(true, 0, s2, 0, s2.length());
    }
    
    public static boolean endsWithIgnoreCase(final String s, final String s2) {
        return s.length() >= s2.length() && s.regionMatches(true, s.length() - s2.length(), s2, 0, s2.length());
    }
    
    public static String getLineSeparator() {
        try {
            return System.getProperty("line.separator", "\n");
        }
        catch (Exception ex) {
            return "\n";
        }
    }
}
