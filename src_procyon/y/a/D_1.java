package y.a;

import y.g.*;
import y.c.*;
import java.util.*;

class D
{
    private int a;
    private A b;
    private int c;
    private boolean d;
    
    D() {
        this.a(0);
        this.b(10);
        this.a(false);
    }
    
    private void b(final i i, final y y, final h h) {
        final boolean a = h.a;
        final Random random = new Random(1234L);
        final A a2 = M.a(new boolean[i.e()]);
        x x = y.a();
        while (true) {
            while (x.f()) {
                a2.a(x.e(), true);
                x.g();
                if (a) {
                    do {
                        x.f();
                        boolean d = false;
                    Label_0089:
                        while (d) {
                            d d2 = x.e().g();
                            while (d2 != null) {
                                d = a2.d(d2.c());
                                if (a) {
                                    continue Label_0089;
                                }
                                if (d) {
                                    h.a(d2, random.nextDouble());
                                }
                                d2 = d2.h();
                                if (a) {
                                    break;
                                }
                            }
                            d d3 = x.e().f();
                            while (d3 != null) {
                                final boolean d4 = a2.d(d3.d());
                                if (a) {
                                    continue Label_0089;
                                }
                                if (d4) {
                                    h.a(d3, random.nextDouble());
                                }
                                d3 = d3.g();
                                if (a) {
                                    break;
                                }
                            }
                            x.g();
                            continue Label_0082;
                        }
                        break;
                    } while (!a);
                    return;
                }
                if (a) {
                    break;
                }
            }
            x = y.a();
            continue;
        }
    }
    
    private void c(final i i, final y y, final h h) {
        final boolean a = h.a;
        final E[] array = new E[i.e()];
        this.a(y, h, 0.0);
        final x a2 = this.a(y).a();
    Label_0586:
        do {
            a2.f();
            boolean b = false;
        Label_0038:
            while (b) {
                final q e = a2.e();
                Label_0579: {
                    if (this.a(e)) {
                        final y y2 = new y();
                        final x a3 = y.a();
                        while (a3.f()) {
                            final q e2 = a3.e();
                            array[e2.d()] = new E(e2);
                            a3.g();
                            if (a) {
                                continue Label_0586;
                            }
                            if (a) {
                                break;
                            }
                        }
                        final y y3 = new y();
                        y3.add(e);
                        final E e3 = array[e.d()];
                        E.a(e3, 1.0);
                        E.a(e3, 0);
                    Label_0377:
                        while (true) {
                            Label_0372: {
                                boolean b3;
                                while (true) {
                                    y3.isEmpty();
                                    boolean b2 = false;
                                Label_0176:
                                    while (!b2) {
                                        final q d = y3.d();
                                        y2.a(d);
                                        final E e4 = array[d.d()];
                                        final e j = d.j();
                                        while (j.f()) {
                                            final d a4 = j.a();
                                            final q a5 = a4.a(d);
                                            b2 = (b3 = this.a(a5));
                                            if (a) {
                                                break Label_0377;
                                            }
                                            if (a) {
                                                continue Label_0176;
                                            }
                                            if (b2) {
                                                final E e5 = array[a5.d()];
                                                if (E.a(e5) < 0) {
                                                    E.a(e5, E.a(e4) + 1);
                                                    if (this.a() != 2 || E.a(e5) <= this.b()) {
                                                        y3.add(e5.a());
                                                    }
                                                }
                                                if (E.a(e5) == E.a(e4) + 1) {
                                                    E.b(e5, E.b(e4));
                                                    E.c(e5).add(a4);
                                                }
                                            }
                                            j.g();
                                            if (a) {
                                                break Label_0372;
                                            }
                                        }
                                        continue Label_0377;
                                    }
                                    break Label_0372;
                                }
                                while (!b3) {
                                    final q d2 = y2.d();
                                    final E e6 = array[d2.d()];
                                    final e a6 = E.c(e6).a();
                                    while (a6.f()) {
                                        final d a7 = a6.a();
                                        final E e7 = array[a7.a(d2).d()];
                                        b = (b3 = this.c());
                                        if (a) {
                                            continue Label_0038;
                                        }
                                        if (a) {
                                            continue Label_0377;
                                        }
                                        Label_0567: {
                                            if (b) {
                                                final double n = E.d(e6) + 1.0;
                                                E.c(e7, n);
                                                h.a(a7, h.c(a7) + n * E.b(e7));
                                                if (!a) {
                                                    break Label_0567;
                                                }
                                            }
                                            final double n2 = (E.b(e6) > 0.0) ? ((E.d(e6) + 1.0) * E.b(e7) / E.b(e6)) : 0.0;
                                            E.c(e7, n2);
                                            h.a(a7, h.c(a7) + n2);
                                        }
                                        a6.g();
                                        if (a) {
                                            break Label_0579;
                                        }
                                    }
                                    break Label_0372;
                                }
                                break Label_0579;
                            }
                            boolean b3 = y2.isEmpty();
                            continue Label_0377;
                        }
                    }
                }
                a2.g();
                continue Label_0586;
            }
            break;
        } while (!a);
    }
    
