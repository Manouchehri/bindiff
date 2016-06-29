package y.h;

import java.util.*;
import y.c.*;

final class av implements am
{
    private final Iterator a;
    private ArrayList b;
    private final as c;
    
    av(final as c) {
        this.c = c;
        this.a = c.a.h(c.a.e(c.d));
        this.b = new ArrayList();
    }
    
    public boolean a() {
        final boolean z = fj.z;
        int n = 0;
        while (true) {
            while (this.a.hasNext() && this.c.f.isEmpty()) {
                final q q = this.a.next();
                final au au = new au(this.c, q);
                final int size = this.c.c.size();
                this.c.c.add(au);
                if (this.c.a.k(q) && !this.b.isEmpty()) {
                    final aw aw = new aw(this.c, this.b);
                    final int size2 = this.c.c.size();
                    this.c.c.add(aw);
                    n = 1;
                    if (aw.a()) {
                        this.c.c.remove(size2);
                        n = 0;
                    }
                    this.b = new ArrayList();
                }
                this.b.add(q);
                if (n == 0) {
                    final boolean a = au.a();
                    if (z) {
                        if (!a && !this.b.isEmpty()) {
                            final aw aw2 = new aw(this.c, this.b);
                            final int size3 = this.c.c.size();
                            this.c.c.add(aw2);
                            n = 1;
                            if (aw2.a()) {
                                this.c.c.remove(size3);
                                n = 0;
                            }
                            this.b = new ArrayList();
                        }
                        return !this.a.hasNext() && n == 0;
                    }
                    if (!a) {
                        continue;
                    }
                    this.c.c.remove(size);
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
