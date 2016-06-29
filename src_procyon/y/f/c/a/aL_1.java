package y.f.c.a;

import y.c.*;
import y.f.*;
import java.util.*;

class aL implements ai
{
    final d a;
    final A b;
    
    aL(final d a, final A b) {
        this.a = a;
        this.b = b;
    }
    
    public B k() {
        return this.b.k();
    }
    
    public d b() {
        return this.a;
    }
    
    public aE c() {
        return null;
    }
    
    public Collection d() {
        return null;
    }
    
    public Object g() {
        return null;
    }
    
    public aE e() {
        return null;
    }
    
    public Collection f() {
        return null;
    }
    
    public Object h() {
        return null;
    }
    
    public byte a() {
        return 0;
    }
    
    public boolean i() {
        return this.b.i();
    }
    
    public boolean j() {
        return this.l();
    }
    
    public void b(final boolean b) {
        throw new UnsupportedOperationException();
    }
    
    public A a(final boolean b, final aE ae) {
        ak ak = null;
        Label_0102: {
            if (this.i()) {
                ak = new ak(this.b(), this.k(), b ? null : ae, this.f(), b ? ae : null, this.d());
                ak.b(true);
                if (!N.x) {
                    break Label_0102;
                }
            }
            ak = new ak(this.b(), this.k(), b ? ae : null, this.d(), b ? null : ae, this.f());
        }
        ak.a(this.l());
        return ak;
    }
    
    public void a(final boolean b) {
        this.b.a(b);
    }
    
    public boolean l() {
        return this.b.l();
    }
}
