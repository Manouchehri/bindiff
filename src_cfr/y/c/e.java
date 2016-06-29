/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import y.c.C;
import y.c.D;
import y.c.p;

public class E
implements C {
    p a;
    private final D b;

    protected E(D d2) {
        this.b = d2;
        this.i();
    }

    @Override
    public boolean f() {
        if (this.a == null) return false;
        return true;
    }

    @Override
    public void g() {
        this.a = this.a.a;
    }

    @Override
    public void h() {
        this.a = this.a.b;
    }

    @Override
    public void i() {
        this.a = this.b.b;
    }

    @Override
    public void j() {
        this.a = this.b.c;
    }

    @Override
    public int k() {
        return this.b.a;
    }

    @Override
    public Object d() {
        return this.a.c;
    }
}

