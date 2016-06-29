/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.c.b;
import y.c.c;
import y.c.q;
import y.f.X;
import y.f.aE;
import y.f.k.A;
import y.f.k.I;
import y.f.k.K;
import y.f.k.P;
import y.f.k.d;
import y.f.k.l;
import y.f.k.x;

public class H
implements I {
    @Override
    public K a(x x2, X x3, q q2) {
        return null;
    }

    @Override
    public void a(q q2, b b2) {
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public A a(c var1_1, c var2_2, X var3_3, q var4_4, byte var5_5) {
        var11_6 = d.g;
        var6_7 = (A)var1_1.b(var4_4);
        var7_8 = new P(l.a, var6_7);
        var8_9 = new y.f.k.X(var7_8, var7_8);
        var7_8.h();
        var9_10 = var4_4.g();
        if (var9_10 != null) ** GOTO lbl-1000
        var10_11 = aE.a(0);
        if (var11_6 != 0) lbl-1000: // 2 sources:
        {
            if ((var10_11 = aE.e(var3_3, var9_10)) == null) {
                var10_11 = aE.a(0);
            }
        }
        switch (var5_5) {
            case 0: {
                switch (var10_11.b()) {
                    default: {
                        if (var11_6 == 0) break;
                    }
                    case 4: {
                        var8_9.a(0, true);
                        if (var11_6 == 0) break;
                    }
                    case 8: {
                        var8_9.b(0, true);
                        if (var11_6 == 0) break;
                    }
                    case 2: {
                        var8_9.d(0, true);
                        var8_9.a(0, true);
                    }
                }
                var8_9.d(1);
                if (var11_6 == 0) break;
            }
            case 1: {
                switch (var10_11.b()) {
                    case 1: {
                        var8_9.c(0, true);
                        if (var11_6 == 0) ** GOTO lbl41
                    }
                    case 2: {
                        var8_9.d(0, true);
                        if (var11_6 == 0) ** GOTO lbl41
                    }
                    default: {
                        if (var11_6 == 0) ** GOTO lbl41
                    }
                    case 8: 
                }
                var8_9.b(0, true);
                var8_9.c(0, true);
lbl41: // 4 sources:
                var8_9.b(1);
                if (var11_6 == 0) break;
            }
            case 2: {
                switch (var10_11.b()) {
                    case 1: {
                        var8_9.c(0, true);
                        var8_9.b(1, true);
                        if (var11_6 == 0) ** GOTO lbl56
                    }
                    case 4: {
                        var8_9.a(0, true);
                        if (var11_6 == 0) ** GOTO lbl56
                    }
                    default: {
                        if (var11_6 == 0) ** GOTO lbl56
                    }
                    case 8: 
                }
                var8_9.b(0, true);
lbl56: // 4 sources:
                var8_9.e(1);
                if (var11_6 == 0) break;
            }
            case 3: {
                switch (var10_11.b()) {
                    case 1: {
                        var8_9.c(0, true);
                        if (var11_6 == 0) break;
                    }
                    case 4: {
                        var8_9.a(0, true);
                        var8_9.c(0, true);
                        if (var11_6 == 0) break;
                    }
                    case 2: {
                        var8_9.d(0, true);
                        break;
                    }
                }
                var8_9.c(1);
                break;
            }
        }
        var7_8.h();
        var7_8.j();
        return var7_8.i();
    }
}

