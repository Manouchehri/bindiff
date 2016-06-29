package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import javax.swing.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.comparators.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.*;
import com.google.security.zynamics.zylib.general.comparators.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;
import com.google.security.zynamics.bindiff.utils.*;

public class MatchedFunctionsViewsTableModel extends AbstractTableModel
{
    public static final Icon IDENTICAL_MATCHED_ICON;
    public static final Icon INSTRUCTIONS_CHANGED_ICON;
    public static final Icon STRUCTURAL_CHANGED_ICON;
    public static final int ICON = 0;
    public static final int SIMILARITY = 1;
    public static final int CONFIDENCE = 2;
    public static final int PRIMARY_ADDRESS = 3;
    public static final int PRIMARY_NAME = 4;
    public static final int PRIMARY_TYPE = 5;
    public static final int SECONDARY_ADDRESS = 6;
    public static final int SECONDARY_NAME = 7;
    public static final int SECONDARY_TYPE = 8;
    public static final int BASICBLOCK_MATCHES = 9;
    public static final int JUMP_MATCHES = 10;
    private static final String[] COLUMNS;
    private final ListenerProvider listeners;
    private final List sorters;
    private final List matchedFunctionPairs;
    
    public MatchedFunctionsViewsTableModel(final Diff diff, final boolean b) {
        super(diff);
        this.listeners = new ListenerProvider();
        this.sorters = new ArrayList();
        this.matchedFunctionPairs = new ArrayList();
        if (b) {
            this.setMatchedFunctionPairs(GraphGetter.getChangedFunctionPairs(diff.getCallgraph(ESide.PRIMARY), diff.getCallgraph(ESide.SECONDARY)));
        }
        this.initSorters();
    }
    
    private Icon getIcon(final RawFunction rawFunction, final RawFunction rawFunction2) {
        if (MatchesGetter.isIdenticalFunctionPair(rawFunction, rawFunction2)) {
            return MatchedFunctionsViewsTableModel.IDENTICAL_MATCHED_ICON;
        }
        if (MatchesGetter.isStructuralChangedFunctionPair(rawFunction, rawFunction2)) {
            return MatchedFunctionsViewsTableModel.STRUCTURAL_CHANGED_ICON;
        }
        if (MatchesGetter.isInstructionsOnlyChangedFunctionPair(rawFunction, rawFunction2)) {
            return MatchedFunctionsViewsTableModel.INSTRUCTIONS_CHANGED_ICON;
        }
        return null;
    }
    
    private void initSorters() {
        this.sorters.add(new Pair(0, new IconComparator()));
        this.sorters.add(new Pair(3, new HexStringComparator()));
        this.sorters.add(new Pair(4, new LexicalComparator()));
        this.sorters.add(new Pair(5, new RawFunctionTypeComparator()));
        this.sorters.add(new Pair(9, new PercentageThreeBarCellDataComparator()));
        this.sorters.add(new Pair(1, new DoubleComparator()));
        this.sorters.add(new Pair(2, new DoubleComparator()));
        this.sorters.add(new Pair(10, new PercentageThreeBarCellDataComparator()));
        this.sorters.add(new Pair(8, new RawFunctionTypeComparator()));
        this.sorters.add(new Pair(7, new LexicalComparator()));
        this.sorters.add(new Pair(6, new HexStringComparator()));
    }
    
    public void addListener(final IMatchedFunctionsViewsTableListener matchedFunctionsViewsTableListener) {
        this.listeners.addListener(matchedFunctionsViewsTableListener);
    }
    
    @Override
    public int getColumnCount() {
        return MatchedFunctionsViewsTableModel.COLUMNS.length;
    }
    
    @Override
    public String getColumnName(final int n) {
        return MatchedFunctionsViewsTableModel.COLUMNS[n];
    }
    
    public Pair getMatchedFunctionPairAt(final int n) {
        return this.matchedFunctionPairs.get(n);
    }
    
    @Override
    public int getRowCount() {
        return this.matchedFunctionPairs.size();
    }
    
    @Override
    public List getSorters() {
        return this.sorters;
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        final RawFunction rawFunction = (RawFunction)this.matchedFunctionPairs.get(n).first();
        final RawFunction rawFunction2 = (RawFunction)this.matchedFunctionPairs.get(n).second();
        final IAddress address = rawFunction.getAddress();
        final IAddress address2 = rawFunction2.getAddress();
        final int sizeOfMatchedBasicblocks = rawFunction.getSizeOfMatchedBasicblocks();
        final int n3 = rawFunction.getSizeOfBasicblocks() - sizeOfMatchedBasicblocks;
        final int n4 = rawFunction2.getSizeOfBasicblocks() - sizeOfMatchedBasicblocks;
        final int sizeOfMatchedJumps = rawFunction.getSizeOfMatchedJumps();
        final int n5 = rawFunction.getSizeOfJumps() - sizeOfMatchedJumps;
        final int n6 = rawFunction2.getSizeOfJumps() - sizeOfMatchedJumps;
        final PercentageThreeBarCellData percentageThreeBarCellData = new PercentageThreeBarCellData(n3, sizeOfMatchedBasicblocks, n4, this.getColumnSortRelevance(n2));
        final PercentageThreeBarCellData percentageThreeBarCellData2 = new PercentageThreeBarCellData(n5, sizeOfMatchedJumps, n6, this.getColumnSortRelevance(n2));
        switch (n2) {
            case 0: {
                return this.getIcon(rawFunction, rawFunction2);
            }
            case 3: {
                return address.toHexString();
            }
            case 4: {
                return rawFunction.getName();
            }
            case 5: {
                return rawFunction.getFunctionType();
            }
            case 9: {
                return percentageThreeBarCellData;
            }
            case 1: {
                return MatchesGetter.getFunctionMatch(this.getDiff(), rawFunction).getSimilarity();
            }
            case 2: {
                return MatchesGetter.getFunctionMatch(this.getDiff(), rawFunction).getConfidence();
            }
            case 10: {
                return percentageThreeBarCellData2;
            }
            case 8: {
                return rawFunction2.getFunctionType();
            }
            case 7: {
                return rawFunction2.getName();
            }
            case 6: {
                return address2.toHexString();
            }
            default: {
                return null;
            }
        }
    }
    
    public void removeListener(final IMatchedFunctionsViewsTableListener matchedFunctionsViewsTableListener) {
        this.listeners.removeListener(matchedFunctionsViewsTableListener);
    }
    
    public void setMatchedFunctionPairs(final Set set) {
        this.matchedFunctionPairs.clear();
        this.matchedFunctionPairs.addAll(set);
        this.fireTableDataChanged();
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().tableDataChanged(this);
        }
    }
    
    static {
        IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tablecellicons/flowgraphs-identical-matched-tab.png");
        INSTRUCTIONS_CHANGED_ICON = ImageUtils.getImageIcon("data/tablecellicons/flowgraphs-changed-instructions-only-tab.png");
        STRUCTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tablecellicons/flowgraphs_structural-changed-tab.png");
        COLUMNS = new String[] { "", "Similarity", "Confidence", "Address", "Primary Name", "Type", "Address", "Secondary Name", "Type", "Basic Blocks", "Jumps" };
    }
}
