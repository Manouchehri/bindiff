package y.h.b;

import java.awt.geom.*;
import y.h.*;
import y.d.*;
import y.h.a.*;

final class o extends b
{
    private static final r b;
    
    private o() {
    }
    
    public r h(final fj fj) {
        if (fj instanceof a) {
            final a a = (a)fj;
            final s s = new s();
            y.h.b.a.a(a, s);
            y.h.b.a.b(a, s);
            return new r(s.a, s.b, s.c, s.d);
        }
        return o.b;
    }
    
    public void c(final fj fj) {
        if (fj instanceof e) {
            final e e = (e)fj;
            if (!e.g()) {
                return;
            }
            e.b(false);
            if (e.isGroupClosed() || this.j(e)) {
                if (!this.a()) {
                    return;
                }
                final Dimension2D e2 = this.e(e);
                final double[] array = { e2.getWidth(), e2.getHeight() };
                this.a(fj, array);
                double width = e.getWidth();
                boolean b = false;
                if (width < array[0]) {
                    width = array[0];
                    b = true;
                }
                double height = e.getHeight();
                if (height < array[1]) {
                    height = array[1];
                    b = true;
                }
                if (!b) {
                    return;
                }
                e.setFrame(e.getX(), e.getY(), width, height);
                if (y.h.b.a.H == 0) {
                    return;
                }
            }
            final Rectangle2D d = this.d(fj);
            final double[] array2 = { d.getWidth(), d.getHeight() };
            this.a(fj, array2);
            fj.setFrame(d.getX(), d.getY(), array2[0], array2[1]);
        }
    }
    
    private void a(final fj fj, final double[] array) {
        final gt sizeConstraintProvider = fj.getSizeConstraintProvider();
        if (sizeConstraintProvider != null) {
            final q minimumSize = sizeConstraintProvider.getMinimumSize();
            if (array[0] < minimumSize.a || array[1] < minimumSize.b) {
                array[0] = Math.max(array[0], minimumSize.a);
                array[1] = Math.max(array[1], minimumSize.b);
            }
        }
    }
    
    private boolean j(final fj fj) {
        final v i = this.i(fj);
        return i == null || !i.p(fj.getNode()).f();
    }
    
    o(final y.h.b.b b) {
        this();
    }
    
    static r b() {
        return o.b;
    }
    
    static {
        b = new r(0.0, 0.0, 0.0, 0.0);
    }
}
