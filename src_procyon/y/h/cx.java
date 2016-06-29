package y.h;

import javax.swing.*;
import java.awt.event.*;

class cx extends AbstractAction
{
    private final cm a;
    
    cx(final cm a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.b((byte)1, this.a.a(actionEvent));
    }
}
