package y.h;

import y.d.*;
import java.awt.geom.*;
import java.awt.*;
import java.util.*;
import y.c.*;
import y.h.a.*;

public class e
{
    private az a;
    private ch b;
    private List c;
    private double d;
    private double e;
    private double f;
    private List g;
    private final List h;
    private boolean i;
    private Color j;
    private t k;
    
    public e(final ch b) {
        this.c = Collections.EMPTY_LIST;
        this.d = 5.0;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = true;
        this.j = Color.LIGHT_GRAY;
        this.k = t.c;
        this.b = b;
        this.a = new f(this);
    }
    
    public Color a() {
        return this.j;
    }
    
    public void a(final boolean i) {
        this.i = i;
    }
    
    public void a(final gz gz) {
        this.g.add(gz);
    }
    
    public void b() {
        this.g.clear();
    }
    
    protected t a(final List c, final t t) {
        final boolean z = fj.z;
        final t k = this.k();
        (this.c = c).addAll(this.g);
        if (this.c.size() <= 0) {
            this.e = t.a - k.a;
            this.f = t.b - k.b;
            return t;
        }
        y.g.e.a(this.c, null);
        final Point2D.Double double1 = new Point2D.Double(t.a, t.b);
        byte a = 0;
        int i = 0;
    Label_0157_Outer:
        while (true) {
            while (true) {
                while (i < this.c.size()) {
                    a = ((gz)this.c.get(i)).a(t, double1, a);
                    ++i;
                    if (z) {
                        final t t2 = t;
                        final HashSet<Object> set = new HashSet<Object>();
                        int j = this.c.size() - 1;
                        while (j >= 0) {
                            final gz gz = this.c.get(j);
                            if (z) {
                                return t2;
                            }
                            Label_0268: {
                                if (!gz.a(t, t2, a)) {
                                    this.c.remove(j);
                                    if (!z) {
                                        break Label_0268;
                                    }
                                }
                                if (gz.a() != null && !set.add(gz.a())) {
                                    this.c.remove(j);
                                }
                            }
                            --j;
                            if (z) {
                                break;
                            }
                        }
                        this.e = t2.a - k.a;
                        this.f = t2.b - k.b;
                        return t2;
                    }
                    if (z) {
                        break;
                    }
                }
                if (a != 0) {
                    final t t2 = new t(double1.x, double1.y);
                    continue;
                }
                break;
            }
            continue Label_0157_Outer;
        }
    }
    
    public ch c() {
        return this.b;
    }
    
    public az d() {
        return this.a;
    }
    
    public void a(final ch b) {
        this.b = b;
    }
    
    static void a(final Graphics2D graphics2D, final double n, final double n2, final double n3, final double n4) {
        final boolean z = fj.z;
        graphics2D.draw(new Line2D.Double(n, n2, n3, n4));
        double n5 = 0.0;
        double n6 = 0.0;
        Label_0144: {
            if (n == n3) {
                n5 = ((n2 > n4) ? -1.0 : 1.0);
                n6 = 0.0;
                if (!z) {
                    break Label_0144;
                }
            }
            if (n2 == n4) {
                n6 = ((n > n3) ? -1.0 : 1.0);
                n5 = 0.0;
                if (!z) {
                    break Label_0144;
                }
            }
            n6 = n3 - n;
            n5 = n4 - n2;
            final double abs = Math.abs(n6 * n6 + n5 * n5);
            if (abs == 0.0) {
                n6 = 1.0;
                n5 = 0.0;
                if (!z) {
                    break Label_0144;
                }
            }
            n6 /= abs;
            n5 /= abs;
        }
        final double n7 = n6 * 5.0;
        final double n8 = n5 * 5.0;
        final double n9 = -n8;
        final double n10 = n7;
        graphics2D.draw(new Line2D.Double(n + n9, n2 + n10, n - n9, n2 - n10));
        graphics2D.draw(new Line2D.Double(n, n2, n + n9 + n7, n2 + n10 + n8));
        graphics2D.draw(new Line2D.Double(n, n2, n - n9 + n7, n2 - n10 + n8));
        graphics2D.draw(new Line2D.Double(n3 + n9, n4 + n10, n3 - n9, n4 - n10));
        graphics2D.draw(new Line2D.Double(n3, n4, n3 + n9 - n7, n4 + n10 - n8));
        graphics2D.draw(new Line2D.Double(n3, n4, n3 - n9 - n7, n4 - n10 - n8));
    }
    
    protected boolean a(final fj fj) {
        return this.b.getVisibleRect().intersects(fj.getX(), fj.getY(), fj.getWidth(), fj.getHeight());
    }
    
    protected boolean a(final aB ab, final t t, final t t2) {
        return this.b.getVisibleRect().intersectsLine(t.a, t.b, t2.a, t2.b);
    }
    
    protected void a(final Collection collection, final Collection collection2) {
        final boolean z = fj.z;
        final bu graph2D = this.b.getGraph2D();
        final v c = graph2D.C();
        final HashSet<Object> set = new HashSet<Object>();
        Label_0142: {
            Label_0134: {
                if (c != null) {
                    final Iterator<q> iterator = collection.iterator();
                Label_0041:
                    while (true) {
                        iterator.hasNext();
                        boolean a = false;
                    Label_0048:
                        while (a) {
                            final q q = iterator.next();
                            if (!graph2D.f(q)) {
                                continue Label_0041;
                            }
                            q q2 = c.n(q);
                            while (q2 != null) {
                                a = this.a(q2);
                                if (z) {
                                    break Label_0142;
                                }
                                if (z) {
                                    continue Label_0048;
                                }
                                if (!a || !set.add(q2)) {
                                    break;
                                }
                                q2 = c.n(q2);
                                if (z) {
                                    break Label_0134;
                                }
                            }
                            continue Label_0041;
                        }
                        break;
                    }
                }
            }
            set.addAll(collection);
        }
        final x o = graph2D.o();
        while (o.f()) {
            final q e = o.e();
            if (!set.contains(e)) {
                collection2.add(e);
            }
            o.g();
            if (z) {
                break;
            }
        }
    }
    
    private boolean a(final q q) {
        final bu graph2D = this.b.getGraph2D();
        if (graph2D != null) {
            final a autoBoundsFeature = graph2D.t(q).getAutoBoundsFeature();
            return autoBoundsFeature != null && autoBoundsFeature.isAutoBoundsEnabled();
        }
        return true;
    }
    
    public double e() {
        return this.d;
    }
    
    public void a(final double d) {
        this.d = d;
    }
    
    public void f() {
        this.b();
        if (this.b != null) {
            this.b.removeDrawable(this.d());
        }
        this.c = Collections.EMPTY_LIST;
        this.k = t.c;
    }
    
    protected void g() {
        this.c().addDrawable(this.d());
    }
    
    public void h() {
        this.c = Collections.EMPTY_LIST;
    }
    
    public void i() {
        this.h.clear();
    }
    
    public void a(final gy gy) {
        this.h.add(gy);
    }
    
    protected List j() {
        return this.h;
    }
    
    public void a(final t k) {
        this.k = k;
    }
    
    public t k() {
        return this.k;
    }
    
    static Color a(final e e) {
        return e.j;
    }
    
    static List b(final e e) {
        return e.c;
    }
    
    static boolean c(final e e) {
        return e.i;
    }
    
    static t d(final e e) {
        return e.k;
    }
    
    static double e(final e e) {
        return e.e;
    }
    
    static double f(final e e) {
        return e.f;
    }
}
