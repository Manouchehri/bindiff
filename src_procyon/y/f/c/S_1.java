package y.f.c;

import y.f.*;
import y.c.*;
import y.g.*;
import java.util.*;

public class S implements v
{
    protected v a;
    protected A b;
    private y c;
    private A d;
    private A e;
    
    public S(final v a) {
        this.a = a;
    }
    
    public void a(final X x, final y[] array, final c c) {
        if (c instanceof A) {
            this.e = (A)c;
            if (!y.f.c.a.i) {
                this.d = x.t();
                this.c = new y();
                this.a(x, array, this.e);
                this.a.a(x, array, this.e);
                this.b(x, array, this.e);
                if (this.e != c) {
                    throw new IllegalStateException("Expected NodeMap layerID!");
                }
                x.a(this.d);
                this.d = null;
                this.c = null;
                this.b = null;
                return;
            }
        }
        throw new IllegalStateException("Expected NodeMap layerID!");
    }
    
    public void a(final A b) {
        this.b = b;
        this.a.a(b);
    }
    
    public void a(final double n) {
        this.a.a(n);
    }
    
    public void d(final double n) {
        this.a.d(n);
    }
    
    public void b(final double n) {
        this.a.b(n);
    }
    
    public void c(final double n) {
        this.a.c(n);
    }
    
