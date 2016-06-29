package y.f.d;

import java.util.*;
import y.c.*;
import y.d.*;
import y.f.*;

class s
{
    private static final am a;
    private static final n[] b;
    
    static D a(final X x, final q q, final aj aj, final al al, final boolean b) {
        final int f = y.f.d.a.f;
        final D d = new D();
        final am a = x.a((Object)q);
        final al a2 = aj.a();
        final Object o = (aj.getModelParameter() == null) ? a2.c() : aj.getModelParameter();
        final n n = (a2 == null) ? aj.getOrientedBox() : a2.a(aj.getOrientedBox().d(), a, o);
        D d2 = null;
        if (b) {
            d.add(new ai(n, o, aj, false));
            if (f == 0) {
                return d2;
            }
        }
        Label_0229: {
            if (al != null && al != a2) {
                final C m = a(x, q, a(aj.getOrientedBox(), al, al.a(n, a)), al).m();
                while (m.f()) {
                    final ai ai = (ai)m.d();
                    d2 = d;
                    if (f != 0) {
                        break;
                    }
                    d2.add(a(ai, aj, a2, a));
                    m.g();
                    if (f != 0) {
                        break Label_0229;
                    }
                }
                return d2;
            }
        }
        d.addAll(a(x, q, aj, a2));
        return d2;
    }
    
    private static D a(final X x, final q q, final aj aj) {
        return a(x, q, aj, 4.0);
    }
    
    private static D a(final X x, final q q, final aj aj, final al al) {
        final am a = x.a((Object)q);
        if (al == null || a(al)) {
            return a(x, q, aj);
        }
        return al.a(aj, a);
    }
    
    private static D a(final X x, final q q, final aj aj, final double n) {
        final int f = y.f.d.a.f;
        final D d = new D();
        final n orientedBox = aj.getOrientedBox();
        final y box = aj.getBox();
        final al a = aj.a();
        final am a2 = x.a((Object)q);
        final y s = x.s(q);
        int n2 = Math.min((int)Math.max(3.0, s.b / box.b), a(x));
        double n3 = (s.b - box.b) / (n2 - 1);
        final double n4 = s.c() - n - box.a;
        final double n5 = s.c() + s.a + n;
        double d2 = s.d();
        int i = 0;
        while (true) {
            while (i < n2) {
                final t t = new t(n4, d2);
                final n n6 = new n(orientedBox);
                n6.e(t.a() + box.a() * 0.5, t.b() + box.b() * 0.5);
                d.add(new ai(n6, a.a(n6, a2), aj, false));
                final t t2 = new t(n5, d2);
                final n n7 = new n(orientedBox);
                n7.e(t2.a() + box.a() * 0.5, t2.b() + box.b() * 0.5);
                d.add(new ai(n7, a.a(n7, a2), aj, false));
                d2 += n3;
                ++i;
                if (f != 0) {
                    final double n8 = s.d() - n - box.b;
                    final double n9 = s.d() + s.b + n;
                    double n10 = s.c() - box.a;
                    int j = 0;
                    D d3 = null;
                    while (j < n2) {
                        final t t3 = new t(n10, n8);
                        final n n11 = new n(orientedBox);
                        n11.e(t3.a() + box.a() * 0.5, t3.b() + box.b() * 0.5);
                        d.add(new ai(n11, a.a(n11, a2), aj, false));
                        final t t4 = new t(n10, n9);
                        final n n12 = new n(orientedBox);
                        n12.e(t4.a() + box.a() * 0.5, t4.b() + box.b() * 0.5);
                        final ai ai = new ai(n12, a.a(n12, a2), aj, false);
                        d3 = d;
                        if (f != 0) {
                            return d3;
                        }
                        d3.add(ai);
                        n10 += n3;
                        ++j;
                        if (f != 0) {
                            break;
                        }
                    }
                    return d3;
                }
                if (f != 0) {
                    break;
                }
            }
            n2 = Math.min((int)Math.max(3.0, s.a / box.a + 2.0), 15);
            n3 = (s.a + box.a) / (n2 - 1);
            continue;
        }
    }
    
    private static ai a(final ai ai, final aj aj, final al al, final am am) {
        final Object a = al.a(ai.d(), am);
        return new ai(al.a(ai.d().d(), am, a), a, aj, false);
    }
    
    private static aj a(final n n, final al al, final Object modelParameter) {
        final ak ak = new ak();
        ak.a(al);
        ak.setModelParameter(modelParameter);
        ak.a(n);
        return ak;
    }
    
    private static boolean a(final al al) {
        final int f = y.f.d.a.f;
        if (al instanceof M) {
            return true;
        }
        int i = 0;
        boolean a = false;
        while (i < s.b.length) {
            a = n.a(s.b[i], al.a(s.b[i].d(), s.a, al.a(s.b[i], s.a)), 1.0);
            if (f != 0) {
                return a;
            }
            if (!a) {
                return false;
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        return a;
    }
    
    private static int a(final X x) {
        int n = 15;
        if (x.f() > 100) {
            n = 10;
            if (y.f.d.a.f == 0) {
                return n;
            }
        }
        if (x.f() > 500) {
            n = 5;
        }
        return n;
    }
    
    static {
        a = new x(0.0, 0.0, 30.0, 30.0);
        b = new n[] { new n(15.0, 5.0, 30.0, 10.0, 1.0, 0.0), new n(-15.0, -15.0, 100.0, 30.0, 0.5, 0.5), new n(50.0, 90.0, 40.0, 15.0, 0.0, -1.0) };
    }
}
