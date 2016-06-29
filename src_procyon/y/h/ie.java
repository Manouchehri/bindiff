package y.h;

import y.c.*;

class ie implements y
{
    e a;
    y b;
    x c;
    bu d;
    
    ie(final bu d) {
        this.d = d;
        this.a = d.p();
        this.i();
    }
    
    public Object d() {
        return this.c;
    }
    
    public x a() {
        return this.c;
    }
    
    public void i() {
        final boolean z = fj.z;
        this.a.i();
        while (this.a.f()) {
            final aB i = this.d.i(this.a.a());
            if (i.bendCount() > 0) {
                this.b = i.bends();
                this.c = this.b.a();
                return;
            }
            this.c = null;
            this.a.g();
            if (z) {
                break;
            }
        }
    }
    
    public void j() {
        final boolean z = fj.z;
        this.a.j();
        while (this.a.f()) {
            final aB i = this.d.i(this.a.a());
            if (i.bendCount() > 0) {
                (this.b = i.bends()).j();
                this.c = this.b.a();
                return;
            }
            this.c = null;
            this.a.h();
            if (z) {
                break;
            }
        }
    }
    
    public void g() {
        final boolean z = fj.z;
        this.b.g();
        if (this.b.f()) {
            this.c = this.b.a();
            if (!z) {
                return;
            }
        }
        this.a.g();
        while (this.a.f()) {
            final aB i = this.d.i(this.a.a());
            if (z) {
                return;
            }
            if (i.bendCount() > 0) {
                this.b = i.bends();
                this.c = this.b.a();
                return;
            }
            this.a.g();
            if (z) {
                break;
            }
        }
        this.c = null;
    }
    
    public void h() {
        final boolean z = fj.z;
        this.b.h();
        if (this.b.f()) {
            this.c = this.b.a();
            if (!z) {
                return;
            }
        }
        this.a.h();
        while (this.a.f()) {
            final aB i = this.d.i(this.a.a());
            if (z) {
                return;
            }
            if (i.bendCount() > 0) {
                (this.b = i.bends()).j();
                this.c = this.b.a();
                return;
            }
            this.a.h();
            if (z) {
                break;
            }
        }
        this.c = null;
    }
    
    public boolean f() {
        return this.c != null;
    }
    
    public int k() {
        throw new UnsupportedOperationException();
    }
}
