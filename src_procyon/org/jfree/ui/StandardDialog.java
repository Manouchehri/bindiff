package org.jfree.ui;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StandardDialog extends JDialog implements ActionListener
{
    private boolean cancelled;
    protected static final ResourceBundle localizationResources;
    
    public StandardDialog(final Frame frame, final String s, final boolean b) {
        super(frame, s, b);
        this.cancelled = false;
    }
    
    public StandardDialog(final Dialog dialog, final String s, final boolean b) {
        super(dialog, s, b);
        this.cancelled = false;
    }
    
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (!actionCommand.equals("helpButton")) {
            if (actionCommand.equals("okButton")) {
                this.setVisible(this.cancelled = false);
            }
            else if (actionCommand.equals("cancelButton")) {
                this.cancelled = true;
                this.setVisible(false);
            }
        }
    }
    
    protected JPanel createButtonPanel() {
        final L1R2ButtonPanel l1R2ButtonPanel = new L1R2ButtonPanel(StandardDialog.localizationResources.getString("Help"), StandardDialog.localizationResources.getString("OK"), StandardDialog.localizationResources.getString("Cancel"));
        final JButton leftButton = l1R2ButtonPanel.getLeftButton();
        leftButton.setActionCommand("helpButton");
        leftButton.addActionListener(this);
        final JButton rightButton1 = l1R2ButtonPanel.getRightButton1();
        rightButton1.setActionCommand("okButton");
        rightButton1.addActionListener(this);
        final JButton rightButton2 = l1R2ButtonPanel.getRightButton2();
        rightButton2.setActionCommand("cancelButton");
        rightButton2.addActionListener(this);
        l1R2ButtonPanel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        return l1R2ButtonPanel;
    }
    
    static {
        localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");
    }
}
