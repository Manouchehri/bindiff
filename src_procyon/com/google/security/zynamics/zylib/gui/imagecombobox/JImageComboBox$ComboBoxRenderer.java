package com.google.security.zynamics.zylib.gui.imagecombobox;

import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;

class JImageComboBox$ComboBoxRenderer extends JLabel implements ListCellRenderer
{
    private static final long serialVersionUID = 2728401247866641230L;
    private Font uhOhFont;
    
    public JImageComboBox$ComboBoxRenderer(final int horizontalAlignment) {
        this.setOpaque(true);
        this.setHorizontalAlignment(horizontalAlignment);
        this.setVerticalAlignment(0);
        if (horizontalAlignment == 2) {
            this.setBorder(new EmptyBorder(0, 5, 0, 0));
        }
    }
    
    protected void setUhOhText(final String text, final Font font) {
        if (this.uhOhFont == null) {
            this.uhOhFont = font.deriveFont(2);
        }
        this.setFont(this.uhOhFont);
        this.setText(text);
    }
    
    @Override
    public Component getListCellRendererComponent(final JList list, final Object o, final int n, final boolean b, final boolean b2) {
        final ImageElement imageElement = (ImageElement)o;
        if (b) {
            this.setBackground(list.getSelectionBackground());
            this.setForeground(list.getSelectionForeground());
        }
        else {
            this.setBackground(list.getBackground());
            this.setForeground(list.getForeground());
        }
        if (imageElement == null) {
            return this;
        }
        final ImageIcon icon = imageElement.getIcon();
        final String string = imageElement.getObject().toString();
        this.setIcon(icon);
        if (icon != null) {
            this.setText(string);
            this.setFont(list.getFont());
        }
        else {
            this.setUhOhText(String.valueOf(string).concat(" (no image available)"), list.getFont());
        }
        return this;
    }
}
