package y.h.a;

import y.h.*;
import java.util.*;
import y.c.*;
import java.awt.*;

public class c extends N
{
    private fj a;
    private fj b;
    private boolean c;
    
    public c() {
        this.a();
    }
    
    public i a(final Object o) {
        final bu bu = (bu)super.a(o);
        this.a(bu, o);
        return bu;
    }
    
    protected void a(final bu bu, final Object o) {
        final int a = v.a;
        if (o instanceof i) {
            final Iterator q = ((i)o).q();
            while (q.hasNext()) {
                bu.a(q.next());
                if (a != 0) {
                    return;
                }
                if (a != 0) {
                    break;
                }
            }
        }
        if (o instanceof bu) {
            final bu bu2 = (bu)o;
            Iterator iterator = bu2.X();
            while (true) {
                while (iterator.hasNext()) {
                    bu.a(iterator.next());
                    if (a != 0) {
                        while (true) {
                            while (iterator.hasNext()) {
                                bu.a((cf)iterator.next());
                                if (a != 0) {
                                    bu.a(bu2.G());
                                    return;
                                }
                                if (a != 0) {
                                    break;
                                }
                            }
                            bu.b(bu2.F());
                            continue;
                        }
                    }
                    if (a != 0) {
                        break;
                    }
                }
                iterator = bu2.W();
                continue;
            }
        }
    }
    
    public q a(final i i, final Object o) {
        return ((bu)i).a(this.b(o));
    }
    
    public fj b(final Object o) {
        final L l = new L();
        final fj copy = this.b().createCopy();
        l.a(copy);
        final fj copy2 = this.c().createCopy();
        l.a(copy2);
        l.b((o instanceof i) ? copy2 : copy);
        fj e;
        if (this.c) {
            e = l;
        }
        else {
            e = l.e();
        }
        return e;
    }
    
    void a() {
        final p a = new p();
        a.setSize(100.0, 60.0);
        a.setFillColor(new Color(248, 236, 201));
        a.setShapeType((byte)6);
        a.setGroupClosed(false);
        this.a = a;
        final p b = new p();
        b.setSize(100.0, 60.0);
        b.setFillColor(new Color(248, 236, 201));
        b.setShapeType((byte)6);
        b.setGroupClosed(true);
        this.b = b;
    }
    
    public fj b() {
        return this.a;
    }
    
    public fj c() {
        return this.b;
    }
}
