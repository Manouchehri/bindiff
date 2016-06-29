/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageThreeBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.DoubleComparator;
import com.google.security.zynamics.zylib.general.comparators.HexStringComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FunctionDiffViewsTableModel
extends AbstractFunctionDiffViewsTableModel {
    public static final int VIEWNAME = 0;
    public static final int SIMILARITY = 1;
    public static final int CONFIDENCE = 2;
    public static final int PRIMARY_ADDRESS = 3;
    public static final int PRIMARY_NAME = 4;
    public static final int SECONDARY_ADDRESS = 5;
    public static final int SECONDARY_NAME = 6;
    public static final int BASICBLOCK_MATCHES = 7;
    public static final int JUMP_MATCHES = 8;
    private static final String[] COLUMNS = new String[]{"View Name", "Similarity", "Confidence", "Address", "Primary Name", "Address", "Secondary Name", "Basic Blocks", "Jumps"};
    private final List sorters = new ArrayList();

    public FunctionDiffViewsTableModel(List list) {
        super(list);
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
    public Object getValueAt(int n2, int n3) {
        Diff diff = (Diff)this.functionDiffViewList.get(n2);
        String string = diff.getMatchesDatabase().getName();
        string = CFileUtils.forceFilenameEndsNotWithExtension(string, "BinDiff");
        RawFunction rawFunction = (RawFunction)diff.getCallgraph(ESide.PRIMARY).getNodes().get(0);
        RawFunction rawFunction2 = (RawFunction)diff.getCallgraph(ESide.SECONDARY).getNodes().get(0);
        IAddress iAddress = rawFunction.getAddress();
        IAddress iAddress2 = rawFunction2.getAddress();
        int n4 = rawFunction.getSizeOfMatchedBasicblocks();
        int n5 = rawFunction.getSizeOfBasicblocks() - n4;
        int n6 = rawFunction2.getSizeOfBasicblocks() - n4;
        int n7 = rawFunction.getSizeOfMatchedJumps();
        int n8 = rawFunction.getSizeOfJumps() - n7;
        int n9 = rawFunction2.getSizeOfJumps() - n7;
        PercentageThreeBarCellData percentageThreeBarCellData = new PercentageThreeBarCellData(n5, n4, n6, this.getColumnSortRelevance(n3));
        PercentageThreeBarCellData percentageThreeBarCellData2 = new PercentageThreeBarCellData(n8, n7, n9, this.getColumnSortRelevance(n3));
        switch (n3) {
            case 0: {
                return string;
            }
            case 3: {
                return iAddress.toHexString();
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
                return iAddress2.toHexString();
            }
        }
        return null;
    }

    public void deleteDiff(Diff diff) {
        if (!this.functionDiffViewList.remove(diff)) return;
        this.fireTableDataChanged();
    }
}

