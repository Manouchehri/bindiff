package y.h;

import java.awt.*;
import javax.swing.*;

class hE extends JLabel
{
    public void setText(final String text) {
        try {
            super.setText(text);
        }
        catch (ClassCastException ex) {
            if (!a(this.getText())) {
                throw ex;
            }
        }
    }
    
    protected void paintComponent(final Graphics graphics) {
        try {
            super.paintComponent(graphics);
        }
        catch (ClassCastException ex) {
            if (!a(this.getText())) {
                throw ex;
            }
        }
    }
    
    public JToolTip createToolTip() {
        final il il = new il();
        il.setComponent(this);
        return il;
    }
    
    private static boolean a(final String s) {
        return il.a(s);
    }
}
