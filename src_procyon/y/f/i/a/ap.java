package y.f.i.a;

final class ap
{
    final ai a;
    final ai b;
    private final aj c;
    
    public ap(final aj c, final ai a, final ai b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final ap ap = (ap)o;
        return this.a.equals(ap.a) && this.b.equals(ap.b);
    }
    
    public int hashCode() {
        return 31 * this.a.hashCode() + this.b.hashCode();
    }
}
