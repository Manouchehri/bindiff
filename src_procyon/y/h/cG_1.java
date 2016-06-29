package y.h;

import javax.swing.*;
import java.awt.event.*;
import java.beans.*;
import y.c.*;
import y.h.b.*;
import java.util.*;
import y.d.*;
import java.awt.*;

public class cG extends AbstractAction
{
    private final ch a;
    
    public cG() {
        this((ch)null);
    }
    
    public cG(final ch a) {
        super(cm.B.toString());
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final ch a = this.a(actionEvent);
        if (a != null) {
            this.a(a);
        }
    }
    
    public void a(final ch ch) {
        final gZ b = this.b(ch);
        if (b == null || !a(ch, b)) {
            return;
        }
        final PropertyChangeListener a = this.a();
        final cO co = new cO(this, ch.getGraph2D(), b);
        PropertyChangeListener propertyChangeListener = null;
        Label_0081: {
            if (a != null) {
                final cP cp = new cP();
                cp.add(co);
                cp.add((cO)a);
                propertyChangeListener = cp;
                if (!fj.z) {
                    break Label_0081;
                }
            }
            propertyChangeListener = co;
        }
        this.a(ch, b, propertyChangeListener, this.b());
    }
    
    protected PropertyChangeListener a() {
        final Object value = this.getValue("PROPERTY_CHANGE_LISTENER");
        return (value instanceof PropertyChangeListener) ? ((PropertyChangeListener)value) : null;
    }
    
    protected boolean b() {
        final Object value = this.getValue("SINGLE_LINE_MODE");
        return !(value instanceof Boolean) || (boolean)value;
    }
    
    protected void a(final ch ch, final gZ gz, final PropertyChangeListener propertyChangeListener, final boolean b) {
        final t k = gz.transformCTW(gz.getTextBox()).k();
        ch.openLabelEditorCentered(gz, k.a, k.b, propertyChangeListener, b);
    }
    
    protected ch a(final ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }
    
    protected gZ b(final ch ch) {
        return this.a(ch.getGraph2D());
    }
    
    gZ a(final bu bu) {
        final boolean z = fj.z;
        gZ gz = null;
        Label_0178: {
            if (!bu.H()) {
                final C l = bu.L();
                if (l.f()) {
                    gz = (gZ)l.d();
                }
                else {
                    final x j = bu.J();
                    if (j.f()) {
                        final fj a = cm.a(bu, j.e());
                        if (a instanceof a) {
                            gz = this.a((a)a);
                        }
                        if (gz == null) {
                            if (a.labelCount() > 0) {
                                gz = a.getLabel();
                                if (!z) {
                                    break Label_0178;
                                }
                            }
                            gz = this.a(a);
                        }
                    }
                    else {
                        final e k = bu.K();
                        if (k.f()) {
                            final aB i = bu.i(k.a());
                            if (i.labelCount() > 0) {
                                gz = i.getLabel();
                            }
                            else {
                                gz = this.a(i);
                            }
                        }
                    }
                }
            }
        }
        if (gz == null) {
            final x o = bu.o();
            while (o.f()) {
                final fj a2 = cm.a(bu, o.e());
                if (a2 instanceof a) {
                    gz = this.a((a)a2);
                    if (gz != null) {
                        break;
                    }
                }
                o.g();
                if (z) {
                    break;
                }
            }
        }
        return gz;
    }
    
    protected aA a(final aB ab) {
        return ab.getLabel();
    }
    
    protected eR a(final fj fj) {
        return fj.getLabel();
    }
    
    protected eR a(final a a, final c c) {
        final eR nodeLabel = a.createNodeLabel();
        a.addLabel(nodeLabel);
        a.a(nodeLabel, c, true, 0.0);
        return nodeLabel;
    }
    
    protected eR a(final a a, final f f) {
        final eR nodeLabel = a.createNodeLabel();
        a.addLabel(nodeLabel);
        a.a(nodeLabel, f, true, 0.0);
        return nodeLabel;
    }
    
    eR a(final a a) {
        final boolean z = fj.z;
        final Collection b = a.l().b();
        final Collection c = a.l().c();
        if (b.size() + c.size() > 0) {
            int i = 0;
            while (true) {
                while (i < a.labelCount()) {
                    final eR label = a.getLabel(i);
                    final int n = (label.a() instanceof h) ? 1 : 0;
                    if (!z) {
                        if (n != 0) {
                            if (b.contains(h.a(label))) {
                                return label;
                            }
                        }
                        else if (label.a() instanceof y.h.b.e && c.contains(y.h.b.e.a(label))) {
                            return label;
                        }
                        ++i;
                        if (z) {
                            return null;
                        }
                        continue;
                    }
                    else {
                        if (n > 0) {
                            return this.a(a, b.iterator().next());
                        }
                        if (c.size() > 0) {
                            return this.a(a, c.iterator().next());
                        }
                        return null;
                    }
                }
                b.size();
                continue;
            }
        }
        return null;
    }
    
    protected void a(final gZ gz, final String text) {
        gz.setText(text);
    }
    
    private static boolean a(final ch ch, final gZ gz) {
        final Rectangle visibleRect = ch.getVisibleRect();
        return y.a(gz.getBox(), new y(visibleRect.x, visibleRect.y, visibleRect.width, visibleRect.height));
    }
}
