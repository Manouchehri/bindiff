package org.jfree.ui;

import javax.swing.table.AbstractTableModel;

public abstract class SortableTableModel extends AbstractTableModel {
   private int sortingColumn = -1;
   private boolean ascending = true;

   public int getSortingColumn() {
      return this.sortingColumn;
   }

   public boolean isAscending() {
      return this.ascending;
   }

   public void setAscending(boolean var1) {
      this.ascending = var1;
   }

   public void sortByColumn(int var1, boolean var2) {
      if(this.isSortable(var1)) {
         this.sortingColumn = var1;
      }

   }

   public boolean isSortable(int var1) {
      return false;
   }
}
