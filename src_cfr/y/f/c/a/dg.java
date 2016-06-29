/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.awt.geom.Rectangle2D;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import y.a.g;
import y.a.z;
import y.c.A;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.p;
import y.c.x;
import y.d.q;
import y.d.r;
import y.d.y;
import y.f.X;
import y.f.am;
import y.f.b.f;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.aY;
import y.f.c.a.cr;
import y.f.c.a.cy;
import y.f.c.a.da;
import y.f.c.a.dd;
import y.f.c.a.dh;
import y.g.M;
import y.g.e;

class dg {
    y.c.q f;
    private D a;
    aQ g;
    aQ h;
    float i;
    float j;
    int k;
    int l;
    float m;
    float n;
    int o;
    int p;
    da[] q;
    private float b;
    int r;
    BitSet s;
    int t;
    int u;
    boolean v;
    Rectangle2D w;
    double x;
    double y;
    public y z;
    public aQ A;
    public aQ B;
    E C;
    HashSet D;
    double E;
    double F;
    HashMap G = new HashMap();

    dg(E e2, y.c.q q2) {
        this.C = e2;
        if (q2 != null) {
            this.f = q2;
            X x2 = (X)q2.e();
            am am2 = x2.a(q2);
            this.z = new y(am2.getX(), am2.getY(), am2.getWidth(), am2.getHeight());
        }
        this.a = new D();
        this.D = new HashSet();
    }

    void b(Object object) {
        if (this.D.contains(object)) return;
        this.a.b(object);
        this.D.add(object);
    }

    /*
     * Unable to fully structure code
     */
    public void a(aU var1_1, int var2_2, aV var3_3) {
        block8 : {
            var18_4 = N.x;
            if (this.g == null) return;
            if (this.h == null) return;
            if (this.g.c() > var2_2) return;
            if (this.h.c() < var2_2) return;
            var4_5 = false;
            var5_6 = this.b(var2_2);
            var6_7 = null;
            var7_8 = null;
            var8_9 = var3_3.a((y.c.q)var5_6.f()).k();
            var9_10 = var3_3.a((y.c.q)var5_6.i()).k();
            var10_11 = var5_6.k();
            while (var10_11 != null) {
                block9 : {
                    v0 = var10_11.c() instanceof y.c.q;
                    if (var18_4) break block8;
                    if (!v0) ** GOTO lbl-1000
                    var11_12 = (y.c.q)var10_11.c();
                    var12_13 = var3_3.a((y.c.q)var11_12);
                    if (var12_13.b() != 15) ** GOTO lbl43
                    if (!var4_5) {
                        this.G.clear();
                        var6_7 = new y.c.y();
                        var7_8 = new y.c.y();
                    }
                    var4_5 = true;
                    if (var12_13.e() <= 0) ** GOTO lbl43
                    var13_14 = 0.0;
                    for (var15_15 = var12_13.d(); var15_15 != null; var13_14 += (double)var17_18.k(), var15_15 = var15_15.a()) {
                        var16_17 = (d)var15_15.c();
                        var17_18 = var3_3.a(var16_17.a((y.c.q)var11_12));
                        if (!var18_4) {
                            if (!var18_4) continue;
                        }
                        break block9;
                    }
                    if (Math.abs((var15_16 = var13_14 / (double)var12_13.e()) - (double)var8_9) >= Math.abs((double)var9_10 - var15_16)) ** GOTO lbl-1000
                    var6_7.add(var11_12);
                    this.G.put(var11_12, new Double(var15_16));
                    if (var18_4) lbl-1000: // 2 sources:
                    {
                        var7_8.add(var11_12);
                        this.G.put(var11_12, new Double(- var15_16));
                    }
                    var5_6.h((p)var10_11);
                    if (var18_4) lbl-1000: // 2 sources:
                    {
                        var11_12 = (dg)var10_11.c();
                        var11_12.a(var1_1, var2_2, var3_3);
                    }
lbl43: // 5 sources:
                    var10_11 = var10_11.a();
                }
                if (!var18_4) continue;
            }
            v0 = var4_5;
        }
        if (v0 == false) return;
        var10_11 = e.c(M.a(this.G));
        var6_7.sort((Comparator)var10_11);
        var7_8.sort((Comparator)var10_11);
        while (!var6_7.isEmpty()) {
            var5_6.b(var6_7.g(), var5_6.k());
            if (var18_4 != false) return;
            if (!var18_4) continue;
        }
        do {
            if (var7_8.isEmpty() != false) return;
            var5_6.a(var7_8.g(), var5_6.l());
        } while (!var18_4);
    }

