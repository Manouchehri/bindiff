package y.h;

import javax.swing.*;
import y.h.a.*;
import java.awt.event.*;
import y.c.*;

public abstract class cA extends AbstractAction
{
    protected final ch a;
    private fs b;
    private boolean c;
    
    protected cA(final String s, final ch a) {
        super(s);
        this.b = new fo();
        this.c = true;
        this.a = a;
    }
    
    public fs a() {
        return this.b;
    }
    
    protected v a(final bu bu) {
        return v.a(bu);
    }
    
    protected ch a(final ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }
    
    public boolean b() {
        return this.c;
    }
    
    protected void a(final q q, final bu bu) {
        final fs a = this.a();
        if (a != null) {
            a.a(q);
        }
    }
    
    protected void b(final q q, final bu bu) {
        final fs a = this.a();
        if (a != null) {
            a.b(q);
        }
    }
}
