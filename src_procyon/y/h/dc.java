package y.h;

import y.d.*;
import y.c.*;
import java.util.*;
import y.g.*;
import java.awt.geom.*;
import java.awt.*;

public class dc extends e
{
    private Collection a;
    private c b;
    private ai c;
    private List d;
    private ai e;
    
    public dc() {
        this(null);
    }
    
    public dc(final ch ch) {
        super(ch);
    }
    
    public void f() {
        super.f();
        this.a = null;
        final ai ai = null;
        this.c = ai;
        this.e = ai;
        this.b = null;
        this.d = null;
    }
    
    public void a(final t t, final Collection a, final c b) {
        final boolean z = fj.z;
        this.a(t);
        final ch c = this.c();
        this.g();
        this.a = a;
        this.b = b;
        this.e = new ai();
        this.c = new ai();
        final ArrayList list = new ArrayList<q>(c.getGraph2D().e() - new HashSet(a).size());
        this.a(a, list);
        for (final q q : list) {
            final fj t2 = c.getGraph2D().t(q);
            if (this.a(t2)) {
                this.a(q, t2.getWidth(), this.c);
                this.a(q, t2.getHeight(), this.e);
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
                continue;
            }
        }
        this.d = this.a(list);
    }
    
    protected List a(final Collection collection) {
        final boolean z = fj.z;
        final ArrayList list = new ArrayList();
        final Iterator<q> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.a(iterator.next(), list);
            if (z) {
                break;
            }
        }
        return list;
    }
    
    protected void a(final q q, final Collection collection) {
        final fj t = this.c().getGraph2D().t(q);
        if (this.a(t)) {
            this.a(t, collection);
        }
    }
    
    protected void a(final fj fj, final Collection collection) {
        final double centerX = fj.getCenterX();
        final double y = fj.getY();
        collection.add(new gy((byte)0, (byte)1, new t(centerX, y), null, 1.0));
        final double n = y + fj.getHeight();
        collection.add(new gy((byte)0, (byte)2, new t(centerX, n), null, 1.0));
        final double width = fj.getWidth();
        final double x = fj.getX();
        final double n2 = x + width;
        collection.add(new gy((byte)0, (byte)2, new t(centerX, y), x, n2, null, 1.0));
        collection.add(new gy((byte)0, (byte)1, new t(centerX, n), x, n2, null, 1.0));
        final double centerY = fj.getCenterY();
        collection.add(new gy((byte)1, (byte)4, new t(x, centerY), null, 1.0));
        collection.add(new gy((byte)1, (byte)8, new t(n2, centerY), null, 1.0));
        collection.add(new gy((byte)1, (byte)8, new t(x, centerY), y, n, null, 1.0));
        collection.add(new gy((byte)1, (byte)4, new t(n2, centerY), y, n, null, 1.0));
    }
    
    private void a(final q q, final double n, final ai ai) {
        final boolean z = fj.z;
        de de = new de(n);
        final aj b = ai.b(de);
        Label_0155: {
            if (b == null) {
                if (ai.a() == 0) {
                    ai.a(de);
                    if (!z) {
                        break Label_0155;
                    }
                }
                final de de2 = (de)ai.b().c();
                if (de2.a == n) {
                    de = de2;
                    if (!z) {
                        break Label_0155;
                    }
                }
                ai.b(ai.b(), de);
                if (!z) {
                    break Label_0155;
                }
            }
            if (b.a() != null && ((de)b.a().c()).a == n) {
                de = (de)b.a().c();
                if (!z) {
                    break Label_0155;
                }
            }
            ai.a(b, de);
        }
        de.b.add(q);
    }
    
    public t a(final t t, final byte b, final boolean b2, final boolean b3) {
        final boolean z = fj.z;
        final t k = this.k();
        this.h();
        if (this.c.a() == 0) {
            return t;
        }
        if (b2) {
            switch (b) {
                case 0:
                case 2:
                case 3:
                case 5: {
                    return t;
                }
            }
        }
        final double n = t.a - k.a;
        final double n2 = t.b - k.b;
        double n3 = 0.0;
        double n4 = 0.0;
        double n5 = 0.0;
        double n6 = 0.0;
        double n7 = 0.0;
        double n8 = 0.0;
        Label_0490: {
            Label_0438: {
                switch (b) {
                    case 7: {
                        n3 = 0.0;
                        n4 = 1.0;
                        n5 = (b3 ? -1.0 : 0.0);
                        n6 = 0.0;
                        n7 = 1.0;
                        n8 = 0.0;
                        if (z) {
                            break Label_0438;
                        }
                        break Label_0490;
                    }
                    case 2: {
                        n3 = -1.0;
                        n4 = 1.0;
                        n5 = (b3 ? -1.0 : 0.0);
                        n6 = 1.0;
                        n7 = 1.0;
                        n8 = (b3 ? -1.0 : 0.0);
                        if (z) {
                            break Label_0438;
                        }
                        break Label_0490;
                    }
                    case 5: {
                        n3 = 1.0;
                        n4 = 1.0;
                        n5 = (b3 ? -1.0 : 0.0);
                        n6 = (b3 ? -1.0 : 0.0);
                        n7 = 1.0;
                        n8 = 1.0;
                        if (z) {
                            break Label_0438;
                        }
                        break Label_0490;
                    }
                    case 6: {
                        n3 = 0.0;
                        n4 = -1.0;
                        n5 = 1.0;
                        n6 = 0.0;
                        n7 = (b3 ? -1.0 : 0.0);
                        n8 = 0.0;
                        if (z) {
                            break Label_0438;
                        }
                        break Label_0490;
                    }
                    case 3: {
                        n3 = 1.0;
                        n4 = -1.0;
                        n5 = 1.0;
                        n6 = (b3 ? -1.0 : 0.0);
                        n7 = (b3 ? -1.0 : 0.0);
                        n8 = 1.0;
                        if (z) {
                            break Label_0438;
                        }
                        break Label_0490;
                    }
                    case 0: {
                        n3 = -1.0;
                        n4 = -1.0;
                        n5 = 1.0;
                        n6 = 1.0;
                        n7 = (b3 ? -1.0 : 0.0);
                        n8 = (b3 ? -1.0 : 0.0);
                        if (z) {
                            break Label_0438;
                        }
                        break Label_0490;
                    }
                    case 1: {
                        n3 = -1.0;
                        n4 = 0.0;
                        n5 = 0.0;
                        n6 = 1.0;
                        n7 = 0.0;
                        n8 = (b3 ? -1.0 : 0.0);
                        if (z) {
                            break Label_0438;
                        }
                        break Label_0490;
                    }
                    case 4: {
                        n3 = 1.0;
                        n4 = 0.0;
                        n5 = 0.0;
                        n6 = (b3 ? -1.0 : 0.0);
                        n7 = 0.0;
                        n8 = 1.0;
                        if (z) {
                            break;
                        }
                        break Label_0490;
                    }
                }
            }
            n3 = (n4 = 0.0);
            n6 = (n5 = 0.0);
            n8 = (n7 = 0.0);
        }
        if (b3) {
            n4 *= 2.0;
            n3 *= 2.0;
        }
        final double n9 = n * n4;
        final double n10 = n2 * n3;
        final double n11 = n5 * n;
        final double n12 = n6 * n2;
        final ArrayList<gz> list = new ArrayList<gz>(5);
        final double n13 = this.e() / this.c().getZoom();
        final Iterator iterator = this.a.iterator();
    Label_1386:
        while (true) {
            double hasNext = iterator.hasNext() ? 1 : 0;
        Label_0581:
            while (hasNext != 0) {
                final q q = iterator.next();
                Rectangle2D.Double double1;
                try {
                    double1 = (Rectangle2D.Double)this.b.b(q);
                    if (double1 == null && !z) {
                        continue Label_1386;
                    }
                }
                catch (Exception ex) {
                    continue Label_1386;
                }
                final double n14 = double1.getX() + n11;
                final double n15 = double1.width + n9;
                final double n16 = n14 + n15;
                final double n17 = double1.getY() + n12;
                final double n18 = double1.height + n10;
                final double n19 = n17 + n18;
                final gt sizeConstraintProvider = this.c().getGraph2D().t(q).getSizeConstraintProvider();
                if (sizeConstraintProvider != null) {
                    final y.d.q minimumSize = sizeConstraintProvider.getMinimumSize();
                    if (minimumSize != null) {
                        if (n15 - n13 < minimumSize.a) {
                            n5 = (n4 = (n7 = 0.0));
                        }
                        if (n18 - n13 < minimumSize.b) {
                            n6 = (n3 = (n8 = 0.0));
                        }
                    }
                    final y.d.q maximumSize = sizeConstraintProvider.getMaximumSize();
                    if (maximumSize != null) {
                        if (n15 + n13 > maximumSize.a) {
                            n5 = (n4 = (n7 = 0.0));
                        }
                        if (n18 + n13 > maximumSize.b) {
                            n6 = (n3 = (n8 = 0.0));
                        }
                    }
                }
                if (n4 != 0.0) {
                    final gz a = this.a(q, 1.0 / n4, n15, this.c, t.a, true);
                    if (a.b() > 0.0) {
                        list.add(a);
                    }
                }
                if (n3 != 0.0) {
                    final gz a2 = this.a(q, 1.0 / n3, n18, this.e, t.b, false);
                    if (a2.b() > 0.0) {
                        list.add(a2);
                    }
                }
                for (final gy gy : this.d) {
                    if (gy.c() == 1) {
                        if (gy.d() == 4) {
                            if (n5 == 0.0 || gy.e() >= n19 || gy.f() <= n17) {
                                continue;
                            }
                            final double n20 = gy.b().a - n14;
                            if (Math.abs(n20) >= n13) {
                                continue;
                            }
                            list.add(gz.a(n13 - Math.abs(n20), gy, true, t.a + n20 * n5));
                            if (!z) {
                                continue;
                            }
                        }
                        if (gy.d() != 8 || n7 == 0.0 || gy.e() >= n19 || gy.f() <= n17) {
                            continue;
                        }
                        final double n21 = gy.b().a - n16;
                        if (Math.abs(n21) >= n13) {
                            continue;
                        }
                        list.add(gz.a(n13 - Math.abs(n21), gy, true, t.a + n21 * n7));
                        if (!z) {
                            continue;
                        }
                    }
                    if (gy.d() == 1) {
                        if (n6 == 0.0 || gy.e() >= n16 || gy.f() <= n14) {
                            continue;
                        }
                        final double n22 = gy.b().b - n17;
                        if (Math.abs(n22) >= n13) {
                            continue;
                        }
                        list.add(gz.a(n13 - Math.abs(n22), gy, false, t.b + n22 * n6));
                        if (!z) {
                            continue;
                        }
                    }
                    if (gy.d() == 2) {
                        final double n23 = hasNext = dcmpl(n8, 0.0);
                        if (z) {
                            continue Label_0581;
                        }
                        if (n23 == 0 || gy.e() >= n16 || gy.f() <= n14) {
                            continue;
                        }
                        final double n24 = gy.b().b - n19;
                        if (Math.abs(n24) >= n13) {
                            continue;
                        }
                        list.add(gz.a(n13 - Math.abs(n24), gy, false, t.b + n24 * n8));
                        if (z) {
                            break Label_1386;
                        }
                        continue;
                    }
                }
                continue Label_1386;
            }
            break;
        }
        return this.a(list, t);
    }
    
    private gz a(final q q, final double n, final double n2, final ai ai, final double n3, final boolean b) {
        final boolean z = fj.z;
        final double n4 = this.e() / this.c().getZoom();
        final aj b2 = ai.b(new de(n2));
        final aj aj = (b2 != null) ? b2.a() : ai.b();
        final double n5 = (b2 != null) ? (((de)b2.c()).a - n2) : Double.POSITIVE_INFINITY;
        final double n6 = (aj != null) ? (((de)aj.c()).a - n2) : Double.POSITIVE_INFINITY;
        if (Math.abs(n5) < n4) {
            if (Math.abs(n6) < Math.abs(n5)) {
                final double n7 = n6 * n;
                final de de = (de)aj.c();
                if (!z) {
                    return gz.a((n7 != 0.0) ? (1.0 / (1.0 + Math.abs(n7))) : 1.0, new dd(this, de, b, q), b, n7 + n3);
                }
            }
            final double n7 = n5 * n;
            final de de = (de)b2.c();
            if (!z) {
                return gz.a((n7 != 0.0) ? (1.0 / (1.0 + Math.abs(n7))) : 1.0, new dd(this, de, b, q), b, n7 + n3);
            }
        }
        if (Math.abs(n6) < n4) {
            final double n7 = n6 * n;
            final de de = (de)aj.c();
            if (!z) {
                return gz.a((n7 != 0.0) ? (1.0 / (1.0 + Math.abs(n7))) : 1.0, new dd(this, de, b, q), b, n7 + n3);
            }
        }
        return gz.b;
    }
    
    private Rectangle2D a(final bu bu, final q q, final boolean b) {
        final fj t = bu.t(q);
        if (b) {
            final Line2D.Double double1 = new Line2D.Double(t.getX(), t.getY() - 15.0, t.getX() + t.getWidth(), t.getY() + 10.0);
            if (!fj.z) {
                return double1.getBounds2D();
            }
        }
        final Line2D.Double double1 = new Line2D.Double(t.getX() - 15.0, t.getY(), t.getX() + 10.0, t.getY() + t.getHeight());
        return double1.getBounds2D();
    }
    
    private void a(final Graphics2D graphics2D, final bu bu, final q q, final boolean b) {
        final fj t = bu.t(q);
        if (b) {
            y.h.e.a(graphics2D, t.getX(), t.getY() - 5.0, t.getX() + t.getWidth(), t.getY() - 5.0);
            if (!fj.z) {
                return;
            }
        }
        y.h.e.a(graphics2D, t.getX() - 5.0, t.getY(), t.getX() - 5.0, t.getY() + t.getHeight());
    }
    
    static void a(final dc dc, final Graphics2D graphics2D, final bu bu, final q q, final boolean b) {
        dc.a(graphics2D, bu, q, b);
    }
    
    static Rectangle2D a(final dc dc, final bu bu, final q q, final boolean b) {
        return dc.a(bu, q, b);
    }
}
