package y.h.b;

import y.h.*;
import java.awt.geom.*;
import y.d.*;
import java.util.*;
import java.awt.*;

public class J implements bo
{
    public static final L a;
    public static final L b;
    public static final L c;
    public static final L d;
    public static final L e;
    public static final L f;
    private static final fj g;
    private final Map h;
    private int i;
    
    protected J() {
        this.h = new HashMap();
    }
    
    public static J a() {
        final J j = new J();
        j.h.put(J.b, new Q(false));
        j.h.put(J.a, new Q(true));
        j.h.put(J.d, new R(false, false));
        j.h.put(J.c, new R(true, false));
        j.h.put(J.f, new P(false, false));
        j.h.put(J.e, new P(true, false));
        return j;
    }
    
    public bo a(final L l) {
        return this.h.get(l);
    }
    
    public void a(final fj fj, final Graphics2D graphics2D) {
        this.b(fj, graphics2D, false);
    }
    
    protected void b(final fj fj, final Graphics2D graphics2D) {
        if (c(fj, graphics2D)) {
            fj.paintHotSpots(graphics2D);
        }
    }
    
    static boolean c(final fj fj, final Graphics2D graphics2D) {
        return fj.isSelected() && hk.b(graphics2D);
    }
    
    static boolean a(final Graphics2D graphics2D, final boolean b) {
        final Object renderingHint = graphics2D.getRenderingHint(hk.g);
        if (b) {
            return hk.i.equals(renderingHint);
        }
        return !hk.j.equals(renderingHint);
    }
    
    static boolean b(final Graphics2D graphics2D, final boolean b) {
        final Object renderingHint = graphics2D.getRenderingHint(hk.k);
        if (b) {
            return hk.m.equals(renderingHint);
        }
        return !hk.n.equals(renderingHint);
    }
    
    protected void d(final fj fj, final Graphics2D graphics2D) {
        fj.paintPorts(graphics2D);
    }
    
    protected void f(final fj fj, final Graphics2D graphics2D) {
        if (fj.labelCount() > 0) {
            fj.paintText(graphics2D);
        }
    }
    
    public void e(final fj fj, final Graphics2D graphics2D) {
        this.b(fj, graphics2D, true);
    }
    
    protected void a(final fj fj, final Graphics2D graphics2D, final boolean b) {
        if (fj instanceof a) {
            final Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
            final K k = new K(this, J.g);
            final a a = (a)fj;
            this.a(a, k);
            k.setSelected(c(fj, graphics2D));
            k.a("y.view.tabular.TableNodePainter.BOUNDS", new Rectangle2D.Double());
            k.a("y.view.tabular.TableNodePainter.CONTEXT", a);
            k.a("y.view.tabular.TableNodePainter.TABLE", a.l());
            this.a(k, graphics2D2, b, false);
            this.a(k, graphics2D2, b, true);
            graphics2D2.dispose();
        }
    }
    
    private void b(final fj fj, final Graphics2D graphics2D, final boolean b) {
        if (!b) {
            this.b(fj, graphics2D);
        }
        this.a(fj, graphics2D, b);
        if (b(graphics2D, b)) {
            this.d(fj, graphics2D);
        }
        if (a(graphics2D, b)) {
            this.f(fj, graphics2D);
        }
    }
    
    private void a(final aZ az, final Graphics2D graphics2D, final boolean b, final boolean b2) {
        final int h = y.h.b.a.H;
        final a a = a(az);
        final i l = a.l();
        final double x = a.getX();
        final double y = a.getY();
        final double width = a.getWidth();
        final double height = a.getHeight();
        final bo a2 = this.a(b2 ? J.a : J.b);
        Label_0110: {
            if (a2 != null) {
                az.setFrame(x, y, width, height);
                if (b) {
                    a2.e(az, graphics2D);
                    if (h == 0) {
                        break Label_0110;
                    }
                }
                a2.a(az, graphics2D);
            }
        }
        final bo a3 = this.a(b2 ? J.c : J.d);
        Label_0285: {
            if (a3 != null) {
                double n = x + a.v();
                final double n2 = y;
                final double n3 = height;
                final r d = l.d();
                final double n4 = n2 + d.a;
                final double n5 = n3 - (d.a + d.c);
                for (final c c : l.l()) {
                    az.a("y.view.tabular.TableNodePainter.COLUMN", c);
                    final double g = c.g();
                    az.setFrame(n, n4, g, n5);
                    this.a(az, graphics2D, b, a3);
                    n += g;
                    if (h != 0) {
                        break Label_0285;
                    }
                    if (h != 0) {
                        break;
                    }
                }
                az.c("y.view.tabular.TableNodePainter.COLUMN");
            }
        }
        final bo a4 = this.a(b2 ? J.e : J.f);
        if (a4 != null) {
            final double n6 = x;
            double n7 = y + a.t();
            final double n8 = width;
            final r d2 = l.d();
            final double n9 = n6 + d2.b;
            final double n10 = n8 - (d2.b + d2.d);
            for (final f f : l.o()) {
                az.a("y.view.tabular.TableNodePainter.ROW", f);
                final double g2 = f.g();
                az.setFrame(n9, n7, n10, g2);
                this.b(az, graphics2D, b, a4);
                n7 += g2;
                if (h != 0) {
                    return;
                }
                if (h != 0) {
                    break;
                }
            }
            az.c("y.view.tabular.TableNodePainter.ROW");
        }
    }
    
