package y.h;

import javax.swing.*;
import java.awt.event.*;

class co extends AbstractAction
{
    private final cm a;
    
    co(final cm a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.b((byte)3, this.a.a(actionEvent));
    }
}
