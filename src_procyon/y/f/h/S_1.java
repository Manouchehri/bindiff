package y.f.h;

import y.c.*;

class S implements m
{
    private e a;
    private boolean b;
    
    public S(final e a) {
        (this.a = a).i();
        this.b = this.a.f();
    }
    
    public void a(final d[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Parameter == null");
        }
        if (array.length < 2) {
            throw new IllegalArgumentException("Parameter Array Size < 2");
        }
        if (!this.b) {
            throw new RuntimeException("Cursor is not valid");
        }
        array[0] = this.a.a();
        this.a.b();
        array[1] = this.a.a();
        this.a.c();
    }
    
    public boolean f() {
        return this.b;
    }
    
    public void g() {
        this.a.g();
        this.b = this.a.f();
    }
    
    public void h() {
        this.a.h();
        this.b = this.a.f();
    }
    
    public void i() {
        this.a.i();
    }
    
    public void j() {
        this.a.j();
    }
    
    public Object d() {
        final d[] array = new d[2];
        this.a(array);
        return array;
    }
    
    public int k() {
        return this.a.k();
    }
}
