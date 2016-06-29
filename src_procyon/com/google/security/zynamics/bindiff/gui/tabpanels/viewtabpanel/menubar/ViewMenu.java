package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;

public class ViewMenu extends JMenu
{
    private final ViewMenu$InternalViewListener viewListener;
    private ViewTabPanelFunctions viewTabPanelController;
    private JMenuItem saveView;
    private JMenuItem printPrimaryGraph;
    private JMenuItem printSecondaryGraph;
    private JMenuItem printCombinedGraph;
    private JMenuItem exportViewAsPng;
    private JMenuItem closeView;
    
    public ViewMenu(final ViewTabPanelFunctions viewTabPanelFunctions) {
        super("View");
        this.viewListener = new ViewMenu$InternalViewListener(this, null);
        this.setMnemonic('V');
        this.viewTabPanelController = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        final Diff diff = viewTabPanelFunctions.getGraphs().getDiff();
        this.saveView = GuiUtils.buildMenuItem("Save View", 'S', 83, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), new SaveViewAction(viewTabPanelFunctions));
        this.printPrimaryGraph = GuiUtils.buildMenuItem("Print Primary Graph...", 'P', new PrintViewAction(viewTabPanelFunctions, viewTabPanelFunctions.getGraphs().getPrimaryGraph()));
        this.printSecondaryGraph = GuiUtils.buildMenuItem("Print Secondary Graph...", 'S', new PrintViewAction(viewTabPanelFunctions, viewTabPanelFunctions.getGraphs().getSecondaryGraph()));
        this.printCombinedGraph = GuiUtils.buildMenuItem("Print Combined Graph...", 'C', new PrintViewAction(viewTabPanelFunctions, viewTabPanelFunctions.getGraphs().getCombinedGraph()));
        this.exportViewAsPng = GuiUtils.buildMenuItem("Export View as Image...", 'E', new ExportViewAsImageAction(viewTabPanelFunctions));
        this.closeView = GuiUtils.buildMenuItem("Close View", 'C', new CloseViewAction(viewTabPanelFunctions));
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
}
