package y.f.h.a;

class h
{
    i a;
    h b;
    h c;
    
    h(final i a, final h b, final h c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    i a() {
        return this.a;
    }
    
    void a(final h b) {
        this.b = b;
    }
    
    void b(final h c) {
        this.c = c;
    }
    
    void b() {
        this.b.b(this.c);
        this.c.a(this.b);
    }
    
    h a(final i i) {
        final h h = new h(i, this.b, this);
        this.b.b(h);
        this.a(h);
        return h;
    }
}
