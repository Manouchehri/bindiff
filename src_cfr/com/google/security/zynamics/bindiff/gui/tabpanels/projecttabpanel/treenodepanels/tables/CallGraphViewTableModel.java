/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageThreeBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.DoubleComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.List;

public class CallGraphViewTableModel
extends AbstractTableModel {
    public static final int SIMILARITY = 0;
    public static final int CONFIDENCE = 1;
    public static final int PRIMARY_NAME = 2;
    public static final int SECONDARY_NAME = 3;
    public static final int FUNCTIONS = 4;
    public static final int CALLS = 5;
    private final String[] COLUMNS = new String[]{"Similarity", "Confidence", "Primary Name", "Secondary Name", "Functions", "Calls"};
    private final List sorters = new ArrayList();

    public CallGraphViewTableModel(Diff diff) {
        super(diff);
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
    public String getColumnName(int n2) {
        return this.COLUMNS[n2];
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
    public Object getValueAt(int n2, int n3) {
        MatchData matchData = this.getDiff().getMatches();
        PercentageThreeBarCellData percentageThreeBarCellData = new PercentageThreeBarCellData(matchData.getSizeOfUnmatchedFunctions(ESide.PRIMARY), matchData.getSizeOfMatchedFunctions(), matchData.getSizeOfUnmatchedFunctions(ESide.SECONDARY));
        PercentageThreeBarCellData percentageThreeBarCellData2 = new PercentageThreeBarCellData(matchData.getSizeOfUnmatchedCalls(ESide.PRIMARY), matchData.getSizeOfMatchedCalls(), matchData.getSizeOfUnmatchedCalls(ESide.SECONDARY));
        DiffMetaData diffMetaData = this.getDiff().getMetaData();
        switch (n3) {
            case 0: {
                return diffMetaData.getTotalSimilarity();
            }
            case 1: {
                return diffMetaData.getTotalConfidence();
            }
            case 2: {
                return diffMetaData.getImageName(ESide.PRIMARY);
            }
            case 3: {
                return diffMetaData.getImageName(ESide.SECONDARY);
            }
            case 4: {
                return percentageThreeBarCellData;
            }
            case 5: {
                return percentageThreeBarCellData2;
            }
        }
        return null;
    }
}

