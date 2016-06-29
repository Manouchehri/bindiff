package y.f.b;

import java.util.*;
import y.f.*;
import y.c.*;

public class i extends a
{
    public void c(final X x) {
        final int a = c.a;
        Label_0254: {
            if (c.b(x)) {
                final ah a2 = this.a();
                if (a2 != null) {
                    final y.c.c c = x.c(f.b);
                    final y.c.c c2 = x.c(f.c);
                    final HashMap<Object, q> hashMap = new HashMap<Object, q>();
                    final x o = x.o();
                    while (o.f()) {
                        hashMap.put(c.b(o.e()), o.e());
                        o.g();
                        if (a != 0) {
                            return;
                        }
                        if (a != 0) {
                            break;
                        }
                    }
                    final ArrayList<d> list = new ArrayList<d>(x.e());
                    final x o2 = x.o();
                    while (true) {
                        while (o2.f()) {
                            final q e = o2.e();
                            final Object b = c2.b(e);
                            if (a != 0) {
                                int i = 0;
                                while (i < list.size()) {
                                    x.a(list.get(i));
                                    ++i;
                                    if (a != 0) {
                                        break Label_0254;
                                    }
                                }
                                return;
                            }
                            if (b != null) {
                                final q q = hashMap.get(b);
                                if (q != null) {
                                    list.add(x.a(e, q));
                                }
                            }
                            o2.g();
                            if (a != 0) {
                                break;
                            }
                        }
                        a2.c(x);
                        continue;
                    }
                }
                return;
            }
        }
        final ah a3 = this.a();
        if (a3 != null) {
            a3.c(x);
        }
    }
}
