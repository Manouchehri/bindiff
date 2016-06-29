package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import java.awt.*;

public class GraphsMenu extends JMenu
{
    private JMenuItem graphSettings;
    private JMenuItem HierarchicalLayout;
    private JMenuItem orthogonalLayout;
    private JMenuItem circularLayout;
    private JMenuItem fitContent;
    private JMenuItem zoomToSelected;
    private final JMenuItem zoomIn;
    private final JMenuItem zoomOut;
    private JMenuItem deleteMatch;
    private JMenuItem addMatch;
    private ViewTabPanelFunctions controller;
    private GraphsMenu$InternalGraphSelectionListener listener;
    
    public GraphsMenu(final ViewTabPanelFunctions viewTabPanelFunctions) {
        super("Graphs");
        this.listener = new GraphsMenu$InternalGraphSelectionListener(this, null);
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        final int menuShortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        viewTabPanelFunctions.getGraphs().getPrimaryGraph().getIntermediateListeners().addIntermediateListener(this.listener);
        viewTabPanelFunctions.getGraphs().getSecondaryGraph().getIntermediateListeners().addIntermediateListener(this.listener);
        viewTabPanelFunctions.getGraphs().getCombinedGraph().getIntermediateListeners().addIntermediateListener(this.listener);
        this.setMnemonic('G');
        this.graphSettings = GuiUtils.buildMenuItem("Graph Settings", 'G', 113, 0, new ShowGraphSettingsDialogAction(viewTabPanelFunctions));
        this.HierarchicalLayout = GuiUtils.buildMenuItem("Hierarchical Layout", 'H', 72, menuShortcutKeyMask | 0x40, new HierarchicalGraphLayoutAction(viewTabPanelFunctions));
        this.orthogonalLayout = GuiUtils.buildMenuItem("Orthogonal Layout", 'L', 79, menuShortcutKeyMask | 0x40, new OrthogonalGraphLayoutAction(viewTabPanelFunctions));
        this.circularLayout = GuiUtils.buildMenuItem("Circular Layout", 'C', 67, menuShortcutKeyMask | 0x40, new CircularGraphLayoutAction(viewTabPanelFunctions));
        this.fitContent = GuiUtils.buildMenuItem("Fit Graph", 'F', 77, menuShortcutKeyMask | 0x40, new FitGraphContentAction(viewTabPanelFunctions));
        this.zoomToSelected = GuiUtils.buildMenuItem("Zoom to Selected", 'Z', 83, menuShortcutKeyMask | 0x40, new ZoomToSelectedAction(viewTabPanelFunctions));
        this.zoomIn = GuiUtils.buildMenuItem("Zoom in", 'I', 521, menuShortcutKeyMask, new ZoomInAction(viewTabPanelFunctions));
        this.zoomOut = GuiUtils.buildMenuItem("Zoom out", 'O', 45, menuShortcutKeyMask, new ZoomOutAction(viewTabPanelFunctions));
        this.deleteMatch = GuiUtils.buildMenuItem("Delete Matches", 'D', new DeleteNodeMatchAction(viewTabPanelFunctions));
        this.addMatch = GuiUtils.buildMenuItem("Add Match", 'A', new AddNodeMatchAction(viewTabPanelFunctions));
        this.add(this.graphSettings);
        this.add(new JSeparator());
        this.add(this.HierarchicalLayout);
        this.add(this.orthogonalLayout);
        this.add(this.circularLayout);
        this.add(new JSeparator());
        this.add(this.fitContent);
        this.add(this.zoomToSelected);
        this.add(this.zoomIn);
        this.add(this.zoomOut);
        this.add(new JSeparator());
        this.add(this.deleteMatch);
        this.add(this.addMatch);
        this.addMatch.setEnabled(false);
        this.deleteMatch.setEnabled(false);
    }
    
    public void dispose() {
        this.controller.getGraphs().getPrimaryGraph().getIntermediateListeners().removeIntermediateListener(this.listener);
        this.controller.getGraphs().getSecondaryGraph().getIntermediateListeners().removeIntermediateListener(this.listener);
        this.controller.getGraphs().getCombinedGraph().getIntermediateListeners().removeIntermediateListener(this.listener);
        this.controller = null;
        this.listener = null;
        this.graphSettings = null;
        this.HierarchicalLayout = null;
        this.orthogonalLayout = null;
        this.circularLayout = null;
        this.fitContent = null;
        this.zoomToSelected = null;
        this.deleteMatch = null;
        this.addMatch = null;
    }
}
