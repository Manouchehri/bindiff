package y.f.i;

import y.f.*;
import y.g.*;
import y.c.*;

class ar
{
    private X a;
    private v b;
    private byte c;
    private c d;
    private h e;
    
    public ar(final X a, final v b) {
        this.a = a;
        this.b = b;
    }
    
    h a() {
        return this.e;
    }
    
    public void b() {
        if (this.b.p() == 2) {
            final Object c = this.b.c();
            if (this.a.c(c) == null) {
                throw new IllegalStateException("No DataProvider " + c + " registered with graph!");
            }
        }
        else if (this.b.p() == 4) {
            final Object b = this.b.b();
            if (this.a.c(b) == null) {
                throw new IllegalStateException("No DataProvider " + b + " registered with graph!");
            }
        }
    }
    
    public void c() {
        final int f = v.f;
        this.d();
        final Object c = this.b.c();
        final c c2 = this.a.c(c);
        if (c2 != null) {
            this.e = M.b();
            final e p = this.a.p();
            while (p.f()) {
                this.e.a(p.a(), c2.d(p.a()));
                p.g();
                if (f != 0) {
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            this.a.a(c, this.e);
        }
    }
    
    public void d() {
        this.c = this.b.p();
        this.b.b((byte)2);
        final Object c = this.b.c();
        this.d = this.a.c(c);
        final c c2 = this.a.c(this.b.b());
        c c3 = null;
        if (this.c == 0) {
            c3 = new as(this);
        }
        else if (this.c == 4) {
            c3 = new at(this, c2);
        }
        if (c3 != null) {
            this.b.b((byte)2);
            this.a.a(c, c3);
        }
    }
    
    public void e() {
        if (this.c != 2) {
            final Object c = this.b.c();
            Label_0049: {
                if (this.d != null) {
                    this.a.a(c, this.d);
                    if (v.f == 0) {
                        break Label_0049;
                    }
                }
                this.a.d_(c);
            }
            this.b.b(this.c);
        }
        if (this.e != null) {
            this.e = null;
        }
    }
}
