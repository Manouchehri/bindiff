/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.ICloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent$1;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabLabel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

public class TabButtonComponent
extends JPanel {
    private final TabButtonComponent$InternalMouseListener mouseListener;
    private final JTabbedPane pane;
    private final TabPanel tabPanel;
    private final TabButton closeButton;
    private final TabLabel label;

    public TabButtonComponent(JTabbedPane jTabbedPane, TabPanel tabPanel, Icon icon, boolean bl2) {
        super(new FlowLayout(0, 0, 0));
        this.mouseListener = new TabButtonComponent$InternalMouseListener(this, null);
        this.pane = (JTabbedPane)Preconditions.checkNotNull(jTabbedPane);
        this.tabPanel = (TabPanel)Preconditions.checkNotNull(tabPanel);
        this.closeButton = new TabButton(jTabbedPane, this, bl2);
        this.label = new TabLabel(jTabbedPane, this);
        if (icon != null) {
            this.label.setIcon(icon);
        }
        this.label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
        this.add(this.label);
        if (bl2) {
            this.add(this.closeButton);
        }
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        this.addMouseListener(this.mouseListener);
    }

    public void addListener(ICloseTabButtonListener iCloseTabButtonListener) {
        this.closeButton.addListener(iCloseTabButtonListener);
    }

    public TabPanel getTabPanel() {
        return this.tabPanel;
    }

    public void removeListener(ICloseTabButtonListener iCloseTabButtonListener) {
        this.closeButton.removeListener(iCloseTabButtonListener);
    }

    public void setIcon(Icon icon) {
        this.label.setIcon(icon);
        this.label.updateUI();
    }

    public void setTitle(String string) {
        this.label.setText(string);
        this.label.updateUI();
    }

    static /* synthetic */ TabPanel access$100(TabButtonComponent tabButtonComponent) {
        return tabButtonComponent.tabPanel;
    }

    static /* synthetic */ JTabbedPane access$200(TabButtonComponent tabButtonComponent) {
        return tabButtonComponent.pane;
    }
}

