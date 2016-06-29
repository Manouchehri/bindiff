/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.jfree.ui.FontChooserPanel;
import org.jfree.ui.StandardDialog;

public class FontChooserDialog
extends StandardDialog {
    private FontChooserPanel fontChooserPanel;

    public FontChooserDialog(Dialog dialog, String string, boolean bl2, Font font) {
        super(dialog, string, bl2);
        this.setContentPane(this.createContent(font));
    }

    public FontChooserDialog(Frame frame, String string, boolean bl2, Font font) {
        super(frame, string, bl2);
        this.setContentPane(this.createContent(font));
    }

    public Font getSelectedFont() {
        return this.fontChooserPanel.getSelectedFont();
    }

    private JPanel createContent(Font font) {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        if (font == null) {
            font = new Font("Dialog", 10, 0);
        }
        this.fontChooserPanel = new FontChooserPanel(font);
        jPanel.add(this.fontChooserPanel);
        JPanel jPanel2 = this.createButtonPanel();
        jPanel2.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        jPanel.add((Component)jPanel2, "South");
        return jPanel;
    }
}

