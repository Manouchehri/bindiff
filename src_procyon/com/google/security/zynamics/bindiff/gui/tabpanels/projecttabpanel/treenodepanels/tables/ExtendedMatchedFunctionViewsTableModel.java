package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import javax.swing.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.comparators.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.*;
import com.google.security.zynamics.zylib.general.comparators.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import java.util.*;
import com.google.security.zynamics.bindiff.utils.*;

public class ExtendedMatchedFunctionViewsTableModel extends AbstractTableModel
{
    public static final Icon ADDED_ICON;
    public static final Icon REMOVED_ICON;
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
    private final List sorters;
    private final List matchedFunctionPairs;
    
    public ExtendedMatchedFunctionViewsTableModel(final Diff diff) {
        super(diff);
        this.sorters = new ArrayList();
        this.matchedFunctionPairs = new ArrayList();
        this.initSorters();
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
    
    @Override
    public int getColumnCount() {
        return ExtendedMatchedFunctionViewsTableModel.COLUMNS.length;
    }
    
    @Override
    public String getColumnName(final int n) {
        return ExtendedMatchedFunctionViewsTableModel.COLUMNS[n];
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
        final EExistence eExistence = (EExistence)this.matchedFunctionPairs.get(n).third();
        String s = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        EFunctionType eFunctionType = EFunctionType.UNKNOWN;
        EFunctionType eFunctionType2 = EFunctionType.UNKNOWN;
        double similarity = -1.0;
        double confidence = -1.0;
        final boolean b = false;
        final boolean b2 = false;
        final boolean b3 = false;
        final boolean b4 = false;
        final boolean b5 = false;
        final boolean b6 = false;
        PercentageThreeBarCellData percentageThreeBarCellData;
        PercentageThreeBarCellData percentageThreeBarCellData2;
        if (rawFunction != null && rawFunction2 != null) {
            similarity = MatchesGetter.getFunctionMatch(this.getDiff(), rawFunction).getSimilarity();
            confidence = MatchesGetter.getFunctionMatch(this.getDiff(), rawFunction).getConfidence();
            s = rawFunction.getAddress().toHexString();
            s2 = rawFunction2.getAddress().toHexString();
            s3 = rawFunction.getName();
            s4 = rawFunction2.getName();
            eFunctionType = rawFunction.getFunctionType();
            eFunctionType2 = rawFunction2.getFunctionType();
            final int sizeOfMatchedBasicblocks = rawFunction.getSizeOfMatchedBasicblocks();
            final int n3 = rawFunction.getSizeOfBasicblocks() - sizeOfMatchedBasicblocks;
            final int n4 = rawFunction2.getSizeOfBasicblocks() - sizeOfMatchedBasicblocks;
            final int sizeOfMatchedJumps = rawFunction.getSizeOfMatchedJumps();
            final int n5 = rawFunction.getSizeOfJumps() - sizeOfMatchedJumps;
            final int n6 = rawFunction2.getSizeOfJumps() - sizeOfMatchedJumps;
            percentageThreeBarCellData = new PercentageThreeBarCellData(n3, sizeOfMatchedBasicblocks, n4, this.getColumnSortRelevance(n2));
            percentageThreeBarCellData2 = new PercentageThreeBarCellData(n5, sizeOfMatchedJumps, n6, this.getColumnSortRelevance(n2));
        }
        else if (rawFunction != null) {
            s = rawFunction.getAddress().toHexString();
            s3 = rawFunction.getName();
            eFunctionType = rawFunction.getFunctionType();
            final int sizeOfBasicblocks = rawFunction.getSizeOfBasicblocks();
            final int sizeOfJumps = rawFunction.getSizeOfJumps();
            percentageThreeBarCellData = new PercentageThreeBarCellData(sizeOfBasicblocks, b ? 1 : 0, b3 ? 1 : 0, this.getColumnSortRelevance(n2));
            percentageThreeBarCellData2 = new PercentageThreeBarCellData(sizeOfJumps, b4 ? 1 : 0, b6 ? 1 : 0, this.getColumnSortRelevance(n2));
        }
        else {
            if (rawFunction2 == null) {
                throw new IllegalStateException("Primary and secondary raw functions cannot both be null.");
            }
            s2 = rawFunction2.getAddress().toHexString();
            s4 = rawFunction2.getName();
            eFunctionType2 = rawFunction2.getFunctionType();
            final int sizeOfBasicblocks2 = rawFunction2.getSizeOfBasicblocks();
            final int sizeOfJumps2 = rawFunction2.getSizeOfJumps();
            percentageThreeBarCellData = new PercentageThreeBarCellData(b2 ? 1 : 0, b ? 1 : 0, sizeOfBasicblocks2, this.getColumnSortRelevance(n2));
            percentageThreeBarCellData2 = new PercentageThreeBarCellData(b5 ? 1 : 0, b4 ? 1 : 0, sizeOfJumps2, this.getColumnSortRelevance(n2));
        }
        switch (n2) {
            case 0: {
                return (eExistence == EExistence.ADDED) ? ExtendedMatchedFunctionViewsTableModel.ADDED_ICON : ExtendedMatchedFunctionViewsTableModel.REMOVED_ICON;
            }
            case 3: {
                return s;
            }
            case 4: {
                return s3;
            }
            case 5: {
                return eFunctionType;
            }
            case 9: {
                return percentageThreeBarCellData;
            }
            case 1: {
                return similarity;
            }
            case 2: {
                return confidence;
            }
            case 10: {
                return percentageThreeBarCellData2;
            }
            case 8: {
                return eFunctionType2;
            }
            case 7: {
                return s4;
            }
            case 6: {
                return s2;
            }
            default: {
                return null;
            }
        }
    }
    
    public void setMatchedFunctionPairs(final List list) {
        this.matchedFunctionPairs.clear();
        this.matchedFunctionPairs.addAll(list);
        this.fireTableDataChanged();
    }
    
    static {
        ADDED_ICON = ImageUtils.getImageIcon("data/tablecellicons/added.png");
        REMOVED_ICON = ImageUtils.getImageIcon("data/tablecellicons/removed.png");
        COLUMNS = new String[] { "", "Similarity", "Confidence", "Address", "Primary Name", "Type", "Address", "Secondary Name", "Type", "Basic Blocks", "Jumps" };
    }
}
