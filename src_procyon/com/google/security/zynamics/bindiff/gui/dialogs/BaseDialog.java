package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class BaseDialog extends JDialog
{
    public BaseDialog(final Window window, final String title) {
        super(window, ModalityType.APPLICATION_MODAL);
        this.init();
        this.setTitle(title);
    }
    
    public BaseDialog(final Window window, final String s, final int n, final int n2) {
        this(window, s);
        this.setSize(n, n2);
        this.setMinimumSize(new Dimension(n, n2));
    }
    
    private void init() {
        this.getRootPane().registerKeyboardAction(new BaseDialog$1(this), "doEscape", KeyStroke.getKeyStroke(27, 0, false), 2);
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (visible) {
            UIManager.put("TabbedPane.tabAreaInsets", new Insets(2, 2, 0, 2));
            UIManager.put("TabbedPane.contentBorderInsets", new Insets(4, 2, 3, 2));
            SwingUtilities.updateComponentTreeUI(this);
        }
        super.setVisible(visible);
    }
}
