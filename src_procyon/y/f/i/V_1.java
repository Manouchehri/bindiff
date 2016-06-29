package y.f.i;

import java.util.*;
import y.g.*;

class V implements Comparator, g
{
    private Comparator a;
    
    public V(final Comparator a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final U u = (U)o;
        final U u2 = (U)o2;
        final byte a = u.a();
        final byte a2 = u2.a();
        if (a != a2) {
            return e.a(a, a2);
        }
        switch (a) {
            case 0: {
                if (U.c(u) == U.c(u2) && U.b(u) == U.b(u2)) {
                    return (this.a != null) ? this.a.compare(u.c(), u2.c()) : 0;
                }
                if (U.c(u) >= U.c(u2) && U.b(u) <= U.b(u2)) {
                    return -1;
                }
                if (U.c(u2) >= U.c(u) && U.b(u2) <= U.b(u)) {
                    return 1;
                }
                if (U.c(u) < U.c(u2)) {
                    return -1;
                }
                if (U.c(u2) < U.c(u)) {
                    return 1;
                }
                return 0;
            }
            case 1: {
                if (U.c(u) == U.c(u2) && U.b(u) == U.b(u2)) {
                    return (this.a != null) ? this.a.compare(u.c(), u2.c()) : 0;
                }
                if (U.c(u) > U.c(u2) && U.b(u) < U.b(u2)) {
                    return 1;
                }
                if (U.c(u2) > U.c(u) && U.b(u2) < U.b(u)) {
                    return -1;
                }
                if (U.c(u2) == U.c(u)) {
                    return (U.b(u) < U.b(u2)) ? -1 : 1;
                }
                if (U.b(u2) == U.b(u)) {
                    return (U.c(u) < U.c(u2)) ? -1 : 1;
                }
                if (U.c(u) < U.c(u2)) {
                    return -1;
                }
                if (U.c(u2) < U.c(u)) {
                    return 1;
                }
                return 0;
            }
            case 2: {
                if (U.c(u) == U.c(u2) && U.b(u) == U.b(u2)) {
                    return (this.a != null) ? this.a.compare(u.c(), u2.c()) : 0;
                }
                if (U.c(u) > U.c(u2) && U.b(u) < U.b(u2)) {
                    return -1;
                }
                if (U.c(u2) > U.c(u) && U.b(u2) < U.b(u)) {
                    return 1;
                }
                if (U.c(u2) == U.c(u)) {
                    return (U.b(u) < U.b(u2)) ? 1 : -1;
                }
                if (U.b(u2) == U.b(u)) {
                    return (U.c(u) < U.c(u2)) ? 1 : -1;
                }
                if (U.c(u) < U.c(u2)) {
                    return 1;
                }
                if (U.c(u2) < U.c(u)) {
                    return -1;
                }
                return 0;
            }
            case 3: {
                if (U.c(u) == U.c(u2) && U.b(u) == U.b(u2)) {
                    return (this.a != null) ? this.a.compare(u2.c(), u.c()) : 0;
                }
                if (U.c(u) >= U.c(u2) && U.b(u) <= U.b(u2)) {
                    return -1;
                }
                if (U.c(u2) >= U.c(u) && U.b(u2) <= U.b(u)) {
                    return 1;
                }
                if (U.c(u) < U.c(u2)) {
                    return -1;
                }
                if (U.c(u2) < U.c(u)) {
                    return 1;
                }
                return 0;
            }
            default: {
                return 0;
            }
        }
    }
}
