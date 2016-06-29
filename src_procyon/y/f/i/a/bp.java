package y.f.i.a;

import y.c.*;
import y.f.*;
import java.util.*;

class bp extends K
{
    boolean a;
    
    public void a(final Z z, final I i) {
        final int a = ab.a;
        super.a(z, i);
        final y c = z.c();
        if (!(this.a = c.j())) {
            return;
        }
        final X a2 = z.a();
        final e p2 = a2.p();
        while (p2.f()) {
            final d a3 = p2.a();
            Label_0149: {
                if (!c.a(a3, (i)a2)) {
                    final C[] d = a2.d((Object)a3);
                    int j = 0;
                    while (j < d.length) {
                        final C c2 = d[j];
                        i.a(a(c2), new br(c2, null));
                        ++j;
                        if (a != 0) {
                            break Label_0149;
                        }
                        if (a != 0) {
                            break;
                        }
                    }
                }
                p2.g();
            }
            if (a != 0) {
                break;
            }
        }
    }
    
    private static y.d.y a(final C c) {
        final y.d.y box = c.getBox();
        return new y.d.y(box.c() - 3.0, box.d() - 3.0, box.a() + 6.0, box.b() + 6.0);
    }
    
    public void b(final R r) {
        final int a = ab.a;
        if (!this.a) {
            return;
        }
        final ArrayList list = new ArrayList<C>();
        for (final N n : this.b().e(r)) {
            if (n.b() instanceof br) {
                list.add(br.a((br)n.b()));
                if (a != 0) {
                    return;
                }
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        if (list.size() > 0) {
            r.a(T.d, list);
        }
    }
}
