package y.h.a;

import y.c.*;
import y.h.*;

public class s implements u
{
    boolean a;
    boolean b;
    
    public s() {
        this.a = true;
    }
    
    public boolean a() {
        return this.b;
    }
    
    public void a(final t t) {
        final v v = (v)t.getSource();
        if (t.a() == 6) {
            this.a = v.l((q)t.b());
            if (y.h.a.v.a == 0) {
                return;
            }
        }
        if (t.a() == 4) {
            final q q = (q)t.b();
            final fj t2 = ((bu)q.e()).t(q);
            if (!v.l(q)) {
                if (t2 instanceof h) {
                    ((h)t2).setGroupClosed(v.j(q));
                }
                else if (t2 instanceof gd) {
                    final gd gd = (gd)t2;
                    final boolean selected = gd.isSelected();
                    if (v.k(q)) {
                        final fj a = gd.a(0);
                        gd.b(a);
                        if (this.a()) {
                            gd.setSelected(selected);
                        }
                        if (a instanceof h) {
                            ((h)a).setGroupClosed(false);
                        }
                    }
                    else {
                        final fj a2 = gd.a(1);
                        gd.b(a2);
                        if (this.a()) {
                            gd.setSelected(selected);
                        }
                        if (!this.a) {
                            a2.setLocation(gd.a(0).getX(), gd.a(0).getY());
                        }
                        if (a2 instanceof h) {
                            ((h)a2).setGroupClosed(true);
                        }
                    }
                }
            }
        }
    }
}
