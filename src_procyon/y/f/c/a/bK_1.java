package y.f.c.a;

import y.g.*;
import java.util.*;

public class bK implements Comparable, g
{
    private Object a;
    private Comparator b;
    private double c;
    private double d;
    private double e;
    private double f;
    private int g;
    private double h;
    private double i;
    private boolean j;
    
    public bK(final Comparable a) {
        this.g = -1;
        this.j = true;
        if (a == null) {
            throw new NullPointerException();
        }
        this.a = a;
        this.b = null;
    }
    
    public boolean a() {
        return this.j;
    }
    
    public void a(final boolean j) {
        this.j = j;
    }
    
    public void a(final Object a) {
        if (this.d() == null && !(a instanceof Comparable)) {
            throw new IllegalArgumentException("Object must be Comparable if no comparator is set!");
        }
        this.a = a;
    }
    
    public Object b() {
        return this.a;
    }
    
    public void a(final double i) {
        if (i < 0.0 || i > 1.0) {
            throw new IllegalArgumentException();
        }
        this.i = i;
    }
    
    public double c() {
        return this.i;
    }
    
    public Comparator d() {
        return this.b;
    }
    
    public double e() {
        return this.c;
    }
    
    public void b(final double c) {
        if (c < 0.0) {
            throw new IllegalArgumentException();
        }
        this.c = c;
    }
    
    public double f() {
        return this.d;
    }
    
    public double g() {
        return this.e;
    }
    
    public void c(final double d) {
        if (d < 0.0) {
            throw new IllegalArgumentException();
        }
        this.d = d;
    }
    
    public void d(final double e) {
        if (e < 0.0) {
            throw new IllegalArgumentException();
        }
        this.e = e;
    }
    
    void e(final double h) {
        this.h = h;
    }
    
    public double h() {
        return this.h;
    }
    
    void f(final double f) {
        this.f = f;
    }
    
    public double i() {
        return this.f;
    }
    
    void a(final int g) {
        this.g = g;
    }
    
    public int j() {
        return this.g;
    }
    
    public int compareTo(final Object o) {
        final bK bk = (bK)o;
        final Comparator d = this.d();
        if (d == null) {
            return ((Comparable)this.b()).compareTo(bk.b());
        }
        return d.compare(this.b(), bk.b());
    }
}
