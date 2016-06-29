package y.f.f.c;

import y.f.f.b.*;
import y.g.*;
import y.a.*;
import y.c.*;

public class k implements l
{
    public void a(final h h, final p p3, final p p4) {
        o.a(this, 3, "SSP Compaction");
        o.a(this, 3, "Vertical: ");
        this.a(p3);
        o.a(this, 3, "Horizontal: ");
        this.a(p4);
    }
    
    public void a(final p p) {
        final int a = g.a;
        final i f = p.f();
        final A t = f.t();
        final int[] array = new int[f.e()];
        m.a(f, array);
        final q[] array2 = new q[f.f()];
        final x o = f.o();
        while (o.f()) {
            final q e = o.e();
            t.a(e, 0.0);
            array2[array[e.d()]] = e;
            o.g();
            if (a != 0) {
                break;
            }
        }
        int n = 0;
        Label_0349: {
        Block_4:
            while (true) {
                double n2 = n;
            Label_0103:
                while (n2 < array2.length) {
                    final q q = array2[n];
                    final double c = t.c(q);
                    p.b(q).a((int)c);
                    if (a != 0) {
                        return;
                    }
                    if (c > 100000.0) {
                        break Block_4;
                    }
                    final g b = p.b(q);
                    final y.f.f.c.o a2 = p.a(b);
                    if (a2 != null && a2.b() == b) {
                        final q a3 = a2.a().a();
                        if (t.c(a3) < c - a2.c()) {
                            t.a(a3, c - a2.c());
                            n = array[a3.d()];
                            if (a == 0) {
                                continue Label_0349;
                            }
                        }
                    }
                    final e l = q.l();
                    while (l.f()) {
                        final d a4 = l.a();
                        final double b2 = p.b(a4);
                        final double n3 = n2 = dcmpl(c + b2, t.c(a4.d()));
                        if (a != 0) {
                            continue Label_0103;
                        }
                        if (n3 > 0) {
                            t.a(a4.d(), c + b2);
                        }
                        l.g();
                        if (a != 0) {
                            break;
                        }
                    }
                    ++n;
                    if (a != 0) {
                        break;
                    }
                    continue Label_0349;
                }
                break Label_0349;
            }
            throw new RuntimeException("Compaction did not terminate ...");
        }
        f.a(t);
    }
}
