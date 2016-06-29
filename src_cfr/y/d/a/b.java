/*
 * Decompiled with CFR 0_115.
 */
package y.d.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import y.c.A;
import y.c.d;
import y.c.q;
import y.c.x;
import y.d.a.c;
import y.d.a.e;
import y.d.a.g;
import y.d.a.h;
import y.d.a.i;
import y.d.a.j;
import y.d.a.k;
import y.d.b.l;
import y.d.b.v;
import y.d.b.z;
import y.f.h.N;
import y.g.o;

public class b {
    protected int a;
    private l c;
    private k d;
    private y.c.i e;
    private y.c.h f;
    private A g;
    private i h;
    public static int b;

    public void a(k k2) {
        this.d = k2;
    }

    public void a(l l2, Collection collection, N n2, A a2, y.c.h h2) {
        ArrayList<d> arrayList;
        int n3;
        block5 : {
            n3 = b;
            this.e = n2.g();
            this.e.j();
            this.g = a2;
            this.f = h2;
            this.a = 0;
            this.a(l2, collection);
            arrayList = new ArrayList<d>(this.e.h());
            y.c.e e2 = this.e.p();
            while (e2.f()) {
                arrayList.add(e2.a());
                e2.g();
                if (n3 == 0) {
                    if (n3 == 0) continue;
                }
                break block5;
            }
            y.g.e.a(arrayList, (Comparator)new g(this, h2));
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            d d2;
            d d3;
            block6 : {
                d3 = (d)arrayList.get(i2);
                d2 = this.e.a(d3.d(), d3.d().f(), d3.c(), null, 1, 1);
                n2.b(d3, d2);
                e e3 = (e)h2.b(d3);
                if (e3.a()) {
                    n2.m(d3);
                    if (n3 == 0) break block6;
                }
                n2.m(d2);
            }
            h2.a((Object)d3, e3.e);
            h2.a((Object)d2, e3.e);
            if (n3 == 0) continue;
        }
        if (!y.c.i.g) return;
        b = ++n3;
    }

