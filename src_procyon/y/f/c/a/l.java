package y.f.c.a;

public class l implements Comparable
{
    private bk a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i;
    private int j;
    private boolean k;
    
    l(final int j, final bk a) {
        this.j = j;
        this.a = a;
        this.k = true;
    }
    
    public int a() {
        return this.j;
    }
    
    void a(final int j) {
        this.j = j;
    }
    
    public int compareTo(final Object o) {
        final int j = ((l)o).j;
        if (this.j < j) {
            return -1;
        }
        if (this.j == j) {
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
        return this.h;
    }
    
    public void e(final double h) {
        this.h = h;
    }
    
    public double g() {
        return this.i;
    }
    
    public void f(final double i) {
        this.i = i;
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
        return this.k;
    }
    
    public void a(final boolean k) {
        this.k = k;
    }
}
