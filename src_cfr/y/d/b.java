/*
 * Decompiled with CFR 0_115.
 */
package y.d;

public class b {
    public static double a(double d2, double d3) {
        double d4 = d2 + d3;
        if (d4 >= 6.283185307179586) {
            d4 -= 6.283185307179586;
        }
        if (d4 >= 0.0) return d4;
        d4 += 6.283185307179586;
        return d4;
    }
}

