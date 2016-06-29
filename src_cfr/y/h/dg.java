/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import y.c.C;
import y.d.n;
import y.d.q;
import y.d.t;
import y.d.y;
import y.f.I;
import y.f.Q;
import y.f.am;
import y.h.aA;
import y.h.aB;
import y.h.az;
import y.h.dB;
import y.h.dC;
import y.h.eR;
import y.h.fj;
import y.h.gZ;
import y.h.hC;

class dG
implements az {
    private final BasicStroke a;
    private final BasicStroke b;
    private boolean c;
    private boolean d;
    private Rectangle e;
    private Q f;
    private boolean g;
    private Object h;
    private final dB i;

    private dG(dB dB2) {
        this.i = dB2;
        this.b = new BasicStroke(3.0f, 2, 0);
        this.a = new BasicStroke(1.0f, 2, 0);
        this.c = true;
        this.d = false;
        this.d();
    }

    @Override
    public Rectangle getBounds() {
        if (!this.a()) return this.e;
        if (this.i.e instanceof eR) {
            return this.a(this.a(dB.a(this.i)));
        }
        if (!(this.i.e instanceof aA)) return new Rectangle(0, 0, -1, -1);
        return this.a(this.a(dB.b(this.i)));
    }

    private Rectangle a(n n2) {
        y y2 = n2.h();
        return new Rectangle((int)Math.floor(y2.c()), (int)Math.floor(y2.d()), (int)Math.ceil(y2.a()), (int)Math.ceil(y2.b()));
    }

    @Override
    public void a(Graphics2D graphics2D) {
        if (this.a()) {
            this.c(graphics2D);
            if (!fj.z) return;
        }
        this.b(graphics2D);
    }

    private void b(Graphics2D graphics2D) {
        Q q2;
        boolean bl2 = fj.z;
        Stroke stroke = graphics2D.getStroke();
        Color color = graphics2D.getColor();
        graphics2D.setColor(dB.h());
        if (dB.c(this.i) != null) {
            C c2 = dB.c(this.i).m();
            while (c2.f()) {
                Q q3;
                q2 = q3 = (Q)c2.d();
                if (!bl2) {
                    if (!q2.equals(this.f)) {
                        this.a(graphics2D, q3, this.a);
                    }
                    c2.g();
                    if (!bl2) continue;
                }
                break;
            }
        } else {
            q2 = this.f;
        }
        if (q2 != null) {
            this.a(graphics2D, this.f, this.b);
        }
        graphics2D.setStroke(stroke);
        graphics2D.setColor(color);
    }

    private void a(Graphics2D graphics2D, Q q2, Stroke stroke) {
        Line2D.Double double_;
        boolean bl2;
        t[] arrt;
        block4 : {
            bl2 = fj.z;
            if (q2 == null) {
                return;
            }
            graphics2D.setStroke(stroke);
            double_ = hC.a().l;
            if (this.i.e instanceof eR && this.b() || this.i.e instanceof aA && this.c()) {
                n n2 = new n(q2.h());
                arrt = n.a(n2);
                if (!bl2) break block4;
            }
            arrt = n.a(q2.d());
        }
        int n3 = 0;
        do {
            if (n3 >= arrt.length) return;
            int n4 = n3 == 0 ? arrt.length - 1 : n3 - 1;
            double_.setLine(arrt[n3].a(), arrt[n3].b(), arrt[n4].a(), arrt[n4].b());
            graphics2D.draw(double_);
            ++n3;
        } while (!bl2);
    }

    private void c(Graphics2D graphics2D) {
        n n2;
        if (this.i.e instanceof aA) {
            n2 = this.a(dB.b(this.i));
            this.a(graphics2D, n2);
            if (!fj.z) return;
        }
        if (!(this.i.e instanceof eR)) return;
        n2 = this.a(dB.a(this.i));
        this.a(graphics2D, n2);
    }

    private n a(aA aA2) {
        aB aB2 = aA2.getRealizer();
        return dB.d(this.i).a(aA2.getOrientedBox().d(), aB2, aB2.getSourceRealizer(), aB2.getTargetRealizer(), this.h);
    }

    private n a(eR eR2) {
        return dB.e(this.i).a(eR2.getOrientedBox().d(), eR2.g(), this.h);
    }

    /*
     * Unable to fully structure code
     */
    private void a(Graphics2D var1_1, n var2_2) {
        var9_3 = fj.z;
        var3_4 = var1_1.getColor();
        var4_5 = var1_1.getStroke();
        var1_1.setColor(dB.h());
        var1_1.setStroke(new BasicStroke(3.0f, 2, 0));
        var5_6 = hC.a().l;
        if ((!(this.i.e instanceof eR) || !this.b()) && (!(this.i.e instanceof aA) || !this.c())) ** GOTO lbl-1000
        var7_7 = new n(var2_2.h());
        var6_9 = n.a(var7_7);
        if (var9_3) lbl-1000: // 2 sources:
        {
            var6_9 = n.a(var2_2);
        }
        for (var7_8 = 0; var7_8 < var6_9.length; ++var7_8) {
            var8_10 = var7_8 == 0 ? var6_9.length - 1 : var7_8 - 1;
            var5_6.setLine(var6_9[var7_8].a(), var6_9[var7_8].b(), var6_9[var8_10].a(), var6_9[var8_10].b());
            var1_1.draw(var5_6);
            if (!var9_3) continue;
        }
        var1_1.setColor(var3_4);
        var1_1.setStroke(var4_5);
    }

    private void a(Object object) {
        this.h = object;
    }

    private void a(Q q2) {
        this.f = q2;
    }

    private void d() {
        boolean bl2 = fj.z;
        if (dB.c(this.i) == null || dB.c(this.i).isEmpty()) {
            this.e = null;
            if (!bl2) return;
        }
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        double d4 = -1.7976931348623157E308;
        double d5 = -1.7976931348623157E308;
        C c2 = dB.c(this.i).m();
        while (c2.f()) {
            y y2 = ((Q)c2.d()).h();
            d2 = Math.min(d2, y2.c());
            d3 = Math.min(d3, y2.d());
            d4 = Math.max(d4, y2.c() + y2.a());
            d5 = Math.max(d5, y2.d() + y2.b());
            c2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        double d6 = this.b.getLineWidth();
        this.e = new Rectangle((int)Math.floor(d2 - d6), (int)Math.floor(d3 - d6), (int)Math.ceil(d4 - d2 + 2.0 * d6), (int)Math.ceil(d5 - d3 + 2.0 * d6));
    }

    public boolean a() {
        return this.g;
    }

    public void a(boolean bl2) {
        this.g = bl2;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    dG(dB dB2, dC dC2) {
        this(dB2);
    }

    static void a(dG dG2, Q q2) {
        dG2.a(q2);
    }

    static void a(dG dG2, Object object) {
        dG2.a(object);
    }
}

