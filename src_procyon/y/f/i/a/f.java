package y.f.i.a;

import y.f.*;
import y.c.*;

public class f
{
    private R c;
    private f d;
    private P e;
    private y f;
    private boolean g;
    private double h;
    D a;
    e b;
    private boolean i;
    private boolean j;
    private v k;
    private P l;
    
    public f(final R c) {
        this.c = c;
    }
    
    public f(final f f) {
        this(f.c);
        this.d = f.d;
        this.e = f.e;
        this.f = f.f;
        this.g = f.g;
        this.h = f.h;
        this.a = f.a;
        this.b = f.b;
        this.i = f.i;
        this.j = f.j;
        this.k = f.k;
    }
    
    public String toString() {
        return "cellRect: " + this.c.e() + "\ninterval: " + ((this.e == null) ? "-" : this.e.e().toString()) + "\ncosts: " + this.h + "\n";
    }
    
    public R a() {
        return this.c;
    }
    
    public f b() {
        return this.d;
    }
    
    public void a(final f d) {
        this.d = d;
    }
    
    public P c() {
        return this.e;
    }
    
    public void a(final P e) {
        this.e = e;
    }
    
    public y d() {
        return this.f;
    }
    
    public void a(final y f) {
        this.f = f;
    }
    
    boolean e() {
        return this.g;
    }
    
    void a(final boolean g) {
        this.g = g;
    }
    
    public double f() {
        return this.h;
    }
    
    public void a(final double h) {
        this.h = h;
    }
    
    boolean g() {
        return this.i;
    }
    
    void b(final boolean i) {
        this.i = i;
    }
    
    P h() {
        return this.l;
    }
    
    void b(final P l) {
        this.l = l;
    }
    
    boolean i() {
        return this.j;
    }
    
    void c(final boolean j) {
        this.j = j;
    }
    
    public v j() {
        return this.k;
    }
    
    public void a(final v k) {
        this.k = k;
    }
}
