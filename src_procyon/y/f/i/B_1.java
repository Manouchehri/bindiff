package y.f.i;

import y.d.*;
import y.c.*;
import y.f.*;

class B
{
    private X a;
    private y b;
    
    private B(final X a) {
        this.a = a;
        this.b = new y();
    }
    
    public y a() {
        final int i = v.f;
        this.b();
        final x o = this.a.o();
        do {
            Label_0017: {
                o.f();
            }
            boolean a = false;
            Label_0023:
            while (a) {
                final y.d.y s = this.a.s(o.e());
                final B b = this;
                if (i == 0) {
                    final aj[] a_ = this.a.a_(o.e());
                    if (a_ != null && a_.length > 0) {
                        int j = 0;
                        while (j < a_.length) {
                            final y.d.y box = a_[j].getBox();
                            a = this.a(s, box, 3.0);
                            if (i != 0) {
                                continue Label_0023;
                            }
                            if (!a) {
                                final y.c.q d = this.a.d();
                                this.a.a(d, box);
                                this.a.b(d, box.e());
                                this.b.add(d);
                            }
                            ++j;
                            if (i != 0) {
                                break;
                            }
                        }
                    }
                    o.g();
                    continue Label_0017;
                }
                return b.b;
            }
            break;
        } while (i == 0);
        final B b = this;
        return b.b;
    }
    
    private boolean a(final y.d.y y, final y.d.y y2, final double n) {
        return y.d() < y2.d() + n && y.c() < y2.c() + n && y.d() + y.b() > y2.d() + y2.b() - n && y.c() + y.a() > y2.c() + y2.a() - n;
    }
    
    public void b() {
        final int f = v.f;
        if (!this.b.isEmpty()) {
            final x a = this.b.a();
            while (a.f()) {
                this.a.a(a.e());
                a.g();
                if (f != 0) {
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            this.b.clear();
        }
    }
    
    B(final X x, final w w) {
        this(x);
    }
}
