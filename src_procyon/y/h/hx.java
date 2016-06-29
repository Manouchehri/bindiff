package y.h;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

abstract class hx
{
    private JComponent a;
    private final hw b;
    
    hx(final hw b, final JComponent a) {
        this.b = b;
        this.a = a;
    }
    
    public JComponent a() {
        return this.a;
    }
    
    public abstract Cursor b();
    
    public void a(final MouseEvent mouseEvent) {
        this.a(mouseEvent, mouseEvent.getID());
    }
    
    public abstract void a(final MouseEvent p0, final int p1);
    
    protected void a(final Component component, final MouseEvent mouseEvent, final int n, final int n2, final int n3) {
        this.b.a(component, mouseEvent, n, n2, n3);
    }
}
