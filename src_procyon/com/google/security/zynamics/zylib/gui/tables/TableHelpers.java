package com.google.security.zynamics.zylib.gui.tables;

import javax.swing.*;
import java.awt.event.*;

public class TableHelpers
{
    @Deprecated
    public static int[] normalizeRows(final CTableSorter cTableSorter, final int[] array) {
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = cTableSorter.modelIndex(array[i]);
        }
        return array2;
    }
    
    public static void selectClickedRow(final JTable table, final MouseEvent mouseEvent) {
        final int rowAtPoint = table.rowAtPoint(mouseEvent.getPoint());
        if (rowAtPoint == -1) {
            return;
        }
        table.setRowSelectionInterval(rowAtPoint, rowAtPoint);
    }
}
