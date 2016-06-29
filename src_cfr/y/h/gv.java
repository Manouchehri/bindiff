/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.beans.PropertyChangeSupport;
import java.util.Stack;
import y.c.D;
import y.h.ch;
import y.h.gI;
import y.h.gT;
import y.h.gU;
import y.h.gX;

public class gV
implements gT {
    private Stack b = new Stack();
    private gX c = null;
    private ch d;
    private D e = new D();
    protected gU a;
    private PropertyChangeSupport f;

    public gV() {
        this.f = new PropertyChangeSupport(this);
    }

    public gV(gU gU2) {
        this();
        this.a(gU2);
    }

    public void a(gU gU2) {
        if (this.a != null) {
            this.a();
        }
        if (gU2 == null) return;
        gU2.addViewChangeListener(this);
        this.a = gU2;
        this.d = null;
        gI gI2 = gU2.getCurrentView();
        if (gI2 != null && gI2 instanceof ch) {
            this.d = (ch)gI2;
        }
        if (this.d == null) return;
        if (this.c == null) return;
        this.a(this.c);
    }

    public void a() {
        this.a = null;
        if (this.d == null) return;
        if (this.c == null) return;
        this.d.removeViewMode(this.c);
    }

    public void b() {
        this.a((gX)this.b.pop());
    }

    protected void a(gX gX2) {
        if (this.c != null) {
            gV.b(this.d, this.c);
        }
        this.f.firePropertyChange("Mode", this.c, gX2);
        this.c = gX2;
        gV.a(this.d, this.c);
    }

    protected static void a(ch ch2, gX gX2) {
        if (ch2 == null) return;
        if (gX2 == null) {
            return;
        }
        gX2.setActiveView(ch2);
        ch2.addViewMode(gX2);
    }

    protected static void b(ch ch2, gX gX2) {
        if (ch2 == null) {
            return;
        }
        ch2.removeViewMode(gX2);
    }
}

