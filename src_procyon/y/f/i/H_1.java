package y.f.i;

import y.d.*;

class H
{
    private t a;
    private t b;
    
    H(final t a, final t b) {
        this.a = a;
        this.b = b;
    }
    
    private boolean e() {
        return this.a.a() == this.b.a();
    }
    
    boolean a() {
        return this.e() && this.a.b() > this.b.b();
    }
    
    boolean b() {
        return this.e() && this.a.b() < this.b.b();
    }
    
    boolean c() {
        return !this.e() && this.a.a() > this.b.a();
    }
    
    int d() {
        if (this.a()) {
            return 0;
        }
        if (this.b()) {
            return 1;
        }
        if (this.c()) {
            return 2;
        }
        return 3;
    }
    
    static boolean a(final H h) {
        return h.e();
    }
}
