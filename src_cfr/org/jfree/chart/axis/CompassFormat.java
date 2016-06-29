/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class CompassFormat
extends NumberFormat {
    private static final String N = "N";
    private static final String E = "E";
    private static final String S = "S";
    private static final String W = "W";
    public static final String[] DIRECTIONS = new String[]{"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N"};

    public String getDirectionCode(double d2) {
        if ((d2 %= 360.0) < 0.0) {
            d2 += 360.0;
        }
        int n2 = ((int)Math.floor(d2 / 11.25) + 1) / 2;
        return DIRECTIONS[n2];
    }

    @Override
    public StringBuffer format(double d2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return stringBuffer.append(this.getDirectionCode(d2));
    }

    @Override
    public StringBuffer format(long l2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return stringBuffer.append(this.getDirectionCode(l2));
    }

    @Override
    public Number parse(String string, ParsePosition parsePosition) {
        return null;
    }
}

