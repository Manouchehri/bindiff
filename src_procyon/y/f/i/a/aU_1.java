package y.f.i.a;

import y.f.*;
import y.d.*;
import java.util.*;
import y.c.*;

class aU
{
    private X a;
    private d b;
    private List[] c;
    private List[] d;
    private bl[] e;
    private HashMap f;
    private HashMap g;
    
    aU(final d b) {
        this.a = (X)b.a();
        this.b = b;
        this.c = new List[2];
        this.d = new List[2];
        this.e = new bl[2];
        this.c(true);
        this.c(false);
        this.a();
    }
    
    private void c(final boolean b) {
        final int a = ab.a;
        final int n = b ? 0 : 1;
        final D d = new D();
        final c c = this.a.c(b ? ax.a : ax.b);
        if (c != null) {
            final List list = (List)c.b(this.b);
            if (list != null) {
                d.addAll(list);
            }
        }
        final aE ae = b ? aE.d(this.a, this.b) : aE.e(this.a, this.b);
        if (ae != null) {
            d.add(this.a(ae, b));
        }
        final bl a2 = bl.a(b ? this.b.c() : this.b.d());
        this.e[n] = a2;
        List a3 = null;
        Label_0251: {
            if (d.isEmpty() && a2 == null) {
                a3 = null;
                if (a == 0) {
                    break Label_0251;
                }
            }
            if (d.isEmpty()) {
                a3 = a2.a();
                if (a == 0) {
                    break Label_0251;
                }
            }
            if (a2 == null) {
                a3 = d;
                if (a == 0) {
                    break Label_0251;
                }
            }
            d.removeAll(a2.b());
            a3 = d;
        }
        this.c[n] = a3;
        this.d[n] = this.a(a3);
    }
    
    private ax a(final aE ae, final boolean b) {
        final int n = ae.g() ? 255 : ae.b();
        if (ae.a()) {
            final t t = b ? this.a.n(this.b) : this.a.o(this.b);
            return ax.a(t.a(), t.b(), n);
        }
        return ax.b(n);
    }
    
    public List a(final List list) {
        final int a = ab.a;
        final D d = new D();
        D d2 = null;
        if (list != null) {
            for (final ax ax : list) {
                if (ax.b()) {
                    d2 = d;
                    if (a != 0) {
                        break;
                    }
                    d2.add(ax);
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
        }
        return d2;
    }
    
    public List a(final List list, final R r, final R r2, final boolean b) {
        final int a = ab.a;
        final D d = new D();
        D d2 = null;
        if (list != null) {
            for (final ax ax : list) {
                if (a(b ? r : r2, b ? r2 : r, ax)) {
                    d2 = d;
                    if (a != 0) {
                        break;
                    }
                    d2.add(ax);
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
        }
        return d2;
    }
    
    public List a(final U u, final boolean b) {
        final int b2 = u.b();
        final f a = u.a(b ? 0 : (b2 - 2));
        final f a2 = u.a(b ? 1 : (b2 - 1));
        return this.a(a.a(), a2.a(), a2.c(), b);
    }
    
    public List a(final R r, final R r2, final P p4, final boolean b) {
        final int a = ab.a;
        final int n = b ? 0 : 1;
        if (this.c[n] == null) {
            return Collections.EMPTY_LIST;
        }
        final List a2 = this.a(this.c[n], r, r2, b);
        if (a2.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        final D d = new D();
        final M e = p4.e();
        for (final ax ax : a2) {
            if (!ax.b()) {
                d.add(ax);
                if (a == 0) {
                    continue;
                }
            }
            final t a3 = this.a(ax, b);
            final double n2 = p4.a() ? a3.b() : a3.a();
            if (e.d() == 0.0 && e.a() == n2) {
                d.add(ax);
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        return d;
    }
    
    private void a() {
        final int a = ab.a;
        final List list = this.d[0];
        final List list2 = this.d[1];
        if (list != null) {
            this.f = new HashMap(list.size());
            for (final ax ax : list) {
                this.f.put(ax, a(ax, this.b.c()));
                if (a != 0) {
                    return;
                }
                if (a != 0) {
                    break;
                }
            }
        }
        if (list2 != null) {
            this.g = new HashMap(list2.size());
            for (final ax ax2 : list2) {
                this.g.put(ax2, a(ax2, this.b.d()));
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    public List a(final boolean b) {
        return this.c[!b];
    }
    
    public List b(final boolean b) {
        return this.d[!b];
    }
    
    public t a(final ax ax, final boolean b) {
        if (b && this.f != null) {
            return this.f.get(ax);
        }
        if (!b && this.g != null) {
            return this.g.get(ax);
        }
        return null;
    }
    
    public void b(final U u, final boolean b) {
        final int a = ab.a;
        final bl bl = this.e[!b];
        if (bl != null) {
            final Iterator<ax> iterator = (Iterator<ax>)this.a(u, b).iterator();
            while (iterator.hasNext()) {
                bl.a(iterator.next());
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    private static boolean a(final R r, final R r2, final ax ax) {
        if (ax.a() == 1) {
            return r.i() == r2.k();
        }
        if (ax.a() == 2) {
            return r.k() == r2.i();
        }
        if (ax.a() == 4) {
            return r.j() == r2.h();
        }
        return ax.a() != 8 || r.h() == r2.j();
    }
    
    private static t a(final ax ax, final q q) {
        final t l = ((X)q.e()).l(q);
        return new t(l.a() + ax.c(), l.b() + ax.d());
    }
}
