package y.h;

import java.awt.event.*;
import y.h.a.*;
import y.c.*;

public class cM extends cA
{
    public cM() {
        this((ch)null);
    }
    
    public cM(final ch ch) {
        super(cm.x.toString(), ch);
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
            if (!y.isEmpty()) {
                graph2D.r();
                try {
                    final f a2 = this.a(y, graph2D);
                    a.b(y);
                    this.a(a2, graph2D);
                }
                finally {
                    graph2D.s();
                }
            }
            final x a3 = y2.a();
            while (a3.f()) {
                final q e2 = a3.e();
                if (this.b()) {
                    graph2D.a(e2, true);
                }
                a3.g();
                if (z) {
                    break;
                }
            }
        }
    }
    
    protected boolean a(final bu bu, final q q) {
        return bu.v(q);
    }
    
    protected f a(final y y, final bu bu) {
        return new f();
    }
    
    protected void a(final f f, final bu bu) {
    }
}
