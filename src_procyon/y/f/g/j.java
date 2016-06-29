package y.f.g;

class j
{
    private final Object a;
    private final Object b;
    private final d c;
    
    private j(final d c, final Object a, final Object b) {
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
        final j j = (j)o;
        Label_0062: {
            if (this.b != null) {
                if (this.b.equals(j.b)) {
                    break Label_0062;
                }
            }
            else if (j.b == null) {
                break Label_0062;
            }
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(j.a)) {
                return true;
            }
        }
        else if (j.a == null) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        return 31 * ((this.a != null) ? this.a.hashCode() : 0) + ((this.b != null) ? this.b.hashCode() : 0);
    }
    
    j(final d d, final Object o, final Object o2, final e e) {
        this(d, o, o2);
    }
}
