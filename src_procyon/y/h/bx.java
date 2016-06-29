package y.h;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

class bx extends JTextArea
{
    private final bw a;
    
    bx(final bw a, final String s) {
        super(s);
        this.a = a;
    }
    
    public Dimension getPreferredSize() {
        final Dimension preferredSize = super.getPreferredSize();
        if (this.isEditable()) {
            try {
                final Rectangle modelToView = this.modelToView(this.getCaretPosition());
                if (modelToView != null && preferredSize != null && modelToView.x + 3 > preferredSize.width) {
                    preferredSize.width = modelToView.x + Math.max(0, modelToView.width) + 3;
                }
            }
            catch (BadLocationException ex) {}
        }
        return preferredSize;
    }
    
    protected void paintComponent(final Graphics graphics) {
        if (graphics.getFontMetrics().getHeight() > 0) {
            super.paintComponent(graphics);
        }
    }
}
