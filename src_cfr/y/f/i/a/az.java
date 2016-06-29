/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import y.c.d;
import y.f.ax;
import y.f.i.a.L;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.S;
import y.f.i.a.Z;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ad;
import y.f.i.a.ba;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.x;
import y.f.y;

class aZ
extends ab {
    private ArrayList b;
    private R c;
    private L d;
    private int e;

    aZ() {
    }

    @Override
    protected void c() {
        super.c();
        this.b = null;
        this.c = null;
        this.d = null;
    }

    @Override
    protected void a(Z z2) {
        super.a(z2);
        this.d = z2.c().k();
    }

    @Override
    protected void b(aa aa2) {
        aU aU2;
        int n2;
        List list;
        int n3;
        block6 : {
            block5 : {
                n3 = ab.a;
                super.b(aa2);
                this.e = aa2.d().f().a();
                this.c = aa2.g();
                d d2 = aa2.c();
                aU2 = this.a().a(d2);
                if (aU2 != null) {
                    list = aU2.a(false);
                    if (n3 == 0) break block5;
                }
                list = null;
            }
            this.b = null;
            if (list == null) return;
            int n4 = 0;
            for (ax ax2 : list) {
                if (ax2.b()) continue;
                n2 = ax2.a();
                if (n3 == 0) {
                    if (n2 != 255) continue;
                    return;
                }
                break block6;
            }
            n2 = n4;
        }
        if (n2 != 0) return;
        this.b = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        do {
            ax ax2;
            if (!iterator.hasNext()) return;
            ax2 = (ax)iterator.next();
            this.b.add(new ba(this, ax2, aU2));
        } while (n3 == 0);
    }

    @Override
    double[] a(f f2, R r2, P[] arrp, v[] arrv, double[] arrd) {
        double d2;
        block5 : {
            if (this.e == 0) {
                this.b("bend penalty", 0.0, false);
                return new double[arrp.length];
            }
            y y2 = f2.d();
            if (y2 == null) {
                this.b("bend penalty", 0.0, false);
                return new double[arrp.length];
            }
            y y3 = arrv[0].l();
            if (y2 == y3) {
                return super.a(f2, r2, arrp, arrv, arrd);
            }
            if (y2.c() == y3) {
                d2 = 2.0;
                if (ab.a == 0) break block5;
            }
            d2 = 1.0;
        }
        double d3 = d2 * (double)this.e;
        this.b("bend penalty", d3, false);
        double[] arrd2 = new double[arrp.length];
        if (d3 <= 0.0) return arrd2;
        Arrays.fill(arrd2, d3);
        return arrd2;
    }

    @Override
    protected double a(f f2, R r2, P p2, v v2, double d2) {
        double d3;
        block2 : {
            if (v2.c() == 1) {
                d3 = 2.0;
                if (ab.a == 0) break block2;
            }
            d3 = 0.0;
        }
        double d4 = d3 * (double)this.e;
        this.a("bend penalty", d4, false);
        return d4;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected double b(f var1_1) {
        var5_2 = ab.a;
        if (this.e == 0 || this.b().d(var1_1.a())) {
            this.a("HEUR bend penalty", 0.0, true);
            return 0.0;
        }
        var3_3 = aZ.a(var1_1, this.c);
        var4_4 = aZ.b(var1_1, this.c);
        if (this.b == null) ** GOTO lbl11
        var2_5 = var3_3 != false ? 2 : (var4_4 != false ? 0 : 1);
        var2_5 = this.a(var1_1, var2_5);
        if (var5_2 == 0) ** GOTO lbl18
lbl11: // 2 sources:
        if (!var3_3) ** GOTO lbl14
        v0 = var2_5 = this.d == null ? 2 : this.c(var1_1, this.c);
        if (var5_2 == 0) ** GOTO lbl18
lbl14: // 2 sources:
        if (!var4_4) ** GOTO lbl-1000
        v1 = var2_5 = this.d == null ? 0 : this.d(var1_1, this.c);
        if (var5_2 != 0) lbl-1000: // 2 sources:
        {
            var2_5 = this.d == null ? 1 : this.e(var1_1, this.c);
        }
lbl18: // 5 sources:
        this.a("HEUR bend penalty", var2_5 * this.e, true);
        return var2_5 * this.e;
    }

    private static boolean a(f f2, R r2) {
        y y2 = f2.d();
        R r3 = f2.a();
        if (y2 == y.b) {
            if (r2.j() > r3.h()) return false;
            return true;
        }
        if (y2 == y.d) {
            if (r3.j() > r2.h()) return false;
            return true;
        }
        if (y2 == y.a) {
            if (r3.k() > r2.i()) return false;
            return true;
        }
        if (r2.k() > r3.i()) return false;
        return true;
    }

    private static boolean b(f f2, R r2) {
        P p2;
        y y2 = f2.d();
        if (y2.d()) {
            p2 = r2.a(S.d);
            if (ab.a == 0) return f2.c().a(p2, 0.1);
        }
        p2 = r2.a(S.a);
        return f2.c().a(p2, 0.1);
    }

    private int c(f f2, R r2) {
        y y2 = f2.d();
        P p2 = this.b(r2, y2);
        P p3 = this.c(r2, y2);
        if (this.d.a(p2)) return 2;
        if (!this.d.a(p3)) return 2;
        return 3;
    }

    private int d(f f2, R r2) {
        y y2 = f2.d();
        P p2 = this.a(r2, y2);
        P p3 = this.c(r2, y2);
        P p4 = f2.c();
        P p5 = P.a(p4, p2);
        P p6 = new P(p4.f(), p2.f(), 0.0, !p4.a());
        if (this.d.a(p5)) {
            return 0;
        }
        boolean bl2 = this.d.a(p2);
        boolean bl3 = this.d.a(p3);
        boolean bl4 = this.d.a(p4);
        boolean bl5 = this.d.a(p6);
        if (bl4) {
            if (bl3) return 1;
            if (bl2) return 2;
            return 1;
        }
        if (p4.c(p2)) {
            if (!bl2) {
                if (!bl3) return 0;
            }
            if (!bl5) {
                return 0;
            }
            if (bl3) return 3;
            return 2;
        }
        if (bl3) {
            return 1;
        }
        if (!bl2) return 0;
        if (bl5) return 2;
        return 0;
    }

    private int e(f f2, R r2) {
        y y2 = f2.d();
        P p2 = this.b(r2, y2);
        P p3 = this.c(r2, y2);
        P p4 = f2.c();
        P p5 = new P(p4.f(), y2 == y.b || y2 == y.c ? p3.c() : p3.b(), p3.f(), p3.a());
        if (this.d.a(p5)) return 1;
        if (!this.d.a(p2)) return 1;
        return 2;
    }

    private P a(R r2, y y2) {
        if (y2 == y.b) {
            return r2.a(S.d);
        }
        if (y2 == y.d) {
            return r2.a(S.c);
        }
        if (y2 == y.c) {
            return r2.a(S.a);
        }
        if (y2 != y.a) throw new IllegalArgumentException(new StringBuffer().append("Unknown direction: ").append(y2).toString());
        return r2.a(S.b);
    }

    private P b(R r2, y y2) {
        if (y2 == y.b) {
            return r2.a(S.c);
        }
        if (y2 == y.d) {
            return r2.a(S.d);
        }
        if (y2 == y.c) {
            return r2.a(S.b);
        }
        if (y2 != y.a) throw new IllegalArgumentException(new StringBuffer().append("Unknown direction: ").append(y2).toString());
        return r2.a(S.a);
    }

    private P c(R r2, y y2) {
        if (y2 == y.b) return r2.a(S.a);
        if (y2 == y.d) {
            return r2.a(S.a);
        }
        if (y2 == y.c) return r2.a(S.d);
        if (y2 != y.a) throw new IllegalArgumentException(new StringBuffer().append("Unknown direction: ").append(y2).toString());
        return r2.a(S.d);
    }

    private int a(f f2, int n2) {
        int n3;
        int n4 = ab.a;
        int n5 = Integer.MAX_VALUE;
        if (this.b == null) return n2;
        if (this.b.isEmpty()) return n2;
        block0 : for (ba ba2 : this.b) {
            int n6 = 0;
            block1 : do {
                int n7 = n6;
                int n8 = ba2.a.length;
                while (n7 < n8) {
                    n3 = n5 = Math.min(n5, this.a(f2, ba2.a[n6], ba2.b[n6]));
                    if (n4 != 0) return n3;
                    n8 = n2;
                    if (n4 != 0) continue;
                    if (n3 <= n8) {
                        return n5;
                    }
                    ++n6;
                    if (n4 == 0) continue block1;
                }
                continue block0;
                break;
            } while (true);
        }
        n3 = n5;
        return n3;
    }

    private int a(f f2, P p2, y y2) {
        P p3 = f2.c();
        y y3 = f2.d();
        if (y3 == y2) {
            boolean bl2 = aZ.a(p3.f(), p2.f(), y3);
            if (!bl2) {
                return 4;
            }
            if (!p3.a(p2, p2.d() > 0.0 ? 0.1 : 0.0)) return 2;
            if (p2.d() <= 0.0) return 0;
            if (this.d == null) return 0;
            if (this.d.a(P.a(p3, p2))) return 0;
            if (this.d.a(p3)) return 2;
            if (!this.d.a(p2)) return 0;
            return 2;
        }
        if (y3.c() == y2) {
            P p4 = this.c.a(S.a(y2));
            if (!aZ.a(p3.f(), p4.f(), y3)) return 2;
            if (!p3.c(p4)) return 2;
            return 4;
        }
        boolean bl3 = aZ.a(p2.f(), p3.b(), y2) && aZ.a(p2.f(), p3.c(), y2) || this.d != null && this.a(p3, p2, y2);
        boolean bl4 = !aZ.a(p3.f(), p2.b(), y3) && !aZ.a(p3.f(), p2.c(), y3) || this.d != null && this.b(p3, p2, y3);
        if (bl3) return 3;
        if (bl4) return 3;
        return 1;
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(P var1_1, P var2_2, y var3_3) {
        if (!var1_1.e().a(var2_2.f())) {
            return false;
        }
        if (var3_3 != y.b && var3_3 != y.c) ** GOTO lbl-1000
        var4_4 = new P(var1_1.b(), var2_2.f(), 0.0, var1_1.a());
        var5_5 = new P(var1_1.c(), var2_2.f(), 0.0, var1_1.a());
        if (ab.a != 0) lbl-1000: // 2 sources:
        {
            var4_4 = new P(var1_1.c(), var2_2.f(), 0.0, var1_1.a());
            var5_5 = new P(var1_1.b(), var2_2.f(), 0.0, var1_1.a());
        }
        if (this.d.a(var4_4) != false) return false;
        if (this.d.a(var5_5) == false) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private boolean b(P var1_1, P var2_2, y var3_3) {
        if (!var2_2.e().a(var1_1.f())) {
            return false;
        }
        if (var3_3 != y.b && var3_3 != y.c) ** GOTO lbl-1000
        var4_4 = new P(var2_2.c(), var1_1.f(), 0.0, var2_2.a());
        var5_5 = new P(var2_2.b(), var1_1.f(), 0.0, var2_2.a());
        if (ab.a != 0) lbl-1000: // 2 sources:
        {
            var4_4 = new P(var2_2.b(), var1_1.f(), 0.0, var2_2.a());
            var5_5 = new P(var2_2.c(), var1_1.f(), 0.0, var2_2.a());
        }
        if (this.d.a(var4_4) != false) return false;
        if (this.d.a(var5_5) == false) return false;
        return true;
    }

    private static boolean a(double d2, double d3, y y2) {
        if (y.b == y2 || y.c == y2) {
            if (d3 <= d2) return false;
            return true;
        }
        if (d3 >= d2) return false;
        return true;
    }

    private static y b(int n2) {
        switch (n2) {
            case 1: {
                return y.c;
            }
            case 2: {
                return y.a;
            }
            case 4: {
                return y.d;
            }
            case 8: {
                return y.b;
            }
        }
        return y.c;
    }

    static y a(int n2) {
        return aZ.b(n2);
    }

    static R a(aZ aZ2) {
        return aZ2.c;
    }
}

