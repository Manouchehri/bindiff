/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.d;
import y.c.q;
import y.g.z;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.eR;
import y.h.eU;
import y.h.fL;
import y.h.fj;
import y.h.x;

public class gY
implements z {
    final bu a;
    int b;
    int c;
    int d;
    int e;

    public gY(bu bu2, int n2, int n3, int n4, int n5) {
        this.a = bu2;
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = n5;
    }

    @Override
    public boolean a(Object object) {
        if (object instanceof d) {
            if (this.a.i((d)object).isVisible()) {
                if ((this.d & 1) == 0) return false;
                return true;
            }
            if ((this.d & 2) == 0) return false;
            return true;
        }
        if (object instanceof q) {
            if (this.a.t((q)object).isVisible()) {
                if ((this.b & 1) == 0) return false;
                return true;
            }
            if ((this.b & 2) == 0) return false;
            return true;
        }
        if (object instanceof aA) {
            aA aA2 = (aA)object;
            if (aA2.isVisible() && (aA2.getOwner() == null || aA2.getOwner().hasVisiblePath())) {
                if ((this.e & 1) == 0) return false;
                return true;
            }
            if ((this.e & 2) == 0) return false;
            return true;
        }
        if (object instanceof x) {
            if (this.a.i(((x)object).a()).isVisible()) {
                if ((this.d & 1) == 0) return false;
                return true;
            }
            if ((this.d & 2) == 0) return false;
            return true;
        }
        if (object instanceof fL) {
            if (((fL)object).d().isVisible()) {
                if ((this.d & 1) == 0) return false;
                return true;
            }
            if ((this.d & 2) == 0) return false;
            return true;
        }
        if (object instanceof eR) {
            if (((eR)object).isVisible()) {
                if ((this.c & 1) == 0) return false;
                return true;
            }
            if ((this.c & 2) == 0) return false;
            return true;
        }
        if (!(object instanceof eU)) return false;
        if (((eU)object).b().isVisible()) {
            if ((this.b & 1) == 0) return false;
            return true;
        }
        if ((this.b & 2) == 0) return false;
        return true;
    }
}

