package y.h.b;

import java.awt.geom.*;
import y.d.*;
import y.h.*;
import java.util.*;

public final class h extends l
{
    public h() {
        this(3.0);
    }
    
    public h(final double n) {
        super(n);
    }
    
    public Object c() {
        return super.c();
    }
    
    n a(final y y, final q q) {
        final double a = this.a();
        final double n = y.c + y.a * 0.5;
        final Rectangle2D h = q.h();
        if (n < h.getX()) {
            return new n(q.a, false, 0.0);
        }
        if (n > h.getMaxX()) {
            return new n(q.a, false, 1.0);
        }
        final double c = y.c;
        final double n2 = h.getWidth() - y.a - 2.0 * a;
        final double n3 = h.getX() + a;
        final double n4 = n3 + n2;
        if (c < n3) {
            return new n(q.a, true, 0.0);
        }
        if (c > n4) {
            return new n(q.a, true, 1.0);
        }
        return new n(q.a, true, (c - n3) / n2);
    }
    
    t a(final y.d.q q, final q q2, final n n) {
        final int h = y.h.b.a.H;
        final double a = this.a();
        final Rectangle2D h2 = q2.h();
        final double n2 = h2.getCenterY() - q.b * 0.5;
        if (n.b) {
            final double n3 = h2.getX() + a + (h2.getWidth() - q.a - 2.0 * a) * n.c;
            if (h == 0) {
                return new t(n3, n2);
            }
        }
        if (n.c < 0.5) {
            final double n3 = h2.getX() - q.a - a;
            if (h == 0) {
                return new t(n3, n2);
            }
        }
        final double n3 = h2.getMaxX() + a;
        return new t(n3, n2);
    }
    
    Collection a(final i i) {
        return i.o();
    }
    
    public static f a(final eR er) {
        if (er.a() instanceof h) {
            return (f)l.a((a)er.g(), (l)er.a(), l.a(er.getModelParameter()));
        }
        return null;
    }
    
    public static f a(final a a, final Object o) {
        return (f)l.a(a, new h(), l.a(o));
    }
    
    public static Collection a(final f f) {
        final int h = y.h.b.a.H;
        final a a = y.h.b.a.a(f);
        final ArrayList list = new ArrayList<eR>(a.labelCount());
        final Object a2 = ((r)f).a;
        int i = 0;
        while (i < a.labelCount()) {
            final eR label = a.getLabel(i);
            if (label.a() instanceof h && a2 == l.a(label.getModelParameter()).a) {
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
