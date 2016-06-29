package y.h;

import javax.swing.*;
import java.awt.event.*;

class by extends KeyAdapter
{
    private final boolean a;
    private final JTextArea b;
    private final bw c;
    
    by(final bw c, final boolean a, final JTextArea b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public void keyPressed(final KeyEvent keyEvent) {
        final boolean z = fj.z;
        if (keyEvent.getKeyCode() == 10) {
            if (this.a) {
                if (keyEvent.isControlDown() || keyEvent.isShiftDown()) {
                    this.b.insert("\n", this.b.getCaretPosition());
                    if (!z) {
                        return;
                    }
                }
                this.c.d(true);
                if (!z) {
                    return;
                }
            }
            if (!keyEvent.isControlDown() && !keyEvent.isShiftDown()) {
                return;
            }
            this.c.d(true);
            if (!z) {
                return;
            }
        }
        if (keyEvent.getKeyCode() == 27) {
            this.c.d(false);
        }
    }
}
