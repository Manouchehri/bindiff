package y.f.i;

import y.f.*;
import y.d.*;
import y.c.*;

class Q extends R
{
    private m a;
    private d b;
    private boolean c;
    private int d;
    private final boolean e;
    private final boolean f;
    
    public Q(final byte b, final m a, final d b2, final boolean c, final int d, final boolean e, final boolean f) {
        super(b, a.c().a());
        this.a = a;
        this.b = b2;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public m a() {
        return this.a;
    }
    
    private boolean l() {
        return this.g() > 0;
    }
    
    public boolean b() {
        final D m = ((X)this.e().a()).m(this.b);
        if (this.l()) {
            return ((t)m.b(this.g() - 1).c()).a() <= ((t)m.b(this.g()).c()).a();
        }
        return !this.m() || this.c();
    }
    
    private boolean m() {
        return this.g() < ((X)this.e().a()).m(this.b).size() - 2;
    }
    
    public boolean c() {
        final D m = ((X)this.e().a()).m(this.b);
        if (this.m()) {
            return ((t)m.b(this.g() + 1).c()).a() > ((t)m.b(this.g() + 2).c()).a();
        }
        return !this.l() || this.b();
    }
    
    public boolean d() {
        return !this.l() || !this.m() || (this.l() && this.m() && this.b() != this.c());
    }
    
    public d e() {
        return this.b;
    }
    
    public boolean f() {
        return this.c;
    }
    
    public int g() {
        return this.d;
    }
    
    public String toString() {
        return "Edge: " + this.b.c() + " -> " + this.b.d() + ", " + (this.f() ? "locked" : "unlocked") + " segment " + this.g() + ", " + this.a.toString();
    }
    
    public boolean h() {
        return this.e;
    }
    
    public boolean i() {
        return this.f;
    }
    
    static d a(final Q q) {
        return q.b;
    }
}
