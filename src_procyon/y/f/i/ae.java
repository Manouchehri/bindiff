package y.f.i;

import java.util.*;
import y.c.*;
import y.d.*;

class ae
{
    private boolean b;
    private boolean c;
    private Collection d;
    private Collection e;
    private boolean f;
    private boolean g;
    private D h;
    private D i;
    private q j;
    private D k;
    private boolean l;
    private d m;
    private boolean n;
    private boolean o;
    int a;
    
    public ae(final d m) {
        this.n = false;
        this.o = false;
        this.m = m;
    }
    
    public d a() {
        return this.m;
    }
    
    public boolean a(final boolean b) {
        if (b) {
            return this.n;
        }
        return this.o;
    }
    
    public void a(final boolean b, final boolean b2) {
        if (b2) {
            this.n = b;
            if (v.f == 0) {
                return;
            }
        }
        this.o = b;
    }
    
    public boolean b(final boolean b) {
        return b ? this.b : this.c;
    }
    
    public Collection c(final boolean b) {
        return b ? this.d : this.e;
    }
    
    public boolean d(final boolean b) {
        return b ? this.f : this.g;
    }
    
    public D e(final boolean b) {
        return b ? this.h : this.i;
    }
    
    public C b() {
        if (this.k != null) {
            return this.k.m();
        }
        return null;
    }
    
    public boolean c() {
        return this.l;
    }
    
    public void a(final boolean b, final Collection collection) {
        if (b) {
            this.d = collection;
            if (v.f == 0) {
                return;
            }
        }
        this.e = collection;
    }
    
    public void b(final boolean b, final boolean b2) {
        if (b) {
            this.b = b2;
            if (v.f == 0) {
                return;
            }
        }
        this.c = b2;
    }
    
    public void c(final boolean b, final boolean b2) {
        if (b) {
            this.f = b2;
            if (v.f == 0) {
                return;
            }
        }
        this.g = b2;
    }
    
    public void a(final boolean b, final D d) {
        if (b) {
            this.h = d;
            if (v.f == 0) {
                return;
            }
        }
        this.i = d;
    }
    
    public void a(final q j) {
        this.j = j;
    }
    
    public void f(final boolean l) {
        this.l = l;
    }
    
    public void a(final m m) {
        if (this.k == null) {
            this.k = new D();
        }
        this.k.add(m);
    }
    
    public void a(final boolean b, final m m) {
        if (this.k == null) {
            return;
        }
        (b ? this.k.k() : this.k.l()).a(m);
    }
    
    public void a(final D k) {
        this.k = k;
    }
}
