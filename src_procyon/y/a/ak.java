package y.a;

import y.c.*;
import java.util.*;

class ak extends ai
{
    int a;
    final Set b;
    int c;
    private final ag d;
    
    ak(final ag d, final i i) {
        super(d, i);
        this.d = d;
        this.a = 0;
        this.c = (int)Math.round(Math.sqrt(i.g() * ag.b(d)));
        if (i.g() / this.c < 15.0) {
            this.c = Math.round(i.g() / 15.0f);
        }
        this.b = new HashSet(this.c);
    }
    
    void a() {
        this.b.clear();
    }
    
    d b() {
        ++this.a;
        return super.b();
    }
    
    y[] a(final y y, final A a) {
        this.b.remove(y);
        return super.a(y, a);
    }
    
    void c(final y y) {
        final boolean a = y.a.h.a;
        this.i.set(this.g.a(y.b()), y);
        Label_0124: {
            if (y.size() > Math.max(ag.c(this.d), 1)) {
                this.b.add(y);
                if (this.a >= this.c) {
                    final Iterator<y> iterator = (Iterator<y>)this.b.iterator();
                    while (true) {
                        while (iterator.hasNext()) {
                            this.a(iterator.next());
                            if (!a) {
                                if (a) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (a) {
                                    break Label_0124;
                                }
                                return;
                            }
                        }
                        this.a = 0;
                        this.b.clear();
                        continue;
                    }
                }
                return;
            }
        }
        this.b.remove(y);
        this.d(y);
    }
}
