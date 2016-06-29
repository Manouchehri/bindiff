package org.jfree.chart.axis;

import java.text.*;

public class CompassFormat extends NumberFormat
{
    private static final String N = "N";
    private static final String E = "E";
    private static final String S = "S";
    private static final String W = "W";
    public static final String[] DIRECTIONS;
    
    public String getDirectionCode(double n) {
        n %= 360.0;
        if (n < 0.0) {
            n += 360.0;
        }
        return CompassFormat.DIRECTIONS[((int)Math.floor(n / 11.25) + 1) / 2];
    }
    
    public StringBuffer format(final double n, final StringBuffer sb, final FieldPosition fieldPosition) {
        return sb.append(this.getDirectionCode(n));
    }
    
    public StringBuffer format(final long n, final StringBuffer sb, final FieldPosition fieldPosition) {
        return sb.append(this.getDirectionCode(n));
    }
    
    public Number parse(final String s, final ParsePosition parsePosition) {
        return null;
    }
    
    static {
        DIRECTIONS = new String[] { "N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N" };
    }
}
