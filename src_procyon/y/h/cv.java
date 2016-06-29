package y.h;

import javax.swing.*;
import java.awt.event.*;

class cv extends AbstractAction
{
    private final cm a;
    
    cv(final cm a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.a((byte)3, this.a.a(actionEvent));
    }
}