    public void a(l l2, Collection collection, y.c.i i2, A a2, y.c.h h2) {
        int n2 = b;
        this.e = i2;
        i2.j();
        this.g = a2;
        this.f = h2;
        this.a = 0;
        this.a(l2, collection);
        y.c.e e2 = i2.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            Object object = ((e)h2.b((Object)d2)).e;
            h2.a((Object)d2, object);
            e2.g();
        } while (n2 == 0);
    }

    public void a(l l2, Collection collection) {
        int n2 = b;
        this.c = l2;
        TreeMap treeMap = new TreeMap(l2.c());
        h h2 = new h(this, null);
        this.a(collection, treeMap, h2);
        e[] arre = new e[2];
        ArrayList arrayList = new ArrayList();
        q q2 = null;
        do {
            Object object;
            int n3 = treeMap.isEmpty();
            if (n3 != 0) return;
            block1 : do {
                int n4;
                block13 : {
                    Object k2 = treeMap.firstKey();
                    j j2 = (j)treeMap.get(k2);
                    object = j2.c;
                    treeMap.remove(k2);
                    if (this.d != null) {
                        this.d.a(j2);
                    }
                    h2.a(object, arrayList, arre);
                    if (this.a == 0) {
                        q2 = this.e.d();
                        this.g.a((Object)q2, object);
                        for (n4 = 0; n4 < arrayList.size(); ++n4) {
                            e e2 = (e)arrayList.get(n4);
                            d d2 = this.e.a(q2, q2.f(), e2.a, null, 1, 1);
                            this.f.a((Object)d2, e2);
                            e2.a = q2;
                            if (n2 == 0) {
                                if (n2 == 0) continue;
                            }
                            break;
                        }
                    } else {
                        n4 = 0;
                    }
                    while (n4 < j2.b.size()) {
                        e e3 = (e)j2.b.get(n4);
                        h2.a(e3);
                        ++n4;
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break block13;
                    }
                    h2.a(object);
                }
                for (n4 = 0; n4 < j2.a.size(); ++n4) {
                    e e4 = (e)j2.a.get(n4);
                    e4.a = q2;
                    h2.a(object, e4);
                    if (n2 != 0) break block1;
                    if (n2 == 0) continue;
                }
                if (this.a != 1) break;
                arrayList.addAll(j2.a);
                n4 = 0;
                while (n4 < arrayList.size()) {
                    block14 : {
                        Object e5 = arrayList.get(n4);
                        n3 = 0;
                        if (n2 != 0) continue block1;
                        for (int i2 = v757574; i2 < arrayList.size(); ++i2) {
                            Object e6 = arrayList.get(i2);
                            this.h.a(e5, e6);
                            if (n2 == 0) {
                                if (n2 == 0) continue;
                            }
                            break block14;
                        }
                        ++n4;
                    }
                    if (n2 == 0) continue;
                }
                break block1;
                break;
            } while (true);
            e e4 = h2.b(arre[0]);
            this.a(object, treeMap, arre[0], e4);
            e e2 = h2.c(arre[1]);
            this.a(object, treeMap, e2, arre[1]);
        } while (n2 == 0);
    }

    private void a(Collection collection, TreeMap treeMap, h h2) {
        int n2;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        block13 : {
            int n3 = b;
            n2 = 0;
            Comparator comparator = this.c.c();
            double d2 = 1.0;
            object5 = collection.iterator();
            while (object5.hasNext()) {
                object4 = object5.next();
                object3 = this.c.c(object4);
                object = this.c.d(object4);
                object2 = comparator;
                if (n3 == 0) {
                    j j2;
                    j j3;
                    if (object2.compare(object3, object) > 0) {
                        Object object6 = object;
                        object = object3;
                        object3 = object6;
                    }
                    double d3 = this.c.k(object3).e();
                    double d4 = this.c.l(object3).e();
                    double d5 = this.c.k(object).e();
                    double d6 = this.c.l(object).e();
                    if (d3 < 0.0) {
                        d3 = - d3;
                    }
                    if (d4 < 0.0) {
                        d4 = - d4;
                    }
                    if (d5 < 0.0) {
                        d5 = - d5;
                    }
                    if (d6 < 0.0) {
                        d6 = - d6;
                    }
                    do {
                        double d7;
                        double d8;
                        if (d3 < d2) {
                            d7 = d4;
                            d8 = d2;
                            if (n3 == 0) {
                                if (d7 < d8 && d5 < d2 && d6 < d2) break;
                            }
                        } else {
                            d7 = d2;
                            d8 = 2.0;
                        }
                        d2 = d7 * d8;
                    } while (n3 == 0);
                    if ((j2 = (j)treeMap.get(object3)) == null) {
                        j2 = new j(object3);
                        treeMap.put(object3, j2);
                    }
                    if ((j3 = (j)treeMap.get(object)) == null) {
                        j3 = new j(object);
                        treeMap.put(object, j3);
                    }
                    if (object3.equals(object)) continue;
                    e e2 = new e(this, object3, object, object4, n2++);
                    j2.a.add(e2);
                    j3.b.add(e2);
                    if (n3 == 0) continue;
                }
                break block13;
            }
            object5 = this.c.a(- d2, d2);
            object4 = this.c.a(d2, d2);
            object3 = this.c.a(- d2, - d2);
            object = this.c.a(d2, - d2);
            object2 = this.c.c(object5, object4);
        }
        Comparator comparator = object2;
        Object object7 = this.c.c(object3, object);
        e e3 = new e(this, object5, object4, comparator, n2++);
        e e4 = new e(this, object3, object, object7, n2++);
        h2.a(object5, e3);
        h2.a(object3, e4);
    }

    /*
     * Unable to fully structure code
     */
    protected void a(Object var1_1, TreeMap var2_2, e var3_3, e var4_4) {
        var9_5 = b.b;
        var5_6 = this.c.f(var3_3.g, var4_4.g);
        if (var5_6 == null) {
            return;
        }
        if (this.c.c().compare(var1_1, var5_6) >= 0) return;
        var6_7 = false;
        do lbl-1000: // 3 sources:
        {
            if (this.c.c().compare(var5_6, var3_3.d) < 0) {
                var6_7 = true;
            }
            if ((var3_3 = var3_3.h) == null) ** GOTO lbl13
            v0 = var6_7;
            if (!v0) ** GOTO lbl-1000
lbl13: // 2 sources:
            v0 = false;
        } while (var9_5 != 0);
        var7_8 = v0;
        block1 : do {
            if (this.c.c().compare(var5_6, var4_4.d) < 0) {
                var7_8 = true;
            }
            if ((var4_4 = var4_4.h) == null) ** GOTO lbl23
            v1 = var7_8;
            do {
                if (!v1) continue block1;
lbl23: // 2 sources:
                v1 = var6_7;
            } while (var9_5 != 0);
            break;
        } while (true);
        if (v1 == false) return;
        if (var7_8 == false) return;
        if (var2_2.containsKey(var5_6) != false) return;
        var8_9 = new j(var5_6);
        var2_2.put(var5_6, var8_9);
    }

    /*
     * Unable to fully structure code
     */
    public void a(l var1_1, Collection var2_2, y.c.i var3_3, A var4_4, y.c.h var5_5, boolean var6_6) {
        var24_7 = b.b;
        var7_8 = var1_1.i(var1_1.a(new v(0), new v(0)), var1_1.a(new v(0), new v(-1)));
        var8_9 = var1_1.c();
        var9_10 = var3_3.o();
        block0 : do {
            v0 = var9_10.f();
            block1 : while (v0) {
                var10_12 = var9_10.e();
                var11_13 = var4_4.b(var10_12);
                var12_14 = -1.7976931348623157E308;
                var14_18 = null;
                if (var24_7 != 0) ** GOTO lbl-1000
                var15_21 = var10_12.l();
                while (var15_21.f()) {
                    var16_22 = var15_21.a();
                    var17_23 = (e)var5_5.b(var16_22);
                    var18_24 = var4_4.b(var16_22.d());
                    var19_25 = var1_1.i(var11_13, var18_24);
                    var20_26 = var1_1.h(var7_8, var19_25);
                    v0 = var20_26 DCMPL 0.0;
                    if (var24_7 != 0) continue block1;
                    if (!v0) {
                        var20_26 = 6.283185307179586;
                    }
                    if (var20_26 < var12_14) {
                        o.a((Object)new StringBuffer().append("Error: Edge: ").append(var16_22).append(" Angle: ").append(var20_26 / 3.141592653589793 * 2.0).append(" !!").toString());
                    }
                    if (var20_26 != var12_14) ** GOTO lbl34
                    if (var8_9.compare(var11_13, var18_24) <= 0) ** GOTO lbl32
                    if (var17_23.b() > var14_18.b()) {
                        o.a((Object)"Error  ....>");
                        if (var24_7 != 0) {
                            v1 = y.c.i.g = y.c.i.g == false;
lbl32: // 2 sources:
                            if (var17_23.b() < var14_18.b()) {
                                o.a((Object)"Error  ....>");
                            }
                        }
                    }
lbl34: // 8 sources:
                    var12_14 = var20_26;
                    var14_18 = var17_23;
                    var15_21.g();
                    if (var24_7 == 0) continue;
                }
                var9_10.g();
                if (var24_7 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        if (var6_6) {
            v2 = 2;
        } else lbl-1000: // 2 sources:
        {
            v2 = 1;
        }
        var9_11 = v2;
        var10_12 = new TreeMap<K, V>(var1_1.c());
        var11_13 = var3_3.o();
        while (var11_13.f()) {
            var12_16 = var11_13.e();
            var13_29 = var4_4.b(var12_16);
            var14_18 = var10_12.put(var13_29, var12_16);
            if (var14_18 != null) {
                o.a((Object)new StringBuffer().append("Points is double mentioned :").append(var13_29).toString());
            }
            var11_13.g();
            if (var24_7 == 0) continue;
        }
        var11_13 = var2_2.toArray();
        var12_17 = 0;
        do {
            v3 = var12_17;
            block5 : do {
                if (v3 >= var11_13.length - 1) return;
                var13_29 = var11_13[var12_17];
                for (var14_20 = var12_17 + 1; var14_20 < var11_13.length; ++var14_20) {
                    var15_21 = var11_13[var14_20];
                    var16_22 = var1_1.c(var13_29);
                    var17_23 = var1_1.c(var15_21);
                    var18_24 = var1_1.d(var13_29);
                    var19_25 = var1_1.d(var15_21);
                    v3 = (int)var1_1.a(var13_29) ? 1 : 0;
                    if (var24_7 != 0) continue block5;
                    var20_28 = v3 != 0 ? 0 : 1;
                    var21_30 = var1_1.a(var15_21) != false ? 0 : 1;
                    var22_31 = false;
                    if (var1_1.b(var13_29, var17_23)) {
                        var22_31 = true;
                        this.a((TreeMap)var10_12, var5_5, var17_23, var13_29, var15_21, 2, var21_30, var9_11);
                    }
                    if (var1_1.b(var13_29, var19_25)) {
                        var22_31 = true;
                        this.a((TreeMap)var10_12, var5_5, var19_25, var13_29, var15_21, 2, var21_30, var9_11);
                    }
                    if (var1_1.b(var15_21, var16_22)) {
                        var22_31 = true;
                        this.a((TreeMap)var10_12, var5_5, var16_22, var13_29, var15_21, var20_28, 2, var9_11);
                    }
                    if (var1_1.b(var15_21, var18_24)) {
                        var22_31 = true;
                        this.a((TreeMap)var10_12, var5_5, var18_24, var13_29, var15_21, var20_28, 2, var9_11);
                    }
                    if (var22_31 || (var23_32 = var1_1.g(var13_29, var15_21)) == null || (var16_22.equals(var23_32) || var18_24.equals(var23_32)) && (var17_23.equals(var23_32) || var19_25.equals(var23_32))) continue;
                    this.a((TreeMap)var10_12, var5_5, var23_32, var13_29, var15_21, 2, 2, var9_11);
                    if (var24_7 == 0) continue;
                }
                break;
            } while (true);
            ++var12_17;
        } while (var24_7 == 0);
    }

    protected boolean a(TreeMap treeMap, y.c.h h2, Object object, Object object2, Object object3, int n2, int n3, int n4) {
        int n5;
        int n6;
        block7 : {
            int n7 = b;
            q q2 = (q)treeMap.get(object);
            if (q2 == null) {
                o.a((Object)"Crossing not found: ");
                o.a(object2);
                o.a(object3);
                o.a(object);
                return false;
            }
            n5 = 0;
            n6 = 0;
            y.c.e e2 = q2.j();
            while (e2.f()) {
                d d2 = e2.a();
                Object object4 = h2.b(d2);
                if (n7 == 0) {
                    if (object4 == object2) {
                        ++n5;
                    }
                    if (object4 == object3) {
                        ++n6;
                    }
                    e2.g();
                    if (n7 == 0) continue;
                }
                break block7;
            }
            if (n5 == n2 * n4) {
                if (n6 == n3 * n4) return true;
            }
            o.a((Object)"Crossing found, but not for this segments:");
            o.a((Object)new StringBuffer().append("at ").append(object).toString());
        }
        if (n5 != n2 * n4) {
            o.a((Object)new StringBuffer().append("Is: ").append(n5).append(" Should: ").append(n2).append(" Seg: ").append(object2).toString());
        }
        if (n6 == n3 * n4) return false;
        o.a((Object)new StringBuffer().append("Is: ").append(n6).append(" Should: ").append(n3).append(" Seg: ").append(object3).toString());
        return false;
    }

    static l a(b b2) {
        return b2.c;
    }
}

