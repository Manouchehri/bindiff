/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.EExistence;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.comparators.RawFunctionTypeComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.IconComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageThreeBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.Triple;
import com.google.security.zynamics.zylib.general.comparators.DoubleComparator;
import com.google.security.zynamics.zylib.general.comparators.HexStringComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.Icon;

public class ExtendedMatchedFunctionViewsTableModel
extends AbstractTableModel {
    public static final Icon ADDED_ICON = ImageUtils.getImageIcon("data/tablecellicons/added.png");
    public static final Icon REMOVED_ICON = ImageUtils.getImageIcon("data/tablecellicons/removed.png");
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
    private static final String[] COLUMNS = new String[]{"", "Similarity", "Confidence", "Address", "Primary Name", "Type", "Address", "Secondary Name", "Type", "Basic Blocks", "Jumps"};
    private final List sorters = new ArrayList();
    private final List matchedFunctionPairs = new ArrayList();

    public ExtendedMatchedFunctionViewsTableModel(Diff diff) {
        super(diff);
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
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int n2) {
        return COLUMNS[n2];
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
    public Object getValueAt(int n2, int n3) {
        RawFunction rawFunction = (RawFunction)((Triple)this.matchedFunctionPairs.get(n2)).first();
        RawFunction rawFunction2 = (RawFunction)((Triple)this.matchedFunctionPairs.get(n2)).second();
        EExistence eExistence = (EExistence)((Object)((Triple)this.matchedFunctionPairs.get(n2)).third());
        String string = "";
        String string2 = "";
        String string3 = "";
        String string4 = "";
        EFunctionType eFunctionType = EFunctionType.UNKNOWN;
        EFunctionType eFunctionType2 = EFunctionType.UNKNOWN;
        double d2 = -1.0;
        double d3 = -1.0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        PercentageThreeBarCellData percentageThreeBarCellData = null;
        PercentageThreeBarCellData percentageThreeBarCellData2 = null;
        if (rawFunction != null && rawFunction2 != null) {
            d2 = MatchesGetter.getFunctionMatch(this.getDiff(), rawFunction).getSimilarity();
            d3 = MatchesGetter.getFunctionMatch(this.getDiff(), rawFunction).getConfidence();
            string = rawFunction.getAddress().toHexString();
            string2 = rawFunction2.getAddress().toHexString();
            string3 = rawFunction.getName();
            string4 = rawFunction2.getName();
            eFunctionType = rawFunction.getFunctionType();
            eFunctionType2 = rawFunction2.getFunctionType();
            n4 = rawFunction.getSizeOfMatchedBasicblocks();
            n5 = rawFunction.getSizeOfBasicblocks() - n4;
            n6 = rawFunction2.getSizeOfBasicblocks() - n4;
            n7 = rawFunction.getSizeOfMatchedJumps();
            n8 = rawFunction.getSizeOfJumps() - n7;
            n9 = rawFunction2.getSizeOfJumps() - n7;
            percentageThreeBarCellData = new PercentageThreeBarCellData(n5, n4, n6, this.getColumnSortRelevance(n3));
            percentageThreeBarCellData2 = new PercentageThreeBarCellData(n8, n7, n9, this.getColumnSortRelevance(n3));
        } else if (rawFunction != null) {
            string = rawFunction.getAddress().toHexString();
            string3 = rawFunction.getName();
            eFunctionType = rawFunction.getFunctionType();
            n5 = rawFunction.getSizeOfBasicblocks();
            n8 = rawFunction.getSizeOfJumps();
            percentageThreeBarCellData = new PercentageThreeBarCellData(n5, n4, n6, this.getColumnSortRelevance(n3));
            percentageThreeBarCellData2 = new PercentageThreeBarCellData(n8, n7, n9, this.getColumnSortRelevance(n3));
        } else {
            if (rawFunction2 == null) throw new IllegalStateException("Primary and secondary raw functions cannot both be null.");
            string2 = rawFunction2.getAddress().toHexString();
            string4 = rawFunction2.getName();
            eFunctionType2 = rawFunction2.getFunctionType();
            n6 = rawFunction2.getSizeOfBasicblocks();
            n9 = rawFunction2.getSizeOfJumps();
            percentageThreeBarCellData = new PercentageThreeBarCellData(n5, n4, n6, this.getColumnSortRelevance(n3));
            percentageThreeBarCellData2 = new PercentageThreeBarCellData(n8, n7, n9, this.getColumnSortRelevance(n3));
        }
        switch (n3) {
            case 0: {
                Icon icon;
                if (eExistence == EExistence.ADDED) {
                    icon = ADDED_ICON;
                    return icon;
                }
                icon = REMOVED_ICON;
                return icon;
            }
            case 3: {
                return string;
            }
            case 4: {
                return string3;
            }
            case 5: {
                return eFunctionType;
            }
            case 9: {
                return percentageThreeBarCellData;
            }
            case 1: {
                return d2;
            }
            case 2: {
                return d3;
            }
            case 10: {
                return percentageThreeBarCellData2;
            }
            case 8: {
                return eFunctionType2;
            }
            case 7: {
                return string4;
            }
            case 6: {
                return string2;
            }
        }
        return null;
    }

    public void setMatchedFunctionPairs(List list) {
        this.matchedFunctionPairs.clear();
        this.matchedFunctionPairs.addAll(list);
        this.fireTableDataChanged();
    }
}

