package y.f.c.a;

import y.f.*;
import y.f.b.*;
import y.d.*;
import y.c.*;

public class bM implements z
{
    private double a;
    private double b;
    private double c;
    private double d;
    
    public bM() {
        this.a = 30.0;
        this.b = 15.0;
        this.c = 10.0;
        this.d = 15.0;
    }
    
    public double a(final X x, final aQ aq, final aV av, final q q, final q q2) {
        final boolean x2 = N.x;
        if (q == null || q2 == null) {
            return 0.0;
        }
        final aX a = av.a(q);
        final aX a2 = av.a(q2);
        final byte b = a.b();
        final byte b2 = a2.b();
        double n = 0.0;
        d d = null;
        int n2 = 0;
        Label_0384: {
            switch (b) {
                default: {
                    n2 = 0;
                    if (x2) {
                        break Label_0384;
                    }
                    break;
                }
                case 12: {
                    n2 = 4;
                    if (x2) {
                        break Label_0384;
                    }
                    break;
                }
                case 13: {
                    n2 = 5;
                    if (x2) {
                        break Label_0384;
                    }
                    break;
                }
                case 15: {
                    n2 = 6;
                    if (x2) {
                        break Label_0384;
                    }
                    break;
                }
                case 2: {
                    d = a.g();
                    Label_0263: {
                        if (a.f() == q2) {
                            final B k = av.a(d).k();
                            if (k != null) {
                                if (q.b() == 0 ^ av.a(d).i()) {
                                    n = k.a();
                                    if (!x2) {
                                        break Label_0263;
                                    }
                                }
                                n = k.b();
                            }
                        }
                    }
                    n2 = 1;
                    break;
                }
                case 3: {
                    final d g = a.g();
                    final B i = av.a(g).k();
                    if (i != null && a.f() == q2) {
                        if (g.c() == q2 ^ av.a(g).i()) {
                            n = i.a();
                            if (!x2) {
                                break Label_0384;
                            }
                        }
                        n = i.b();
                    }
                    break Label_0384;
                }
                case 1:
                case 8:
                case 9:
                case 10: {
                    d = a.g();
                }
                case 6:
                case 7: {
                    n2 = 1;
                    break;
                }
                case 4: {
                    n2 = 2;
                    if (x2) {
                        break Label_0384;
                    }
                    break;
                }
                case 11: {
                    n2 = 3;
                    break;
                }
            }
        }
        d d2 = null;
        int n3 = 0;
        Label_0716: {
            switch (b2) {
                default: {
                    n3 = 0;
                    if (x2) {
                        break Label_0716;
                    }
                    break;
                }
                case 13: {
                    n3 = 4;
                    if (x2) {
                        break Label_0716;
                    }
                    break;
                }
                case 12: {
                    n3 = 5;
                    if (x2) {
                        break Label_0716;
                    }
                    break;
                }
                case 15: {
                    n3 = 6;
                    if (x2) {
                        break Label_0716;
                    }
                    break;
                }
                case 2: {
                    d2 = a2.g();
                    Label_0595: {
                        if (a2.f() == q) {
                            final B j = av.a(d2).k();
                            if (j != null) {
                                if (q2.b() == 0 ^ av.a(d2).i()) {
                                    n = j.a();
                                    if (!x2) {
                                        break Label_0595;
                                    }
                                }
                                n = j.b();
                            }
                        }
                    }
                    n3 = 1;
                    break;
                }
                case 3: {
                    final d g2 = a2.g();
                    final B l = av.a(g2).k();
                    if (l != null && a2.f() == q) {
                        if (g2.c() == q ^ av.a(g2).i()) {
                            n = l.a();
                            if (!x2) {
                                break Label_0716;
                            }
                        }
                        n = l.b();
                    }
                    break Label_0716;
                }
                case 1:
                case 8:
                case 9:
                case 10: {
                    d2 = a2.g();
                }
                case 6:
                case 7: {
                    n3 = 1;
                    break;
                }
                case 4: {
                    n3 = 2;
                    if (x2) {
                        break Label_0716;
                    }
                    break;
                }
                case 11: {
                    n3 = 3;
                    break;
                }
            }
        }
        if (n2 == 4 && n3 == 4) {
            final c c = x.c(f.f);
            final c c2 = x.c(f.e);
            y.d.q q3 = null;
            if (c != null) {
                q3 = (y.d.q)c.b(a.l());
            }
            r a3 = null;
            if (c2 != null) {
                a3 = r.a(c2.b(a.l()));
            }
            return Math.max((q3 != null) ? q3.a : 0.0, (a3 != null) ? (a3.b + a3.d) : this.a);
        }
        if (n2 == 4 || n3 == 4) {
            final c c3 = x.c(f.e);
            if (c3 != null) {
                if (n2 == 4) {
                    final r a4 = r.a(c3.b(a.l()));
                    if (a4 != null) {
                        return a4.b;
                    }
                }
                if (n3 == 4) {
                    final r a5 = r.a(c3.b(a2.l()));
                    if (a5 != null) {
                        return a5.d;
                    }
                }
            }
        }
        if (n2 == 5 || n3 == 5) {
            aY ay = null;
            Label_1005: {
                if (n2 == 5) {
                    ay = av.a(a.l()).i();
                    if (!x2) {
                        break Label_1005;
                    }
                }
                ay = av.a(a2.l()).i();
            }
            final double n4 = (ay != null) ? ay.d() : 0.0;
            if (n3 == 1 || n2 == 1) {
                return Math.max(this.b, n4);
            }
            if (n3 == 2 || n3 == 1 || n3 == 0 || n2 == 0) {
                return Math.max(this.a, n4);
            }
        }
        if (n2 == 6 || n3 == 6) {
            if (n2 == 0 || n3 == 0) {
                return this.b;
            }
            return this.c;
        }
        else if (n2 == n3) {
            switch (n2) {
                default: {
                    return this.a;
                }
                case 1: {
                    double n5 = this.c;
                    if (d != null) {
                        final A a6 = av.a(d);
                        if (a6 != null) {
                            final B m = a6.k();
                            if (m != null) {
                                n5 = Math.max(n5, m.d());
                            }
                        }
                    }
                    if (d2 != null) {
                        final A a7 = av.a(d2);
                        if (a7 != null) {
                            final B k2 = a7.k();
                            if (k2 != null) {
                                n5 = Math.max(n5, k2.d());
                            }
                        }
                    }
                    return Math.max(n, n5);
                }
                case 2:
                case 3: {
                    return 0.0;
                }
            }
        }
        else {
            if (n2 == 3 && n3 == 3) {
                return this.d;
            }
            if (n2 == 2 || n3 == 2) {
                return 0.0;
            }
            double n6 = this.b;
            if (d != null) {
                final A a8 = av.a(d);
                if (a8 != null) {
                    final B k3 = a8.k();
                    if (k3 != null) {
                        n6 = Math.max(n6, k3.d());
                    }
                }
            }
            if (d2 != null) {
                final A a9 = av.a(d2);
                if (a9 != null) {
                    final B k4 = a9.k();
                    if (k4 != null) {
                        n6 = Math.max(n6, k4.d());
                    }
                }
            }
            return Math.max(n, n6);
        }
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public void b(final double b) {
        this.b = b;
    }
    
    public void c(final double c) {
        this.c = c;
    }
    
    public void b(final X x, final aU au, final aV av) {
    }
    
    public void a(final X x, final aU au, final aV av) {
    }
}
