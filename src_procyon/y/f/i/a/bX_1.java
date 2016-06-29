package y.f.i.a;

import y.c.*;
import y.f.*;
import y.d.*;
import java.util.*;

class bX extends K
{
    boolean a;
    
    public void a(final Z z, final I i) {
        final int a = ab.a;
        super.a(z, i);
        if (!(this.a = z.c().i())) {
            return;
        }
        final X a2 = z.a();
        final x o = a2.o();
    Label_0130_Outer:
        while (o.f()) {
            final aj[] a_ = a2.a_(o.e());
            int j = 0;
            while (true) {
                while (j < a_.length) {
                    final aj aj = a_[j];
                    i.a(a(aj), new bZ(aj, null));
                    ++j;
                    if (a == 0) {
                        if (a != 0) {
                            break;
                        }
                        continue Label_0130_Outer;
                    }
                    else {
                        if (a != 0) {
                            break Label_0130_Outer;
                        }
                        continue Label_0130_Outer;
                    }
                }
                o.g();
                continue;
            }
        }
    }
    
    private static y a(final aj aj) {
        final y box = aj.getBox();
        return new y(box.c() - 3.0, box.d() - 3.0, box.a() + 6.0, box.b() + 6.0);
    }
    
    public void b(final R r) {
        final int a = ab.a;
        if (this.a) {
            final Iterator<N> iterator = this.b().e(r).iterator();
            final ArrayList list = new ArrayList<aj>();
            while (iterator.hasNext()) {
                final N n = iterator.next();
                if (n.b() instanceof bZ) {
                    list.add(bZ.a((bZ)n.b()));
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
                r.a(T.c, list);
            }
        }
    }
}
