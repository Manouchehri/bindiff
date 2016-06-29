/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$5;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class HelpMenu
extends JMenu {
    public HelpMenu(TabPanelFunctions tabPanelFunctions) {
        super("Help");
        this.setMnemonic('H');
        JMenuItem jMenuItem = GuiUtils.buildMenuItem("Help Contents", 'H', 112, 0, new HelpMenu$1(this, tabPanelFunctions));
        JMenuItem jMenuItem2 = GuiUtils.buildMenuItem("Report a Bug", 'R', (AbstractAction)new HelpMenu$2(this, tabPanelFunctions));
        JMenuItem jMenuItem3 = GuiUtils.buildMenuItem("Show License Information...", 'L', (AbstractAction)new HelpMenu$3(this, tabPanelFunctions));
        JMenuItem jMenuItem4 = GuiUtils.buildMenuItem("Check for Updates...", 'U', (AbstractAction)new HelpMenu$4(this, tabPanelFunctions));
        JMenuItem jMenuItem5 = GuiUtils.buildMenuItem("About", 'A', (AbstractAction)new HelpMenu$5(this, tabPanelFunctions));
        this.add(jMenuItem);
        this.add(new JSeparator());
        this.add(jMenuItem2);
        this.add(new JSeparator());
        this.add(jMenuItem3);
        this.add(jMenuItem4);
        this.add(new JSeparator());
        this.add(jMenuItem5);
    }
}

