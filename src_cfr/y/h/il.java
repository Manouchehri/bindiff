/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics;
import javax.swing.JToolTip;

final class il
extends JToolTip {
    il() {
    }

    @Override
    public void setTipText(String string) {
        try {
            super.setTipText(string);
            return;
        }
        catch (ClassCastException var2_2) {
            if (!il.a(string)) throw var2_2;
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
            if (!il.a(this.getTipText())) throw var2_2;
            return;
        }
    }

    static boolean a(String string) {
        if (string == null) return false;
        if (string.length() <= 5) return false;
        if (!"<html>".equalsIgnoreCase(string.substring(0, 6))) return false;
        return true;
    }
}

