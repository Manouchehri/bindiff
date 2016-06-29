/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import java.io.PrintStream;
import y.c.D;
import y.c.d;
import y.c.e;
import y.f.f.b.h;
import y.f.f.b.o;
import y.f.f.c.f;
import y.f.f.c.g;
import y.f.f.c.p;
import y.f.f.d.b;
import y.f.h.q;

public class m
implements f {
    private h a;
    private p b;
    private p c;

    @Override
    public void a(h h2, p p2, p p3) {
        this.a = h2;
        this.b = p2;
        this.c = p3;
        this.a();
    }

    public void a() {
        int n2 = g.a;
        q q2 = this.a.c();
        do {
            if (!q2.f()) return;
            this.b(this.a(q2.a()));
            q2.g();
        } while (n2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private void b(D var1_1) {
        var4_2 = g.a;
        var2_3 = var1_1.size();
        var3_4 = 0;
        do lbl-1000: // 3 sources:
        {
            if (var3_4 >= var2_3) return;
            if (!this.a(var1_1)) ** GOTO lbl10
            var3_4 = 0;
            var2_3 = var1_1.size();
            if (var4_2 == 0) ** GOTO lbl-1000
lbl10: // 2 sources:
            var1_1.add(var1_1.g());
            ++var3_4;
        } while (var4_2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private D a(y.f.h.p var1_1) {
        var14_2 = g.a;
        var2_3 = new D();
        var3_4 = var1_1.a();
        do {
            if (var3_4.f() == false) return var2_3;
            var4_5 = var3_4.a();
            if (this.a.d(var4_5) == 2) ** GOTO lbl36
            if (this.a.h(var4_5) != o.a && this.a.h(var4_5) != o.c) ** GOTO lbl-1000
            var5_6 = this.c;
            var6_7 = this.b;
            if (var14_2 != 0) lbl-1000: // 2 sources:
            {
                var5_6 = this.b;
                var6_7 = this.c;
            }
            var7_8 = var6_7.a(var4_5);
            var8_9 = var4_5.c();
            var9_10 = new y.f.f.d.p(var7_8);
            var10_11 = var5_6.a(var8_9);
            var11_12 = new y.f.f.d.p(var10_11);
            switch (this.a.d(var4_5)) {
                case 1: {
                    var12_13 = new b(var11_12, var9_10, 0, this.a.h(var4_5), 2);
                    var2_3.add(var12_13);
                    if (var14_2 == 0) ** GOTO lbl36
                }
                case 3: {
                    var12_13 = new b(var11_12, var9_10, 1, this.a.h(var4_5), 2);
                    var2_3.add(var12_13);
                    if (var14_2 == 0) ** GOTO lbl36
                }
                case 4: {
                    var13_14 = this.a.h(var4_5).b();
                    var12_13 = new b(var9_10, var11_12, 1, var13_14, 2);
                    var2_3.add(var12_13);
                    var12_13 = new b(var11_12, var9_10, 1, this.a.h(var4_5), 2);
                    var2_3.add(var12_13);
                    if (var14_2 == 0) ** GOTO lbl36
                }
            }
            System.err.println("Impossible Angle !");
lbl36: // 5 sources:
            var3_4.g();
        } while (var14_2 == 0);
        return var2_3;
    }

    public boolean a(D d2) {
        int n2 = g.a;
        if (d2.size() < 4) {
            return false;
        }
        y.c.p p2 = d2.l();
        b b2 = (b)p2.c();
        p2 = p2.b();
        b b3 = (b)p2.c();
        p2 = p2.b();
        b b4 = (b)p2.c();
        b b5 = (b)(p2 = p2.b()).c();
        if (b5.b() != 1) return false;
        if (b4.b() != 0) return false;
        if (b3.b() != 0) return false;
        d2.j();
        d2.j();
        d2.j();
        d2.j();
        b b6 = new b(b5.d(), b3.e(), 0, b3.c(), 2);
        d2.add(b6);
        d2.add(b2);
        y.f.f.d.p p3 = b5.d();
        y.f.f.d.p p4 = b2.e();
        if (b5.c().a(o.d)) {
            y.f.f.d.p.a(this.b, p3, p4, 1);
            if (n2 == 0) return true;
        }
        if (b5.c().a(o.b)) {
            y.f.f.d.p.a(this.b, p4, p3, 1);
            if (n2 == 0) return true;
        }
        if (b5.c().a(o.c)) {
            y.f.f.d.p.a(this.c, p4, p3, 1);
            if (n2 == 0) return true;
        }
        if (b5.c().a(o.a)) {
            y.f.f.d.p.a(this.c, p3, p4, 1);
            if (n2 == 0) return true;
        }
        y.g.o.a((Object)"Consistency Error in rect decomp.");
        return true;
    }
}

