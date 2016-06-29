package y.h;

import javax.swing.*;
import java.awt.event.*;

class cy extends AbstractAction
{
    private final boolean a;
    private final byte b;
    private final cm c;
    
    cy(final cm c, final String s, final boolean a, final byte b) {
        super(s);
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.c.a(this.c.a(actionEvent), this.a, this.b);
    }
}
