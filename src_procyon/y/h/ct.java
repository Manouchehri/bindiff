package y.h;

import javax.swing.*;
import java.awt.event.*;

class ct extends AbstractAction
{
    private final cm a;
    
    ct(final cm a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.a((byte)1, this.a.a(actionEvent));
    }
}
