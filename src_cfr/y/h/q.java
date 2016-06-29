/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import y.c.I;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.h.O;
import y.h.P;
import y.h.a.v;
import y.h.a.y;
import y.h.bu;
import y.h.cg;
import y.h.fj;
import y.h.hL;
import y.h.hM;
import y.h.hQ;

final class Q
implements cg {
    boolean a;
    private final O b;

    private Q(O o2) {
        this.b = o2;
    }

    @Override
    public Iterator a(bu bu2, int n2) {
        hM hM2 = new hM(this.a((i)bu2, n2));
        if ((n2 & 124) == 0) return hM2;
        return new hQ(bu2, hM2, n2, true);
    }

    @Override
    public Iterator b(bu bu2, int n2) {
        hL hL2 = new hL(this.a((i)bu2, n2));
        if ((n2 & 124) == 0) return hL2;
        return new hQ(bu2, hL2, n2, false);
    }

    private ArrayList a(i i2, int n2) {
        boolean bl2;
        boolean bl3 = (n2 & 81) != 0;
        if ((n2 & 46) != 0) {
            bl2 = true;
            return this.a(i2, bl3, bl2);
        }
        bl2 = false;
        return this.a(i2, bl3, bl2);
    }

    /*
     * Unable to fully structure code
     */
    private ArrayList a(i var1_1, boolean var2_2, boolean var3_3) {
        block15 : {
            var11_4 = fj.z;
            var4_5 = new ArrayList<I>(Math.min(250, var1_1.g() + var1_1.e()));
            if (var3_3 && this.a) {
                var5_6 = var1_1.p();
                while (var5_6.f()) {
                    var4_5.add(var5_6.a());
                    var5_6.g();
                    if (!var11_4) {
                        if (!var11_4) continue;
                    }
                    break block15;
                }
            }
            if (!var2_2) ** GOTO lbl23
            var5_6 = v.a(var1_1);
            if (var5_6 == null) ** GOTO lbl16
            var5_6.a(var5_6.e(var1_1), new P(this, var4_5));
            if (!var11_4) ** GOTO lbl23
lbl16: // 2 sources:
            var6_7 = var1_1.o();
            while (var6_7.f()) {
                var4_5.add(var6_7.e());
                var6_7.g();
                if (!var11_4) {
                    if (!var11_4) continue;
                }
                ** GOTO lbl-1000
            }
        }
        if (var3_3 && !this.a) {
            var5_6 = var1_1.p();
            while (var5_6.f()) {
                v0 = var4_5;
                if (!var11_4) {
                    v0.add((d)var5_6.a());
                    var5_6.g();
                    if (!var11_4) continue;
                }
                break;
            }
        } else lbl-1000: // 4 sources:
        {
            v0 = var5_6 = new ArrayList(var4_5.size());
        }
        if (!var4_5.isEmpty() && var1_1 instanceof bu) {
            var6_7 = this.a(var4_5, (bu)var1_1);
            var7_8 = 0;
            while (var7_8 < var6_7.length) {
                v1 = var8_9 = var6_7[var7_8];
                if (var11_4 != false) return v1;
                if (v1 != null) {
                    var10_11 = var8_9.size();
                    for (var9_10 = 0; var9_10 < var10_11; ++var9_10) {
                        var5_6.add(var8_9.get(var9_10));
                        if (!var11_4) {
                            if (!var11_4) continue;
                        }
                        break;
                    }
                } else {
                    ++var7_8;
                }
                if (!var11_4) continue;
            }
        }
        v1 = var5_6;
        return v1;
    }

    private ArrayList[] a(ArrayList arrayList, bu bu2) {
        ArrayList[] arrarrayList;
        int n2;
        int n3;
        block7 : {
            boolean bl2 = fj.z;
            n2 = 0;
            arrarrayList = new ArrayList[10];
            int n4 = arrayList.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                Object e2 = arrayList.get(i2);
                n3 = e2 instanceof q;
                if (!bl2) {
                    int n5;
                    block6 : {
                        if (n3 != 0) {
                            n5 = this.b.getLayer(bu2, (q)e2);
                            if (!bl2) break block6;
                        }
                        n5 = this.b.getLayer(bu2, (d)e2);
                    }
                    n2 = Math.max(n5, n2);
                    if (n5 >= arrarrayList.length) {
                        ArrayList[] arrarrayList2 = new ArrayList[n5 + 5];
                        System.arraycopy(arrarrayList, 0, arrarrayList2, 0, arrarrayList.length);
                        arrarrayList = arrarrayList2;
                    }
                    if (arrarrayList[n5] == null) {
                        arrarrayList[n5] = new ArrayList(64);
                    }
                    arrarrayList[n5].add(e2);
                    if (!bl2) continue;
                }
                break block7;
            }
            n3 = n2;
        }
        if (n3 >= arrarrayList.length - 1) return arrarrayList;
        ArrayList[] arrarrayList3 = new ArrayList[n2 + 1];
        System.arraycopy(arrarrayList, 0, arrarrayList3, 0, n2 + 1);
        return arrarrayList3;
    }

    Q(O o2, P p2) {
        this(o2);
    }
}

