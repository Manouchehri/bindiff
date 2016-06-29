/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.GraphsMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.SearchMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.SelectionMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.WindowMenu;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

public class ViewMenuBar
extends JMenuBar {
    private final JMenu viewMenu;
    private final JMenu modeMenu;
    private final JMenu graphsMenu;
    private final JMenu selectionMenu;
    private final JMenu searchMenu;
    private final JMenu windowMenu;
    private final JMenu helpMenu;

    public ViewMenuBar(ViewTabPanelFunctions viewTabPanelFunctions) {
        this.viewMenu = new ViewMenu(viewTabPanelFunctions);
        this.modeMenu = new ModesMenu(viewTabPanelFunctions);
        this.graphsMenu = new GraphsMenu(viewTabPanelFunctions);
        this.selectionMenu = new SelectionMenu(viewTabPanelFunctions);
        this.searchMenu = new SearchMenu(viewTabPanelFunctions);
        this.windowMenu = new WindowMenu(viewTabPanelFunctions);
        this.helpMenu = new HelpMenu(viewTabPanelFunctions);
        this.add(this.viewMenu);
        this.add(this.modeMenu);
        this.add(this.graphsMenu);
        this.add(this.selectionMenu);
        this.add(this.searchMenu);
        this.add(this.windowMenu);
        this.add(this.helpMenu);
        this.removeKeyBindings();
    }

    private void removeKeyBindings() {
        InputMap inputMap = this.getInputMap(2);
        if (inputMap == null) {
            return;
        }
        Object object = inputMap.get(KeyStroke.getKeyStroke("F10"));
        ActionMap actionMap = this.getActionMap();
        if (actionMap == null) return;
        if (actionMap.getParent() == null) {
            return;
        }
        actionMap.getParent().remove(object);
    }

    public void dispose() {
        ((ViewMenu)this.viewMenu).dispose();
        ((ModesMenu)this.modeMenu).dispose();
        ((GraphsMenu)this.graphsMenu).dispose();
        ((SelectionMenu)this.selectionMenu).dispose();
        ((SearchMenu)this.searchMenu).dispose();
        ((WindowMenu)this.windowMenu).dispose();
    }
}

