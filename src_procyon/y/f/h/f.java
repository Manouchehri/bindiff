package y.f.h;

class f
{
    private final Object a;
    
    private f(final Object a) {
        this.a = a;
    }
    
    public static f a(final Object o) {
        return new f(o);
    }
    
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && this.a == ((f)o).a);
    }
    
    public int hashCode() {
        return this.a.hashCode();
    }
}
