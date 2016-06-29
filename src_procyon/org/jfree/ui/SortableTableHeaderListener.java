package org.jfree.ui;

import java.awt.event.*;
import javax.swing.table.*;

public class SortableTableHeaderListener implements MouseListener, MouseMotionListener
{
    private SortableTableModel model;
    private SortButtonRenderer renderer;
    private int sortColumnIndex;
    
    public SortableTableHeaderListener(final SortableTableModel model, final SortButtonRenderer renderer) {
        this.model = model;
        this.renderer = renderer;
    }
    
    public void setTableModel(final SortableTableModel model) {
        this.model = model;
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
        final JTableHeader tableHeader = (JTableHeader)mouseEvent.getComponent();
        if (tableHeader.getResizingColumn() == null && tableHeader.getDraggedDistance() < 1) {
            final int columnAtPoint = tableHeader.columnAtPoint(mouseEvent.getPoint());
            if (this.model.isSortable(tableHeader.getTable().convertColumnIndexToModel(columnAtPoint))) {
                this.sortColumnIndex = tableHeader.getTable().convertColumnIndexToModel(columnAtPoint);
                this.renderer.setPressedColumn(this.sortColumnIndex);
                tableHeader.repaint();
                if (tableHeader.getTable().isEditing()) {
                    tableHeader.getTable().getCellEditor().stopCellEditing();
                }
            }
            else {
                this.sortColumnIndex = -1;
            }
        }
    }
    
    public void mouseDragged(final MouseEvent mouseEvent) {
        final JTableHeader tableHeader = (JTableHeader)mouseEvent.getComponent();
        if (tableHeader.getDraggedDistance() > 0 || tableHeader.getResizingColumn() != null) {
            this.renderer.setPressedColumn(-1);
            this.sortColumnIndex = -1;
        }
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
    }
    
    public void mouseClicked(final MouseEvent mouseEvent) {
    }
    
    public void mouseMoved(final MouseEvent mouseEvent) {
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        final JTableHeader tableHeader = (JTableHeader)mouseEvent.getComponent();
        if (tableHeader.getResizingColumn() == null && this.sortColumnIndex != -1) {
            final SortableTableModel sortableTableModel = (SortableTableModel)tableHeader.getTable().getModel();
            final boolean ascending = !sortableTableModel.isAscending();
            sortableTableModel.setAscending(ascending);
            sortableTableModel.sortByColumn(this.sortColumnIndex, ascending);
            this.renderer.setPressedColumn(-1);
            tableHeader.repaint();
        }
    }
}
