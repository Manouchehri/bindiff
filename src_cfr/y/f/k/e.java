/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import java.util.ArrayList;
import java.util.List;
import y.f.X;
import y.f.k.B;
import y.f.k.F;

class E {
    private List a;
    private X b;
    private double c;
    private final B d;

    E(B b2, X x2) {
        this.d = b2;
        this.a = new ArrayList();
        this.b = x2;
    }

    F a(int n2) {
        if (this.a.size() != n2) {
            throw new IllegalStateException(new StringBuffer().append("Cannot try to create layer with index ").append(n2).append(". First create layer ").append(this.a.size()).toString());
        }
        F f2 = new F(n2, this);
        f2.a(B.a(this.d));
        f2.b(B.b(this.d));
        this.a.add(f2);
        return f2;
    }

    F b(int n2) {
        if (this.a.size() <= n2) return null;
        return (F)this.a.get(n2);
    }

    private F c(int n2) {
        if (this.a.size() > n2) return (F)this.a.get(n2);
        return this.a(n2);
    }

    X a() {
        return this.b;
    }

    void a(double d2) {
        this.c = d2;
    }

    static F a(E e2, int n2) {
        return e2.c(n2);
    }
}