    /*
     * Unable to fully structure code
     */
    void a(aQ var1_1, X var2_2) {
        var9_3 = N.x;
        var3_4 = var1_1.c();
        var4_5 = this.b(var3_4);
        var4_5.f = 0.0;
        var5_6 = var4_5.k();
        do {
            if (var5_6 == null) return;
            if (!(var5_6.c() instanceof y.c.q)) ** GOTO lbl-1000
            var6_7 = var2_2.a(var5_6.c());
            var4_5.f = Math.max(var4_5.f, var6_7.getHeight());
            if (var9_3) lbl-1000: // 2 sources:
            {
                var6_7 = (dg)var5_6.c();
                var6_7.a(var1_1, var2_2);
                var7_8 = var6_7.b(var3_4);
                var8_9 = var2_2.a(var7_8.f());
                var8_9.setSize(var8_9.getWidth(), var7_8.f);
                var8_9 = var2_2.a(var7_8.i());
                var8_9.setSize(var8_9.getWidth(), var7_8.f);
                var4_5.f = Math.max(var4_5.f, var7_8.f);
            }
            var5_6 = var5_6.a();
        } while (!var9_3);
    }

    void a(int n2) {
        boolean bl2 = N.x;
        if (this.g.c() <= n2 && this.h.c() >= n2) {
            da da2 = this.b(n2);
            int n3 = 0;
            p p2 = da2.k();
            do {
                if (p2 == null) return;
                if (p2.c() instanceof dg) {
                    dg dg2 = (dg)p2.c();
                    dg2.r = n3++;
                    dg2.a(n2);
                }
                p2 = p2.a();
            } while (!bl2);
        }
        this.r = -1;
    }

    void b() {
        boolean bl2 = N.x;
        i i2 = new i();
        A a2 = i2.t();
        if (this.g == null) return;
        if (this.h == null) return;
        int n2 = this.g.c();
        int n3 = this.h.c();
        HashMap<dg, y.c.q> hashMap = new HashMap<dg, y.c.q>();
        int n4 = n2;
        block0 : do {
            int n5 = n4;
            block1 : while (n5 <= n3) {
                da da2 = this.b(n4);
                y.c.q q2 = null;
                dg dg2 = null;
                if (bl2) return;
                for (p p2 = da2.k(); p2 != null; p2 = p2.a()) {
                    Object object = p2.c();
                    n5 = object instanceof dg;
                    if (bl2) continue block1;
                    if (n5 == 0) continue;
                    dg dg3 = (dg)object;
                    y.c.q q3 = (y.c.q)hashMap.get(dg3);
                    if (q3 == null) {
                        q3 = i2.d();
                        hashMap.put(dg3, q3);
                        a2.a((Object)q3, dg3);
                    }
                    if (q2 != null && q2.a(q3) == null) {
                        if (q3.a(q2) != null) {
                            throw new IllegalStateException(new StringBuffer().append("grouping inconsistent ").append(dg2).append(" <-- ").append(dg3).toString());
                        }
                        d d2 = i2.a(q2, q3);
                    }
                    q2 = q3;
                    dg2 = dg3;
                    if (!bl2) continue;
                }
                ++n4;
                if (!bl2) continue block0;
            }
            break block0;
            break;
        } while (true);
        if (!g.b(i2)) return;
        throw new IllegalStateException("grouping inconsistent");
    }

    p a(int n2, p p2) {
        p p3;
        boolean bl2 = N.x;
        for (p p4 = this.b((int)n2).k(); p4 != null; p4 = p4.a()) {
            Object object;
            p3 = p4;
            if (bl2) return p3;
            Object object2 = p3.c();
            if (object2 instanceof dg) {
                object = (dg)object2;
                p2 = object.a(n2, p2);
                if (!bl2) continue;
            }
            object = (y.c.q)object2;
            p2.a(object2);
            p2 = p2.a();
            if (!bl2) continue;
        }
        p3 = p2;
        return p3;
    }

