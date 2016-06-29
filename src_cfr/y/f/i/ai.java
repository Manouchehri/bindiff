/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.Comparator;
import y.c.f;
import y.f.X;
import y.f.i.aG;
import y.f.i.v;

class aI {
    X a;
    v b;
    private f c;

    public aI(X x2, f f2, v v2) {
        this.a = x2;
        this.b = v2;
        this.c = f2;
    }

    public f a() {
        aG aG2 = new aG(this.a, this.b);
        f f2 = new f(this.c);
        f2.sort(aG2);
        return f2;
    }
}

