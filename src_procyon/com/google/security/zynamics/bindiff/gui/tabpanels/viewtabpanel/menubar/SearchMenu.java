package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import java.awt.*;

public class SearchMenu extends JMenu
{
    private JMenuItem jumpToPrimaryAddress;
    private JMenuItem jumpToSecondaryAddress;
    private JMenuItem search;
    
    public SearchMenu(final ViewTabPanelFunctions viewTabPanelFunctions) {
        super("Search");
        this.setMnemonic('A');
        final int menuShortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        Preconditions.checkNotNull(viewTabPanelFunctions);
        this.jumpToPrimaryAddress = GuiUtils.buildMenuItem("Jump to Primary Address", 'P', 74, menuShortcutKeyMask, new JumpToAddressAction(viewTabPanelFunctions, ESide.PRIMARY));
        this.jumpToSecondaryAddress = GuiUtils.buildMenuItem("Jump to Secondary Address", 'S', 74, menuShortcutKeyMask | 0x40, new JumpToAddressAction(viewTabPanelFunctions, ESide.SECONDARY));
        this.add(this.search = GuiUtils.buildMenuItem("Search", 'S', 70, menuShortcutKeyMask, new SearchAction(viewTabPanelFunctions)));
        this.add(new JSeparator());
        this.add(this.jumpToPrimaryAddress);
        this.add(this.jumpToSecondaryAddress);
    }
    
    public void dispose() {
        this.jumpToPrimaryAddress = null;
        this.jumpToSecondaryAddress = null;
        this.search = null;
    }
}
