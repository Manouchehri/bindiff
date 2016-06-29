/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.S;
import y.a.T;
import y.c.c;
import y.c.d;

class X
extends S {
    private X() {
    }

    @Override
    double a(d[] arrd, c c2, int n2) {
        if (arrd.length == 0) {
            return 0.0;
        }
        double d2 = X.b().a(arrd, c2, n2);
        return d2 / (double)arrd.length;
    }

    X(T t2) {
        this();
    }
}

