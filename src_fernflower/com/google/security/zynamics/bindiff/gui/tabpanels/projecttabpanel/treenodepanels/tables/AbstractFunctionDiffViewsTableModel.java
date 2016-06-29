package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel$InternalDiffListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractFunctionDiffViewsTableModel extends AbstractTableModel {
   private final IDiffListener diffListener = new AbstractFunctionDiffViewsTableModel$InternalDiffListener(this, (AbstractFunctionDiffViewsTableModel$1)null);
   List functionDiffViewList;

   public AbstractFunctionDiffViewsTableModel(List var1) {
      Preconditions.checkNotNull(var1);
      this.functionDiffViewList = var1;
      this.addDiffListener();
   }

   private void addDiffListener() {
      Iterator var1 = this.functionDiffViewList.iterator();

      while(var1.hasNext()) {
         Diff var2 = (Diff)var1.next();
         var2.addListener(this.diffListener);
      }

   }

   private void removeDiffListener() {
      Iterator var1 = this.functionDiffViewList.iterator();

      while(var1.hasNext()) {
         Diff var2 = (Diff)var1.next();
         var2.removeListener(this.diffListener);
      }

   }

   public void addRow(Diff var1) {
      if(this.functionDiffViewList.add(var1)) {
         var1.addListener(this.diffListener);
         this.fireTableDataChanged();
      }

   }

   public void dispose() {
      this.removeDiffListener();
   }

   public Diff getDiffAt(int var1) {
      return (Diff)this.functionDiffViewList.get(var1);
   }

   public int getRowCount() {
      return this.functionDiffViewList.size();
   }

   public void removeRow(Diff var1) {
      if(this.functionDiffViewList.remove(var1)) {
         var1.removeListener(this.diffListener);
         this.fireTableDataChanged();
      }

   }

   public void setFunctionDiffList(List var1) {
      this.removeDiffListener();
      this.functionDiffViewList = var1;
      this.addDiffListener();
      this.fireTableDataChanged();
   }
}
