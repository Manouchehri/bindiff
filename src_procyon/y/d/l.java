package y.d;

import y.c.*;

class l implements j
{
    D[] a;
    p b;
    final double c;
    final double d;
    final double e;
    final int f;
    
    l(final double c, final double d, final int n) {
        final boolean d2 = t.d;
        this.a = new D[n];
        int i = 0;
        while (i < this.a.length) {
            this.a[i] = new D();
            ++i;
            if (d2) {
                return;
            }
            if (d2) {
                break;
            }
        }
        this.c = c;
        this.d = d;
        this.e = d - c + 1.0;
        this.f = this.a.length / 2;
    }
    
    public void a(final h h) {
        final boolean d = t.d;
        int i = 0;
        double c = this.c;
        double d2 = this.d;
        while (true) {
            while (i < this.f) {
                final double n = 0.5 * (d2 - c);
                final h h2 = h;
                if (d) {
                    h2.e = this.a[i].b(h);
                    return;
                }
                if (h.b < n) {
                    i = (i << 1) + 1;
                    d2 = n;
                    if (!d) {
                        continue;
                    }
                }
                if (h.a <= n) {
                    break;
                }
                i = (i << 1) + 2;
                c = n;
                if (d) {
                    break;
                }
            }
            if (this.b != null) {
                final p b = (p)this.b.c();
                this.b.a(h);
                this.a[i].a(this.b);
                h.e = this.b;
                this.b = b;
                if (!d) {
                    return;
                }
            }
            final h h2 = h;
            continue;
        }
    }
    
    public void b(final h h) {
        final boolean d = t.d;
        int i = 0;
        double c = this.c;
        double d2 = this.d;
        while (true) {
            while (i < this.f) {
                final double n = 0.5 * (d2 - c);
                final h h2 = h;
                if (d) {
                    h2.e.a(this.b);
                    this.b = h.e;
                    return;
                }
                if (h.b < n) {
                    i = (i << 1) + 1;
                    d2 = n;
                    if (!d) {
                        continue;
                    }
                }
                if (h.a <= n) {
                    break;
                }
                i = (i << 1) + 2;
                c = n;
                if (d) {
                    break;
                }
            }
            this.a[i].h(h.e);
            final h h2 = h;
            continue;
        }
    }
    
    void a(final h h, final g g, final int n, final double n2, final double n3) {
        final boolean d = t.d;
        final double n4 = 0.5 * (n3 - n2);
        final Object d2 = h.d;
        Label_0345: {
            if (n < this.f) {
                Label_0142: {
                    if (h.b < n4) {
                        p p5 = this.a[n].k();
                        while (true) {
                            while (p5 != null) {
                                final h h2 = (h)p5.c();
                                if (!d) {
                                    if (h2.b >= h.a && h2.a <= h.b) {
                                        g.a(d2, h2.d);
                                    }
                                    p5 = p5.a();
                                    if (d) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (d) {
                                        break Label_0142;
                                    }
                                    return;
                                }
                            }
                            this.a(h, g, (n << 1) + 1, n2, n4);
                            continue;
                        }
                    }
                }
                Label_0254: {
                    if (h.a > n4) {
                        p p6 = this.a[n].k();
                        while (true) {
                            while (p6 != null) {
                                final h h3 = (h)p6.c();
                                if (!d) {
                                    if (h3.b >= h.a && h3.a <= h.b) {
                                        g.a(d2, h3.d);
                                    }
                                    p6 = p6.a();
                                    if (d) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (d) {
                                        break Label_0254;
                                    }
                                    return;
                                }
                            }
                            this.a(h, g, (n << 1) + 2, n4, n3);
                            continue;
                        }
                    }
                }
                p p7 = this.a[n].k();
                while (true) {
                    while (p7 != null) {
                        g.a(d2, ((h)p7.c()).d);
                        p7 = p7.a();
                        if (!d) {
                            if (d) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (d) {
                                break Label_0345;
                            }
                            return;
                        }
                    }
                    this.a(h, g, (n << 1) + 1, n2, n4);
                    this.a(h, g, (n << 1) + 2, n4, n3);
                    continue;
                }
            }
        }
        p p8 = this.a[n].k();
        while (p8 != null) {
            final h h4 = (h)p8.c();
            if (h4.b >= h.a && h4.a <= h.b) {
                g.a(d2, h4.d);
            }
            p8 = p8.a();
            if (d) {
                break;
            }
        }
    }
    
    public void a(final h h, final g g) {
        this.a(h, g, 0, this.c, this.d);
    }
}
