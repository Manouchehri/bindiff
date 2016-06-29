package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.*;
import com.google.security.zynamics.zylib.general.comparators.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class FunctionDiffViewsTableModel extends AbstractFunctionDiffViewsTableModel
{
    public static final int VIEWNAME = 0;
    public static final int SIMILARITY = 1;
    public static final int CONFIDENCE = 2;
    public static final int PRIMARY_ADDRESS = 3;
    public static final int PRIMARY_NAME = 4;
    public static final int SECONDARY_ADDRESS = 5;
    public static final int SECONDARY_NAME = 6;
    public static final int BASICBLOCK_MATCHES = 7;
    public static final int JUMP_MATCHES = 8;
    private static final String[] COLUMNS;
    private final List sorters;
    
    public FunctionDiffViewsTableModel(final List list) {
        super(list);
        this.sorters = new ArrayList();
    }
    
    @Override
    public int getColumnCount() {
        return FunctionDiffViewsTableModel.COLUMNS.length;
    }
    
    @Override
    public String getColumnName(final int n) {
        return FunctionDiffViewsTableModel.COLUMNS[n];
    }
    
    @Override
    public List getSorters() {
        this.sorters.add(new Pair(0, new LexicalComparator()));
        this.sorters.add(new Pair(3, new HexStringComparator()));
        this.sorters.add(new Pair(4, new LexicalComparator()));
        this.sorters.add(new Pair(7, new PercentageThreeBarCellDataComparator()));
        this.sorters.add(new Pair(1, new DoubleComparator()));
        this.sorters.add(new Pair(2, new DoubleComparator()));
        this.sorters.add(new Pair(8, new PercentageThreeBarCellDataComparator()));
        this.sorters.add(new Pair(6, new LexicalComparator()));
        this.sorters.add(new Pair(5, new HexStringComparator()));
        return this.sorters;
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        final Diff diff = this.functionDiffViewList.get(n);
        final String forceFilenameEndsNotWithExtension = CFileUtils.forceFilenameEndsNotWithExtension(diff.getMatchesDatabase().getName(), "BinDiff");
        final RawFunction rawFunction = diff.getCallgraph(ESide.PRIMARY).getNodes().get(0);
        final RawFunction rawFunction2 = diff.getCallgraph(ESide.SECONDARY).getNodes().get(0);
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
                return forceFilenameEndsNotWithExtension;
            }
            case 3: {
                return address.toHexString();
            }
            case 4: {
                return rawFunction.getName();
            }
            case 7: {
                return percentageThreeBarCellData;
            }
            case 2: {
                return MatchesGetter.getFunctionMatch(diff, rawFunction).getConfidence();
            }
            case 1: {
                return MatchesGetter.getFunctionMatch(diff, rawFunction).getSimilarity();
            }
            case 8: {
                return percentageThreeBarCellData2;
            }
            case 6: {
                return rawFunction2.getName();
            }
            case 5: {
                return address2.toHexString();
            }
            default: {
                return null;
            }
        }
    }
    
    public void deleteDiff(final Diff diff) {
        if (this.functionDiffViewList.remove(diff)) {
            this.fireTableDataChanged();
        }
    }
    
    static {
        COLUMNS = new String[] { "View Name", "Similarity", "Confidence", "Address", "Primary Name", "Address", "Secondary Name", "Basic Blocks", "Jumps" };
    }
}
