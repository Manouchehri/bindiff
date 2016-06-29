/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.CheckboxCellEditor;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.CheckboxCellRenderer;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DefaultCellRenderer;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DestinationCellRenderer;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.IdbPairTableModel;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class IdbPairTable
extends JTable {
    private final CTableSorter tableSorter;
    private final IdbPairTableModel model;

    public IdbPairTable(File file, IdbPairTableModel idbPairTableModel) {
        Preconditions.checkNotNull(file);
        this.model = (IdbPairTableModel)Preconditions.checkNotNull(idbPairTableModel);
        this.tableSorter = new CTableSorter(idbPairTableModel);
        this.setModel(this.tableSorter);
        this.tableSorter.setTableHeader(this.getTableHeader());
        Object object = idbPairTableModel.getSorters().iterator();
        do {
            Object object2;
            if (!object.hasNext()) {
                this.getModel().getTableHeader().setToolTipText("Press CTRL to add secondary sort.");
                this.tableSorter.setTableHeader(this.getTableHeader());
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                this.setCellSelectionEnabled(false);
                object = this.getColumnModel().getColumn(0);
                object2 = this.getColumnModel().getColumn(1);
                TableColumn tableColumn = this.getColumnModel().getColumn(2);
                TableColumn tableColumn2 = this.getColumnModel().getColumn(3);
                object.setMaxWidth(30);
                object.setWidth(30);
                object.setMinWidth(30);
                object2.setMinWidth(150);
                object2.setWidth(150);
                tableColumn2.setMinWidth(375);
                tableColumn2.setWidth(375);
                CheckboxCellRenderer checkboxCellRenderer = new CheckboxCellRenderer();
                object.setCellRenderer(checkboxCellRenderer);
                object.setCellEditor(new CheckboxCellEditor());
                DefaultCellRenderer defaultCellRenderer = new DefaultCellRenderer();
                object2.setCellRenderer(defaultCellRenderer);
                tableColumn.setCellRenderer(defaultCellRenderer);
                DestinationCellRenderer destinationCellRenderer = new DestinationCellRenderer(file.getPath());
                tableColumn2.setCellRenderer(destinationCellRenderer);
                return;
            }
            object2 = (Pair)object.next();
            this.tableSorter.setColumnComparator((Integer)object2.first(), (Comparator)object2.second());
        } while (true);
    }

    @Override
    public CTableSorter getModel() {
        return this.tableSorter;
    }

    public IdbPairTableModel getTableModel() {
        return this.model;
    }

    public void setTableData(List list) {
        this.model.setTableData(list);
    }
}

