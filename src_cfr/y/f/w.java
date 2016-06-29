/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.f.C;
import y.f.E;
import y.f.Q;
import y.f.R;
import y.f.X;
import y.f.aG;
import y.f.aH;
import y.f.aO;
import y.f.aP;
import y.f.aj;
import y.f.z;

public class W
implements aH {
    @Override
    public double a(Q q2) {
        Object object;
        boolean bl2 = X.j;
        R r2 = q2.e();
        if (r2 instanceof aj) {
            return 1.0;
        }
        C c2 = (C)r2;
        byte by2 = c2.getPreferredPlacementDescriptor().a();
        E e2 = c2.getLabelModel();
        double d2 = 0.0;
        double d3 = 0.5;
        switch (by2) {
            case 1: {
                d3 = 0.0;
                if (!bl2) break;
            }
            case 2: {
                d3 = 1.0;
                if (!bl2) break;
            }
            case 4: {
                d3 = 0.5;
            }
        }
        if (e2 instanceof aO) {
            object = q2.l();
            aP aP2 = (aP)object;
            d2 = aP2.e();
        }
        if (!(e2 instanceof z)) return 1.0 - Math.abs((d3 - d2) * 2.0);
        object = q2.l();
        int n2 = (Integer)object;
        switch (n2) {
            case 1: 
            case 8: 
            case 64: {
                d2 = 0.05;
                if (!bl2) return 1.0 - Math.abs((d3 - d2) * 2.0);
            }
            case 2: 
            case 16: 
            case 128: {
                d2 = 0.5;
                if (!bl2) return 1.0 - Math.abs((d3 - d2) * 2.0);
            }
            case 4: 
            case 32: 
            case 256: {
                d2 = 0.95;
            }
        }
        return 1.0 - Math.abs((d3 - d2) * 2.0);
    }
}

