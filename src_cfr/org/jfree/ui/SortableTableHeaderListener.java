/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.jfree.ui.SortButtonRenderer;
import org.jfree.ui.SortableTableModel;

public class SortableTableHeaderListener
implements MouseListener,
MouseMotionListener {
    private SortableTableModel model;
    private SortButtonRenderer renderer;
    private int sortColumnIndex;

    public SortableTableHeaderListener(SortableTableModel sortableTableModel, SortButtonRenderer sortButtonRenderer) {
        this.model = sortableTableModel;
        this.renderer = sortButtonRenderer;
    }

    public void setTableModel(SortableTableModel sortableTableModel) {
        this.model = sortableTableModel;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        JTableHeader jTableHeader = (JTableHeader)mouseEvent.getComponent();
        if (jTableHeader.getResizingColumn() != null) return;
        if (jTableHeader.getDraggedDistance() >= 1) return;
        int n2 = jTableHeader.columnAtPoint(mouseEvent.getPoint());
        int n3 = jTableHeader.getTable().convertColumnIndexToModel(n2);
        if (this.model.isSortable(n3)) {
            this.sortColumnIndex = jTableHeader.getTable().convertColumnIndexToModel(n2);
            this.renderer.setPressedColumn(this.sortColumnIndex);
            jTableHeader.repaint();
            if (!jTableHeader.getTable().isEditing()) return;
            jTableHeader.getTable().getCellEditor().stopCellEditing();
            return;
        }
        this.sortColumnIndex = -1;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        JTableHeader jTableHeader = (JTableHeader)mouseEvent.getComponent();
        if (jTableHeader.getDraggedDistance() <= 0) {
            if (jTableHeader.getResizingColumn() == null) return;
        }
        this.renderer.setPressedColumn(-1);
        this.sortColumnIndex = -1;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        JTableHeader jTableHeader = (JTableHeader)mouseEvent.getComponent();
        if (jTableHeader.getResizingColumn() != null) return;
        if (this.sortColumnIndex == -1) return;
        SortableTableModel sortableTableModel = (SortableTableModel)jTableHeader.getTable().getModel();
        boolean bl2 = !sortableTableModel.isAscending();
        sortableTableModel.setAscending(bl2);
        sortableTableModel.sortByColumn(this.sortColumnIndex, bl2);
        this.renderer.setPressedColumn(-1);
        jTableHeader.repaint();
    }
}

