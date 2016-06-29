/*
 * Decompiled with CFR 0_115.
 */
package y.f.b;

import java.util.ArrayList;
import java.util.HashMap;
import y.c.d;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.a;
import y.f.ah;
import y.f.b.c;
import y.f.b.f;

public class i
extends a {
    @Override
    public void c(X x2) {
        ah ah2;
        int n2 = c.a;
        if (c.b(x2)) {
            Object object;
            block6 : {
                ah2 = this.a();
                if (ah2 == null) return;
                y.c.c c2 = x2.c(f.b);
                y.c.c c3 = x2.c(f.c);
                HashMap<Object, q> hashMap = new HashMap<Object, q>();
                object = x2.o();
                while (object.f()) {
                    hashMap.put(c2.b(object.e()), object.e());
                    object.g();
                    if (n2 != 0) return;
                    if (n2 == 0) continue;
                }
                object = new ArrayList(x2.e());
                x x3 = x2.o();
                while (x3.f()) {
                    q q2 = x3.e();
                    Object object2 = c3.b(q2);
                    if (n2 == 0) {
                        q q3;
                        if (object2 != null && (q3 = (q)hashMap.get(object2)) != null) {
                            object.add(x2.a(q2, q3));
                        }
                        x3.g();
                        if (n2 == 0) continue;
                    }
                    break block6;
                }
                ah2.c(x2);
            }
            int n3 = 0;
            do {
                if (n3 >= object.size()) return;
                x2.a((d)object.get(n3));
                ++n3;
            } while (n2 == 0);
        }
        if ((ah2 = this.a()) == null) return;
        ah2.c(x2);
    }
}

