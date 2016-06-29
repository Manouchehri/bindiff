/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.d;

class bD {
    private int a;
    private final d b;
    private final d c;
    private Object d;

    bD(d d2, d d3, Object object, int n2) {
        this.b = d2;
        this.c = d3;
        this.d = object;
        this.a = n2;
    }

    public d a() {
        return this.c;
    }

    public d b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public void a(int n2) {
        this.a = n2;
    }

    public boolean a(bD bD2) {
        if (this.d.equals(bD2.d)) return false;
        return true;
    }

    static Object b(bD bD2) {
        return bD2.d;
    }

    static d c(bD bD2) {
        return bD2.b;
    }

    static d d(bD bD2) {
        return bD2.c;
    }
}

