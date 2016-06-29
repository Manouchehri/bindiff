package y.h;

import javax.swing.*;
import java.awt.*;

final class il extends JToolTip
{
    public void setTipText(final String tipText) {
        try {
            super.setTipText(tipText);
        }
        catch (ClassCastException ex) {
            if (!a(tipText)) {
                throw ex;
            }
        }
    }
    
    protected void paintComponent(final Graphics graphics) {
        try {
            super.paintComponent(graphics);
        }
        catch (ClassCastException ex) {
            if (!a(this.getTipText())) {
                throw ex;
            }
        }
    }
    
    static boolean a(final String s) {
        return s != null && s.length() > 5 && "<html>".equalsIgnoreCase(s.substring(0, 6));
    }
}
