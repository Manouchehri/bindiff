package org.jfree.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.table.JTableHeader;
import org.jfree.ui.SortButtonRenderer;
import org.jfree.ui.SortableTableModel;

public class SortableTableHeaderListener implements MouseListener, MouseMotionListener {
   private SortableTableModel model;
   private SortButtonRenderer renderer;
   private int sortColumnIndex;

   public SortableTableHeaderListener(SortableTableModel var1, SortButtonRenderer var2) {
      this.model = var1;
      this.renderer = var2;
   }

   public void setTableModel(SortableTableModel var1) {
      this.model = var1;
   }

   public void mousePressed(MouseEvent var1) {
      JTableHeader var2 = (JTableHeader)var1.getComponent();
      if(var2.getResizingColumn() == null && var2.getDraggedDistance() < 1) {
         int var3 = var2.columnAtPoint(var1.getPoint());
         int var4 = var2.getTable().convertColumnIndexToModel(var3);
         if(this.model.isSortable(var4)) {
            this.sortColumnIndex = var2.getTable().convertColumnIndexToModel(var3);
            this.renderer.setPressedColumn(this.sortColumnIndex);
            var2.repaint();
            if(var2.getTable().isEditing()) {
               var2.getTable().getCellEditor().stopCellEditing();
            }
         } else {
            this.sortColumnIndex = -1;
         }
      }

   }

   public void mouseDragged(MouseEvent var1) {
      JTableHeader var2 = (JTableHeader)var1.getComponent();
      if(var2.getDraggedDistance() > 0 || var2.getResizingColumn() != null) {
         this.renderer.setPressedColumn(-1);
         this.sortColumnIndex = -1;
      }

   }

   public void mouseEntered(MouseEvent var1) {
   }

   public void mouseClicked(MouseEvent var1) {
   }

   public void mouseMoved(MouseEvent var1) {
   }

   public void mouseExited(MouseEvent var1) {
   }

   public void mouseReleased(MouseEvent var1) {
      JTableHeader var2 = (JTableHeader)var1.getComponent();
      if(var2.getResizingColumn() == null && this.sortColumnIndex != -1) {
         SortableTableModel var3 = (SortableTableModel)var2.getTable().getModel();
         boolean var4 = !var3.isAscending();
         var3.setAscending(var4);
         var3.sortByColumn(this.sortColumnIndex, var4);
         this.renderer.setPressedColumn(-1);
         var2.repaint();
      }

   }
}
