package com.google.security.zynamics.zylib.gui.tables;

import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.comparators.*;
import javax.swing.*;
import javax.swing.table.*;

@Deprecated
public class CTableSorter extends AbstractTableModel
{
    private static final long serialVersionUID = -6803591209710987100L;
    public static final int DESCENDING = -1;
    public static final int NOT_SORTED = 0;
    public static final int ASCENDING = 1;
    public static final CTableSorter$Directive EMPTY_DIRECTIVE;
    public static final Comparator COMPARABLE_COMPARATOR;
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
        this.mouseListener = new CTableSorter$MouseHandler(this, null);
        this.tableModelListener = new CTableSorter$TableModelHandler(this, null);
    }
    
    public CTableSorter(final TableModel tableModel) {
        this();
        this.setTableModel(tableModel);
    }
    
    public CTableSorter(final TableModel tableModel, final JTableHeader tableHeader) {
        this();
        this.setTableHeader(tableHeader);
        this.setTableModel(tableModel);
    }
    
    private CTableSorter$Directive getDirective(final int n) {
        for (int i = 0; i < this.sortingColumns.size(); ++i) {
            final CTableSorter$Directive cTableSorter$Directive = this.sortingColumns.get(i);
            if (cTableSorter$Directive.column == n) {
                return cTableSorter$Directive;
            }
        }
        return CTableSorter.EMPTY_DIRECTIVE;
    }
    
    private CTableSorter$Row[] getViewToModel() {
        if (this.viewToModel == null) {
            final int rowCount = this.tableModel.getRowCount();
            this.viewToModel = new CTableSorter$Row[rowCount];
            for (int i = 0; i < rowCount; ++i) {
                this.viewToModel[i] = new CTableSorter$Row(this, i);
            }
            if (this.isSorting()) {
                Arrays.sort(this.viewToModel);
            }
        }
        return this.viewToModel;
    }
    
    private void sortingStatusChanged() {
        this.clearSortingState();
        this.fireTableDataChanged();
        if (this.tableHeader != null) {
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
    
    protected Comparator getComparator(final int n) {
        final Class<?> columnClass = this.tableModel.getColumnClass(n);
        final Comparator comparator = this.primaryColumnComparator.get(n);
        if (comparator != null) {
            return comparator;
        }
        final Comparator comparator2 = this.columnComparators.get(columnClass);
        if (comparator2 != null) {
            return comparator2;
        }
        if (columnClass.equals(String.class)) {
            return new LexicalComparator();
        }
        if (Comparable.class.isAssignableFrom(columnClass)) {
            return CTableSorter.COMPARABLE_COMPARATOR;
        }
        return new LexicalComparator();
    }
    
    protected Icon getHeaderRendererIcon(final int n, final int n2) {
        final CTableSorter$Directive directive = this.getDirective(n);
        if (directive == CTableSorter.EMPTY_DIRECTIVE) {
            return null;
        }
        return new CTableSorter$Arrow(directive.direction == -1, n2, this.sortingColumns.indexOf(directive));
    }
    
    protected int[] getModelToView() {
        if (this.modelToView == null) {
            final int length = this.getViewToModel().length;
            this.modelToView = new int[length];
            for (int i = 0; i < length; ++i) {
                this.modelToView[this.modelIndex(i)] = i;
            }
        }
        return this.modelToView;
    }
    
    @Override
    public Class getColumnClass(final int n) {
        return this.tableModel.getColumnClass(n);
    }
    
    @Override
    public int getColumnCount() {
        return (this.tableModel == null) ? 0 : this.tableModel.getColumnCount();
    }
    
    @Override
    public String getColumnName(final int n) {
        return this.tableModel.getColumnName(n);
    }
    
    @Override
    public int getRowCount() {
        return (this.tableModel == null) ? 0 : this.tableModel.getRowCount();
    }
    
    public int getSortingStatus(final int n) {
        return this.getDirective(n).direction;
    }
    
    public JTableHeader getTableHeader() {
        return this.tableHeader;
    }
    
    public TableModel getTableModel() {
        return this.tableModel;
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        return this.tableModel.getValueAt(this.modelIndex(n), n2);
    }
    
    @Override
    public boolean isCellEditable(final int n, final int n2) {
        return this.tableModel.isCellEditable(this.modelIndex(n), n2);
    }
    
    public boolean isSorting() {
        return this.sortingColumns.size() != 0;
    }
    
    public int modelIndex(final int n) {
        if (n >= 0) {
            return this.getViewToModel()[n].modelIndex;
        }
        return 0;
    }
    
    public void setColumnComparator(final Class clazz, final Comparator comparator) {
        if (comparator == null) {
            this.columnComparators.remove(clazz);
        }
        else {
            this.columnComparators.put(clazz, comparator);
        }
    }
    
    public void setColumnComparator(final int n, final Comparator comparator) {
        if (comparator != null) {
            this.primaryColumnComparator.put(n, comparator);
        }
    }
    
    public void setSortingStatus(final int n, final int n2) {
        final CTableSorter$Directive directive = this.getDirective(n);
        if (directive != CTableSorter.EMPTY_DIRECTIVE) {
            this.sortingColumns.remove(directive);
        }
        if (n2 != 0) {
            this.sortingColumns.add(new CTableSorter$Directive(n, n2));
        }
        this.sortingStatusChanged();
    }
    
    public void setTableHeader(final JTableHeader tableHeader) {
        if (this.tableHeader != null) {
            this.tableHeader.removeMouseListener(this.mouseListener);
            final TableCellRenderer defaultRenderer = this.tableHeader.getDefaultRenderer();
            if (defaultRenderer instanceof CTableSorter$SortableHeaderRenderer) {
                this.tableHeader.setDefaultRenderer(((CTableSorter$SortableHeaderRenderer)defaultRenderer).tableCellRenderer);
            }
        }
        this.tableHeader = tableHeader;
        if (this.tableHeader != null) {
            this.tableHeader.addMouseListener(this.mouseListener);
            this.tableHeader.setDefaultRenderer(new CTableSorter$SortableHeaderRenderer(this, this.tableHeader.getDefaultRenderer()));
        }
    }
    
    public void setTableModel(final TableModel tableModel) {
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
    public void setValueAt(final Object o, final int n, final int n2) {
        this.tableModel.setValueAt(o, this.modelIndex(n), n2);
    }
    
    public int viewIndex(final int n) {
        if (n >= 0) {
            return this.getModelToView()[n];
        }
        return 0;
    }
    
    static {
        EMPTY_DIRECTIVE = new CTableSorter$Directive(-1, 0);
        COMPARABLE_COMPARATOR = new CTableSorter$1();
    }
}
