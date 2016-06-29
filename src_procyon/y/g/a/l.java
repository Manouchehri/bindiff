package y.g.a;

class l
{
    l a;
    l b;
    l c;
    Object d;
    byte e;
    
    public l(final Object d) {
        this.d = d;
    }
    
    void a(final l b) {
        this.b = b;
        if (b != null) {
            b.a = this;
        }
    }
    
    void b(final l c) {
        this.c = c;
        if (c != null) {
            c.a = this;
        }
    }
    
    public String toString() {
        return this.d.toString() + " / " + this.e;
    }
}
