/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.Comparator;
import y.f.i.U;
import y.g.e;
import y.g.g;

class V
implements Comparator,
g {
    private Comparator a;

    public V(Comparator comparator) {
        this.a = comparator;
    }

    public int compare(Object object, Object object2) {
        byte by2;
        U u2 = (U)object;
        U u3 = (U)object2;
        byte by3 = u2.a();
        if (by3 != (by2 = u3.a())) {
            return e.a(by3, by2);
        }
        switch (by3) {
            case 0: {
                if (U.c(u2) == U.c(u3) && U.b(u2) == U.b(u3)) {
                    if (this.a == null) return 0;
                    int n2 = this.a.compare(u2.c(), u3.c());
                    return n2;
                }
                if (U.c(u2) >= U.c(u3) && U.b(u2) <= U.b(u3)) {
                    return -1;
                }
                if (U.c(u3) >= U.c(u2) && U.b(u3) <= U.b(u2)) {
                    return 1;
                }
                if (U.c(u2) < U.c(u3)) {
                    return -1;
                }
                if (U.c(u3) >= U.c(u2)) return 0;
                return 1;
            }
            case 1: {
                if (U.c(u2) == U.c(u3) && U.b(u2) == U.b(u3)) {
                    if (this.a == null) return 0;
                    int n3 = this.a.compare(u2.c(), u3.c());
                    return n3;
                }
                if (U.c(u2) > U.c(u3) && U.b(u2) < U.b(u3)) {
                    return 1;
                }
                if (U.c(u3) > U.c(u2) && U.b(u3) < U.b(u2)) {
                    return -1;
                }
                if (U.c(u3) == U.c(u2)) {
                    if (U.b(u2) >= U.b(u3)) return 1;
                    return -1;
                }
                if (U.b(u3) == U.b(u2)) {
                    if (U.c(u2) >= U.c(u3)) return 1;
                    return -1;
                }
                if (U.c(u2) < U.c(u3)) {
                    return -1;
                }
                if (U.c(u3) >= U.c(u2)) return 0;
                return 1;
            }
            case 2: {
                if (U.c(u2) == U.c(u3) && U.b(u2) == U.b(u3)) {
                    if (this.a == null) return 0;
                    int n4 = this.a.compare(u2.c(), u3.c());
                    return n4;
                }
                if (U.c(u2) > U.c(u3) && U.b(u2) < U.b(u3)) {
                    return -1;
                }
                if (U.c(u3) > U.c(u2) && U.b(u3) < U.b(u2)) {
                    return 1;
                }
                if (U.c(u3) == U.c(u2)) {
                    if (U.b(u2) >= U.b(u3)) return -1;
                    return 1;
                }
                if (U.b(u3) == U.b(u2)) {
                    if (U.c(u2) >= U.c(u3)) return -1;
                    return 1;
                }
                if (U.c(u2) < U.c(u3)) {
                    return 1;
                }
                if (U.c(u3) >= U.c(u2)) return 0;
                return -1;
            }
            case 3: {
                if (U.c(u2) == U.c(u3) && U.b(u2) == U.b(u3)) {
                    if (this.a == null) return 0;
                    int n5 = this.a.compare(u3.c(), u2.c());
                    return n5;
                }
                if (U.c(u2) >= U.c(u3) && U.b(u2) <= U.b(u3)) {
                    return -1;
                }
                if (U.c(u3) >= U.c(u2) && U.b(u3) <= U.b(u2)) {
                    return 1;
                }
                if (U.c(u2) < U.c(u3)) {
                    return -1;
                }
                if (U.c(u3) >= U.c(u2)) return 0;
                return 1;
            }
        }
        return 0;
    }
}

