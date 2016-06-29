package y.h;

import javax.swing.*;
import java.awt.event.*;

class cu extends AbstractAction
{
    private final cm a;
    
    cu(final cm a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.a((byte)2, this.a.a(actionEvent));
    }
}
