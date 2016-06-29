package y.h;

import javax.swing.*;
import java.awt.event.*;

class cw extends AbstractAction
{
    private final cm a;
    
    cw(final cm a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.b((byte)0, this.a.a(actionEvent));
    }
}
