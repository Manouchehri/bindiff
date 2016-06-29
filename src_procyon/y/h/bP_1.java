package y.h;

class bP implements bQ
{
    private final Throwable[] a;
    private final bI b;
    
    bP(final bI b, final Throwable[] a) {
        this.b = b;
        this.a = a;
    }
    
    public void a(final Throwable t) {
        this.a[0] = t;
    }
}
