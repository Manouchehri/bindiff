/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.N;
import y.a.h;

class M {
    public N a(Object object) {
        return new N(object);
    }

    public N a(N n2) {
        N n3;
        N n4;
        block4 : {
            boolean bl2 = h.a;
            N n5 = n2.a;
            if (n5 == null) {
                return n2;
            }
            n4 = n2;
            while (n4.a != null) {
                n4 = n4.a;
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block4;
            }
            while (n5 != n4) {
                n2.a = n4;
                n2 = n5;
                n3 = n2.a;
                if (bl2) return n3;
                n5 = n3;
                if (!bl2) continue;
            }
        }
        n3 = n4;
        return n3;
    }

    public void a(N n2, N n3) {
        if ((n2 = this.a(n2)) == (n3 = this.a(n3))) {
            return;
        }
        if (n2.b > n3.b) {
            n3.a = n2;
            n2.b += n3.b;
            if (!h.a) return;
        }
        n2.a = n3;
        n3.b += n2.b;
    }

    public Object b(N n2) {
        return n2.c;
    }
}

