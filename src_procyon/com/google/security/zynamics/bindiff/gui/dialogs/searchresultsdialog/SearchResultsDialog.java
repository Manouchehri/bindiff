package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class SearchResultsDialog extends BaseDialog
{
    private final JTabbedPane tabbedPane;
    private final JTable primaryTable;
    private final JTable secondaryTable;
    private final JLabel primaryResultsLabel;
    private final JLabel secondaryResultsLabel;
    private final SearchResultsDialog$InternalTableListener listener;
    private final IGraphSearchFieldListener searchListener;
    private final GraphSearchField searchField;
    private boolean wasVisible;
    
    public SearchResultsDialog(final Window window, final GraphSearchField searchField) {
        super(window, "Search Results");
        this.tabbedPane = new JTabbedPane();
        this.primaryTable = new JTable();
        this.secondaryTable = new JTable();
        this.primaryResultsLabel = new JLabel("");
        this.secondaryResultsLabel = new JLabel("");
        this.listener = new SearchResultsDialog$InternalTableListener(this, null);
        this.searchListener = new SearchResultsDialog$InternalSearchListener(this, null);
        this.setModal(this.wasVisible = false);
        this.searchField = searchField;
        this.setResults(searchField.getGraphs());
        this.setLayout(new BorderLayout());
        searchField.addListener(this.searchListener);
        this.primaryTable.setDefaultRenderer(Object.class, new SearchResultsCellRenderer());
        this.primaryTable.getSelectionModel().addListSelectionListener(this.listener);
        this.primaryTable.setSelectionMode(0);
        this.secondaryTable.setDefaultRenderer(Object.class, new SearchResultsCellRenderer());
        this.secondaryTable.getSelectionModel().addListSelectionListener(this.listener);
        this.secondaryTable.setSelectionMode(0);
        this.init();
        this.setSize(400, 400);
    }
    
    private void fillUpTableData(final List list, final Object[][] array) {
        int n = 0;
        Color white = null;
        Object object = null;
        for (final SearchResult searchResult : list) {
            if (object == null || object != searchResult.getObject()) {
                object = searchResult.getObject();
                if (white == null || white.equals(Color.WHITE)) {
                    white = new Color(242, 242, 242);
                }
                else {
                    white = Color.WHITE;
                }
            }
            searchResult.setObjectMarkerColor(white);
            if (searchResult.getObject() instanceof ZyGraphNode) {
                array[n++][0] = searchResult;
            }
            else {
                if (!(searchResult.getObject() instanceof ZyGraphEdge)) {
                    continue;
                }
                array[n++][0] = searchResult;
            }
        }
    }
    
    private void removAllRows(final JTable table) {
        ((DefaultTableModel)table.getModel()).getDataVector().removeAllElements();
    }
    
    private void setResults(final GraphsContainer graphsContainer) {
        final ArrayList list = new ArrayList();
        list.addAll(graphsContainer.getPrimaryGraph().getGraphSearcher().getSubObjectResults());
        final ArrayList list2 = new ArrayList();
        list2.addAll(graphsContainer.getSecondaryGraph().getGraphSearcher().getSubObjectResults());
        final Object[][] array = new Object[list.size()][1];
        final Object[][] array2 = new Object[list2.size()][1];
        this.fillUpTableData(list, array);
        this.fillUpTableData(list2, array2);
        this.primaryTable.setModel(new SearchResultsDialog$CResultsTableModel(this, array, new String[] { "Primary Results" }));
        this.secondaryTable.setModel(new SearchResultsDialog$CResultsTableModel(this, array2, new String[] { "Secondary Results" }));
        this.primaryResultsLabel.setText(String.format("%d search results", array.length));
        this.secondaryResultsLabel.setText(String.format("%d search results", array2.length));
    }
    
    private void init() {
        this.tabbedPane.setFocusable(false);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.tabbedPane, "Center");
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(2, 2, 2, 1));
        panel2.add(new JScrollPane(this.primaryTable), "Center");
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(new EmptyBorder(2, 2, 2, 1));
        panel3.add(new JScrollPane(this.secondaryTable), "Center");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(new LineBorder(Color.GRAY));
        panel4.add(panel2, "Center");
        this.primaryResultsLabel.setBorder(new EmptyBorder(2, 2, 5, 2));
        panel4.add(this.primaryResultsLabel, "South");
        this.tabbedPane.add("Primary", panel4);
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel5.setBorder(new LineBorder(Color.GRAY));
        panel5.add(panel3, "Center");
        this.secondaryResultsLabel.setBorder(new EmptyBorder(2, 2, 5, 1));
        panel5.add(this.secondaryResultsLabel, "South");
        this.tabbedPane.add("Secondary", panel5);
        this.add(panel, "Center");
    }
    
    public boolean getReshowDialog() {
        return this.wasVisible;
    }
    
    public void setReshowDialog(final boolean wasVisible) {
        this.wasVisible = wasVisible;
    }
}
