package y.f;

import y.d.*;
import y.c.*;

class aW
{
    public static Q a(final D d, final t t) {
        final boolean j = X.j;
        Q q = null;
        Q q2 = null;
        double n = Double.MAX_VALUE;
        double n2 = Double.MAX_VALUE;
        final C m = d.m();
        while (m.f()) {
            final Q q3 = (Q)m.d();
            final double a = t.a(t, q3.d().k());
            if (j) {
                return q;
            }
            if (a < n) {
                n = a;
                q = q3;
            }
            if (a < n2 && y.d.n.a(q3.d(), t, 0.0)) {
                n2 = a;
                q2 = q3;
            }
            m.g();
            if (j) {
                break;
            }
        }
        if (q2 != null) {
            return q2;
        }
        return q;
    }
    
    public static n a(final n n) {
        final t k = n.k();
        final n n2 = new n(0.0, 0.0, n.e(), n.f());
        n2.e(k.a, k.b);
        return n2;
    }
}
