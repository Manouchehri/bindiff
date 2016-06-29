/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.S;
import y.a.T;
import y.a.V;
import y.a.W;
import y.a.X;
import y.c.c;
import y.c.d;

class Y
extends S {
    private final double a;
    private final double b;
    private final double c;
    private final X d;
    private final V e;
    private final W f;

    Y(double d2, double d3, double d4) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = new X(null);
        this.e = new V(null);
        this.f = new W(null);
    }

    @Override
    double a(d[] arrd, c c2, int n2) {
        return this.a * this.d.a(arrd, c2, n2) + this.b * this.e.a(arrd, c2, n2) + this.c * this.f.a(arrd, c2, n2);
    }
}

