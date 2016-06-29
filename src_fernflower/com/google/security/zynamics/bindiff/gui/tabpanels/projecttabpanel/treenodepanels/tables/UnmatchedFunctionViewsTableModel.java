package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.comparators.RawFunctionTypeComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageTwoBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IUnmatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.HexStringComparator;
import com.google.security.zynamics.zylib.general.comparators.IntComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UnmatchedFunctionViewsTableModel extends AbstractTableModel {
   public static final int ADDRESS = 0;
   public static final int FUNCTION_NAME = 1;
   public static final int TYPE = 2;
   public static final int BASICBLOCKS = 3;
   public static final int JUMPS = 4;
   public static final int INSTRUCTIONS = 5;
   public static final int CALLERS = 6;
   public static final int CALLEES = 7;
   private static final String[] COLUMNS = new String[]{"Address", "Name", "Type", "Basic Blocks", "Jumps", "Instructions", "Callers", "Callees"};
   private final ListenerProvider listeners = new ListenerProvider();
   private final List sorters = new ArrayList();
   private final ESide side;
   private final List unmatchedFunctions = new ArrayList();

   public UnmatchedFunctionViewsTableModel(Diff var1, ESide var2, boolean var3) {
      super(var1);
      this.side = var2;
      if(var3) {
         HashSet var4 = new HashSet();
         var4.addAll(GraphGetter.getUnmatchedFunctions(var1.getCallgraph(var2)));
         this.setUnmatchedFunctions(var4);
      }

      this.initSorters();
   }

   private void initSorters() {
      this.sorters.add(new Pair(Integer.valueOf(0), new HexStringComparator()));
      this.sorters.add(new Pair(Integer.valueOf(1), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(2), new RawFunctionTypeComparator()));
      this.sorters.add(new Pair(Integer.valueOf(3), new IntComparator()));
      this.sorters.add(new Pair(Integer.valueOf(4), new IntComparator()));
      this.sorters.add(new Pair(Integer.valueOf(5), new IntComparator()));
      this.sorters.add(new Pair(Integer.valueOf(6), new IntComparator()));
      this.sorters.add(new Pair(Integer.valueOf(7), new PercentageTwoBarCellDataComparator()));
   }

   public void addListener(IUnmatchedFunctionsViewsTableListener var1) {
      this.listeners.addListener(var1);
   }

   public int getColumnCount() {
      return COLUMNS.length;
   }

   public String getColumnName(int var1) {
      return COLUMNS[var1];
   }

   public int getRowCount() {
      return this.unmatchedFunctions.size();
   }

   public ESide getSide() {
      return this.side;
   }

   public List getSorters() {
      return this.sorters;
   }

   public RawFunction getUnmatchedFunctionAt(int var1) {
      return (RawFunction)this.unmatchedFunctions.get(var1);
   }

   public Object getValueAt(int var1, int var2) {
      if(this.getRowCount() == 0) {
         return null;
      } else {
         RawFunction var3 = (RawFunction)this.unmatchedFunctions.get(var1);
         IAddress var4 = var3.getAddress();
         switch(var2) {
         case 0:
            return var4.toHexString();
         case 1:
            return var3.getName();
         case 2:
            return var3.getFunctionType();
         case 3:
            return Integer.valueOf(var3.getSizeOfBasicblocks());
         case 4:
            return Integer.valueOf(var3.getSizeOfJumps());
         case 5:
            return Integer.valueOf(var3.getSizeOfInstructions());
         case 6:
            return Integer.valueOf(var3.getCallers().size());
         case 7:
            return Integer.valueOf(var3.getCallees().size());
         default:
            return null;
         }
      }
   }

   public void removeListener(IUnmatchedFunctionsViewsTableListener var1) {
      this.listeners.removeListener(var1);
   }

   public void setUnmatchedFunctions(Set var1) {
      this.unmatchedFunctions.clear();
      this.unmatchedFunctions.addAll(var1);
      this.fireTableDataChanged();
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         IUnmatchedFunctionsViewsTableListener var3 = (IUnmatchedFunctionsViewsTableListener)var2.next();
         var3.tableDataChanged(this);
      }

   }
}
