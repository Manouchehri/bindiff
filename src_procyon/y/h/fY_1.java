package y.h;

import javax.swing.*;
import java.awt.event.*;

class fY extends AbstractAction
{
    private final gb a;
    
    fY(final gb a, final String s) {
        super(s);
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.e(this.a.b() * 2);
    }
}
