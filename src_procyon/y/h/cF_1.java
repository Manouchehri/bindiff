package y.h;

import javax.swing.*;
import java.awt.event.*;
import y.c.*;
import java.util.*;

public class cF extends AbstractAction
{
    private ch a;
    private hV b;
    
    public cF(final ch a) {
        this.a = a;
        this.b = new hV(this);
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final ch a = this.a(actionEvent);
        if (a != null) {
            this.a(a);
            a.getGraph2D().T();
        }
    }
    
    public void a(final ch ch) {
        final bu graph2D = ch.getGraph2D();
        graph2D.r();
        try {
            this.b.a(graph2D);
        }
        finally {
            graph2D.s();
        }
        ch.updateWorldRect();
        graph2D.T();
    }
    
    protected void a(final bu bu, final y y, final f f, final Map map, final Map map2) {
        this.b.a(bu, y, f, map, map2);
    }
    
    protected y a(final bu bu) {
        return this.b.b(bu);
    }
    
    protected f b(final bu bu) {
        return this.b.c(bu);
    }
    
    protected void b(final bu bu, final y y, final f f, final Map map, final Map map2) {
        this.b.b(bu, y, f, map, map2);
    }
    
    protected void c(final bu bu, final y y, final f f, final Map map, final Map map2) {
        this.b.a(bu, y, f);
    }
    
    protected void a(final bu bu, final List list, final List list2, final Map map, final Map map2) {
        this.b.a(bu, list, list2, map, map2);
    }
    
    protected List c(final bu bu) {
        return this.b.d(bu);
    }
    
    protected List d(final bu bu) {
        return this.b.e(bu);
    }
    
    protected void b(final bu bu, final List list, final List list2, final Map map, final Map map2) {
        this.b.a(list, list2);
    }
    
    protected void c(final bu bu, final List list, final List list2, final Map map, final Map map2) {
        this.b.a(bu, list, list2);
    }
    
    protected ch a(final ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }
}
