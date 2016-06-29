package y.h.a;

import y.c.*;
import java.awt.event.*;
import y.h.*;
import javax.swing.*;

public abstract class n extends c
{
    private final fj a;
    private final ch b;
    
    protected n(final fj a, final ch b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean a(final dw dw) {
        return this.a(this.a, dw.a(), dw.b());
    }
    
    public void b(final dw dw) {
        if (!this.a(this.a, dw.a(), dw.b())) {
            this.e();
            return;
        }
        if (dw.c() == 500) {
            final q node = this.a.getNode();
            if (node == null || node.e() == null) {
                return;
            }
            final v a = v.a(this.b.getGraph2D());
            if (a != null && a.d(node.e())) {
                boolean b = false;
                Label_0123: {
                    if (a.j(node)) {
                        this.a(node, a);
                        b = true;
                        if (v.a == 0) {
                            break Label_0123;
                        }
                    }
                    if (a.k(node)) {
                        this.b(node, a);
                        b = true;
                    }
                }
                if (b) {
                    this.e();
                }
            }
        }
    }
    
    protected abstract boolean a(final fj p0, final double p1, final double p2);
    
    protected void a(final q q, final v v) {
        a(q, cm.z, this.b);
    }
    
    protected void b(final q q, final v v) {
        a(q, cm.A, this.b);
    }
    
    private static void a(final q q, final Object o, final ch ch) {
        final Action a = a(o, ch);
        if (a != null) {
            if (q != null) {
                final bu graph2D = ch.getGraph2D();
                graph2D.N();
                graph2D.a(q, true);
            }
            a.actionPerformed(new ActionEvent(ch, 1001, ""));
        }
    }
    
    private static Action a(final Object o, final ch ch) {
        final ActionMap actionMap = ch.getCanvasComponent().getActionMap();
        if (actionMap != null) {
            final Action value = actionMap.get(o);
            if (value != null) {
                return value;
            }
        }
        return new cm(ch).v().get(o);
    }
}
