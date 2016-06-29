package y.f.i;

import y.c.*;

class aJ
{
    public D a;
    public D b;
    public D c;
    public D d;
    public D e;
    public D f;
    public D g;
    public D h;
    
    public aJ() {
        this.a = new D();
        this.b = new D();
        this.c = new D();
        this.d = new D();
        this.e = new D();
        this.f = new D();
        this.g = new D();
        this.h = new D();
    }
    
    public void a(final Object o) {
        this.a.add(o);
    }
    
    public void b(final Object o) {
        this.b.add(o);
    }
    
    public void c(final Object o) {
        this.c.add(o);
    }
    
    public void d(final Object o) {
        this.d.add(o);
    }
    
    public void e(final Object o) {
        this.e.add(o);
    }
    
    public void f(final Object o) {
        this.f.add(o);
    }
    
    public void g(final Object o) {
        this.g.add(o);
    }
    
    public void h(final Object o) {
        this.h.add(o);
    }
    
    public Object a() {
        return this.a.isEmpty() ? null : this.a.i();
    }
    
    public Object b() {
        return this.c.isEmpty() ? null : this.c.i();
    }
    
    public Object c() {
        return this.e.isEmpty() ? null : this.e.i();
    }
    
    public Object d() {
        return this.g.isEmpty() ? null : this.g.i();
    }
    
    public String toString() {
        return "[north=" + this.a.size() + ";northDistant=" + this.b.size() + ";south=" + this.c.size() + ";southDistant=" + this.d.size() + ";west=" + this.e.size() + ";westDistant=" + this.f.size() + ";east=" + this.g.size() + ";eastDistant=" + this.h.size() + "]";
    }
}
