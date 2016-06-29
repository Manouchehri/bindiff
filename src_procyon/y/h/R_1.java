package y.h;

import java.util.*;

final class R implements cg
{
    boolean a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    private cg f;
    private final O g;
    
    R(final O g) {
        this.g = g;
        this.c = true;
        final U f = new U();
        f.a(this.a);
        f.b(this.c);
        f.c(this.d);
        this.f = f;
    }
    
    public Iterator a(final bu bu, final int n) {
        return (this.e() ? new hP(this.f, this.c()) : this.f).a(bu, n);
    }
    
    public Iterator b(final bu bu, final int n) {
        return (this.e() ? new hP(this.f, this.c()) : this.f).b(bu, n);
    }
    
    boolean a() {
        return this.b;
    }
    
    void a(final boolean b) {
        if (this.b != b) {
            this.b = b;
            if (this.b) {
                final Q f = new Q(this.g, null);
                f.a = this.a;
                this.f = f;
                if (!fj.z) {
                    return;
                }
            }
            final U f2 = new U();
            f2.a(this.a);
            f2.b(this.c);
            f2.c(this.d);
            this.f = f2;
        }
    }
    
    boolean b() {
        return this.c;
    }
    
    void b(final boolean c) {
        this.c = c;
        if (!this.b) {
            ((U)this.f).b(c);
        }
    }
    
    boolean c() {
        return this.d;
    }
    
    void c(final boolean d) {
        this.d = d;
        if (!this.b) {
            ((U)this.f).c(d);
        }
    }
    
    boolean d() {
        return this.a;
    }
    
    void d(final boolean b) {
        this.a = b;
        if (!this.b) {
            ((U)this.f).a(b);
            if (!fj.z) {
                return;
            }
        }
        ((Q)this.f).a = b;
    }
    
    public boolean e() {
        return this.e;
    }
    
    public void e(final boolean e) {
        this.e = e;
    }
}
