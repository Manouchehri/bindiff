/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.imagecombobox;

import com.google.security.zynamics.zylib.gui.imagecombobox.ImageElement;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

class JImageComboBox$ComboBoxRenderer
extends JLabel
implements ListCellRenderer {
    private static final long serialVersionUID = 2728401247866641230L;
    private Font uhOhFont;

    public JImageComboBox$ComboBoxRenderer(int n2) {
        this.setOpaque(true);
        this.setHorizontalAlignment(n2);
        this.setVerticalAlignment(0);
        if (n2 != 2) return;
        this.setBorder(new EmptyBorder(0, 5, 0, 0));
    }

    protected void setUhOhText(String string, Font font) {
        if (this.uhOhFont == null) {
            this.uhOhFont = font.deriveFont(2);
        }
        this.setFont(this.uhOhFont);
        this.setText(string);
    }

    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        ImageElement imageElement = (ImageElement)object;
        if (bl2) {
            this.setBackground(jList.getSelectionBackground());
            this.setForeground(jList.getSelectionForeground());
        } else {
            this.setBackground(jList.getBackground());
            this.setForeground(jList.getForeground());
        }
        if (imageElement == null) {
            return this;
        }
        ImageIcon imageIcon = imageElement.getIcon();
        String string = imageElement.getObject().toString();
        this.setIcon(imageIcon);
        if (imageIcon != null) {
            this.setText(string);
            this.setFont(jList.getFont());
            return this;
        }
        this.setUhOhText(String.valueOf(string).concat(" (no image available)"), jList.getFont());
        return this;
    }
}

