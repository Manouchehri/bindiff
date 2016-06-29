/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.I;
import y.f.X;
import y.f.aF;
import y.f.ah;
import y.f.am;
import y.f.c.Q;
import y.f.c.a;
import y.f.c.au;
import y.f.c.av;
import y.f.c.h;
import y.f.w;

class at {
    private Map a = new HashMap();
    private av b;
    private Q c;
    private au d = new au();

    public at(Q q2) {
        this.c = q2;
    }

    public void a(Object object, X x2, A a2, int n2, y y2, y y3, c c2, c c3, c c4, c c5, c c6, c c7) {
        Object object2;
        void var21_28;
        Object object3;
        HashMap<Object, Object> hashMap2;
        Object object4;
        Object object5;
        C c8;
        C c9;
        Object object6;
        w w2;
        boolean bl2;
        HashMap<Object, Object> hashMap;
        block12 : {
            void var21_26;
            y.c.h h2;
            A a4;
            A a3;
            X x3;
            block11 : {
                bl2 = a.i;
                w2 = new w();
                A a5 = w2.t();
                h2 = w2.u();
                hashMap2 = new HashMap<Object, Object>();
                hashMap = new HashMap<Object, Object>();
                a3 = null;
                if (c4 != null) {
                    a3 = w2.t();
                    w2.a(aF.a, a3);
                }
                a4 = null;
                if (c5 != null) {
                    a4 = w2.t();
                    w2.a(aF.b, a4);
                }
                w2.a(ah.f_, a5);
                w2.a(ah.k, h2);
                c8 = x2.o();
                while (c8.f()) {
                    q q2 = c8.e();
                    object6 = w2.d();
                    object4 = c2.b(q2);
                    a5.a(object6, object4);
                    hashMap2.put(object4, object6);
                    x3 = w2;
                    if (!bl2) {
                        x3.a((q)object6, x2.a(q2));
                        c8.g();
                        if (!bl2) continue;
                    }
                    break block11;
                }
                x3 = x2;
            }
            c8 = x3.p();
            while (c8.f()) {
                d d2 = c8.a();
                object6 = (q)hashMap2.get(c2.b(d2.c()));
                object4 = (q)hashMap2.get(c2.b(d2.d()));
                object5 = w2.a((q)object6, (q)object4);
                w2.a((d)object5, x2.b(d2));
                object3 = c3.b(d2);
                h2.a(object5, object3);
                hashMap.put(object3, object5);
                if (c4 != null && (object2 = c4.b(d2)) != null) {
                    a3.a(object5, object2);
                }
                if (c5 != null && (object2 = c5.b(d2)) != null) {
                    a4.a(object5, object2);
                }
                c8.g();
                if (!bl2) continue;
            }
            c8 = new q[y2.size()];
            boolean bl3 = false;
            for (object6 = y2.k(); object6 != null; object6 = object6.a(), ++var21_26) {
                c9 = c8;
                if (!bl2) {
                    c9[var21_26] = (q)hashMap2.get(c2.b(object6.c()));
                    if (!bl2) continue;
                }
                break block12;
            }
            c9 = new q[y3.size()];
        }
        object6 = c9;
        boolean bl4 = false;
        for (object4 = y3.k(); object4 != null; object4 = object4.a(), ++var21_28) {
            object6[var21_28] = (q)hashMap2.get(c2.b(object4.c()));
            if (!bl2) continue;
        }
        object4 = w2.t();
        object5 = x2.o();
        while (object5.f()) {
            object3 = object5.e();
            object2 = c2.b(object3);
            object4.a(hashMap2.get(object2), a2.b(object3));
            object5.g();
            if (!bl2) continue;
        }
        object5 = new av(this.c, object, w2, (A)object4, n2, (q[])c8, (q[])object6, hashMap2, hashMap);
        this.a.put(object, object5);
    }

