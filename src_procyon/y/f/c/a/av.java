package y.f.c.a;

import y.c.*;
import y.f.*;
import java.util.*;

class av extends aL
{
    av(final d d, final A a) {
        super(d, a);
    }
    
    public aE c() {
        return this.b.c();
    }
    
    public Collection d() {
        return this.b.d();
    }
    
    public Object g() {
        return this.b.g();
    }
    
    public boolean j() {
        final aE c = this.b.c();
        if (c != null) {
            if (c.c()) {
                return true;
            }
            if (c.d()) {
                return false;
            }
        }
        return this.l();
    }
}
