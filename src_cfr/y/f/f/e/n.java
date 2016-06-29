/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import y.c.A;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.x;
import y.d.t;
import y.f.X;
import y.f.f.b.h;
import y.f.f.b.o;
import y.f.f.b.p;
import y.f.f.c.f;
import y.f.f.c.k;
import y.f.f.c.l;
import y.f.f.c.m;
import y.f.f.c.r;
import y.f.f.e.a;
import y.f.h.q;
import y.g.al;

public class n
implements p {
    private h b;
    private X c;
    private short d = 0;
    private short e = 0;
    private int f = 3;
    public int a;
    private boolean g = false;
    private y.f.f.b.m h;

    @Override
    public void a(h h2) {
        this.b = h2;
        this.c = (X)this.b.a();
    }

    @Override
    public void a(int n2) {
        this.a = n2;
    }

    @Override
    public void a(y.f.f.b.m m2) {
        this.h = m2;
    }

    public void a(short s2) {
        this.d = s2;
    }

    public void b(short s2) {
        this.e = s2;
    }

    public void b(int n2) {
        this.f = n2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a() {
        block18 : {
            block17 : {
                block16 : {
                    var12_1 = a.a;
                    y.g.o.a(this, (Object)"------->>> Entering Compaction Phase");
                    var1_2 = new al();
                    var2_3 = this.c.n();
                    for (var3_4 = 0; var3_4 < var2_3.length; ++var3_4) {
                        var4_6 = var2_3[var3_4];
                        v0 = this.b;
                        if (var12_1 == 0) {
                            if (v0.c((d)var4_6)) continue;
                            this.b.n((d)var4_6);
                            if (var12_1 == 0) continue;
                        }
                        break block16;
                    }
                    v0 = this.b;
                }
                var3_5 = v0.a().p();
                while (var3_5.f()) {
                    this.b.b(var3_5.a(), 1);
                    v1 = this;
                    if (var12_1 == 0) {
                        v1.b.b(var3_5.a(), 1.0);
                        var3_5.g();
                        if (var12_1 == 0) continue;
                    }
                    break block17;
                }
                v1 = this;
            }
            var3_5 = v1.c.c("y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
            if (this.d == 1) {
                var4_6 = this.b.c();
                block7 : do {
                    v2 = var4_6.f();
                    block8 : while (v2 != 0) {
                        var5_7 = (y.f.h.p)var4_6.d();
                        if (var12_1 != 0) break block18;
                        if (var3_5.d(var5_7)) {
                            var6_8 = new y.c.q[4];
                            var7_10 = var5_7.a();
                            while (var7_10.f()) {
                                var8_12 = var7_10.a();
                                v2 = this.b.d((d)var8_12);
                                if (var12_1 != 0) continue block8;
                                if (v2 == 1) {
                                    var6_8[this.b.h((d)var8_12).g()] = var8_12.c();
                                }
                                var7_10.g();
                                if (var12_1 == 0) continue;
                            }
                            var7_10 = new y.f.f.b.n(var6_8[1], var6_8[0], 2, 1, o.b);
                            this.b.a((y.f.f.b.n)var7_10);
                            var8_12 = new y.f.f.b.n(var6_8[2], var6_8[1], 2, 1, o.c);
                            this.b.a((y.f.f.b.n)var8_12);
                        }
                        var4_6.g();
                        if (var12_1 == 0) continue block7;
                    }
                    break block7;
                    break;
                } while (true);
            }
            this.h.h = (int)var1_2.d();
            var1_2.e();
        }
        var4_6 = new r();
        var4_6.a(this.f);
        switch (this.e) {
            case 0: {
                var4_6.a(new k());
                var4_6.a(new m());
                if (var12_1 == 0) ** GOTO lbl70
            }
            case 1: {
                var4_6.a(new y.f.f.c.h());
                var4_6.a(new m());
                if (var12_1 == 0) ** GOTO lbl70
            }
            case 2: {
                var4_6.a(new y.f.f.c.n());
                var4_6.a(new m());
                if (var12_1 == 0) ** GOTO lbl70
            }
        }
        y.g.o.a((Object)"Unknown Compactor !");
lbl70: // 4 sources:
        var5_7 = this.c.t();
        var4_6.a(this.b);
        var4_6.a(this.g);
        var4_6.a((A)var5_7);
        this.h.i = (int)var1_2.d();
        var1_2.e();
        var6_9 = this.a;
        var7_11 = this.a;
        var8_12 = this.c.o();
        while (var8_12.f()) {
            var9_13 = var8_12.e();
            var10_14 = (t)var5_7.b(var9_13);
            var11_15 = new t(var10_14.a() * (double)var6_9, var10_14.b() * (double)var7_11);
            var5_7.a((Object)var9_13, var11_15);
            this.c.a(var9_13, var11_15.a(), var11_15.b());
            var8_12.g();
            if (var12_1 != 0) return;
            if (var12_1 == 0) continue;
        }
        this.c.a((A)var5_7);
        this.h.j = var4_6.a();
        this.h.k = var4_6.b();
        this.h.l = var4_6.c();
        this.h.m = var4_6.d();
        y.g.o.a(this, (Object)new StringBuffer().append("Prof: -> Total running time of compaction Phase: ").append(var1_2).toString());
        y.g.o.a(this, (Object)"<<<------- Leaving Compaction Phase");
    }
}

