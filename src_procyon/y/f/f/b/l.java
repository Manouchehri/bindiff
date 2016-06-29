package y.f.f.b;

import y.f.h.*;
import y.c.*;

public class l
{
    h a;
    i b;
    
    public void a(final h a, final c c) {
        final int a2 = h.a;
        this.a = a;
        this.b = a.a();
        final q c2 = a.c();
    Label_0185_Outer:
        while (c2.f()) {
            d d = null;
            final p a3 = c2.a();
            final e a4 = a3.a();
            int n = 0;
            int n2 = 0;
            int n3 = 0;
            int a5 = 0;
            while (true) {
                while (a4.f()) {
                    final d a6 = a4.a();
                    final int a7 = a6.c().a();
                    final int n4 = 4;
                    if (a2 == 0) {
                        Label_0167: {
                            if (a7 == n4) {
                                ++n;
                                if (a2 == 0) {
                                    break Label_0167;
                                }
                            }
                            if (a6.c().a() == 6) {
                                ++n2;
                                if (d != null) {
                                    break Label_0167;
                                }
                                d = a6;
                                a5 = 6;
                                if (a2 == 0) {
                                    break Label_0167;
                                }
                            }
                            if (a6.c().a() > a5) {
                                d = a6;
                                a5 = a6.c().a();
                            }
                        }
                        ++n3;
                        a4.g();
                        if (a2 != 0) {
                            break;
                        }
                        continue Label_0185_Outer;
                    }
                    else {
                        Label_0564: {
                            if ((a7 > n4 && n > 0) || n2 > 0) {
                                final d[] array = new d[n3];
                                int n5 = 0;
                                int n6 = 0;
                                final e a8 = a3.a();
                                Label_0262: {
                                    if (d != null) {
                                        while (a8.a() != d) {
                                            a8.b();
                                            if (a2 != 0) {
                                                break Label_0262;
                                            }
                                            if (a2 != 0) {
                                                break;
                                            }
                                        }
                                    }
                                    a8.c();
                                }
                                p b = a.b(a.a(a8.a()));
                                a8.b();
                                int i = 0;
                                while (i < n3) {
                                    final d a9 = a8.a();
                                    final int a10 = a9.c().a();
                                    final p b2 = a.b(a.a(a9));
                                    if (a2 != 0) {
                                        break Label_0564;
                                    }
                                    final boolean b3 = c != null && c.d(a9);
                                    final int n7 = a.d(a9) - 2;
                                    final boolean b4 = n7 < -1 || n7 > 1;
                                    if (b2 != b || b3 || b4) {
                                        if (n5 > 0) {
                                            this.a(c, array, n5, n6, a3, b);
                                        }
                                        n5 = 0;
                                        n6 = 0;
                                        b = b2;
                                    }
                                    Label_0519: {
                                        if (!b4 && (n5 == 0 || a10 == 4 || a10 == 6) && !b3) {
                                            if (n5 > 0) {
                                                n6 += n7;
                                            }
                                            array[n5++] = a9;
                                            if (a2 == 0) {
                                                break Label_0519;
                                            }
                                        }
                                        if (n5 > 0) {
                                            this.a(c, array, n5, n6, a3, b);
                                        }
                                        n5 = 0;
                                        n6 = 0;
                                        b = b2;
                                    }
                                    a8.b();
                                    ++i;
                                    if (a2 != 0) {
                                        break;
                                    }
                                }
                                if (n5 > 0) {
                                    this.a(c, array, n5, n6, a3, b);
                                }
                            }
                            c2.g();
                        }
                        if (a2 != 0) {
                            break Label_0185_Outer;
                        }
                        continue Label_0185_Outer;
                    }
                }
                continue;
            }
        }
        final x o = this.b.o();
        while (o.f()) {
            final y.c.q e = o.e();
            if (e.a() == 4) {
                final d f = e.f();
                final d h = e.h();
                if (a.b(f) == a.b(h)) {
                    a.a(f, 2);
                    a.a(h, 2);
                }
            }
            o.g();
            if (a2 != 0) {
                break;
            }
        }
    }
    
