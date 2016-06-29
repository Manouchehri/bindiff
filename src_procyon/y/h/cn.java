package y.h;

import javax.swing.*;
import java.awt.event.*;

class cn extends AbstractAction
{
    private final cm a;
    
    cn(final cm a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.a(this.a.a(actionEvent));
    }
}
