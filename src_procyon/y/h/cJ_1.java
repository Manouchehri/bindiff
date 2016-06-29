package y.h;

import java.awt.event.*;
import y.c.*;
import java.awt.geom.*;
import y.f.*;
import y.d.*;
import y.h.a.*;

public class cJ extends cA
{
    private boolean b;
    
    public cJ() {
        this((ch)null);
    }
    
    public cJ(final ch ch) {
        super(cm.z.toString(), ch);
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final ch a = this.a(actionEvent);
        if (a != null) {
            this.a(a);
        }
    }
    
    public void a(final ch ch) {
        final boolean z = fj.z;
        final bu graph2D = ch.getGraph2D();
        final v a = this.a(graph2D);
        if (a != null) {
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
            graph2D.r();
            try {
                graph2D.a(y.a());
                final x a2 = y.a();
                while (a2.f()) {
                    final q e2 = a2.e();
                    final q n = a.n(e2);
                    if (z) {
                        break;
                    }
                    Label_0253: {
                        if (n != null) {
                            final a autoBoundsFeature = graph2D.t(n).getAutoBoundsFeature();
                            final boolean b = autoBoundsFeature != null && autoBoundsFeature.isAutoBoundsEnabled();
                            if (b) {
                                autoBoundsFeature.setAutoBoundsEnabled(false);
                            }
                            try {
                                this.c(e2, graph2D);
                                break Label_0253;
                            }
                            finally {
                                if (b) {
                                    autoBoundsFeature.setAutoBoundsEnabled(true);
                                }
                            }
                        }
                        this.c(e2, graph2D);
                    }
                    a2.g();
                    if (z) {
                        break;
                    }
                }
            }
            finally {
                graph2D.s();
            }
            if (this.b()) {
                final x a3 = y2.a();
                while (a3.f()) {
                    graph2D.a(a3.e(), true);
                    a3.g();
                    if (z) {
                        break;
                    }
                }
            }
        }
    }
    
    protected boolean a(final bu bu, final q q) {
        final v a = this.a(bu);
        return bu.v(q) && a.j(q);
    }
    
    public void c(final q q, final bu bu) {
        bu.r();
        try {
            this.a(q, bu);
            this.b(bu, q);
            this.b(q, bu);
        }
        finally {
            bu.s();
        }
        bu.T();
    }
    
    private void b(final bu bu, final q q) {
        final v a = this.a(bu);
        final bu bu2 = (bu)a.m(q);
        final t o = bu.o(q);
        final y y = new y(bu2.o());
        a.f(q);
        final fj t = bu.t(q);
        this.a(t);
        t.calcUnionRect(new Rectangle2D.Double());
        final Rectangle2D.Double boundingBox = t.getBoundingBox();
        if (y.size() > 0) {
            y.add(q);
            ae.a(bu, y.a(), o.a - boundingBox.x, o.b - boundingBox.y);
            if (!fj.z) {
                return;
            }
        }
        ae.a(bu, q, o.a - boundingBox.x, o.b - boundingBox.y);
    }
    
    protected void a(fj a) {
        if (a instanceof gd) {
            final gd gd = (gd)a;
            final boolean selected = gd.isSelected();
            a = gd.a(0);
            gd.b(a);
            if (this.c()) {
                gd.setSelected(selected);
            }
            if (!(a instanceof h) || !((h)a).isGroupClosed()) {
                return;
            }
            ((h)a).setGroupClosed(false);
            if (!fj.z) {
                return;
            }
        }
        if (a instanceof h && ((h)a).isGroupClosed()) {
            ((h)a).setGroupClosed(false);
        }
    }
    
    public boolean c() {
        return this.b;
    }
}