    void c() {
        i i2;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        dg dg2;
        boolean bl2;
        A a2;
        block8 : {
            bl2 = N.x;
            if (this.g == null) return;
            if (this.h == null) {
                return;
            }
            i2 = new i();
            a2 = i2.t();
            int n2 = this.g.c();
            int n3 = this.h.c();
            int n4 = 0;
            HashMap<dg, y.c.q> hashMap = new HashMap<dg, y.c.q>();
            int n5 = n2;
            block0 : do {
                int n6 = n5;
                block1 : while (n6 <= n3) {
                    object2 = this.b(n5);
                    object3 = null;
                    if (bl2) break block8;
                    for (object4 = object2.k(); object4 != null; object4 = object4.a()) {
                        object = object4.c();
                        n6 = object instanceof dg;
                        if (bl2) continue block1;
                        if (n6 == 0) continue;
                        dg2 = (dg)object;
                        y.c.q q2 = (y.c.q)hashMap.get(dg2);
                        if (q2 == null) {
                            q2 = i2.d();
                            hashMap.put(dg2, q2);
                            a2.a((Object)q2, dg2);
                            dg2.t = n4++;
                        }
                        if (object3 != null && object3.a(q2) == null) {
                            d d2 = i2.a((y.c.q)object3, q2);
                        }
                        object3 = q2;
                        if (!bl2) continue;
                    }
                    ++n5;
                    if (!bl2) continue block0;
                }
                break block0;
                break;
            } while (true);
            z.a(i2);
        }
        x x2 = i2.o();
        block3 : do {
            if (!x2.f()) return;
            object2 = x2.e();
            object3 = (dg)a2.b(object2);
            object3.s = new BitSet(i2.e());
            for (object4 = object2.f(); object4 != null; object4 = object4.g()) {
                object = object4.d();
                dg2 = (dg)a2.b(object);
                object3.s.set(dg2.t);
                if (bl2) continue block3;
                if (!bl2) continue;
            }
            object3.c();
            x2.g();
        } while (!bl2);
    }

    void a(int n2, boolean bl2, c c2) {
        Object object;
        boolean bl3;
        Object object2;
        int n3;
        da da2;
        block19 : {
            Object object3;
            bl3 = N.x;
            da2 = this.b(n2);
            for (object3 = da2.k(); object3 != null; object3 = object3.a()) {
                object2 = object3.c();
                n3 = object2 instanceof dg;
                if (!bl3) {
                    if (n3 == 0) continue;
                    object = (dg)object2;
                    object.v = object.l > 0;
                    if (!bl3) continue;
                }
                break block19;
            }
            object3 = da2.k();
            while (object3 != null) {
                object2 = object3.c();
                n3 = object2 instanceof dg;
                if (bl3) break block19;
                if (n3 != 0) {
                    boolean bl4;
                    object = (dg)object2;
                    boolean bl5 = bl4 = bl2 && object.g.c() < n2 || !bl2 && object.h.c() > n2;
                    if (!object.v) {
                        int n4;
                        Object object4;
                        boolean bl6;
                        p p2 = null;
                        p p3 = object3.b();
                        while (p3 != null) {
                            n3 = p3.c() instanceof dg;
                            if (!bl3) {
                                if (n3 != 0) {
                                    object4 = (dg)p3.c();
                                    boolean bl7 = bl6 = bl2 && object4.g.c() < n2 || !bl2 && object4.h.c() > n2;
                                    int n5 = object4.v ? object.a((dg)object4, bl4 && bl6) : (n4 = 0);
                                    if (n4 == 0) {
                                        p3 = p3.b();
                                        if (!bl3) continue;
                                    }
                                    if (n4 < 0) {
                                        p2 = p3;
                                        p3 = p3.b();
                                        if (!bl3) continue;
                                    }
                                    if (n4 <= 0) continue;
                                    break;
                                }
                                p3 = p3.b();
                                if (!bl3) continue;
                            }
                            break block19;
                        }
                        if (p2 != null) {
                            object4 = object3.a();
                            da2.h((p)object3);
                            da2.a((p)object3, p2);
                            object3 = object4;
                            object.v = true;
                            if (!bl3) continue;
                        }
                        p3 = object3.a();
                        while (p3 != null) {
                            n3 = p3.c() instanceof dg;
                            if (!bl3) {
                                if (n3 != 0) {
                                    object4 = (dg)p3.c();
                                    boolean bl8 = bl6 = bl2 && object4.g.c() < n2 || !bl2 && object4.h.c() > n2;
                                    int n6 = object4.v ? object.a((dg)object4, bl4 && bl6) : (n4 = 0);
                                    if (n4 == 0) {
                                        p3 = p3.a();
                                        if (!bl3) continue;
                                    }
                                    if (n4 > 0) {
                                        p2 = p3;
                                        p3 = p3.a();
                                        if (!bl3) continue;
                                    }
                                    if (n4 >= 0) continue;
                                    break;
                                }
                                p3 = p3.a();
                                if (!bl3) continue;
                            }
                            break block19;
                        }
                        if (p2 != null) {
                            object4 = object3.a();
                            da2.h((p)object3);
                            da2.b((p)object3, p2);
                            object3 = object4;
                            object.v = true;
                            if (!bl3) continue;
                        }
                        object.v = true;
                    }
                }
                object3 = object3.a();
                if (!bl3) continue;
            }
            n3 = 0;
        }
        int n7 = n3;
        object2 = da2.k();
        do {
            if (object2 == null) return;
            object = object2.c();
            if (object instanceof dg) {
                dg dg2 = (dg)object;
                dg2.r = n7++;
                dg2.a(n2, bl2, c2);
            }
            object2 = object2.a();
        } while (!bl3);
    }

