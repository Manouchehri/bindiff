package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.zylib.general.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.resources.*;

public class GraphSearchField extends JPanel
{
    private static int SEARCH_STRING_HISTORY_MAX;
    private static final Icon ICON_CLEAR;
    private static final Icon ICON_CLEAR_GRAY;
    private static final Icon ICON_NORMAL_SEARCH;
    private static final Icon ICON_JUMP_TO_PRIMARY_ADDRESS;
    private static final Icon ICON_JUMP_TO_SECONDARY_ADDRESS;
    private static final Icon ICON_NORMAL_SEARCH_FIELD;
    private static final Icon ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD;
    private static final Icon ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD;
    private static final Color BACKGROUND_COLOR_FAIL;
    private static final Color BACKGROUND_COLOR_SUCCESS;
    private static final int ICON_SPACE = 38;
    private static final Insets BORDER_INSETS;
    private final ListenerProvider listeners;
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
    
    public GraphSearchField(final ViewTabPanelFunctions viewTabPanelFunctions, final JButton clearSearchResultsButton) {
        super(new BorderLayout());
        this.listeners = new ListenerProvider();
        this.searchCombo = new JMemoryBox(GraphSearchField.SEARCH_STRING_HISTORY_MAX);
        this.priJumpCombo = new JMemoryBox(GraphSearchField.SEARCH_STRING_HISTORY_MAX);
        this.secJumpCombo = new JMemoryBox(GraphSearchField.SEARCH_STRING_HISTORY_MAX);
        this.searchField = new JTextField();
        this.priHexField = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CHexFormatter(16));
        this.secHexField = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CHexFormatter(16));
        this.border = new GraphSearchField$CEditorBorder(this, null);
        this.searchAction = new GraphSearchField$CSearchAction(this, null);
        this.popupChooserAction = new GraphSearchField$CPopupChooserAction(this, null);
        this.activeIcon = GraphSearchField.ICON_NORMAL_SEARCH_FIELD;
        (this.clearSearchResultsButton = clearSearchResultsButton).setIcon(GraphSearchField.ICON_CLEAR_GRAY);
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graphs = viewTabPanelFunctions.getGraphs();
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
        this.priHexField.getActionMap().put("zoomToAddress", new GraphSearchField$CZoomToAddressAction(this, null));
        this.secHexField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "zoomToAddress");
        this.secHexField.getActionMap().put("zoomToAddress", new GraphSearchField$CZoomToAddressAction(this, null));
        this.mouseListener = new GraphSearchField$InternalMouseListener(this, null);
        this.searchField.addMouseListener(this.mouseListener);
        this.priHexField.addMouseListener(this.mouseListener);
        this.secHexField.addMouseListener(this.mouseListener);
        this.add(this.searchCombo, "Center");
    }
    
    private JPopupMenu createPopup() {
        final JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(GuiUtils.buildMenuItem("Search Node Contents", GraphSearchField.ICON_NORMAL_SEARCH, this.popupChooserAction));
        popupMenu.add(new JSeparator());
        popupMenu.add(GuiUtils.buildMenuItem("Jump to Primary Address", GraphSearchField.ICON_JUMP_TO_PRIMARY_ADDRESS, this.popupChooserAction));
        popupMenu.add(GuiUtils.buildMenuItem("Jump to Secondary Address", GraphSearchField.ICON_JUMP_TO_SECONDARY_ADDRESS, this.popupChooserAction));
        return popupMenu;
    }
    
    private void setEditors() {
        this.searchCombo.setEditor(new GraphSearchField$1(this));
        this.priJumpCombo.setEditor(new GraphSearchField$2(this));
        this.secJumpCombo.setEditor(new GraphSearchField$3(this));
    }
    
    private void updateSearchBox(final Icon icon) {
        if (icon == GraphSearchField.ICON_NORMAL_SEARCH && this.activeIcon == GraphSearchField.ICON_NORMAL_SEARCH_FIELD) {
            this.searchField.getCaret().setVisible(true);
            this.searchField.grabFocus();
            this.searchCombo.updateUI();
            return;
        }
        if (icon == GraphSearchField.ICON_JUMP_TO_PRIMARY_ADDRESS && this.activeIcon == GraphSearchField.ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD) {
            this.priHexField.getCaret().setVisible(true);
            this.priHexField.grabFocus();
            this.priJumpCombo.updateUI();
            return;
        }
        if (icon == GraphSearchField.ICON_JUMP_TO_SECONDARY_ADDRESS && this.activeIcon == GraphSearchField.ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD) {
            this.secHexField.getCaret().setVisible(true);
            this.secHexField.grabFocus();
            this.secJumpCombo.updateUI();
            return;
        }
        if (this.activeIcon == GraphSearchField.ICON_NORMAL_SEARCH_FIELD) {
            this.remove(this.searchCombo);
        }
        else if (this.activeIcon == GraphSearchField.ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD) {
            this.remove(this.priJumpCombo);
        }
        else if (this.activeIcon == GraphSearchField.ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD) {
            this.remove(this.secJumpCombo);
        }
        if (icon == GraphSearchField.ICON_NORMAL_SEARCH) {
            this.activeIcon = GraphSearchField.ICON_NORMAL_SEARCH_FIELD;
        }
        else if (icon == GraphSearchField.ICON_JUMP_TO_PRIMARY_ADDRESS) {
            this.activeIcon = GraphSearchField.ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD;
        }
        else if (icon == GraphSearchField.ICON_JUMP_TO_SECONDARY_ADDRESS) {
            this.activeIcon = GraphSearchField.ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD;
        }
        if (this.activeIcon == GraphSearchField.ICON_NORMAL_SEARCH_FIELD) {
            this.add(this.searchCombo);
            this.searchField.getCaret().setVisible(true);
            this.searchField.grabFocus();
            this.searchCombo.updateUI();
        }
        else if (this.activeIcon == GraphSearchField.ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD) {
            this.add(this.priJumpCombo);
            this.priHexField.getCaret().setVisible(true);
            this.priHexField.grabFocus();
            this.priJumpCombo.updateUI();
        }
        else if (this.activeIcon == GraphSearchField.ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD) {
            this.add(this.secJumpCombo);
            this.secHexField.getCaret().setVisible(true);
            this.secHexField.grabFocus();
            this.secJumpCombo.updateUI();
        }
    }
    
    public void addListener(final IGraphSearchFieldListener graphSearchFieldListener) {
        this.listeners.addListener(graphSearchFieldListener);
    }
    
    public void dispose() {
        this.searchField.removeMouseListener(this.mouseListener);
        this.priHexField.removeMouseListener(this.mouseListener);
        this.secHexField.removeMouseListener(this.mouseListener);
    }
    
    public GraphsContainer getGraphs() {
        return this.graphs;
    }
    
    public void jumpToIndex(final int n, final ESide eSide) {
        BinDiffGraph binDiffGraph;
        if (eSide == ESide.PRIMARY) {
            binDiffGraph = this.graphs.getPrimaryGraph();
        }
        else {
            binDiffGraph = this.graphs.getSecondaryGraph();
        }
        Object o = binDiffGraph.getGraphSearcher().getSubObjectResults().get(n).getObject();
        if (binDiffGraph.getSettings().getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            if (o instanceof ZyGraphNode) {
                o = ((SingleDiffNode)o).getCombinedDiffNode();
            }
            else if (o instanceof ZyGraphEdge) {
                o = ((SingleDiffEdge)o).getCombinedDiffEdge();
            }
            binDiffGraph = this.graphs.getCombinedGraph();
        }
        GraphSeacherFunctions.jumpToResultObject(binDiffGraph, o, true);
    }
    
    public void notifySearchFieldListener() {
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().searched();
        }
    }
    
    public void setCaretIntoJumpToAddressField(final ESide eSide) {
        this.updateSearchBox((eSide == ESide.PRIMARY) ? GraphSearchField.ICON_JUMP_TO_PRIMARY_ADDRESS : GraphSearchField.ICON_JUMP_TO_SECONDARY_ADDRESS);
    }
    
    public void setCaretIntoSearchField() {
        if (this.searchField.hasFocus() && this.searchField.getCaret().isVisible()) {
            return;
        }
        this.updateSearchBox(GraphSearchField.ICON_NORMAL_SEARCH);
    }
    
    static {
        GraphSearchField.SEARCH_STRING_HISTORY_MAX = 50;
        ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
        ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
        ICON_NORMAL_SEARCH = ImageUtils.getImageIcon("data/buttonicons/normal-search.png");
        ICON_JUMP_TO_PRIMARY_ADDRESS = ImageUtils.getImageIcon("data/buttonicons/jump-primary-address.png");
        ICON_JUMP_TO_SECONDARY_ADDRESS = ImageUtils.getImageIcon("data/buttonicons/jump-secondary-address.png");
        ICON_NORMAL_SEARCH_FIELD = ImageUtils.getImageIcon("data/buttonicons/normal-searchfield.png");
        ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD = ImageUtils.getImageIcon("data/buttonicons/jump-primary-addressfield.png");
        ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD = ImageUtils.getImageIcon("data/buttonicons/jump-secondary-addressfield.png");
        BACKGROUND_COLOR_FAIL = Colors.GRAY224;
        BACKGROUND_COLOR_SUCCESS = Color.WHITE;
        BORDER_INSETS = new Insets(2, 38, 2, 0);
    }
}
