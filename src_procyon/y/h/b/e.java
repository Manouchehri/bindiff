package y.h.b;

import java.awt.geom.*;
import y.d.*;
import y.h.*;
import java.util.*;

public final class e extends l
{
    public e() {
        this(3.0);
    }
    
    public e(final double n) {
        super(n);
    }
    
    public Object c() {
        return super.c();
    }
    
    n a(final y y, final q q) {
        final double a = this.a();
        final double n = y.d + y.b * 0.5;
        final Rectangle2D h = q.h();
        if (n < h.getY()) {
            return new n(q.a, false, 0.0);
        }
        if (n > h.getMaxY()) {
            return new n(q.a, false, 1.0);
        }
        final double d = y.d;
        final double n2 = h.getHeight() - y.b - 2.0 * a;
        final double n3 = h.getY() + a;
        final double n4 = n3 + n2;
        if (d < n3) {
            return new n(q.a, true, 0.0);
        }
        if (d > n4) {
            return new n(q.a, true, 1.0);
        }
        return new n(q.a, true, (d - n3) / n2);
    }
    
    t a(final y.d.q q, final q q2, final n n) {
        final int h = y.h.b.a.H;
        final double a = this.a();
        final Rectangle2D h2 = q2.h();
        final double n2 = h2.getCenterX() - q.a * 0.5;
        if (n.b) {
            final double n3 = h2.getY() + a + (h2.getHeight() - q.b - 2.0 * a) * n.c;
            if (h == 0) {
                return new t(n2, n3);
            }
        }
        if (n.c < 0.5) {
            final double n3 = h2.getY() - q.b - a;
            if (h == 0) {
                return new t(n2, n3);
            }
        }
        final double n3 = h2.getMaxY() + a;
        return new t(n2, n3);
    }
    
    Collection a(final i i) {
        return i.l();
    }
    
    public static c a(final eR er) {
        if (er.a() instanceof e) {
            return (c)l.a((a)er.g(), (l)er.a(), l.a(er.getModelParameter()));
        }
        return null;
    }
    
    public static c a(final a a, final Object o) {
        return (c)l.a(a, new e(), l.a(o));
    }
    
    public static Collection a(final c c) {
        final int h = y.h.b.a.H;
        final a a = y.h.b.a.a(c);
        final ArrayList list = new ArrayList<eR>(a.labelCount());
        final Object a2 = ((y.h.b.t)c).a;
        int i = 0;
        while (i < a.labelCount()) {
            final eR label = a.getLabel(i);
            if (label.a() instanceof e && a2 == l.a(label.getModelParameter()).a) {
                list.add(label);
            }
            ++i;
            if (h != 0) {
                break;
            }
        }
        return list;
    }
}