    private void a(final aZ az, final Graphics2D graphics2D, final boolean b, final bo bo) {
        final int h = y.h.b.a.H;
        final c c = c(az);
        double x = az.getX();
        double y = az.getY();
        double height = az.getHeight();
        final r a = this.a(az, c.i());
        if (this.b(1)) {
            y += a.a;
            height -= a.a;
        }
        if (this.b(4)) {
            height -= a.c;
        }
        Label_0116: {
            if (b) {
                bo.e(az, graphics2D);
                if (h == 0) {
                    break Label_0116;
                }
            }
            bo.a(az, graphics2D);
        }
        for (final c c2 : c.l()) {
            az.a("y.view.tabular.TableNodePainter.COLUMN", c2);
            double g = c2.g();
            double b2 = 0.0;
            double d = 0.0;
            Label_0229: {
                if (c2.b() == 0) {
                    if (this.a(2)) {
                        g += a.b;
                        b2 = a.b;
                        if (h == 0) {
                            break Label_0229;
                        }
                    }
                    x += a.b;
                }
            }
            if (c2.b() + 1 == c.k() && this.a(8)) {
                g += a.d;
                d = a.d;
            }
            az.setFrame(x, y, g, height);
            az.a("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID", new r(a.a, b2, a.c, d));
            this.a(az, graphics2D, b, bo);
            az.c("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID");
            x += g;
            if (h != 0) {
                break;
            }
        }
    }
    
    private void b(final aZ az, final Graphics2D graphics2D, final boolean b, final bo bo) {
        final int h = y.h.b.a.H;
        final f d = d(az);
        double x = az.getX();
        double y = az.getY();
        double width = az.getWidth();
        final r b2 = this.b(az, d.i());
        if (this.b(32)) {
            x += b2.b;
            width -= b2.b;
        }
        if (this.b(128)) {
            width -= b2.d;
        }
        Label_0119: {
            if (b) {
                bo.e(az, graphics2D);
                if (h == 0) {
                    break Label_0119;
                }
            }
            bo.a(az, graphics2D);
        }
        for (final f f : d.o()) {
            az.a("y.view.tabular.TableNodePainter.ROW", f);
            double g = f.g();
            double a = 0.0;
            double c = 0.0;
            Label_0234: {
                if (f.b() == 0) {
                    if (this.a(16)) {
                        g += b2.a;
                        a = b2.a;
                        if (h == 0) {
                            break Label_0234;
                        }
                    }
                    y += b2.a;
                }
            }
            if (f.b() + 1 == d.n() && this.a(64)) {
                g += b2.c;
                c = b2.c;
            }
            az.setFrame(x, y, width, g);
            az.a("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID", new r(a, b2.b, c, b2.d));
            this.b(az, graphics2D, b, bo);
            az.c("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID");
            y += g;
            if (h != 0) {
                break;
            }
        }
    }
    
    private r a(final aZ az, final r r) {
        return this.a(az, r, new int[] { 1, 2, 4, 8 });
    }
    
    private r b(final aZ az, final r r) {
        return this.a(az, r, new int[] { 16, 32, 64, 128 });
    }
    
    private r a(final aZ az, final r r, final int[] array) {
        final Object a = az.a("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID");
        if (a instanceof r) {
            double a2 = r.a;
            if (this.a(array[0])) {
                a2 += ((r)a).a;
            }
            double b = r.b;
            if (this.a(array[1])) {
                b += ((r)a).b;
            }
            double c = r.c;
            if (this.a(array[2])) {
                c += ((r)a).c;
            }
            double d = r.d;
            if (this.a(array[3])) {
                d += ((r)a).d;
            }
            return new r(a2, b, c, d);
        }
        return r;
    }
    
    private boolean a(final int n) {
        return (this.i & n) == n;
    }
    
    private boolean b(final int n) {
        return !this.a(n);
    }
    
    private static fj b() {
        final aZ az = new aZ();
        az.setLocation(0.0, 0.0);
        az.setFillColor(null);
        az.setFillColor2(null);
        az.setLineColor(null);
        while (az.labelCount() > 0) {
            az.removeLabel(az.getLabel(0));
        }
        return az;
    }
    
    private void a(final aZ az, final aZ az2) {
        final int h = y.h.b.a.H;
        az2.setFrame(az.getX(), az.getY(), az.getWidth(), az.getHeight());
        az2.setFillColor(az.getFillColor());
        az2.setFillColor2(az.getFillColor2());
        az2.setLineColor(az.getLineColor());
        az2.setLineType(az.getLineType());
        for (final Map.Entry<String, V> entry : az.e()) {
            az2.a(entry.getKey(), entry.getValue());
            if (h != 0) {
                break;
            }
        }
    }
    
    public static a a(final fj fj) {
        return (a)((aZ)fj).a("y.view.tabular.TableNodePainter.CONTEXT");
    }
    
    public static i b(final fj fj) {
        return (i)((aZ)fj).a("y.view.tabular.TableNodePainter.TABLE");
    }
    
    public static c c(final fj fj) {
        return (c)((aZ)fj).a("y.view.tabular.TableNodePainter.COLUMN");
    }
    
    public static f d(final fj fj) {
        return (f)((aZ)fj).a("y.view.tabular.TableNodePainter.ROW");
    }
    
    private static Rectangle2D f(final fj fj) {
        final Rectangle2D rectangle2D = (Rectangle2D)((aZ)fj).a("y.view.tabular.TableNodePainter.BOUNDS");
        rectangle2D.setFrame(fj.getX(), fj.getY(), fj.getWidth(), fj.getHeight());
        return rectangle2D;
    }
    
    private static Y b(final fj fj, final String s) {
        return (Y)((aZ)fj).a(s);
    }
    
    static Rectangle2D e(final fj fj) {
        return f(fj);
    }
    
    static Y a(final fj fj, final String s) {
        return b(fj, s);
    }
    
    static {
        a = new L(0, null);
        b = new L(1, null);
        c = new L(2, null);
        d = new L(3, null);
        e = new L(4, null);
        f = new L(5, null);
        g = b();
    }
}
