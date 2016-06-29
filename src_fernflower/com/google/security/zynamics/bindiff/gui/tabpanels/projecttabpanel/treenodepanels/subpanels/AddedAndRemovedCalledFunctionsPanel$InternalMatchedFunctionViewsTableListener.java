package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.enums.ECallDirection;
import com.google.security.zynamics.bindiff.enums.EExistence;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.AddedAndRemovedCalledFunctionsPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.AddedAndRemovedCalledFunctionsPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.general.Triple;
import java.util.ArrayList;
import java.util.Iterator;

class AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener implements IMatchedFunctionsViewsTableListener {
   // $FF: synthetic field
   final AddedAndRemovedCalledFunctionsPanel this$0;

   private AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener(AddedAndRemovedCalledFunctionsPanel var1) {
      this.this$0 = var1;
   }

   public void rowSelectionChanged(MatchedFunctionViewsTable var1) {
      int[] var2 = var1.getSelectedRows();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int[] var9 = var2;
      int var10 = var2.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         int var12 = var9[var11];
         String var13 = (String)var1.getModel().getValueAt(var12, 3);
         String var14 = (String)var1.getModel().getValueAt(var12, 6);
         CAddress var15 = new CAddress(var13, 16);
         CAddress var16 = new CAddress(var14, 16);
         AddedAndRemovedCalledFunctionsPanel.access$100(this.this$0, var15, var16, ECallDirection.INCOMING, var3);
         AddedAndRemovedCalledFunctionsPanel.access$100(this.this$0, var15, var16, ECallDirection.OUTGOING, var4);
      }

      Iterator var17 = var3.iterator();

      Triple var18;
      while(var17.hasNext()) {
         var18 = (Triple)var17.next();
         if(var18.third() == EExistence.ADDED) {
            ++var5;
         } else {
            ++var6;
         }
      }

      var17 = var4.iterator();

      while(var17.hasNext()) {
         var18 = (Triple)var17.next();
         if(var18.third() == EExistence.ADDED) {
            ++var7;
         } else {
            ++var8;
         }
      }

      ((ExtendedMatchedFunctionViewsTableModel)AddedAndRemovedCalledFunctionsPanel.access$200(this.this$0).getTableModel()).setMatchedFunctionPairs(var4);
      ((ExtendedMatchedFunctionViewsTableModel)AddedAndRemovedCalledFunctionsPanel.access$300(this.this$0).getTableModel()).setMatchedFunctionPairs(var3);
      ((ExtendedMatchedFunctionViewsTableModel)AddedAndRemovedCalledFunctionsPanel.access$200(this.this$0).getTableModel()).fireTableDataChanged();
      ((ExtendedMatchedFunctionViewsTableModel)AddedAndRemovedCalledFunctionsPanel.access$300(this.this$0).getTableModel()).fireTableDataChanged();
      AddedAndRemovedCalledFunctionsPanel.access$400(this.this$0, var5, var6, var7, var8);
   }

   public void tableDataChanged(MatchedFunctionsViewsTableModel var1) {
   }

   // $FF: synthetic method
   AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener(AddedAndRemovedCalledFunctionsPanel var1, AddedAndRemovedCalledFunctionsPanel$1 var2) {
      this(var1);
   }
}
