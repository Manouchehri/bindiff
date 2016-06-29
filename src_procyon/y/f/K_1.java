package y.f;

import y.d.*;
import y.c.*;

public class K implements E
{
    public Object c() {
        return new L(20.0, 20.0, 0.0);
    }
    
    public Object a(final n n, final I i, final am am, final am am2) {
        if (ae.a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        final t sourcePoint = i.getSourcePoint();
        final t t = new t(sourcePoint.a() + am.getX() + am.getWidth() / 2.0, sourcePoint.b() + am.getY() + am.getHeight() / 2.0);
        t point = null;
        Label_0188: {
            if (i.pointCount() == 0) {
                final t targetPoint = i.getTargetPoint();
                point = new t(targetPoint.a() + am2.getX() + am2.getWidth() / 2.0, targetPoint.b() + am2.getY() + am2.getHeight() / 2.0);
                if (!X.j) {
                    break Label_0188;
                }
            }
            point = i.getPoint(0);
        }
        final double a = this.a(t, point);
        final y h = n.h();
        final t t2 = new t(h.c() + h.a() / 2.0, h.d() + h.b() / 2.0);
        final double n2 = this.a(t, t2) - a;
        final double n3 = t2.a() - t.a();
        final double n4 = t2.b() - t.b();
        return this.a((n3 != 0.0 || n4 != 0.0) ? Math.sqrt(n3 * n3 + n4 * n4) : 0.0, n2, n.j());
    }
    
    private Object a(final double n, final double n2, final double n3) {
        return new L(n, n2, n3);
    }
    
    private double a(final t t, final t t2) {
        final double n = t2.a() - t.a();
        final double n2 = t2.b() - t.b();
        return (n != 0.0 || n2 != 0.0) ? Math.atan2(n2, n) : 0.0;
    }
    
    public n a(final q q, final I i, final am am, final am am2, final Object o) {
        final t sourcePoint = i.getSourcePoint();
        final t t = new t(sourcePoint.a() + am.getX() + am.getWidth() / 2.0, sourcePoint.b() + am.getY() + am.getHeight() / 2.0);
        t point = null;
        Label_0154: {
            if (i.pointCount() == 0) {
                final t targetPoint = i.getTargetPoint();
                point = new t(targetPoint.a() + am2.getX() + am2.getWidth() / 2.0, targetPoint.b() + am2.getY() + am2.getHeight() / 2.0);
                if (!X.j) {
                    break Label_0154;
                }
            }
            point = i.getPoint(0);
        }
        final double a = this.a(t, point);
        final L l = (L)((o != null) ? o : ((L)this.c()));
        final double n = a + l.b;
        final double cos = Math.cos(n);
        final double sin = Math.sin(n);
        final n n2 = new n(0.0, 0.0, q.a(), q.b());
        n2.a(l.a());
        final y h = n2.h();
        final t t2 = new t(t.a() + cos * l.a - h.a() / 2.0, t.b() + sin * l.a - h.b() / 2.0);
        n2.e(t2.a + h.a() * 0.5, t2.b + h.b() * 0.5);
        return n2;
    }
    
    public D a(final C c, final I i, final am am, final am am2) {
        final D d = new D();
        d.add(new B(c.getOrientedBox(), c.getModelParameter(), c));
        return d;
    }
}
