package y.f.h.a;

class o
{
    o a;
    o b;
    m c;
    
    o(final m c, final o a, final o b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    m a() {
        return this.c;
    }
    
    o a(final o o) {
        if (o == this.a) {
            return this.b;
        }
        if (o == this.b) {
            return this.a;
        }
        throw new RuntimeException("Link not known!");
    }
    
    void a(final int n, final o o) {
        if (n == 0) {
            this.a = o;
            if (!y.f.h.a.b.g) {
                return;
            }
        }
        this.b = o;
    }
    
    void a(final o o, final o o2) {
        final boolean g = y.f.h.a.b.g;
        if (o == this.a) {
            this.a = o2;
            if (!g) {
                return;
            }
        }
        if (o == this.b) {
            this.b = o2;
            if (!g) {
                return;
            }
        }
        throw new RuntimeException("Link not known!");
    }
    
    o b() {
        if (this.a != null) {
            this.a.a(this, this.b);
        }
        if (this.b != null) {
            this.b.a(this, this.a);
        }
        this.a = null;
        this.b = null;
        return this;
    }
    
    void b(final o o, final o o2) {
        final boolean g = y.f.h.a.b.g;
        if (o == this.a) {
            this.b.a(this, o2);
            o2.a(1, this.b);
            (this.b = o2).a(0, this);
            if (!g) {
                return;
            }
        }
        if (o == this.b) {
            this.a.a(this, o2);
            o2.a(0, this.a);
            (this.a = o2).a(1, this);
            if (!g) {
                return;
            }
        }
        throw new RuntimeException("Link not known!");
    }
    
    void a(final o o, final f f) {
        final boolean g = y.f.h.a.b.g;
        if (!f.a()) {
            Label_0111: {
                if (o == this.a) {
                    this.b.a(this, f.f());
                    f.c(this.b);
                    this.b = f.e();
                    f.d(this);
                    if (!g) {
                        break Label_0111;
                    }
                }
                if (o == this.b) {
                    this.a.a(this, f.f());
                    f.c(this.a);
                    this.a = f.e();
                    f.d(this);
                    if (!g) {
                        break Label_0111;
                    }
                }
                throw new RuntimeException("Link not known!");
            }
            f.b();
        }
    }
}
