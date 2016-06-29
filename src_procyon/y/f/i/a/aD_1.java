package y.f.i.a;

import y.c.*;
import java.util.*;
import y.d.*;
import y.f.*;

class aD extends K
{
    public void a(final Z z, final I i) {
        final int a = ab.a;
        super.a(z, i);
        final X a2 = z.a();
        final c c = a2.c(ay.a);
        final c c2 = a2.c(ax.a);
        final c c3 = a2.c(ax.b);
        if (a2.c(aF.a) == null && a2.c(aF.b) == null && c == null && c2 == null && c3 == null) {
            return;
        }
        final e p2 = a2.p();
    Label_0740:
        while (true) {
            p2.f();
            boolean a3 = false;
        Label_0620_Outer:
            while (a3) {
                final d a4 = p2.a();
                final q c4 = a4.c();
                final q d = a4.d();
                final D d2 = new D();
                final D d3 = new D();
                Label_0498: {
                    if (this.a(a2, a4)) {
                        final aE d4 = aE.d(a2, a4);
                        if (d4 != null) {
                            d2.add(this.a(d4, a2, a4, true));
                        }
                        final aE e = aE.e(a2, a4);
                        if (e == null) {
                            break Label_0498;
                        }
                        d3.add(this.a(e, a2, a4, false));
                        if (a == 0) {
                            break Label_0498;
                        }
                    }
                    if (this.b(a2, a4)) {
                        if (c2 != null && c2.b(a4) != null) {
                            final List list = (List)c2.b(a4);
                            if (!list.isEmpty()) {
                                d2.addAll(list);
                            }
                        }
                        if (c3 == null || c3.b(a4) == null) {
                            break Label_0498;
                        }
                        final List list2 = (List)c3.b(a4);
                        if (list2.isEmpty()) {
                            break Label_0498;
                        }
                        d3.addAll(list2);
                        if (a == 0) {
                            break Label_0498;
                        }
                    }
                    if (this.c(a2, a4)) {
                        if (c != null && c.b(c4) != null) {
                            final Iterator a5 = ((ay)c.b(c4)).a();
                            while (a5.hasNext()) {
                                d2.add(a5.next().a());
                                if (a != 0) {
                                    break Label_0498;
                                }
                                if (a != 0) {
                                    break;
                                }
                            }
                        }
                        if (c != null && c.b(d) != null) {
                            final Iterator a6 = ((ay)c.b(d)).a();
                            while (a6.hasNext()) {
                                d3.add(a6.next().a());
                                if (a != 0) {
                                    continue Label_0740;
                                }
                                if (a != 0) {
                                    break;
                                }
                            }
                        }
                    }
                }
                Iterator iterator = d2.iterator();
                while (true) {
                    while (iterator.hasNext()) {
                        final ax ax = iterator.next();
                        if (ax.b()) {
                            final boolean a7 = this.a(a2, c4, ax);
                            if (a == 0) {
                                if (!a7) {
                                    continue Label_0620_Outer;
                                }
                                final t a8 = a(ax, c4);
                                this.b().a(new y(a8.a() - 0.5, a8.b() - 0.5, 1.0, 1.0), new y.f.i.a.aF(null));
                                if (a != 0) {
                                    break;
                                }
                                continue Label_0620_Outer;
                            }
                            else {
                            Label_0728:
                                while (true) {
                                    if (a7) {
                                        final ax ax2 = iterator.next();
                                        if (ax2.b()) {
                                            a3 = this.a(a2, d, ax2);
                                            if (a != 0) {
                                                continue Label_0620_Outer;
                                            }
                                            if (a3) {
                                                final t a9 = a(ax2, d);
                                                this.b().a(new y(a9.a() - 0.5, a9.b() - 0.5, 1.0, 1.0), new y.f.i.a.aF(null));
                                                if (a != 0) {
                                                    break Label_0728;
                                                }
                                            }
                                        }
                                        iterator.hasNext();
                                        continue Label_0620_Outer;
                                    }
                                    break;
                                }
                                p2.g();
                                if (a != 0) {
                                    break Label_0740;
                                }
                                continue Label_0740;
                            }
                        }
                    }
                    iterator = d3.iterator();
                    continue;
                }
            }
            break;
        }
    }
    
    private boolean a(final X x, final d d) {
        return aE.a(x, d);
    }
    
    private boolean b(final X x, final d d) {
        final c c = x.c(ax.a);
        final c c2 = x.c(ax.b);
        return (c != null && c.b(d) != null) || (c2 != null && c2.b(d) != null);
    }
    
    private boolean c(final X x, final d d) {
        final c c = x.c(ay.a);
        return c != null && (c.b(d.c()) != null || c.b(d.d()) != null);
    }
    
    static t a(final ax ax, final q q) {
        final t l = ((X)q.e()).l(q);
        return new t(l.a() + ax.c(), l.b() + ax.d());
    }
    
    private boolean a(final X x, final q q, final ax ax) {
        final am a = x.a((Object)q);
        final y y = new y(a.getX() - 1.0E-6, a.getY() - 1.0E-6, a.getWidth() + 2.0E-6, a.getHeight() + 2.0E-6);
        final t l = x.l(q);
        final t t = new t(l.a() + ax.c(), l.b() + ax.d());
        return !y.d.y.a(y.c(), y.d(), y.a(), y.b(), t.a(), t.b(), true);
    }
    
    private ax a(final aE ae, final X x, final d d, final boolean b) {
        final t t = b ? x.n(d) : x.o(d);
        if (ae.a()) {
            return ax.a(t.a(), t.b(), ae.b());
        }
        return ax.a(ae);
    }
}
