package y.f.c.a;

import y.f.*;
import java.util.*;
import y.c.*;

class ak extends ao
{
    aE a;
    aE b;
    Collection c;
    Collection d;
    Object e;
    Object f;
    d g;
    
    ak(final d d, final B b, final aE ae, final Collection collection, final aE ae2, final Collection collection2) {
        this(d, b, ae, collection, ae2, collection2, null, null);
    }
    
    ak(final d g, final B b, final aE a, final Collection c, final aE b2, final Collection d, final Object e, final Object f) {
        super(b);
        this.g = g;
        this.d = d;
        this.c = c;
        this.a = a;
        this.b = b2;
        this.e = e;
        this.f = f;
    }
    
    public Object g() {
        return this.i ? this.f : this.e;
    }
    
    public Object h() {
        return this.i ? this.e : this.f;
    }
    
    public d b() {
        return this.g;
    }
    
    public aE c() {
        return this.i ? this.b : this.a;
    }
    
    public Collection d() {
        return this.i ? this.d : this.c;
    }
    
    public aE e() {
        return this.i ? this.a : this.b;
    }
    
    public Collection f() {
        return this.i ? this.c : this.d;
    }
    
    public boolean j() {
        final aE c = this.c();
        final aE e = this.e();
        if (c != null) {
            if (c.c()) {
                return true;
            }
            if (c.d()) {
                return false;
            }
        }
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
    
    public A a(final boolean b, final aE ae) {
        final boolean x = N.x;
        if (b) {
            if (this.i) {
                this.b = ae;
                if (!x) {
                    return this;
                }
            }
            this.a = ae;
            if (!x) {
                return this;
            }
        }
        if (this.i) {
            this.a = ae;
            if (!x) {
                return this;
            }
        }
        this.b = ae;
        return this;
    }
}
