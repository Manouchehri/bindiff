/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import y.h.aB;
import y.h.aF;
import y.h.aG;
import y.h.aI;
import y.h.aO;
import y.h.aT;
import y.h.aY;
import y.h.fK;
import y.h.fj;
import y.h.gr;

public final class aM {
    private final aY c = new aY("DEFAULT");
    Map a;
    Set b;

    private aM() {
        this.c.k = new gr();
        this.c.i = new fK();
        this.a = new HashMap();
        this.b = Collections.unmodifiableSet(this.a.keySet());
    }

    aY a() {
        return this.c;
    }

    public void a(aF aF2, String string) {
        aY aY2 = (aY)this.a.get(string);
        if (aY2 == null) throw new IllegalArgumentException();
        if (aF.a(aF2) == aY2) return;
        aF.a(aF2, aY2);
        if (aF.a((aF)aF2).o != null) {
            aF.a((aF)aF2).o.a(aF2);
        }
        aF2.setDirty();
        if (!fj.z) return;
        throw new IllegalArgumentException();
    }

    aM(aG aG2) {
        this();
    }
}

