/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class TableHelpers {
    @Deprecated
    public static int[] normalizeRows(CTableSorter cTableSorter, int[] arrn) {
        int[] arrn2 = new int[arrn.length];
        int n2 = 0;
        while (n2 < arrn.length) {
            arrn2[n2] = cTableSorter.modelIndex(arrn[n2]);
            ++n2;
        }
        return arrn2;
    }

    public static void selectClickedRow(JTable jTable, MouseEvent mouseEvent) {
        int n2 = jTable.rowAtPoint(mouseEvent.getPoint());
        if (n2 == -1) {
            return;
        }
        jTable.setRowSelectionInterval(n2, n2);
    }
}

