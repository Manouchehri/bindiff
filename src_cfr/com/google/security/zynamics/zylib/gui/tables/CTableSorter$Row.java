/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$Directive;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.TableModel;

class CTableSorter$Row
implements Comparable {
    protected int modelIndex;
    final /* synthetic */ CTableSorter this$0;

    public CTableSorter$Row(CTableSorter cTableSorter, int n2) {
        this.this$0 = cTableSorter;
        this.modelIndex = n2;
    }

    public int compareTo(Object object) {
        int n2;
        int n3;
        int n4 = this.modelIndex;
        int n5 = ((CTableSorter$Row)object).modelIndex;
        Iterator iterator = this.this$0.sortingColumns.iterator();
        do {
            if (!iterator.hasNext()) return 0;
            Object e2 = iterator.next();
            CTableSorter$Directive cTableSorter$Directive = (CTableSorter$Directive)e2;
            int n6 = cTableSorter$Directive.column;
            Object object2 = this.this$0.tableModel.getValueAt(n4, n6);
            Object object3 = this.this$0.tableModel.getValueAt(n5, n6);
            n2 = 0;
            n2 = object2 == null && object3 == null ? 0 : (object2 == null ? -1 : (object3 == null ? 1 : this.this$0.getComparator(n6).compare(object2, object3)));
        } while (n2 == 0);
        if (cTableSorter$Directive.direction == -1) {
            n3 = - n2;
            return n3;
        }
        n3 = n2;
        return n3;
    }
}

