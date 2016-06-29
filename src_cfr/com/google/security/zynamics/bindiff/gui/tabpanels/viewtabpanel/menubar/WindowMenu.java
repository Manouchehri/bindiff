/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ResetDefaultPerspectiveAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleGraphsPerspectiveAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.TogglePrimaryPerspectiveAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleSecondaryPerspectiveAction;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class WindowMenu
extends JMenu {
    private JMenuItem togglePrimaryPerspective;
    private JMenuItem toggleSecondaryPerspective;
    private JMenuItem toogleGraphsPerspective;
    private JMenuItem resetDefaultPerspective;

    public WindowMenu(ViewTabPanelFunctions viewTabPanelFunctions) {
        super("Window");
        this.setMnemonic('W');
        Preconditions.checkNotNull(viewTabPanelFunctions);
        this.togglePrimaryPerspective = GuiUtils.buildMenuItem("Show/Hide Primary", 'P', 120, 0, new TogglePrimaryPerspectiveAction(viewTabPanelFunctions));
        this.toggleSecondaryPerspective = GuiUtils.buildMenuItem("Show/Hide Secondary", 'S', 121, 0, new ToggleSecondaryPerspectiveAction(viewTabPanelFunctions));
        this.toogleGraphsPerspective = GuiUtils.buildMenuItem("Show/Hide Overviews", 'G', 122, 0, new ToggleGraphsPerspectiveAction(viewTabPanelFunctions));
        this.resetDefaultPerspective = GuiUtils.buildMenuItem("Reset Window Layout", 'R', 123, 0, new ResetDefaultPerspectiveAction(viewTabPanelFunctions));
        this.add(this.togglePrimaryPerspective);
        this.add(this.toggleSecondaryPerspective);
        this.add(this.toogleGraphsPerspective);
        this.add(new JSeparator());
        this.add(this.resetDefaultPerspective);
    }

    public void dispose() {
        this.togglePrimaryPerspective = null;
        this.toggleSecondaryPerspective = null;
        this.toogleGraphsPerspective = null;
        this.resetDefaultPerspective = null;
    }
}

