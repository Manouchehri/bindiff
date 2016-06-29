package y.f.i;

import y.d.*;
import y.c.*;
import y.f.*;

public class ac extends a
{
    public void c(final X x) {
        final int f = v.f;
        final x o = x.o();
        while (o.f()) {
            final q e;
            final q q = e = o.e();
        Label_0027:
            while (true) {
                q c = null;
                final e j = c.j();
                while (j.f()) {
                    final d a = j.a();
                    final D m = x.m(a);
                    c = a.c();
                    if (f != 0) {
                        continue Label_0027;
                    }
                    if (c == q) {
                        final p b = m.b(0);
                        final t t = (t)b.c();
                        final am a2 = x.a((Object)q);
                        if (t.b() < a2.getY() || t.b() > a2.getY() + a2.getHeight() || t.a() < a2.getX() || t.a() > a2.getX() + a2.getWidth()) {
                            this.a(a2, b);
                        }
                    }
                    if (a.d() == q) {
                        final p b2 = m.b(m.size() - 1);
                        final t t2 = (t)b2.c();
                        final am a3 = x.a((Object)q);
                        if (t2.b() < a3.getY() || t2.b() > a3.getY() + a3.getHeight() || t2.a() < a3.getX() || t2.a() > a3.getX() + a3.getWidth()) {
                            this.a(a3, b2);
                        }
                    }
                    x.a(a, m);
                    j.g();
                    if (f != 0) {
                        break;
                    }
                }
                break;
            }
            o.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void a(final am am, final p p2) {
        t t = (t)p2.c();
        if (t.b() < am.getY()) {
            t = new t(t.a, am.getY());
            p2.a(t);
        }
        if (t.a() < am.getX()) {
            t = new t(am.getX(), t.b);
            p2.a(t);
        }
        if (t.b() > am.getY() + am.getHeight()) {
            t = new t(t.a, am.getY() + am.getHeight());
            p2.a(t);
        }
        if (t.a() > am.getX() + am.getWidth()) {
            p2.a(new t(am.getX() + am.getWidth(), t.b));
        }
    }
}
