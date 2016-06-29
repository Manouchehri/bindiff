package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSeacherFunctions;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$2;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$3;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$CEditorBorder;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$CPopupChooserAction;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$CSearchAction;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$CZoomToAddressAction;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.IGraphSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.CHexFormatter;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.JMemoryBox;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.util.Iterator;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class GraphSearchField extends JPanel {
   private static int SEARCH_STRING_HISTORY_MAX = 50;
   private static final Icon ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
   private static final Icon ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
   private static final Icon ICON_NORMAL_SEARCH = ImageUtils.getImageIcon("data/buttonicons/normal-search.png");
   private static final Icon ICON_JUMP_TO_PRIMARY_ADDRESS = ImageUtils.getImageIcon("data/buttonicons/jump-primary-address.png");
   private static final Icon ICON_JUMP_TO_SECONDARY_ADDRESS = ImageUtils.getImageIcon("data/buttonicons/jump-secondary-address.png");
   private static final Icon ICON_NORMAL_SEARCH_FIELD = ImageUtils.getImageIcon("data/buttonicons/normal-searchfield.png");
   private static final Icon ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD = ImageUtils.getImageIcon("data/buttonicons/jump-primary-addressfield.png");
   private static final Icon ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD = ImageUtils.getImageIcon("data/buttonicons/jump-secondary-addressfield.png");
   private static final Color BACKGROUND_COLOR_FAIL;
   private static final Color BACKGROUND_COLOR_SUCCESS;
   private static final int ICON_SPACE = 38;
   private static final Insets BORDER_INSETS;
   private final ListenerProvider listeners = new ListenerProvider();
   private final MouseListener mouseListener;
   private final ViewTabPanelFunctions controller;
   private final GraphsContainer graphs;
   private final JMemoryBox searchCombo;
   private final JMemoryBox priJumpCombo;
   private final JMemoryBox secJumpCombo;
   private final JTextField searchField;
   private final JFormattedTextField priHexField;
   private final JFormattedTextField secHexField;
   private final JButton clearSearchResultsButton;
   private final GraphSearchField$CEditorBorder border;
   private final GraphSearchField$CSearchAction searchAction;
   private final GraphSearchField$CPopupChooserAction popupChooserAction;
   private Icon activeIcon;

   public GraphSearchField(ViewTabPanelFunctions var1, JButton var2) {
      super(new BorderLayout());
      this.searchCombo = new JMemoryBox(SEARCH_STRING_HISTORY_MAX);
      this.priJumpCombo = new JMemoryBox(SEARCH_STRING_HISTORY_MAX);
      this.secJumpCombo = new JMemoryBox(SEARCH_STRING_HISTORY_MAX);
      this.searchField = new JTextField();
      this.priHexField = new JFormattedTextField(new CHexFormatter(16));
      this.secHexField = new JFormattedTextField(new CHexFormatter(16));
      this.border = new GraphSearchField$CEditorBorder(this, (GraphSearchField$1)null);
      this.searchAction = new GraphSearchField$CSearchAction(this, (GraphSearchField$1)null);
      this.popupChooserAction = new GraphSearchField$CPopupChooserAction(this, (GraphSearchField$1)null);
      this.activeIcon = ICON_NORMAL_SEARCH_FIELD;
      this.clearSearchResultsButton = var2;
      this.clearSearchResultsButton.setIcon(ICON_CLEAR_GRAY);
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.graphs = var1.getGraphs();
      this.setEditors();
      this.searchField.setBorder(this.border);
      this.priHexField.setBorder(this.border);
      this.secHexField.setBorder(this.border);
      this.searchField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "search");
      this.searchField.getInputMap().put(KeyStroke.getKeyStroke(10, 1), "search");
      this.searchField.getInputMap().put(KeyStroke.getKeyStroke(10, 2), "search");
      this.searchField.getInputMap().put(KeyStroke.getKeyStroke(10, 3), "search");
      this.searchField.getActionMap().put("search", this.searchAction);
      this.priHexField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "zoomToAddress");
      this.priHexField.getActionMap().put("zoomToAddress", new GraphSearchField$CZoomToAddressAction(this, (GraphSearchField$1)null));
      this.secHexField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "zoomToAddress");
      this.secHexField.getActionMap().put("zoomToAddress", new GraphSearchField$CZoomToAddressAction(this, (GraphSearchField$1)null));
      this.mouseListener = new GraphSearchField$InternalMouseListener(this, (GraphSearchField$1)null);
      this.searchField.addMouseListener(this.mouseListener);
      this.priHexField.addMouseListener(this.mouseListener);
      this.secHexField.addMouseListener(this.mouseListener);
      this.add(this.searchCombo, "Center");
   }

   private JPopupMenu createPopup() {
      JPopupMenu var1 = new JPopupMenu();
      var1.add(GuiUtils.buildMenuItem("Search Node Contents", ICON_NORMAL_SEARCH, this.popupChooserAction));
      var1.add(new JSeparator());
      var1.add(GuiUtils.buildMenuItem("Jump to Primary Address", ICON_JUMP_TO_PRIMARY_ADDRESS, this.popupChooserAction));
      var1.add(GuiUtils.buildMenuItem("Jump to Secondary Address", ICON_JUMP_TO_SECONDARY_ADDRESS, this.popupChooserAction));
      return var1;
   }

   private void setEditors() {
      this.searchCombo.setEditor(new GraphSearchField$1(this));
      this.priJumpCombo.setEditor(new GraphSearchField$2(this));
      this.secJumpCombo.setEditor(new GraphSearchField$3(this));
   }

   private void updateSearchBox(Icon var1) {
      if(var1 == ICON_NORMAL_SEARCH && this.activeIcon == ICON_NORMAL_SEARCH_FIELD) {
         this.searchField.getCaret().setVisible(true);
         this.searchField.grabFocus();
         this.searchCombo.updateUI();
      } else if(var1 == ICON_JUMP_TO_PRIMARY_ADDRESS && this.activeIcon == ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD) {
         this.priHexField.getCaret().setVisible(true);
         this.priHexField.grabFocus();
         this.priJumpCombo.updateUI();
      } else if(var1 == ICON_JUMP_TO_SECONDARY_ADDRESS && this.activeIcon == ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD) {
         this.secHexField.getCaret().setVisible(true);
         this.secHexField.grabFocus();
         this.secJumpCombo.updateUI();
      } else {
         if(this.activeIcon == ICON_NORMAL_SEARCH_FIELD) {
            this.remove(this.searchCombo);
         } else if(this.activeIcon == ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD) {
            this.remove(this.priJumpCombo);
         } else if(this.activeIcon == ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD) {
            this.remove(this.secJumpCombo);
         }

         if(var1 == ICON_NORMAL_SEARCH) {
            this.activeIcon = ICON_NORMAL_SEARCH_FIELD;
         } else if(var1 == ICON_JUMP_TO_PRIMARY_ADDRESS) {
            this.activeIcon = ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD;
         } else if(var1 == ICON_JUMP_TO_SECONDARY_ADDRESS) {
            this.activeIcon = ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD;
         }

         if(this.activeIcon == ICON_NORMAL_SEARCH_FIELD) {
            this.add(this.searchCombo);
            this.searchField.getCaret().setVisible(true);
            this.searchField.grabFocus();
            this.searchCombo.updateUI();
         } else if(this.activeIcon == ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD) {
            this.add(this.priJumpCombo);
            this.priHexField.getCaret().setVisible(true);
            this.priHexField.grabFocus();
            this.priJumpCombo.updateUI();
         } else if(this.activeIcon == ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD) {
            this.add(this.secJumpCombo);
            this.secHexField.getCaret().setVisible(true);
            this.secHexField.grabFocus();
            this.secJumpCombo.updateUI();
         }

      }
   }

   public void addListener(IGraphSearchFieldListener var1) {
      this.listeners.addListener(var1);
   }

   public void dispose() {
      this.searchField.removeMouseListener(this.mouseListener);
      this.priHexField.removeMouseListener(this.mouseListener);
      this.secHexField.removeMouseListener(this.mouseListener);
   }

   public GraphsContainer getGraphs() {
      return this.graphs;
   }

   public void jumpToIndex(int var1, ESide var2) {
      Object var3;
      if(var2 == ESide.PRIMARY) {
         var3 = this.graphs.getPrimaryGraph();
      } else {
         var3 = this.graphs.getSecondaryGraph();
      }

      GraphSearcher var4 = ((BinDiffGraph)var3).getGraphSearcher();
      Object var5 = ((SearchResult)var4.getSubObjectResults().get(var1)).getObject();
      if(((BinDiffGraph)var3).getSettings().getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
         if(var5 instanceof ZyGraphNode) {
            var5 = ((SingleDiffNode)var5).getCombinedDiffNode();
         } else if(var5 instanceof ZyGraphEdge) {
            var5 = ((SingleDiffEdge)var5).getCombinedDiffEdge();
         }

         var3 = this.graphs.getCombinedGraph();
      }

      GraphSeacherFunctions.jumpToResultObject((BinDiffGraph)var3, var5, true);
   }

   public void notifySearchFieldListener() {
      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         IGraphSearchFieldListener var2 = (IGraphSearchFieldListener)var1.next();
         var2.searched();
      }

   }

   public void setCaretIntoJumpToAddressField(ESide var1) {
      this.updateSearchBox(var1 == ESide.PRIMARY?ICON_JUMP_TO_PRIMARY_ADDRESS:ICON_JUMP_TO_SECONDARY_ADDRESS);
   }

   public void setCaretIntoSearchField() {
      if(!this.searchField.hasFocus() || !this.searchField.getCaret().isVisible()) {
         this.updateSearchBox(ICON_NORMAL_SEARCH);
      }
   }

   // $FF: synthetic method
   static JTextField access$500(GraphSearchField var0) {
      return var0.searchField;
   }

   // $FF: synthetic method
   static JFormattedTextField access$600(GraphSearchField var0) {
      return var0.priHexField;
   }

   // $FF: synthetic method
   static JFormattedTextField access$700(GraphSearchField var0) {
      return var0.secHexField;
   }

   // $FF: synthetic method
   static Insets access$800() {
      return BORDER_INSETS;
   }

   // $FF: synthetic method
   static Icon access$900(GraphSearchField var0) {
      return var0.activeIcon;
   }

   // $FF: synthetic method
   static void access$1000(GraphSearchField var0, Icon var1) {
      var0.updateSearchBox(var1);
   }

   // $FF: synthetic method
   static GraphsContainer access$1100(GraphSearchField var0) {
      return var0.graphs;
   }

   // $FF: synthetic method
   static ListenerProvider access$1200(GraphSearchField var0) {
      return var0.listeners;
   }

   // $FF: synthetic method
   static JMemoryBox access$1300(GraphSearchField var0) {
      return var0.searchCombo;
   }

   // $FF: synthetic method
   static Color access$1400() {
      return BACKGROUND_COLOR_FAIL;
   }

   // $FF: synthetic method
   static Icon access$1500() {
      return ICON_CLEAR_GRAY;
   }

   // $FF: synthetic method
   static JButton access$1600(GraphSearchField var0) {
      return var0.clearSearchResultsButton;
   }

   // $FF: synthetic method
   static Color access$1700() {
      return BACKGROUND_COLOR_SUCCESS;
   }

   // $FF: synthetic method
   static Icon access$1800() {
      return ICON_CLEAR;
   }

   // $FF: synthetic method
   static ViewTabPanelFunctions access$1900(GraphSearchField var0) {
      return var0.controller;
   }

   // $FF: synthetic method
   static JMemoryBox access$2000(GraphSearchField var0) {
      return var0.priJumpCombo;
   }

   // $FF: synthetic method
   static JMemoryBox access$2100(GraphSearchField var0) {
      return var0.secJumpCombo;
   }

   // $FF: synthetic method
   static JPopupMenu access$2200(GraphSearchField var0) {
      return var0.createPopup();
   }

   static {
      BACKGROUND_COLOR_FAIL = Colors.GRAY224;
      BACKGROUND_COLOR_SUCCESS = Color.WHITE;
      BORDER_INSETS = new Insets(2, 38, 2, 0);
   }
}
