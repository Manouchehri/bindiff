/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Iterator;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.q;
import y.d.t;
import y.d.y;
import y.h.aB;
import y.h.bu;
import y.h.eR;
import y.h.eV;
import y.h.eW;
import y.h.eX;
import y.h.eY;
import y.h.eZ;
import y.h.fM;
import y.h.fO;
import y.h.fP;
import y.h.fa;
import y.h.fb;
import y.h.fc;
import y.h.fd;
import y.h.fe;
import y.h.fj;
import y.h.fm;
import y.h.gd;
import y.h.gq;
import y.h.hk;

public class eU {
    private static final eY f = new eY(null);
    private static final gq g = new gq();
    fj a = null;
    fP b;
    fe c;
    boolean d;
    Object e;

    public eU() {
        this.b = fm.a;
        this.c = eU.j().a();
        this.d = false;
        this.e = null;
    }

    public eU(eU eU2) {
        this.b = eU2.b;
        this.c = eU2.c;
        this.d = eU2.d;
        if (this.c.g == null) {
            this.e = eU2.e;
            if (!fj.z) return;
        }
        this.e = this.c.g.a(eU2, eU2.e, this);
    }

    public eU a() {
        return this.a(this);
    }

    public eU a(eU eU2) {
        return new eU(eU2);
    }

    protected void a(fj fj2) {
        this.a = fj2;
    }

    public fj b() {
        return this.a;
    }

    public void a(aB aB2) {
        eU.a(this, aB2);
    }

    public static void a(eU eU2, aB aB2) {
        Object object;
        boolean bl2 = fj.z;
        if (eU2 == null) {
            aB2.vb = null;
            if (!bl2) return;
        }
        if ((object = eU.d(eU2)) == null) throw new IllegalArgumentException("NodePort not in NodeRealizer.");
        aB2.vb = object;
        aB2.setSourcePoint(eU.b(eU2));
        if (!bl2) return;
        throw new IllegalArgumentException("NodePort not in NodeRealizer.");
    }

    public static eU b(aB aB2) {
        return eU.a(aB2, true);
    }

    public void c(aB aB2) {
        eU.b(this, aB2);
    }

    public static void b(eU eU2, aB aB2) {
        Object object;
        boolean bl2 = fj.z;
        if (eU2 == null) {
            aB2.zb = null;
            if (!bl2) return;
        }
        if ((object = eU.d(eU2)) == null) throw new IllegalArgumentException("NodePort not in NodeRealizer.");
        aB2.zb = object;
        aB2.setTargetPoint(eU.b(eU2));
        if (!bl2) return;
        throw new IllegalArgumentException("NodePort not in NodeRealizer.");
    }

    public static eU d(aB aB2) {
        return eU.a(aB2, false);
    }

    private static eU a(aB aB2, boolean bl2) {
        Object object = bl2 ? aB2.vb : aB2.zb;
        if (object == null) return null;
        bu bu2 = aB2.i();
        if (bu2 == null) return null;
        fj fj2 = bl2 ? aB2.getSourceRealizer() : aB2.getTargetRealizer();
        return fj2.b(object);
    }

    public e c() {
        return this.a(true, true).a();
    }

    public e d() {
        return this.a(true, false).a();
    }

    public e e() {
        return this.a(false, true).a();
    }

    private f a(boolean bl2, boolean bl3) {
        aB aB2;
        e e2;
        f f2 = new f();
        fj fj2 = this.b();
        if (fj2 == null) return f2;
        Object object = eU.d(this);
        q q2 = fj2.getNode();
        if (q2 == null) return f2;
        if (q2.a() <= 0) return f2;
        if (q2.e() == null) return f2;
        bu bu2 = fj2.d();
        HashSet<d> hashSet = new HashSet<d>();
        if (bl2) {
            e2 = q2.k();
            while (e2.f()) {
                aB2 = bu2.i(e2.a());
                if (object == aB2.zb && hashSet.add(e2.a())) {
                    f2.add(e2.a());
                }
                e2.g();
            }
        }
        if (!bl3) return f2;
        e2 = q2.l();
        while (e2.f()) {
            aB2 = bu2.i(e2.a());
            if (object == aB2.vb && hashSet.add(e2.a())) {
                f2.add(e2.a());
            }
            e2.g();
        }
        return f2;
    }

    public boolean f() {
        return this.d;
    }

    public void a(boolean bl2) {
        bu bu2;
        if (this.d == bl2) return;
        this.d = bl2;
        fj fj2 = this.b();
        if (fj2 != null && (bu2 = fj2.d()) != null) {
            bu2.e(this);
        }
        if (this.c.f == null) return;
        this.c.f.a(this);
    }

    public fP g() {
        return this.b;
    }

    public void a(fP fP2) {
        this.b = fP2;
        this.i();
    }

