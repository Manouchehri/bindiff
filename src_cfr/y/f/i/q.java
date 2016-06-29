/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.D;
import y.c.d;
import y.c.i;
import y.c.p;
import y.c.q;
import y.d.m;
import y.d.t;
import y.f.X;
import y.f.i.R;

class Q
extends R {
    private m a;
    private d b;
    private boolean c;
    private int d;
    private final boolean e;
    private final boolean f;

    public Q(byte by2, m m2, d d2, boolean bl2, int n2, boolean bl3, boolean bl4) {
        super(by2, m2.c().a());
        this.a = m2;
        this.b = d2;
        this.c = bl2;
        this.d = n2;
        this.e = bl3;
        this.f = bl4;
    }

    public m a() {
        return this.a;
    }

    private boolean l() {
        if (this.g() <= 0) return false;
        return true;
    }

    public boolean b() {
        D d2 = ((X)this.e().a()).m(this.b);
        if (this.l()) {
            p p2 = d2.b(this.g() - 1);
            t t2 = (t)p2.c();
            p p3 = d2.b(this.g());
            t t3 = (t)p3.c();
            if (t2.a() > t3.a()) return false;
            return true;
        }
        if (!this.m()) return true;
        if (this.c()) return true;
        return false;
    }

    private boolean m() {
        D d2 = ((X)this.e().a()).m(this.b);
        if (this.g() >= d2.size() - 2) return false;
        return true;
    }

    public boolean c() {
        D d2 = ((X)this.e().a()).m(this.b);
        if (this.m()) {
            p p2 = d2.b(this.g() + 1);
            t t2 = (t)p2.c();
            p p3 = d2.b(this.g() + 2);
            t t3 = (t)p3.c();
            if (t2.a() > t3.a()) return true;
            return false;
        }
        if (!this.l()) return true;
        if (this.b()) return true;
        return false;
    }

    public boolean d() {
        if (!this.l()) return true;
        if (!this.m()) {
            return true;
        }
        if (!this.l()) return false;
        if (!this.m()) return false;
        if (this.b() == this.c()) return false;
        return true;
    }

    public d e() {
        return this.b;
    }

    public boolean f() {
        return this.c;
    }

    public int g() {
        return this.d;
    }

    public String toString() {
        String string;
        if (this.f()) {
            string = "locked";
            return new StringBuffer().append("Edge: ").append(this.b.c()).append(" -> ").append(this.b.d()).append(", ").append(string).append(" segment ").append(this.g()).append(", ").append(this.a.toString()).toString();
        }
        string = "unlocked";
        return new StringBuffer().append("Edge: ").append(this.b.c()).append(" -> ").append(this.b.d()).append(", ").append(string).append(" segment ").append(this.g()).append(", ").append(this.a.toString()).toString();
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return this.f;
    }

    static d a(Q q2) {
        return q2.b;
    }
}

