package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.graph.GraphsContainer;
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
import java.awt.Window;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class SearchResultsDialog extends BaseDialog {
   private final JTabbedPane tabbedPane = new JTabbedPane();
   private final JTable primaryTable = new JTable();
   private final JTable secondaryTable = new JTable();
   private final JLabel primaryResultsLabel = new JLabel("");
   private final JLabel secondaryResultsLabel = new JLabel("");
   private final SearchResultsDialog$InternalTableListener listener = new SearchResultsDialog$InternalTableListener(this, (SearchResultsDialog$1)null);
   private final IGraphSearchFieldListener searchListener = new SearchResultsDialog$InternalSearchListener(this, (SearchResultsDialog$1)null);
   private final GraphSearchField searchField;
   private boolean wasVisible = false;

   public SearchResultsDialog(Window var1, GraphSearchField var2) {
      super(var1, "Search Results");
      this.setModal(false);
      this.searchField = var2;
      this.setResults(var2.getGraphs());
      this.setLayout(new BorderLayout());
      var2.addListener(this.searchListener);
      this.primaryTable.setDefaultRenderer(Object.class, new SearchResultsCellRenderer());
      this.primaryTable.getSelectionModel().addListSelectionListener(this.listener);
      this.primaryTable.setSelectionMode(0);
      this.secondaryTable.setDefaultRenderer(Object.class, new SearchResultsCellRenderer());
      this.secondaryTable.getSelectionModel().addListSelectionListener(this.listener);
      this.secondaryTable.setSelectionMode(0);
      this.init();
      this.setSize(400, 400);
   }

   private void fillUpTableData(List var1, Object[][] var2) {
      int var3 = 0;
      Color var4 = null;
      Object var5 = null;
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         SearchResult var7 = (SearchResult)var6.next();
         if(var5 == null || var5 != var7.getObject()) {
            var5 = var7.getObject();
            if(var4 != null && !var4.equals(Color.WHITE)) {
               var4 = Color.WHITE;
            } else {
               var4 = new Color(242, 242, 242);
            }
         }

         var7.setObjectMarkerColor(var4);
         if(var7.getObject() instanceof ZyGraphNode) {
            var2[var3++][0] = var7;
         } else if(var7.getObject() instanceof ZyGraphEdge) {
            var2[var3++][0] = var7;
         }
      }

   }

   private void removAllRows(JTable var1) {
      DefaultTableModel var2 = (DefaultTableModel)var1.getModel();
      var2.getDataVector().removeAllElements();
   }

   private void setResults(GraphsContainer var1) {
      ArrayList var2 = new ArrayList();
      var2.addAll(var1.getPrimaryGraph().getGraphSearcher().getSubObjectResults());
      ArrayList var3 = new ArrayList();
      var3.addAll(var1.getSecondaryGraph().getGraphSearcher().getSubObjectResults());
      Object[][] var4 = new Object[var2.size()][1];
      Object[][] var5 = new Object[var3.size()][1];
      this.fillUpTableData(var2, var4);
      this.fillUpTableData(var3, var5);
      this.primaryTable.setModel(new SearchResultsDialog$CResultsTableModel(this, var4, new String[]{"Primary Results"}));
      this.secondaryTable.setModel(new SearchResultsDialog$CResultsTableModel(this, var5, new String[]{"Secondary Results"}));
      this.primaryResultsLabel.setText(String.format("%d search results", new Object[]{Integer.valueOf(var4.length)}));
      this.secondaryResultsLabel.setText(String.format("%d search results", new Object[]{Integer.valueOf(var5.length)}));
   }

   private void init() {
      this.tabbedPane.setFocusable(false);
      JPanel var1 = new JPanel(new BorderLayout());
      var1.add(this.tabbedPane, "Center");
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(2, 2, 2, 1));
      var2.add(new JScrollPane(this.primaryTable), "Center");
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(2, 2, 2, 1));
      var3.add(new JScrollPane(this.secondaryTable), "Center");
      JPanel var4 = new JPanel(new BorderLayout());
      var4.setBorder(new LineBorder(Color.GRAY));
      var4.add(var2, "Center");
      this.primaryResultsLabel.setBorder(new EmptyBorder(2, 2, 5, 2));
      var4.add(this.primaryResultsLabel, "South");
      this.tabbedPane.add("Primary", var4);
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setBorder(new LineBorder(Color.GRAY));
      var5.add(var3, "Center");
      this.secondaryResultsLabel.setBorder(new EmptyBorder(2, 2, 5, 1));
      var5.add(this.secondaryResultsLabel, "South");
      this.tabbedPane.add("Secondary", var5);
      this.add(var1, "Center");
   }

   public boolean getReshowDialog() {
      return this.wasVisible;
   }

   public void setReshowDialog(boolean var1) {
      this.wasVisible = var1;
   }

   // $FF: synthetic method
   static JTable access$200(SearchResultsDialog var0) {
      return var0.primaryTable;
   }

   // $FF: synthetic method
   static void access$300(SearchResultsDialog var0, JTable var1) {
      var0.removAllRows(var1);
   }

   // $FF: synthetic method
   static JTable access$400(SearchResultsDialog var0) {
      return var0.secondaryTable;
   }

   // $FF: synthetic method
   static GraphSearchField access$500(SearchResultsDialog var0) {
      return var0.searchField;
   }

   // $FF: synthetic method
   static void access$600(SearchResultsDialog var0, GraphsContainer var1) {
      var0.setResults(var1);
   }

   // $FF: synthetic method
   static JLabel access$700(SearchResultsDialog var0) {
      return var0.primaryResultsLabel;
   }

   // $FF: synthetic method
   static JLabel access$800(SearchResultsDialog var0) {
      return var0.secondaryResultsLabel;
   }

   // $FF: synthetic method
   static JTabbedPane access$900(SearchResultsDialog var0) {
      return var0.tabbedPane;
   }
}
