/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import y.c.D;
import y.c.d;
import y.c.q;
import y.d.n;
import y.d.t;
import y.f.C;
import y.f.E;
import y.f.I;
import y.f.K;
import y.f.M;
import y.f.Q;
import y.f.aj;
import y.f.al;
import y.f.am;
import y.h.aA;
import y.h.aB;
import y.h.az;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dC;
import y.h.dD;
import y.h.dE;
import y.h.dF;
import y.h.dG;
import y.h.dh;
import y.h.eR;
import y.h.fj;
import y.h.gX;
import y.h.gZ;
import y.h.gg;
import y.h.gu;
import y.h.gw;
import y.h.ih;

public class dB
extends gX {
    private static final Color f = new Color(51, 51, 51);
    double a;
    double b;
    double c;
    double d;
    gZ e;
    private D g;
    private dG h;
    private byte i;
    private boolean j = true;
    private al k;
    private E l;
    private ih m;
    private dE n;
    private dh o;
    private boolean p = true;
    private int q;

    public dB() {
        this.a(2);
    }

    public void a(int n2) {
        this.q = n2;
    }

    public int a() {
        return this.q;
    }

    protected boolean a(MouseEvent mouseEvent) {
        if ((mouseEvent.getModifiers() & this.a()) == 0) return false;
        return true;
    }

    public dh c() {
        if (this.o != null) return this.o;
        this.o = this.f();
        return this.o;
    }

    public boolean e() {
        return this.p;
    }

    protected dh f() {
        return new dh(this.view);
    }

    public boolean g() {
        return this.j;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void mousePressedLeft(double var1_1, double var3_2) {
        block12 : {
            var13_3 = fj.z;
            if (this.m != null) {
                this.m.a();
            }
            this.m = new ih();
            this.a = this.c = var1_1;
            this.b = this.d = var3_2;
            var5_4 = this.getGraph2D();
            var6_5 = this.e;
            var7_6 = this.i;
            var8_7 = this.k;
            var9_8 = this.l;
            this.e = null;
            this.g = null;
            if (this.h != null) {
                this.view.removeDrawable(this.h);
                this.h = null;
            }
            if (this.n != null) {
                this.n.a();
                this.n = null;
            }
            if (var6_5 == null) ** GOTO lbl31
            this.c().f();
            var10_9 = var6_5.getOrientedBox();
            var6_5.setModel(var7_6);
            if (!(var6_5 instanceof eR)) ** GOTO lbl-1000
            var11_10 = (eR)var6_5;
            var11_10.a(var8_7, var8_7.a((n)var10_9, (am)var11_10.g()));
            if (var13_3) lbl-1000: // 2 sources:
            {
                var11_10 = (aA)var6_5;
                var12_11 = var11_10.getRealizer();
                var11_10.setLabelModel(var9_8, var9_8.a((n)var10_9, (I)var12_11, (am)var12_11.getSourceRealizer(), (am)var12_11.getTargetRealizer()));
            }
lbl31: // 4 sources:
            if ((var10_9 = this.getHitInfo(var1_1, var3_2)).l() == null) ** GOTO lbl-1000
            this.setEditing(true);
            var11_10 = var10_9.l();
            this.i = var11_10.getModel();
            this.k = var11_10.a();
            this.a(var5_4, (eR)var11_10, var1_1, var3_2);
            this.e = var11_10;
            if (var13_3) lbl-1000: // 2 sources:
            {
                if (var10_9.m() != null) {
                    this.setEditing(true);
                    var11_10 = var10_9.m();
                    this.i = var11_10.getModel();
                    this.l = var11_10.getLabelModel();
                    this.a(var5_4, (aA)var11_10, var1_1, var3_2);
                    this.e = var11_10;
                }
            }
            if (var6_5 != null && this.e == null) {
                block11 : {
                    this.i = var7_6;
                    this.k = var8_7;
                    this.l = var9_8;
                    if (var6_5 instanceof eR) {
                        this.a(var5_4, (eR)var6_5, var1_1, var3_2);
                        if (!var13_3) break block11;
                    }
                    this.a(var5_4, (aA)var6_5, var1_1, var3_2);
                }
                this.e = var6_5;
            }
            if (this.e == null) return;
            if (this.n == null) {
                this.i();
                if (!var13_3) break block12;
            }
            this.n.a(this.a(this.e, this.lastPressEvent, var1_1, var3_2));
        }
        this.view.updateView();
        this.m.a(this.view, this.e);
        this.view.setViewCursor(Cursor.getPredefinedCursor(13));
    }

    private void a(bu bu2, eR eR2, double d2, double d3) {
        q q2 = eR2.f();
        this.m.a(bu2, q2);
        this.g = this.k.a(eR2, (am)bu2.t(q2));
        this.a(bu2, q2);
        this.m.b(bu2, q2);
        this.n = this.a(eR2);
        if (this.n != null) return;
        if (this.e()) {
            dh dh2 = this.c();
            dh2.a(this.view);
            dh2.a(new t(d2, d3), eR2);
        }
        eR2.setModel(4);
    }

    private void a(bu bu2, aA aA2, double d2, double d3) {
        d d4 = aA2.getEdge();
        this.g = this.l.a(aA2, (I)bu2.i(d4), (am)bu2.t(d4.c()), (am)bu2.t(d4.d()));
        this.a(bu2, d4);
        this.m.a(bu2, d4);
        this.n = this.a(aA2);
        if (this.n != null) return;
        if (this.e()) {
            dh dh2 = this.c();
            dh2.a(this.view);
            dh2.a(new t(d2, d3), aA2);
        }
        aA2.setModel(4);
    }

    protected dE a(gZ gZ2) {
        if (gZ2 instanceof aA) {
            E e2 = ((aA)gZ2).getLabelModel();
            if (!(e2 instanceof dF)) return null;
            return ((dF)((Object)e2)).a();
        }
        if (!(gZ2 instanceof eR)) return null;
        al al2 = ((eR)gZ2).a();
        if (!(al2 instanceof dF)) return null;
        return ((dF)((Object)al2)).a();
    }

    private void i() {
        byte by2;
        boolean bl2;
        block8 : {
            bl2 = fj.z;
            if (this.i == 4 || this.i == 4) {
                this.g = null;
            }
            if (this.g == null) return;
            if (this.e instanceof eR) {
                by2 = this.a(this.k);
                if (!bl2) break block8;
            }
            by2 = this.a(this.l);
        }
        switch (by2) {
            case 0: {
                this.h = null;
                if (!bl2) return;
            }
            case 2: {
                this.h = new dG(this, null);
                this.h.a(true);
                this.view.addDrawable(this.h);
                if (!bl2) return;
            }
            case 1: {
                this.h = new dG(this, null);
                this.h.a(false);
                this.view.addDrawable(this.h);
                if (!bl2) return;
            }
        }
        throw new IllegalStateException("Unknown Candidates Type");
    }

    protected void a(bu bu2, q q2) {
        if (!this.g()) return;
        this.a(bu2, q2, true);
    }

    protected void a(bu bu2, d d2) {
        if (!this.g()) return;
        this.a(bu2, d2, true);
    }

    protected void a(bu bu2, d d2, boolean bl2) {
        bu2.a(d2, bl2);
    }

    protected void a(bu bu2, q q2, boolean bl2) {
        if (bl2) {
            gg.a(bu2, q2);
            if (!fj.z) return;
        }
        gg.b(bu2, q2);
    }

    @Override
    public void mouseReleasedRight(double d2, double d3) {
        this.mouseReleasedLeft(d2, d3);
    }

    @Override
    public void mouseReleasedLeft(double d2, double d3) {
        this.a(d2, d3, false);
    }

    /*
     * Unable to fully structure code
     */
    private void a(double var1_1, double var3_2, boolean var5_3) {
        var7_4 = fj.z;
        if (this.e == null) ** GOTO lbl20
        if (this.n != null) ** GOTO lbl-1000
        this.j();
        if (var7_4) lbl-1000: // 2 sources:
        {
            block4 : {
                if (var5_3) {
                    this.n.a();
                    if (!var7_4) break block4;
                }
                this.n.c(this.a(this.e, this.lastReleaseEvent, var1_1, var3_2));
            }
            this.n = null;
        }
        var6_5 = this.getGraph2D();
        this.m.a(var6_5);
        this.c().f();
        this.view.updateWorldRect();
        this.view.setDrawingMode(0);
        this.a(var1_1 - this.a, var3_2 - this.b, var1_1, var3_2);
        this.setEditing(false);
        var6_5.T();
lbl20: // 2 sources:
        this.i = 0;
        this.e = null;
        this.l = null;
        this.k = null;
        this.g = null;
        if (this.m != null) {
            this.m.a();
        }
        this.m = null;
        this.reactivateParent();
    }

    /*
     * Unable to fully structure code
     */
    private void j() {
        block8 : {
            var6_1 = fj.z;
            if (this.h != null) {
                this.view.removeDrawable(this.h);
                this.h = null;
            }
            var1_2 = this.e.getOrientedBox();
            var2_3 = this.e instanceof eR;
            if (var2_3) {
                var4_4 = this.a(this.k);
                if (!var6_1) break block8;
            }
            var4_4 = this.a(this.l);
        }
        switch (var4_4) {
            case 0: 
            case 2: {
                if (!var2_3) ** GOTO lbl17
                var3_5 = this.a(this.k, var1_2, this.l().g(), this.lastReleaseEvent);
                if (!var6_1) ** GOTO lbl30
lbl17: // 2 sources:
                var3_5 = this.a(this.l, var1_2, this.k().getRealizer(), this.lastReleaseEvent);
                if (!var6_1) ** GOTO lbl30
            }
            case 1: {
                var5_6 = this.a(var1_2);
                if (var5_6 != null) ** GOTO lbl27
                if (!var2_3) ** GOTO lbl25
                var3_5 = this.a(this.k, var1_2, this.l().g(), this.lastReleaseEvent);
                if (!var6_1) ** GOTO lbl30
lbl25: // 2 sources:
                var3_5 = this.a(this.l, var1_2, this.k().getRealizer(), this.lastReleaseEvent);
                if (!var6_1) ** GOTO lbl30
lbl27: // 2 sources:
                var3_5 = var5_6.b();
                if (!var6_1) ** GOTO lbl30
            }
        }
        throw new IllegalStateException("Unknown Candidates Type");
lbl30: // 5 sources:
        this.e.setModel(this.i);
        if (var2_3) {
            this.l().a(this.k, var3_5);
            if (var6_1 == false) return;
        }
        this.k().setLabelModel(this.l, var3_5);
    }

    private aA k() {
        return (aA)this.e;
    }

    private eR l() {
        return (eR)this.e;
    }

    private boolean b(MouseEvent mouseEvent) {
        if (!this.e()) return false;
        if (this.a(mouseEvent)) return false;
        return true;
    }

    @Override
    public void mouseDraggedRight(double d2, double d3) {
        this.mouseDraggedLeft(d2, d3);
    }

    @Override
    public void mouseDraggedLeft(double d2, double d3) {
        block2 : {
            if (this.e == null) return;
            if (this.n == null) {
                this.a(d2, d3);
                if (!fj.z) break block2;
            }
            this.n.b(this.a(this.e, this.lastDragEvent, d2, d3));
        }
        this.m.a(this.view.getGraph2D());
        this.view.updateView();
    }

    /*
     * Unable to fully structure code
     */
    private void a(double var1_1, double var3_2) {
        block9 : {
            var13_3 = fj.z;
            var5_4 = var1_1 - this.c;
            var7_5 = var3_2 - this.d;
            this.c = var1_1;
            this.d = var3_2;
            if (this.e instanceof eR) {
                var9_6 = this.a(this.k);
                if (!var13_3) break block9;
            }
            var9_6 = this.a(this.l);
        }
        switch (var9_6) {
            case 0: {
                if (this.h == null) ** GOTO lbl30
                this.view.removeDrawable(this.h);
                this.h = null;
                if (!var13_3) ** GOTO lbl30
            }
            case 2: {
                if (this.h != null) ** GOTO lbl30
                this.h = new dG(this, null);
                this.view.addDrawable(this.h);
                this.h.a(true);
                if (!var13_3) ** GOTO lbl30
            }
            case 1: {
                if (this.h != null) ** GOTO lbl30
                this.h = new dG(this, null);
                this.view.addDrawable(this.h);
                this.h.a(false);
                if (!var13_3) ** GOTO lbl30
            }
        }
        throw new IllegalStateException("Unknown Candidates Type");
lbl30: // 6 sources:
        var10_7 = this.e.getOrientedBox();
        var11_8 = var10_7.f(var5_4, var7_5);
        if (!this.b(this.lastDragEvent)) ** GOTO lbl-1000
        var12_9 = this.c().b(var11_8.k());
        var11_8.b(var12_9);
        this.c = var12_9.a();
        this.d = var12_9.b();
        if (var13_3) lbl-1000: // 2 sources:
        {
            if (this.e()) {
                this.c().h();
            }
        }
        this.b(var11_8);
    }

    private Q a(n n2) {
        return this.a(n2, this.g);
    }

    protected Q a(n n2, D d2) {
        return this.a(n2.k(), d2);
    }

    private Q a(t t2, D d2) {
        Q q2;
        boolean bl2 = fj.z;
        if (d2 == null) {
            return null;
        }
        double d3 = Double.MAX_VALUE;
        Q q3 = null;
        y.c.C c2 = d2.m();
        while (c2.f()) {
            q2 = (Q)c2.d();
            if (bl2) return q2;
            Q q4 = q2;
            double d4 = t.a(t2, q4.d().k());
            if (d4 < d3) {
                d3 = d4;
                q3 = q4;
            }
            c2.g();
            if (!bl2) continue;
        }
        q2 = q3;
        return q2;
    }

    /*
     * Unable to fully structure code
     */
    private void b(n var1_1) {
        var7_2 = fj.z;
        var2_3 = this.lastDragEvent;
        if (!(this.e instanceof eR)) ** GOTO lbl-1000
        var3_4 = this.l();
        var4_5 = var3_4.a();
        var5_6 = var3_4.g();
        this.e.setModelParameter(this.a((al)var4_5, var1_1, (fj)var5_6, var2_3));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if (this.e instanceof aA) {
                var3_4 = this.k();
                var4_5 = var3_4.getLabelModel();
                var5_6 = var3_4.getRealizer();
                var6_7 = this.a((E)var4_5, var1_1, (aB)var5_6, var2_3);
                this.e.setModelParameter(var6_7);
            }
        }
        if (this.h == null) return;
        dG.a(this.h, this.a(var1_1));
        if (this.h.a() == false) return;
        if (this.e instanceof eR) {
            var3_4 = this.a(this.k, var1_1, this.l().g(), var2_3);
            dG.a(this.h, var3_4);
            if (var7_2 == false) return;
        }
        if (this.e instanceof aA == false) return;
        var3_4 = this.a(this.l, var1_1, this.k().getRealizer(), var2_3);
        dG.a(this.h, var3_4);
    }

    protected void a(double d2, double d3, double d4, double d5) {
    }

    @Override
    public void cancelEditing() {
        if (!this.isEditing()) return;
        this.a(this.c, this.d, true);
    }

    protected byte a(al al2) {
        if (al2 instanceof gw) {
            return 0;
        }
        if (!(al2 instanceof M)) return 1;
        return 0;
    }

    protected byte a(E e2) {
        if (e2 instanceof gu) {
            return 0;
        }
        if (!(e2 instanceof K)) return 1;
        return 0;
    }

    protected Object a(al al2, n n2, fj fj2, MouseEvent mouseEvent) {
        return al2.a(n2, (am)fj2);
    }

    protected Object a(E e2, n n2, aB aB2, MouseEvent mouseEvent) {
        return e2.a(n2, (I)aB2, (am)aB2.getSourceRealizer(), (am)aB2.getTargetRealizer());
    }

    private dD a(gZ gZ2, MouseEvent mouseEvent, double d2, double d3) {
        return new dD(this, gZ2, mouseEvent.getModifiersEx(), d2, d3, this.b(mouseEvent));
    }

    static eR a(dB dB2) {
        return dB2.l();
    }

    static aA b(dB dB2) {
        return dB2.k();
    }

    static Color h() {
        return f;
    }

    static D c(dB dB2) {
        return dB2.g;
    }

    static E d(dB dB2) {
        return dB2.l;
    }

    static al e(dB dB2) {
        return dB2.k;
    }
}

