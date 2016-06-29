package y.h;

import javax.swing.*;
import java.awt.event.*;

class cs extends AbstractAction
{
    private final cm a;
    
    cs(final cm a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.a((byte)0, this.a.a(actionEvent));
    }
}
