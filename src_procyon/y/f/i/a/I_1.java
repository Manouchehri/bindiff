package y.f.i.a;

import y.d.*;
import y.f.*;
import java.awt.geom.*;
import java.util.*;
import y.c.*;

public class I implements Q, l, m
{
    private final O a;
    private final List b;
    private final HashMap c;
    private final D d;
    private Z e;
    private double f;
    
    public I(final O a) {
        this.a = a;
        this.d = new D();
        this.b = new ArrayList();
        this.c = new HashMap();
    }
    
    public void a(final m m) {
        this.b.add(m);
    }
    
    public void b(final m m) {
        this.b.remove(m);
    }
    
    public void a(final Z e) {
        final int a = ab.a;
        this.e = e;
        this.f = this.c();
        if (this.a instanceof l) {
            ((l)this.a).a(this);
        }
        int i = 0;
        while (true) {
            while (i < this.b.size()) {
                final I j = this;
                if (a != 0) {
                    this.a.a(this.d, j.a(e.a(), this.d));
                    return;
                }
                if (this.b.get(i) instanceof J) {
                    ((J)this.b.get(i)).a(e, this);
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            final I j = this;
            continue;
        }
    }
    
    y a(final X x, final List list) {
        final int a = ab.a;
        final Rectangle2D a2 = ae.a(x, x.o());
        final Iterator<N> iterator = list.iterator();
        y a3 = null;
        while (iterator.hasNext()) {
            a3 = iterator.next().a();
            if (a != 0) {
                return a3;
            }
            final y y = a3;
            Rectangle2D.union(a2, new Rectangle2D.Double(y.c(), y.d(), y.a(), y.b()), a2);
            if (a != 0) {
                break;
            }
        }
        final y y2 = new y(a2.getX() - 100.0, a2.getY() - 100.0, a2.getWidth() + 200.0, a2.getHeight() + 200.0);
        return a3;
    }
    
    public List c(final R r) {
        return this.a.c(r);
    }
    
    public List d(final R r) {
        final int a = ab.a;
        final List d = this.a.d(r);
        if (d == null) {
            return Collections.EMPTY_LIST;
        }
        final ArrayList<Object> list = new ArrayList<Object>();
        ArrayList<Object> list2 = null;
        for (final N n : d) {
            if (n.b() instanceof q) {
                list2 = list;
                if (a != 0) {
                    return list2;
                }
                list2.add(n.b());
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        return list2;
    }
    
    public List e(final R r) {
        return this.a.d(r);
    }
    
    public List a(final q q) {
        final N n = this.c.get(q);
        if (n != null) {
            return this.a.a(n);
        }
        throw new IllegalArgumentException("Unknown node");
    }
    
    public List a(final y y) {
        return this.a.a(y);
    }
    
    public y b() {
        return this.a.b();
    }
    
    public void a() {
        final int a = ab.a;
        int i = 0;
        while (true) {
            while (i < this.b.size()) {
                final boolean b = this.b.get(i) instanceof J;
                if (a != 0) {
                    if (b) {
                        ((l)this.a).b(this);
                    }
                    this.e = null;
                    this.c.clear();
                    this.d.clear();
                    this.a.a();
                    return;
                }
                if (b) {
                    ((J)this.b.get(i)).a();
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            final boolean b2 = this.a instanceof l;
            continue;
        }
    }
    
    public void a(final R r, final List list) {
        final int a = ab.a;
        int i = this.b.size() - 1;
        while (i >= 0) {
            ((m)this.b.get(i)).a(r, list);
            --i;
            if (a != 0) {
                break;
            }
        }
    }
    
    public void b(final R r) {
        final int a = ab.a;
        int i = this.b.size() - 1;
        while (i >= 0) {
            ((m)this.b.get(i)).b(r);
            --i;
            if (a != 0) {
                break;
            }
        }
    }
    
    public void a(final R r) {
        final int a = ab.a;
        r.a(new bc(r, this.f, this.e.c().k()));
        int i = this.b.size() - 1;
        while (i >= 0) {
            ((m)this.b.get(i)).a(r);
            --i;
            if (a != 0) {
                break;
            }
        }
    }
    
    private double c() {
        final int a = ab.a;
        double n = 0.0;
        final y.f.i.a.y c = this.e.c();
        final e a2 = this.e.a().E().a();
        double max = 0.0;
        while (a2.f()) {
            max = Math.max(n, c.a(a2.a()).c());
            if (a != 0) {
                return max;
            }
            n = max;
            a2.g();
            if (a != 0) {
                break;
            }
        }
        return max;
    }
    
    public N a(final y y, final Object o) {
        final N n = new N(y, o);
        this.c.put(o, n);
        this.d.add(n);
        return n;
    }
}
