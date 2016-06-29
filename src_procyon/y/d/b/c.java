package y.d.b;

public abstract class c implements u
{
    public static int a;
    
    public int a(final Object o, final Object o2) {
        return this.c(this.c(o), this.d(o), o2);
    }
    
    public boolean a(final Object o, final Object o2, final Object o3) {
        return this.c(o, o2, o3) > 0;
    }
    
    public boolean b(final Object o, final Object o2, final Object o3) {
        return this.c(o, o2, o3) == 0;
    }
    
    public boolean b(final Object o, final Object o2) {
        return !o2.equals(this.c(o)) && !o2.equals(this.d(o)) && this.e(o, o2);
    }
    
    public boolean a(final Object o) {
        return this.c(o).equals(this.d(o));
    }
    
    public z b(final Object o) {
        final Object c = this.c(o);
        final Object d = this.d(o);
        final z b = this.k(c).b(this.k(d));
        final z b2 = this.l(c).b(this.l(d));
        return b.c(b).a(b2.c(b2));
    }
}
