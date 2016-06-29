/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter;

import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.BasicBlockTreeNodeMatchStateComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.CombinedTreeNodeAdressComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.CombinedTreeNodeSideComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.FunctionTreeNodeMatchStateComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.FunctionTreeNodeNameComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.FunctionTreeNodeTypeComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.SingleTreeNodeAdressComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.TreeNodeSelectionComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.TreeNodeVisibilityComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ITreeNodeSorterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter$1;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TreeNodeMultiSorter
implements Iterable {
    public static final int MAX_DEPTH = 5;
    private final ListenerProvider listeners = new ListenerProvider();
    private final List criteria = new ArrayList();

    public TreeNodeMultiSorter() {
        this.criteria.add(new Pair((Object)ESortByCriterium.NONE, (Object)ESortOrder.ASCENDING));
        this.criteria.add(new Pair((Object)ESortByCriterium.NONE, (Object)ESortOrder.ASCENDING));
        this.criteria.add(new Pair((Object)ESortByCriterium.NONE, (Object)ESortOrder.ASCENDING));
        this.criteria.add(new Pair((Object)ESortByCriterium.NONE, (Object)ESortOrder.ASCENDING));
        this.criteria.add(new Pair((Object)ESortByCriterium.NONE, (Object)ESortOrder.ASCENDING));
        this.criteria.add(new Pair((Object)ESortByCriterium.NONE, (Object)ESortOrder.ASCENDING));
    }

    public void addListener(ITreeNodeSorterListener iTreeNodeSorterListener) {
        this.listeners.addListener(iTreeNodeSorterListener);
    }

    public List getCombinedBasicblockTreeNodeComparatorList() {
        ArrayList<Comparator> arrayList = new ArrayList<Comparator>();
        Iterator iterator = this.criteria.iterator();
        do {
            if (!iterator.hasNext()) {
                Collections.reverse(arrayList);
                return arrayList;
            }
            Pair pair = (Pair)iterator.next();
            switch ((ESortByCriterium)((Object)pair.first())) {
                case ADDRESS: {
                    arrayList.add(new CombinedTreeNodeAdressComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case MATCHSTATE: {
                    arrayList.add(new BasicBlockTreeNodeMatchStateComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case VISIBILITY: {
                    arrayList.add(new TreeNodeVisibilityComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case SELECTION: {
                    arrayList.add(new TreeNodeSelectionComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case SIDE: {
                    arrayList.add(new CombinedTreeNodeSideComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
            }
        } while (true);
    }

    public List getCombinedFunctionTreeNodeComparatorList() {
        ArrayList<Comparator> arrayList = new ArrayList<Comparator>();
        Iterator iterator = this.criteria.iterator();
        do {
            if (!iterator.hasNext()) {
                Collections.reverse(arrayList);
                return arrayList;
            }
            Pair pair = (Pair)iterator.next();
            switch ((ESortByCriterium)((Object)pair.first())) {
                case ADDRESS: {
                    arrayList.add(new CombinedTreeNodeAdressComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case MATCHSTATE: {
                    arrayList.add(new FunctionTreeNodeMatchStateComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case VISIBILITY: {
                    arrayList.add(new TreeNodeVisibilityComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case SELECTION: {
                    arrayList.add(new TreeNodeSelectionComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case SIDE: {
                    arrayList.add(new CombinedTreeNodeSideComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case FUNCTIONTYPE: {
                    arrayList.add(new FunctionTreeNodeTypeComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
            }
        } while (true);
    }

    public List getSingleBasicblockTreeNodeComparatorList() {
        ArrayList<Comparator> arrayList = new ArrayList<Comparator>();
        Iterator iterator = this.criteria.iterator();
        do {
            if (!iterator.hasNext()) {
                Collections.reverse(arrayList);
                return arrayList;
            }
            Pair pair = (Pair)iterator.next();
            switch ((ESortByCriterium)((Object)pair.first())) {
                case ADDRESS: {
                    arrayList.add(new SingleTreeNodeAdressComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case MATCHSTATE: {
                    arrayList.add(new BasicBlockTreeNodeMatchStateComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case VISIBILITY: {
                    arrayList.add(new TreeNodeVisibilityComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case SELECTION: {
                    arrayList.add(new TreeNodeSelectionComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
            }
        } while (true);
    }

    public List getSingleFunctionTreeNodeComparatorList() {
        ArrayList<Comparator> arrayList = new ArrayList<Comparator>();
        Iterator iterator = this.criteria.iterator();
        do {
            if (!iterator.hasNext()) {
                Collections.reverse(arrayList);
                return arrayList;
            }
            Pair pair = (Pair)iterator.next();
            switch (TreeNodeMultiSorter$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[((ESortByCriterium)((Object)pair.first())).ordinal()]) {
                case 1: {
                    arrayList.add(new CombinedTreeNodeAdressComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case 2: {
                    arrayList.add(new FunctionTreeNodeMatchStateComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case 3: {
                    arrayList.add(new TreeNodeVisibilityComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case 4: {
                    arrayList.add(new TreeNodeSelectionComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case 6: {
                    arrayList.add(new FunctionTreeNodeTypeComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
                case 7: {
                    arrayList.add(new FunctionTreeNodeNameComparator((ESortOrder)((Object)pair.second())));
                    break;
                }
            }
        } while (true);
    }

    public Iterator iterator() {
        return this.criteria.iterator();
    }

    public void notifyListeners() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ITreeNodeSorterListener iTreeNodeSorterListener = (ITreeNodeSorterListener)iterator.next();
            iTreeNodeSorterListener.sortingChanged(this);
        }
    }

    public void removeListener(ITreeNodeSorterListener iTreeNodeSorterListener) {
        this.listeners.removeListener(iTreeNodeSorterListener);
    }

    public void setCriterium(ESortByCriterium eSortByCriterium, ESortOrder eSortOrder, int n2, boolean bl2) {
        if (n2 < 0 || n2 > 5) {
            Logger.logSevere("Severe: Criterium depth is out of range.", new Object[0]);
            return;
        }
        if (((Pair)this.criteria.get(n2)).first() == eSortByCriterium) {
            if (((Pair)this.criteria.get(n2)).second() == eSortOrder) return;
        }
        this.criteria.remove(n2);
        this.criteria.add(n2, new Pair((Object)eSortByCriterium, (Object)eSortOrder));
        if (!bl2) return;
        this.notifyListeners();
    }
}

