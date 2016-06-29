package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageThreeBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.DoubleComparator;
import com.google.security.zynamics.zylib.general.comparators.HexStringComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.List;

public class FunctionDiffViewsTableModel extends AbstractFunctionDiffViewsTableModel {
   public static final int VIEWNAME = 0;
   public static final int SIMILARITY = 1;
   public static final int CONFIDENCE = 2;
   public static final int PRIMARY_ADDRESS = 3;
   public static final int PRIMARY_NAME = 4;
   public static final int SECONDARY_ADDRESS = 5;
   public static final int SECONDARY_NAME = 6;
   public static final int BASICBLOCK_MATCHES = 7;
   public static final int JUMP_MATCHES = 8;
   private static final String[] COLUMNS = new String[]{"View Name", "Similarity", "Confidence", "Address", "Primary Name", "Address", "Secondary Name", "Basic Blocks", "Jumps"};
   private final List sorters = new ArrayList();

   public FunctionDiffViewsTableModel(List var1) {
      super(var1);
   }

   public int getColumnCount() {
      return COLUMNS.length;
   }

   public String getColumnName(int var1) {
      return COLUMNS[var1];
   }

   public List getSorters() {
      this.sorters.add(new Pair(Integer.valueOf(0), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(3), new HexStringComparator()));
      this.sorters.add(new Pair(Integer.valueOf(4), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(7), new PercentageThreeBarCellDataComparator()));
      this.sorters.add(new Pair(Integer.valueOf(1), new DoubleComparator()));
      this.sorters.add(new Pair(Integer.valueOf(2), new DoubleComparator()));
      this.sorters.add(new Pair(Integer.valueOf(8), new PercentageThreeBarCellDataComparator()));
      this.sorters.add(new Pair(Integer.valueOf(6), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(5), new HexStringComparator()));
      return this.sorters;
   }

   public Object getValueAt(int var1, int var2) {
      Diff var3 = (Diff)this.functionDiffViewList.get(var1);
      String var4 = var3.getMatchesDatabase().getName();
      var4 = CFileUtils.forceFilenameEndsNotWithExtension(var4, "BinDiff");
      RawFunction var5 = (RawFunction)var3.getCallgraph(ESide.PRIMARY).getNodes().get(0);
      RawFunction var6 = (RawFunction)var3.getCallgraph(ESide.SECONDARY).getNodes().get(0);
      IAddress var7 = var5.getAddress();
      IAddress var8 = var6.getAddress();
      int var9 = var5.getSizeOfMatchedBasicblocks();
      int var10 = var5.getSizeOfBasicblocks() - var9;
      int var11 = var6.getSizeOfBasicblocks() - var9;
      int var12 = var5.getSizeOfMatchedJumps();
      int var13 = var5.getSizeOfJumps() - var12;
      int var14 = var6.getSizeOfJumps() - var12;
      PercentageThreeBarCellData var15 = new PercentageThreeBarCellData(var10, var9, var11, this.getColumnSortRelevance(var2));
      PercentageThreeBarCellData var16 = new PercentageThreeBarCellData(var13, var12, var14, this.getColumnSortRelevance(var2));
      switch(var2) {
      case 0:
         return var4;
      case 1:
         return Double.valueOf(MatchesGetter.getFunctionMatch(var3, var5).getSimilarity());
      case 2:
         return Double.valueOf(MatchesGetter.getFunctionMatch(var3, var5).getConfidence());
      case 3:
         return var7.toHexString();
      case 4:
         return var5.getName();
      case 5:
         return var8.toHexString();
      case 6:
         return var6.getName();
      case 7:
         return var15;
      case 8:
         return var16;
      default:
         return null;
      }
   }

   public void deleteDiff(Diff var1) {
      if(this.functionDiffViewList.remove(var1)) {
         this.fireTableDataChanged();
      }

   }
}
