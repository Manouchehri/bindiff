package y.f;

import y.d.*;
import y.c.*;

public class M implements al
{
    public Object c() {
        return new N(-20.0, -20.0);
    }
    
    public n a(final q q, final am am, final Object o) {
        final N n = (N)o;
        final double b = q.b();
        return new n(n.a - b * n.c + am.getX(), n.b - b * n.d + am.getY(), q.a(), b, n.c, n.d);
    }
    
    public D a(final aj aj, final am am) {
        final D d = new D();
        d.add(new ai(aj.getOrientedBox(), aj.getModelParameter(), aj, false));
        return d;
    }
    
    public Object a(final n n, final am am) {
        if (ae.a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        final double g = n.g();
        final double i = n.i();
        final double f = n.f();
        return new N(n.b() + f * g - am.getX(), n.c() + f * i - am.getY(), g, i);
    }
}
