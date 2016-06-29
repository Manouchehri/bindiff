package y.h.b;

public final class L
{
    private final int a;
    
    private L(final int a) {
        this.a = a;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && this.a == ((L)o).a);
    }
    
    public int hashCode() {
        return this.a;
    }
    
    L(final int n, final K k) {
        this(n);
    }
}
