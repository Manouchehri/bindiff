package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.EExistence;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.comparators.RawFunctionTypeComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.IconComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageThreeBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.Triple;
import com.google.security.zynamics.zylib.general.comparators.DoubleComparator;
import com.google.security.zynamics.zylib.general.comparators.HexStringComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;

public class ExtendedMatchedFunctionViewsTableModel extends AbstractTableModel {
   public static final Icon ADDED_ICON = ImageUtils.getImageIcon("data/tablecellicons/added.png");
   public static final Icon REMOVED_ICON = ImageUtils.getImageIcon("data/tablecellicons/removed.png");
   public static final int ICON = 0;
   public static final int SIMILARITY = 1;
   public static final int CONFIDENCE = 2;
   public static final int PRIMARY_ADDRESS = 3;
   public static final int PRIMARY_NAME = 4;
   public static final int PRIMARY_TYPE = 5;
   public static final int SECONDARY_ADDRESS = 6;
   public static final int SECONDARY_NAME = 7;
   public static final int SECONDARY_TYPE = 8;
   public static final int BASICBLOCK_MATCHES = 9;
   public static final int JUMP_MATCHES = 10;
   private static final String[] COLUMNS = new String[]{"", "Similarity", "Confidence", "Address", "Primary Name", "Type", "Address", "Secondary Name", "Type", "Basic Blocks", "Jumps"};
   private final List sorters = new ArrayList();
   private final List matchedFunctionPairs = new ArrayList();

   public ExtendedMatchedFunctionViewsTableModel(Diff var1) {
      super(var1);
      this.initSorters();
   }

   private void initSorters() {
      this.sorters.add(new Pair(Integer.valueOf(0), new IconComparator()));
      this.sorters.add(new Pair(Integer.valueOf(3), new HexStringComparator()));
      this.sorters.add(new Pair(Integer.valueOf(4), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(5), new RawFunctionTypeComparator()));
      this.sorters.add(new Pair(Integer.valueOf(9), new PercentageThreeBarCellDataComparator()));
      this.sorters.add(new Pair(Integer.valueOf(1), new DoubleComparator()));
      this.sorters.add(new Pair(Integer.valueOf(2), new DoubleComparator()));
      this.sorters.add(new Pair(Integer.valueOf(10), new PercentageThreeBarCellDataComparator()));
      this.sorters.add(new Pair(Integer.valueOf(8), new RawFunctionTypeComparator()));
      this.sorters.add(new Pair(Integer.valueOf(7), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(6), new HexStringComparator()));
   }

   public int getColumnCount() {
      return COLUMNS.length;
   }

   public String getColumnName(int var1) {
      return COLUMNS[var1];
   }

   public int getRowCount() {
      return this.matchedFunctionPairs.size();
   }

   public List getSorters() {
      return this.sorters;
   }

   public Object getValueAt(int var1, int var2) {
      RawFunction var3 = (RawFunction)((Triple)this.matchedFunctionPairs.get(var1)).first();
      RawFunction var4 = (RawFunction)((Triple)this.matchedFunctionPairs.get(var1)).second();
      EExistence var5 = (EExistence)((Triple)this.matchedFunctionPairs.get(var1)).third();
      String var6 = "";
      String var7 = "";
      String var8 = "";
      String var9 = "";
      EFunctionType var10 = EFunctionType.UNKNOWN;
      EFunctionType var11 = EFunctionType.UNKNOWN;
      double var12 = -1.0D;
      double var14 = -1.0D;
      byte var16 = 0;
      byte var17 = 0;
      byte var18 = 0;
      byte var19 = 0;
      byte var20 = 0;
      byte var21 = 0;
      PercentageThreeBarCellData var22 = null;
      PercentageThreeBarCellData var23 = null;
      int var24;
      int var26;
      int var27;
      int var29;
      if(var3 != null && var4 != null) {
         var12 = MatchesGetter.getFunctionMatch(this.getDiff(), var3).getSimilarity();
         var14 = MatchesGetter.getFunctionMatch(this.getDiff(), var3).getConfidence();
         var6 = var3.getAddress().toHexString();
         var7 = var4.getAddress().toHexString();
         var8 = var3.getName();
         var9 = var4.getName();
         var10 = var3.getFunctionType();
         var11 = var4.getFunctionType();
         int var25 = var3.getSizeOfMatchedBasicblocks();
         var26 = var3.getSizeOfBasicblocks() - var25;
         var27 = var4.getSizeOfBasicblocks() - var25;
         int var28 = var3.getSizeOfMatchedJumps();
         var29 = var3.getSizeOfJumps() - var28;
         var24 = var4.getSizeOfJumps() - var28;
         var22 = new PercentageThreeBarCellData(var26, var25, var27, this.getColumnSortRelevance(var2));
         var23 = new PercentageThreeBarCellData(var29, var28, var24, this.getColumnSortRelevance(var2));
      } else if(var3 != null) {
         var6 = var3.getAddress().toHexString();
         var8 = var3.getName();
         var10 = var3.getFunctionType();
         var26 = var3.getSizeOfBasicblocks();
         var29 = var3.getSizeOfJumps();
         var22 = new PercentageThreeBarCellData(var26, var16, var18, this.getColumnSortRelevance(var2));
         var23 = new PercentageThreeBarCellData(var29, var19, var21, this.getColumnSortRelevance(var2));
      } else {
         if(var4 == null) {
            throw new IllegalStateException("Primary and secondary raw functions cannot both be null.");
         }

         var7 = var4.getAddress().toHexString();
         var9 = var4.getName();
         var11 = var4.getFunctionType();
         var27 = var4.getSizeOfBasicblocks();
         var24 = var4.getSizeOfJumps();
         var22 = new PercentageThreeBarCellData(var17, var16, var27, this.getColumnSortRelevance(var2));
         var23 = new PercentageThreeBarCellData(var20, var19, var24, this.getColumnSortRelevance(var2));
      }

      switch(var2) {
      case 0:
         return var5 == EExistence.ADDED?ADDED_ICON:REMOVED_ICON;
      case 1:
         return Double.valueOf(var12);
      case 2:
         return Double.valueOf(var14);
      case 3:
         return var6;
      case 4:
         return var8;
      case 5:
         return var10;
      case 6:
         return var7;
      case 7:
         return var9;
      case 8:
         return var11;
      case 9:
         return var22;
      case 10:
         return var23;
      default:
         return null;
      }
   }

   public void setMatchedFunctionPairs(List var1) {
      this.matchedFunctionPairs.clear();
      this.matchedFunctionPairs.addAll(var1);
      this.fireTableDataChanged();
   }
}
