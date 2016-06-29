package y.f;

class H
{
    private final aG a;
    private final y b;
    
    private H(final aG a, final y b) {
        this.a = a;
        this.b = b;
    }
    
    H(final aG ag, final y y, final G g) {
        this(ag, y);
    }
    
    static aG a(final H h) {
        return h.a;
    }
    
    static y b(final H h) {
        return h.b;
    }
}
