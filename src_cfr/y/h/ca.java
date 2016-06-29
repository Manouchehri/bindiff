/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import y.c.q;
import y.h.a.v;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.fo;
import y.h.fs;

public abstract class cA
extends AbstractAction {
    protected final ch a;
    private fs b = new fo();
    private boolean c = true;

    protected cA(String string, ch ch2) {
        super(string);
        this.a = ch2;
    }

    public fs a() {
        return this.b;
    }

    protected v a(bu bu2) {
        return v.a(bu2);
    }

    protected ch a(ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }

    public boolean b() {
        return this.c;
    }

    protected void a(q q2, bu bu2) {
        fs fs2 = this.a();
        if (fs2 == null) return;
        fs2.a(q2);
    }

    protected void b(q q2, bu bu2) {
        fs fs2 = this.a();
        if (fs2 == null) return;
        fs2.b(q2);
    }
}

