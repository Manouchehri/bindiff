package y.a;

import y.c.*;

class d extends e
{
    boolean a;
    private final f f;
    
    d(final f f) {
        this.f = f;
        this.a = false;
    }
    
    protected void a(final y.c.d d, final q q, final boolean b) {
        final boolean a = y.a.h.a;
        if (!this.a) {
            Label_0178: {
                if (this.b.b(q) == d.d) {
                    this.a = true;
                    int size = this.f.size();
                    final y.c.e a2 = this.f.a();
                    a2.j();
                    while (true) {
                        while (true) {
                            while (a2.f()) {
                                final q c = a2.a().c();
                                if (!a) {
                                    if (c == q) {
                                        break;
                                    }
                                    if (a2.a().d() == q) {
                                        break;
                                    }
                                    a2.h();
                                    --size;
                                    if (a) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    while (true) {
                                        if (!a) {
                                            if (!a) {
                                                if (--size > 0) {
                                                    this.f.g();
                                                    continue;
                                                }
                                            }
                                            this.f.b(d);
                                        }
                                        break;
                                    }
                                    if (a) {
                                        break Label_0178;
                                    }
                                    return;
                                }
                            }
                            if (!d.e()) {
                                continue;
                            }
                            this.f.clear();
                            if (a) {
                                continue;
                            }
                            break;
                        }
                        continue;
                    }
                }
            }
            if (b) {
                this.f.b(d);
            }
        }
    }
    
    protected void a(final y.c.d d, final q q) {
        if (!this.a) {
            this.f.h(this.f.l());
        }
    }
}