    int a(dg dg2, boolean bl2) {
        if (bl2 && this.r >= 0 && dg2.r >= 0) {
            return this.r - dg2.r;
        }
        if (this.s == null) return 0;
        if (dg2.s == null) return 0;
        if (this.s.get(dg2.t)) {
            return -1;
        }
        if (!dg2.s.get(this.t)) return 0;
        return 1;
    }

    /*
     * Unable to fully structure code
     */
    void d() {
        var4_1 = N.x;
        var1_2 = this.a.iterator();
        do lbl-1000: // 4 sources:
        {
            if (var1_2.hasNext() == false) return;
            var2_3 = var1_2.next();
            if (!(var2_3 instanceof dg)) ** GOTO lbl-1000
            var3_4 = (dg)var2_3;
            var3_4.d();
            if (var3_4.g != null && (this.g == null || var3_4.g.c() < this.g.c())) {
                this.g = var3_4.g;
            }
            if (var3_4.A != null && (this.A == null || var3_4.A.c() < this.A.c())) {
                this.A = var3_4.A;
            }
            if (var3_4.h != null && (this.h == null || var3_4.h.c() > this.h.c())) {
                this.h = var3_4.h;
            }
            if (var3_4.B == null || this.B != null && var3_4.B.c() <= this.B.c()) ** GOTO lbl-1000
            this.B = var3_4.B;
        } while (!var4_1);
    }

