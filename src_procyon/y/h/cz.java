package y.h;

import javax.swing.*;
import java.awt.event.*;

class cz extends AbstractAction
{
    private final cm a;
    
    cz(final cm a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.b((byte)2, this.a.a(actionEvent));
    }
}
