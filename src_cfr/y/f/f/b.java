/*
 * Decompiled with CFR 0_115.
 */
package y.f.f;

import y.f.V;
import y.f.X;
import y.f.ad;
import y.f.e;
import y.f.f.a.a;
import y.f.f.c;

public class b
extends y.f.c {
    public static final Object n = c.n;
    private a o;
    private boolean p;
    private boolean q;
    private y.f.f.a r;

    protected y.f.f.a a() {
        return new y.f.f.a();
    }

    public y.f.f.a n() {
        if (this.r != null) return this.r;
        this.r = this.a();
        return this.r;
    }

    public boolean o() {
        ad ad2 = this.b();
        if (ad2 instanceof V) {
            return ((V)ad2).d();
        }
        if (!this.q) return false;
        throw new IllegalStateException("No LabelLayoutTranslator registered");
    }

    public boolean p() {
        ad ad2 = this.b();
        if (!(ad2 instanceof V)) {
            if (!this.p) return false;
            throw new IllegalStateException("No LabelLayoutTranslator registered");
        }
        if (!((V)ad2).e()) return false;
        if (!((V)ad2).c()) return false;
        return true;
    }

    @Override
    public void d(ad ad2) {
        super.d(ad2);
    }

    public int q() {
        return this.o.a();
    }

    @Override
    protected boolean b(X x2) {
        return this.o.b(x2);
    }

    @Override
    protected void a(X x2) {
        this.o.a(this.n());
        this.o.d(this.e());
        this.o.a(x2);
    }

    @Override
    public void c(X x2) {
        if (this.e() instanceof e) {
            e e2 = (e)this.e();
            e2.a(this.q());
            e2.b(this.q());
            e2.a(this.o() || this.p());
        }
        super.c(x2);
    }
}