    public t h() {
        fP fP2 = this.g();
        return fP2.a().a(this, fP2);
    }

    void i() {
        if (eU.d(this) == null) return;
        this.l();
        this.m();
    }

    private void l() {
        Iterator iterator = fM.a(this).iterator();
        while (iterator.hasNext()) {
            ((eR)iterator.next()).setOffsetDirty();
        }
    }

    private void m() {
        aB aB2;
        bu bu2 = this.b().d();
        if (bu2 == null) return;
        t t2 = eU.b(this);
        e e2 = this.e();
        while (e2.f()) {
            aB2 = bu2.i(e2.a());
            aB2.setSourcePoint(t2);
            e2.g();
        }
        e2 = this.d();
        while (e2.f()) {
            aB2 = bu2.i(e2.a());
            aB2.setTargetPoint(t2);
            e2.g();
        }
    }

    public static eY j() {
        return f;
    }

    static eU a(bu bu2, d d2, boolean bl2) {
        return eU.a(bu2.i(d2), bl2);
    }

    static t b(eU eU2) {
        t t2 = eU2.h();
        fj fj2 = eU2.b();
        return new t(t2.a() - fj2.getCenterX(), t2.b() - fj2.getCenterY());
    }

    static void a(eU eU2, t t2) {
        eU.a(eU2, t2.a(), t2.b());
    }

    static void a(eU eU2, double d2, double d3) {
        fj fj2 = eU2.b();
        eU.b(eU2, fj2.getCenterX() + d2, fj2.getCenterY() + d3);
    }

    static void b(eU eU2, double d2, double d3) {
        fP fP2 = eU2.g();
        eU2.a(fP2.a().a(eU2.b(), new t(d2, d3)));
    }

    static Rectangle2D c(eU eU2) {
        y y2 = eU2.k();
        return new Rectangle2D.Double(y2.c(), y2.d(), y2.a(), y2.b());
    }

    static Object d(eU eU2) {
        fj fj2 = eU2.b();
        if (fj2 == null) {
            return null;
        }
        Object object = fj2.c(eU2);
        return object;
    }

    static int e(eU eU2) {
        boolean bl2 = fj.z;
        fj fj2 = eU2.b();
        if (fj2 == null) return -1;
        int n2 = 0;
        Iterator iterator = fj2.ports();
        do {
            if (!iterator.hasNext()) return -1;
            if (iterator.next() == eU2) {
                return n2;
            }
            ++n2;
        } while (!bl2);
        return -1;
    }

    static eU a(fj fj2, double d2, double d3) {
        eU eU2;
        boolean bl2 = fj.z;
        eU eU3 = null;
        int n2 = fj2.portCount();
        if (n2 > 0) {
            double d4 = Double.POSITIVE_INFINITY;
            int n3 = n2;
            while (n3-- > 0) {
                eU eU4 = fj2.getPort(n3);
                t t2 = eU4.h();
                double d5 = eU.a(t2.a(), t2.b(), d2, d3);
                if (d4 <= d5) continue;
                d4 = d5;
                eU2 = eU4;
                if (bl2) return eU2;
                eU3 = eU2;
                if (!bl2) continue;
            }
        }
        eU2 = eU3;
        return eU2;
    }

    static double a(double d2, double d3, double d4, double d5) {
        double d6 = d2 - d4;
        double d7 = d3 - d5;
        return d6 * d6 + d7 * d7;
    }

    static boolean a(eU eU2, fj fj2) {
        return eU.a(eU2.b(), fj2);
    }

    static boolean a(fj fj2, fj fj3) {
        if (fj2 == fj3) return true;
        if (!(fj3 instanceof gd)) return false;
        if (fj2 != ((gd)fj3).e()) return false;
        return true;
    }

    public boolean a(double d2, double d3) {
        if (this.c.c != null) return this.c.c.a(this, d2, d3);
        return g.a(this, d2, d3);
    }

    public boolean a(double d2, double d3, double d4, double d5, Point2D point2D) {
        if (this.c.d != null) return this.c.d.a(this, d2, d3, d4, d5, point2D);
        return g.a(this, d2, d3, d4, d5, point2D);
    }

    public void a(Graphics2D graphics2D) {
        if (this.c.b == null) {
            g.a(this, graphics2D);
            if (!fj.z) return;
        }
        this.c.b.a(this, graphics2D);
    }

    public y k() {
        if (this.c.e != null) return this.c.e.a(this);
        return g.a(this);
    }

    public void a(Rectangle2D rectangle2D) {
        if (this.c.h == null) {
            g.a(this, rectangle2D);
            if (!fj.z) return;
        }
        this.c.h.a(this, rectangle2D);
    }

    static boolean a(eU eU2, Graphics2D graphics2D) {
        if (!eU2.f()) return false;
        if (!hk.b(graphics2D)) return false;
        return true;
    }
}