    public void a(Object object) {
        boolean bl2 = a.i;
        av av2 = (av)this.a.get(object);
        if (this.b == null) {
            this.b = av2;
        }
        c c2 = av2.b.c(ah.f_);
        x x2 = av2.b.o();
        while (x2.f()) {
            q q2 = x2.e();
            Object object2 = c2.b(q2);
            av av3 = (av)this.a.get(object2);
            if (bl2) return;
            if (av3 != null) {
                this.b(av2, av3);
            }
            x2.g();
            if (!bl2) continue;
        }
        this.a(this.b);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void b(av var1_1, av var2_2) {
        block38 : {
            block36 : {
                var20_3 = a.i;
                var3_4 = var2_2.b.c(ah.f_);
                var4_5 = (q)var1_1.i.get(var2_2.a);
                var5_6 = var1_1.b.c(ah.f_);
                var6_7 = var1_1.b.c(ah.k);
                var7_8 = 0;
                block12 : do {
                    v0 = var7_8;
                    block13 : while (v0 < var2_2.g.length) {
                        block37 : {
                            var8_10 = var2_2.g[var7_8];
                            var9_11 = var3_4.b(var8_10);
                            var10_12 = null;
                            var11_13 = (y.g.am)var9_11;
                            v1 = (int)"UpperGroupNode".equals(var11_13.a) ? 1 : 0;
                            if (var20_3) break block36;
                            if (v1 == 0) ** GOTO lbl20
                            var12_14 = ((y.g.am)var11_13.b).a;
                            var13_15 = null;
                            ** GOTO lbl24
lbl20: // 1 sources:
                            if (!"UpperDUmmyNode".equals(var11_13.a)) ** GOTO lbl83
                            var12_14 = ((y.g.am)((y.g.am)var9_11).b).a;
                            var13_15 = null;
                            ** GOTO lbl45
lbl24: // 7 sources:
                            for (var14_16 = var4_5.g(); var14_16 != null; var14_16 = var14_16.h()) {
                                var15_17 = var6_7.b(var14_16);
                                v0 = var15_17 instanceof y.g.am;
                                if (var20_3) continue block13;
                                if (v0 == 0) continue;
                                try {
                                    var16_18 = (y.g.am)var15_17;
                                    if (!"TargetGroupNodeConnector".equals(var16_18.a) || !((var17_27 = ((y.g.am)((y.g.am)var16_18.b).a).b) instanceof y.g.am) || !(((y.g.am)var17_27).a instanceof y.g.am)) continue;
                                    var18_28 = (y.g.am)((y.g.am)var17_27).a;
                                    if (!(var18_28.a instanceof y.g.am) || !"TargetInEdge".equals(((y.g.am)var18_28.a).a) || !var12_14.equals(var18_28.b)) continue;
                                    var13_15 = var18_28.b;
                                    var10_12 = var14_16;
                                    if (var20_3) {
                                        continue;
                                    }
                                    break block37;
                                }
                                catch (ClassCastException var16_19) {
                                    continue;
                                }
                                catch (NullPointerException var16_20) {
                                    // empty catch block
                                }
                            }
                            ** GOTO lbl83
lbl45: // 8 sources:
                            for (var14_16 = var4_5.g(); var14_16 != null; var14_16 = var14_16.h()) {
                                var15_17 = var6_7.b(var14_16);
                                v0 = var15_17 instanceof y.g.am;
                                if (var20_3) continue block13;
                                if (v0 == 0) continue;
                                try {
                                    var16_18 = (y.g.am)var15_17;
                                    if ("DummyEdge".equals(var16_18.a)) {
                                        var17_27 = (y.g.am)var5_6.b(var14_16.c());
                                        if ("UpperSameLayerEdgeSupport".equals(var17_27.a) && var12_14.equals(var18_28 = ((y.g.am)((y.g.am)var17_27.b).b).a)) {
                                            var13_15 = var18_28;
                                            var10_12 = var14_16;
                                            if (!var20_3) break;
                                        }
                                        if (!"BendNode".equals(var17_27.a)) continue;
                                        var18_28 = ((y.g.am)((y.g.am)((y.g.am)var17_27.b).a).b).a;
                                        if (var18_28 instanceof y.g.am && ((y.g.am)var18_28).b instanceof y.g.am && var12_14.equals(var19_29 = ((y.g.am)((y.g.am)var18_28).b).a)) {
                                            var13_15 = var19_29;
                                            var10_12 = var14_16;
                                            if (!var20_3) break;
                                        }
                                        if (!var12_14.equals(var18_28)) continue;
                                        var13_15 = var18_28;
                                        var10_12 = var14_16;
                                        if (!var20_3) break;
                                    }
                                    if (var12_14.equals(var17_27 = ((y.g.am)var16_18.b).a)) {
                                        var13_15 = var17_27;
                                        var10_12 = var14_16;
                                        if (!var20_3) break;
                                    }
                                    if (!(var17_27 instanceof y.g.am) || !"InEdge".equals(var18_28 = ((y.g.am)var17_27).a) && !"OutEdge".equals(var18_28) || !var12_14.equals(var17_27 = ((y.g.am)((y.g.am)var17_27).b).a)) continue;
                                    var13_15 = var17_27;
                                    var10_12 = var14_16;
                                    if (var20_3) {
                                        continue;
                                    }
                                    break;
                                }
                                catch (ClassCastException var16_21) {
                                    continue;
                                }
                                catch (NullPointerException var16_22) {
                                    // empty catch block
                                }
                                if (!var20_3) continue;
                            }
                        }
                        if (var10_12 != null) {
                            var2_2.e.a((Object)var8_10, var10_12);
                        }
                        ++var7_8;
                        if (!var20_3) continue block12;
                    }
                    break block12;
                    break;
                } while (true);
                v1 = 0;
            }
            var7_8 = v1;
            block16 : do {
                v2 = var7_8;
                block17 : while (v2 < var2_2.h.length) {
                    block39 : {
                        v3 = var2_2;
                        if (var20_3) break block38;
                        var8_10 = v3.h[var7_8];
                        var9_11 = var3_4.b(var8_10);
                        var10_12 = null;
                        var11_13 = (y.g.am)var9_11;
                        if (!"LowerGroupNode".equals(var11_13.a)) ** GOTO lbl104
                        var12_14 = ((y.g.am)var11_13.b).a;
                        var13_15 = null;
                        ** GOTO lbl108
lbl104: // 1 sources:
                        if (!"LowerDummyNode".equals(var11_13.a)) ** GOTO lbl167
                        var12_14 = ((y.g.am)((y.g.am)var9_11).b).a;
                        var13_15 = null;
                        ** GOTO lbl129
lbl108: // 7 sources:
                        for (var14_16 = var4_5.f(); var14_16 != null; var14_16 = var14_16.g()) {
                            var15_17 = var6_7.b(var14_16);
                            v2 = var15_17 instanceof y.g.am;
                            if (var20_3) continue block17;
                            if (v2 == 0) continue;
                            try {
                                var16_18 = (y.g.am)var15_17;
                                if (!"SourceGroupNodeConnector".equals(var16_18.a) || !((var17_27 = ((y.g.am)((y.g.am)var16_18.b).b).b) instanceof y.g.am) || !(((y.g.am)var17_27).a instanceof y.g.am)) continue;
                                var18_28 = (y.g.am)((y.g.am)var17_27).a;
                                if (!(var18_28.a instanceof y.g.am) || !"SourceOutEdge".equals(((y.g.am)var18_28.a).a) || !var12_14.equals(var18_28.b)) continue;
                                var13_15 = var18_28.b;
                                var10_12 = var14_16;
                                if (var20_3) {
                                    continue;
                                }
                                break block39;
                            }
                            catch (ClassCastException var16_23) {
                                continue;
                            }
                            catch (NullPointerException var16_24) {
                                // empty catch block
                            }
                        }
                        ** GOTO lbl167
lbl129: // 8 sources:
                        for (var14_16 = var4_5.f(); var14_16 != null; var14_16 = var14_16.g()) {
                            var15_17 = var6_7.b(var14_16);
                            v2 = var15_17 instanceof y.g.am;
                            if (var20_3) continue block17;
                            if (v2 == 0) continue;
                            try {
                                var16_18 = (y.g.am)var15_17;
                                if ("DummyEdge".equals(var16_18.a)) {
                                    var17_27 = (y.g.am)var5_6.b(var14_16.d());
                                    if ("LowerSameLayerEdgeSupport".equals(var17_27.a) && var12_14.equals(var18_28 = ((y.g.am)((y.g.am)var17_27.b).b).a)) {
                                        var13_15 = var18_28;
                                        var10_12 = var14_16;
                                        if (!var20_3) break;
                                    }
                                    if (!"BendNode".equals(var17_27.a)) continue;
                                    var18_28 = ((y.g.am)((y.g.am)((y.g.am)var17_27.b).a).b).a;
                                    if (var18_28 instanceof y.g.am && ((y.g.am)var18_28).b instanceof y.g.am && var12_14.equals(var19_29 = ((y.g.am)((y.g.am)var18_28).b).a)) {
                                        var13_15 = var19_29;
                                        var10_12 = var14_16;
                                        if (!var20_3) break;
                                    }
                                    if (!var12_14.equals(var18_28)) continue;
                                    var13_15 = var18_28;
                                    var10_12 = var14_16;
                                    if (!var20_3) break;
                                }
                                if (var12_14.equals(var17_27 = ((y.g.am)var16_18.b).a)) {
                                    var13_15 = var17_27;
                                    var10_12 = var14_16;
                                    if (!var20_3) break;
                                }
                                if (!(var17_27 instanceof y.g.am) || !"InEdge".equals(var18_28 = ((y.g.am)var17_27).a) && !"OutEdge".equals(var18_28) || !var12_14.equals(var17_27 = ((y.g.am)((y.g.am)var17_27).b).a)) continue;
                                var13_15 = var17_27;
                                var10_12 = var14_16;
                                if (var20_3) {
                                    continue;
                                }
                                break;
                            }
                            catch (ClassCastException var16_25) {
                                continue;
                            }
                            catch (NullPointerException var16_26) {
                                // empty catch block
                            }
                            if (!var20_3) continue;
                        }
                    }
                    if (var10_12 != null) {
                        var2_2.e.a((Object)var8_10, var10_12);
                    }
                    ++var7_8;
                    if (!var20_3) continue block16;
                }
                break block16;
                break;
            } while (true);
            v3 = var2_2;
        }
        var7_9 = v3.b.o();
        while (var7_9.f()) {
            var8_10 = var7_9.e();
            var9_11 = var3_4.b(var8_10);
            var10_12 = (av)this.a.get(var9_11);
            if (var20_3 != false) return;
            if (var10_12 != null) {
                this.b(var2_2, (av)var10_12);
            }
            var7_9.g();
            if (!var20_3) continue;
        }
        this.a(var2_2);
    }

    private void a(av av2) {
        boolean bl2 = a.i;
        c c2 = av2.b.c(ah.f_);
        av2.k = new D[av2.c.d.length];
        int n2 = 0;
        do {
            if (n2 >= av2.c.d.length) return;
            av av3 = av2;
            block1 : do {
                y y2 = av3.c.d[n2];
                for (p p2 = y2.k(); p2 != null; p2 = p2.a()) {
                    av av4;
                    q q2 = (q)p2.c();
                    Object object = c2.b(q2);
                    av3 = av4 = (av)this.a.get(object);
                    if (bl2) continue block1;
                    if (av3 == null) continue;
                    if (av2.k[n2] == null) {
                        av2.k[n2] = new D();
                    }
                    av2.k[n2].add(av4);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            ++n2;
        } while (!bl2);
    }

    public Map a() {
        boolean bl2 = a.i;
        av av2 = this.b;
        int n2 = Integer.MAX_VALUE;
        int n3 = 20;
        while (n3-- > 0 && n2 > 0 && (n2 = this.c(null, av2)) != 0) {
            n2 = this.a(null, av2);
            if (!bl2) continue;
        }
        HashMap hashMap = new HashMap();
        this.a(av2, hashMap);
        return hashMap;
    }

    private void a(av av2, Map map) {
        boolean bl2 = a.i;
        c c2 = av2.b.c(ah.f_);
        x x2 = av2.b.o();
        do {
            if (!x2.f()) return;
            Object object = c2.b(x2.e());
            map.put(object, new Integer(av2.c.a[x2.e().d()]));
            av av3 = (av)this.a.get(object);
            if (av3 != null) {
                this.a(av3, map);
            }
            x2.g();
        } while (!bl2);
    }

    private int c(av av2, av av3) {
        int n2;
        int n3;
        boolean bl2 = a.i;
        h h2 = av2 != null ? av2.c : null;
        h h3 = av3.c;
        c c2 = av3.b.c(ah.f_);
        int n4 = 0;
        if (av2 != null) {
            p p2;
            int n5;
            int n6;
            block23 : {
                int n7 = n2 = av3.g != null && av3.g.length > 0 ? 1 : 0;
                if (n2 != 0) {
                    this.d.a = av2.c.k;
                    this.d.c = h3.a;
                    this.d.b = av3.e;
                    h3.d[0].sort(this.d);
                    n5 = 0;
                    for (p2 = h3.d[0].k(); p2 != null; p2 = p2.a()) {
                        h3.a[((q)p2.c()).d()] = n5++;
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break;
                    }
                } else {
                    n5 = 0;
                }
                while (n5 < h3.d.length) {
                    n6 = n5;
                    if (!bl2) {
                        if (n6 > 0) {
                            h3.a(n5);
                        }
                        if (av3.k[n5] != null) {
                            for (p2 = av3.k[n5].k(); p2 != null; n4 += this.c((av)av3, (av)((av)p2.c())), p2 = p2.a()) {
                                if (!bl2) {
                                    if (!bl2) continue;
                                }
                                break;
                            }
                        } else {
                            ++n5;
                        }
                        if (!bl2) continue;
                    }
                    break block23;
                }
                n6 = (int)h3.a() ? 1 : 0;
            }
            if (n6 != 0 && h3.d.length - (n2 != 0 ? 1 : 0) > 0) {
                h3.a(n2 != 0 ? 1 : 0, h3.d.length - 1);
            }
            if (av3.h != null && av3.h.length > 0) {
                n5 = 1;
                for (p2 = h3.d[h3.d.length - 1].k(); p2 != null; p2 = p2.a()) {
                    q q2 = (q)p2.c();
                    d d2 = (d)av3.e.b(q2);
                    if (!bl2) {
                        if (d2 == null) continue;
                        h2.g[d2.b()] = n5++;
                        if (!bl2) continue;
                    }
                    break;
                }
            } else {
                n4 += h3.f();
            }
            if (!bl2) return n4;
        }
        n2 = 0;
        while (n2 < av3.f) {
            n3 = n2;
            if (bl2) return n3;
            if (n3 > 0) {
                h3.a(n2);
            }
            if (av3.k[n2] != null) {
                for (p p3 = av3.k[n2].k(); p3 != null; n4 += this.c((av)av3, (av)((av)p3.c())), p3 = p3.a()) {
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break;
                }
            } else {
                ++n2;
            }
            if (!bl2) continue;
        }
        n3 = n4 + h3.f();
        return n3;
    }

    /*
     * Unable to fully structure code
     */
    public int a(av var1_1, av var2_2) {
        var12_3 = a.i;
        var3_4 = var1_1 != null ? var1_1.c : null;
        var4_5 = var2_2.c;
        var5_6 = var2_2.b.c(ah.f_);
        var6_7 = 0;
        if (var1_1 == null) ** GOTO lbl50
        v0 = var7_8 = var2_2.h != null && var2_2.h.length > 0 ? 1 : 0;
        if (var7_8 != 0) {
            this.d.a = var1_1.c.j;
            this.d.c = var4_5.a;
            this.d.b = var2_2.e;
            var4_5.d[var4_5.d.length - 1].sort(this.d);
            var8_9 = 0;
            for (var9_11 = var4_5.d[var4_5.d.length - 1].k(); var9_11 != null; var9_11 = var9_11.a()) {
                var4_5.a[((q)var9_11.c()).d()] = var8_9++;
                if (!var12_3) {
                    if (!var12_3) continue;
                }
                break;
            }
        } else {
            var8_9 = var4_5.d.length - 1;
        }
        while (var8_9 >= 0) {
            v1 = var8_9;
            v2 = var4_5.d.length - 1;
            if (!var12_3) {
                if (v1 < v2) {
                    var4_5.b(var8_9);
                }
                if (var2_2.k[var8_9] != null) {
                    for (var9_11 = var2_2.k[var8_9].k(); var9_11 != null; var6_7 += this.a((av)var2_2, (av)((av)var9_11.c())), var9_11 = var9_11.a()) {
                        if (!var12_3) {
                            if (!var12_3) continue;
                        }
                        break;
                    }
                } else {
                    --var8_9;
                }
                if (!var12_3) continue;
            }
            ** GOTO lbl48
        }
        if (var4_5.a() && var4_5.d.length - (var7_8 != 0 ? 1 : 0) > 0) {
            var4_5.a(var4_5.d.length - (var7_8 != 0 ? 2 : 1), 0);
        }
        if (var2_2.g != null && var2_2.g.length > 0) {
            var8_9 = 1;
            for (var9_11 = var4_5.d[0].k(); var9_11 != null; var9_11 = var9_11.a()) {
                var10_12 = (q)var9_11.c();
                var11_13 = (d)var2_2.e.b(var10_12);
                if (!var12_3) {
                    if (var11_13 == null) continue;
                    var3_4.h[var11_13.b()] = var8_9++;
                    if (!var12_3) continue;
                }
                break;
            }
        } else {
            v1 = var6_7;
            v2 = var4_5.f();
lbl48: // 2 sources:
            var6_7 = v1 + v2;
        }
        if (var12_3 == false) return var6_7;
lbl50: // 2 sources:
        var7_8 = var2_2.f - 1;
        while (var7_8 >= 0) {
            v3 = var7_8;
            v4 = var2_2.f - 1;
            if (var12_3 != false) return v3 + v4;
            if (v3 < v4) {
                var4_5.b(var7_8);
            }
            if (var2_2.k[var7_8] != null) {
                for (var8_10 = var2_2.k[var7_8].k(); var8_10 != null; var6_7 += this.a((av)var2_2, (av)((av)var8_10.c())), var8_10 = var8_10.a()) {
                    if (!var12_3) {
                        if (!var12_3) continue;
                    }
                    break;
                }
            } else {
                --var7_8;
            }
            if (!var12_3) continue;
        }
        v3 = var6_7;
        v4 = var4_5.f();
        return v3 + v4;
    }
}

