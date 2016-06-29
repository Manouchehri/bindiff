package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$1;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$Arrow;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$Directive;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$MouseHandler;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$Row;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$SortableHeaderRenderer;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$TableModelHandler;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

@Deprecated
public class CTableSorter extends AbstractTableModel {
   private static final long serialVersionUID = -6803591209710987100L;
   public static final int DESCENDING = -1;
   public static final int NOT_SORTED = 0;
   public static final int ASCENDING = 1;
   public static final CTableSorter$Directive EMPTY_DIRECTIVE = new CTableSorter$Directive(-1, 0);
   public static final Comparator COMPARABLE_COMPARATOR = new CTableSorter$1();
   protected TableModel tableModel;
   protected CTableSorter$Row[] viewToModel;
   protected int[] modelToView;
   protected JTableHeader tableHeader;
   protected MouseListener mouseListener;
   protected TableModelListener tableModelListener;
   protected Map columnComparators;
   protected HashMap primaryColumnComparator;
   protected List sortingColumns;

   public CTableSorter() {
      this.columnComparators = new HashMap();
      this.primaryColumnComparator = new HashMap();
      this.sortingColumns = new ArrayList();
      this.mouseListener = new CTableSorter$MouseHandler(this, (CTableSorter$1)null);
      this.tableModelListener = new CTableSorter$TableModelHandler(this, (CTableSorter$1)null);
   }

   public CTableSorter(TableModel var1) {
      this();
      this.setTableModel(var1);
   }

   public CTableSorter(TableModel var1, JTableHeader var2) {
      this();
      this.setTableHeader(var2);
      this.setTableModel(var1);
   }

   private CTableSorter$Directive getDirective(int var1) {
      for(int var2 = 0; var2 < this.sortingColumns.size(); ++var2) {
         CTableSorter$Directive var3 = (CTableSorter$Directive)this.sortingColumns.get(var2);
         if(var3.column == var1) {
            return var3;
         }
      }

      return EMPTY_DIRECTIVE;
   }

   private CTableSorter$Row[] getViewToModel() {
      if(this.viewToModel == null) {
         int var1 = this.tableModel.getRowCount();
         this.viewToModel = new CTableSorter$Row[var1];

         for(int var2 = 0; var2 < var1; ++var2) {
            this.viewToModel[var2] = new CTableSorter$Row(this, var2);
         }

         if(this.isSorting()) {
            Arrays.sort(this.viewToModel);
         }
      }

      return this.viewToModel;
   }

   private void sortingStatusChanged() {
      this.clearSortingState();
      this.fireTableDataChanged();
      if(this.tableHeader != null) {
         this.tableHeader.repaint();
      }

   }

   protected void cancelSorting() {
      this.sortingColumns.clear();
      this.sortingStatusChanged();
   }

   protected void clearSortingState() {
      this.viewToModel = null;
      this.modelToView = null;
   }

   protected Comparator getComparator(int var1) {
      Class var2 = this.tableModel.getColumnClass(var1);
      Comparator var3 = (Comparator)this.primaryColumnComparator.get(Integer.valueOf(var1));
      if(var3 != null) {
         return var3;
      } else {
         var3 = (Comparator)this.columnComparators.get(var2);
         return (Comparator)(var3 != null?var3:(var2.equals(String.class)?new LexicalComparator():(Comparable.class.isAssignableFrom(var2)?COMPARABLE_COMPARATOR:new LexicalComparator())));
      }
   }

   protected Icon getHeaderRendererIcon(int var1, int var2) {
      CTableSorter$Directive var3 = this.getDirective(var1);
      return var3 == EMPTY_DIRECTIVE?null:new CTableSorter$Arrow(var3.direction == -1, var2, this.sortingColumns.indexOf(var3));
   }

   protected int[] getModelToView() {
      if(this.modelToView == null) {
         int var1 = this.getViewToModel().length;
         this.modelToView = new int[var1];

         for(int var2 = 0; var2 < var1; this.modelToView[this.modelIndex(var2)] = var2++) {
            ;
         }
      }

      return this.modelToView;
   }

   public Class getColumnClass(int var1) {
      return this.tableModel.getColumnClass(var1);
   }

   public int getColumnCount() {
      return this.tableModel == null?0:this.tableModel.getColumnCount();
   }

   public String getColumnName(int var1) {
      return this.tableModel.getColumnName(var1);
   }

   public int getRowCount() {
      return this.tableModel == null?0:this.tableModel.getRowCount();
   }

   public int getSortingStatus(int var1) {
      return this.getDirective(var1).direction;
   }

   public JTableHeader getTableHeader() {
      return this.tableHeader;
   }

   public TableModel getTableModel() {
      return this.tableModel;
   }

   public Object getValueAt(int var1, int var2) {
      return this.tableModel.getValueAt(this.modelIndex(var1), var2);
   }

   public boolean isCellEditable(int var1, int var2) {
      return this.tableModel.isCellEditable(this.modelIndex(var1), var2);
   }

   public boolean isSorting() {
      return this.sortingColumns.size() != 0;
   }

   public int modelIndex(int var1) {
      return var1 >= 0?this.getViewToModel()[var1].modelIndex:0;
   }

   public void setColumnComparator(Class var1, Comparator var2) {
      if(var2 == null) {
         this.columnComparators.remove(var1);
      } else {
         this.columnComparators.put(var1, var2);
      }

   }

   public void setColumnComparator(int var1, Comparator var2) {
      if(var2 != null) {
         this.primaryColumnComparator.put(Integer.valueOf(var1), var2);
      }

   }

   public void setSortingStatus(int var1, int var2) {
      CTableSorter$Directive var3 = this.getDirective(var1);
      if(var3 != EMPTY_DIRECTIVE) {
         this.sortingColumns.remove(var3);
      }

      if(var2 != 0) {
         this.sortingColumns.add(new CTableSorter$Directive(var1, var2));
      }

      this.sortingStatusChanged();
   }

   public void setTableHeader(JTableHeader var1) {
      if(this.tableHeader != null) {
         this.tableHeader.removeMouseListener(this.mouseListener);
         TableCellRenderer var2 = this.tableHeader.getDefaultRenderer();
         if(var2 instanceof CTableSorter$SortableHeaderRenderer) {
            this.tableHeader.setDefaultRenderer(((CTableSorter$SortableHeaderRenderer)var2).tableCellRenderer);
         }
      }

      this.tableHeader = var1;
      if(this.tableHeader != null) {
         this.tableHeader.addMouseListener(this.mouseListener);
         this.tableHeader.setDefaultRenderer(new CTableSorter$SortableHeaderRenderer(this, this.tableHeader.getDefaultRenderer()));
      }

   }

   public void setTableModel(TableModel var1) {
      if(this.tableModel != null) {
         this.tableModel.removeTableModelListener(this.tableModelListener);
      }

      this.tableModel = var1;
      if(this.tableModel != null) {
         this.tableModel.addTableModelListener(this.tableModelListener);
      }

      this.clearSortingState();
      this.fireTableStructureChanged();
   }

   public void setValueAt(Object var1, int var2, int var3) {
      this.tableModel.setValueAt(var1, this.modelIndex(var2), var3);
   }

   public int viewIndex(int var1) {
      return var1 >= 0?this.getModelToView()[var1]:0;
   }
}
