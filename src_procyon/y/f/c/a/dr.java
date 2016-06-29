package y.f.c.a;

import y.d.*;
import y.c.*;

class dr
{
    private final t a;
    private final d b;
    
    private dr(final d b, final t a) {
        this.b = b;
        this.a = a;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final dr dr = (dr)o;
        Label_0062: {
            if (this.b != null) {
                if (this.b.equals(dr.b)) {
                    break Label_0062;
                }
            }
            else if (dr.b == null) {
                break Label_0062;
            }
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(dr.a)) {
                return true;
            }
        }
        else if (dr.a == null) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        return 31 * ((this.a != null) ? this.a.hashCode() : 0) + ((this.b != null) ? this.b.hashCode() : 0);
    }
    
    dr(final d d, final t t, final dq dq) {
        this(d, t);
    }
}