    protected void a(final X x, final y[] array, final A a) {
        final boolean i = a.i;
        final d[] array2 = new d[x.g()];
        final int[] array3 = new int[x.e()];
        int j = 0;
    Label_0104_Outer:
        while (j < array.length) {
            int n = 0;
            p p3 = array[j].k();
            while (true) {
                while (p3 != null) {
                    this.d.a(p3.c(), p3);
                    array3[((q)p3.c()).d()] = n;
                    p3 = p3.a();
                    ++n;
                    if (!i) {
                        if (i) {
                            break;
                        }
                        continue Label_0104_Outer;
                    }
                    else {
                        if (i) {
                            break Label_0104_Outer;
                        }
                        continue Label_0104_Outer;
                    }
                }
                ++j;
                continue;
            }
        }
        final T t = new T(this, array3);
        final U u = new U(this, array3);
        int n2 = 0;
        while (true) {
        Label_0504_Outer:
            do {
            Label_0485:
                while (true) {
                    Label_0808: {
                    Label_0504:
                        while (true) {
                        Label_0469:
                            while (true) {
                                final int n3 = array.length - 1;
                                int k = 0;
                                int n4 = 0;
                            Label_0142:
                                while (k < n4) {
                                    final y y = array[n2 + 1];
                                    final p l = array[n2].k();
                                    if (!i) {
                                        p a2 = l;
                                    Label_0258_Outer:
                                        while (a2 != null) {
                                            final q q = (q)a2.c();
                                            k = q.c();
                                            n4 = 1;
                                            if (i) {
                                                continue Label_0142;
                                            }
                                            Label_0457: {
                                                if (k > n4 && q.c() % 2 == 0) {
                                                    int n5 = 0;
                                                    d d = q.f();
                                                    while (true) {
                                                        while (d != null) {
                                                            array2[n5] = d;
                                                            d = d.g();
                                                            ++n5;
                                                            if (!i) {
                                                                if (i) {
                                                                    break;
                                                                }
                                                                continue Label_0258_Outer;
                                                            }
                                                            else {
                                                                final int n6 = q.c() / 2 - 1;
                                                                final d d2 = array2[n6];
                                                                p a3 = (p)this.d.b(array2[n6].d());
                                                                p b = (p)this.d.b(array2[n6 + 1].d());
                                                                if (a3 == b) {
                                                                    break Label_0457;
                                                                }
                                                                boolean b2 = true;
                                                                while (a3 != b) {
                                                                    final boolean b3 = b2;
                                                                    if (i) {
                                                                        continue Label_0485;
                                                                    }
                                                                    if (b3) {
                                                                        b2 = false;
                                                                        a3 = a3.a();
                                                                        if (!i) {
                                                                            continue Label_0258_Outer;
                                                                        }
                                                                    }
                                                                    b2 = true;
                                                                    b = b.b();
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                }
                                                                final q d3 = x.d();
                                                                this.c.add(am.a(d3, y));
                                                                this.d.a(d3, y.a(d3, a3));
                                                                a.a(d3, n2 + 1);
                                                                x.a(q, d2, d3, null, 0, 0);
                                                                x.b(d3, 0.0, 0.0);
                                                                break Label_0457;
                                                            }
                                                        }
                                                        y.g.e.a(array2, 0, n5, u);
                                                        continue Label_0504_Outer;
                                                    }
                                                }
                                            }
                                            a2 = a2.a();
                                            if (i) {
                                                break;
                                            }
                                        }
                                        break Label_0469;
                                    }
                                    break Label_0504;
                                }
                                break Label_0504_Outer;
                            }
                            ++n2;
                            continue Label_0504_Outer;
                            p l = null;
                            p a4 = l;
                            while (a4 != null) {
                                final q q2 = (q)a4.c();
                                final int b4 = q2.b();
                                final int n7 = 1;
                                if (i) {
                                    break Label_0485;
                                }
                                Label_0796: {
                                    if (b4 > n7 && q2.b() % 2 == 0) {
                                        int n8 = 0;
                                        d d4 = q2.g();
                                        while (true) {
                                            while (d4 != null) {
                                                array2[n8] = d4;
                                                d4 = d4.h();
                                                ++n8;
                                                if (!i) {
                                                    if (i) {
                                                        break;
                                                    }
                                                    continue Label_0504_Outer;
                                                }
                                                else {
                                                    final int n9 = q2.b() / 2 - 1;
                                                    final d d5 = array2[n9];
                                                    p a5 = (p)this.d.b(array2[n9].c());
                                                    p b5 = (p)this.d.b(array2[n9 + 1].c());
                                                    if (a5 == b5) {
                                                        break Label_0796;
                                                    }
                                                    boolean b6 = true;
                                                    while (a5 != b5) {
                                                        final boolean b7 = b6;
                                                        if (i) {
                                                            break Label_0485;
                                                        }
                                                        if (b7) {
                                                            b6 = false;
                                                            a5 = a5.a();
                                                            if (!i) {
                                                                continue Label_0504_Outer;
                                                            }
                                                        }
                                                        b6 = true;
                                                        b5 = b5.b();
                                                        if (i) {
                                                            break;
                                                        }
                                                    }
                                                    final q d6 = x.d();
                                                    final y y;
                                                    this.c.add(am.a(d6, y));
                                                    this.d.a(d6, y.a(d6, a5));
                                                    a.a(d6, n2 - 1);
                                                    x.a(d6, null, q2, d5, 0, 0);
                                                    x.b(d6, 0.0, 0.0);
                                                    break Label_0796;
                                                }
                                            }
                                            y.g.e.a(array2, 0, n8, t);
                                            continue;
                                        }
                                    }
                                }
                                a4 = a4.a();
                                if (i) {
                                    break;
                                }
                            }
                            break Label_0808;
                            int b4 = 0;
                            int n7 = 0;
                            if (b4 >= n7) {
                                final y y = array[n2 - 1];
                                array[n2].k();
                                continue Label_0504;
                            }
                            break;
                        }
                        return;
                    }
                    --n2;
                    if (!i) {
                        continue Label_0485;
                    }
                    break;
                }
                return;
            } while (!i);
            n2 = array.length - 1;
            continue;
        }
    }
    
    protected void b(final X x, final y[] array, final A a) {
        final boolean i = a.i;
        p p3 = this.c.k();
        while (p3 != null) {
            final am am = (am)p3.c();
            final q q = (q)am.a;
            ((y)am.b).h((p)this.d.b(q));
            x.a(q);
            p3 = p3.a();
            if (i) {
                break;
            }
        }
    }
}
