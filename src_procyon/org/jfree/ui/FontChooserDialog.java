package org.jfree.ui;

import javax.swing.*;
import java.awt.*;

public class FontChooserDialog extends StandardDialog
{
    private FontChooserPanel fontChooserPanel;
    
    public FontChooserDialog(final Dialog dialog, final String s, final boolean b, final Font font) {
        super(dialog, s, b);
        this.setContentPane(this.createContent(font));
    }
    
    public FontChooserDialog(final Frame frame, final String s, final boolean b, final Font font) {
        super(frame, s, b);
        this.setContentPane(this.createContent(font));
    }
    
    public Font getSelectedFont() {
        return this.fontChooserPanel.getSelectedFont();
    }
    
    private JPanel createContent(Font font) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        if (font == null) {
            font = new Font("Dialog", 10, 0);
        }
        panel.add(this.fontChooserPanel = new FontChooserPanel(font));
        final JPanel buttonPanel = this.createButtonPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        panel.add(buttonPanel, "South");
        return panel;
    }
}
