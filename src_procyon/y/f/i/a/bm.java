package y.f.i.a;

import y.f.*;
import y.c.*;

class bm
{
    private X a;
    private y b;
    private byte c;
    private c d;
    private h e;
    
    public bm(final X a, final y b) {
        this.a = a;
        this.b = b;
    }
    
    public void a() {
        if (this.b.f() == 2) {
            final Object h = this.b.h();
            if (this.a.c(h) == null) {
                throw new IllegalStateException("No DataProvider " + h + " registered with graph!");
            }
        }
        else if (this.b.f() == 4) {
            final Object g = this.b.g();
            if (this.a.c(g) == null) {
                throw new IllegalStateException("No DataProvider " + g + " registered with graph!");
            }
        }
    }
    
    public void b() {
        this.c = this.b.f();
        this.b.a((byte)2);
        final Object h = this.b.h();
        this.d = this.a.c(h);
        final c c = this.a.c(this.b.g());
        c c2 = null;
        if (this.c == 0) {
            c2 = new bn(this);
        }
        else if (this.c == 4) {
            c2 = new bo(this, c);
        }
        if (c2 != null) {
            this.b.a((byte)2);
            this.a.a(h, c2);
        }
    }
    
    public void c() {
        if (this.c != 2) {
            final Object h = this.b.h();
            Label_0049: {
                if (this.d != null) {
                    this.a.a(h, this.d);
                    if (ab.a == 0) {
                        break Label_0049;
                    }
                }
                this.a.d_(h);
            }
            this.b.a(this.c);
        }
        if (this.e != null) {
            this.e = null;
        }
    }
}
