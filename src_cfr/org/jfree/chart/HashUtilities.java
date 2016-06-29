/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.geom.Point2D;

public class HashUtilities {
    public static int hashCodeForPaint(Paint paint) {
        if (paint == null) {
            return 0;
        }
        int n2 = 0;
        if (!(paint instanceof GradientPaint)) return paint.hashCode();
        GradientPaint gradientPaint = (GradientPaint)paint;
        n2 = 193;
        n2 = 37 * n2 + gradientPaint.getColor1().hashCode();
        n2 = 37 * n2 + gradientPaint.getPoint1().hashCode();
        n2 = 37 * n2 + gradientPaint.getColor2().hashCode();
        return 37 * n2 + gradientPaint.getPoint2().hashCode();
    }

    public static int hashCodeForDoubleArray(double[] arrd) {
        if (arrd == null) {
            return 0;
        }
        int n2 = 193;
        int n3 = 0;
        while (n3 < arrd.length) {
            long l2 = Double.doubleToLongBits(arrd[n3]);
            n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
            ++n3;
        }
        return n2;
    }
}

