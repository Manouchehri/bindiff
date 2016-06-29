/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.n;
import y.c.p;
import y.d.t;
import y.f.O;
import y.f.X;
import y.f.a;
import y.f.aA;
import y.f.aE;
import y.f.aF;
import y.f.am;
import y.f.ax;
import y.f.ay;
import y.f.b.f;
import y.f.i.F;
import y.f.i.G;
import y.f.i.H;
import y.f.i.I;
import y.f.i.J;
import y.f.i.ac;
import y.f.i.v;
import y.f.x;
import y.g.e;
import y.g.q;

public class E
extends a {
    public static final Object a = "y.layout.router.OrthogonalPatternEdgeRouter.AFFECTED_EDGES";
    private double b = 10.0;
    private double c = 1.0;
    private double d = 5.0;
    private double e = 50.0;
    private boolean f;
    private t g = new t(0.0, 0.0);
    private double h = 10.0;
    private t i;
    private List n;
    private List o;
    private int p;
    private int q = 50;
    private int r = 20;
    private final ArrayList s = new ArrayList();
    private Object t = a;
    private c u;
    private double v;
    private byte w = 0;

    public E() {
        this.s.add(ax.b(1));
        this.s.add(ax.b(4));
        this.s.add(ax.b(2));
        this.s.add(ax.b(8));
        this.n = new ArrayList();
        this.o = new ArrayList();
    }

    public void a(byte by2) {
        this.w = by2;
    }

    private boolean e() {
        if (this.w == 1) return true;
        if (this.w == 3) return true;
        return false;
    }

    private boolean f() {
        if (this.w == 2) return true;
        if (this.w == 3) return true;
        return false;
    }

    @Override
    public void c(X x2) {
        X x3;
        block12 : {
            int n2 = v.f;
            boolean bl2 = false;
            if (x2.c("y.layout.router.ORTHOGONAL_PATTERN_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
                this.b(x2);
                x2.a("y.layout.router.ORTHOGONAL_PATTERN_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY", q.a(Boolean.TRUE));
                bl2 = true;
            }
            this.a(x2);
            if (x2.h() > 0) {
                new ac().c(x2);
                this.u = x2.c(this.t);
                boolean bl3 = false;
                this.d(x2);
                D d2 = new D();
                int n3 = 0;
                block0 : do {
                    int n4 = n3;
                    block1 : while (n4 < 2) {
                        x3 = x2;
                        if (n2 != 0) break block12;
                        y.c.e e2 = x3.p();
                        while (e2.f()) {
                            double d3 = Double.MAX_VALUE;
                            d2.clear();
                            d d4 = e2.a();
                            n4 = n3;
                            if (n2 != 0) continue block1;
                            if (!(n4 == 0 && d4.e() || n3 == 1 && !d4.e() || this.u != null && !this.u.d(d4))) {
                                int n5;
                                block13 : {
                                    y.c.q q2 = d4.c();
                                    y.c.q q3 = d4.d();
                                    Collection collection = this.a(x2, d4, true);
                                    Collection collection2 = this.a(x2, d4, false);
                                    for (ax ax2 : collection) {
                                        for (ax ax3 : collection2) {
                                            D d5 = this.a(x2, q2, q3, ax2, ax3);
                                            double d6 = this.a(d4, d5, ax2, ax3);
                                            n5 = (int)(d6 DCMPG d3);
                                            if (n2 == 0) {
                                                D d7;
                                                double d8;
                                                if (n5 < 0) {
                                                    d2 = d5;
                                                    d3 = d6;
                                                    bl3 = false;
                                                }
                                                if ((d8 = this.a(d4, d7 = this.a(x2, q3, q2, ax3, ax2), ax2, ax3)) >= d3) continue;
                                                d2 = d7;
                                                d3 = d8;
                                                bl3 = true;
                                                if (n2 == 0 && n2 == 0) continue;
                                            }
                                            break block13;
                                        }
                                    }
                                    n5 = d2.size();
                                }
                                if (n5 > 1) {
                                    if (bl3) {
                                        d2.n();
                                    }
                                    x2.a(d4, d2);
                                    this.c(d2);
                                }
                            }
                            e2.g();
                            if (n2 == 0) continue;
                        }
                        ++n3;
                        if (n2 == 0) continue block0;
                    }
                    break block0;
                    break;
                } while (true);
            }
            if (!bl2) return;
            x3 = x2;
        }
        x3.d_("y.layout.router.ORTHOGONAL_PATTERN_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY");
    }

    private void b(X x2) {
        this.a(x2, x2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(n var1_1, O var2_2) {
        var6_3 = v.f;
        var3_4 = var1_1.c(f.d);
        if (var3_4 == null) {
            var3_4 = q.a(Boolean.FALSE);
        }
        var4_5 = var1_1.x();
        do lbl-1000: // 3 sources:
        {
            if (var4_5.hasNext() == false) return;
            var5_6 = var4_5.next();
            if (var3_4.d(var5_6)) ** GOTO lbl12
            this.a(var2_2, var5_6);
            if (var6_3 == 0) ** GOTO lbl-1000
lbl12: // 2 sources:
            this.b(var2_2, var5_6);
        } while (var6_3 == 0);
    }

    protected void a(O o2, Object object) {
        am am2 = o2.a(object);
        if (am2.getWidth() == 0.0) throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        if (am2.getHeight() != 0.0) return;
        throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
    }

    protected void b(O o2, Object object) {
        am am2 = o2.a(object);
        if (am2.getWidth() == 0.0) throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        if (am2.getHeight() != 0.0) return;
        throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
    }

    private Collection a(am am2) {
        HashSet<ax> hashSet = new HashSet<ax>();
        hashSet.add(ax.a((- am2.getWidth()) * 0.5 + this.b, (- am2.getHeight()) * 0.5, 1, 0.1));
        hashSet.add(ax.a(am2.getWidth() * 0.5 - this.b, (- am2.getHeight()) * 0.5, 1, 0.1));
        hashSet.add(ax.a(am2.getWidth() * 0.5, this.b - am2.getHeight() * 0.5, 4, 0.1));
        hashSet.add(ax.a(am2.getWidth() * 0.5, am2.getHeight() * 0.5 - this.b, 4, 0.1));
        hashSet.add(ax.a(am2.getWidth() * 0.5 - this.b, am2.getHeight() * 0.5, 2, 0.1));
        hashSet.add(ax.a((- am2.getWidth()) * 0.5 + this.b, am2.getHeight() * 0.5, 2, 0.1));
        hashSet.add(ax.a((- am2.getWidth()) * 0.5, am2.getHeight() * 0.5 - this.b, 8, 0.1));
        hashSet.add(ax.a((- am2.getWidth()) * 0.5, (- am2.getHeight()) * 0.5 + this.b, 8, 0.1));
        return hashSet;
    }

    /*
     * Unable to fully structure code
     */
    private void d(X var1_1) {
        block5 : {
            var14_2 = v.f;
            this.o.clear();
            this.n.clear();
            var2_3 = var1_1.o();
            while (var2_3.f()) {
                var3_4 = var2_3.e();
                var4_5 = ((X)var3_4.e()).h(var3_4);
                var5_6 = new I(var3_4, var4_5.getX(), var4_5.getY(), var4_5.getWidth(), var4_5.getHeight());
                var6_7 = new F(true, var4_5.getX(), var4_5.getY(), var4_5.getY() + var4_5.getHeight(), (J)var5_6);
                var7_9 = new F(false, var4_5.getX() + var4_5.getWidth(), var4_5.getY(), var4_5.getY() + var4_5.getHeight(), (J)var5_6);
                this.n.add(var6_7);
                this.n.add(var7_9);
                var5_6 = new I(var3_4, var4_5.getY(), var4_5.getX(), var4_5.getHeight(), var4_5.getWidth());
                var6_7 = new F(true, var4_5.getY(), var4_5.getX(), var4_5.getX() + var4_5.getWidth(), (J)var5_6);
                var7_10 = new F(false, var4_5.getY() + var4_5.getHeight(), var4_5.getX(), var4_5.getX() + var4_5.getWidth(), (J)var5_6);
                this.o.add(var6_7);
                this.o.add(var7_10);
                if (var14_2 != 0) return;
                var5_6 = var3_4.l();
                while (var5_6.f()) {
                    block6 : {
                        var6_7 = var5_6.a();
                        v0 = this;
                        if (var14_2 != 0) break block5;
                        if (v0.u == null || this.u.d(var6_7)) ** GOTO lbl45
                        var7_11 = null;
                        for (t var9_15 : var1_1.m((d)var6_7)) {
                            if (var14_2 != 0) break block6;
                            if (var7_12 == null) ** GOTO lbl43
                            if (var9_15.a() > var7_12.a()) ** GOTO lbl-1000
                            var10_16 = var9_15;
                            var11_18 = var7_12;
                            if (var14_2 != 0) lbl-1000: // 2 sources:
                            {
                                var10_16 = var7_12;
                                var11_19 = var9_15;
                            }
                            if (var9_15.b() > var7_12.b()) ** GOTO lbl-1000
                            var12_20 = var9_15;
                            var13_22 = var7_12;
                            if (var14_2 != 0) lbl-1000: // 2 sources:
                            {
                                var12_20 = var7_12;
                                var13_23 = var9_15;
                            }
                            this.a(this.n, var10_16.a(), var10_16.b(), var11_17.a(), var11_17.b());
                            this.a(this.o, var12_20.b(), var12_20.a(), var13_21.b(), var13_21.a());
lbl43: // 2 sources:
                            var7_13 = var9_15;
                            if (var14_2 == 0) continue;
                        }
lbl45: // 3 sources:
                        var5_6.g();
                    }
                    if (var14_2 == 0) continue;
                }
                var2_3.g();
                if (var14_2 == 0) continue;
            }
            this.a(this.n);
            v0 = this;
        }
        v0.a(this.o);
    }

    private static boolean a(X x2, d d2) {
        if (x2.n(d2.c()) + x2.q(d2.c()) < x2.n(d2.d())) return false;
        if (x2.n(d2.d()) + x2.q(d2.d()) < x2.n(d2.c())) return false;
        return true;
    }

    private static boolean b(X x2, d d2) {
        if (x2.m(d2.c()) + x2.p(d2.c()) < x2.m(d2.d())) return false;
        if (x2.m(d2.d()) + x2.p(d2.d()) < x2.m(d2.c())) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private Collection a(X var1_1, d var2_2, boolean var3_3) {
        block19 : {
            block15 : {
                var11_4 = v.f;
                if (var3_3) {
                    var4_5 = var1_1.c(ax.a);
                    if (var11_4 == 0) break block15;
                }
                var4_5 = var1_1.c(ax.b);
            }
            var5_6 = null;
            if (var4_5 != null) {
                var5_6 = (ArrayList<Object>)var4_5.b(var2_2);
            } else {
                block16 : {
                    if (var3_3) {
                        var6_7 = var1_1.c(aF.a);
                        if (var11_4 == 0) break block16;
                    }
                    var6_7 = var1_1.c(aF.b);
                }
                if (var6_7 != null && (var7_8 = (aE)var6_7.b(var2_2)) != null) {
                    block18 : {
                        var5_6 = new ArrayList<E>();
                        var9_9 = this.b(var7_8.b());
                        if (var7_8.a()) {
                            block17 : {
                                if (var3_3) {
                                    var10_11 = var1_1.n(var2_2);
                                    if (var11_4 == 0) break block17;
                                }
                                var10_11 = var1_1.o(var2_2);
                            }
                            var8_12 = ax.a(var10_11.a(), var10_11.b(), var9_9);
                            if (var11_4 == 0) break block18;
                        }
                        var8_12 = ax.b(var9_9);
                    }
                    var5_6.add(var8_12);
                }
            }
            if (var5_6 == null && (var6_7 = var1_1.c(ay.a)) != null && (var8_12 = (ay)var6_7.b(var7_8 = var3_3 != false ? var2_2.c() : var2_2.d())) != null) {
                var5_6 = new ArrayList<E>();
                var9_10 = var8_12.a();
                while (var9_10.hasNext()) {
                    var10_11 = (aA)var9_10.next();
                    var5_6.add(var10_11.a());
                    if (var11_4 == 0) {
                        if (var11_4 == 0) continue;
                    }
                    break block19;
                }
            }
            if (var5_6 != null || this.w != 2 && this.w != 1) ** GOTO lbl56
            var5_6 = new ArrayList<Object>();
            var6_7 = var1_1.l(var2_2.c());
            var7_8 = var1_1.l(var2_2.d());
            if (this.w != 1 || E.a(var1_1, var2_2)) ** GOTO lbl50
            v0 = var8_13 = var7_8.b() < var6_7.b();
            if ((!var3_3 || !var8_13) && (var3_3 || var8_13)) ** GOTO lbl48
            var5_6.add(ax.b(1));
            if (var11_4 == 0) ** GOTO lbl56
lbl48: // 2 sources:
            var5_6.add(ax.b(2));
            if (var11_4 == 0) ** GOTO lbl56
lbl50: // 2 sources:
            if (this.w != 2 || E.b(var1_1, var2_2)) ** GOTO lbl56
            v1 = var8_14 = var6_7.a() > var7_8.a();
            if ((!var3_3 || !var8_14) && (var3_3 || var8_14)) ** GOTO lbl-1000
            var5_6.add(ax.b(8));
            if (var11_4 != 0) lbl-1000: // 2 sources:
            {
                var5_6.add(ax.b(4));
            }
        }
        if (var5_6 != null) return this.a((Collection)var5_6);
        var5_6 = new ArrayList<E>(this.s);
        if (var2_2.e() == false) return this.a((Collection)var5_6);
        var5_6.addAll(this.a(var1_1.a(var3_3 != false ? var2_2.c() : var2_2.d())));
        return this.a((Collection)var5_6);
    }

    private int b(byte by2) {
        int n2 = v.f;
        switch (by2) {
            case 0: {
                by2 = (byte)15;
                if (n2 == 0) return by2;
            }
            case 1: {
                by2 = 1;
                if (n2 == 0) return by2;
            }
            case 4: {
                by2 = (byte)4;
                if (n2 == 0) return by2;
            }
            case 2: {
                by2 = (byte)2;
                if (n2 == 0) return by2;
            }
            case 8: {
                by2 = (byte)8;
                if (n2 == 0) return by2;
            }
        }
        return (byte)15;
    }

    /*
     * Unable to fully structure code
     */
    private Collection a(Collection var1_1) {
        block6 : {
            var5_2 = v.f;
            var2_3 = new ArrayList();
            if (var1_1 != null) ** GOTO lbl6
            var2_3 = this.s;
            if (var5_2 == 0) ** GOTO lbl31
lbl6: // 5 sources:
            for (ax var4_5 : var1_1) {
                if ((var4_5.a() & 1) != 1) ** GOTO lbl12
                if (!var4_5.b()) ** GOTO lbl-1000
                var2_3.add(ax.a(var4_5.c(), var4_5.d(), 1, var4_5.f()));
                if (var5_2 != 0) lbl-1000: // 2 sources:
                {
                    var2_3.add(ax.a(1, var4_5.f()));
                }
lbl12: // 4 sources:
                if ((var4_5.a() & 4) != 4) ** GOTO lbl17
                if (!var4_5.b()) ** GOTO lbl-1000
                var2_3.add(ax.a(var4_5.c(), var4_5.d(), 4, var4_5.f()));
                if (var5_2 != 0) lbl-1000: // 2 sources:
                {
                    var2_3.add(ax.a(4, var4_5.f()));
                }
lbl17: // 4 sources:
                if ((var4_5.a() & 2) != 2) ** GOTO lbl22
                if (!var4_5.b()) ** GOTO lbl-1000
                var2_3.add(ax.a(var4_5.c(), var4_5.d(), 2, var4_5.f()));
                if (var5_2 != 0) lbl-1000: // 2 sources:
                {
                    var2_3.add(ax.a(2, var4_5.f()));
                }
lbl22: // 4 sources:
                if ((var4_5.a() & 8) != 8) continue;
                v0 = var4_5.b();
                if (var5_2 == 0) {
                    if (v0) {
                        var2_3.add(ax.a(var4_5.c(), var4_5.d(), 8, var4_5.f()));
                        if (var5_2 == 0) continue;
                    }
                    var2_3.add(ax.a(8, var4_5.f()));
                    if (var5_2 == 0) continue;
                }
                break block6;
            }
lbl31: // 3 sources:
            v0 = var2_3.isEmpty();
        }
        if (v0 == false) return var2_3;
        return this.s;
    }

    /*
     * Unable to fully structure code
     */
    private D a(X var1_1, y.c.q var2_2, y.c.q var3_3, ax var4_4, ax var5_5) {
        block135 : {
            var57_6 = v.f;
            var6_7 = var4_4;
            var7_8 = var5_5;
            var8_9 = new D();
            var9_10 = var1_1.a(var2_2);
            var10_11 = var1_1.a(var3_3);
            var11_12 = var6_7.a();
            var12_13 = var7_8.a();
            var13_14 = new double[]{1.0, 0.0, 0.0, 1.0};
            switch (var11_12) {
                default: {
                    this.i = this.g;
                    if (var57_6 == 0) break;
                }
                case 4: {
                    var13_14[0] = 0.0;
                    var13_14[1] = -1.0;
                    var13_14[2] = 1.0;
                    var13_14[3] = 0.0;
                    var9_10 = new x(var9_10.getY(), - var9_10.getX() + var9_10.getWidth(), var9_10.getHeight(), var9_10.getWidth());
                    var10_11 = new x(var10_11.getY(), - var10_11.getX() + var10_11.getWidth(), var10_11.getHeight(), var10_11.getWidth());
                    this.i = new t(this.g.b(), - this.g.a());
                    var12_13 = this.a(var12_13, 2);
                    if (var57_6 == 0) break;
                }
                case 2: {
                    var13_14[0] = -1.0;
                    var13_14[1] = 0.0;
                    var13_14[2] = 0.0;
                    var13_14[3] = -1.0;
                    var9_10 = new x(- var9_10.getX() + var9_10.getWidth(), - var9_10.getY() + var9_10.getHeight(), var9_10.getWidth(), var9_10.getHeight());
                    var10_11 = new x(- var10_11.getX() + var10_11.getWidth(), - var10_11.getY() + var10_11.getHeight(), var10_11.getWidth(), var10_11.getHeight());
                    this.i = new t(- this.g.a(), - this.g.b());
                    var12_13 = this.a(var12_13, 1);
                    if (var57_6 == 0) break;
                }
                case 8: {
                    var13_14[0] = 0.0;
                    var13_14[1] = 1.0;
                    var13_14[2] = -1.0;
                    var13_14[3] = 0.0;
                    var9_10 = new x(- var9_10.getY() + var9_10.getHeight(), var9_10.getX(), var9_10.getHeight(), var9_10.getWidth());
                    var10_11 = new x(- var10_11.getY() + var10_11.getHeight(), var10_11.getX(), var10_11.getHeight(), var10_11.getWidth());
                    this.i = new t(- this.g.b(), this.g.a());
                    var12_13 = this.a(var12_13, 0);
                }
            }
            if (var4_4.b()) ** GOTO lbl-1000
            var6_7 = this.a(var4_4, var9_10, 1);
            if (var57_6 != 0) lbl-1000: // 2 sources:
            {
                var14_15 = var6_7.c() * var13_14[0] + var6_7.d() * var13_14[2];
                var16_17 = var6_7.c() * var13_14[1] + var6_7.d() * var13_14[3];
                var6_7 = ax.a(var14_15, var16_17, var6_7.a(), var6_7.f());
            }
            if (var5_5.b()) ** GOTO lbl-1000
            var7_8 = this.a(var5_5, var10_11, var12_13);
            if (var57_6 != 0) lbl-1000: // 2 sources:
            {
                var14_15 = var7_8.c() * var13_14[0] + var7_8.d() * var13_14[2];
                var16_17 = var7_8.c() * var13_14[1] + var7_8.d() * var13_14[3];
                var7_8 = ax.a(var14_15, var16_17, var7_8.a(), var7_8.f());
            }
            if (var2_2 == var3_3) {
                var14_16 = 8;
                if (var57_6 == 0) break block135;
            }
            var14_16 = this.a(var9_10, var10_11);
        }
        var15_18 = var9_10.getX() + 0.5 * var9_10.getWidth();
        var17_19 = var9_10.getY() + 0.5 * var9_10.getHeight();
        var19_20 = var10_11.getX() + 0.5 * var10_11.getWidth();
        var21_21 = var10_11.getY() + 0.5 * var10_11.getHeight();
        var23_22 = var15_18 + var6_7.c();
        var25_23 = var17_19 + var6_7.d();
        var27_24 = var19_20 + var7_8.c();
        var29_25 = var21_21 + var7_8.d();
        var8_9.add(new t(var15_18 + var6_7.c(), var17_19 + var6_7.d()));
        block5 : switch (var14_16) {
            case 8: {
                var47_26 = Math.min(var9_10.getHeight(), var9_10.getWidth()) / 2.0;
                this.d(var8_9, var25_23 - var9_10.getY() + var47_26, true);
                switch (var12_13) {
                    case 1: {
                        block136 : {
                            var49_28 = var23_22 - var27_24;
                            if (var49_28 != 0.0) {
                                this.b(var8_9, var49_28, false);
                                if (var57_6 == 0) break block136;
                            }
                            this.b(var8_9, var23_22 - var9_10.getX(), false);
                        }
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 4: {
                        this.c(var8_9, var9_10.getX() + var9_10.getWidth() - var23_22 + var47_26, true);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 2: {
                        this.b(var8_9, var23_22 - var9_10.getX() + var47_26, true);
                        this.a(var8_9, var9_10.getY() + var9_10.getHeight() + var47_26 - this.b(var8_9), true);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 8: {
                        this.b(var8_9, var23_22 - var9_10.getX() + var47_26, true);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                }
                if (var57_6 == 0) break;
            }
            case 0: {
                block137 : {
                    var35_30 = var9_10.getX() + var9_10.getWidth() - var23_22;
                    var37_31 = var10_11.getX() + var10_11.getWidth() - var23_22;
                    var39_32 = var27_24 - var23_22;
                    var41_33 = var9_10.getY() + var9_10.getHeight();
                    var43_34 = var10_11.getY();
                    if (this.f) {
                        var45_35 = this.a(var9_10.getY() + var9_10.getHeight() + this.b, true, true);
                        if (var57_6 == 0) break block137;
                    }
                    var45_35 = var9_10.getY() + var9_10.getHeight() + this.b;
                }
                switch (var12_13) {
                    case 1: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        if (var39_32 > var35_30 + this.b) {
                            this.c(var8_9, var39_32, false);
                            this.a(var8_9, var29_25 - this.b(var8_9), false);
                            if (var57_6 == 0) break block5;
                        }
                        this.c(var8_9, var35_30 + this.b, true);
                        if (!this.a(var41_33, var43_34, var45_35)) ** GOTO lbl-1000
                        this.a(var8_9, var9_10.getY() + var9_10.getHeight() + this.b - this.b(var8_9), true);
                        if (var57_6 != 0) lbl-1000: // 2 sources:
                        {
                            var49_28 = var10_11.getY() - (var9_10.getY() + var9_10.getHeight());
                            this.a(var8_9, var9_10.getY() + var9_10.getHeight() + 0.5 * var49_28 - this.b(var8_9), false);
                        }
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 4: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        this.c(var8_9, Math.max(var37_31, var35_30) + this.b, true);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 2: {
                        block138 : {
                            this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                            if (var37_31 > var35_30) {
                                this.c(var8_9, var37_31 + this.b, true);
                                if (var57_6 == 0) break block138;
                            }
                            this.c(var8_9, var35_30 + this.b, true);
                        }
                        this.a(var8_9, var10_11.getY() + var10_11.getHeight() + this.b - this.b(var8_9), true);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 8: {
                        block139 : {
                            this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                            if (var37_31 > var35_30) {
                                this.c(var8_9, var37_31 + this.b, true);
                                if (var57_6 == 0) break block139;
                            }
                            this.c(var8_9, var35_30 + this.b, true);
                        }
                        this.a(var8_9, var10_11.getY() + var10_11.getHeight() + this.b - this.b(var8_9), true);
                        this.b(var8_9, this.a(var8_9) - var10_11.getX() + this.b, true);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                }
                if (var57_6 == 0) break;
            }
            case 1: {
                var49_29 = var23_22 < var10_11.getX();
                var50_36 = var23_22 > var10_11.getX() + var10_11.getWidth();
                switch (var12_13) {
                    case 1: {
                        if (!var49_29) ** GOTO lbl166
                        this.d(var8_9, var25_23 - var10_11.getY() + this.b, true);
                        this.c(var8_9, var27_24 - var23_22, false);
                        if (var57_6 == 0) ** GOTO lbl174
lbl166: // 2 sources:
                        if (!var50_36) ** GOTO lbl-1000
                        this.d(var8_9, var25_23 - var10_11.getY() + this.b, true);
                        this.b(var8_9, var23_22 - var27_24, false);
                        if (var57_6 != 0) lbl-1000: // 2 sources:
                        {
                            this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                            this.c(var8_9, var10_11.getX() + var10_11.getWidth() - var23_22 + this.b, true);
                            this.d(var8_9, var9_10.getY() - var10_11.getY(), true);
                            this.b(var8_9, this.a(var8_9) - var27_24, false);
                        }
lbl174: // 4 sources:
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 4: {
                        if (var50_36) {
                            this.d(var8_9, var25_23 - var29_25, false);
                            this.b(var8_9, var23_22 - var27_24, false);
                            if (var57_6 == 0) break block5;
                        }
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        this.c(var8_9, var10_11.getX() + var10_11.getWidth() - var23_22 + this.b, true);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 2: {
                        var51_37 = var9_10.getX();
                        if (var10_11.getX() > var9_10.getX()) {
                            var51_37 = var10_11.getX();
                        }
                        var53_38 = var10_11.getX() + var10_11.getWidth();
                        if (var9_10.getX() + var9_10.getWidth() < var10_11.getX() + var10_11.getWidth()) {
                            var53_38 = var9_10.getX() + var9_10.getWidth();
                        }
                        var55_39 = var51_37 + 0.5 * (var53_38 - var51_37);
                        if (var4_4.b() && var5_5.b()) {
                            if (Math.abs(var23_22 - var27_24) < 0.001) {
                                this.d(var8_9, var25_23 - var29_25, false);
                                if (var57_6 == 0) break block5;
                            }
                            this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                            this.c(var8_9, var27_24 - var23_22, false);
                            this.d(var8_9, this.b(var8_9) - var29_25, false);
                            if (var57_6 == 0) break block5;
                        }
                        if (var4_4.b()) {
                            if (var23_22 >= var51_37 && var23_22 <= var53_38) {
                                this.d(var8_9, var25_23 - var29_25, false);
                                if (var57_6 == 0) break block5;
                            }
                            this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                            this.c(var8_9, var55_39 - var23_22, false);
                            this.d(var8_9, var9_10.getY() - var29_25 - this.b, false);
                            if (var57_6 == 0) break block5;
                        }
                        if (var5_5.b()) {
                            if (var27_24 >= var51_37 && var27_24 <= var53_38) {
                                var8_9.clear();
                                var8_9.add(new t(var27_24, var9_10.getY()));
                                this.d(var8_9, var25_23 - var29_25, false);
                                if (var57_6 == 0) break block5;
                            }
                            this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                            this.c(var8_9, var27_24 - var23_22, false);
                            this.d(var8_9, var9_10.getY() - var29_25 - this.b, false);
                            if (var57_6 == 0) break block5;
                        }
                        var8_9.clear();
                        var8_9.add(new t(var55_39, var9_10.getY()));
                        this.d(var8_9, var9_10.getY() - (var10_11.getY() + var10_11.getHeight()), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 8: {
                        if (var49_29) {
                            this.d(var8_9, var25_23 - var29_25, false);
                            this.c(var8_9, var27_24 - var23_22, false);
                            if (var57_6 == 0) break block5;
                        }
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        this.b(var8_9, var23_22 - var10_11.getX() + this.b, true);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                }
                if (var57_6 == 0) break;
            }
            case 4: {
                block140 : {
                    var41_33 = var9_10.getX() + var9_10.getWidth();
                    var43_34 = var10_11.getX();
                    if (this.f) {
                        var45_35 = this.a(var9_10.getX() + var9_10.getWidth() + this.b, true, true);
                        if (var57_6 == 0) break block140;
                    }
                    var45_35 = var9_10.getX() + var9_10.getWidth() + this.b;
                }
                switch (var12_13) {
                    case 1: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        this.c(var8_9, var27_24 - var23_22, false);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 4: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        this.c(var8_9, var10_11.getX() + var10_11.getWidth() - var23_22 + this.b, true);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 2: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        if (!this.a(var41_33, var43_34, var45_35)) ** GOTO lbl-1000
                        this.c(var8_9, var9_10.getX() + var9_10.getWidth() + this.b - var23_22, true);
                        this.a(var8_9, var10_11.getY() + var10_11.getHeight() + this.b - this.b(var8_9), true);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        if (var57_6 != 0) lbl-1000: // 2 sources:
                        {
                            this.c(var8_9, var10_11.getX() + var10_11.getWidth() + this.b - var23_22, true);
                            this.a(var8_9, var10_11.getY() + var10_11.getHeight() + this.b - this.b(var8_9), true);
                            this.b(var8_9, this.a(var8_9) - var27_24, false);
                        }
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 8: {
                        block141 : {
                            this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                            if (this.a(var41_33, var43_34, var45_35)) {
                                this.c(var8_9, var9_10.getX() + var9_10.getWidth() + this.b - var23_22, true);
                                if (var57_6 == 0) break block141;
                            }
                            this.b(var8_9, var23_22 - var9_10.getX() + this.b, true);
                        }
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                }
                if (var57_6 == 0) break;
            }
            case 5: {
                block142 : {
                    var41_33 = var10_11.getX() + var10_11.getWidth();
                    var43_34 = var9_10.getX();
                    if (this.f) {
                        var45_35 = this.a(var9_10.getX() - this.b, false, true);
                        if (var57_6 == 0) break block142;
                    }
                    var45_35 = var9_10.getX() - this.b;
                }
                switch (var12_13) {
                    case 1: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        this.b(var8_9, var23_22 - var27_24, false);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 4: {
                        block143 : {
                            this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                            if (this.a(var41_33, var43_34, var45_35)) {
                                this.b(var8_9, var23_22 - var9_10.getX() + this.b, true);
                                if (var57_6 == 0) break block143;
                            }
                            this.c(var8_9, var9_10.getX() + var9_10.getWidth() - var23_22 + this.b, true);
                        }
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 2: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        if (this.a(var41_33, var43_34, var45_35)) {
                            this.b(var8_9, var23_22 - var9_10.getX() + this.b, true);
                            this.a(var8_9, this.b + var10_11.getY() + var10_11.getHeight() - this.b(var8_9), true);
                            this.b(var8_9, this.a(var8_9) - var27_24, false);
                            this.d(var8_9, this.b(var8_9) - var29_25, false);
                            if (var57_6 == 0) break block5;
                        }
                        this.c(var8_9, var9_10.getX() + var9_10.getWidth() - var23_22 + this.b, true);
                        this.a(var8_9, this.b + var10_11.getY() + var10_11.getHeight() - this.b(var8_9), true);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 8: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        this.b(var8_9, var23_22 - var10_11.getX() + this.b, true);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                }
                if (var57_6 == 0) break;
            }
            case 7: {
                block144 : {
                    var41_33 = var10_11.getY() + var10_11.getHeight();
                    var43_34 = var9_10.getY();
                    if (this.f) {
                        var45_35 = this.a(var9_10.getY() - this.b, false, false);
                        if (var57_6 == 0) break block144;
                    }
                    var45_35 = var9_10.getY() - this.b;
                }
                switch (var12_13) {
                    case 1: {
                        this.d(var8_9, var25_23 - var10_11.getY() + this.b, true);
                        this.b(var8_9, var23_22 - var27_24, false);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 4: {
                        this.d(var8_9, var25_23 - var29_25, false);
                        this.b(var8_9, var23_22 - var27_24, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 2: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        if (this.a(var41_33, var43_34, var45_35)) {
                            this.b(var8_9, var23_22 - var27_24, false);
                            this.d(var8_9, this.b(var8_9) - var29_25, false);
                            if (var57_6 == 0) break block5;
                        }
                        this.c(var8_9, var9_10.getX() + var9_10.getWidth() + this.b - this.a(var8_9), true);
                        this.a(var8_9, var9_10.getY() + var9_10.getHeight() + this.b - this.b(var8_9), true);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 8: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        if (!this.a(var41_33, var43_34, var45_35)) ** GOTO lbl-1000
                        this.b(var8_9, var23_22 - var10_11.getX() + this.b, true);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 != 0) lbl-1000: // 2 sources:
                        {
                            this.c(var8_9, var9_10.getX() + var9_10.getWidth() - var23_22 + this.b, true);
                            this.a(var8_9, var9_10.getY() + var9_10.getHeight() + this.b - this.b(var8_9), true);
                            this.b(var8_9, this.a(var8_9) - var10_11.getX() + this.b, true);
                            this.d(var8_9, this.b(var8_9) - var29_25, false);
                        }
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                }
                if (var57_6 == 0) break;
            }
            case 6: {
                block145 : {
                    var41_33 = var10_11.getY() + var10_11.getHeight();
                    var43_34 = var9_10.getY();
                    if (this.f) {
                        var45_35 = this.a(var9_10.getY() - this.b, false, false);
                        if (var57_6 == 0) break block145;
                    }
                    var45_35 = var9_10.getY() - this.b;
                }
                switch (var12_13) {
                    case 1: {
                        this.d(var8_9, var25_23 - var10_11.getY() + this.b, true);
                        this.c(var8_9, var27_24 - var23_22, false);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 4: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        if (!this.a(var41_33, var43_34, var45_35)) ** GOTO lbl-1000
                        this.c(var8_9, var10_11.getX() + var10_11.getWidth() - var23_22 + this.b, true);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 != 0) lbl-1000: // 2 sources:
                        {
                            this.b(var8_9, var23_22 - var9_10.getX() + this.b, true);
                            this.a(var8_9, var9_10.getY() + var9_10.getHeight() + this.b - this.b(var8_9), true);
                            this.c(var8_9, var10_11.getX() + var10_11.getWidth() + this.b - this.a(var8_9), true);
                            this.d(var8_9, this.b(var8_9) - var29_25, false);
                        }
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 2: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        if (this.a(var41_33, var43_34, var45_35)) {
                            this.c(var8_9, var27_24 - var23_22, false);
                            this.d(var8_9, this.b(var8_9) - var29_25, false);
                            if (var57_6 == 0) break block5;
                        }
                        this.b(var8_9, var23_22 - var9_10.getX() + this.b, true);
                        this.a(var8_9, var9_10.getY() + var9_10.getHeight() + this.b - this.b(var8_9), true);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 8: {
                        this.d(var8_9, var25_23 - var29_25, false);
                        this.c(var8_9, var27_24 - var23_22, false);
                        if (var57_6 == 0) break block5;
                    }
                }
                if (var57_6 == 0) break;
            }
            case 2: {
                block146 : {
                    var31_40 = var25_23 - var9_10.getY();
                    var33_41 = var25_23 - var10_11.getY();
                    var39_32 = var25_23 - var29_25;
                    var41_33 = var9_10.getX() + var9_10.getWidth();
                    var43_34 = var10_11.getX();
                    if (this.f) {
                        var45_35 = this.a(var9_10.getX() + var9_10.getWidth() + this.b, true, true);
                        if (var57_6 == 0) break block146;
                    }
                    var45_35 = var9_10.getX() + var9_10.getWidth() + this.b;
                }
                switch (var12_13) {
                    case 1: {
                        block147 : {
                            if (var31_40 > var33_41) {
                                this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                                if (var57_6 == 0) break block147;
                            }
                            this.d(var8_9, var25_23 - var10_11.getY() + this.b, true);
                        }
                        this.c(var8_9, var27_24 - var23_22, false);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 4: {
                        block148 : {
                            if (var31_40 > var33_41) {
                                this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                                if (var57_6 == 0) break block148;
                            }
                            this.d(var8_9, var25_23 - var10_11.getY() + this.b, true);
                        }
                        this.c(var8_9, var10_11.getX() + var10_11.getWidth() - var23_22 + this.b, true);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 2: {
                        block149 : {
                            this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                            if (this.a(var41_33, var43_34, var45_35)) {
                                this.c(var8_9, var9_10.getX() + var9_10.getWidth() - var23_22 + this.b, true);
                                this.a(var8_9, var10_11.getY() + var10_11.getHeight() + this.b - this.b(var8_9), true);
                                this.c(var8_9, var27_24 - this.a(var8_9), false);
                                this.d(var8_9, this.b(var8_9) - var29_25, false);
                                if (var57_6 == 0) break block5;
                            }
                            this.b(var8_9, var23_22 - var9_10.getX() + this.b, true);
                            if (var9_10.getY() + var9_10.getHeight() + this.b > var10_11.getY() + var10_11.getHeight()) {
                                this.a(var8_9, var9_10.getY() + var9_10.getHeight() + this.b - this.b(var8_9), true);
                                if (var57_6 == 0) break block149;
                            }
                            this.a(var8_9, var10_11.getY() + var10_11.getHeight() + this.b - this.b(var8_9), true);
                        }
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 8: {
                        if (var39_32 >= var31_40 + this.b) {
                            this.d(var8_9, var39_32, false);
                            this.c(var8_9, var27_24 - var23_22, false);
                            if (var57_6 == 0) break block5;
                        }
                        this.d(var8_9, var31_40 + this.b, true);
                        if (!this.a(var41_33, var43_34, var45_35)) ** GOTO lbl-1000
                        this.c(var8_9, var9_10.getX() + var9_10.getWidth() + this.b - this.a(var8_9), true);
                        if (var57_6 != 0) lbl-1000: // 2 sources:
                        {
                            var51_37 = var10_11.getX() - (var9_10.getX() + var9_10.getWidth());
                            this.c(var8_9, var10_11.getX() - 0.5 * var51_37 - this.a(var8_9), false);
                        }
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                }
                if (var57_6 == 0) break;
            }
            case 3: {
                block150 : {
                    var31_40 = var25_23 - var9_10.getY();
                    var33_41 = var25_23 - var10_11.getY();
                    var39_32 = var25_23 - var29_25;
                    var41_33 = var10_11.getX() + var10_11.getWidth();
                    var43_34 = var9_10.getX();
                    if (this.f) {
                        var45_35 = this.a(var9_10.getX() - this.b, false, true);
                        if (var57_6 == 0) break block150;
                    }
                    var45_35 = var9_10.getX() - this.b;
                }
                switch (var12_13) {
                    case 1: {
                        block151 : {
                            if (var31_40 > var33_41) {
                                this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                                if (var57_6 == 0) break block151;
                            }
                            this.d(var8_9, var25_23 - var10_11.getY() + this.b, true);
                        }
                        this.b(var8_9, var23_22 - var27_24, false);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                    case 4: {
                        if (var39_32 >= var31_40 + this.b) {
                            this.d(var8_9, var39_32, false);
                            this.b(var8_9, var23_22 - var27_24, false);
                            if (var57_6 == 0) break block5;
                        }
                        this.d(var8_9, var31_40 + this.b, true);
                        if (!this.a(var41_33, var43_34, var45_35)) ** GOTO lbl-1000
                        this.b(var8_9, var23_22 - var9_10.getX() + this.b, true);
                        if (var57_6 != 0) lbl-1000: // 2 sources:
                        {
                            var51_37 = var9_10.getX() - (var10_11.getX() + var10_11.getWidth());
                            this.b(var8_9, var23_22 - (var10_11.getX() + var10_11.getWidth()) - 0.5 * var51_37, false);
                        }
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 2: {
                        this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                        if (this.a(var41_33, var43_34, var45_35)) {
                            this.b(var8_9, var23_22 - var9_10.getX() + this.b, true);
                            this.a(var8_9, var10_11.getY() + var10_11.getHeight() + this.b - this.b(var8_9), true);
                            this.b(var8_9, this.a(var8_9) - var27_24, false);
                            this.d(var8_9, this.b(var8_9) - var29_25, false);
                            if (var57_6 == 0) break block5;
                        }
                        this.c(var8_9, var9_10.getX() + var9_10.getWidth() - var23_22 + this.b, true);
                        if (var9_10.getY() + var9_10.getHeight() + this.b > var10_11.getY() + var10_11.getHeight()) {
                            this.a(var8_9, var9_10.getY() + var9_10.getHeight() + this.b - this.b(var8_9), true);
                            this.b(var8_9, this.a(var8_9) - var27_24, false);
                            this.d(var8_9, this.b(var8_9) - var29_25, false);
                            if (var57_6 == 0) break block5;
                        }
                        this.a(var8_9, var10_11.getY() + var10_11.getHeight() + this.b - this.b(var8_9), true);
                        this.b(var8_9, this.a(var8_9) - var27_24, false);
                        this.d(var8_9, this.b(var8_9) - var29_25, false);
                        if (var57_6 == 0) break block5;
                    }
                    case 8: {
                        block152 : {
                            if (var31_40 > var33_41) {
                                this.d(var8_9, var25_23 - var9_10.getY() + this.b, true);
                                if (var57_6 == 0) break block152;
                            }
                            this.d(var8_9, var25_23 - var10_11.getY() + this.b, true);
                        }
                        this.b(var8_9, var23_22 - var10_11.getX() + this.b, true);
                        this.a(var8_9, var29_25 - this.b(var8_9), false);
                        this.c(var8_9, var27_24 - this.a(var8_9), false);
                        if (var57_6 == 0) break block5;
                    }
                }
                break;
            }
        }
        var47_27 = var8_9.k();
        do {
            if (var47_27 == null) return var8_9;
            var48_42 = (t)var47_27.c();
            var47_27.a(new t(var48_42.a * var13_14[0] + var48_42.b * var13_14[1], var48_42.a * var13_14[2] + var48_42.b * var13_14[3]));
            var47_27 = var47_27.a();
        } while (var57_6 == 0);
        return var8_9;
    }

    protected double a(d d2, D d3, ax ax2, ax ax3) {
        double d4 = this.e(d2, d3, ax2, ax3);
        double d5 = this.c(d2, d3, ax2, ax3);
        double d6 = this.f(d2, d3, ax2, ax3);
        double d7 = this.d(d2, d3, ax2, ax3);
        double d8 = this.b(d2, d3, ax2, ax3);
        if (d2.e()) {
            return d5 + d6 + d7 + d8;
        }
        double d9 = 0.0;
        if (this.w == 0) return d4 + d5 + d6 + d8 + d9;
        byte by2 = this.a(d3, ax2, ax3);
        if (this.e() && by2 != 1 && by2 != 3) {
            d9 = 100000.0;
            if (v.f == 0) return d4 + d5 + d6 + d8 + d9;
        }
        if (!this.f()) return d4 + d5 + d6 + d8 + d9;
        if (by2 == 2) return d4 + d5 + d6 + d8 + d9;
        if (by2 == 3) return d4 + d5 + d6 + d8 + d9;
        d9 = 100000.0;
        return d4 + d5 + d6 + d8 + d9;
    }

    private byte a(D d2, ax ax2, ax ax3) {
        int n2 = v.f;
        int[] arrn = new int[4];
        t t2 = null;
        H h2 = null;
        H h3 = null;
        C c2 = d2.m();
        while (c2.f()) {
            t t3 = (t)c2.d();
            if (t2 != null) {
                H h4 = new H(t2, t3);
                int[] arrn2 = arrn;
                int n3 = h4.d();
                arrn2[n3] = arrn2[n3] + 1;
                if (h2 == null) {
                    h2 = h4;
                }
                h3 = h4;
            }
            t2 = t3;
            c2.g();
            if (n2 == 0) continue;
        }
        int n4 = 0;
        if (!(arrn[0] != 0 && arrn[1] != 0 || ax2.a() == 255 && !H.a(h2) || ax3.a() == 255 && !H.a(h3))) {
            n4 = 1;
            if (n2 == 0) return (byte)n4;
        }
        if (!(arrn[2] != 0 && arrn[3] != 0 || ax2.a() == 255 && H.a(h2) || ax3.a() == 255 && H.a(h3))) {
            n4 = 2;
            if (n2 == 0) return (byte)n4;
        }
        if (arrn[2] != 0) {
            if (arrn[3] != 0) return (byte)n4;
        }
        if (arrn[0] == 0) return (byte)3;
        if (arrn[1] != 0) return (byte)n4;
        return (byte)3;
    }

    protected double b(d d2, D d3, ax ax2, ax ax3) {
        return ax2.f() + ax3.f();
    }

    protected double c(d d2, D d3, ax ax2, ax ax3) {
        return this.c * (double)(d3.size() - 2);
    }

    protected double d(d d2, D d3, ax ax2, ax ax3) {
        if (ax2.a() != ax3.a()) return 0.0;
        if (d2.c() != d2.d()) return 0.0;
        return this.c + 1.0;
    }

    protected double e(d d2, D d3, ax ax2, ax ax3) {
        int n2 = v.f;
        double d4 = 0.0;
        t t2 = null;
        for (t t3 : d3) {
            if (n2 != 0) return 0.0;
            if (t2 != null) {
                d4 += t2.a(t3);
            }
            t2 = t3;
            if (n2 == 0) continue;
        }
        if (d4 <= 0.0) return 0.0;
        double d5 = 1.0 - 1.0 / d4;
        return d5;
    }

    /*
     * Unable to fully structure code
     */
    protected double f(d var1_1, D var2_2, ax var3_3, ax var4_4) {
        var10_5 = v.f;
        var5_6 = 0.0;
        if (this.b() == 0.0 && this.d() == 0.0 && this.c() == 0.0) {
            return var5_6;
        }
        var7_7 = null;
        var8_8 = var2_2.iterator();
        do {
            if (var8_8.hasNext() == false) return var5_6;
            var9_9 = (t)var8_8.next();
            if (var7_7 == null) ** GOTO lbl19
            ++this.p;
            if (Math.abs(var9_9.a() - var7_7.a()) > 0.001) ** GOTO lbl-1000
            var5_6 = this.a(var1_1, var5_6, this.n, var9_9.a(), Math.min(var9_9.b(), var7_7.b()), Math.max(var9_9.b(), var7_7.b()));
            if (var10_5 != 0) lbl-1000: // 2 sources:
            {
                if (Math.abs(var9_9.b() - var7_7.b()) > 0.001) throw new IllegalStateException("Edge is not routed orthogonally!");
                var5_6 = this.a(var1_1, var5_6, this.o, var9_9.b(), Math.min(var9_9.a(), var7_7.a()), Math.max(var9_9.a(), var7_7.a()));
                if (var10_5 != 0) {
                    throw new IllegalStateException("Edge is not routed orthogonally!");
                }
            }
lbl19: // 5 sources:
            var7_7 = var9_9;
        } while (var10_5 == 0);
        return var5_6;
    }

    /*
     * Unable to fully structure code
     */
    private double a(d var1_1, double var2_2, List var4_3, double var5_4, double var7_5, double var9_6) {
        var14_7 = v.f;
        var11_8 = this.a(var5_4, var4_3) - 1;
        if (var11_8 < 0) return var2_2;
        var12_9 = (F)var4_3.get(var11_8);
        var13_10 = var12_9.e;
        do {
            if (var13_10 == 0) return var2_2;
            if (var12_9 == null) return var2_2;
            if (var12_9.a) ** GOTO lbl-1000
            var12_9.f.a = this.p;
            if (var14_7 != 0) lbl-1000: // 2 sources:
            {
                if (var12_9.a == false) throw new InternalError("Event Type undefined!");
                if (var12_9.f.a != this.p) {
                    var2_2 += var12_9.f.a(var1_1, var5_4, var7_5, var9_6, this);
                    --var13_10;
                    if (var14_7 != 0) {
                        throw new InternalError("Event Type undefined!");
                    }
                }
            }
            v0 = var12_9 = var11_8 > 0 ? (F)var4_3.get(--var11_8) : null;
        } while (var14_7 == 0);
        return var2_2;
    }

    /*
     * Unable to fully structure code
     */
    private int a(double var1_1, List var3_2) {
        var8_3 = v.f;
        if (var3_2.isEmpty()) {
            return 0;
        }
        if (((F)var3_2.get((int)0)).b > var1_1) {
            return 0;
        }
        var4_4 = 0;
        var5_5 = var3_2.size();
        block0 : do {
            var6_6 = (var4_4 + var5_5) / 2;
            var7_7 = (F)var3_2.get(var6_6);
            if (var7_7.b >= var1_1) ** GOTO lbl14
            var4_4 = var6_6;
            if (var8_3 == 0) ** GOTO lbl23
lbl14: // 2 sources:
            v0 = var7_7.b DCMPL var1_1;
            do {
                if (v0 <= 0) ** GOTO lbl19
                var5_5 = var6_6;
                if (var8_3 == 0) ** GOTO lbl23
lbl19: // 2 sources:
                if (!var7_7.a) ** GOTO lbl-1000
                var4_4 = var6_6;
                if (var8_3 != 0) lbl-1000: // 2 sources:
                {
                    var5_5 = var6_6;
                }
lbl23: // 5 sources:
                if (var5_5 - var4_4 > 1) continue block0;
                v0 = var5_5;
            } while (var8_3 != 0);
            break;
        } while (true);
        return (int)v0;
    }

    private int a(F f2, List list) {
        int n2;
        int n3 = v.f;
        if (list.isEmpty()) {
            return 0;
        }
        if (((F)list.get(0)).compareTo(f2) > 0) {
            return 0;
        }
        if (((F)list.get(list.size() - 1)).compareTo(f2) < 0) {
            return list.size();
        }
        int n4 = 0;
        int n5 = list.size();
        block0 : do {
            block7 : {
                int n6;
                F f3;
                if ((f3 = (F)list.get(n6 = (n4 + n5) / 2)).compareTo(f2) <= 0) {
                    n4 = n6;
                    if (n3 == 0) break block7;
                }
                n2 = n5 = n6;
            }
            do {
                if (n5 - n4 > 1) continue block0;
                n2 = n5;
            } while (n3 != 0);
            break;
        } while (true);
        return n2;
    }

    private boolean a(double d2, double d3, double d4) {
        if (d4 - d2 < this.b) return false;
        if (d3 - d4 < this.b) return false;
        return true;
    }

    private double a(D d2) {
        return ((t)d2.i()).a();
    }

    private double b(D d2) {
        return ((t)d2.i()).b();
    }

    private ax a(ax ax2, am am2, int n2) {
        double d2;
        double d3;
        int n3 = v.f;
        switch (n2) {
            default: {
                block11 : {
                    if (this.f) {
                        d2 = this.a(am2.getX() + 0.5 * am2.getWidth(), true);
                        if (n3 == 0) break block11;
                    }
                    d2 = 0.0;
                }
                d3 = (- am2.getHeight()) * 0.5;
                if (n3 == 0) return ax.a(d2, d3, ax2.a(), ax2.f());
            }
            case 4: {
                d2 = am2.getWidth() * 0.5;
                if (this.f) {
                    d3 = this.a(am2.getY() + 0.5 * am2.getHeight(), false);
                    if (n3 == 0) return ax.a(d2, d3, ax2.a(), ax2.f());
                }
                d3 = 0.0;
                if (n3 == 0) return ax.a(d2, d3, ax2.a(), ax2.f());
            }
            case 2: {
                block12 : {
                    if (this.f) {
                        d2 = this.a(am2.getX() + 0.5 * am2.getWidth(), true);
                        if (n3 == 0) break block12;
                    }
                    d2 = 0.0;
                }
                d3 = am2.getHeight() * 0.5;
                if (n3 == 0) return ax.a(d2, d3, ax2.a(), ax2.f());
            }
            case 8: 
        }
        d2 = (- am2.getWidth()) * 0.5;
        if (this.f) {
            d3 = this.a(am2.getY() + 0.5 * am2.getHeight(), false);
            if (n3 == 0) return ax.a(d2, d3, ax2.a(), ax2.f());
        }
        d3 = 0.0;
        return ax.a(d2, d3, ax2.a(), ax2.f());
    }

    private double a(double d2, boolean bl2) {
        if (!this.f) return 0.0;
        if (this.h <= 0.0) return 0.0;
        double d3 = bl2 ? this.g.a() : this.g.b();
        double d4 = Math.floor((d2 - d3) / this.h) * this.h - d2;
        double d5 = Math.ceil((d2 - d3) / this.h) * this.h - d2;
        if (Math.abs(d4) >= Math.abs(d5)) return d5;
        return d4;
    }

    private byte a(am am2, am am3) {
        boolean bl2;
        int n2 = v.f;
        int n3 = 0;
        double d2 = am2.getX();
        double d3 = am2.getY();
        double d4 = am2.getWidth();
        double d5 = am2.getHeight();
        double d6 = am3.getX();
        double d7 = am3.getY();
        double d8 = am3.getWidth();
        double d9 = am3.getHeight();
        boolean bl3 = d2 < d6 && d2 + d4 < d6;
        boolean bl4 = d2 > d6 && d2 > d6 + d8;
        boolean bl5 = d3 < d7 && d3 + d5 < d7;
        boolean bl6 = bl2 = d3 > d7 && d3 > d7 + d9;
        if (!bl3 && !bl4) {
            if (d3 + d5 < d7) {
                n3 = 0;
                if (n2 == 0) return (byte)n3;
            }
            if (d3 > d7 + d9) {
                n3 = 1;
                if (n2 == 0) return (byte)n3;
            }
            if (d3 < d7) {
                n3 = 0;
                if (n2 == 0) return (byte)n3;
            }
            n3 = 1;
            if (n2 == 0) return (byte)n3;
        }
        if (!bl5 && !bl2) {
            if (d2 + d4 < d6) {
                n3 = 2;
                if (n2 == 0) return (byte)n3;
            }
            if (d2 > d6 + d8) {
                n3 = 3;
                if (n2 == 0) return (byte)n3;
            }
            if (d2 < d6) {
                n3 = 2;
                if (n2 == 0) return (byte)n3;
            }
            n3 = 3;
            if (n2 == 0) return (byte)n3;
        }
        if (d2 < d6) {
            if (d3 < d7) {
                n3 = 4;
                if (n2 == 0) return (byte)n3;
            }
            if (d3 <= d7) return (byte)n3;
            n3 = 6;
            if (n2 == 0) return (byte)n3;
        }
        if (d2 <= d6) return (byte)n3;
        if (d3 < d7) {
            n3 = 5;
            if (n2 == 0) return (byte)n3;
        }
        if (d3 <= d7) return (byte)n3;
        return (byte)7;
    }

    private static boolean[] a(int n2) {
        int n3 = v.f;
        boolean[] arrbl = new boolean[4];
        if ((n2 & 1) != 0) {
            arrbl[0] = true;
            if (n3 == 0) return arrbl;
        }
        if ((n2 & 4) != 0) {
            arrbl[1] = true;
            if (n3 == 0) return arrbl;
        }
        if ((n2 & 2) != 0) {
            arrbl[2] = true;
            if (n3 == 0) return arrbl;
        }
        if ((n2 & 8) == 0) return arrbl;
        arrbl[3] = true;
        return arrbl;
    }

    private static int a(boolean[] arrbl) {
        int n2 = v.f;
        int n3 = 0;
        if (arrbl[0]) {
            n3 |= true;
            if (n2 == 0) return n3 |= 2;
        }
        if (arrbl[1]) {
            n3 |= 4;
            if (n2 == 0) return n3 |= 2;
        }
        if (arrbl[2]) {
            if (n2 == 0) return n3 |= 2;
        }
        if (!arrbl[3]) return n3 |= 2;
        n3 |= 8;
        return n3 |= 2;
    }

    /*
     * Unable to fully structure code
     */
    private int a(int var1_1, byte var2_2) {
        var7_3 = v.f;
        var3_4 = E.a(var1_1);
        for (var4_5 = 0; var4_5 < var3_4.length; ++var4_5) {
            v0 = var5_6 = var3_4[var4_5];
            if (var7_3 != 0) return v0;
            if (v0 == 0) continue;
            var6_7 = 0;
            switch (var2_2) {
                case 0: {
                    var6_7 = (var4_5 + 1) % var3_4.length;
                    if (var7_3 == 0) ** GOTO lbl19
                }
                case 1: {
                    var6_7 = (var4_5 + 2) % var3_4.length;
                    if (var7_3 == 0) ** GOTO lbl19
                }
                case 2: {
                    var6_7 = (var4_5 + 3) % var3_4.length;
                    if (var7_3 == 0) ** GOTO lbl19
                }
            }
            throw new IllegalArgumentException(new StringBuffer().append("Undefined angle given: ").append(var2_2).toString());
lbl19: // 3 sources:
            var3_4[var6_7] = true;
            var3_4[var4_5] = false;
            if (var7_3 == 0) break;
            if (var7_3 == 0) continue;
        }
        v0 = E.a(var3_4);
        return v0;
    }

    private double a(double d2, boolean bl2, boolean bl3) {
        if (!this.f) return d2;
        if (bl2) {
            if (!bl3) return Math.ceil((d2 - this.i.b()) / this.h) * this.h + this.i.b();
            return Math.ceil((d2 - this.i.a()) / this.h) * this.h + this.i.a();
        }
        if (!bl3) return Math.floor((d2 - this.i.b()) / this.h) * this.h + this.i.b();
        return Math.floor((d2 - this.i.a()) / this.h) * this.h + this.i.a();
    }

    private void a(D d2, double d3, boolean bl2) {
        double d4;
        double d5;
        block2 : {
            d4 = this.a(d2);
            double d6 = this.b(d2);
            if (bl2 && this.f) {
                d5 = this.a(d6 + d3, true, false);
                if (v.f == 0) break block2;
            }
            d5 = d6 + d3;
        }
        d2.add(new t(d4, d5));
    }

    private void b(D d2, double d3, boolean bl2) {
        double d4;
        double d5;
        block2 : {
            double d6 = this.a(d2);
            d4 = this.b(d2);
            if (bl2 && this.f) {
                d5 = this.a(d6 - d3, false, true);
                if (v.f == 0) break block2;
            }
            d5 = d6 - d3;
        }
        d2.add(new t(d5, d4));
    }

    private void c(D d2, double d3, boolean bl2) {
        double d4;
        double d5;
        block2 : {
            double d6 = this.a(d2);
            d4 = this.b(d2);
            if (bl2 && this.f) {
                d5 = this.a(d6 + d3, true, true);
                if (v.f == 0) break block2;
            }
            d5 = d6 + d3;
        }
        d2.add(new t(d5, d4));
    }

    private void d(D d2, double d3, boolean bl2) {
        double d4;
        double d5;
        block2 : {
            d4 = this.a(d2);
            double d6 = this.b(d2);
            if (bl2 && this.f) {
                d5 = this.a(d6 - d3, false, false);
                if (v.f == 0) break block2;
            }
            d5 = d6 - d3;
        }
        d2.add(new t(d4, d5));
    }

    private void a(List list, double d2, double d3, double d4, double d5) {
        G g2 = new G(d2, d3, d4, d5);
        F f2 = new F(true, d2, Math.min(d3, d5), Math.max(d3, d5), g2);
        F f3 = new F(false, d4, Math.min(d3, d5), Math.max(d3, d5), g2);
        list.add(f2);
        list.add(f3);
    }

    /*
     * Unable to fully structure code
     */
    private void a(List var1_1) {
        var13_2 = v.f;
        e.a(var1_1, null);
        var2_3 = new HashSet<J>();
        var3_4 = 0;
        var4_5 = 0;
        var5_6 = -1.7976931348623157E308;
        var7_7 = 0;
        do {
            block7 : {
                if (var7_7 >= var1_1.size()) return;
                var8_8 = (F)var1_1.get(var7_7);
                if (var8_8.b > var5_6 && var4_5 > this.q) {
                    var9_9 = new ArrayList<J>();
                    for (J var11_12 : var2_3) {
                        if (var7_7 - var11_12.a <= this.r) continue;
                        var9_9.add(var11_12);
                        var12_13 = var11_12.a(false, var8_8.b);
                        var12_13.e = --var3_4;
                        var1_1.add(var7_7, var12_13);
                        var4_5 -= var7_7 - var8_8.f.a;
                        ++var7_7;
                        if (var13_2 == 0) {
                            if (var13_2 == 0) continue;
                        }
                        break block7;
                    }
                    for (var10_11 = var9_9.size() - 1; var10_11 >= 0; var4_5 += var3_4, --var10_11) {
                        var11_12 = (J)var9_9.get(var10_11);
                        var12_13 = var11_12.a(true, var8_8.b);
                        var12_13.e = ++var3_4;
                        var1_1.add(var7_7, var12_13);
                        var11_12.a = var7_7++;
                        if (var13_2 == 0) {
                            if (var13_2 == 0) continue;
                        }
                        break block7;
                    }
                }
                var5_6 = var8_8.b;
            }
            if (!var8_8.a) ** GOTO lbl-1000
            var2_3.add(var8_8.f);
            var8_8.f.a = var7_7;
            ++var3_4;
            if (var13_2 != 0) lbl-1000: // 2 sources:
            {
                var2_3.remove(var8_8.f);
                var4_5 -= var7_7 - var8_8.f.a;
                var8_8.f.a = 0;
                --var3_4;
            }
            var4_5 += var3_4;
            var8_8.e = var3_4;
            ++var7_7;
        } while (var13_2 == 0);
    }

    private void c(D d2) {
        int n2 = v.f;
        t t2 = null;
        Iterator iterator = d2.iterator();
        do {
            if (!iterator.hasNext()) return;
            t t3 = (t)iterator.next();
            if (t2 != null) {
                this.a(new t(t3.b, t3.a), new t(t2.b, t2.a), this.o);
                this.a(t3, t2, this.n);
            }
            t2 = t3;
        } while (n2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private void a(t var1_1, t var2_2, List var3_3) {
        var13_4 = v.f;
        if (var1_1.a() > var2_2.a()) ** GOTO lbl-1000
        var8_5 = var1_1;
        var9_6 = var2_2;
        if (var13_4 != 0) lbl-1000: // 2 sources:
        {
            var8_5 = var2_2;
            var9_6 = var1_1;
        }
        var10_7 = new G(var8_5.a(), var8_5.b(), var9_6.a(), var9_6.b());
        var4_8 = new F(true, var8_5.a(), var8_5.b(), var9_6.b(), var10_7);
        var5_9 = new F(false, var9_6.a(), var9_6.b(), var8_5.b(), var10_7);
        var6_10 = this.a(var5_9, var3_3);
        var7_11 = this.a(var4_8, var3_3);
        var5_9.e = var3_3.size() > var6_10 - 1 && var6_10 > 0 ? ((F)var3_3.get((int)(var6_10 - 1))).e : 0;
        for (var11_12 = var7_11; var11_12 < var6_10; ++var12_13.e, ++var11_12) {
            var12_13 = (F)var3_3.get(var11_12);
            if (var13_4 == 0) {
                if (var13_4 == 0) continue;
            }
            ** GOTO lbl-1000
        }
        if (var3_3.size() > var7_11 - 1 && var7_11 > 0) {
            v0 = ((F)var3_3.get((int)(var7_11 - 1))).e;
        } else lbl-1000: // 2 sources:
        {
            v0 = 0;
        }
        var11_12 = v0;
        var4_8.e = var11_12 + 1;
        var3_3.add(var6_10, var5_9);
        var3_3.add(var7_11, var4_8);
    }

    public void a(Object object) {
        this.t = object;
    }

    public double b() {
        return this.d;
    }

    public double c() {
        return this.e;
    }

    public double d() {
        return this.v;
    }
}