    private final void a(final c c, final d[] array, final int n, int i, final p p6, final p p7) {
        final int a = h.a;
        if (n <= 1) {
            return;
        }
        final d d = array[0];
        d d2 = (d.i() == null) ? d.c().h() : d.i();
        if (this.a.b(d2) != p7 && d.c().a() == 6) {
            d2 = ((d2.i() == null) ? d2.c().h() : d2.i());
        }
        Label_0272: {
            if (this.a.b(d2) == p7) {
                while (true) {
                    while (i < 0) {
                        final int d3 = this.a.d(d);
                        final int n2 = 1;
                        if (a == 0) {
                            if (d3 <= n2 || this.a.d(d2) >= 3) {
                                break;
                            }
                            ++i;
                            this.a.a(d, this.a.d(d) - 1);
                            this.a.a(d2, this.a.d(d2) + 1);
                            if (a != 0) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (d3 <= n2 || this.a.d(d) >= 3) {
                                break Label_0272;
                            }
                            --i;
                            this.a.a(d, this.a.d(d) + 1);
                            this.a.a(d2, this.a.d(d2) - 1);
                            if (a != 0) {
                                break Label_0272;
                            }
                            break;
                        }
                    }
                    if (i > 0) {
                        this.a.d(d2);
                        continue;
                    }
                    break;
                }
            }
        }
        final d d4 = array[n - 1];
        final y.c.q d5 = d4.d();
        final d a2 = this.a.a(d4);
        d d6 = d5.f();
    Label_0460_Outer:
        while (true) {
            while (true) {
            Label_0524:
                while (true) {
                    while (this.a.b(d6) != p6) {
                        d6 = d6.g();
                        if (a == 0) {
                            if (a != 0) {
                                break;
                            }
                            continue Label_0460_Outer;
                        }
                        else {
                            final int n3 = 1;
                            int j = n3;
                            while (j < n) {
                                final y.c.q c2 = array[j].c();
                                final d d7 = array[j];
                                if (a != 0) {
                                    return;
                                }
                                final d d8 = (d7.i() == null) ? c2.h() : d7.i();
                                if (this.a.b(d8) != p7) {
                                    throw new IllegalStateException("Wrong face!");
                                }
                                final int d9 = this.a.d(d7);
                                int n4 = 0;
                                Label_0663: {
                                    if (i < 0) {
                                        ++i;
                                        n4 = 1;
                                        if (a == 0) {
                                            break Label_0663;
                                        }
                                    }
                                    if (i > 0) {
                                        if (c2.a() == 4) {
                                            --i;
                                            n4 = 3;
                                            if (a == 0) {
                                                break Label_0663;
                                            }
                                        }
                                        n4 = 2;
                                        if (a == 0) {
                                            break Label_0663;
                                        }
                                    }
                                    n4 = 2;
                                }
                                final int n5 = n4 - d9;
                                Label_0876: {
                                    if (n5 != 0) {
                                        final int d10 = this.a.d(d8);
                                        if (d10 - n5 >= 1 && d10 - n5 < 4) {
                                            this.a.a(d8, d10 - n5);
                                            this.a.a(d7, d9 + n5);
                                            if (a == 0) {
                                                break Label_0876;
                                            }
                                        }
                                        if (c2.a() != 6) {
                                            throw new IllegalStateException("Incompatible degree!");
                                        }
                                        final d d11 = (d8.i() == null) ? c2.h() : d8.i();
                                        if (this.a.b(d11) != p7) {
                                            throw new IllegalStateException("Wrong face!");
                                        }
                                        final int d12 = this.a.d(d11);
                                        if (d12 - n5 >= 1 && d12 - n5 < 4) {
                                            this.a.a(d11, d12 - n5);
                                            this.a.a(d7, d9 + n5);
                                            if (a == 0) {
                                                break Label_0876;
                                            }
                                        }
                                        throw new IllegalStateException("Could not assign new angle!");
                                    }
                                }
                                ++j;
                                if (a != 0) {
                                    break;
                                }
                            }
                            if (i != 0) {
                                throw new IllegalStateException("Could not compensate directions changes.");
                            }
                            return;
                        }
                    }
                    if (d6 == d4 || this.a.b(a2) != p7) {
                        continue Label_0524;
                    }
                    while (i < 0) {
                        final int d13 = this.a.d(d6);
                        final int n6 = 1;
                        if (a == 0) {
                            if (d13 <= n6 || this.a.d(a2) >= 3) {
                                break;
                            }
                            ++i;
                            this.a.a(d6, this.a.d(d6) - 1);
                            this.a.a(a2, this.a.d(a2) + 1);
                            if (a != 0) {
                                break;
                            }
                            continue Label_0460_Outer;
                        }
                        else {
                            if (d13 <= n6 || this.a.d(d6) >= 3) {
                                continue Label_0524;
                            }
                            --i;
                            this.a.a(d6, this.a.d(d6) + 1);
                            this.a.a(a2, this.a.d(a2) - 1);
                            if (a != 0) {
                                continue Label_0524;
                            }
                            break;
                        }
                    }
                    if (i <= 0) {
                        continue Label_0524;
                    }
                    break;
                }
                final int d14;
                final int n3 = d14 = this.a.d(a2);
                if (a == 0) {
                    continue;
                }
                break;
            }
            continue Label_0460_Outer;
        }
    }
}
