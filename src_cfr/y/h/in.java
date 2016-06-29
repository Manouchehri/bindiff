/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.d;
import y.c.i;
import y.d.m;
import y.d.n;
import y.d.q;
import y.d.t;
import y.f.B;
import y.f.C;
import y.f.D;
import y.f.E;
import y.f.I;
import y.f.Q;
import y.f.aG;
import y.f.am;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.ch;
import y.h.dB;
import y.h.dD;
import y.h.dE;
import y.h.dh;
import y.h.fj;
import y.h.gZ;
import y.h.gu;
import y.h.gv;
import y.h.iq;
import y.h.ir;
import y.h.it;
import y.h.x;

class in
implements dE {
    private gu a;
    private dh b;
    private n c;
    private gv d;
    private gv e;
    private t f;
    private double g;
    private double h;

    in(gu gu2) {
        this.a = gu2;
    }

    @Override
    public void a(dD dD2) {
        gv gv2;
        this.g = dD2.c();
        this.h = dD2.d();
        aA aA2 = (aA)dD2.b();
        this.c = aA2.getOrientedBox();
        this.f = this.c.k();
        Object object = aA2.getModelParameter();
        this.d = gv2 = (gv)(object instanceof gv ? object : this.a.c());
        this.e = gv2;
        dB dB2 = dD2.a();
        if (!dB2.e()) return;
        this.b = dB2.c();
        this.b.a(dB2.view);
        this.b.a(new t(this.g, this.h), (aA)dD2.b());
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void b(dD var1_1) {
        var13_2 = fj.z;
        var2_3 = new it(this, var1_1);
        if (!var1_1.e()) ** GOTO lbl-1000
        var3_4 = (aA)var1_1.b();
        var4_5 = this.a(var3_4.getEdge()) != false ? this.a(var2_3) : this.b(var2_3);
        var5_6 = new y.c.D();
        if (var4_5 != null) ** GOTO lbl-1000
        var2_3.d();
        if (var13_2) lbl-1000: // 2 sources:
        {
            var5_6.add(var4_5);
            var2_3.f = var4_5.c();
        }
        var6_7 = var2_3.a(var5_6);
        var7_8 = var2_3.c();
        var8_9 = var2_3.b();
        v0 = var10_10 = var8_9 < 1.0 ? 0.1 : 0.1 / var8_9;
        if (t.a(var7_8.k(), var6_7) > var10_10) {
            var12_11 = var2_3.a.getRealizer();
            var2_3.e.b(var6_7);
            var2_3.f = (gv)var2_3.b.b(var2_3.e, var12_11, var12_11.getSourceRealizer(), var12_11.getTargetRealizer());
            ** if (!var13_2) goto lbl24
        }
        ** GOTO lbl24
lbl-1000: // 2 sources:
        {
            this.b.h();
            var2_3.d();
        }
lbl24: // 3 sources:
        this.e = var2_3.f;
        var2_3.a.setModelParameter(var2_3.f);
    }

    private boolean a(d d2) {
        bu bu2 = (bu)d2.a();
        aB aB2 = bu2.i(d2);
        if (!d2.e()) return false;
        if (aB2.bendCount() != 1) return false;
        return true;
    }

    @Override
    public void c(dD dD2) {
        this.b();
    }

    @Override
    public void a() {
        this.b();
    }

    private void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    private iq a(it it2) {
        double d2 = it2.a();
        gu gu2 = it2.b;
        n n2 = it2.e;
        aA aA2 = it2.a;
        aB aB2 = aA2.getRealizer();
        gv gv2 = gu2.a(n2, aB2, this.d, 0);
        t t2 = aB2.firstBend().e();
        if (t.a(n2.k(), t2) >= d2) return null;
        ir ir2 = new ir();
        ir2.a(t2);
        ir2.a(it2.d);
        return new iq(gv2, t2, ir2);
    }

    private iq b(it it2) {
        Object object;
        Object object2;
        boolean bl2 = fj.z;
        double d2 = it2.a();
        gu gu2 = it2.b;
        gv gv2 = it2.c;
        n n2 = it2.e;
        aA aA2 = it2.a;
        aB aB2 = aA2.getRealizer();
        fj fj2 = aB2.getSourceRealizer();
        fj fj3 = aB2.getTargetRealizer();
        gv gv3 = gu2.a(n2, aB2, gv2, 0);
        t t2 = gu2.a(n2.d(), aB2, fj2, fj3, gv3).k();
        m m2 = gv3.g();
        ir ir2 = null;
        if (m2 != null) {
            object2 = m2.c();
            object = m2.d();
            ir2 = new ir(object2.a(), object2.b(), object.a(), object.b());
            ir2.a(it2.d);
        }
        if (t.a(n2.k(), t2) >= d2) return null;
        object2 = new D();
        object2.setModelParameter(gv3);
        object2.a(gu2);
        object2.a(n2);
        object2.a(aA2.getPreferredPlacementDescriptor());
        object = gu2.a((C)object2, (I)aB2, (am)fj2, (am)fj3);
        Q q2 = null;
        double d3 = d2 * 0.5;
        if (object != null && !object.isEmpty()) {
            int n3 = aB2.pointCount() + 1;
            y.c.C c2 = object.m();
            while (c2.f()) {
                B b2 = (B)c2.d();
                t t3 = b2.d().k();
                if (bl2) return new iq(gv3, t2, ir2);
                if (ir2 != null && in.a(gv3, b2.b(), n3)) {
                    ir2.a(t3);
                    double d4 = t.a(t3, t2);
                    if (d4 < d3) {
                        q2 = b2;
                        d3 = d4;
                    }
                }
                c2.g();
                if (!bl2) continue;
            }
        }
        if (q2 == null) return new iq(gv3, t2, ir2);
        return new iq((gv)q2.b(), q2.d().k(), ir2);
    }

    private static boolean a(Object object, Object object2, int n2) {
        gv gv2 = (gv)object;
        int n3 = gv2.a();
        int n4 = n3 < 0 ? n3 + n2 : n3;
        gv gv3 = (gv)object2;
        int n5 = gv3.a();
        int n6 = n5 < 0 ? n5 + n2 : n5;
        if (n4 != n6) return false;
        if (gv2.e() != gv3.e()) return false;
        return true;
    }

    static double a(in in2) {
        return in2.g;
    }

    static double b(in in2) {
        return in2.h;
    }

    static t c(in in2) {
        return in2.f;
    }

    static gu d(in in2) {
        return in2.a;
    }

    static gv e(in in2) {
        return in2.e;
    }

    static gv f(in in2) {
        return in2.d;
    }

    static dh g(in in2) {
        return in2.b;
    }

    static n h(in in2) {
        return in2.c;
    }
}

