/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import y.f.f.b.h;
import y.f.h.E;

public class i
extends E {
    private int a;
    private String b;
    private int c;
    private double d;
    private int e;
    private int f;
    private final h g;

    public i(h h2) {
        this.g = h2;
        this.c = Integer.MIN_VALUE;
        this.d = 1.0;
        this.e = 0;
        this.f = 0;
    }

    public void a(int n2) {
        this.a = n2;
    }

    public int a() {
        return this.a;
    }

    public void a(String string) {
        this.b = string;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void b(int n2) {
        this.c = n2;
    }

    public double d() {
        return this.d;
    }

    public void a(double d2) {
        this.d = d2;
    }

    static int a(i i2, int n2) {
        i2.e = n2;
        return i2.e;
    }

    static int b(i i2, int n2) {
        i2.f = n2;
        return i2.f;
    }

    static int a(i i2) {
        return i2.e;
    }

    static int b(i i2) {
        return i2.f;
    }
}

