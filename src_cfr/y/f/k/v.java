/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import java.util.ArrayList;
import java.util.List;
import y.f.k.P;
import y.f.k.Y;

abstract class V {
    protected List a = new ArrayList();
    protected P b;

    protected V(P p2) {
        this.b = p2;
    }

    void a(Y y2) {
        if (!y2.a()) {
            throw new IllegalArgumentException(new StringBuffer().append("RoutingBound is not complete ").append(y2).toString());
        }
        this.a.add(y2);
    }

    Y a(int n2) {
        return (Y)this.a.get(n2);
    }

    private Y e(int n2, boolean bl2) {
        Y y2 = this.a(n2);
        if (!bl2) return y2;
        return y2.a(20.0);
    }

    void b(int n2) {
        this.b(this.e(n2, false));
    }

    void a(int n2, boolean bl2) {
        this.b(this.e(n2, bl2));
    }

    void b(Y y2) {
        this.b(y2.c());
    }

    void c(int n2) {
        this.c(this.e(n2, false));
    }

    void b(int n2, boolean bl2) {
        this.c(this.e(n2, bl2));
    }

    void c(Y y2) {
        this.b(y2.d());
    }

    void d(int n2) {
        this.d(this.e(n2, false));
    }

    void c(int n2, boolean bl2) {
        this.d(this.e(n2, bl2));
    }

    void d(Y y2) {
        this.a(y2.g());
    }

    void e(int n2) {
        this.e(this.e(n2, false));
    }

    void d(int n2, boolean bl2) {
        this.e(this.e(n2, bl2));
    }

    void e(Y y2) {
        this.a(y2.f());
    }

    private void a(double d2) {
        this.b.a(this.a(), d2);
    }

    private void b(double d2) {
        this.b.a(d2, this.b());
    }

    protected double a() {
        return this.b.b();
    }

    protected double b() {
        return this.b.c();
    }
}

