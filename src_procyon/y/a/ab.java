package y.a;

import y.g.*;
import java.util.*;
import y.c.*;

class ab
{
    private y a;
    private p[] b;
    private List c;
    private int d;
    private int[] e;
    private int[] f;
    private int[] g;
    private int h;
    private c i;
    
    public int a(final i i, final int[] e, final int[] f, final long n) {
        final boolean a = y.a.h.a;
        final long currentTimeMillis = System.currentTimeMillis();
        this.b = new p[i.e()];
        this.a = new y();
        this.e = e;
        this.f = f;
        this.g = new int[i.e()];
        this.h = 0;
        this.i = new c(this.b.length);
        this.c = new ArrayList(i.e() * 2);
        this.d = 0;
        final q k = i.k();
        final int d = k.d();
        this.i.b(k);
        this.b[d] = this.a.a(k);
        while (!this.i.e() && System.currentTimeMillis() - currentTimeMillis < n) {
            this.b();
            if (this.a.size() + this.d < i.e()) {
                this.a();
                if (a) {
                    break;
                }
                continue;
            }
        }
        int n2 = 0;
        int j = this.c.size() - 1;
        while (true) {
            while (j >= 0) {
                final Object value = this.c.get(j);
                final int n4;
                final int n3 = n4 = ((value instanceof Integer) ? 1 : 0);
                if (a) {
                    int max = n4;
                    int l = this.e.length - 1;
                    while (true) {
                        while (l >= 0) {
                            j = Math.min(j, this.e[l]);
                            max = Math.max(max, this.e[l]);
                            --l;
                            if (a) {
                                while (l >= 0) {
                                    e[l] -= j;
                                    --l;
                                    if (a) {
                                        return max - j + 1;
                                    }
                                    if (a) {
                                        break;
                                    }
                                }
                                this.b = null;
                                this.a = null;
                                this.c = null;
                                this.f = null;
                                this.i = null;
                                this.e = null;
                                return max - j + 1;
                            }
                            if (a) {
                                break;
                            }
                        }
                        l = e.length - 1;
                        continue;
                    }
                }
                Label_0270: {
                    if (n3 != 0) {
                        n2 += (int)value;
                        if (!a) {
                            break Label_0270;
                        }
                    }
                    final int[] e2 = this.e;
                    final int d2 = ((q)value).d();
                    e2[d2] += n2;
                }
                --j;
                if (a) {
                    break;
                }
            }
            j = Integer.MAX_VALUE;
            int n4 = 0;
            continue;
        }
    }
    
