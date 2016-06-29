/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Arrays;
import y.f.X;
import y.f.c.a.bk;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ad;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.x;
import y.f.y;

class aG
extends ab {
    private int b;
    private boolean c;
    private bk d;

    aG() {
    }

    @Override
    protected void c() {
        super.c();
        this.d = null;
    }

    @Override
    protected void a(Z z2) {
        super.a(z2);
        this.d = bk.c(z2.a());
    }

    @Override
    protected void b(aa aa2) {
        super.b(aa2);
        this.b = this.b().d().f().n();
        this.c = this.d != null && this.b > 0;
    }

    @Override
    double[] a(f f2, R r2, P[] arrp, v[] arrv, double[] arrd) {
        double d2 = 0.0;
        if (this.c && f2.d() != null && this.a(f2, r2)) {
            d2 = this.b;
        }
        this.b("punish reentering partition grid cells", d2, false);
        double[] arrd2 = new double[arrp.length];
        if (d2 <= 0.0) return arrd2;
        Arrays.fill(arrd2, d2);
        return arrd2;
    }

    private boolean a(f f2, R r2) {
        R r3 = this.b().a(0);
        int n2 = this.a(r3);
        int n3 = this.b(r3);
        R r4 = this.b().b(0);
        int n4 = this.a(r4);
        int n5 = this.b(r4);
        R r5 = f2.a();
        if (n2 < n4) {
            if (this.a(r2) < this.a(r5)) return true;
        }
        if (n2 > n4) {
            if (this.a(r2) > this.a(r5)) return true;
        }
        if (n2 == n4 && this.a(r5) > n4) {
            if (this.a(r5) > this.a(r2)) return true;
        }
        if (n2 == n4 && this.a(r5) < n4) {
            if (this.a(r5) < this.a(r2)) return true;
        }
        if (n3 < n5) {
            if (this.b(r2) < this.b(r5)) return true;
        }
        if (n3 > n5) {
            if (this.b(r2) > this.b(r5)) return true;
        }
        if (n3 == n5 && this.b(r5) > n5) {
            if (this.b(r5) > this.b(r2)) return true;
        }
        if (n3 != n5) return false;
        if (this.b(r5) >= n5) return false;
        if (this.b(r5) >= this.b(r2)) return false;
        return true;
    }

    private int a(R r2) {
        Integer n2 = (Integer)r2.a(T.f);
        if (n2 == null) return -1;
        int n3 = n2;
        return n3;
    }

    private int b(R r2) {
        Integer n2 = (Integer)r2.a(T.g);
        if (n2 == null) return -1;
        int n3 = n2;
        return n3;
    }
}

