package y.h;

import java.awt.event.*;
import y.c.*;

public class cI extends cA
{
    private boolean b;
    
    public cI() {
        this((ch)null);
    }
    
    public cI(final ch ch) {
        super(cm.v.toString(), ch);
        this.b = false;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final ch a = this.a(actionEvent);
        if (a != null) {
            this.a(a);
            a.getGraph2D().T();
        }
    }
    
    public void a(final ch ch) {
        final boolean z = fj.z;
        final bu graph2D = ch.getGraph2D();
        if (this.a(graph2D) != null) {
            final y y = new y();
            final x o = graph2D.o();
            while (o.f()) {
                final q e = o.e();
                if (z) {
                    return;
                }
                if (this.a(graph2D, e)) {
                    y.add(e);
                }
                o.g();
                if (z) {
                    break;
                }
            }
            final y y2 = new y(graph2D.J());
            this.a(y, ch);
            final x a = y2.a();
            while (a.f()) {
                final q e2 = a.e();
                if (this.b()) {
                    graph2D.a(e2, true);
                }
                a.g();
                if (z) {
                    break;
                }
            }
        }
    }
    
    protected q a(final y y, final ch ch) {
        final bu graph2D = ch.getGraph2D();
        graph2D.r();
        try {
            q q = null;
            if (y.isEmpty()) {
                if (this.c()) {
                    q = this.b(ch);
                }
            }
            else {
                q = this.b(y, ch);
            }
            if (q != null) {
                this.a(q, ch);
            }
            return q;
        }
        finally {
            graph2D.s();
        }
    }
    
    protected void a(final q q, final ch ch) {
        final fj t = ch.getGraph2D().t(q);
        if (t instanceof gd) {
            final gd gd = (gd)t;
            gd.a(0).setLabelText(this.c(q, ch));
            gd.a(1).setLabelText(this.b(q, ch));
            if (!fj.z) {
                return;
            }
        }
        t.setLabelText(this.c(q, ch));
    }
    
    protected String b(final q q, final ch ch) {
        return "Folder";
    }
    
    protected String c(final q q, final ch ch) {
        return "Group";
    }
    
    protected q b(final ch ch) {
        final bu graph2D = ch.getGraph2D();
        final q c = this.a(graph2D).c(graph2D);
        graph2D.a(c, ch.getCenter().getX(), ch.getCenter().getY());
        return c;
    }
    
    protected q b(final y y, final ch ch) {
        final bu graph2D = ch.getGraph2D();
        final q b = this.a(graph2D).b(this.a(graph2D).a(y));
        this.a(b, graph2D);
        this.a(graph2D).c(y, b);
        this.b(b, graph2D);
        return b;
    }
    
    protected boolean a(final bu bu, final q q) {
        return bu.v(q);
    }
    
    protected void a(final q q, final bu bu) {
    }
    
    protected void b(final q q, final bu bu) {
    }
    
    public boolean c() {
        return this.b;
    }
}
