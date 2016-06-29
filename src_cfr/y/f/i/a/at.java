/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.d;
import y.c.q;
import y.d.m;
import y.d.o;
import y.d.t;

abstract class aT
implements o {
    protected final m a;
    protected final m b;
    protected final byte c;
    protected final d d;
    q e;
    q f;

    protected aT(d d2, m m2, m m3) {
        this.d = d2;
        this.a = m2;
        this.b = m3;
        this.c = this.g();
    }

    public byte i() {
        return this.c;
    }

    public d j() {
        return this.d;
    }

    public abstract double b();

    public abstract double c();

    public abstract double d();

    public abstract double e();

    public abstract void a(double var1);

    public Object f() {
        return null;
    }

    public abstract boolean a();

    public boolean k() {
        if (this.c == 1) return true;
        if (this.c == 2) return true;
        return false;
    }

    private byte g() {
        boolean bl2;
        boolean bl3 = Math.min(this.b.c().b, this.b.d().b) + 1.0E-6 < this.a.c().b;
        if (Math.min(this.a.c().a, this.a.d().a) + 1.0E-6 >= this.b.c().a) return 0;
        boolean bl4 = bl2 = true;
        if (bl3 && !bl2) {
            return 0;
        }
        if (bl3 && bl2) {
            return 1;
        }
        if (bl2) return 3;
        return 2;
    }
}

