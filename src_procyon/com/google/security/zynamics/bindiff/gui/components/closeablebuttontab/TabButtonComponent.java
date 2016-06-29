package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.common.base.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabButtonComponent extends JPanel
{
    private final TabButtonComponent$InternalMouseListener mouseListener;
    private final JTabbedPane pane;
    private final TabPanel tabPanel;
    private final TabButton closeButton;
    private final TabLabel label;
    
    public TabButtonComponent(final JTabbedPane tabbedPane, final TabPanel tabPanel, final Icon icon, final boolean b) {
        super(new FlowLayout(0, 0, 0));
        this.mouseListener = new TabButtonComponent$InternalMouseListener(this, null);
        this.pane = (JTabbedPane)Preconditions.checkNotNull(tabbedPane);
        this.tabPanel = (TabPanel)Preconditions.checkNotNull(tabPanel);
        this.closeButton = new TabButton(tabbedPane, this, b);
        this.label = new TabLabel(tabbedPane, this);
        if (icon != null) {
            this.label.setIcon(icon);
        }
        this.label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
        this.add(this.label);
        if (b) {
            this.add(this.closeButton);
        }
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        this.addMouseListener(this.mouseListener);
    }
    
    public void addListener(final ICloseTabButtonListener closeTabButtonListener) {
        this.closeButton.addListener(closeTabButtonListener);
    }
    
    public TabPanel getTabPanel() {
        return this.tabPanel;
    }
    
    public void removeListener(final ICloseTabButtonListener closeTabButtonListener) {
        this.closeButton.removeListener(closeTabButtonListener);
    }
    
    public void setIcon(final Icon icon) {
        this.label.setIcon(icon);
        this.label.updateUI();
    }
    
    public void setTitle(final String text) {
        this.label.setText(text);
        this.label.updateUI();
    }
}
