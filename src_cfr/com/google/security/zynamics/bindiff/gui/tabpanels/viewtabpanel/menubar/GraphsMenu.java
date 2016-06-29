/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.ZoomInAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.ZoomOutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.AddNodeMatchAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CircularGraphLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.DeleteNodeMatchAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.FitGraphContentAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.HierarchicalGraphLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.OrthogonalGraphLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ShowGraphSettingsDialogAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ZoomToSelectedAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.GraphsMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.GraphsMenu$InternalGraphSelectionListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class GraphsMenu
extends JMenu {
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

    public GraphsMenu(ViewTabPanelFunctions viewTabPanelFunctions) {
        super("Graphs");
        this.listener = new GraphsMenu$InternalGraphSelectionListener(this, null);
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        int n2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        viewTabPanelFunctions.getGraphs().getPrimaryGraph().getIntermediateListeners().addIntermediateListener(this.listener);
        viewTabPanelFunctions.getGraphs().getSecondaryGraph().getIntermediateListeners().addIntermediateListener(this.listener);
        viewTabPanelFunctions.getGraphs().getCombinedGraph().getIntermediateListeners().addIntermediateListener(this.listener);
        this.setMnemonic('G');
        this.graphSettings = GuiUtils.buildMenuItem("Graph Settings", 'G', 113, 0, new ShowGraphSettingsDialogAction(viewTabPanelFunctions));
        this.HierarchicalLayout = GuiUtils.buildMenuItem("Hierarchical Layout", 'H', 72, n2 | 64, new HierarchicalGraphLayoutAction(viewTabPanelFunctions));
        this.orthogonalLayout = GuiUtils.buildMenuItem("Orthogonal Layout", 'L', 79, n2 | 64, new OrthogonalGraphLayoutAction(viewTabPanelFunctions));
        this.circularLayout = GuiUtils.buildMenuItem("Circular Layout", 'C', 67, n2 | 64, new CircularGraphLayoutAction(viewTabPanelFunctions));
        this.fitContent = GuiUtils.buildMenuItem("Fit Graph", 'F', 77, n2 | 64, new FitGraphContentAction(viewTabPanelFunctions));
        this.zoomToSelected = GuiUtils.buildMenuItem("Zoom to Selected", 'Z', 83, n2 | 64, new ZoomToSelectedAction(viewTabPanelFunctions));
        this.zoomIn = GuiUtils.buildMenuItem("Zoom in", 'I', 521, n2, new ZoomInAction(viewTabPanelFunctions));
        this.zoomOut = GuiUtils.buildMenuItem("Zoom out", 'O', 45, n2, new ZoomOutAction(viewTabPanelFunctions));
        this.deleteMatch = GuiUtils.buildMenuItem("Delete Matches", 'D', (AbstractAction)new DeleteNodeMatchAction(viewTabPanelFunctions));
        this.addMatch = GuiUtils.buildMenuItem("Add Match", 'A', (AbstractAction)new AddNodeMatchAction(viewTabPanelFunctions));
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

    static /* synthetic */ ViewTabPanelFunctions access$100(GraphsMenu graphsMenu) {
        return graphsMenu.controller;
    }

    static /* synthetic */ JMenuItem access$200(GraphsMenu graphsMenu) {
        return graphsMenu.addMatch;
    }

    static /* synthetic */ JMenuItem access$300(GraphsMenu graphsMenu) {
        return graphsMenu.deleteMatch;
    }
}