    void e() {
        boolean bl2 = N.x;
        int n2 = this.g.c();
        int n3 = this.h.c();
        this.q = new da[n3 - n2 + 1];
        int n4 = n2;
        do {
            if (n4 > n3) return;
            this.q[n4 - n2] = new da();
            ++n4;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    void a(aU var1_1, aV var2_2, dd var3_3) {
        block5 : {
            var12_4 = N.x;
            if (this.g == null) return;
            if (this.h == null) {
                return;
            }
            var4_5 = this.g.c();
            var5_6 = this.h.c();
            this.q = new da[var5_6 - var4_5 + 1];
            for (var6_7 = var4_5; var6_7 <= var5_6; ++var6_7) {
                v0 = this;
                if (!var12_4) {
                    v0.q[var6_7 - var4_5] = new da();
                    if (!var12_4) continue;
                }
                break block5;
            }
            v0 = this;
        }
        var6_8 = v0.a.iterator();
        block1 : do lbl-1000: // 6 sources:
        {
            if (var6_8.hasNext() == false) return;
            var7_9 = var6_8.next();
            if (!(var7_9 instanceof y.c.q)) ** GOTO lbl27
            var8_10 = (y.c.q)var7_9;
            if (var8_10.e() == null || var3_3.a(var8_10) != this) ** GOTO lbl-1000
            var9_11 = var2_2.a((y.c.q)var8_10).j();
            if (this.g.c() > var9_11 || this.h.c() < var9_11) ** GOTO lbl-1000
            this.b(var9_11).add(var8_10);
            if (!var12_4) ** GOTO lbl-1000
lbl27: // 2 sources:
            var8_10 = (dg)var7_9;
            if (var8_10.g == null || var8_10.h == null) ** GOTO lbl-1000
            var8_10.a(var1_1, var2_2, var3_3);
            var9_11 = var8_10.g.c();
            var10_12 = var8_10.h.c();
            var11_13 = var9_11;
            do {
                if (var11_13 > var10_12) continue block1;
                this.b(var11_13).add(var8_10);
                ++var11_13;
                if (var12_4 != false) return;
            } while (!var12_4);
            break;
        } while (true);
    }

    void a(int n2, float[] arrf, c c2, aV aV2, boolean bl2) {
        this.a(n2, arrf, c2, bl2);
        dh dh2 = new dh(this, arrf);
        this.a(n2, dh2, aV2);
    }

    private void a(int n2, Comparator comparator, aV aV2) {
        p p2;
        da da2;
        block5 : {
            Object object;
            boolean bl2 = N.x;
            da2 = this.b(n2);
            da2.sort(comparator);
            p p3 = null;
            p2 = null;
            for (p p4 = da2.k(); p4 != null; p4 = p4.a()) {
                object = p4.c();
                if (!bl2) {
                    byte by2;
                    y.c.q q2;
                    if (object instanceof dg) {
                        ((dg)p4.c()).a(n2, comparator, aV2);
                        if (!bl2) continue;
                    }
                    if ((by2 = aV2.a(q2 = (y.c.q)p4.c()).b()) == 12) {
                        p3 = p4;
                        if (!bl2) continue;
                    }
                    if (by2 != 13) continue;
                    p2 = p4;
                    if (!bl2) continue;
                }
                break block5;
            }
            if (p3 != null && p3 != da2.k()) {
                da2.h(p3);
                da2.a(p3, da2.k());
            }
            if (p2 == null) return;
            if (p2 == da2.l()) return;
            object = da2.h(p2);
        }
        da2.b(p2, da2.l());
    }

    da b(int n2) {
        return this.q[n2 - this.g.c()];
    }

    /*
     * Unable to fully structure code
     */
    private void a(int var1_1, float[] var2_2, c var3_3, boolean var4_4) {
        block9 : {
            var9_5 = N.x;
            this.n = 0.0f;
            this.m = 0.0f;
            this.j = 0.0f;
            this.i = 0.0f;
            this.p = 0;
            this.o = 0;
            this.l = 0;
            this.k = 0;
            for (E var6_7 : this.b(var1_1)) {
                v0 = var6_7 instanceof dg;
                if (var9_5) break block9;
                if (v0 != 0) {
                    var7_8 = (dg)var6_7;
                    super.a(var1_1, var2_2, var3_3, var4_4);
                    this.i += var7_8.i;
                    this.k += var7_8.k;
                    this.j += var7_8.j;
                    this.l += var7_8.l;
                    this.m += var7_8.m;
                    this.o += var7_8.o;
                    this.n += var7_8.n;
                    this.p += var7_8.p;
                    if (!var9_5) continue;
                }
                var7_8 = (y.c.q)var6_7;
                v1 = var8_9 = var4_4 != false && var7_8.b() > 0 || var4_4 == false && var7_8.c() > 0;
                if (var3_3 == null) ** GOTO lbl-1000
                if (!var3_3.d(var7_8)) {
                    if (var8_9) {
                        ++this.l;
                        this.j += var2_2[var7_8.d()];
                    }
                    ++this.p;
                    this.n += var2_2[var7_8.d()];
                    if (!var9_5) continue;
                }
                if (var8_9) lbl-1000: // 2 sources:
                {
                    ++this.k;
                    this.i += var2_2[var7_8.d()];
                }
                ++this.o;
                this.m += var2_2[var7_8.d()];
                if (!var9_5) continue;
            }
            v0 = this.l;
        }
        if (v0 > 0) {
            this.b = this.j / (float)this.l;
            if (var9_5 == false) return;
        }
        if (this.k > 0) {
            this.b = this.i / (float)this.k;
            if (var9_5 == false) return;
        }
        if (this.p > 0) {
            this.b = this.n / (float)this.p;
            if (var9_5 == false) return;
        }
        if (this.o > 0) {
            this.b = this.m / (float)this.o;
            if (var9_5 == false) return;
        }
        this.b = 0.0f;
    }

    p a(aQ aQ2, p p2, aP aP2, dd dd2) {
        p p3;
        Object object;
        Object object2;
        boolean bl2 = N.x;
        if (this.g == null) return p2;
        if (this.g.c() > aQ2.c()) return p2;
        if (this.h == null) return p2;
        if (this.h.c() < aQ2.c()) {
            return p2;
        }
        y.c.y y2 = aQ2.d();
        da da2 = this.b(aQ2.c());
        boolean bl3 = true;
        if (da2.size() > 1 && da2.f() instanceof y.c.q && da2.i() instanceof y.c.q) {
            object = dd2.b.a((y.c.q)da2.f());
            object2 = dd2.b.a((y.c.q)da2.i());
            if (object.b() == 12 && object2.b() == 13) {
                bl3 = false;
            }
        }
        for (object = da2.k(); object != null; object = object.a()) {
            p3 = object;
            if (bl2) return p3;
            object2 = p3.c();
            if (object2 instanceof dg) {
                dg dg2 = (dg)object2;
                if (bl3) {
                    y.c.q q2;
                    y.c.q q3;
                    block8 : {
                        q3 = aP2.a(dg2.f, aQ2, 12);
                        y2.a(q3, p2);
                        p2 = dg2.a(aQ2, p2, aP2, dd2);
                        q2 = aP2.a(dg2.f, aQ2, 13);
                        if (p2 != null) {
                            y2.a(q2, p2);
                            if (!bl2) break block8;
                        }
                        y2.b(q2);
                    }
                    dg2.b(aQ2.c()).a(q3);
                    dg2.b(aQ2.c()).b(q2);
                    dd2.a(q3, dg2);
                    dd2.a(q2, dg2);
                    if (!bl2) continue;
                }
                p2 = dg2.a(aQ2, p2, aP2, dd2);
                if (!bl2) continue;
            }
            p2 = p2.a();
            if (!bl2) continue;
        }
        p3 = p2;
        return p3;
    }

    public void b(aV aV2) {
        Object object;
        Object object2;
        Object object3;
        boolean bl2;
        int n2;
        block6 : {
            bl2 = N.x;
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                object3 = iterator.next();
                n2 = object3 instanceof y.c.q;
                if (!bl2) {
                    if (n2 != 0) {
                        object2 = (y.c.q)object3;
                        object = aV2.a((y.c.q)object2);
                        if (object.b() != 12 && object.b() != 13) continue;
                        iterator.remove();
                        this.D.remove(object3);
                        if (!bl2) continue;
                    }
                    object2 = (dg)object3;
                    object2.b(aV2);
                    if (!bl2) continue;
                }
                break block6;
            }
            if (this.q == null) return;
            n2 = 0;
        }
        int n3 = n2;
        do {
            int n4 = n3;
            block2 : do {
                if (n4 >= this.q.length) return;
                object3 = this.q[n3];
                for (object2 = object3.k(); object2 != null; object2 = object2.a()) {
                    aX aX2;
                    n4 = object2.c() instanceof y.c.q;
                    if (bl2) continue block2;
                    if (n4 == 0 || (aX2 = aV2.a((y.c.q)(object = (y.c.q)object2.c()))).b() != 12 && aX2.b() != 13) continue;
                    object3.h((p)object2);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            ++n3;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    public void a(cr var1_1, aQ var2_2, boolean var3_3, double var4_4) {
        var30_5 = N.x;
        var6_6 = this.C.c;
        var7_7 = this.C.b;
        var8_8 = this.b(var2_2.c());
        var9_9 = null;
        var10_10 = var8_8.k();
        block0 : do {
            if (var10_10 == null) return;
            var11_11 = var10_10.c();
            if (!(var11_11 instanceof dg)) ** GOTO lbl19
            var12_12 = (dg)var11_11;
            var12_12.a(var1_1, var2_2, var3_3, var4_4);
            if (!var3_3 || this.A != var2_2) ** GOTO lbl16
            var1_1.a(this, var12_12, 2);
            if (!var30_5) ** GOTO lbl74
lbl16: // 2 sources:
            if (var3_3 || this.B != var2_2) ** GOTO lbl74
            var1_1.a(var12_12, this, 2);
            if (!var30_5) ** GOTO lbl74
lbl19: // 2 sources:
            var12_12 = (y.c.q)var11_11;
            var13_13 = var6_6.a((y.c.q)var12_12);
            if (!var3_3 || this.A != var2_2) ** GOTO lbl-1000
            if (var13_13.b() != 12) ** GOTO lbl25
            var9_9 = var12_12;
            if (!var30_5) ** GOTO lbl74
lbl25: // 2 sources:
            if (var13_13.b() != 13) ** GOTO lbl-1000
            var14_14 = var7_7.m((y.c.q)var9_9) + var7_7.p((y.c.q)var9_9);
            var16_18 = var7_7.m((y.c.q)var12_12);
            var18_19 = var13_13.f();
            var19_20 = this.C.c(var18_19);
            var20_21 = var6_6.a(var18_19).i();
            var21_22 = Math.max(var20_21 != null ? var20_21.d() : 0.0, this.C.h());
            var23_23 = var19_20.a;
            var25_24 = var21_22;
            var27_25 = var1_1.a(this, 0.0, var25_24, var23_23, (double)var14_14, var3_3 == false, var16_18, var3_3 == false);
            var27_25.l = Math.min(var7_7.k((y.c.q)var9_9), var7_7.k((y.c.q)var12_12)) + var4_4;
            if (var30_5) lbl-1000: // 2 sources:
            {
                if (var13_13.b() == 15) {
                    for (var14_15 = var13_13.d(); var14_15 != null; var14_15 = var14_15.a()) {
                        var15_17 = (d)var14_15.c();
                        var1_1.a(var15_17, this, 1);
                        if (var30_5) continue block0;
                        if (!var30_5) continue;
                    }
                }
            }
            ** GOTO lbl74
lbl-1000: // 2 sources:
            {
                if (var3_3 || this.B != var2_2) break;
                if (var13_13.b() == 12) {
                    var9_9 = var12_12;
                    if (!var30_5) break;
                }
                if (var13_13.b() == 13) {
                    var14_16 = var7_7.m((y.c.q)var9_9) + var7_7.p((y.c.q)var9_9);
                    var16_18 = var7_7.m((y.c.q)var12_12);
                    var18_19 = var13_13.f();
                    var19_20 = this.C.c(var18_19);
                    var20_21 = var6_6.a(var18_19).i();
                    var21_22 = Math.max(var20_21 != null ? var20_21.d() : 0.0, this.C.h());
                    var23_23 = var19_20.c;
                    var25_24 = var21_22;
                    var27_25 = var1_1.a(this, 0.0, var23_23, var25_24, var14_16, var3_3 == false, var16_18, var3_3 == false);
                    var28_26 = var7_7.c(f.f);
                    if (var28_26 != null) {
                        var29_27 = (q)var28_26.b(this.f);
                        if (var29_27 != null) {
                            var27_25.k = this.E + var29_27.b;
                            if (!var30_5) break;
                        }
                        var27_25.k = this.E;
                        if (!var30_5) break;
                    }
                    var27_25.k = this.E;
                    if (!var30_5) break;
                }
                if (var13_13.b() != 15) break;
                for (var14_14 = (Object)var13_13.d(); var14_14 != null; var14_14 = var14_14.a()) {
                    var15_17 = (d)var14_14.c();
                    var1_1.a(this, var15_17, 1);
                    if (var30_5) continue block0;
                    if (!var30_5) continue;
                }
            }
lbl74: // 14 sources:
            var10_10 = var10_10.a();
        } while (!var30_5);
    }

    public Collection f() {
        return this.a;
    }

    static float a(dg dg2) {
        return dg2.b;
    }
}

