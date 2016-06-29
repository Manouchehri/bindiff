package y.h;

import javax.swing.*;
import javax.swing.event.*;

class bz implements CaretListener
{
    private final JTextArea a;
    private final bw b;
    
    bz(final bw b, final JTextArea a) {
        this.b = b;
        this.a = a;
    }
    
    public void caretUpdate(final CaretEvent caretEvent) {
        this.a.revalidate();
    }
}
