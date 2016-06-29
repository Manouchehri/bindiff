/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.c.f;
import y.c.q;

class E {
    private final q a;
    private double b;
    private double c;
    private int d;
    private final f e;

    E(q q2) {
        this.a = q2;
        this.b = 0.0;
        this.c = 0.0;
        this.d = Integer.MIN_VALUE;
        this.e = new f();
    }

    q a() {
        return this.a;
    }

    static double a(E e2, double d2) {
        e2.c = d2;
        return e2.c;
    }

    static int a(E e2, int n2) {
        e2.d = n2;
        return e2.d;
    }

    static int a(E e2) {
        return e2.d;
    }

    static double b(E e2, double d2) {
        return e2.c += d2;
    }

    static double b(E e2) {
        return e2.c;
    }

    static f c(E e2) {
        return e2.e;
    }

    static double d(E e2) {
        return e2.b;
    }

    static double c(E e2, double d2) {
        return e2.b += d2;
    }
}

