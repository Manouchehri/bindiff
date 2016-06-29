/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ISavableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CloseViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ExportViewAsImageAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.PrintViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SaveViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu$InternalViewListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class ViewMenu
extends JMenu {
    private final ViewMenu$InternalViewListener viewListener;
    private ViewTabPanelFunctions viewTabPanelController;
    private JMenuItem saveView;
    private JMenuItem printPrimaryGraph;
    private JMenuItem printSecondaryGraph;
    private JMenuItem printCombinedGraph;
    private JMenuItem exportViewAsPng;
    private JMenuItem closeView;

    public ViewMenu(ViewTabPanelFunctions viewTabPanelFunctions) {
        super("View");
        this.viewListener = new ViewMenu$InternalViewListener(this, null);
        this.setMnemonic('V');
        this.viewTabPanelController = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        Diff diff = viewTabPanelFunctions.getGraphs().getDiff();
        int n2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        this.saveView = GuiUtils.buildMenuItem("Save View", 'S', 83, n2, new SaveViewAction(viewTabPanelFunctions));
        this.printPrimaryGraph = GuiUtils.buildMenuItem("Print Primary Graph...", 'P', (AbstractAction)new PrintViewAction(viewTabPanelFunctions, viewTabPanelFunctions.getGraphs().getPrimaryGraph()));
        this.printSecondaryGraph = GuiUtils.buildMenuItem("Print Secondary Graph...", 'S', (AbstractAction)new PrintViewAction(viewTabPanelFunctions, viewTabPanelFunctions.getGraphs().getSecondaryGraph()));
        this.printCombinedGraph = GuiUtils.buildMenuItem("Print Combined Graph...", 'C', (AbstractAction)new PrintViewAction(viewTabPanelFunctions, viewTabPanelFunctions.getGraphs().getCombinedGraph()));
        this.exportViewAsPng = GuiUtils.buildMenuItem("Export View as Image...", 'E', (AbstractAction)new ExportViewAsImageAction(viewTabPanelFunctions));
        this.closeView = GuiUtils.buildMenuItem("Close View", 'C', (AbstractAction)new CloseViewAction(viewTabPanelFunctions));
        this.saveView.setEnabled(diff.isFunctionDiff());
        this.add(this.saveView);
        this.add(new JSeparator());
        this.add(this.printPrimaryGraph);
        this.add(this.printSecondaryGraph);
        this.add(this.printCombinedGraph);
        this.add(new JSeparator());
        this.add(this.exportViewAsPng);
        this.add(new JSeparator());
        this.add(this.closeView);
        this.viewTabPanelController.addListener(this.viewListener);
    }

    public void dispose() {
        this.viewTabPanelController.removeListener(this.viewListener);
        this.viewTabPanelController = null;
        this.saveView = null;
        this.printPrimaryGraph = null;
        this.printSecondaryGraph = null;
        this.printCombinedGraph = null;
        this.exportViewAsPng = null;
        this.closeView = null;
    }

    static /* synthetic */ ViewTabPanelFunctions access$100(ViewMenu viewMenu) {
        return viewMenu.viewTabPanelController;
    }

    static /* synthetic */ JMenuItem access$200(ViewMenu viewMenu) {
        return viewMenu.saveView;
    }
}

