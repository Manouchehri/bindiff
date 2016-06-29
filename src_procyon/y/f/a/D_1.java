package y.f.a;

class D
{
    B a;
    B b;
    private final z c;
    
    public D(final z c, final B a, final B b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public boolean equals(final Object o) {
        if (o instanceof D) {
            final D d = (D)o;
            return (B.a(this.a) == B.a(d.a) && B.a(this.b) == B.a(d.b)) || (B.a(this.a) == B.a(d.b) && B.a(this.b) == B.a(d.a));
        }
        return false;
    }
    
    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }
}
