package y.f.c.a;

import java.util.*;
import y.f.*;
import y.g.*;

class bd implements Comparator
{
    private final int a;
    private final bb b;
    
    bd(final bb b, final int a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return this.a((ax)o, (ax)o2, this.a);
    }
    
    int a(final ax ax, final ax ax2, final int n) {
        if (ax == ax2) {
            return 0;
        }
        if (ax.b() && ax2.b()) {
            final byte b = this.b.b();
            final int a = this.b.a();
            switch (n) {
                case 0: {
                    return e.a(ax.a(b, a), ax2.a(b, a));
                }
                case 1: {
                    return e.a(ax.b(b, a), ax2.b(b, a));
                }
                default: {
                    return e.a(ax2.a(b, a), ax.a(b, a));
                }
                case 3: {
                    return e.a(ax2.b(b, a), ax.b(b, a));
                }
            }
        }
        else {
            if (ax.b()) {
                return -1;
            }
            if (ax2.b()) {
                return 1;
            }
            return 0;
        }
    }
}
