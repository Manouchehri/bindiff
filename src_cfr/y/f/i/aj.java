/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.D;

class aJ {
    public D a = new D();
    public D b = new D();
    public D c = new D();
    public D d = new D();
    public D e = new D();
    public D f = new D();
    public D g = new D();
    public D h = new D();

    public void a(Object object) {
        this.a.add(object);
    }

    public void b(Object object) {
        this.b.add(object);
    }

    public void c(Object object) {
        this.c.add(object);
    }

    public void d(Object object) {
        this.d.add(object);
    }

    public void e(Object object) {
        this.e.add(object);
    }

    public void f(Object object) {
        this.f.add(object);
    }

    public void g(Object object) {
        this.g.add(object);
    }

    public void h(Object object) {
        this.h.add(object);
    }

    public Object a() {
        if (this.a.isEmpty()) {
            return null;
        }
        Object object = this.a.i();
        return object;
    }

    public Object b() {
        if (this.c.isEmpty()) {
            return null;
        }
        Object object = this.c.i();
        return object;
    }

    public Object c() {
        if (this.e.isEmpty()) {
            return null;
        }
        Object object = this.e.i();
        return object;
    }

    public Object d() {
        if (this.g.isEmpty()) {
            return null;
        }
        Object object = this.g.i();
        return object;
    }

    public String toString() {
        return new StringBuffer().append("[north=").append(this.a.size()).append(";northDistant=").append(this.b.size()).append(";south=").append(this.c.size()).append(";southDistant=").append(this.d.size()).append(";west=").append(this.e.size()).append(";westDistant=").append(this.f.size()).append(";east=").append(this.g.size()).append(";eastDistant=").append(this.h.size()).append("]").toString();
    }
}

