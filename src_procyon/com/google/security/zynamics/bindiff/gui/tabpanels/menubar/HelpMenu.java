package com.google.security.zynamics.bindiff.gui.tabpanels.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.awt.*;
import javax.swing.*;

public class HelpMenu extends JMenu
{
    public HelpMenu(final TabPanelFunctions tabPanelFunctions) {
        super("Help");
        this.setMnemonic('H');
        final JMenuItem buildMenuItem = GuiUtils.buildMenuItem("Help Contents", 'H', 112, 0, new HelpMenu$1(this, tabPanelFunctions));
        final JMenuItem buildMenuItem2 = GuiUtils.buildMenuItem("Report a Bug", 'R', new HelpMenu$2(this, tabPanelFunctions));
        final JMenuItem buildMenuItem3 = GuiUtils.buildMenuItem("Show License Information...", 'L', new HelpMenu$3(this, tabPanelFunctions));
        final JMenuItem buildMenuItem4 = GuiUtils.buildMenuItem("Check for Updates...", 'U', new HelpMenu$4(this, tabPanelFunctions));
        final JMenuItem buildMenuItem5 = GuiUtils.buildMenuItem("About", 'A', new HelpMenu$5(this, tabPanelFunctions));
        this.add(buildMenuItem);
        this.add(new JSeparator());
        this.add(buildMenuItem2);
        this.add(new JSeparator());
        this.add(buildMenuItem3);
        this.add(buildMenuItem4);
        this.add(new JSeparator());
        this.add(buildMenuItem5);
    }
}
