/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.IGraphSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsCellRenderer;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog$CResultsTableModel;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog$InternalSearchListener;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog$InternalTableListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class SearchResultsDialog
extends BaseDialog {
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final JTable primaryTable = new JTable();
    private final JTable secondaryTable = new JTable();
    private final JLabel primaryResultsLabel = new JLabel("");
    private final JLabel secondaryResultsLabel = new JLabel("");
    private final SearchResultsDialog$InternalTableListener listener;
    private final IGraphSearchFieldListener searchListener;
    private final GraphSearchField searchField;
    private boolean wasVisible;

    public SearchResultsDialog(Window window, GraphSearchField graphSearchField) {
        super(window, "Search Results");
        this.listener = new SearchResultsDialog$InternalTableListener(this, null);
        this.searchListener = new SearchResultsDialog$InternalSearchListener(this, null);
        this.wasVisible = false;
        this.setModal(false);
        this.searchField = graphSearchField;
        this.setResults(graphSearchField.getGraphs());
        this.setLayout(new BorderLayout());
        graphSearchField.addListener(this.searchListener);
        this.primaryTable.setDefaultRenderer(Object.class, new SearchResultsCellRenderer());
        this.primaryTable.getSelectionModel().addListSelectionListener(this.listener);
        this.primaryTable.setSelectionMode(0);
        this.secondaryTable.setDefaultRenderer(Object.class, new SearchResultsCellRenderer());
        this.secondaryTable.getSelectionModel().addListSelectionListener(this.listener);
        this.secondaryTable.setSelectionMode(0);
        this.init();
        this.setSize(400, 400);
    }

    private void fillUpTableData(List list, Object[][] arrobject) {
        int n2 = 0;
        Color color = null;
        Object object = null;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SearchResult searchResult = (SearchResult)iterator.next();
            if (object == null || object != searchResult.getObject()) {
                object = searchResult.getObject();
                color = color == null || color.equals(Color.WHITE) ? new Color(242, 242, 242) : Color.WHITE;
            }
            searchResult.setObjectMarkerColor(color);
            if (searchResult.getObject() instanceof ZyGraphNode) {
                arrobject[n2++][0] = searchResult;
                continue;
            }
            if (!(searchResult.getObject() instanceof ZyGraphEdge)) continue;
            arrobject[n2++][0] = searchResult;
        }
    }

    private void removAllRows(JTable jTable) {
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable.getModel();
        defaultTableModel.getDataVector().removeAllElements();
    }

    private void setResults(GraphsContainer graphsContainer) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(graphsContainer.getPrimaryGraph().getGraphSearcher().getSubObjectResults());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(graphsContainer.getSecondaryGraph().getGraphSearcher().getSubObjectResults());
        Object[][] arrobject = new Object[arrayList.size()][1];
        Object[][] arrobject2 = new Object[arrayList2.size()][1];
        this.fillUpTableData(arrayList, arrobject);
        this.fillUpTableData(arrayList2, arrobject2);
        this.primaryTable.setModel(new SearchResultsDialog$CResultsTableModel(this, arrobject, new String[]{"Primary Results"}));
        this.secondaryTable.setModel(new SearchResultsDialog$CResultsTableModel(this, arrobject2, new String[]{"Secondary Results"}));
        this.primaryResultsLabel.setText(String.format("%d search results", arrobject.length));
        this.secondaryResultsLabel.setText(String.format("%d search results", arrobject2.length));
    }

    private void init() {
        this.tabbedPane.setFocusable(false);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.tabbedPane, "Center");
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(2, 2, 2, 1));
        jPanel2.add((Component)new JScrollPane(this.primaryTable), "Center");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(new EmptyBorder(2, 2, 2, 1));
        jPanel3.add((Component)new JScrollPane(this.secondaryTable), "Center");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new LineBorder(Color.GRAY));
        jPanel4.add((Component)jPanel2, "Center");
        this.primaryResultsLabel.setBorder(new EmptyBorder(2, 2, 5, 2));
        jPanel4.add((Component)this.primaryResultsLabel, "South");
        this.tabbedPane.add("Primary", jPanel4);
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.setBorder(new LineBorder(Color.GRAY));
        jPanel5.add((Component)jPanel3, "Center");
        this.secondaryResultsLabel.setBorder(new EmptyBorder(2, 2, 5, 1));
        jPanel5.add((Component)this.secondaryResultsLabel, "South");
        this.tabbedPane.add("Secondary", jPanel5);
        this.add((Component)jPanel, "Center");
    }

    public boolean getReshowDialog() {
        return this.wasVisible;
    }

    public void setReshowDialog(boolean bl2) {
        this.wasVisible = bl2;
    }

    static /* synthetic */ JTable access$200(SearchResultsDialog searchResultsDialog) {
        return searchResultsDialog.primaryTable;
    }

    static /* synthetic */ void access$300(SearchResultsDialog searchResultsDialog, JTable jTable) {
        searchResultsDialog.removAllRows(jTable);
    }

    static /* synthetic */ JTable access$400(SearchResultsDialog searchResultsDialog) {
        return searchResultsDialog.secondaryTable;
    }

    static /* synthetic */ GraphSearchField access$500(SearchResultsDialog searchResultsDialog) {
        return searchResultsDialog.searchField;
    }

    static /* synthetic */ void access$600(SearchResultsDialog searchResultsDialog, GraphsContainer graphsContainer) {
        searchResultsDialog.setResults(graphsContainer);
    }

    static /* synthetic */ JLabel access$700(SearchResultsDialog searchResultsDialog) {
        return searchResultsDialog.primaryResultsLabel;
    }

    static /* synthetic */ JLabel access$800(SearchResultsDialog searchResultsDialog) {
        return searchResultsDialog.secondaryResultsLabel;
    }

    static /* synthetic */ JTabbedPane access$900(SearchResultsDialog searchResultsDialog) {
        return searchResultsDialog.tabbedPane;
    }
}

