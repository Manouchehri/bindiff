package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import java.awt.*;

public class WindowMenu extends JMenu
{
    private JMenuItem togglePrimaryPerspective;
    private JMenuItem toggleSecondaryPerspective;
    private JMenuItem toogleGraphsPerspective;
    private JMenuItem resetDefaultPerspective;
    
    public WindowMenu(final ViewTabPanelFunctions viewTabPanelFunctions) {
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
