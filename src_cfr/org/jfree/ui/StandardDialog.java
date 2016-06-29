/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.jfree.ui.L1R2ButtonPanel;

public class StandardDialog
extends JDialog
implements ActionListener {
    private boolean cancelled = false;
    protected static final ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");

    public StandardDialog(Frame frame, String string, boolean bl2) {
        super(frame, string, bl2);
    }

    public StandardDialog(Dialog dialog, String string, boolean bl2) {
        super(dialog, string, bl2);
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("helpButton")) {
            return;
        }
        if (string.equals("okButton")) {
            this.cancelled = false;
            this.setVisible(false);
            return;
        }
        if (!string.equals("cancelButton")) return;
        this.cancelled = true;
        this.setVisible(false);
    }

    protected JPanel createButtonPanel() {
        L1R2ButtonPanel l1R2ButtonPanel = new L1R2ButtonPanel(localizationResources.getString("Help"), localizationResources.getString("OK"), localizationResources.getString("Cancel"));
        JButton jButton = l1R2ButtonPanel.getLeftButton();
        jButton.setActionCommand("helpButton");
        jButton.addActionListener(this);
        JButton jButton2 = l1R2ButtonPanel.getRightButton1();
        jButton2.setActionCommand("okButton");
        jButton2.addActionListener(this);
        JButton jButton3 = l1R2ButtonPanel.getRightButton2();
        jButton3.setActionCommand("cancelButton");
        jButton3.addActionListener(this);
        l1R2ButtonPanel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        return l1R2ButtonPanel;
    }
}

