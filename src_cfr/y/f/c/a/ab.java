/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.HashMap;
import y.c.A;
import y.c.c;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.c.a.N;
import y.f.c.a.O;
import y.f.c.a.bK;
import y.g.M;

final class aB {
    private final c a;
    private final A b;
    private final c c;
    private final y d;
    private final A e;

    private aB(X x2, c c2, c c3) {
        this.a = c2;
        this.b = M.a();
        this.c = c3;
        this.d = new y();
        this.e = x2.t();
    }

    bK a(q q2) {
        return (bK)this.a.b(q2);
    }

    void a(q q2, bK bK2) {
        this.b.a((Object)q2, bK2);
    }

    x a() {
        return this.d.a();
    }

    x b(q q2) {
        return ((y)this.e.b(q2)).a();
    }

    boolean c(q q2) {
        return this.c.d(q2);
    }

    /*
     * Unable to fully structure code
     */
    void a(X var1_1, c var2_2, c var3_3) {
        block8 : {
            var9_4 = N.x;
            var4_5 = new HashMap<Object, q>();
            var5_6 = var1_1.o();
            while (var5_6.f()) {
                var4_5.put(var2_2.b(var5_6.e()), var5_6.e());
                var5_6.g();
                if (!var9_4) {
                    if (!var9_4) continue;
                }
                break block8;
            }
            var5_6 = var1_1.o();
        }
        do {
            if (var5_6.f() == false) return;
            var6_7 = var3_3.b(var5_6.e());
            var7_8 = (q)var4_5.get(var6_7);
            if (var7_8 == null) ** GOTO lbl-1000
            var8_9 = (y)this.e.b(var7_8);
            if (var8_9 == null) {
                var8_9 = new y();
                this.e.a((Object)var7_8, var8_9);
            }
            var8_9.add(var5_6.e());
            if (var9_4) lbl-1000: // 2 sources:
            {
                if (this.c(var5_6.e())) {
                    this.d.add(var5_6.e());
                }
            }
            if (this.c(var5_6.e())) ** GOTO lbl-1000
            this.b.a((Object)var5_6.e(), this.a.b(var5_6.e()));
            if (var9_4) lbl-1000: // 2 sources:
            {
                if (this.e.b(var5_6.e()) == null) {
                    this.e.a((Object)var5_6.e(), new y());
                }
            }
            var5_6.g();
        } while (!var9_4);
    }

    void a(X x2) {
        x2.a(this.e);
    }

    void b(q q2, bK bK2) {
        boolean bl2 = N.x;
        x x2 = this.b(q2);
        if (x2.k() == 0) {
            this.a(q2, bK2);
            if (!bl2) return;
        }
        do {
            block5 : {
                if (!x2.f()) return;
                q q3 = x2.e();
                bK bK3 = this.a(q3);
                if (bK3 == null) {
                    bK3 = bK2;
                }
                if (this.c(q3)) {
                    this.b(q3, bK3);
                    if (!bl2) break block5;
                }
                this.a(q3, bK3);
            }
            x2.g();
        } while (!bl2);
    }

    aB(X x2, c c2, c c3, O o2) {
        this(x2, c2, c3);
    }

    static A a(aB aB2) {
        return aB2.b;
    }
}

