package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.general.comparators.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import com.google.security.zynamics.bindiff.project.matches.*;

public class CallGraphViewTableModel extends AbstractTableModel
{
    public static final int SIMILARITY = 0;
    public static final int CONFIDENCE = 1;
    public static final int PRIMARY_NAME = 2;
    public static final int SECONDARY_NAME = 3;
    public static final int FUNCTIONS = 4;
    public static final int CALLS = 5;
    private final String[] COLUMNS;
    private final List sorters;
    
    public CallGraphViewTableModel(final Diff diff) {
        super(diff);
        this.COLUMNS = new String[] { "Similarity", "Confidence", "Primary Name", "Secondary Name", "Functions", "Calls" };
        this.sorters = new ArrayList();
        this.initSorters();
    }
    
    private void initSorters() {
        this.sorters.add(new Pair(0, new DoubleComparator()));
        this.sorters.add(new Pair(1, new DoubleComparator()));
        this.sorters.add(new Pair(2, new LexicalComparator()));
        this.sorters.add(new Pair(3, new LexicalComparator()));
        this.sorters.add(new Pair(4, new PercentageThreeBarCellDataComparator()));
        this.sorters.add(new Pair(5, new PercentageThreeBarCellDataComparator()));
    }
    
    @Override
    public int getColumnCount() {
        return this.COLUMNS.length;
    }
    
    @Override
    public String getColumnName(final int n) {
        return this.COLUMNS[n];
    }
    
    @Override
    public int getRowCount() {
        return 1;
    }
    
    @Override
    public List getSorters() {
        return this.sorters;
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        final MatchData matches = this.getDiff().getMatches();
        final PercentageThreeBarCellData percentageThreeBarCellData = new PercentageThreeBarCellData(matches.getSizeOfUnmatchedFunctions(ESide.PRIMARY), matches.getSizeOfMatchedFunctions(), matches.getSizeOfUnmatchedFunctions(ESide.SECONDARY));
        final PercentageThreeBarCellData percentageThreeBarCellData2 = new PercentageThreeBarCellData(matches.getSizeOfUnmatchedCalls(ESide.PRIMARY), matches.getSizeOfMatchedCalls(), matches.getSizeOfUnmatchedCalls(ESide.SECONDARY));
        final DiffMetaData metaData = this.getDiff().getMetaData();
        switch (n2) {
            case 0: {
                return metaData.getTotalSimilarity();
            }
            case 1: {
                return metaData.getTotalConfidence();
            }
            case 2: {
                return metaData.getImageName(ESide.PRIMARY);
            }
            case 3: {
                return metaData.getImageName(ESide.SECONDARY);
            }
            case 4: {
                return percentageThreeBarCellData;
            }
            case 5: {
                return percentageThreeBarCellData2;
            }
            default: {
                return null;
            }
        }
    }
}
