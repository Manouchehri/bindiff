/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.HashMap;
import java.util.Map;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.k;
import y.c.q;
import y.c.x;
import y.c.y;
import y.g.C;
import y.g.E;
import y.g.G;
import y.g.H;
import y.g.p;

public class B {
    private C a;
    private boolean b;
    private boolean c;
    private boolean d;

    public B() {
        this.a = new k();
    }

    public B(C c2) {
        if (c2 == null) {
            throw new NullPointerException("copyFactory");
        }
        this.a = c2;
    }

    public y a(i i2, i i3) {
        return this.a(i2, this.b(i2), i3);
    }

    public C a() {
        return this.a;
    }

    public void a(C c2) {
        if (c2 == null) {
            throw new NullPointerException();
        }
        this.a = c2;
    }

    private C a(C c2, i i2) {
        C c3;
        boolean bl2 = p.c;
        if (this.c) {
            c2 = new H(c2);
        }
        if (this.d) {
            c2 = new E(c2);
        }
        if (this.b) {
            Object[] arrobject = i2.z();
            for (int i3 = 0; i3 < arrobject.length; ++i3) {
                Object object = arrobject[i3];
                c3 = new G(c2, object);
                if (bl2) return c3;
                c2 = c3;
                if (!bl2) continue;
            }
        }
        c3 = c2;
        return c3;
    }

    public y a(i i2, x x2, i i3) {
        return this.a(this.a(this.a, i2), i2, x2, null, i3);
    }

    public y a(i i2, x x2, e e2, i i3) {
        return this.a(this.a(this.a, i2), i2, x2, e2, i3);
    }

    /*
     * Unable to fully structure code
     */
    private y a(C var1_1, i var2_2, x var3_3, e var4_4, i var5_5) {
        var16_6 = p.c;
        this.a(var1_1, var2_2, var5_5);
        var6_7 = new y();
        var7_8 = this.c();
        var8_9 = this.b();
        if (var2_2 == var5_5) {
            var3_3 = new y(var3_3).a();
        }
        while (var3_3.f()) {
            var9_10 = var3_3.e();
            var10_11 = this.a(var1_1, var5_5, (q)var9_10);
            var7_8.put(var9_10, var10_11);
            var6_7.add(var10_11);
            var3_3.g();
            if (!var16_6) {
                if (!var16_6) continue;
            }
            ** GOTO lbl-1000
        }
        if (var4_4 != null) {
            v0 = var4_4;
        } else lbl-1000: // 2 sources:
        {
            v0 = var9_10 = this.a(var2_2);
        }
        if (var2_2 == var5_5) {
            var9_10 = new f((e)var9_10).a();
        }
        while (var9_10.f()) {
            var10_13 = var9_10.a();
            var11_14 = var10_13.c();
            var12_15 = var10_13.d();
            var13_16 = (q)var7_8.get(var11_14);
            var14_17 = (q)var7_8.get(var12_15);
            if (var16_6 != false) return var6_7;
            if (var13_16 != null && var14_17 != null) {
                var15_18 = this.a(var1_1, var5_5, var13_16, var14_17, var10_13);
                if (var8_9 != null) {
                    var8_9.put(var10_13, var15_18);
                }
            }
            var9_10.g();
            if (!var16_6) continue;
        }
        this.a(var1_1, var2_2, var5_5, var7_8, var8_9);
        return var6_7;
    }

    protected void a(C c2, i i2, i i3) {
        c2.a(i2, i3);
    }

    protected void a(C c2, i i2, i i3, Map map, Map map2) {
        c2.a(i2, i3, map, map2);
    }

    protected Map b() {
        return new HashMap();
    }

    protected d a(C c2, i i2, q q2, q q3, d d2) {
        return c2.a(i2, q2, q3, d2);
    }

    protected e a(i i2) {
        return i2.p();
    }

    protected q a(C c2, i i2, q q2) {
        return c2.a(i2, q2);
    }

    protected Map c() {
        return new HashMap();
    }

    protected x b(i i2) {
        return i2.o();
    }
}

