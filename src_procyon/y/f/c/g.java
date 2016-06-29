package y.f.c;

import y.f.*;
import y.a.*;
import y.c.*;
import y.f.c.a.*;

public class g implements R, aT
{
    public static final Object a;
    
    public int a(final X x, final A a, final f f) {
        final boolean i = a.i;
        if (x.i()) {
            return 0;
        }
        final c c = x.c(g.a);
        final y y = new y();
        boolean d = false;
        Label_0108: {
            if (c != null) {
                final x o = x.o();
                while (o.f()) {
                    d = c.d(o.e());
                    if (i) {
                        break Label_0108;
                    }
                    if (d) {
                        y.add(o.e());
                    }
                    o.g();
                    if (i) {
                        break;
                    }
                }
            }
            y.isEmpty();
        }
        y[] array = null;
        Label_0237: {
            Label_0230: {
                if (d) {
                    final y[] a2 = h.a(x);
                    int j = 0;
                Label_0208_Outer:
                    while (j < a2.length) {
                        array = a2;
                        if (!i) {
                            final y y2 = array[j];
                            final x a3 = y2.a();
                            while (true) {
                                while (a3.f()) {
                                    final int b = a3.e().b();
                                    if (!i) {
                                        if (b == 0) {
                                            y.add(a3.e());
                                        }
                                        a3.g();
                                        if (i) {
                                            break;
                                        }
                                        continue Label_0208_Outer;
                                    }
                                    else {
                                        if (b == 0) {
                                            y.add(y2.b());
                                        }
                                        ++j;
                                        if (i) {
                                            break Label_0230;
                                        }
                                        continue Label_0208_Outer;
                                    }
                                }
                                continue;
                            }
                        }
                        break Label_0237;
                    }
                }
            }
            b.a(x, y, a);
        }
        final y[] array2 = array;
        f.clear();
        final e p3 = x.p();
        int a5 = 0;
        while (p3.f()) {
            final d a4 = p3.a();
            a5 = a.a(a4.c());
            if (i) {
                return a5;
            }
            if (a5 > a.a(a4.d())) {
                f.c(a4);
                x.c(a4);
            }
            p3.g();
            if (i) {
                break;
            }
        }
        final int length = array2.length;
        return a5;
    }
    
    public void a(final X x, final aU au, final aV av) {
        new ba(this).a(x, au, av);
    }
    
    static {
        a = new Object();
    }
}
