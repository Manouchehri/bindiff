/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.CircularStyle;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.HierarchicOrientation;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.HierarchicStyle;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.OrthogonalStyle;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters.ZyGraphLayouter$1;
import y.f.a.a;
import y.f.a.f;
import y.f.aN;
import y.f.ad;
import y.f.ah;
import y.f.an;
import y.f.c.K;
import y.f.c.M;
import y.f.c.a.B;
import y.f.c.a.aY;
import y.f.c.a.bs;
import y.f.c.b;
import y.f.c.d;
import y.f.c.v;
import y.f.f.c;
import y.f.k.o;
import y.h.bu;

public class ZyGraphLayouter {
    public static void alignNodesToTopLayer(bu bu2, y.f.c c2) {
        if (!(c2 instanceof K)) {
            if (!(c2 instanceof M)) return;
            M m2 = (M)c2;
            m2.b(1);
            m2.E().a(0.0);
            return;
        }
        K k2 = (K)c2;
        k2.c(1);
        an an2 = (an)k2.g();
        k2.a(new b(k2.o()));
        bu2.a(b.a, an2.b() == 0 ? new d() : new y.f.c.c());
    }

    /*
     * Unable to fully structure code
     */
    public static y.f.c createCircularLayouter(CircularStyle var0, long var1_1) {
        Preconditions.checkNotNull((Object)var0, "Internal Error: Layout style can't be null");
        Preconditions.checkArgument(var1_1 >= 0, "Internal Error: Minimum node distance can't be negative");
        var3_2 = new a();
        switch (ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$CircularStyle[var0.ordinal()]) {
            case 1: {
                var3_2.b(0);
                ** break;
            }
            case 2: {
                var3_2.b(1);
                ** break;
            }
            case 3: {
                var3_2.b(3);
                ** break;
            }
        }
        throw new IllegalStateException("Internal Error: Unknown layout style");
lbl15: // 3 sources:
        var3_2.c(0);
        var4_3 = var3_2.n();
        var4_3.h(true);
        var4_3.a((int)var1_1);
        var5_4 = var3_2.o();
        var5_4.b((int)var1_1);
        var5_4.h(false);
        return var3_2;
    }

    /*
     * Unable to fully structure code
     */
    public static y.f.c createHierarchicalLayouter(HierarchicStyle var0, long var1_1, long var3_2, long var5_3, long var7_4, HierarchicOrientation var9_5) {
        Preconditions.checkNotNull((Object)var0, "Internal Error: Layout style can't be null");
        Preconditions.checkArgument(var1_1 >= 0, "Internal Error: Minimum layer distance can't be negative");
        Preconditions.checkArgument(var3_2 >= 0, "Internal Error: Minimum node distance can't be negative");
        Preconditions.checkArgument(var5_3 >= 0, "Internal Error: Minimum edge distance can't be negative");
        var10_6 = new M();
        var10_6.c(1);
        var10_6.k(true);
        var10_6.g(true);
        var10_6.a(var9_5 == HierarchicOrientation.HORIZONTAL ? 0 : 1);
        var10_6.h(true);
        var11_7 = var10_6.C();
        var11_7.a(true);
        var11_7.b(true);
        var11_7.a(25.0);
        var11_7.b(25.0);
        var12_8 = var10_6.E();
        var12_8.a(0.0);
        var13_9 = new aN(var10_6);
        var13_9.a(true);
        switch (ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[var0.ordinal()]) {
            case 1: {
                ZyGraphLayouter.setStyle(1, 1, true, var10_6, var11_7);
                ** break;
            }
            case 2: {
                ZyGraphLayouter.setStyle(1, 0, true, var10_6, var11_7);
                ** break;
            }
            case 3: {
                ZyGraphLayouter.setStyle(1, 2, false, var10_6, var11_7);
                ** break;
            }
            case 4: {
                ZyGraphLayouter.setStyle(0, 1, true, var10_6, var11_7);
                ** break;
            }
            case 5: {
                ZyGraphLayouter.setStyle(0, 0, true, var10_6, var11_7);
                ** break;
            }
            case 6: {
                ZyGraphLayouter.setStyle(0, 2, true, var10_6, var11_7);
                ** break;
            }
            case 7: {
                ZyGraphLayouter.setStyle(2, 1, true, var10_6, var11_7);
                ** break;
            }
            case 8: {
                ZyGraphLayouter.setStyle(2, 0, true, var10_6, var11_7);
                ** break;
            }
            case 9: {
                ZyGraphLayouter.setStyle(2, 2, true, var10_6, var11_7);
                ** break;
            }
            case 10: {
                ZyGraphLayouter.setStyle(4, 1, true, var10_6, var11_7);
                ** break;
            }
            case 11: {
                ZyGraphLayouter.setStyle(4, 0, true, var10_6, var11_7);
                ** break;
            }
            case 12: {
                ZyGraphLayouter.setStyle(4, 2, false, var10_6, var11_7);
                ** break;
            }
        }
        throw new IllegalStateException("Internal Error: Unknown layout style");
lbl58: // 12 sources:
        var10_6.a(var1_1);
        var10_6.b(var3_2);
        var10_6.c(var5_3);
        var10_6.d(var7_4);
        return var10_6;
    }

    private static void setStyle(byte by2, byte by3, boolean bl2, M m2, B b2) {
        m2.b(by2);
        m2.i(bl2);
        b2.a(new bs(by3));
    }

    public static y.f.c createIncrementalHierarchicalLayouter(boolean bl2, long l2, long l3, HierarchicOrientation hierarchicOrientation) {
        M m2 = new M();
        an an2 = (an)m2.g();
        an2.a(hierarchicOrientation == HierarchicOrientation.HORIZONTAL ? 0 : 1);
        m2.a(l2);
        m2.b(l3);
        m2.d(25.0);
        m2.c(25.0);
        m2.h(true);
        m2.b(true);
        m2.i(bl2);
        return m2;
    }

    public static y.f.c createOrthoLayouter(OrthogonalStyle orthogonalStyle, long l2, boolean bl2) {
        Preconditions.checkArgument(l2 > 0, "Internal Error: Grid size can not be 0 or lower.");
        Preconditions.checkNotNull((Object)orthogonalStyle, "Internal Error: Layout style can't be null");
        c c2 = new c();
        c2.b(orthogonalStyle == OrthogonalStyle.NORMAL ? 0 : 4);
        an an2 = (an)c2.g();
        an2.a(bl2 ? 0 : 1);
        c2.a((int)l2);
        return c2;
    }
}

