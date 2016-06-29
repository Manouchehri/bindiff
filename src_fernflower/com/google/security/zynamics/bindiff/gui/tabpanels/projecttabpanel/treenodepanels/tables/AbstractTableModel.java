package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractTableModel extends javax.swing.table.AbstractTableModel {
   private final Diff diff;
   private final Map sortRelevance = new HashMap();

   public AbstractTableModel() {
      this.diff = null;
   }

   public AbstractTableModel(Diff var1) {
      Preconditions.checkNotNull(var1);
      this.diff = var1;
   }

   protected EPercentageBarSortType getColumnSortRelevance(int var1) {
      return (EPercentageBarSortType)this.sortRelevance.get(Integer.valueOf(var1));
   }

   public void dispose() {
   }

   public abstract String getColumnName(int var1);

   public Diff getDiff() {
      return this.diff;
   }

   public abstract List getSorters();

   public void setColumnSortRelevance(int var1, EPercentageBarSortType var2) {
      if(var1 >= this.getColumnCount()) {
         Logger.logWarning("Column is not in table.", new Object[0]);
      } else {
         this.sortRelevance.put(Integer.valueOf(var1), var2);
      }
   }
}
