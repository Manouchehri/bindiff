/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import java.util.ArrayList;
import java.util.List;
import y.c.A;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.am;
import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.ag;
import y.f.e.a.ah;
import y.f.e.a.ao;
import y.f.e.a.ap;
import y.f.e.a.aq;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.m;
import y.f.e.a.w;

public class af
implements w {
    protected int a;
    private int c;
    private int d;
    private a e = new Z();
    private a f = new Z();
    private a g = new Z();
    private double h;
    private double i;
    private double j;
    private X k;
    private A l;
    private h m;
    private List n = new ArrayList();
    public static boolean b;

    public af(X x2) {
        this.k = x2;
        this.l = x2.t();
        this.m = x2.u();
        this.m();
    }

    void a(m m2, double d2, double d3, double d4, double d5, double d6, double d7) {
        boolean bl2 = b;
        if (this.n.isEmpty()) {
            return;
        }
        ap ap2 = new ap(this, m2, d2, d3, d4, d5, d6, d7);
        ao[] arrao = new ao[this.n.size()];
        this.n.toArray(arrao);
        int n2 = 0;
        do {
            if (n2 >= arrao.length) return;
            arrao[n2].a(ap2);
            ++n2;
        } while (!bl2);
    }

    private void b(X x2) {
        boolean bl2 = b;
        x x3 = x2.o();
        while (x3.f()) {
            q q2 = x3.e();
            this.l.a((Object)q2, this.b(q2));
            x3.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.h = (double)this.c * 0.9;
        this.i = 0.81 * (double)this.c;
        this.l();
    }

    private void c(X x2) {
        boolean bl2 = b;
        e e2 = x2.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            this.m.a((Object)d2, this.c(d2));
            e2.g();
        } while (!bl2);
    }

    private ah c(d d2) {
        return new ah(this, d2);
    }

    protected ag b(q q2) {
        return new ag(this, q2);
    }

    public int g() {
        return this.a;
    }

    @Override
    public double d() {
        return c.a(this.k.e(), this.h, this.i);
    }

    @Override
    public double a() {
        return c.a(this.k.e(), this.f.d(), this.g.d());
    }

    @Override
    public double b() {
        return c.a(this.k.e(), this.f.e(), this.g.e());
    }

    private void l() {
        this.j = this.c > 0 ? this.h / (double)this.c : 0.0;
    }

    @Override
    public k e() {
        this.e.a(this.h());
        this.e.b(this.i());
        this.e.c(this.j());
        return this.e;
    }

    public double h() {
        if (this.c <= 0) return 0.0;
        double d2 = this.f.d() / (double)this.c;
        return d2;
    }

    public double i() {
        if (this.c <= 0) return 0.0;
        double d2 = this.f.e() / (double)this.c;
        return d2;
    }

    public double j() {
        if (this.c <= 0) return 0.0;
        double d2 = this.f.f() / (double)this.c;
        return d2;
    }

    @Override
    public m a(q q2) {
        return (m)this.l.b(q2);
    }

    public ag c(q q2) {
        return (ag)this.l.b(q2);
    }

    private void m() {
        this.d = this.k.h();
        this.c = this.k.f();
        this.b(this.k);
        this.c(this.k);
    }

    public void k() {
        boolean bl2 = b;
        x x2 = this.k.o();
        do {
            if (!x2.f()) return;
            q q2 = x2.e();
            ag ag2 = this.c(q2);
            am am2 = this.k.h(q2);
            am2.setLocation(ag2.b() - am2.getWidth() / 2.0, ag2.c() - am2.getHeight() / 2.0);
            x2.g();
        } while (!bl2);
    }

    @Override
    public X f() {
        return this.k;
    }

    @Override
    public double c() {
        return this.j;
    }

    @Override
    public aq a(d d2) {
        return (aq)this.m.b(d2);
    }

    public ah b(d d2) {
        return (ah)this.m.b(d2);
    }

    public void a(X x2) {
        if (x2 != this.k) {
            throw new IllegalStateException();
        }
        x2.a(this.l);
        this.l = null;
        x2.a(this.m);
        this.m = null;
        this.k = null;
    }

    static X a(af af2) {
        return af2.k;
    }

    static a b(af af2) {
        return af2.f;
    }

    static a c(af af2) {
        return af2.g;
    }

    static double a(af af2, double d2) {
        return af2.h += d2;
    }

    static double b(af af2, double d2) {
        return af2.i += d2;
    }

    static void d(af af2) {
        af2.l();
    }
}

