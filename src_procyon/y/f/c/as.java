package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;
import y.d.*;
import y.f.*;

class as implements Comparator, g
{
    private q a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private c g;
    private final ap h;
    
    as(final ap h, final c g) {
        this.h = h;
        this.g = g;
    }
    
    void a(final q a, final int n) {
        this.a = a;
        this.d = this.g.a(this.a);
        this.b = n / 3;
        this.f = (n > 3 && n < 11);
        this.c = (this.f ? 2 : 0);
        Label_0139: {
            switch (n) {
                case 0:
                case 3:
                case 5:
                case 8: {
                    this.e = false;
                    if (a.i) {
                        break Label_0139;
                    }
                    break;
                }
                case 2:
                case 6:
                case 9:
                case 11: {
                    this.e = true;
                    break;
                }
            }
        }
    }
    
    public int compare(Object o, Object o2) {
        final boolean i = y.f.c.a.i;
        if (this.e) {
            final Object o3 = o2;
            o2 = o;
            o = o3;
        }
        final d d = (d)o;
        final d d2 = (d)o2;
        q q = null;
        int n = 0;
        t t = null;
        boolean b = false;
        Label_0171: {
            if (d.c() == this.a) {
                q = d.d();
                n = x.a(this.h.b(d).b(), this.c);
                t = ap.a(this.h).o(d);
                b = false;
                if (!i) {
                    break Label_0171;
                }
            }
            q = d.c();
            n = x.a(this.h.a(d).b(), this.c);
            t = ap.a(this.h).n(d);
            b = ((this.b ^ n) == 0x2 && (this.b | n) == 0x2);
        }
        q q2 = null;
        t t2 = null;
        int n2 = 0;
        boolean b3 = false;
        Label_0312: {
            if (d2.c() == this.a) {
                q2 = d2.d();
                final aE b2 = this.h.b(d2);
                t2 = ap.a(this.h).o(d2);
                n2 = x.a(b2.b(), this.c);
                b3 = false;
                if (!i) {
                    break Label_0312;
                }
            }
            q2 = d2.c();
            n2 = x.a(this.h.a(d2).b(), this.c);
            t2 = ap.a(this.h).n(d2);
            b3 = ((this.b ^ n2) == 0x2 && (this.b | n2) == 0x2);
        }
        int a = this.g.a(q);
        int a2 = this.g.a(q2);
        if (y.g.e.a(a2, a) == 0) {
            if (b3 != b) {
                return (b ^ this.e) ? -1 : 1;
            }
            if (a > this.d) {
                if (this.f) {
                    final int n3 = 1;
                    if (!i) {
                        return this.a(n3, n, n2, this.f, t, t2);
                    }
                }
                final int n3 = 2;
                if (!i) {
                    return this.a(n3, n, n2, this.f, t, t2);
                }
            }
            if (this.f) {
                final int n3 = 3;
                if (!i) {
                    return this.a(n3, n, n2, this.f, t, t2);
                }
            }
            final int n3 = 3;
            return this.a(n3, n, n2, this.f, t, t2);
        }
        else {
            if (b3 == b) {
                Label_0506: {
                    if (a < this.d) {
                        a = this.d - a;
                        if (!i) {
                            break Label_0506;
                        }
                    }
                    a = Integer.MAX_VALUE - a;
                }
                if (a2 < this.d) {
                    a2 = this.d - a2;
                    if (!i) {
                        return y.g.e.a(a, a2);
                    }
                }
                a2 = Integer.MAX_VALUE - a2;
                return y.g.e.a(a, a2);
            }
            if (b ^ this.e) {
                return -1;
            }
            return 1;
        }
    }
    
    private int a(final int n, int n2, int n3, final boolean b, final t t, final t t2) {
        final boolean i = y.f.c.a.i;
        if (b) {
            if (n2 > n) {
                n2 -= 4;
            }
            if (n3 > n) {
                n3 -= 4;
            }
            final int a = y.g.e.a(n2, n3);
            if (a == 0) {
                Label_0108: {
                    switch (4 + n2 & 0x3) {
                        case 0: {
                            final int n4 = y.g.e.a(t2.a, t.a);
                            if (i) {
                                break Label_0108;
                            }
                            return -n4;
                        }
                        case 1: {
                            final int n4 = y.g.e.a(t2.b, t.b);
                            if (i) {
                                break Label_0108;
                            }
                            return -n4;
                        }
                        case 2: {
                            final int n4 = y.g.e.a(t.a, t2.a);
                            if (i) {
                                break;
                            }
                            return -n4;
                        }
                    }
                }
                final int n4 = y.g.e.a(t.b, t2.b);
                return -n4;
            }
            return a;
        }
        else {
            if (n2 < n) {
                n2 += 4;
            }
            if (n3 < n) {
                n3 += 4;
            }
            final int a2 = y.g.e.a(n3, n2);
            if (a2 == 0) {
                Label_0248: {
                    switch (4 + n2 & 0x3) {
                        case 0: {
                            final int n5 = y.g.e.a(t2.a, t.a);
                            if (i) {
                                break Label_0248;
                            }
                            return n5;
                        }
                        case 1: {
                            final int n5 = y.g.e.a(t2.b, t.b);
                            if (i) {
                                break Label_0248;
                            }
                            return n5;
                        }
                        case 2: {
                            final int n5 = y.g.e.a(t.a, t2.a);
                            if (i) {
                                break;
                            }
                            return n5;
                        }
                    }
                }
                return y.g.e.a(t.b, t2.b);
            }
            return a2;
        }
    }
}
