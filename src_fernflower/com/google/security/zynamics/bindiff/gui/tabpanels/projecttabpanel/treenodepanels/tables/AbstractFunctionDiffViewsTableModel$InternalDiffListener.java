package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel$1;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;
import java.util.Iterator;

class AbstractFunctionDiffViewsTableModel$InternalDiffListener extends DiffListenerAdapter {
   // $FF: synthetic field
   final AbstractFunctionDiffViewsTableModel this$0;

   private AbstractFunctionDiffViewsTableModel$InternalDiffListener(AbstractFunctionDiffViewsTableModel var1) {
      this.this$0 = var1;
   }

   private Diff isExisting(String var1) {
      Iterator var2 = this.this$0.functionDiffViewList.iterator();

      Diff var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (Diff)var2.next();
      } while(!var3.getMatchesDatabase().getPath().equals(var1));

      return var3;
   }

   public void willOverwriteDiff(String var1) {
      Diff var2 = this.isExisting(var1);
      if(var2 != null) {
         this.this$0.removeRow(var2);
      }

   }

   // $FF: synthetic method
   AbstractFunctionDiffViewsTableModel$InternalDiffListener(AbstractFunctionDiffViewsTableModel var1, AbstractFunctionDiffViewsTableModel$1 var2) {
      this(var1);
   }
}
