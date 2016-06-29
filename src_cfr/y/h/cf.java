/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import y.c.f;
import y.c.y;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.hV;

public class cF
extends AbstractAction {
    private ch a;
    private hV b;

    public cF(ch ch2) {
        this.a = ch2;
        this.b = new hV(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ch ch2 = this.a(actionEvent);
        if (ch2 == null) return;
        this.a(ch2);
        ch2.getGraph2D().T();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(ch ch2) {
        bu bu2;
        bu2 = ch2.getGraph2D();
        bu2.r();
        try {
            this.b.a(bu2);
        }
        finally {
            bu2.s();
        }
        ch2.updateWorldRect();
        bu2.T();
    }

    protected void a(bu bu2, y y2, f f2, Map map, Map map2) {
        this.b.a(bu2, y2, f2, map, map2);
    }

    protected y a(bu bu2) {
        return this.b.b(bu2);
    }

    protected f b(bu bu2) {
        return this.b.c(bu2);
    }

    protected void b(bu bu2, y y2, f f2, Map map, Map map2) {
        this.b.b(bu2, y2, f2, map, map2);
    }

    protected void c(bu bu2, y y2, f f2, Map map, Map map2) {
        this.b.a(bu2, y2, f2);
    }

    protected void a(bu bu2, List list, List list2, Map map, Map map2) {
        this.b.a(bu2, list, list2, map, map2);
    }

    protected List c(bu bu2) {
        return this.b.d(bu2);
    }

    protected List d(bu bu2) {
        return this.b.e(bu2);
    }

    protected void b(bu bu2, List list, List list2, Map map, Map map2) {
        this.b.a(list, list2);
    }

    protected void c(bu bu2, List list, List list2, Map map, Map map2) {
        this.b.a(bu2, list, list2);
    }

    protected ch a(ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }
}

