/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.List;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ad;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.x;

class aV
extends ab {
    private int b;
    private boolean c;

    aV() {
    }

    @Override
    protected void b(aa aa2) {
        super.b(aa2);
        this.b = aa2.d().f().l();
        this.c = this.b > 0;
    }

    @Override
    double[] a(f f2, R r2, P[] arrp, v[] arrv, double[] arrd) {
        if (this.c) return super.a(f2, r2, arrp, arrv, arrd);
        this.b("punish bends in node to edge distance", 0.0, false);
        return new double[arrp.length];
    }

    @Override
    protected double a(f f2, R r2, P p2, v v2, double d2) {
        R r3 = f2.a();
        double d3 = 0.0;
        if (aV.a(r3)) {
            d3 = this.b * aV.a(v2);
        }
        this.a("punish bends in node to edge distance", d3, false);
        return d3;
    }

    private static boolean a(R r2) {
        if (aV.b(r2).isEmpty()) return false;
        return true;
    }

    private static int a(v v2) {
        if (v2 == null) {
            return 0;
        }
        switch (v2.c()) {
            case 1: 
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
        }
        return 0;
    }

    private static List b(R r2) {
        return (List)r2.a(T.b);
    }
}

