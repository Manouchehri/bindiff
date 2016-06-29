/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.g.g;

public class bK
implements Comparable,
g {
    private Object a;
    private Comparator b;
    private double c;
    private double d;
    private double e;
    private double f;
    private int g = -1;
    private double h;
    private double i;
    private boolean j = true;

    public bK(Comparable comparable) {
        if (comparable == null) {
            throw new NullPointerException();
        }
        this.a = comparable;
        this.b = null;
    }

    public boolean a() {
        return this.j;
    }

    public void a(boolean bl2) {
        this.j = bl2;
    }

    public void a(Object object) {
        if (this.d() == null && !(object instanceof Comparable)) {
            throw new IllegalArgumentException("Object must be Comparable if no comparator is set!");
        }
        this.a = object;
    }

    public Object b() {
        return this.a;
    }

    public void a(double d2) {
        if (d2 < 0.0) throw new IllegalArgumentException();
        if (d2 > 1.0) {
            throw new IllegalArgumentException();
        }
        this.i = d2;
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

    public void b(double d2) {
        if (d2 < 0.0) {
            throw new IllegalArgumentException();
        }
        this.c = d2;
    }

    public double f() {
        return this.d;
    }

    public double g() {
        return this.e;
    }

    public void c(double d2) {
        if (d2 < 0.0) {
            throw new IllegalArgumentException();
        }
        this.d = d2;
    }

    public void d(double d2) {
        if (d2 < 0.0) {
            throw new IllegalArgumentException();
        }
        this.e = d2;
    }

    void e(double d2) {
        this.h = d2;
    }

    public double h() {
        return this.h;
    }

    void f(double d2) {
        this.f = d2;
    }

    public double i() {
        return this.f;
    }

    void a(int n2) {
        this.g = n2;
    }

    public int j() {
        return this.g;
    }

    public int compareTo(Object object) {
        bK bK2 = (bK)object;
        Comparator comparator = this.d();
        if (comparator != null) return comparator.compare(this.b(), bK2.b());
        return ((Comparable)this.b()).compareTo(bK2.b());
    }
}

