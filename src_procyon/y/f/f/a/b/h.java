package y.f.f.a.b;

import y.f.h.*;
import y.g.*;
import y.f.f.a.a.*;
import y.c.*;

public class h extends R
{
    private i j;
    private p k;
    
    public h(final i j, final p k) {
        this.j = j;
        this.k = k;
    }
    
    public void a(final y y) {
        final boolean c = y.f.f.a.b.a.c;
        final y.f.f.a.b.i i = new y.f.f.a.b.i(this.j, this.k);
        i.h();
        i.e();
        final D d = new D();
        final y y2 = new y();
        final I j = new I(this.j);
        i.f();
        d.c(this.k.a());
    Label_0220_Outer:
        while (!d.isEmpty()) {
            final b b = (b)d.g();
            if (!c) {
                if (b.d()) {
                    y.b(b.b_());
                    if (!c) {
                        continue Label_0220_Outer;
                    }
                }
                i.b(b);
                j.e();
                y2.clear();
                this.a(this.j);
                super.a(y2);
                final x a = y2.a();
                a.j();
                while (true) {
                    while (a.f()) {
                        d.c(this.k.a(a.e()));
                        a.h();
                        if (!c) {
                            if (c) {
                                break;
                            }
                            continue Label_0220_Outer;
                        }
                        else {
                            if (c) {
                                break Label_0220_Outer;
                            }
                            continue Label_0220_Outer;
                        }
                    }
                    j.h();
                    i.a(b);
                    continue;
                }
            }
            return;
        }
        i.g();
        i.i();
        i.d();
    }
}
