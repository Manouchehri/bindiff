package y.f.c.a;

class L
{
    final Object a;
    final Object b;
    private final E c;
    
    L(final E c, final Object a, final Object b) {
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
        final L l = (L)o;
        Label_0062: {
            if (this.a != null) {
                if (this.a.equals(l.a)) {
                    break Label_0062;
                }
            }
            else if (l.a == null) {
                break Label_0062;
            }
            return false;
        }
        if (this.b != null) {
            if (!this.b.equals(l.b)) {
                return false;
            }
        }
        else if (l.b != null) {
            return false;
        }
        return true;
        b = false;
        return b;
    }
    
    public int hashCode() {
        return 31 * ((this.a != null) ? this.a.hashCode() : 0) + ((this.b != null) ? this.b.hashCode() : 0);
    }
}
