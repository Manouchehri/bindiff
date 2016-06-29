/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.aA;
import y.h.bu;
import y.h.cG;
import y.h.eR;
import y.h.fj;
import y.h.gZ;

class cO
implements PropertyChangeListener {
    private final WeakReference a;
    private final WeakReference b;
    private final WeakReference c;

    cO(cG cG2, bu bu2, gZ gZ2) {
        this.a = new WeakReference<cG>(cG2);
        this.b = new WeakReference<bu>(bu2);
        this.c = new WeakReference<gZ>(gZ2);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        cO.a((cG)this.a.get(), (bu)this.b.get(), (gZ)this.c.get(), (String)propertyChangeEvent.getNewValue());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private static void a(cG var0, bu var1_1, gZ var2_2, String var3_3) {
        var5_4 = fj.z;
        if (var1_1 == null) return;
        if (var2_2 == null) return;
        var1_1.r();
        try {
            if (!(var2_2 instanceof eR)) ** GOTO lbl-1000
            var1_1.a(new y(((eR)var2_2).f()).a());
            if (var5_4) lbl-1000: // 2 sources:
            {
                if (var2_2 instanceof aA) {
                    var1_1.a(new f(((aA)var2_2).getEdge()).a());
                }
            }
            if (var0 == null) {
                var2_2.setText(var3_3);
                if (var5_4 == false) return;
            }
            var0.a(var2_2, var3_3);
            return;
        }
        finally {
            var1_1.s();
        }
    }
}

