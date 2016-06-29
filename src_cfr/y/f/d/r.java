/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import y.c.D;

abstract class r {
    protected D b;
    protected int c;
    private boolean a;
    private int d;

    public r(int n2) {
        this.d = n2;
        this.a = false;
    }

    public D b() {
        return this.b;
    }

    public boolean c() {
        return this.a;
    }

    public void a(boolean bl2) {
        this.a = bl2;
    }

    void a(D d2) {
        this.b = d2;
    }

    public abstract void a();
}

