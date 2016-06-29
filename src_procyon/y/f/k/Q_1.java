package y.f.k;

import y.d.*;
import java.util.*;
import y.c.*;
import y.f.*;

class Q
{
    private q a;
    private X b;
    
    Q(final q a, final X b) {
        this.a = a;
        this.b = b;
    }
    
    void a(final A a, byte b, final double n, final F f) {
        final int g = d.g;
        final y.c.d g2 = this.a.g();
        if (g2 == null) {
            return;
        }
        final c c = this.b.c(U.a);
        if (c == null) {
            return;
        }
        final S[] array = (S[])c.b(g2);
        if (array == null) {
            return;
        }
        if (array.length == 0) {
            return;
        }
        if (array.length == 1 && array[0].b() == 0.0) {
            return;
        }
        if (b < 0) {
            aE ae = aE.e(this.b, g2);
            if (ae == null) {
                ae = aE.a((byte)0);
            }
            Label_0189: {
                switch (ae.b()) {
                    default: {
                        b = 0;
                        if (g != 0) {
                            break Label_0189;
                        }
                        break;
                    }
                    case 4: {
                        b = 1;
                        if (g != 0) {
                            break Label_0189;
                        }
                        break;
                    }
                    case 2: {
                        b = 2;
                        if (g != 0) {
                            break Label_0189;
                        }
                        break;
                    }
                    case 8: {
                        b = 3;
                        break;
                    }
                }
            }
        }
        double b2 = a.b();
        double c2 = a.c();
        final double n2 = b2;
        final double n3 = c2;
        final am a2 = this.b.a((Object)this.a);
        final y a3 = this.a(g2, b);
        final D d = new D();
        int i = 0;
        while (true) {
            while (i < array.length) {
                f.a(this.b, array[i], a3);
                d.add(new y.f.k.S(array[i], i, null));
                ++i;
                if (g != 0) {
                    final Iterator iterator = d.iterator();
                    while (iterator.hasNext()) {
                        final S a4 = iterator.next().a;
                        final boolean b3 = !iterator.hasNext();
                        final double b4 = a4.b();
                        final double c3 = a4.c();
                        final double max = Math.max(0.0, a4.f().h());
                        final int a5 = this.a(a4, a3);
                        double n4 = 0.0;
                        double n5 = 0.0;
                        Label_0690: {
                            switch (b) {
                                default: {
                                    throw new IllegalStateException("Should not reach");
                                }
                                case 0: {
                                    n4 = a.f() - c3 - n;
                                    Label_0503: {
                                        if (a5 == 3) {
                                            n5 = b2 - b4 - max;
                                            if (g == 0) {
                                                break Label_0503;
                                            }
                                        }
                                        if (a5 == 2) {
                                            n5 = b2 + max;
                                            if (g == 0) {
                                                break Label_0503;
                                            }
                                        }
                                        n5 = b2 - b4 * 0.5;
                                    }
                                    c2 = a.f() - c3 - n;
                                    a.a(b2, c2);
                                    if (g != 0) {
                                        break Label_0690;
                                    }
                                    break;
                                }
                                case 1: {
                                    n5 = a.g() + n;
                                    Label_0584: {
                                        if (a5 == 0) {
                                            n4 = c2 - c3 - max;
                                            if (g == 0) {
                                                break Label_0584;
                                            }
                                        }
                                        if (a5 == 1) {
                                            n4 = c2 + max;
                                            if (g == 0) {
                                                break Label_0584;
                                            }
                                        }
                                        n4 = c2 - c3 * 0.5;
                                    }
                                    b2 = a.g() + b4 + n;
                                    a.a(b2, c2);
                                    if (g != 0) {
                                        break Label_0690;
                                    }
                                    break;
                                }
                                case 2: {
                                    n4 = a.h() + n;
                                    Label_0666: {
                                        if (a5 == 2) {
                                            n5 = b2 + max;
                                            if (g == 0) {
                                                break Label_0666;
                                            }
                                        }
                                        if (a5 == 3) {
                                            n5 = b2 - b4 - max;
                                            if (g == 0) {
                                                break Label_0666;
                                            }
                                        }
                                        n5 = b2 - b4 * 0.5;
                                    }
                                    c2 = a.h() + c3 + n;
                                    a.a(b2, c2);
                                    if (g != 0) {
                                        break Label_0690;
                                    }
                                    break;
                                }
                                case 3: {
                                    n5 = a.e() - b4 - n;
                                    Label_0750: {
                                        if (a5 == 1) {
                                            n4 = c2 + max;
                                            if (g == 0) {
                                                break Label_0750;
                                            }
                                        }
                                        if (a5 == 0) {
                                            n4 = c2 - c3 - max;
                                            if (g == 0) {
                                                break Label_0750;
                                            }
                                        }
                                        n4 = c2 - c3 * 0.5;
                                    }
                                    b2 = a.e() - b4 - n;
                                    a.a(b2, c2);
                                    break;
                                }
                            }
                        }
                        a4.a(n5 - a2.getX(), n4 - a2.getY());
                        final n n6 = new n(a4.a());
                        n6.d(a2.getX(), a2.getY());
                        a.a(n6);
                        if (b3) {
                            double n7 = 0.0;
                            double n8 = 0.0;
                            if (g != 0) {
                                return;
                            }
                            Label_0905: {
                                switch (b) {
                                    case 0: {
                                        n8 = -n;
                                        if (g != 0) {
                                            break Label_0905;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        n7 = n;
                                        if (g != 0) {
                                            break Label_0905;
                                        }
                                        break;
                                    }
                                    case 2: {
                                        n8 = n;
                                        if (g != 0) {
                                            break Label_0905;
                                        }
                                        break;
                                    }
                                    case 3: {
                                        n7 = -n;
                                        break;
                                    }
                                }
                            }
                            n6.d(n7, n8);
                            a.a(n6);
                            b2 += n7;
                            c2 += n8;
                            if (g != 0) {
                                break;
                            }
                            continue;
                        }
                    }
                    a.a(n2, n3, b2, c2);
                    return;
                }
                if (g != 0) {
                    break;
                }
            }
            d.o();
            continue;
        }
    }
    
    private y a(final y.c.d d, final byte b) {
        final boolean b2 = ((h)this.b.c(x.q)).b(d) != null;
        switch (b) {
            case 0: {
                return b2 ? y.a : y.c;
            }
            case 1: {
                return b2 ? y.b : y.d;
            }
            case 2: {
                return b2 ? y.c : y.a;
            }
            case 3: {
                return b2 ? y.d : y.b;
            }
            default: {
                throw new IllegalStateException("Unknown node placer direction " + b);
            }
        }
    }
    
    private int a(final S s, final y y) {
        final aG f = s.f();
        if (!f.m()) {
            final boolean b = y == y.d || y == y.b;
            final boolean b2 = y == y.a || y == y.c;
            if ((f.u() && y == y.a && f.l()) || (f.u() && y == y.c && f.n()) || (f.v() && b2 && f.l()) || (f.w() && b2 && f.l())) {
                return 3;
            }
            if ((f.u() && y == y.a && f.n()) || (f.u() && y == y.c && f.l()) || (f.v() && b2 && f.n()) || (f.w() && b2 && f.n())) {
                return 2;
            }
            if ((f.u() && y == y.d && f.n()) || (f.u() && y == y.b && f.l()) || (f.v() && b && f.l()) || (f.w() && b && f.n())) {
                return 0;
            }
            if ((f.u() && y == y.d && f.l()) || (f.u() && y == y.b && f.n()) || (f.v() && b && f.n()) || (f.w() && b && f.l())) {
                return 1;
            }
        }
        return 4;
    }
    
    void a(final A a) {
        final int g = d.g;
        final am a2 = this.b.a((Object)this.a);
        final c c = this.b.c(U.b);
        if (c != null) {
            final S[] array = (S[])c.b(this.a);
            if (array != null) {
                final double n = a2.getX() + a2.getWidth() / 2.0;
                final double n2 = a2.getY() + a2.getHeight() / 2.0;
                int i = 0;
                while (i < array.length) {
                    final y.d.y h = array[i].a().h();
                    a.b(h.c + n, h.d + n2, h.a, h.b);
                    ++i;
                    if (g != 0) {
                        break;
                    }
                }
            }
        }
    }
}
