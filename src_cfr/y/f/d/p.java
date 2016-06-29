/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import y.f.d.o;

class p {
    private byte a;
    private boolean b;
    private double c;
    private int d;
    private int e;

    private p(byte by2, boolean bl2) {
        this.a = by2;
        this.b = bl2;
    }

    p(byte by2, boolean bl2, o o2) {
        this(by2, bl2);
    }

    static int a(p p2, int n2) {
        p2.e = n2;
        return p2.e;
    }

    static double a(p p2, double d2) {
        p2.c = d2;
        return p2.c;
    }

    static int b(p p2, int n2) {
        p2.d = n2;
        return p2.d;
    }

    static int a(p p2) {
        return p2.e;
    }

    static byte b(p p2) {
        return p2.a;
    }

    static boolean c(p p2) {
        return p2.b;
    }

    static double d(p p2) {
        return p2.c;
    }

    static int e(p p2) {
        return p2.d;
    }
}

