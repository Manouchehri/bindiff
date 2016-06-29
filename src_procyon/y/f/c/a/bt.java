package y.f.c.a;

public class bt implements Comparable
{
    private bk a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private int h;
    private boolean i;
    private double j;
    private double k;
    
    bt(final int h, final bk a) {
        this.i = true;
        this.h = h;
        this.a = a;
    }
    
    public int a() {
        return this.h;
    }
    
    void a(final int h) {
        this.h = h;
    }
    
    public int compareTo(final Object o) {
        final int h = ((bt)o).h;
        if (this.h < h) {
            return -1;
        }
        if (this.h == h) {
            return 0;
        }
        return 1;
    }
    
    public double b() {
        return this.b;
    }
    
    public void a(final double b) {
        if (b < 0.0) {
            throw new IllegalArgumentException();
        }
        this.b = b;
    }
    
    public double c() {
        return this.c;
    }
    
    public void b(final double c) {
        if (c < 0.0) {
            throw new IllegalArgumentException();
        }
        this.c = c;
    }
    
    public double d() {
        return this.d;
    }
    
    public void c(final double d) {
        if (d < 0.0) {
            throw new IllegalArgumentException();
        }
        this.d = d;
    }
    
    public double e() {
        return this.e;
    }
    
    public void d(final double e) {
        this.e = e;
    }
    
    public double f() {
        return this.k;
    }
    
    public void e(final double k) {
        this.k = k;
    }
    
    public double g() {
        return this.j;
    }
    
    public void f(final double j) {
        this.j = j;
    }
    
    public double h() {
        return this.f;
    }
    
    public void g(final double f) {
        this.f = f;
    }
    
    public double i() {
        return this.g;
    }
    
    public void h(final double g) {
        if (g < 0.0 || g > 1.0) {
            throw new IllegalArgumentException();
        }
        this.g = g;
    }
    
    public boolean j() {
        return this.i;
    }
    
    public void a(final boolean i) {
        this.i = i;
    }
}
