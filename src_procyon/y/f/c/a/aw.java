package y.f.c.a;

import y.c.*;
import y.f.*;
import java.util.*;

class aw extends aL
{
    aw(final d d, final A a) {
        super(d, a);
    }
    
    public aE c() {
        return this.b.e();
    }
    
    public Collection d() {
        return this.b.f();
    }
    
    public Object g() {
        return this.b.h();
    }
    
    public boolean j() {
        final aE e = this.b.e();
        if (e != null) {
            if (e.c()) {
                return true;
            }
            if (e.d()) {
                return false;
            }
        }
        return this.l();
    }
    
    public boolean i() {
        return !this.b.i();
    }
}
