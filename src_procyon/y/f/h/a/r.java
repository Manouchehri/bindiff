package y.f.h.a;

abstract class r
{
    f a;
    
    r() {
        this.a = new f();
    }
    
    abstract String a();
    
    f r() {
        return this.a;
    }
    
    m c(final m m) {
        return this.a.c(m);
    }
    
    m s() {
        return this.a.g();
    }
    
    m f(final int n) {
        return (n == 0) ? this.a.g() : this.a.h();
    }
    
    int a(final m m, final int n) {
        if (!this.a.i()) {
            return n;
        }
        if (this.a.g() == m) {
            return 0;
        }
        if (this.a.h() == m) {
            return 1;
        }
        throw new RuntimeException("Edge " + m.toString() + " not adjacent to the node" + this.toString() + "!");
    }
    
    m t() {
        if (this.a.g().c()) {
            return this.a.e().b().a();
        }
        if (this.a.h().c()) {
            return this.a.f().b().a();
        }
        return null;
    }
    
    boolean u() {
        return this.a.i();
    }
    
    o d(final m m) {
        return this.a.a(m);
    }
    
    o e(final m m) {
        return this.a.b(m);
    }
    
    abstract int f();
    
    boolean g() {
        return false;
    }
    
    abstract n b();
}
