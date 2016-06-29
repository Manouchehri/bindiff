/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSeacherFunctions;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
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
import java.awt.Component;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ComboBoxEditor;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.text.Caret;

public class GraphSearchField
extends JPanel {
    private static int SEARCH_STRING_HISTORY_MAX = 50;
    private static final Icon ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
    private static final Icon ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
    private static final Icon ICON_NORMAL_SEARCH = ImageUtils.getImageIcon("data/buttonicons/normal-search.png");
    private static final Icon ICON_JUMP_TO_PRIMARY_ADDRESS = ImageUtils.getImageIcon("data/buttonicons/jump-primary-address.png");
    private static final Icon ICON_JUMP_TO_SECONDARY_ADDRESS = ImageUtils.getImageIcon("data/buttonicons/jump-secondary-address.png");
    private static final Icon ICON_NORMAL_SEARCH_FIELD = ImageUtils.getImageIcon("data/buttonicons/normal-searchfield.png");
    private static final Icon ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD = ImageUtils.getImageIcon("data/buttonicons/jump-primary-addressfield.png");
    private static final Icon ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD = ImageUtils.getImageIcon("data/buttonicons/jump-secondary-addressfield.png");
    private static final Color BACKGROUND_COLOR_FAIL = Colors.GRAY224;
    private static final Color BACKGROUND_COLOR_SUCCESS = Color.WHITE;
    private static final int ICON_SPACE = 38;
    private static final Insets BORDER_INSETS = new Insets(2, 38, 2, 0);
    private final ListenerProvider listeners = new ListenerProvider();
    private final MouseListener mouseListener;
    private final ViewTabPanelFunctions controller;
    private final GraphsContainer graphs;
    private final JMemoryBox searchCombo = new JMemoryBox(SEARCH_STRING_HISTORY_MAX);
    private final JMemoryBox priJumpCombo = new JMemoryBox(SEARCH_STRING_HISTORY_MAX);
    private final JMemoryBox secJumpCombo = new JMemoryBox(SEARCH_STRING_HISTORY_MAX);
    private final JTextField searchField = new JTextField();
    private final JFormattedTextField priHexField = new JFormattedTextField(new CHexFormatter(16));
    private final JFormattedTextField secHexField = new JFormattedTextField(new CHexFormatter(16));
    private final JButton clearSearchResultsButton;
    private final GraphSearchField$CEditorBorder border;
    private final GraphSearchField$CSearchAction searchAction;
    private final GraphSearchField$CPopupChooserAction popupChooserAction;
    private Icon activeIcon;

    public GraphSearchField(ViewTabPanelFunctions viewTabPanelFunctions, JButton jButton) {
        super(new BorderLayout());
        this.border = new GraphSearchField$CEditorBorder(this, null);
        this.searchAction = new GraphSearchField$CSearchAction(this, null);
        this.popupChooserAction = new GraphSearchField$CPopupChooserAction(this, null);
        this.activeIcon = ICON_NORMAL_SEARCH_FIELD;
        this.clearSearchResultsButton = jButton;
        this.clearSearchResultsButton.setIcon(ICON_CLEAR_GRAY);
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
        this.add((Component)this.searchCombo, "Center");
    }

    private JPopupMenu createPopup() {
        JPopupMenu jPopupMenu = new JPopupMenu();
        jPopupMenu.add(GuiUtils.buildMenuItem("Search Node Contents", ICON_NORMAL_SEARCH, (AbstractAction)this.popupChooserAction));
        jPopupMenu.add(new JSeparator());
        jPopupMenu.add(GuiUtils.buildMenuItem("Jump to Primary Address", ICON_JUMP_TO_PRIMARY_ADDRESS, (AbstractAction)this.popupChooserAction));
        jPopupMenu.add(GuiUtils.buildMenuItem("Jump to Secondary Address", ICON_JUMP_TO_SECONDARY_ADDRESS, (AbstractAction)this.popupChooserAction));
        return jPopupMenu;
    }

    private void setEditors() {
        this.searchCombo.setEditor(new GraphSearchField$1(this));
        this.priJumpCombo.setEditor(new GraphSearchField$2(this));
        this.secJumpCombo.setEditor(new GraphSearchField$3(this));
    }

    private void updateSearchBox(Icon icon) {
        if (icon == ICON_NORMAL_SEARCH && this.activeIcon == ICON_NORMAL_SEARCH_FIELD) {
            this.searchField.getCaret().setVisible(true);
            this.searchField.grabFocus();
            this.searchCombo.updateUI();
            return;
        }
        if (icon == ICON_JUMP_TO_PRIMARY_ADDRESS && this.activeIcon == ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD) {
            this.priHexField.getCaret().setVisible(true);
            this.priHexField.grabFocus();
            this.priJumpCombo.updateUI();
            return;
        }
        if (icon == ICON_JUMP_TO_SECONDARY_ADDRESS && this.activeIcon == ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD) {
            this.secHexField.getCaret().setVisible(true);
            this.secHexField.grabFocus();
            this.secJumpCombo.updateUI();
            return;
        }
        if (this.activeIcon == ICON_NORMAL_SEARCH_FIELD) {
            this.remove(this.searchCombo);
        } else if (this.activeIcon == ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD) {
            this.remove(this.priJumpCombo);
        } else if (this.activeIcon == ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD) {
            this.remove(this.secJumpCombo);
        }
        if (icon == ICON_NORMAL_SEARCH) {
            this.activeIcon = ICON_NORMAL_SEARCH_FIELD;
        } else if (icon == ICON_JUMP_TO_PRIMARY_ADDRESS) {
            this.activeIcon = ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD;
        } else if (icon == ICON_JUMP_TO_SECONDARY_ADDRESS) {
            this.activeIcon = ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD;
        }
        if (this.activeIcon == ICON_NORMAL_SEARCH_FIELD) {
            this.add(this.searchCombo);
            this.searchField.getCaret().setVisible(true);
            this.searchField.grabFocus();
            this.searchCombo.updateUI();
            return;
        }
        if (this.activeIcon == ICON_JUMP_TO_PRIMARY_ADDRESS_FIELD) {
            this.add(this.priJumpCombo);
            this.priHexField.getCaret().setVisible(true);
            this.priHexField.grabFocus();
            this.priJumpCombo.updateUI();
            return;
        }
        if (this.activeIcon != ICON_JUMP_TO_SECONDARY_ADDRESS_FIELD) return;
        this.add(this.secJumpCombo);
        this.secHexField.getCaret().setVisible(true);
        this.secHexField.grabFocus();
        this.secJumpCombo.updateUI();
    }

    public void addListener(IGraphSearchFieldListener iGraphSearchFieldListener) {
        this.listeners.addListener(iGraphSearchFieldListener);
    }

    public void dispose() {
        this.searchField.removeMouseListener(this.mouseListener);
        this.priHexField.removeMouseListener(this.mouseListener);
        this.secHexField.removeMouseListener(this.mouseListener);
    }

    public GraphsContainer getGraphs() {
        return this.graphs;
    }

    public void jumpToIndex(int n2, ESide eSide) {
        BinDiffGraph binDiffGraph = eSide == ESide.PRIMARY ? this.graphs.getPrimaryGraph() : this.graphs.getSecondaryGraph();
        GraphSearcher graphSearcher = binDiffGraph.getGraphSearcher();
        Object object = ((SearchResult)graphSearcher.getSubObjectResults().get(n2)).getObject();
        if (binDiffGraph.getSettings().getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            if (object instanceof ZyGraphNode) {
                object = ((SingleDiffNode)object).getCombinedDiffNode();
            } else if (object instanceof ZyGraphEdge) {
                object = ((SingleDiffEdge)object).getCombinedDiffEdge();
            }
            binDiffGraph = this.graphs.getCombinedGraph();
        }
        GraphSeacherFunctions.jumpToResultObject(binDiffGraph, object, true);
    }

    public void notifySearchFieldListener() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IGraphSearchFieldListener iGraphSearchFieldListener = (IGraphSearchFieldListener)iterator.next();
            iGraphSearchFieldListener.searched();
        }
    }

    public void setCaretIntoJumpToAddressField(ESide eSide) {
        this.updateSearchBox(eSide == ESide.PRIMARY ? ICON_JUMP_TO_PRIMARY_ADDRESS : ICON_JUMP_TO_SECONDARY_ADDRESS);
    }

    public void setCaretIntoSearchField() {
        if (this.searchField.hasFocus() && this.searchField.getCaret().isVisible()) {
            return;
        }
        this.updateSearchBox(ICON_NORMAL_SEARCH);
    }

    static /* synthetic */ JTextField access$500(GraphSearchField graphSearchField) {
        return graphSearchField.searchField;
    }

    static /* synthetic */ JFormattedTextField access$600(GraphSearchField graphSearchField) {
        return graphSearchField.priHexField;
    }

    static /* synthetic */ JFormattedTextField access$700(GraphSearchField graphSearchField) {
        return graphSearchField.secHexField;
    }

    static /* synthetic */ Insets access$800() {
        return BORDER_INSETS;
    }

    static /* synthetic */ Icon access$900(GraphSearchField graphSearchField) {
        return graphSearchField.activeIcon;
    }

    static /* synthetic */ void access$1000(GraphSearchField graphSearchField, Icon icon) {
        graphSearchField.updateSearchBox(icon);
    }

    static /* synthetic */ GraphsContainer access$1100(GraphSearchField graphSearchField) {
        return graphSearchField.graphs;
    }

    static /* synthetic */ ListenerProvider access$1200(GraphSearchField graphSearchField) {
        return graphSearchField.listeners;
    }

    static /* synthetic */ JMemoryBox access$1300(GraphSearchField graphSearchField) {
        return graphSearchField.searchCombo;
    }

    static /* synthetic */ Color access$1400() {
        return BACKGROUND_COLOR_FAIL;
    }

    static /* synthetic */ Icon access$1500() {
        return ICON_CLEAR_GRAY;
    }

    static /* synthetic */ JButton access$1600(GraphSearchField graphSearchField) {
        return graphSearchField.clearSearchResultsButton;
    }

    static /* synthetic */ Color access$1700() {
        return BACKGROUND_COLOR_SUCCESS;
    }

    static /* synthetic */ Icon access$1800() {
        return ICON_CLEAR;
    }

    static /* synthetic */ ViewTabPanelFunctions access$1900(GraphSearchField graphSearchField) {
        return graphSearchField.controller;
    }

    static /* synthetic */ JMemoryBox access$2000(GraphSearchField graphSearchField) {
        return graphSearchField.priJumpCombo;
    }

    static /* synthetic */ JMemoryBox access$2100(GraphSearchField graphSearchField) {
        return graphSearchField.secJumpCombo;
    }

    static /* synthetic */ JPopupMenu access$2200(GraphSearchField graphSearchField) {
        return graphSearchField.createPopup();
    }
}

