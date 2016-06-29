/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import y.c.A;
import y.c.C;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.x;
import y.f.f.b.b;
import y.f.f.b.h;
import y.f.f.b.o;
import y.f.f.e.a;
import y.f.f.e.e;
import y.f.f.e.l;
import y.f.h.N;
import y.f.h.p;
import y.f.h.q;
import y.f.h.r;
import y.g.al;

public class k
implements b {
    protected i a;
    protected h b;
    private y.c.h c;
    private y.c.h d;
    private static double e = 0.001;
    private int f = 0;
    private static final Integer g = new Integer(0);
    private static final Integer h = new Integer(1);
    private static final Integer i = new Integer(3);
    private boolean j = false;

    @Override
    public int b() {
        return this.f;
    }

    @Override
    public void a(h h2) {
        this.b = h2;
        this.a = this.b.a();
    }

    @Override
    public void a() {
        y.g.o.a(this, 1, "------->>> Entering Layout Phase");
        al al2 = new al();
        al al3 = new al();
        i i2 = new i();
        A a2 = i2.t();
        y.c.h h2 = i2.u();
        y.c.h h3 = i2.u();
        this.a(i2, a2, h2, h3);
        y.g.o.a(this, 3, new StringBuffer().append("Prof: ---> Constructing network took ").append(al3).toString());
        y.c.h h4 = this.a.u();
        this.a(i2, a2, h2, h3, h4);
        if (this.j) {
            y.f.f.b.l l2 = new y.f.f.b.l();
            c c2 = this.a.c("y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
            N n2 = this.b.b();
            l2.a(this.b, new l(this, h4, c2, n2));
        }
        this.b.a(h4, this.a.p().a(), o.a);
        this.a.a(h4);
        i2.a(a2);
        i2.a(h2);
        i2.a(h3);
        y.g.o.a(this, 1, new StringBuffer().append("Prof: -> Total running time of layout Phase: ").append(al2).toString());
        y.g.o.a(this, 1, "<<<------- Leaving Layout Phase");
    }

    /*
     * Unable to fully structure code
     */
    private void a(i var1_1, A var2_2, y.c.h var3_3, y.c.h var4_4) {
        var21_5 = a.a;
        var5_6 = new Integer(4 * this.a.h());
        var6_7 = var1_1.d();
        var7_8 = var1_1.d();
        this.d = this.a.u();
        this.c = this.a.u();
        var8_9 = var1_1.t();
        var9_10 = this.b.g();
        var10_11 = this.a.c("y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
        var11_12 = this.a.o();
        while (var11_12.f()) {
            var12_14 = var11_12.e();
            if (var12_14.b() < 4) {
                var13_15 = var1_1.d();
                var2_2.a((Object)var13_15, k.g);
                var14_16 = var1_1.a(var6_7, var13_15);
                var3_3.a(var14_16, k.g);
                var4_4.a(var14_16, 4 - var12_14.b());
                var8_9.a(var12_14, var13_15);
            }
            var11_12.g();
            if (var21_5 == 0) continue;
        }
        var11_12 = this.b.c();
        while (var11_12.f()) {
            var12_14 = var11_12.a();
            var13_15 = var1_1.d();
            var2_2.a((Object)var13_15, k.g);
            v0 = var12_14.a().k();
            if (var21_5 == 0) {
                if (v0 < 4 && this.b.d() != var12_14) {
                    var14_16 = var1_1.a(var6_7, var13_15);
                    var3_3.a(var14_16, k.g);
                    var4_4.a(var14_16, 4 - var12_14.a().k());
                }
                if (var12_14.a().k() > 4 && this.b.d() != var12_14) {
                    var14_16 = var1_1.a(var13_15, var7_8);
                    var3_3.a(var14_16, k.g);
                    var4_4.a(var14_16, var12_14.a().k() - 4);
                }
                if (this.b.d() == var12_14) {
                    var14_16 = var1_1.a(var13_15, var7_8);
                    var3_3.a(var14_16, k.g);
                    var4_4.a(var14_16, var12_14.a().k() + 4);
                }
                var9_10.a((p)var12_14, var13_15);
                var11_12.g();
                if (var21_5 == 0) continue;
            }
            ** GOTO lbl48
        }
        var11_12 = this.b.c();
        block2 : do {
            v0 = var11_12.f();
lbl48: // 3 sources:
            block3 : while (v0 != 0) {
                var12_14 = var11_12.a();
                var13_15 = (y.c.q)var9_10.b(var12_14);
                var14_16 = var12_14.a();
                while (var14_16.f()) {
                    block14 : {
                        var15_17 = var14_16.a();
                        var16_18 = this.b.b(this.b.a(var15_17));
                        var17_19 = (y.c.q)var9_10.b(var16_18);
                        var18_20 = var1_1.a(var13_15, var17_19);
                        var3_3.a((Object)var18_20, k.h);
                        this.c.a((Object)var15_17, var18_20);
                        v0 = (int)var10_11.d(var16_18) ? 1 : 0;
                        if (var21_5 != 0) continue block3;
                        if (v0 != 0) {
                            var4_4.a((Object)var18_20, k.g);
                            if (var21_5 == 0) break block14;
                        }
                        var4_4.a((Object)var18_20, var5_6);
                    }
                    if ((var19_21 = (y.c.q)var8_9.b(var15_17.c())) != null) {
                        var20_22 = var1_1.a(var19_21, var13_15);
                        var3_3.a((Object)var20_22, k.g);
                        var4_4.a((Object)var20_22, k.i);
                        this.d.a((Object)var15_17, var20_22);
                    }
                    var14_16.g();
                    if (var21_5 == 0) continue;
                }
                var11_12.g();
                if (var21_5 == 0) continue block2;
            }
            break block2;
            break;
        } while (true);
        var11_13 = 0;
        var12_14 = var6_7.l();
        while (var12_14.f()) {
            var11_13 += var4_4.a(var12_14.a());
            var12_14.g();
            if (var21_5 != 0) return;
            if (var21_5 == 0) continue;
        }
        var2_2.a((Object)var6_7, var11_13);
        var2_2.a((Object)var7_8, - var11_13);
    }

    protected void a(i i2, A a2, y.c.h h2, y.c.h h3, y.c.h h4) {
        int n2 = a.a;
        al al2 = new al();
        this.f = 0;
        y.c.h h5 = i2.u();
        e e2 = new e();
        e2.a(i2, null, h3, h2, a2, h5, null);
        y.g.o.a(this, 3, new StringBuffer().append("Prof: ---> Solving Network took ").append(al2).toString());
        al2.e();
        y.g.o.a(this, 5, "Bends of edges: ");
        y.c.e e3 = this.a.p();
        while (e3.f()) {
            block3 : {
                d d2 = e3.a();
                StringBuffer stringBuffer = new StringBuffer();
                int n3 = h5.a(this.c.b(d2));
                int n4 = h5.a(this.c.b(this.b.a(d2)));
                k.a(stringBuffer, n4, '>');
                k.a(stringBuffer, n3, '<');
                this.f += stringBuffer.length();
                h4.a((Object)d2, stringBuffer.toString());
                if (n2 != 0) return;
                if (d2.c().b() < 4) {
                    int n5 = h5.a(this.d.b(d2));
                    this.b.a(d2, n5 + 1);
                    if (n2 == 0) break block3;
                }
                this.b.a(d2, 1);
            }
            e3.g();
            if (n2 == 0) continue;
        }
        this.f /= 2;
        y.g.o.a(this, 1, new StringBuffer().append("Stat: Number of bends: ").append(this.f).toString());
        y.g.o.a(this, 3, new StringBuffer().append("Prof: ---> Parsing ILP solution took ").append(al2).toString());
    }

    private static void a(StringBuffer stringBuffer, double d2, char c2) {
        int n2 = a.a;
        int n3 = (int)Math.floor(d2 + e);
        int n4 = 0;
        do {
            if (n4 >= n3) return;
            stringBuffer.append(c2);
            ++n4;
        } while (n2 == 0);
    }

    public void a(boolean bl2) {
        this.j = bl2;
    }
}

