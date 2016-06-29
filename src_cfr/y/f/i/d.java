/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import y.c.p;
import y.d.t;
import y.f.aA;
import y.f.ax;
import y.f.ay;
import y.f.i.v;

class D {
    private HashMap a;
    private y.c.D[] b;
    private int[] c;
    private y.c.D d;

    /*
     * Unable to fully structure code
     */
    D(ay var1_1) {
        var7_2 = v.f;
        this();
        var2_3 = var1_1.a();
        do lbl-1000: // 4 sources:
        {
            if (var2_3.hasNext() == false) return;
            var3_4 = (aA)var2_3.next();
            var4_5 = var3_4.a();
            this.d.add(var4_5);
            if (!var4_5.b()) ** GOTO lbl16
            var5_6 = D.b(var4_5.c(), var4_5.d());
            var6_7 = var3_4.b();
            if (this.a.containsKey(var5_6)) {
                var6_7 += ((Integer)this.a.get(var5_6)).intValue();
            }
            this.a.put(var5_6, new Integer(var6_7));
            if (var7_2 == 0) ** GOTO lbl-1000
lbl16: // 2 sources:
            if (var4_5.a(1)) {
                v0 = this.c;
                v0[0] = v0[0] + var3_4.b();
            }
            if (var4_5.a(2)) {
                v1 = this.c;
                v1[1] = v1[1] + var3_4.b();
            }
            if (var4_5.a(8)) {
                v2 = this.c;
                v2[2] = v2[2] + var3_4.b();
            }
            if (!var4_5.a(4)) ** GOTO lbl-1000
            v3 = this.c;
            v3[3] = v3[3] + var3_4.b();
        } while (var7_2 == 0);
    }

    D() {
        int n2 = v.f;
        this.a = null;
        this.b = new y.c.D[4];
        this.c = new int[4];
        this.d = new y.c.D();
        this.a = new HashMap();
        int n3 = 0;
        do {
            if (n3 >= 4) return;
            this.b[n3] = new y.c.D();
            this.c[n3] = -1;
            ++n3;
        } while (n2 == 0);
    }

    private static Object b(double d2, double d3) {
        return new t((int)Math.floor(d2 * 10.0), (int)Math.floor(d3 * 10.0));
    }

    public y.c.D a() {
        return this.d;
    }

    public int a(double d2, double d3) {
        Object object = D.b(d2, d3);
        if (!this.a.containsKey(object)) return -1;
        return (Integer)this.a.get(object);
    }

    public int a(int n2) {
        int n3 = 0;
        if ((n2 & 1) != 0) {
            if (this.c[0] < 0) {
                return Integer.MAX_VALUE;
            }
            n3 += this.c[0];
        }
        if ((n2 & 2) != 0) {
            if (this.c[1] < 0) {
                return Integer.MAX_VALUE;
            }
            n3 += this.c[1];
        }
        if ((n2 & 4) != 0) {
            if (this.c[3] < 0) {
                return Integer.MAX_VALUE;
            }
            n3 += this.c[3];
        }
        if ((n2 & 8) == 0) return n3;
        if (this.c[2] < 0) {
            return Integer.MAX_VALUE;
        }
        n3 += this.c[2];
        return n3;
    }

    public p a(t t2, int n2) {
        if (n2 == 1) {
            return this.b[0].b(t2);
        }
        if (n2 == 2) {
            return this.b[1].b(t2);
        }
        if (n2 == 4) {
            return this.b[3].b(t2);
        }
        if (n2 != 8) throw new RuntimeException("unknown direction");
        return this.b[2].b(t2);
    }

    public void a(p p2, int n2) {
        int n3 = v.f;
        if (n2 == 1) {
            this.b[0].h(p2);
            if (n3 == 0) return;
        }
        if (n2 == 2) {
            this.b[1].h(p2);
            if (n3 == 0) return;
        }
        if (n2 == 4) {
            this.b[3].h(p2);
            if (n3 == 0) return;
        }
        if (n2 != 8) throw new RuntimeException("unknown direction");
        this.b[2].h(p2);
        if (n3 == 0) return;
        throw new RuntimeException("unknown direction");
    }

    public y.c.D b(int n2) {
        y.c.D d2 = new y.c.D();
        if ((n2 & 1) != 0) {
            d2.addAll(this.b[0]);
        }
        if ((n2 & 2) != 0) {
            d2.addAll(this.b[1]);
        }
        if ((n2 & 4) != 0) {
            d2.addAll(this.b[3]);
        }
        if ((n2 & 8) == 0) return d2;
        d2.addAll(this.b[2]);
        return d2;
    }
}

