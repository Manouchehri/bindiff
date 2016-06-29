/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
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
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ViewToolbarPanel
extends JPanel {
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
    private ViewToolbarPanel$InternalSettingsListener settingsListener;
    private ViewToolbarPanel$InternalSearchButtonsListener buttonListener;
    private final GraphSearchField searchField;
    private final GraphSearchOptionsDialog searchOptionsDialog;
    private final SearchResultsDialog searchResultsDialog;
    private ViewTabPanelFunctions controller;
    private GraphSettings settings;
    private final JButton clearSearchResultsButton;
    private final JButton searchOptionsButton;
    private final JButton graphSyncButton;
    private final JToolBar groupSave;
    private final JToolBar groupView;
    private final JToolBar groupLayout;
    private final JToolBar groupModes;
    private final JToolBar groupSelection;
    private final JToolBar groupFitContent;

    public ViewToolbarPanel(ViewTabPanelFunctions viewTabPanelFunctions) {
        super(new BorderLayout());
        this.settingsListener = new ViewToolbarPanel$InternalSettingsListener(this, null);
        this.buttonListener = new ViewToolbarPanel$InternalSearchButtonsListener(this);
        this.clearSearchResultsButton = new JButton();
        this.searchOptionsButton = new JButton(ICON_OPTIONS);
        this.graphSyncButton = new JButton();
        this.groupSave = new JToolBar();
        this.groupView = new JToolBar();
        this.groupLayout = new JToolBar();
        this.groupModes = new JToolBar();
        this.groupSelection = new JToolBar();
        this.groupFitContent = new JToolBar();
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.settings = viewTabPanelFunctions.getGraphSettings();
        this.searchField = new GraphSearchField(viewTabPanelFunctions, this.clearSearchResultsButton);
        this.searchResultsDialog = new SearchResultsDialog(viewTabPanelFunctions.getMainWindow(), this.searchField);
        this.searchOptionsDialog = new GraphSearchOptionsDialog(viewTabPanelFunctions.getMainWindow(), viewTabPanelFunctions.getGraphs().getCombinedGraph());
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
        JButton jButton = null;
        jButton = this.groupSave.add(new ResetDefaultViewLayoutAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(DEFAULT_WINDOW_LAYOUT_UP);
        jButton.setRolloverIcon(DEFAULT_WINDOW_LAYOUT_HOVER);
        jButton.setPressedIcon(DEFAULT_WINDOW_LAYOUT_DOWN);
        jButton.setToolTipText("Reset default Window Layout");
        jButton = this.groupView.add(new SwitchToNormalViewModeAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW ? VIEW_MODE_NORMAL_UP : VIEW_MODE_NORMAL_UP);
        jButton.setRolloverIcon(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW ? VIEW_MODE_NORMAL_HOVER : VIEW_MODE_NORMAL_HOVER);
        jButton.setPressedIcon(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW ? VIEW_MODE_NORMAL_DOWN : VIEW_MODE_NORMAL_DOWN);
        jButton.setToolTipText("Switch to Normal View Mode");
        jButton = this.groupView.add(new SwitchToCombinedViewModeAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW ? VIEW_MODE_COMBINED_UP : VIEW_MODE_COMBINED_UP);
        jButton.setRolloverIcon(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW ? VIEW_MODE_COMBINED_HOVER : VIEW_MODE_COMBINED_HOVER);
        jButton.setPressedIcon(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW ? VIEW_MODE_COMBINED_DOWN : VIEW_MODE_COMBINED_DOWN);
        jButton.setToolTipText("Switch to Combined View Mode");
        jButton = this.groupLayout.add(new HierarchicalGraphLayoutAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(HIERARCHIC_LAYOUT_UP);
        jButton.setRolloverIcon(HIERARCHIC_LAYOUT_HOVER);
        jButton.setPressedIcon(HIERARCHIC_LAYOUT_DOWN);
        jButton.setToolTipText("Switch to Hierarchical Layout");
        jButton = this.groupLayout.add(new OrthogonalGraphLayoutAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(ORTHOGONAL_LAYOUT_UP);
        jButton.setRolloverIcon(ORTHOGONAL_LAYOUT_HOVER);
        jButton.setPressedIcon(ORTHOGONAL_LAYOUT_DOWN);
        jButton.setToolTipText("Switch to Orthogonal Layout");
        jButton = this.groupLayout.add(new CircularGraphLayoutAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(CIRCULAR_LAYOUT_UP);
        jButton.setRolloverIcon(CIRCULAR_LAYOUT_HOVER);
        jButton.setPressedIcon(CIRCULAR_LAYOUT_DOWN);
        jButton.setToolTipText("Switch to Circlular Layout");
        boolean bl2 = this.settings.getLayoutSettings().getAutomaticLayouting();
        jButton = this.groupModes.add(new ToggleAutomaticLayoutAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(bl2 ? AUTOLAYOUT_ON_UP : AUTOLAYOUT_OFF_UP);
        jButton.setRolloverIcon(bl2 ? AUTOLAYOUT_ON_HOVER : AUTOLAYOUT_OFF_HOVER);
        jButton.setPressedIcon(bl2 ? AUTOLAYOUT_ON_DOWN : AUTOLAYOUT_OFF_DOWN);
        jButton.setToolTipText("Toogle Autolayout");
        boolean bl3 = this.settings.getProximitySettings().getProximityBrowsing();
        jButton = this.groupModes.add(new ToggleProximityBrowsingAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(bl3 ? PROXIMITY_BROWSING_ON_UP : PROXIMITY_BROWSING_OFF_UP);
        jButton.setRolloverIcon(bl3 ? PROXIMITY_BROWSING_ON_HOVER : PROXIMITY_BROWSING_OFF_HOVER);
        jButton.setPressedIcon(bl3 ? PROXIMITY_BROWSING_ON_DOWN : PROXIMITY_BROWSING_OFF_DOWN);
        jButton.setToolTipText("Toogle Proximity Browsing");
        boolean bl4 = this.settings.getProximitySettings().getProximityBrowsingFrozen();
        jButton = this.groupModes.add(new ToggleProximityFreezeModeAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        if (bl3) {
            jButton.setIcon(bl4 ? PROXIMITY_FREEZE_ON_UP : PROXIMITY_FREEZE_OFF_UP);
            jButton.setRolloverIcon(bl4 ? PROXIMITY_FREEZE_ON_HOVER : PROXIMITY_FREEZE_OFF_HOVER);
            jButton.setPressedIcon(bl4 ? PROXIMITY_FREEZE_ON_DOWN : PROXIMITY_FREEZE_OFF_DOWN);
        } else {
            jButton.setIcon(bl4 ? PROXIMITY_FREEZE_ON_UP_GRAY : PROXIMITY_FREEZE_OFF_UP_GRAY);
            jButton.setRolloverIcon(bl4 ? PROXIMITY_FREEZE_ON_HOVER_GRAY : PROXIMITY_FREEZE_OFF_HOVER_GRAY);
            jButton.setPressedIcon(bl4 ? PROXIMITY_FREEZE_ON_DOWN_GRAY : PROXIMITY_FREEZE_OFF_DOWN_GRAY);
        }
        jButton.setToolTipText("Toogle Proximity Freeze");
        jButton = this.groupSelection.add(new SelectByCriteriaAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(SELECT_BY_CRITERIA_UP);
        jButton.setRolloverIcon(SELECT_BY_CRITERIA_HOVER);
        jButton.setPressedIcon(SELECT_BY_CRITERIA_DOWN);
        jButton.setToolTipText("Select by Criteria");
        jButton = this.groupSelection.add(new SelectAncestorsAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(SELECT_ANCESTORS_UP);
        jButton.setRolloverIcon(SELECT_ANCESTORS_HOVER);
        jButton.setPressedIcon(SELECT_ANCESTORS_DOWN);
        jButton.setToolTipText("Select Ancestors");
        jButton = this.groupSelection.add(new SelectSuccessorsAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(SELECT_SUCCESSORS_UP);
        jButton.setRolloverIcon(SELECT_SUCCESSORS_HOVER);
        jButton.setPressedIcon(SELECT_SUCCESSORS_DOWN);
        jButton.setToolTipText("Select Successors");
        if (Toolkit.getDefaultToolkit().getScreenSize().getWidth() > 1024.0) {
            jButton = this.groupSelection.add(new InverseSelectionAction(viewTabPanelFunctions));
            jButton.setMargin(new Insets(0, 0, 0, 0));
            jButton.setRolloverEnabled(true);
            jButton.setIcon(INVERT_SELECTION_UP);
            jButton.setRolloverIcon(INVERT_SELECTION_HOVER);
            jButton.setPressedIcon(INVERT_SELECTION_DOWN);
            jButton.setToolTipText("Invert Selection");
        }
        jButton = this.groupFitContent.add(new FitGraphContentAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(FIT_GRAPH_CONTENT_UP);
        jButton.setRolloverIcon(FIT_GRAPH_CONTENT_HOVER);
        jButton.setPressedIcon(FIT_GRAPH_CONTENT_DOWN);
        jButton.setToolTipText("Fit Graph Content");
        jButton = this.groupFitContent.add(new ZoomToSelectedAction(viewTabPanelFunctions));
        jButton.setMargin(new Insets(0, 0, 0, 0));
        jButton.setRolloverEnabled(true);
        jButton.setIcon(ZOOM_TO_SELECTED_UP);
        jButton.setRolloverIcon(ZOOM_TO_SELECTED_HOVER);
        jButton.setPressedIcon(ZOOM_TO_SELECTED_DOWN);
        jButton.setToolTipText("Zoom to selected Nodes");
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.groupSave, "West");
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.add((Component)this.groupView, "West");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.add((Component)this.groupLayout, "West");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.add((Component)this.groupFitContent, "West");
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.add((Component)this.groupSelection, "West");
        JPanel jPanel6 = new JPanel(new BorderLayout());
        jPanel6.add((Component)this.groupModes, "West");
        jPanel.add((Component)jPanel2, "Center");
        jPanel2.add((Component)jPanel3, "Center");
        jPanel3.add((Component)jPanel4, "Center");
        jPanel4.add((Component)jPanel5, "Center");
        jPanel5.add((Component)jPanel6, "Center");
        jPanel6.add(this.createRightToolbarPanel());
        this.add((Component)jPanel, "Center");
    }

    private JPanel createRightToolbarPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
        jPanel.add((Component)this.createSyncPanel(), "West");
        jPanel.add((Component)this.createSearchPanel(), "Center");
        return jPanel;
    }

    private JPanel createSearchPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setPreferredSize(new Dimension(jPanel.getPreferredSize().width, 25));
        this.searchField.setPreferredSize(new Dimension(this.getPreferredSize().width, 20));
        this.searchField.setBackground(Color.WHITE);
        JButton jButton = new JButton(new ShowSearchResultsDialogAction(this.controller));
        jButton.setText("Results");
        jButton.setBackground(Color.WHITE);
        jButton.setFocusable(false);
        this.clearSearchResultsButton.setToolTipText("Clear Search Results");
        this.clearSearchResultsButton.setFocusable(false);
        this.clearSearchResultsButton.setBackground(Color.WHITE);
        this.clearSearchResultsButton.setPreferredSize(new Dimension(32, this.clearSearchResultsButton.getPreferredSize().height));
        this.searchOptionsButton.setToolTipText("Search Settings");
        this.searchOptionsButton.setFocusable(false);
        this.searchOptionsButton.setBackground(Color.WHITE);
        this.searchOptionsButton.setPreferredSize(new Dimension(32, this.clearSearchResultsButton.getPreferredSize().height));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(0, 1, 0, 1));
        jPanel2.add((Component)this.searchOptionsButton, "Center");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.add((Component)this.clearSearchResultsButton, "Center");
        jPanel3.add((Component)jPanel2, "East");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new EmptyBorder(0, 1, 0, 0));
        jPanel4.add((Component)jButton, "Center");
        jPanel4.add((Component)jPanel3, "West");
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.setBorder(new EmptyBorder(1, 1, 1, 1));
        jPanel5.add((Component)this.searchField, "Center");
        jPanel5.add((Component)jPanel4, "East");
        jPanel.add((Component)jPanel5, "Center");
        JPanel jPanel6 = new JPanel(new BorderLayout());
        jPanel6.setBorder(new EmptyBorder(6, 10, 6, 5));
        jPanel6.add((Component)jPanel, "Center");
        return jPanel6;
    }

    private JPanel createSyncPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        this.graphSyncButton.addActionListener(new ToggleGraphSynchronizationAction(this.controller));
        this.graphSyncButton.setMargin(new Insets(0, 0, 0, 0));
        this.graphSyncButton.setBorderPainted(false);
        this.graphSyncButton.setContentAreaFilled(false);
        this.graphSyncButton.setFocusable(false);
        this.graphSyncButton.setRolloverEnabled(true);
        this.graphSyncButton.setIcon(this.settings.isSync() ? SYNC_GRAPHS_ON_UP : SYNC_GRAPHS_OFF_UP);
        this.graphSyncButton.setRolloverIcon(this.settings.isSync() ? SYNC_GRAPHS_ON_HOVER : SYNC_GRAPHS_OFF_HOVER);
        this.graphSyncButton.setPressedIcon(this.settings.isSync() ? SYNC_GRAPHS_OFF_DOWN : SYNC_GRAPHS_ON_DOWN);
        this.graphSyncButton.setToolTipText("Toogle Graph Synchronization");
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel2.add((Component)this.graphSyncButton, "Center");
        jPanel.add((Component)new JLabel("  Sync"), "West");
        jPanel.add((Component)jPanel2, "Center");
        return jPanel;
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

    public void setCaretIntoJumpToAddressField(ESide eSide) {
        this.searchField.setCaretIntoJumpToAddressField(eSide);
    }

    public void setCaretIntoSearchField() {
        this.searchField.setCaretIntoSearchField();
    }

    static /* synthetic */ JToolBar access$100(ViewToolbarPanel viewToolbarPanel) {
        return viewToolbarPanel.groupModes;
    }

    static /* synthetic */ Icon access$200() {
        return AUTOLAYOUT_ON_UP;
    }

    static /* synthetic */ Icon access$300() {
        return AUTOLAYOUT_OFF_UP;
    }

    static /* synthetic */ Icon access$400() {
        return AUTOLAYOUT_ON_HOVER;
    }

    static /* synthetic */ Icon access$500() {
        return AUTOLAYOUT_OFF_HOVER;
    }

    static /* synthetic */ Icon access$600() {
        return AUTOLAYOUT_ON_DOWN;
    }

    static /* synthetic */ Icon access$700() {
        return AUTOLAYOUT_OFF_DOWN;
    }

    static /* synthetic */ Icon access$800() {
        return SYNC_GRAPHS_ON_UP;
    }

    static /* synthetic */ Icon access$900() {
        return SYNC_GRAPHS_OFF_UP;
    }

    static /* synthetic */ JButton access$1000(ViewToolbarPanel viewToolbarPanel) {
        return viewToolbarPanel.graphSyncButton;
    }

    static /* synthetic */ Icon access$1100() {
        return SYNC_GRAPHS_ON_HOVER;
    }

    static /* synthetic */ Icon access$1200() {
        return SYNC_GRAPHS_OFF_HOVER;
    }

    static /* synthetic */ Icon access$1300() {
        return SYNC_GRAPHS_ON_DOWN;
    }

    static /* synthetic */ Icon access$1400() {
        return SYNC_GRAPHS_OFF_DOWN;
    }

    static /* synthetic */ Icon access$1500() {
        return PROXIMITY_BROWSING_ON_UP;
    }

    static /* synthetic */ Icon access$1600() {
        return PROXIMITY_BROWSING_OFF_UP;
    }

    static /* synthetic */ Icon access$1700() {
        return PROXIMITY_BROWSING_ON_HOVER;
    }

    static /* synthetic */ Icon access$1800() {
        return PROXIMITY_BROWSING_OFF_HOVER;
    }

    static /* synthetic */ Icon access$1900() {
        return PROXIMITY_BROWSING_ON_DOWN;
    }

    static /* synthetic */ Icon access$2000() {
        return PROXIMITY_BROWSING_OFF_DOWN;
    }

    static /* synthetic */ Icon access$2100() {
        return PROXIMITY_FREEZE_ON_UP;
    }

    static /* synthetic */ Icon access$2200() {
        return PROXIMITY_FREEZE_OFF_UP;
    }

    static /* synthetic */ Icon access$2300() {
        return PROXIMITY_FREEZE_ON_HOVER;
    }

    static /* synthetic */ Icon access$2400() {
        return PROXIMITY_FREEZE_OFF_HOVER;
    }

    static /* synthetic */ Icon access$2500() {
        return PROXIMITY_FREEZE_ON_DOWN;
    }

    static /* synthetic */ Icon access$2600() {
        return PROXIMITY_FREEZE_OFF_DOWN;
    }

    static /* synthetic */ Icon access$2700() {
        return PROXIMITY_FREEZE_ON_UP_GRAY;
    }

    static /* synthetic */ Icon access$2800() {
        return PROXIMITY_FREEZE_OFF_UP_GRAY;
    }

    static /* synthetic */ Icon access$2900() {
        return PROXIMITY_FREEZE_ON_HOVER_GRAY;
    }

    static /* synthetic */ Icon access$3000() {
        return PROXIMITY_FREEZE_OFF_HOVER_GRAY;
    }

    static /* synthetic */ Icon access$3100() {
        return PROXIMITY_FREEZE_ON_DOWN_GRAY;
    }

    static /* synthetic */ Icon access$3200() {
        return PROXIMITY_FREEZE_OFF_DOWN_GRAY;
    }

    static /* synthetic */ JButton access$3300(ViewToolbarPanel viewToolbarPanel) {
        return viewToolbarPanel.clearSearchResultsButton;
    }

    static /* synthetic */ ViewTabPanelFunctions access$3400(ViewToolbarPanel viewToolbarPanel) {
        return viewToolbarPanel.controller;
    }

    static /* synthetic */ GraphSearchField access$3500(ViewToolbarPanel viewToolbarPanel) {
        return viewToolbarPanel.searchField;
    }

    static /* synthetic */ JButton access$3600(ViewToolbarPanel viewToolbarPanel) {
        return viewToolbarPanel.searchOptionsButton;
    }

    static /* synthetic */ GraphSearchOptionsDialog access$3700(ViewToolbarPanel viewToolbarPanel) {
        return viewToolbarPanel.searchOptionsDialog;
    }
}

