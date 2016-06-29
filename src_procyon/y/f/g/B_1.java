package y.f.g;

import y.d.*;
import y.f.c.a.*;
import y.c.*;
import y.f.*;

class B extends E implements C
{
    D a;
    c[] b;
    final Z c;
    
    B(final aY ay, final bK bk, Z a) {
        super(ay, bk);
        if (a == null) {
            a = Z.a;
        }
        this.c = a;
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
    
    public int e() {
        return (this.a != null) ? this.a.size() : 0;
    }
    
    public c a(final int n, final am am) {
        final boolean d = y.f.g.d.d;
        if (this.b == null) {
            this.b = new c[4];
        }
        if (this.b[n] == null) {
            Label_0145: {
                switch (n) {
                    case 0: {
                        this.b[n] = new c(0.0, am.getWidth(), 0.0);
                        if (d) {
                            break Label_0145;
                        }
                        break;
                    }
                    case 1: {
                        this.b[n] = new c(0.0, am.getHeight(), am.getWidth());
                        if (d) {
                            break Label_0145;
                        }
                        break;
                    }
                    case 2: {
                        this.b[n] = new c(0.0, am.getWidth(), am.getHeight());
                        if (d) {
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
