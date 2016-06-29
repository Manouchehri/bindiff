package y.f.i.a;

import y.c.*;

final class bQ
{
    private final q a;
    private final Object b;
    
    bQ(final q a, final Object b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof bQ)) {
            return false;
        }
        final bQ bq = (bQ)o;
        if (this.a != bq.a) {
            return false;
        }
        if (this.b != null) {
            if (this.b.equals(bq.b)) {
                return true;
            }
        }
        else if (bq.b == null) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        return 31 * ((this.a != null) ? this.a.hashCode() : 0) + ((this.b != null) ? this.b.hashCode() : 0);
    }
}
