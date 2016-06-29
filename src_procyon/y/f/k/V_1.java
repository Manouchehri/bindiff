package y.f.k;

import java.util.*;

abstract class V
{
    protected List a;
    protected P b;
    
    protected V(final P b) {
        this.a = new ArrayList();
        this.b = b;
    }
    
    void a(final Y y) {
        if (!y.a()) {
            throw new IllegalArgumentException("RoutingBound is not complete " + y);
        }
        this.a.add(y);
    }
    
    Y a(final int n) {
        return this.a.get(n);
    }
    
    private Y e(final int n, final boolean b) {
        Y y = this.a(n);
        if (b) {
            y = y.a(20.0);
        }
        return y;
    }
    
    void b(final int n) {
        this.b(this.e(n, false));
    }
    
    void a(final int n, final boolean b) {
        this.b(this.e(n, b));
    }
    
    void b(final Y y) {
        this.b(y.c());
    }
    
    void c(final int n) {
        this.c(this.e(n, false));
    }
    
    void b(final int n, final boolean b) {
        this.c(this.e(n, b));
    }
    
    void c(final Y y) {
        this.b(y.d());
    }
    
    void d(final int n) {
        this.d(this.e(n, false));
    }
    
    void c(final int n, final boolean b) {
        this.d(this.e(n, b));
    }
    
    void d(final Y y) {
        this.a(y.g());
    }
    
    void e(final int n) {
        this.e(this.e(n, false));
    }
    
    void d(final int n, final boolean b) {
        this.e(this.e(n, b));
    }
    
    void e(final Y y) {
        this.a(y.f());
    }
    
    private void a(final double n) {
        this.b.a(this.a(), n);
    }
    
    private void b(final double n) {
        this.b.a(n, this.b());
    }
    
    protected double a() {
        return this.b.b();
    }
    
    protected double b() {
        return this.b.c();
    }
}
