package y.h;

import java.util.*;
import y.c.*;

final class aq implements am
{
    private final Iterator a;
    private ArrayList b;
    private final an c;
    
    aq(final an c) {
        this.c = c;
        this.a = c.a.i(c.a.e(c.d));
        this.b = new ArrayList();
    }
    
    public boolean a() {
        final boolean z = fj.z;
        int n = 0;
        while (true) {
            while (this.a.hasNext() && this.c.f.isEmpty()) {
                final q q = this.a.next();
                this.c.b.set(q.d());
                this.b.add(q);
                if (this.c.a.k(q) && !this.b.isEmpty()) {
                    this.c.c.add(new ap(this.c, this.b));
                    ++n;
                    this.b = new ArrayList();
                }
                final ar ar = new ar(this.c, q);
                final int size = this.c.c.size();
                this.c.c.add(ar);
                ++n;
                final ao ao = new ao(this.c, q);
                final int size2 = this.c.c.size();
                this.c.c.add(ao);
                ++n;
                if (ao.a()) {
                    this.c.c.remove(size2);
                    --n;
                    final boolean empty = this.c.f.isEmpty();
                    if (z) {
                        if (!empty && !this.b.isEmpty()) {
                            final ap ap = new ap(this.c, this.b);
                            final int size3 = this.c.c.size();
                            this.c.c.add(ap);
                            ++n;
                            if (ap.a()) {
                                this.c.c.remove(size3);
                                --n;
                            }
                            this.b = new ArrayList();
                        }
                        return !this.a.hasNext() && n == 0;
                    }
                    if (!empty || !ar.a()) {
                        continue;
                    }
                    this.c.c.remove(size);
                    if (--n <= 0 || !this.c.f.isEmpty()) {
                        continue;
                    }
                    final int n2 = this.c.c.size() - 1;
                    if (!((am)this.c.c.get(n2)).a()) {
                        continue;
                    }
                    this.c.c.remove(n2);
                    --n;
                    if (z) {
                        break;
                    }
                    continue;
                }
            }
            this.a.hasNext();
            continue;
        }
    }
}
