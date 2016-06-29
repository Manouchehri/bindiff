package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.dialogs.GraphSearchOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CircularGraphLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.FitGraphContentAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.HierarchicalGraphLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.InverseSelectionAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.OrthogonalGraphLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ResetDefaultViewLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SelectAncestorsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SelectByCriteriaAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SelectSuccessorsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ShowSearchResultsDialogAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SwitchToCombinedViewModeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SwitchToNormalViewModeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleAutomaticLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleGraphSynchronizationAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleProximityBrowsingAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleProximityFreezeModeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ZoomToSelectedAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel$InternalSearchButtonsListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel$InternalSettingsListener;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class ViewToolbarPanel extends JPanel {
   private static final String ICONPATH = "data/toolbaricons/";
   private static final Icon DEFAULT_WINDOW_LAYOUT_UP = ImageUtils.getImageIcon("data/toolbaricons/default_window_layout_up.png");
   private static final Icon DEFAULT_WINDOW_LAYOUT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/default_window_layout_hover.png");
   private static final Icon DEFAULT_WINDOW_LAYOUT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/default_window_layout_down.png");
   private static final Icon VIEW_MODE_NORMAL_UP = ImageUtils.getImageIcon("data/toolbaricons/view_mode_normal_up.png");
   private static final Icon VIEW_MODE_NORMAL_HOVER = ImageUtils.getImageIcon("data/toolbaricons/view_mode_normal_hover.png");
   private static final Icon VIEW_MODE_NORMAL_DOWN = ImageUtils.getImageIcon("data/toolbaricons/view_mode_normal_down.png");
   private static final Icon VIEW_MODE_COMBINED_UP = ImageUtils.getImageIcon("data/toolbaricons/view_mode_combined_up.png");
   private static final Icon VIEW_MODE_COMBINED_HOVER = ImageUtils.getImageIcon("data/toolbaricons/view_mode_combined_hover.png");
   private static final Icon VIEW_MODE_COMBINED_DOWN = ImageUtils.getImageIcon("data/toolbaricons/view_mode_combined_down.png");
   private static final Icon HIERARCHIC_LAYOUT_UP = ImageUtils.getImageIcon("data/toolbaricons/hierarchic_layout_up.png");
   private static final Icon HIERARCHIC_LAYOUT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/hierarchic_layout_hover.png");
   private static final Icon HIERARCHIC_LAYOUT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/hierarchic_layout_down.png");
   private static final Icon ORTHOGONAL_LAYOUT_UP = ImageUtils.getImageIcon("data/toolbaricons/orthogonal_layout_up.png");
   private static final Icon ORTHOGONAL_LAYOUT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/orthogonal_layout_hover.png");
   private static final Icon ORTHOGONAL_LAYOUT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/orthogonal_layout_down.png");
   private static final Icon CIRCULAR_LAYOUT_UP = ImageUtils.getImageIcon("data/toolbaricons/circular_layout_up.png");
   private static final Icon CIRCULAR_LAYOUT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/circular_layout_hover.png");
   private static final Icon CIRCULAR_LAYOUT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/circular_layout_down.png");
   private static final Icon AUTOLAYOUT_ON_UP = ImageUtils.getImageIcon("data/toolbaricons/autolayout_on_up.png");
   private static final Icon AUTOLAYOUT_ON_HOVER = ImageUtils.getImageIcon("data/toolbaricons/autolayout_on_hover.png");
   private static final Icon AUTOLAYOUT_ON_DOWN = ImageUtils.getImageIcon("data/toolbaricons/autolayout_on_down.png");
   private static final Icon AUTOLAYOUT_OFF_UP = ImageUtils.getImageIcon("data/toolbaricons/autolayout_off_up.png");
   private static final Icon AUTOLAYOUT_OFF_HOVER = ImageUtils.getImageIcon("data/toolbaricons/autolayout_off_hover.png");
   private static final Icon AUTOLAYOUT_OFF_DOWN = ImageUtils.getImageIcon("data/toolbaricons/autolayout_off_down.png");
   private static final Icon PROXIMITY_BROWSING_ON_UP = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_on_up.png");
   private static final Icon PROXIMITY_BROWSING_ON_HOVER = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_on_hover.png");
   private static final Icon PROXIMITY_BROWSING_ON_DOWN = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_on_down.png");
   private static final Icon PROXIMITY_BROWSING_OFF_UP = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_off_up.png");
   private static final Icon PROXIMITY_BROWSING_OFF_HOVER = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_off_hover.png");
   private static final Icon PROXIMITY_BROWSING_OFF_DOWN = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_off_down.png");
   private static final Icon PROXIMITY_FREEZE_ON_UP = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_up.png");
   private static final Icon PROXIMITY_FREEZE_ON_HOVER = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_hover.png");
   private static final Icon PROXIMITY_FREEZE_ON_DOWN = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_down.png");
   private static final Icon PROXIMITY_FREEZE_OFF_UP = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_up.png");
   private static final Icon PROXIMITY_FREEZE_OFF_HOVER = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_hover.png");
   private static final Icon PROXIMITY_FREEZE_OFF_DOWN = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_down.png");
   private static final Icon PROXIMITY_FREEZE_ON_UP_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_up_gray.png");
   private static final Icon PROXIMITY_FREEZE_ON_HOVER_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_hover_gray.png");
   private static final Icon PROXIMITY_FREEZE_ON_DOWN_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_down_gray.png");
   private static final Icon PROXIMITY_FREEZE_OFF_UP_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_up_gray.png");
   private static final Icon PROXIMITY_FREEZE_OFF_HOVER_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_hover_gray.png");
   private static final Icon PROXIMITY_FREEZE_OFF_DOWN_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_down_gray.png");
   private static final Icon SELECT_ANCESTORS_UP = ImageUtils.getImageIcon("data/toolbaricons/select_ancestors_up.png");
   private static final Icon SELECT_ANCESTORS_HOVER = ImageUtils.getImageIcon("data/toolbaricons/select_ancestors_hover.png");
   private static final Icon SELECT_ANCESTORS_DOWN = ImageUtils.getImageIcon("data/toolbaricons/select_ancestors_down.png");
   private static final Icon SELECT_SUCCESSORS_UP = ImageUtils.getImageIcon("data/toolbaricons/select_successors_up.png");
   private static final Icon SELECT_SUCCESSORS_HOVER = ImageUtils.getImageIcon("data/toolbaricons/select_successors_hover.png");
   private static final Icon SELECT_SUCCESSORS_DOWN = ImageUtils.getImageIcon("data/toolbaricons/select_successors_down.png");
   private static final Icon INVERT_SELECTION_UP = ImageUtils.getImageIcon("data/toolbaricons/invert_selection_up.png");
   private static final Icon INVERT_SELECTION_HOVER = ImageUtils.getImageIcon("data/toolbaricons/invert_selection_hover.png");
   private static final Icon INVERT_SELECTION_DOWN = ImageUtils.getImageIcon("data/toolbaricons/invert_selection_down.png");
   private static final Icon SELECT_BY_CRITERIA_UP = ImageUtils.getImageIcon("data/toolbaricons/select_by_criteria_up.png");
   private static final Icon SELECT_BY_CRITERIA_HOVER = ImageUtils.getImageIcon("data/toolbaricons/select_by_criteria_hover.png");
   private static final Icon SELECT_BY_CRITERIA_DOWN = ImageUtils.getImageIcon("data/toolbaricons/select_by_criteria_down.png");
   private static final Icon FIT_GRAPH_CONTENT_UP = ImageUtils.getImageIcon("data/toolbaricons/fit_graph_to_panel_up.png");
   private static final Icon FIT_GRAPH_CONTENT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/fit_graph_to_panel_hover.png");
   private static final Icon FIT_GRAPH_CONTENT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/fit_graph_to_panel_down.png");
   private static final Icon ZOOM_TO_SELECTED_UP = ImageUtils.getImageIcon("data/toolbaricons/zoom_selected_up.png");
   private static final Icon ZOOM_TO_SELECTED_HOVER = ImageUtils.getImageIcon("data/toolbaricons/zoom_selected_hover.png");
   private static final Icon ZOOM_TO_SELECTED_DOWN = ImageUtils.getImageIcon("data/toolbaricons/zoom_selected_down.png");
   private static final Icon SYNC_GRAPHS_ON_UP = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_on_up.png");
   private static final Icon SYNC_GRAPHS_ON_HOVER = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_on_hover.png");
   private static final Icon SYNC_GRAPHS_ON_DOWN = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_on_down.png");
   private static final Icon SYNC_GRAPHS_OFF_UP = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_off_up.png");
   private static final Icon SYNC_GRAPHS_OFF_HOVER = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_off_hover.png");
   private static final Icon SYNC_GRAPHS_OFF_DOWN = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_off_down.png");
   private static final Icon ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
   private ViewToolbarPanel$InternalSettingsListener settingsListener = new ViewToolbarPanel$InternalSettingsListener(this, (ViewToolbarPanel$1)null);
   private ViewToolbarPanel$InternalSearchButtonsListener buttonListener = new ViewToolbarPanel$InternalSearchButtonsListener(this);
   private final GraphSearchField searchField;
   private final GraphSearchOptionsDialog searchOptionsDialog;
   private final SearchResultsDialog searchResultsDialog;
   private ViewTabPanelFunctions controller;
   private GraphSettings settings;
   private final JButton clearSearchResultsButton = new JButton();
   private final JButton searchOptionsButton;
   private final JButton graphSyncButton;
   private final JToolBar groupSave;
   private final JToolBar groupView;
   private final JToolBar groupLayout;
   private final JToolBar groupModes;
   private final JToolBar groupSelection;
   private final JToolBar groupFitContent;

   public ViewToolbarPanel(ViewTabPanelFunctions var1) {
      super(new BorderLayout());
      this.searchOptionsButton = new JButton(ICON_OPTIONS);
      this.graphSyncButton = new JButton();
      this.groupSave = new JToolBar();
      this.groupView = new JToolBar();
      this.groupLayout = new JToolBar();
      this.groupModes = new JToolBar();
      this.groupSelection = new JToolBar();
      this.groupFitContent = new JToolBar();
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.settings = var1.getGraphSettings();
      this.searchField = new GraphSearchField(var1, this.clearSearchResultsButton);
      this.searchResultsDialog = new SearchResultsDialog(var1.getMainWindow(), this.searchField);
      this.searchOptionsDialog = new GraphSearchOptionsDialog(var1.getMainWindow(), var1.getGraphs().getCombinedGraph());
      this.clearSearchResultsButton.addActionListener(this.buttonListener);
      this.searchOptionsButton.addActionListener(this.buttonListener);
      this.settings.addListener(this.settingsListener);
      this.groupSave.setFloatable(false);
      this.groupView.setFloatable(false);
      this.groupLayout.setFloatable(false);
      this.groupModes.setFloatable(false);
      this.groupSelection.setFloatable(false);
      this.groupFitContent.setFloatable(false);
      this.groupSave.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
      this.groupView.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
      this.groupLayout.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
      this.groupSelection.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
      this.groupFitContent.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
      this.groupModes.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY)));
      this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
      JButton var2 = null;
      var2 = this.groupSave.add(new ResetDefaultViewLayoutAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(DEFAULT_WINDOW_LAYOUT_UP);
      var2.setRolloverIcon(DEFAULT_WINDOW_LAYOUT_HOVER);
      var2.setPressedIcon(DEFAULT_WINDOW_LAYOUT_DOWN);
      var2.setToolTipText("Reset default Window Layout");
      var2 = this.groupView.add(new SwitchToNormalViewModeAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW?VIEW_MODE_NORMAL_UP:VIEW_MODE_NORMAL_UP);
      var2.setRolloverIcon(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW?VIEW_MODE_NORMAL_HOVER:VIEW_MODE_NORMAL_HOVER);
      var2.setPressedIcon(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW?VIEW_MODE_NORMAL_DOWN:VIEW_MODE_NORMAL_DOWN);
      var2.setToolTipText("Switch to Normal View Mode");
      var2 = this.groupView.add(new SwitchToCombinedViewModeAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW?VIEW_MODE_COMBINED_UP:VIEW_MODE_COMBINED_UP);
      var2.setRolloverIcon(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW?VIEW_MODE_COMBINED_HOVER:VIEW_MODE_COMBINED_HOVER);
      var2.setPressedIcon(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW?VIEW_MODE_COMBINED_DOWN:VIEW_MODE_COMBINED_DOWN);
      var2.setToolTipText("Switch to Combined View Mode");
      var2 = this.groupLayout.add(new HierarchicalGraphLayoutAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(HIERARCHIC_LAYOUT_UP);
      var2.setRolloverIcon(HIERARCHIC_LAYOUT_HOVER);
      var2.setPressedIcon(HIERARCHIC_LAYOUT_DOWN);
      var2.setToolTipText("Switch to Hierarchical Layout");
      var2 = this.groupLayout.add(new OrthogonalGraphLayoutAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(ORTHOGONAL_LAYOUT_UP);
      var2.setRolloverIcon(ORTHOGONAL_LAYOUT_HOVER);
      var2.setPressedIcon(ORTHOGONAL_LAYOUT_DOWN);
      var2.setToolTipText("Switch to Orthogonal Layout");
      var2 = this.groupLayout.add(new CircularGraphLayoutAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(CIRCULAR_LAYOUT_UP);
      var2.setRolloverIcon(CIRCULAR_LAYOUT_HOVER);
      var2.setPressedIcon(CIRCULAR_LAYOUT_DOWN);
      var2.setToolTipText("Switch to Circlular Layout");
      boolean var3 = this.settings.getLayoutSettings().getAutomaticLayouting();
      var2 = this.groupModes.add(new ToggleAutomaticLayoutAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(var3?AUTOLAYOUT_ON_UP:AUTOLAYOUT_OFF_UP);
      var2.setRolloverIcon(var3?AUTOLAYOUT_ON_HOVER:AUTOLAYOUT_OFF_HOVER);
      var2.setPressedIcon(var3?AUTOLAYOUT_ON_DOWN:AUTOLAYOUT_OFF_DOWN);
      var2.setToolTipText("Toogle Autolayout");
      boolean var4 = this.settings.getProximitySettings().getProximityBrowsing();
      var2 = this.groupModes.add(new ToggleProximityBrowsingAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(var4?PROXIMITY_BROWSING_ON_UP:PROXIMITY_BROWSING_OFF_UP);
      var2.setRolloverIcon(var4?PROXIMITY_BROWSING_ON_HOVER:PROXIMITY_BROWSING_OFF_HOVER);
      var2.setPressedIcon(var4?PROXIMITY_BROWSING_ON_DOWN:PROXIMITY_BROWSING_OFF_DOWN);
      var2.setToolTipText("Toogle Proximity Browsing");
      boolean var5 = this.settings.getProximitySettings().getProximityBrowsingFrozen();
      var2 = this.groupModes.add(new ToggleProximityFreezeModeAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      if(var4) {
         var2.setIcon(var5?PROXIMITY_FREEZE_ON_UP:PROXIMITY_FREEZE_OFF_UP);
         var2.setRolloverIcon(var5?PROXIMITY_FREEZE_ON_HOVER:PROXIMITY_FREEZE_OFF_HOVER);
         var2.setPressedIcon(var5?PROXIMITY_FREEZE_ON_DOWN:PROXIMITY_FREEZE_OFF_DOWN);
      } else {
         var2.setIcon(var5?PROXIMITY_FREEZE_ON_UP_GRAY:PROXIMITY_FREEZE_OFF_UP_GRAY);
         var2.setRolloverIcon(var5?PROXIMITY_FREEZE_ON_HOVER_GRAY:PROXIMITY_FREEZE_OFF_HOVER_GRAY);
         var2.setPressedIcon(var5?PROXIMITY_FREEZE_ON_DOWN_GRAY:PROXIMITY_FREEZE_OFF_DOWN_GRAY);
      }

      var2.setToolTipText("Toogle Proximity Freeze");
      var2 = this.groupSelection.add(new SelectByCriteriaAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(SELECT_BY_CRITERIA_UP);
      var2.setRolloverIcon(SELECT_BY_CRITERIA_HOVER);
      var2.setPressedIcon(SELECT_BY_CRITERIA_DOWN);
      var2.setToolTipText("Select by Criteria");
      var2 = this.groupSelection.add(new SelectAncestorsAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(SELECT_ANCESTORS_UP);
      var2.setRolloverIcon(SELECT_ANCESTORS_HOVER);
      var2.setPressedIcon(SELECT_ANCESTORS_DOWN);
      var2.setToolTipText("Select Ancestors");
      var2 = this.groupSelection.add(new SelectSuccessorsAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(SELECT_SUCCESSORS_UP);
      var2.setRolloverIcon(SELECT_SUCCESSORS_HOVER);
      var2.setPressedIcon(SELECT_SUCCESSORS_DOWN);
      var2.setToolTipText("Select Successors");
      if(Toolkit.getDefaultToolkit().getScreenSize().getWidth() > 1024.0D) {
         var2 = this.groupSelection.add(new InverseSelectionAction(var1));
         var2.setMargin(new Insets(0, 0, 0, 0));
         var2.setRolloverEnabled(true);
         var2.setIcon(INVERT_SELECTION_UP);
         var2.setRolloverIcon(INVERT_SELECTION_HOVER);
         var2.setPressedIcon(INVERT_SELECTION_DOWN);
         var2.setToolTipText("Invert Selection");
      }

      var2 = this.groupFitContent.add(new FitGraphContentAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(FIT_GRAPH_CONTENT_UP);
      var2.setRolloverIcon(FIT_GRAPH_CONTENT_HOVER);
      var2.setPressedIcon(FIT_GRAPH_CONTENT_DOWN);
      var2.setToolTipText("Fit Graph Content");
      var2 = this.groupFitContent.add(new ZoomToSelectedAction(var1));
      var2.setMargin(new Insets(0, 0, 0, 0));
      var2.setRolloverEnabled(true);
      var2.setIcon(ZOOM_TO_SELECTED_UP);
      var2.setRolloverIcon(ZOOM_TO_SELECTED_HOVER);
      var2.setPressedIcon(ZOOM_TO_SELECTED_DOWN);
      var2.setToolTipText("Zoom to selected Nodes");
      JPanel var6 = new JPanel(new BorderLayout());
      var6.add(this.groupSave, "West");
      JPanel var7 = new JPanel(new BorderLayout());
      var7.add(this.groupView, "West");
      JPanel var8 = new JPanel(new BorderLayout());
      var8.add(this.groupLayout, "West");
      JPanel var9 = new JPanel(new BorderLayout());
      var9.add(this.groupFitContent, "West");
      JPanel var10 = new JPanel(new BorderLayout());
      var10.add(this.groupSelection, "West");
      JPanel var11 = new JPanel(new BorderLayout());
      var11.add(this.groupModes, "West");
      var6.add(var7, "Center");
      var7.add(var8, "Center");
      var8.add(var9, "Center");
      var9.add(var10, "Center");
      var10.add(var11, "Center");
      var11.add(this.createRightToolbarPanel());
      this.add(var6, "Center");
   }

   private JPanel createRightToolbarPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
      var1.add(this.createSyncPanel(), "West");
      var1.add(this.createSearchPanel(), "Center");
      return var1;
   }

   private JPanel createSearchPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setPreferredSize(new Dimension(var1.getPreferredSize().width, 25));
      this.searchField.setPreferredSize(new Dimension(this.getPreferredSize().width, 20));
      this.searchField.setBackground(Color.WHITE);
      JButton var2 = new JButton(new ShowSearchResultsDialogAction(this.controller));
      var2.setText("Results");
      var2.setBackground(Color.WHITE);
      var2.setFocusable(false);
      this.clearSearchResultsButton.setToolTipText("Clear Search Results");
      this.clearSearchResultsButton.setFocusable(false);
      this.clearSearchResultsButton.setBackground(Color.WHITE);
      this.clearSearchResultsButton.setPreferredSize(new Dimension(32, this.clearSearchResultsButton.getPreferredSize().height));
      this.searchOptionsButton.setToolTipText("Search Settings");
      this.searchOptionsButton.setFocusable(false);
      this.searchOptionsButton.setBackground(Color.WHITE);
      this.searchOptionsButton.setPreferredSize(new Dimension(32, this.clearSearchResultsButton.getPreferredSize().height));
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(0, 1, 0, 1));
      var3.add(this.searchOptionsButton, "Center");
      JPanel var4 = new JPanel(new BorderLayout());
      var4.add(this.clearSearchResultsButton, "Center");
      var4.add(var3, "East");
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setBorder(new EmptyBorder(0, 1, 0, 0));
      var5.add(var2, "Center");
      var5.add(var4, "West");
      JPanel var6 = new JPanel(new BorderLayout());
      var6.setBorder(new EmptyBorder(1, 1, 1, 1));
      var6.add(this.searchField, "Center");
      var6.add(var5, "East");
      var1.add(var6, "Center");
      JPanel var7 = new JPanel(new BorderLayout());
      var7.setBorder(new EmptyBorder(6, 10, 6, 5));
      var7.add(var1, "Center");
      return var7;
   }

   private JPanel createSyncPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      this.graphSyncButton.addActionListener(new ToggleGraphSynchronizationAction(this.controller));
      this.graphSyncButton.setMargin(new Insets(0, 0, 0, 0));
      this.graphSyncButton.setBorderPainted(false);
      this.graphSyncButton.setContentAreaFilled(false);
      this.graphSyncButton.setFocusable(false);
      this.graphSyncButton.setRolloverEnabled(true);
      this.graphSyncButton.setIcon(this.settings.isSync()?SYNC_GRAPHS_ON_UP:SYNC_GRAPHS_OFF_UP);
      this.graphSyncButton.setRolloverIcon(this.settings.isSync()?SYNC_GRAPHS_ON_HOVER:SYNC_GRAPHS_OFF_HOVER);
      this.graphSyncButton.setPressedIcon(this.settings.isSync()?SYNC_GRAPHS_OFF_DOWN:SYNC_GRAPHS_ON_DOWN);
      this.graphSyncButton.setToolTipText("Toogle Graph Synchronization");
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      var2.add(this.graphSyncButton, "Center");
      var1.add(new JLabel("  Sync"), "West");
      var1.add(var2, "Center");
      return var1;
   }

   public void dispose() {
      this.clearSearchResultsButton.removeActionListener(this.buttonListener);
      this.searchOptionsButton.removeActionListener(this.buttonListener);
      this.settings.removeListener(this.settingsListener);
      this.searchField.dispose();
      this.searchResultsDialog.dispose();
      this.searchOptionsDialog.dispose();
      this.settingsListener = null;
      this.buttonListener = null;
      this.controller = null;
      this.settings = null;
   }

   public SearchResultsDialog getSearchResultsDialog() {
      return this.searchResultsDialog;
   }

   public void setCaretIntoJumpToAddressField(ESide var1) {
      this.searchField.setCaretIntoJumpToAddressField(var1);
   }

   public void setCaretIntoSearchField() {
      this.searchField.setCaretIntoSearchField();
   }

   // $FF: synthetic method
   static JToolBar access$100(ViewToolbarPanel var0) {
      return var0.groupModes;
   }

   // $FF: synthetic method
   static Icon access$200() {
      return AUTOLAYOUT_ON_UP;
   }

   // $FF: synthetic method
   static Icon access$300() {
      return AUTOLAYOUT_OFF_UP;
   }

   // $FF: synthetic method
   static Icon access$400() {
      return AUTOLAYOUT_ON_HOVER;
   }

   // $FF: synthetic method
   static Icon access$500() {
      return AUTOLAYOUT_OFF_HOVER;
   }

   // $FF: synthetic method
   static Icon access$600() {
      return AUTOLAYOUT_ON_DOWN;
   }

   // $FF: synthetic method
   static Icon access$700() {
      return AUTOLAYOUT_OFF_DOWN;
   }

   // $FF: synthetic method
   static Icon access$800() {
      return SYNC_GRAPHS_ON_UP;
   }

   // $FF: synthetic method
   static Icon access$900() {
      return SYNC_GRAPHS_OFF_UP;
   }

   // $FF: synthetic method
   static JButton access$1000(ViewToolbarPanel var0) {
      return var0.graphSyncButton;
   }

   // $FF: synthetic method
   static Icon access$1100() {
      return SYNC_GRAPHS_ON_HOVER;
   }

   // $FF: synthetic method
   static Icon access$1200() {
      return SYNC_GRAPHS_OFF_HOVER;
   }

   // $FF: synthetic method
   static Icon access$1300() {
      return SYNC_GRAPHS_ON_DOWN;
   }

   // $FF: synthetic method
   static Icon access$1400() {
      return SYNC_GRAPHS_OFF_DOWN;
   }

   // $FF: synthetic method
   static Icon access$1500() {
      return PROXIMITY_BROWSING_ON_UP;
   }

   // $FF: synthetic method
   static Icon access$1600() {
      return PROXIMITY_BROWSING_OFF_UP;
   }

   // $FF: synthetic method
   static Icon access$1700() {
      return PROXIMITY_BROWSING_ON_HOVER;
   }

   // $FF: synthetic method
   static Icon access$1800() {
      return PROXIMITY_BROWSING_OFF_HOVER;
   }

   // $FF: synthetic method
   static Icon access$1900() {
      return PROXIMITY_BROWSING_ON_DOWN;
   }

   // $FF: synthetic method
   static Icon access$2000() {
      return PROXIMITY_BROWSING_OFF_DOWN;
   }

   // $FF: synthetic method
   static Icon access$2100() {
      return PROXIMITY_FREEZE_ON_UP;
   }

   // $FF: synthetic method
   static Icon access$2200() {
      return PROXIMITY_FREEZE_OFF_UP;
   }

   // $FF: synthetic method
   static Icon access$2300() {
      return PROXIMITY_FREEZE_ON_HOVER;
   }

   // $FF: synthetic method
   static Icon access$2400() {
      return PROXIMITY_FREEZE_OFF_HOVER;
   }

   // $FF: synthetic method
   static Icon access$2500() {
      return PROXIMITY_FREEZE_ON_DOWN;
   }

   // $FF: synthetic method
   static Icon access$2600() {
      return PROXIMITY_FREEZE_OFF_DOWN;
   }

   // $FF: synthetic method
   static Icon access$2700() {
      return PROXIMITY_FREEZE_ON_UP_GRAY;
   }

   // $FF: synthetic method
   static Icon access$2800() {
      return PROXIMITY_FREEZE_OFF_UP_GRAY;
   }

   // $FF: synthetic method
   static Icon access$2900() {
      return PROXIMITY_FREEZE_ON_HOVER_GRAY;
   }

   // $FF: synthetic method
   static Icon access$3000() {
      return PROXIMITY_FREEZE_OFF_HOVER_GRAY;
   }

   // $FF: synthetic method
   static Icon access$3100() {
      return PROXIMITY_FREEZE_ON_DOWN_GRAY;
   }

   // $FF: synthetic method
   static Icon access$3200() {
      return PROXIMITY_FREEZE_OFF_DOWN_GRAY;
   }

   // $FF: synthetic method
   static JButton access$3300(ViewToolbarPanel var0) {
      return var0.clearSearchResultsButton;
   }

   // $FF: synthetic method
   static ViewTabPanelFunctions access$3400(ViewToolbarPanel var0) {
      return var0.controller;
   }

   // $FF: synthetic method
   static GraphSearchField access$3500(ViewToolbarPanel var0) {
      return var0.searchField;
   }

   // $FF: synthetic method
   static JButton access$3600(ViewToolbarPanel var0) {
      return var0.searchOptionsButton;
   }

   // $FF: synthetic method
   static GraphSearchOptionsDialog access$3700(ViewToolbarPanel var0) {
      return var0.searchOptionsDialog;
   }
}