    private void a() {
        final boolean a = y.a.h.a;
        ++this.h;
        int n = Integer.MAX_VALUE;
        int n2 = 1;
        p k = this.a.k();
    Label_0508_Outer:
        while (true) {
            while (true) {
            Label_0492_Outer:
                while (k != null) {
                    final q q = (q)k.c();
                    boolean b = true;
                    if (!a) {
                        d d = q.g();
                    Label_0492:
                        while (true) {
                            while (d != null) {
                                final q c = d.c();
                                final p p = this.b[c.d()];
                                if (!a) {
                                    Label_0234: {
                                        if (p == null) {
                                            b = false;
                                            final int n3 = this.e[q.d()] - this.e[c.d()] - this.f[d.b()];
                                            if (n3 > 0) {
                                                if (n3 < n) {
                                                    n = n3;
                                                    this.i.c();
                                                    ++this.h;
                                                    this.i.a(c);
                                                    this.g[c.d()] = this.h;
                                                    n2 = 1;
                                                    if (!a) {
                                                        break Label_0234;
                                                    }
                                                }
                                                if (n2 != 0 && n3 == n && this.g[c.d()] < this.h) {
                                                    this.i.a(c);
                                                    this.g[c.d()] = this.h;
                                                }
                                            }
                                        }
                                    }
                                    d = d.h();
                                    if (a) {
                                        break;
                                    }
                                    continue Label_0492_Outer;
                                }
                                else {
                                    k = p;
                                    if (a) {
                                        break Label_0492_Outer;
                                    }
                                    continue Label_0508_Outer;
                                }
                            }
                            d d2 = q.f();
                            while (d2 != null) {
                                final q d3 = d2.d();
                                final p p2 = this.b[d3.d()];
                                if (a) {
                                    continue Label_0492;
                                }
                                Label_0431: {
                                    if (p2 == null) {
                                        b = false;
                                        final int n4 = this.e[d3.d()] - this.e[q.d()] - this.f[d2.b()];
                                        if (n4 > 0) {
                                            if (n4 < n) {
                                                n = n4;
                                                this.i.c();
                                                ++this.h;
                                                this.i.a(d3);
                                                this.g[d3.d()] = this.h;
                                                n2 = 0;
                                                if (!a) {
                                                    break Label_0431;
                                                }
                                            }
                                            if (n2 == 0 && n4 == n && this.g[d3.d()] < this.h) {
                                                this.i.a(d3);
                                                this.g[d3.d()] = this.h;
                                            }
                                        }
                                    }
                                }
                                d2 = d2.g();
                                if (a) {
                                    break;
                                }
                            }
                            if (b) {
                                this.c.add(q);
                                ++this.d;
                                this.a.h(this.b[q.d()]);
                            }
                            k.a();
                            continue Label_0492;
                        }
                    }
                    final int n5 = n;
                    final int n6 = n5;
                    this.c.add(new Integer(n6));
                    p p3 = this.a.k();
                    while (true) {
                        while (p3 != null) {
                            final ab ab = this;
                            if (a) {
                                int i = ab.i.d();
                                while (i > 0) {
                                    final q q2 = (q)this.i.a();
                                    this.b[q2.d()] = this.a.a(q2);
                                    this.i.a(q2);
                                    --i;
                                    if (a) {
                                        break;
                                    }
                                }
                                return;
                            }
                            final int[] e = this.e;
                            final int d4 = ((q)p3.c()).d();
                            e[d4] += n6;
                            p3 = p3.a();
                            if (a) {
                                break;
                            }
                        }
                        final ab ab = this;
                        continue;
                    }
                }
                if (n2 != 0) {
                    final int n5 = -n;
                    continue;
                }
                break;
            }
            continue Label_0508_Outer;
        }
    }
    
    private void b() {
        final boolean a = y.a.h.a;
        while (!this.i.e()) {
            boolean b = true;
            Object a2 = this.i.a();
            q q = null;
            int d = 0;
        Label_0024:
            while (true) {
                q = (q)a2;
                d = q.d();
                d d2 = q.f();
                while (d2 != null) {
                    final q d3 = d2.d();
                    final p p = (p)(a2 = this.b[d3.d()]);
                    if (a) {
                        continue Label_0024;
                    }
                    Label_0139: {
                        if (p == null) {
                            if (this.e[d3.d()] - this.e[d] - this.f[d2.b()] == 0) {
                                this.i.a(d3);
                                this.b[d3.d()] = this.a.a(d3);
                                if (!a) {
                                    break Label_0139;
                                }
                            }
                            b = false;
                        }
                    }
                    d2 = d2.g();
                    if (a) {
                        break;
                    }
                }
                d d4 = q.g();
                while (d4 != null) {
                    final q c = d4.c();
                    final p p2 = (p)(a2 = this.b[c.d()]);
                    if (a) {
                        continue Label_0024;
                    }
                    Label_0257: {
                        if (p2 == null) {
                            if (this.e[d] - this.e[c.d()] - this.f[d4.b()] == 0) {
                                this.i.a(c);
                                this.b[c.d()] = this.a.a(c);
                                if (!a) {
                                    break Label_0257;
                                }
                            }
                            b = false;
                        }
                    }
                    d4 = d4.h();
                    if (a) {
                        break;
                    }
                }
                break;
            }
            if (b) {
                this.c.add(q);
                ++this.d;
                this.a.h(this.b[d]);
                if (a) {
                    break;
                }
                continue;
            }
        }
    }
}
