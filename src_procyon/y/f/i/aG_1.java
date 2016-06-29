package y.f.i;

import y.g.*;
import y.c.*;
import y.f.*;
import java.util.*;

class aG implements Comparator
{
    private X a;
    private v b;
    
    public aG(final X a, final v b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a((d)o), this.a((d)o2));
    }
    
    private int a(final d d) {
        int n = 0;
        if (this.b.b(d.c())) {
            n -= 128;
            if (v.f == 0) {
                return n + this.a(ad.a(this.a, d, true)) + this.a(ad.a(this.a, d, false));
            }
        }
        if (this.b.b(d.d())) {
            n -= 64;
        }
        return n + this.a(ad.a(this.a, d, true)) + this.a(ad.a(this.a, d, false));
    }
    
    private int a(final Collection collection) {
        final int f = v.f;
        int min = 0;
        if (collection != null && !collection.isEmpty()) {
            for (final ax ax : collection) {
                final int b2;
                final boolean b = (b2 = (ax.b() ? 1 : 0)) != 0;
                if (f != 0) {
                    return b2;
                }
                int n = 0;
                Label_0076: {
                    if (b) {
                        n = -16;
                        if (f == 0) {
                            break Label_0076;
                        }
                    }
                    n = -4;
                }
                if (ax.a(1)) {
                    ++n;
                }
                if (ax.a(2)) {
                    ++n;
                }
                if (ax.a(8)) {
                    ++n;
                }
                if (ax.a(4)) {
                    ++n;
                }
                min = Math.min(n, min);
                if (f != 0) {
                    break;
                }
            }
        }
        return min;
    }
}
