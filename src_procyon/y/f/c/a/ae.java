package y.f.c.a;

import y.d.*;
import y.c.*;
import y.f.*;

class ae extends aM implements as
{
    D a;
    c[] b;
    final Z c;
    
    ae(final aY ay, final bK bk, final Z z) {
        super(ay, bk);
        this.c = ((z == null) ? Z.a : z);
    }
    
    public Z c() {
        return this.c;
    }
    
    public byte b() {
        return 0;
    }
    
    public p d() {
        return (this.a != null) ? this.a.k() : null;
    }
    
    public p a(final d d) {
        if (this.a == null) {
            this.a = new D();
        }
        return this.a.b(d);
    }
    
    public void a(final p p) {
        this.a.h(p);
    }
    
    public int e() {
        return (this.a != null) ? this.a.size() : 0;
    }
    
    public c a(final int n, final am am) {
        final boolean x = N.x;
        if (this.b == null) {
            this.b = new c[4];
        }
        if (this.b[n] == null) {
            Label_0145: {
                switch (n) {
                    case 0: {
                        this.b[n] = new c(0.0, am.getWidth(), 0.0);
                        if (x) {
                            break Label_0145;
                        }
                        break;
                    }
                    case 1: {
                        this.b[n] = new c(0.0, am.getHeight(), am.getWidth());
                        if (x) {
                            break Label_0145;
                        }
                        break;
                    }
                    case 2: {
                        this.b[n] = new c(0.0, am.getWidth(), am.getHeight());
                        if (x) {
                            break Label_0145;
                        }
                        break;
                    }
                    case 3: {
                        this.b[n] = new c(0.0, am.getHeight(), 0.0);
                        break;
                    }
                }
            }
        }
        return this.b[n];
    }
    
    public c a(final int n) {
        if (this.b == null) {
            return null;
        }
        return this.b[n];
    }
}
