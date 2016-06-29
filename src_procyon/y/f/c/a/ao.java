package y.f.c.a;

import y.c.*;
import y.f.*;
import java.util.*;

class ao implements ai
{
    boolean h;
    boolean i;
    final B j;
    
    public void a(final boolean h) {
        this.h = h;
    }
    
    public boolean l() {
        return this.h;
    }
    
    ao(final B j) {
        this.j = j;
    }
    
    public B k() {
        return this.j;
    }
    
    public d b() {
        return null;
    }
    
    public Object g() {
        return null;
    }
    
    public Object h() {
        return null;
    }
    
    public byte a() {
        return 0;
    }
    
    public boolean i() {
        return this.i;
    }
    
    public void b(final boolean i) {
        this.i = i;
    }
    
    public aE c() {
        return null;
    }
    
    public Collection d() {
        return null;
    }
    
    public aE e() {
        return null;
    }
    
    public Collection f() {
        return null;
    }
    
    public boolean j() {
        return this.l();
    }
    
    public A a(final boolean b, final aE ae) {
        if (this.i()) {
            final ak ak = new ak(this.b(), this.k(), b ? null : ae, this.f(), b ? ae : null, this.d());
            ak.b(true);
            if (!N.x) {
                return ak;
            }
        }
        return new ak(this.b(), this.k(), b ? ae : null, this.d(), b ? null : ae, this.f());
    }
}
