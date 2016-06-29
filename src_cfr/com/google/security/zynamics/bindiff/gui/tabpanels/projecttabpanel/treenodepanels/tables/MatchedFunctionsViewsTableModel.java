/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.comparators.RawFunctionTypeComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.IconComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators.PercentageThreeBarCellDataComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.DoubleComparator;
import com.google.security.zynamics.zylib.general.comparators.HexStringComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.Icon;

public class MatchedFunctionsViewsTableModel
extends AbstractTableModel {
    public static final Icon IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tablecellicons/flowgraphs-identical-matched-tab.png");
    public static final Icon INSTRUCTIONS_CHANGED_ICON = ImageUtils.getImageIcon("data/tablecellicons/flowgraphs-changed-instructions-only-tab.png");
    public static final Icon STRUCTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tablecellicons/flowgraphs_structural-changed-tab.png");
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
    private final ListenerProvider listeners = new ListenerProvider();
    private final List sorters = new ArrayList();
    private final List matchedFunctionPairs = new ArrayList();

    public MatchedFunctionsViewsTableModel(Diff diff, boolean bl2) {
        super(diff);
        if (bl2) {
            RawCallGraph rawCallGraph = diff.getCallgraph(ESide.PRIMARY);
            RawCallGraph rawCallGraph2 = diff.getCallgraph(ESide.SECONDARY);
            this.setMatchedFunctionPairs(GraphGetter.getChangedFunctionPairs(rawCallGraph, rawCallGraph2));
        }
        this.initSorters();
    }

    private Icon getIcon(RawFunction rawFunction, RawFunction rawFunction2) {
        if (MatchesGetter.isIdenticalFunctionPair(rawFunction, rawFunction2)) {
            return IDENTICAL_MATCHED_ICON;
        }
        if (MatchesGetter.isStructuralChangedFunctionPair(rawFunction, rawFunction2)) {
            return STRUCTURAL_CHANGED_ICON;
        }
        if (!MatchesGetter.isInstructionsOnlyChangedFunctionPair(rawFunction, rawFunction2)) return null;
        return INSTRUCTIONS_CHANGED_ICON;
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

    public void addListener(IMatchedFunctionsViewsTableListener iMatchedFunctionsViewsTableListener) {
        this.listeners.addListener(iMatchedFunctionsViewsTableListener);
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int n2) {
        return COLUMNS[n2];
    }

    public Pair getMatchedFunctionPairAt(int n2) {
        return (Pair)this.matchedFunctionPairs.get(n2);
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
        RawFunction rawFunction = (RawFunction)((Pair)this.matchedFunctionPairs.get(n2)).first();
        RawFunction rawFunction2 = (RawFunction)((Pair)this.matchedFunctionPairs.get(n2)).second();
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
                return this.getIcon(rawFunction, rawFunction2);
            }
            case 3: {
                return iAddress.toHexString();
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
                return iAddress2.toHexString();
            }
        }
        return null;
    }

    public void removeListener(IMatchedFunctionsViewsTableListener iMatchedFunctionsViewsTableListener) {
        this.listeners.removeListener(iMatchedFunctionsViewsTableListener);
    }

    public void setMatchedFunctionPairs(Set set) {
        this.matchedFunctionPairs.clear();
        this.matchedFunctionPairs.addAll(set);
        this.fireTableDataChanged();
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IMatchedFunctionsViewsTableListener iMatchedFunctionsViewsTableListener = (IMatchedFunctionsViewsTableListener)iterator.next();
            iMatchedFunctionsViewsTableListener.tableDataChanged(this);
        }
    }
}

