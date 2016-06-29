package y.g;

class v extends p
{
    private Object a;
    
    v(final Object a) {
        this.a = a;
    }
    
    public Object b(final Object o) {
        return this.a;
    }
    
    public double c(final Object o) {
        return ((Number)this.a).doubleValue();
    }
    
    public int a(final Object o) {
        return ((Number)this.a).intValue();
    }
    
    public boolean d(final Object o) {
        return (boolean)this.a;
    }
}
