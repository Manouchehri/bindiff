/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.AbstractAction;
import y.c.C;
import y.c.d;
import y.c.q;
import y.c.x;
import y.d.n;
import y.d.t;
import y.d.y;
import y.f.al;
import y.h.aA;
import y.h.aB;
import y.h.b.a;
import y.h.b.c;
import y.h.b.e;
import y.h.b.f;
import y.h.b.h;
import y.h.b.i;
import y.h.bu;
import y.h.cO;
import y.h.cP;
import y.h.ch;
import y.h.cm;
import y.h.eR;
import y.h.fj;
import y.h.gZ;

public class cG
extends AbstractAction {
    private final ch a;

    public cG() {
        this(null);
    }

    public cG(ch ch2) {
        super(cm.B.toString());
        this.a = ch2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ch ch2 = this.a(actionEvent);
        if (ch2 == null) return;
        this.a(ch2);
    }

    public void a(ch ch2) {
        gZ gZ2;
        PropertyChangeListener propertyChangeListener2;
        block3 : {
            PropertyChangeListener propertyChangeListener2;
            gZ2 = this.b(ch2);
            if (gZ2 == null) return;
            if (!cG.a(ch2, gZ2)) {
                return;
            }
            PropertyChangeListener propertyChangeListener3 = this.a();
            cO cO2 = new cO(this, ch2.getGraph2D(), gZ2);
            if (propertyChangeListener3 != null) {
                cP cP2 = new cP();
                cP2.add(cO2);
                cP2.add(propertyChangeListener3);
                propertyChangeListener2 = cP2;
                if (!fj.z) break block3;
            }
            propertyChangeListener2 = cO2;
        }
        this.a(ch2, gZ2, propertyChangeListener2, this.b());
    }

    protected PropertyChangeListener a() {
        Object object = this.getValue("PROPERTY_CHANGE_LISTENER");
        if (!(object instanceof PropertyChangeListener)) return null;
        PropertyChangeListener propertyChangeListener = (PropertyChangeListener)object;
        return propertyChangeListener;
    }

    protected boolean b() {
        Object object = this.getValue("SINGLE_LINE_MODE");
        if (!(object instanceof Boolean)) return true;
        boolean bl2 = (Boolean)object;
        return bl2;
    }

    protected void a(ch ch2, gZ gZ2, PropertyChangeListener propertyChangeListener, boolean bl2) {
        t t2 = gZ2.transformCTW(gZ2.getTextBox()).k();
        ch2.openLabelEditorCentered(gZ2, t2.a, t2.b, propertyChangeListener, bl2);
    }

    protected ch a(ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }

    protected gZ b(ch ch2) {
        return this.a(ch2.getGraph2D());
    }

    /*
     * Unable to fully structure code
     */
    gZ a(bu var1_1) {
        var7_2 = fj.z;
        var2_3 = null;
        if (var1_1.H()) ** GOTO lbl25
        var3_4 = var1_1.L();
        if (!var3_4.f()) ** GOTO lbl8
        var2_3 = (gZ)var3_4.d();
        ** GOTO lbl24
lbl8: // 1 sources:
        var4_5 = var1_1.J();
        if (!var4_5.f()) ** GOTO lbl20
        var5_6 = var4_5.e();
        var6_7 = cm.a(var1_1, (q)var5_6);
        if (var6_7 instanceof a) {
            var2_3 = this.a((a)var6_7);
        }
        if (var2_3 != null) ** GOTO lbl24
        if (var6_7.labelCount() <= 0) ** GOTO lbl-1000
        var2_3 = var6_7.getLabel();
        if (var7_2) lbl-1000: // 2 sources:
        {
            var2_3 = this.a((fj)var6_7);
        }
        ** GOTO lbl24
lbl20: // 1 sources:
        var5_6 = var1_1.K();
        if (var5_6.f()) {
            var6_7 = var1_1.i(var5_6.a());
            var2_3 = var6_7.labelCount() > 0 ? var6_7.getLabel() : this.a((aB)var6_7);
        }
lbl24: // 6 sources:
        if (var2_3 != null) return var2_3;
lbl25: // 2 sources:
        var3_4 = var1_1.o();
        do {
            if (var3_4.f() == false) return var2_3;
            var4_5 = var3_4.e();
            var5_6 = cm.a(var1_1, (q)var4_5);
            if (var5_6 instanceof a && (var2_3 = this.a((a)var5_6)) != null) {
                return var2_3;
            }
            var3_4.g();
        } while (!var7_2);
        return var2_3;
    }

    protected aA a(aB aB2) {
        return aB2.getLabel();
    }

    protected eR a(fj fj2) {
        return fj2.getLabel();
    }

    protected eR a(a a2, c c2) {
        eR eR2 = a2.createNodeLabel();
        a2.addLabel(eR2);
        a2.a(eR2, c2, true, 0.0);
        return eR2;
    }

    protected eR a(a a2, f f2) {
        eR eR2 = a2.createNodeLabel();
        a2.addLabel(eR2);
        a2.a(eR2, f2, true, 0.0);
        return eR2;
    }

    eR a(a a2) {
        Collection collection;
        Collection collection2;
        int n2;
        block3 : {
            boolean bl2 = fj.z;
            collection = a2.l().b();
            collection2 = a2.l().c();
            if (collection.size() + collection2.size() <= 0) return null;
            for (int i2 = 0; i2 < a2.labelCount(); ++i2) {
                eR eR2 = a2.getLabel(i2);
                n2 = eR2.a() instanceof h;
                if (!bl2) {
                    Object object;
                    if (!(n2 != 0 ? collection.contains(object = h.a(eR2)) : eR2.a() instanceof e && collection2.contains(object = e.a(eR2)))) continue;
                    return eR2;
                }
                break block3;
            }
            n2 = collection.size();
        }
        if (n2 > 0) {
            return this.a(a2, (f)collection.iterator().next());
        }
        if (collection2.size() <= 0) return null;
        return this.a(a2, (c)collection2.iterator().next());
    }

    protected void a(gZ gZ2, String string) {
        gZ2.setText(string);
    }

    private static boolean a(ch ch2, gZ gZ2) {
        Rectangle rectangle = ch2.getVisibleRect();
        return y.a(gZ2.getBox(), new y(rectangle.x, rectangle.y, rectangle.width, rectangle.height));
    }
}

