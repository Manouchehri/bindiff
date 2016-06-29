/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JToolTip;
import y.h.il;

class hE
extends JLabel {
    hE() {
    }

    @Override
    public void setText(String string) {
        try {
            super.setText(string);
            return;
        }
        catch (ClassCastException var2_2) {
            if (!hE.a(this.getText())) throw var2_2;
            return;
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        try {
            super.paintComponent(graphics);
            return;
        }
        catch (ClassCastException var2_2) {
            if (!hE.a(this.getText())) throw var2_2;
            return;
        }
    }

    @Override
    public JToolTip createToolTip() {
        il il2 = new il();
        il2.setComponent(this);
        return il2;
    }

    private static boolean a(String string) {
        return il.a(string);
    }
}

