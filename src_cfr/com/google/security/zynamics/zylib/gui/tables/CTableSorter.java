/*
 * Decompiled with CFR 0_115.
 */
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
public class CTableSorter
extends AbstractTableModel {
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
    protected Map columnComparators = new HashMap();
    protected HashMap primaryColumnComparator = new HashMap();
    protected List sortingColumns = new ArrayList();

    public CTableSorter() {
        this.mouseListener = new CTableSorter$MouseHandler(this, null);
        this.tableModelListener = new CTableSorter$TableModelHandler(this, null);
    }

    public CTableSorter(TableModel tableModel) {
        this();
        this.setTableModel(tableModel);
    }

    public CTableSorter(TableModel tableModel, JTableHeader jTableHeader) {
        this();
        this.setTableHeader(jTableHeader);
        this.setTableModel(tableModel);
    }

    private CTableSorter$Directive getDirective(int n2) {
        int n3 = 0;
        while (n3 < this.sortingColumns.size()) {
            CTableSorter$Directive cTableSorter$Directive = (CTableSorter$Directive)this.sortingColumns.get(n3);
            if (cTableSorter$Directive.column == n2) {
                return cTableSorter$Directive;
            }
            ++n3;
        }
        return EMPTY_DIRECTIVE;
    }

    private CTableSorter$Row[] getViewToModel() {
        if (this.viewToModel != null) return this.viewToModel;
        int n2 = this.tableModel.getRowCount();
        this.viewToModel = new CTableSorter$Row[n2];
        int n3 = 0;
        do {
            if (n3 >= n2) {
                if (!this.isSorting()) return this.viewToModel;
                Arrays.sort(this.viewToModel);
                return this.viewToModel;
            }
            this.viewToModel[n3] = new CTableSorter$Row(this, n3);
            ++n3;
        } while (true);
    }

    private void sortingStatusChanged() {
        this.clearSortingState();
        this.fireTableDataChanged();
        if (this.tableHeader == null) return;
        this.tableHeader.repaint();
    }

    protected void cancelSorting() {
        this.sortingColumns.clear();
        this.sortingStatusChanged();
    }

    protected void clearSortingState() {
        this.viewToModel = null;
        this.modelToView = null;
    }

    protected Comparator getComparator(int n2) {
        Class class_ = this.tableModel.getColumnClass(n2);
        Comparator comparator = (Comparator)this.primaryColumnComparator.get(n2);
        if (comparator != null) {
            return comparator;
        }
        comparator = (Comparator)this.columnComparators.get(class_);
        if (comparator != null) {
            return comparator;
        }
        if (class_.equals(String.class)) {
            return new LexicalComparator();
        }
        if (!Comparable.class.isAssignableFrom(class_)) return new LexicalComparator();
        return COMPARABLE_COMPARATOR;
    }

    protected Icon getHeaderRendererIcon(int n2, int n3) {
        boolean bl2;
        CTableSorter$Directive cTableSorter$Directive = this.getDirective(n2);
        if (cTableSorter$Directive == EMPTY_DIRECTIVE) {
            return null;
        }
        if (cTableSorter$Directive.direction == -1) {
            bl2 = true;
            return new CTableSorter$Arrow(bl2, n3, this.sortingColumns.indexOf(cTableSorter$Directive));
        }
        bl2 = false;
        return new CTableSorter$Arrow(bl2, n3, this.sortingColumns.indexOf(cTableSorter$Directive));
    }

    protected int[] getModelToView() {
        if (this.modelToView != null) return this.modelToView;
        int n2 = this.getViewToModel().length;
        this.modelToView = new int[n2];
        int n3 = 0;
        while (n3 < n2) {
            this.modelToView[this.modelIndex((int)n3)] = n3++;
        }
        return this.modelToView;
    }

    public Class getColumnClass(int n2) {
        return this.tableModel.getColumnClass(n2);
    }

    @Override
    public int getColumnCount() {
        if (this.tableModel == null) {
            return 0;
        }
        int n2 = this.tableModel.getColumnCount();
        return n2;
    }

    @Override
    public String getColumnName(int n2) {
        return this.tableModel.getColumnName(n2);
    }

    @Override
    public int getRowCount() {
        if (this.tableModel == null) {
            return 0;
        }
        int n2 = this.tableModel.getRowCount();
        return n2;
    }

    public int getSortingStatus(int n2) {
        return this.getDirective((int)n2).direction;
    }

    public JTableHeader getTableHeader() {
        return this.tableHeader;
    }

    public TableModel getTableModel() {
        return this.tableModel;
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        return this.tableModel.getValueAt(this.modelIndex(n2), n3);
    }

    @Override
    public boolean isCellEditable(int n2, int n3) {
        return this.tableModel.isCellEditable(this.modelIndex(n2), n3);
    }

    public boolean isSorting() {
        if (this.sortingColumns.size() == 0) return false;
        return true;
    }

    public int modelIndex(int n2) {
        if (n2 < 0) return 0;
        return this.getViewToModel()[n2].modelIndex;
    }

    public void setColumnComparator(Class class_, Comparator comparator) {
        if (comparator == null) {
            this.columnComparators.remove(class_);
            return;
        }
        this.columnComparators.put(class_, comparator);
    }

    public void setColumnComparator(int n2, Comparator comparator) {
        if (comparator == null) return;
        this.primaryColumnComparator.put(n2, comparator);
    }

    public void setSortingStatus(int n2, int n3) {
        CTableSorter$Directive cTableSorter$Directive = this.getDirective(n2);
        if (cTableSorter$Directive != EMPTY_DIRECTIVE) {
            this.sortingColumns.remove(cTableSorter$Directive);
        }
        if (n3 != 0) {
            this.sortingColumns.add(new CTableSorter$Directive(n2, n3));
        }
        this.sortingStatusChanged();
    }

    public void setTableHeader(JTableHeader jTableHeader) {
        if (this.tableHeader != null) {
            this.tableHeader.removeMouseListener(this.mouseListener);
            TableCellRenderer tableCellRenderer = this.tableHeader.getDefaultRenderer();
            if (tableCellRenderer instanceof CTableSorter$SortableHeaderRenderer) {
                this.tableHeader.setDefaultRenderer(((CTableSorter$SortableHeaderRenderer)tableCellRenderer).tableCellRenderer);
            }
        }
        this.tableHeader = jTableHeader;
        if (this.tableHeader == null) return;
        this.tableHeader.addMouseListener(this.mouseListener);
        this.tableHeader.setDefaultRenderer(new CTableSorter$SortableHeaderRenderer(this, this.tableHeader.getDefaultRenderer()));
    }

    public void setTableModel(TableModel tableModel) {
        if (this.tableModel != null) {
            this.tableModel.removeTableModelListener(this.tableModelListener);
        }
        this.tableModel = tableModel;
        if (this.tableModel != null) {
            this.tableModel.addTableModelListener(this.tableModelListener);
        }
        this.clearSortingState();
        this.fireTableStructureChanged();
    }

    @Override
    public void setValueAt(Object object, int n2, int n3) {
        this.tableModel.setValueAt(object, this.modelIndex(n2), n3);
    }

    public int viewIndex(int n2) {
        if (n2 < 0) return 0;
        return this.getModelToView()[n2];
    }
}

