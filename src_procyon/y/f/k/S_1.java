package y.f.k;

import y.f.*;

final class S implements Comparable
{
    y.f.S a;
    int b;
    
    private S(final y.f.S a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public int compareTo(final Object o) {
        final S s = (S)o;
        final aG f = this.a.f();
        final aG f2 = s.a.f();
        return (f.k() ? -1 : (f.j() ? 0 : 1)) - (f2.k() ? -1 : (f2.j() ? false : true));
    }
    
    S(final y.f.S s, final int n, final R r) {
        this(s, n);
    }
}
