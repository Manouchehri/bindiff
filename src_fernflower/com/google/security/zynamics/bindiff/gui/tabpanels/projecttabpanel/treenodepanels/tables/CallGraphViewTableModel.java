package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageThreeBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.DoubleComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.List;

public class CallGraphViewTableModel extends AbstractTableModel {
   public static final int SIMILARITY = 0;
   public static final int CONFIDENCE = 1;
   public static final int PRIMARY_NAME = 2;
   public static final int SECONDARY_NAME = 3;
   public static final int FUNCTIONS = 4;
   public static final int CALLS = 5;
   private final String[] COLUMNS = new String[]{"Similarity", "Confidence", "Primary Name", "Secondary Name", "Functions", "Calls"};
   private final List sorters = new ArrayList();

   public CallGraphViewTableModel(Diff var1) {
      super(var1);
      this.initSorters();
   }

   private void initSorters() {
      this.sorters.add(new Pair(Integer.valueOf(0), new DoubleComparator()));
      this.sorters.add(new Pair(Integer.valueOf(1), new DoubleComparator()));
      this.sorters.add(new Pair(Integer.valueOf(2), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(3), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(4), new PercentageThreeBarCellDataComparator()));
      this.sorters.add(new Pair(Integer.valueOf(5), new PercentageThreeBarCellDataComparator()));
   }

   public int getColumnCount() {
      return this.COLUMNS.length;
   }

   public String getColumnName(int var1) {
      return this.COLUMNS[var1];
   }

   public int getRowCount() {
      return 1;
   }

   public List getSorters() {
      return this.sorters;
   }

   public Object getValueAt(int var1, int var2) {
      MatchData var3 = this.getDiff().getMatches();
      PercentageThreeBarCellData var4 = new PercentageThreeBarCellData(var3.getSizeOfUnmatchedFunctions(ESide.PRIMARY), var3.getSizeOfMatchedFunctions(), var3.getSizeOfUnmatchedFunctions(ESide.SECONDARY));
      PercentageThreeBarCellData var5 = new PercentageThreeBarCellData(var3.getSizeOfUnmatchedCalls(ESide.PRIMARY), var3.getSizeOfMatchedCalls(), var3.getSizeOfUnmatchedCalls(ESide.SECONDARY));
      DiffMetaData var6 = this.getDiff().getMetaData();
      switch(var2) {
      case 0:
         return Double.valueOf(var6.getTotalSimilarity());
      case 1:
         return Double.valueOf(var6.getTotalConfidence());
      case 2:
         return var6.getImageName(ESide.PRIMARY);
      case 3:
         return var6.getImageName(ESide.SECONDARY);
      case 4:
         return var4;
      case 5:
         return var5;
      default:
         return null;
      }
   }
}