    protected boolean a(final q q) {
        return this.b == null || this.b.a(q) > 0;
    }
    
    protected y a(final y y) {
        final boolean a = y.a.h.a;
        if (this.a() == 1) {
            final Random random = new Random(1234L);
            final y y2 = new y();
            final ArrayList list = new ArrayList<Object>(y);
            final int min = Math.min(y.size(), (int)Math.round(Math.log(y.size()) / Math.log(2.0) * 10.0));
            int i = 0;
            y y3 = null;
            while (i < min) {
                final int nextInt = random.nextInt(list.size());
                y3 = y2;
                if (a) {
                    return y3;
                }
                y3.add(list.get(nextInt));
                Label_0162: {
                    if (nextInt == list.size() - 1) {
                        list.remove(list.size() - 1);
                        if (!a) {
                            break Label_0162;
                        }
                    }
                    list.set(nextInt, list.remove(list.size() - 1));
                }
                ++i;
                if (a) {
                    break;
                }
            }
            return y3;
        }
        return y;
    }
    
    void a(final i i, final y y, final h h) {
        if (i.h() == 0 || y.isEmpty()) {
            return;
        }
        if (this.a() == 3) {
            this.b(i, y, h);
            if (!h.a) {
                return;
            }
        }
        this.c(i, y, h);
    }
    
    void a(final i i, final y y, final A b, final h h) {
        if (i.g() == 0 || y.isEmpty()) {
            return;
        }
        this.b = b;
        this.a(i, y, h);
        this.b = null;
    }
    
    void a(final int c) {
        final boolean a = y.a.h.a;
        Label_0044: {
            switch (this.c = c) {
                default: {
                    if (a) {
                        break Label_0044;
                    }
                }
                case 1: {
                    if (a) {
                        return;
                    }
                }
                case 2: {}
                case 3: {}
            }
        }
    }
    
    int a() {
        return this.c;
    }
    
    int b() {
        return this.a;
    }
    
    void b(final int a) {
        if (a > 1) {
            this.a = a;
            if (!y.a.h.a) {
                return;
            }
        }
        throw new IllegalArgumentException("Maximum path length must be greater than 1.");
    }
    
    boolean c() {
        return this.d;
    }
    
    void a(final boolean d) {
        this.d = d;
    }
    
    protected void a(final y y, final h h, final double n) {
        final boolean a = h.a;
        final x a2 = y.a();
        do {
            Label_0011: {
                a2.f();
            }
            boolean a3 = false;
            Label_0018:
            while (a3) {
                final q e = a2.e();
                if (this.a(e)) {
                    d d = e.f();
                    while (d != null) {
                        a3 = this.a(d.a(e));
                        if (a) {
                            continue Label_0018;
                        }
                        if (a3) {
                            h.a(d, n);
                        }
                        d = d.g();
                        if (a) {
                            break;
                        }
                    }
                    d d2 = e.g();
                    while (d2 != null) {
                        final boolean a4 = this.a(d2.a(e));
                        if (a) {
                            continue Label_0018;
                        }
                        if (a4) {
                            h.a(d2, n);
                        }
                        d2 = d2.h();
                        if (a) {
                            break;
                        }
                    }
                }
                a2.g();
                continue Label_0011;
            }
            break;
        } while (!a);
    }
}
