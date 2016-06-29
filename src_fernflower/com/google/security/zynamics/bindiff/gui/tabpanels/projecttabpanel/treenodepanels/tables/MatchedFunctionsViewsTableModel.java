package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.comparators.RawFunctionTypeComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.IconComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageThreeBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.DoubleComparator;
import com.google.security.zynamics.zylib.general.comparators.HexStringComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.Icon;

public class MatchedFunctionsViewsTableModel extends AbstractTableModel {
   public static final Icon IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tablecellicons/flowgraphs-identical-matched-tab.png");
   public static final Icon INSTRUCTIONS_CHANGED_ICON = ImageUtils.getImageIcon("data/tablecellicons/flowgraphs-changed-instructions-only-tab.png");
   public static final Icon STRUCTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tablecellicons/flowgraphs_structural-changed-tab.png");
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
   private final ListenerProvider listeners = new ListenerProvider();
   private final List sorters = new ArrayList();
   private final List matchedFunctionPairs = new ArrayList();

   public MatchedFunctionsViewsTableModel(Diff var1, boolean var2) {
      super(var1);
      if(var2) {
         RawCallGraph var3 = var1.getCallgraph(ESide.PRIMARY);
         RawCallGraph var4 = var1.getCallgraph(ESide.SECONDARY);
         this.setMatchedFunctionPairs(GraphGetter.getChangedFunctionPairs(var3, var4));
      }

      this.initSorters();
   }

   private Icon getIcon(RawFunction var1, RawFunction var2) {
      return MatchesGetter.isIdenticalFunctionPair(var1, var2)?IDENTICAL_MATCHED_ICON:(MatchesGetter.isStructuralChangedFunctionPair(var1, var2)?STRUCTURAL_CHANGED_ICON:(MatchesGetter.isInstructionsOnlyChangedFunctionPair(var1, var2)?INSTRUCTIONS_CHANGED_ICON:null));
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

   public void addListener(IMatchedFunctionsViewsTableListener var1) {
      this.listeners.addListener(var1);
   }

   public int getColumnCount() {
      return COLUMNS.length;
   }

   public String getColumnName(int var1) {
      return COLUMNS[var1];
   }

   public Pair getMatchedFunctionPairAt(int var1) {
      return (Pair)this.matchedFunctionPairs.get(var1);
   }

   public int getRowCount() {
      return this.matchedFunctionPairs.size();
   }

   public List getSorters() {
      return this.sorters;
   }

   public Object getValueAt(int var1, int var2) {
      RawFunction var3 = (RawFunction)((Pair)this.matchedFunctionPairs.get(var1)).first();
      RawFunction var4 = (RawFunction)((Pair)this.matchedFunctionPairs.get(var1)).second();
      IAddress var5 = var3.getAddress();
      IAddress var6 = var4.getAddress();
      int var7 = var3.getSizeOfMatchedBasicblocks();
      int var8 = var3.getSizeOfBasicblocks() - var7;
      int var9 = var4.getSizeOfBasicblocks() - var7;
      int var10 = var3.getSizeOfMatchedJumps();
      int var11 = var3.getSizeOfJumps() - var10;
      int var12 = var4.getSizeOfJumps() - var10;
      PercentageThreeBarCellData var13 = new PercentageThreeBarCellData(var8, var7, var9, this.getColumnSortRelevance(var2));
      PercentageThreeBarCellData var14 = new PercentageThreeBarCellData(var11, var10, var12, this.getColumnSortRelevance(var2));
      switch(var2) {
      case 0:
         return this.getIcon(var3, var4);
      case 1:
         return Double.valueOf(MatchesGetter.getFunctionMatch(this.getDiff(), var3).getSimilarity());
      case 2:
         return Double.valueOf(MatchesGetter.getFunctionMatch(this.getDiff(), var3).getConfidence());
      case 3:
         return var5.toHexString();
      case 4:
         return var3.getName();
      case 5:
         return var3.getFunctionType();
      case 6:
         return var6.toHexString();
      case 7:
         return var4.getName();
      case 8:
         return var4.getFunctionType();
      case 9:
         return var13;
      case 10:
         return var14;
      default:
         return null;
      }
   }

   public void removeListener(IMatchedFunctionsViewsTableListener var1) {
      this.listeners.removeListener(var1);
   }

   public void setMatchedFunctionPairs(Set var1) {
      this.matchedFunctionPairs.clear();
      this.matchedFunctionPairs.addAll(var1);
      this.fireTableDataChanged();
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         IMatchedFunctionsViewsTableListener var3 = (IMatchedFunctionsViewsTableListener)var2.next();
         var3.tableDataChanged(this);
      }

   }
}
