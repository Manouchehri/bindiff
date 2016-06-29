package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
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
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class GraphsMenu extends JMenu {
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
   private GraphsMenu$InternalGraphSelectionListener listener = new GraphsMenu$InternalGraphSelectionListener(this, (GraphsMenu$1)null);

   public GraphsMenu(ViewTabPanelFunctions var1) {
      super("Graphs");
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      int var2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      var1.getGraphs().getPrimaryGraph().getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)this.listener);
      var1.getGraphs().getSecondaryGraph().getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)this.listener);
      var1.getGraphs().getCombinedGraph().getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)this.listener);
      this.setMnemonic('G');
      this.graphSettings = GuiUtils.buildMenuItem("Graph Settings", 'G', 113, 0, new ShowGraphSettingsDialogAction(var1));
      this.HierarchicalLayout = GuiUtils.buildMenuItem("Hierarchical Layout", 'H', 72, var2 | 64, new HierarchicalGraphLayoutAction(var1));
      this.orthogonalLayout = GuiUtils.buildMenuItem("Orthogonal Layout", 'L', 79, var2 | 64, new OrthogonalGraphLayoutAction(var1));
      this.circularLayout = GuiUtils.buildMenuItem("Circular Layout", 'C', 67, var2 | 64, new CircularGraphLayoutAction(var1));
      this.fitContent = GuiUtils.buildMenuItem("Fit Graph", 'F', 77, var2 | 64, new FitGraphContentAction(var1));
      this.zoomToSelected = GuiUtils.buildMenuItem("Zoom to Selected", 'Z', 83, var2 | 64, new ZoomToSelectedAction(var1));
      this.zoomIn = GuiUtils.buildMenuItem("Zoom in", 'I', 521, var2, new ZoomInAction(var1));
      this.zoomOut = GuiUtils.buildMenuItem("Zoom out", 'O', 45, var2, new ZoomOutAction(var1));
      this.deleteMatch = GuiUtils.buildMenuItem("Delete Matches", 'D', new DeleteNodeMatchAction(var1));
      this.addMatch = GuiUtils.buildMenuItem("Add Match", 'A', new AddNodeMatchAction(var1));
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
      this.controller.getGraphs().getPrimaryGraph().getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)this.listener);
      this.controller.getGraphs().getSecondaryGraph().getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)this.listener);
      this.controller.getGraphs().getCombinedGraph().getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)this.listener);
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

   // $FF: synthetic method
   static ViewTabPanelFunctions access$100(GraphsMenu var0) {
      return var0.controller;
   }

   // $FF: synthetic method
   static JMenuItem access$200(GraphsMenu var0) {
      return var0.addMatch;
   }

   // $FF: synthetic method
   static JMenuItem access$300(GraphsMenu var0) {
      return var0.deleteMatch;
   }
}
