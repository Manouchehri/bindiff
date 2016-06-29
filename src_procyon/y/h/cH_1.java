package y.h;

import java.awt.event.*;
import y.c.*;
import java.awt.geom.*;
import y.h.a.*;
import java.awt.*;

public class cH extends cA
{
    private boolean b;
    
    public cH() {
        this((ch)null);
    }
    
    public cH(final ch ch) {
        super(cm.w.toString(), ch);
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
            while (true) {
                while (o.f()) {
                    final q e = o.e();
                    final cH ch2 = this;
                    if (!z) {
                        if (this.a(graph2D, e)) {
                            y.add(e);
                        }
                        o.g();
                        if (z) {
                            break;
                        }
                        continue;
                    }
                    else {
                        final q a = ch2.a(y, ch);
                        if (this.b() && a != null) {
                            graph2D.a(a, true);
                        }
                        return;
                    }
                }
                final cH ch2 = this;
                continue;
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
            return q;
        }
        finally {
            graph2D.s();
        }
    }
    
    protected q b(final ch ch) {
        final bu graph2D = ch.getGraph2D();
        final q b = this.a(graph2D).b(graph2D);
        graph2D.a(b, ch.getCenter().getX(), ch.getCenter().getY());
        this.a(b, ch);
        return b;
    }
    
    protected q b(final y y, final ch ch) {
        final bu graph2D = ch.getGraph2D();
        final v a = this.a(graph2D);
        final q b = a.b(a.a(y));
        a.c(y, b);
        this.a(b, ch);
        graph2D.t(b).calcUnionRect(new Rectangle2D.Double());
        this.a(b, graph2D);
        a.e(b);
        this.a(graph2D.t(b));
        this.b(b, graph2D);
        return b;
    }
    
    protected void a(fj a) {
        Label_0087: {
            if (a instanceof gd) {
                final gd gd = (gd)a;
                a = gd.a(1);
                gd.b(a);
                if (!(a instanceof h) || ((h)a).isGroupClosed()) {
                    break Label_0087;
                }
                ((h)a).setGroupClosed(true);
                if (!fj.z) {
                    break Label_0087;
                }
            }
            if (a instanceof h && !((h)a).isGroupClosed()) {
                ((h)a).setGroupClosed(true);
            }
        }
        final bu d = a.d();
        final q node = a.getNode();
        final Rectangle a2 = ((bu)d.C().m(node)).a();
        d.b(node, a2.width + 10, a2.height + 10);
        d.c(node, a2.x - 5, a2.y - 5);
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
    
    protected boolean a(final bu bu, final q q) {
        return bu.v(q);
    }
    
    public boolean c() {
        return this.b;
    }
}
