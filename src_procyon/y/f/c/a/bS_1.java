package y.f.c.a;

import y.g.*;
import y.f.*;
import y.c.*;

class bS
{
    static void a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        final A a = M.a();
        int i = 0;
    Label_0096_Outer:
        while (i < au.b()) {
            final x a2 = au.a(i).d().a();
            while (true) {
                while (a2.f()) {
                    a.a(a2.e(), i);
                    a2.g();
                    if (!x2) {
                        if (x2) {
                            break;
                        }
                        continue Label_0096_Outer;
                    }
                    else {
                        if (x2) {
                            break Label_0096_Outer;
                        }
                        continue Label_0096_Outer;
                    }
                }
                ++i;
                continue;
            }
        }
        final aE a3 = aE.a((byte)2);
        final aE a4 = aE.a((byte)1);
        final e p4 = x.p();
        while (p4.f()) {
            final d a5 = p4.a();
            final y.f.c.a.A a6 = av.a(a5);
            if (!a5.e() && a(a5, a)) {
                if (a6.c() == null || a6.c().g()) {
                    ap.a(a5, true, a3);
                }
                if (a6.e() == null || a6.e().g()) {
                    ap.a(a5, false, a4);
                }
            }
            p4.g();
            if (x2) {
                break;
            }
        }
    }
    
    private static boolean a(final d d, final A a) {
        return a.a(d.c()) > a.a(d.d());
    }
}
