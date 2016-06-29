package y.f.i.a;

import java.util.*;
import y.d.*;

public class R
{
    private static int a;
    private final int b;
    private final Q c;
    private final HashMap d;
    private final y e;
    private bc f;
    private HashMap g;
    
    public R(final y e, final Q c) {
        this.e = e;
        this.b = R.a++;
        this.c = c;
        this.d = new HashMap();
    }
    
    public R(final double n, final double n2, final double n3, final double n4, final Q q) {
        this(new y(n, n2, n3, n4), q);
    }
    
    public Object a(final Object o, final Object o2) {
        return this.d.put(o, o2);
    }
    
    public Object a(final Object o) {
        return this.d.get(o);
    }
    
    public void a() {
        this.d.clear();
    }
    
    bc b() {
        return this.f;
    }
    
    void a(final bc f) {
        this.f = f;
    }
    
    HashMap c() {
        return this.g;
    }
    
    void a(final HashMap g) {
        this.g = g;
    }
    
    public Q d() {
        return this.c;
    }
    
    public int e() {
        return this.b;
    }
    
    static void f() {
        R.a = 0;
    }
    
    public y g() {
        return this.e;
    }
    
    public double h() {
        return this.e.c();
    }
    
    public double i() {
        return this.e.d();
    }
    
    public double j() {
        return this.e.c() + this.e.a();
    }
    
    public double k() {
        return this.e.d() + this.e.b();
    }
    
    public double l() {
        return this.e.a();
    }
    
    public double m() {
        return this.e.b();
    }
    
    public P a(final S s) {
        if (s == S.a) {
            return new P(this.h(), this.j(), this.i(), false);
        }
        if (s == S.b) {
            return new P(this.h(), this.j(), this.k(), false);
        }
        if (s == S.d) {
            return new P(this.i(), this.k(), this.h(), true);
        }
        if (s == S.c) {
            return new P(this.i(), this.k(), this.j(), true);
        }
        return null;
    }
    
    static {
        R.a = 0;
    }
}
