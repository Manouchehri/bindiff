/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.event.ChangeListener;
import y.h.bf;
import y.h.c;
import y.h.cW;
import y.h.ch;
import y.h.dw;
import y.h.dx;
import y.h.eE;
import y.h.eF;
import y.h.eG;
import y.h.fj;

public class eD
extends c
implements bf {
    private final Collection a = new ArrayList();
    private final Collection b = Collections.unmodifiableCollection(this.a);
    private final eG c;
    private fj d;
    private ch e;
    private eF f;

    public eD() {
        this.c = new eG(this, null);
    }

    public void a(eF eF2) {
        if (eF2 == null) return;
        this.a.add(eF2);
    }

    @Override
    public dx a(fj fj2, ch ch2, double d2, double d3, cW cW2) {
        if (!this.a()) {
            this.e = null;
            this.d = null;
            return null;
        }
        this.e = ch2;
        this.d = fj2;
        if (this.a(d2, d3) != null) {
            return this;
        }
        this.e = null;
        this.d = null;
        return null;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean a(dw var1_1) {
        var9_2 = fj.z;
        var2_3 = var1_1.a();
        var4_4 = var1_1.b();
        var6_5 = this.a.iterator();
        do lbl-1000: // 3 sources:
        {
            if (!var6_5.hasNext()) {
                return false;
            }
            var7_6 = (eF)var6_5.next();
            var7_6.a(this.e, this, this.d);
            if (!var7_6.a(var2_3, var4_4)) ** GOTO lbl-1000
            v0 = var8_7 = var7_6.a(var1_1);
            if (var9_2 != false) return v0;
        } while (!v0);
        return true;
    }

    @Override
    public void e() {
        boolean bl2 = fj.z;
        if (this.f != null) {
            if (this.f.c()) {
                this.f.e();
            }
            this.f = null;
        }
        if (this.e != null) {
            this.e.setViewCursor(Cursor.getDefaultCursor());
            this.e = null;
        }
        this.d = null;
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((eF)iterator.next()).a(null, null, null);
            if (bl2) return;
            if (!bl2) continue;
        }
        super.e();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void b(dw var1_1) {
        var10_2 = fj.z;
        if (this.f != null) ** GOTO lbl33
        var2_3 = var1_1.a();
        var4_4 = var1_1.b();
        var6_5 = false;
        var7_6 = null;
        for (eF var9_8 : this.a) {
            var9_8.a(this.e, this, this.d);
            if (var9_8.a(var1_1)) {
                this.f = var9_8;
                this.f.a(this.c);
                this.f.d();
                this.f.b(var1_1);
                if (!var10_2) break;
            }
            if (!var9_8.a(var2_3, var4_4)) continue;
            var6_5 = true;
            v0 = var7_6;
            if (!var10_2) {
                if (v0 != null) continue;
                var7_6 = var9_8.c(var1_1);
                if (!var10_2) continue;
            }
            ** GOTO lbl26
        }
        if (this.f != null) return;
        if (var6_5 && this.e != null) {
            v0 = var7_6;
lbl26: // 2 sources:
            if (v0 != null) {
                this.e.setViewCursor(var7_6);
                if (var10_2 == false) return;
            }
            this.e.setViewCursor(Cursor.getDefaultCursor());
            if (var10_2 == false) return;
        }
        this.e();
        if (var10_2 == false) return;
lbl33: // 2 sources:
        this.f.b(var1_1);
    }

    private eF a(double d2, double d3) {
        eF eF2;
        if (this.a.isEmpty()) return null;
        Iterator iterator = this.a.iterator();
        do {
            if (!iterator.hasNext()) return null;
            eF2 = (eF)iterator.next();
            eF2.a(this.e, this, this.d);
        } while (!eF2.a(d2, d3));
        return eF2;
    }

    static eF a(eD eD2, eF eF2) {
        eD2.f = eF2;
        return eD2.f;
    }
}

