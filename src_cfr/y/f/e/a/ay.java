/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y.a.a;
import y.c.i;
import y.f.X;
import y.f.ae;
import y.f.c;
import y.f.e.a.G;
import y.f.e.a.af;
import y.f.e.a.ak;
import y.f.e.a.am;
import y.f.e.a.au;
import y.f.e.a.aw;
import y.f.e.a.ax;
import y.f.e.a.b;
import y.f.e.a.e;
import y.f.e.a.g;
import y.f.e.a.h;
import y.f.e.a.l;
import y.f.e.a.o;
import y.f.e.a.p;
import y.f.e.a.r;
import y.f.e.a.s;
import y.f.e.d;

public class ay
extends c {
    public static final Object n = d.p;
    private List p;
    private List q;
    private s r;
    private G s;
    private aw t;
    private r u;
    private List v;
    private List w;
    private List x;
    private boolean y;
    protected l o;
    private af z;
    private double A;
    private double B;
    private boolean C;
    private List D;
    private boolean E;

    public ay() {
        this(true);
    }

    public void g(boolean bl2) {
        this.E = bl2;
    }

    public ay(boolean bl2) {
        boolean bl3 = af.b;
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ak();
        this.s = new b();
        this.t = new o();
        this.u = new g(false);
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = true;
        this.A = 50.0;
        this.B = 50.0;
        this.D = new ArrayList();
        this.E = true;
        this.e(false);
        this.d(true);
        if (bl2) {
            this.a();
        }
        this.e(new au(this));
        this.n();
        if (!i.g) return;
        af.b = !bl3;
    }

    protected void a() {
        this.a(new h());
    }

    protected void n() {
        this.a(new e());
    }

    public void a(p p2) {
        p2.a(this);
        this.D.add(p2);
    }

    public List o() {
        return Collections.unmodifiableList(this.D);
    }

    @Override
    public boolean b(X x2) {
        if (x2.e() == 0) return false;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(X x2) {
        this.d(x2);
        try {
            this.a(0);
            return;
        }
        finally {
            this.e(x2);
        }
    }

    protected void d(X x2) {
        this.g(x2);
        this.z = this.h(x2);
        this.o = this.v();
        this.u();
        this.r();
        this.C();
    }

    protected int a(int n2) {
        boolean bl2 = af.b;
        this.C = true;
        do {
            if (this.q()) return n2;
            a.a();
            this.b(n2);
            this.u.a(this.o);
            this.A();
            this.p();
            ++n2;
        } while (!bl2);
        return n2;
    }

    protected void e(X x2) {
        this.B();
        this.t();
        this.f(x2);
        this.C = false;
    }

    protected void f(X x2) {
        this.z.a(x2);
        this.z = null;
    }

    protected void b(int n2) {
        this.o.a(n2);
        this.o.a(this.t.a(this.o));
    }

    protected void p() {
    }

    private void A() {
        boolean bl2 = af.b;
        int n2 = 0;
        do {
            if (n2 >= this.x.size()) return;
            am am2 = (am)this.x.get(n2);
            am2.a(this.o, this.z);
            ++n2;
        } while (!bl2);
    }

    private void B() {
        boolean bl2 = af.b;
        int n2 = 0;
        do {
            if (n2 >= this.w.size()) return;
            am am2 = (am)this.w.get(n2);
            am2.a(this.o, this.z);
            ++n2;
        } while (!bl2);
    }

    private void C() {
        boolean bl2 = af.b;
        int n2 = 0;
        do {
            if (n2 >= this.v.size()) return;
            am am2 = (am)this.v.get(n2);
            am2.a(this.o, this.z);
            ++n2;
        } while (!bl2);
    }

    protected boolean q() {
        return this.t.b(this.o);
    }

    protected void r() {
        this.u.a(this.q);
        this.u.a(this.r);
        this.u.a(this.s);
        this.u.a();
    }

    protected void g(X x2) {
        if (!this.E) return;
        ae.a(x2);
    }

    public l s() {
        return this.o;
    }

    protected void t() {
        this.z.k();
    }

    public af h(X x2) {
        return new af(x2);
    }

    protected void u() {
        boolean bl2 = af.b;
        int n2 = 0;
        do {
            if (n2 >= this.p.size()) return;
            am am2 = (am)this.p.get(n2);
            am2.a(this.o, this.z);
            ++n2;
        } while (!bl2);
    }

    protected l v() {
        return new l(this.z, this, this.y);
    }

    public double w() {
        return this.A;
    }

    public void a(double d2) {
        this.A = d2;
    }

    public double x() {
        return this.B;
    }

    public void b(double d2) {
        this.B = d2;
    }

    public void h(boolean bl2) {
        this.y = bl2;
    }

    public void a(ax ax2) {
        this.q.add(ax2);
    }

    public List y() {
        return Collections.unmodifiableList(this.q);
    }

    public void b(ax ax2) {
        int n2 = this.q.indexOf(ax2);
        if (n2 < 0) {
            return;
        }
        this.q.remove(n2);
    }

    public void a(am am2) {
        this.v.add(am2);
    }

    public void b(am am2) {
        this.w.add(am2);
    }

    public void c(am am2) {
        this.x.add(am2);
    }

    public void d(am am2) {
        int n2 = this.x.indexOf(am2);
        if (n2 < 0) {
            return;
        }
        this.x.remove(n2);
    }

    public aw z() {
        return this.t;
    }

    public void a(aw aw2) {
        this.t = aw2;
    }

    public void e(am am2) {
        this.p.add(am2);
    }
}

