package org.jfree.chart;

import java.awt.*;

public class HashUtilities
{
    public static int hashCodeForPaint(final Paint paint) {
        if (paint == null) {
            return 0;
        }
        int hashCode;
        if (paint instanceof GradientPaint) {
            final GradientPaint gradientPaint = (GradientPaint)paint;
            hashCode = 37 * (37 * (37 * (37 * 193 + gradientPaint.getColor1().hashCode()) + gradientPaint.getPoint1().hashCode()) + gradientPaint.getColor2().hashCode()) + gradientPaint.getPoint2().hashCode();
        }
        else {
            hashCode = paint.hashCode();
        }
        return hashCode;
    }
    
    public static int hashCodeForDoubleArray(final double[] array) {
        if (array == null) {
            return 0;
        }
        int n = 193;
        for (int i = 0; i < array.length; ++i) {
            final long doubleToLongBits = Double.doubleToLongBits(array[i]);
            n = 29 * n + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        }
        return n;
    }
}
