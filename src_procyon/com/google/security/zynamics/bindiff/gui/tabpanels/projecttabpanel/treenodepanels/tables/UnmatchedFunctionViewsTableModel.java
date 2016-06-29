package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.comparators.*;
import com.google.security.zynamics.zylib.general.comparators.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;

public class UnmatchedFunctionViewsTableModel extends AbstractTableModel
{
    public static final int ADDRESS = 0;
    public static final int FUNCTION_NAME = 1;
    public static final int TYPE = 2;
    public static final int BASICBLOCKS = 3;
    public static final int JUMPS = 4;
    public static final int INSTRUCTIONS = 5;
    public static final int CALLERS = 6;
    public static final int CALLEES = 7;
    private static final String[] COLUMNS;
    private final ListenerProvider listeners;
    private final List sorters;
    private final ESide side;
    private final List unmatchedFunctions;
    
    public UnmatchedFunctionViewsTableModel(final Diff diff, final ESide side, final boolean b) {
        super(diff);
        this.listeners = new ListenerProvider();
        this.sorters = new ArrayList();
        this.unmatchedFunctions = new ArrayList();
        this.side = side;
        if (b) {
            final HashSet unmatchedFunctions = new HashSet();
            unmatchedFunctions.addAll(GraphGetter.getUnmatchedFunctions(diff.getCallgraph(side)));
            this.setUnmatchedFunctions(unmatchedFunctions);
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
    
    public void addListener(final IUnmatchedFunctionsViewsTableListener unmatchedFunctionsViewsTableListener) {
        this.listeners.addListener(unmatchedFunctionsViewsTableListener);
    }
    
    @Override
    public int getColumnCount() {
        return UnmatchedFunctionViewsTableModel.COLUMNS.length;
    }
    
    @Override
    public String getColumnName(final int n) {
        return UnmatchedFunctionViewsTableModel.COLUMNS[n];
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
    
    public RawFunction getUnmatchedFunctionAt(final int n) {
        return this.unmatchedFunctions.get(n);
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        if (this.getRowCount() == 0) {
            return null;
        }
        final RawFunction rawFunction = this.unmatchedFunctions.get(n);
        final IAddress address = rawFunction.getAddress();
        switch (n2) {
            case 0: {
                return address.toHexString();
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
            default: {
                return null;
            }
        }
    }
    
    public void removeListener(final IUnmatchedFunctionsViewsTableListener unmatchedFunctionsViewsTableListener) {
        this.listeners.removeListener(unmatchedFunctionsViewsTableListener);
    }
    
    public void setUnmatchedFunctions(final Set set) {
        this.unmatchedFunctions.clear();
        this.unmatchedFunctions.addAll(set);
        this.fireTableDataChanged();
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().tableDataChanged(this);
        }
    }
    
    static {
        COLUMNS = new String[] { "Address", "Name", "Type", "Basic Blocks", "Jumps", "Instructions", "Callers", "Callees" };
    }
}
