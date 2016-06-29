/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.comparators.RawFunctionTypeComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageTwoBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IUnmatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.HexStringComparator;
import com.google.security.zynamics.zylib.general.comparators.IntComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UnmatchedFunctionViewsTableModel
extends AbstractTableModel {
    public static final int ADDRESS = 0;
    public static final int FUNCTION_NAME = 1;
    public static final int TYPE = 2;
    public static final int BASICBLOCKS = 3;
    public static final int JUMPS = 4;
    public static final int INSTRUCTIONS = 5;
    public static final int CALLERS = 6;
    public static final int CALLEES = 7;
    private static final String[] COLUMNS = new String[]{"Address", "Name", "Type", "Basic Blocks", "Jumps", "Instructions", "Callers", "Callees"};
    private final ListenerProvider listeners = new ListenerProvider();
    private final List sorters = new ArrayList();
    private final ESide side;
    private final List unmatchedFunctions = new ArrayList();

    public UnmatchedFunctionViewsTableModel(Diff diff, ESide eSide, boolean bl2) {
        super(diff);
        this.side = eSide;
        if (bl2) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(GraphGetter.getUnmatchedFunctions(diff.getCallgraph(eSide)));
            this.setUnmatchedFunctions(hashSet);
        }
        this.initSorters();
    }

    private void initSorters() {
        this.sorters.add(new Pair(0, new HexStringComparator()));
        this.sorters.add(new Pair(1, new LexicalComparator()));
        this.sorters.add(new Pair(2, new RawFunctionTypeComparator()));
        this.sorters.add(new Pair(3, new IntComparator()));
        this.sorters.add(new Pair(4, new IntComparator()));
        this.sorters.add(new Pair(5, new IntComparator()));
        this.sorters.add(new Pair(6, new IntComparator()));
        this.sorters.add(new Pair(7, new PercentageTwoBarCellDataComparator()));
    }

    public void addListener(IUnmatchedFunctionsViewsTableListener iUnmatchedFunctionsViewsTableListener) {
        this.listeners.addListener(iUnmatchedFunctionsViewsTableListener);
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int n2) {
        return COLUMNS[n2];
    }

    @Override
    public int getRowCount() {
        return this.unmatchedFunctions.size();
    }

    public ESide getSide() {
        return this.side;
    }

    @Override
    public List getSorters() {
        return this.sorters;
    }

    public RawFunction getUnmatchedFunctionAt(int n2) {
        return (RawFunction)this.unmatchedFunctions.get(n2);
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        if (this.getRowCount() == 0) {
            return null;
        }
        RawFunction rawFunction = (RawFunction)this.unmatchedFunctions.get(n2);
        IAddress iAddress = rawFunction.getAddress();
        switch (n3) {
            case 0: {
                return iAddress.toHexString();
            }
            case 1: {
                return rawFunction.getName();
            }
            case 2: {
                return rawFunction.getFunctionType();
            }
            case 3: {
                return rawFunction.getSizeOfBasicblocks();
            }
            case 4: {
                return rawFunction.getSizeOfJumps();
            }
            case 5: {
                return rawFunction.getSizeOfInstructions();
            }
            case 6: {
                return rawFunction.getCallers().size();
            }
            case 7: {
                return rawFunction.getCallees().size();
            }
        }
        return null;
    }

    public void removeListener(IUnmatchedFunctionsViewsTableListener iUnmatchedFunctionsViewsTableListener) {
        this.listeners.removeListener(iUnmatchedFunctionsViewsTableListener);
    }

    public void setUnmatchedFunctions(Set set) {
        this.unmatchedFunctions.clear();
        this.unmatchedFunctions.addAll(set);
        this.fireTableDataChanged();
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IUnmatchedFunctionsViewsTableListener iUnmatchedFunctionsViewsTableListener = (IUnmatchedFunctionsViewsTableListener)iterator.next();
            iUnmatchedFunctionsViewsTableListener.tableDataChanged(this);
        }
    }
}

