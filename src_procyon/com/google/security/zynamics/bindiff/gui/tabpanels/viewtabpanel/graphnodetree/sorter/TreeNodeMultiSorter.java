package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.*;
import com.google.security.zynamics.bindiff.log.*;

public class TreeNodeMultiSorter implements Iterable
{
    public static final int MAX_DEPTH = 5;
    private final ListenerProvider listeners;
    private final List criteria;
    
    public TreeNodeMultiSorter() {
        this.listeners = new ListenerProvider();
        (this.criteria = new ArrayList()).add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
        this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
        this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
        this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
        this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
        this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
    }
    
    public void addListener(final ITreeNodeSorterListener treeNodeSorterListener) {
        this.listeners.addListener(treeNodeSorterListener);
    }
    
    public List getCombinedBasicblockTreeNodeComparatorList() {
        final ArrayList<BasicBlockTreeNodeMatchStateComparator> list = new ArrayList<BasicBlockTreeNodeMatchStateComparator>();
        for (final Pair pair : this.criteria) {
            switch (TreeNodeMultiSorter$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[((ESortByCriterium)pair.first()).ordinal()]) {
                case 1: {
                    list.add(new CombinedTreeNodeAdressComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 2: {
                    list.add((CombinedTreeNodeAdressComparator)new BasicBlockTreeNodeMatchStateComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 3: {
                    list.add((CombinedTreeNodeAdressComparator)new TreeNodeVisibilityComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 4: {
                    list.add((CombinedTreeNodeAdressComparator)new TreeNodeSelectionComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 5: {
                    list.add((CombinedTreeNodeAdressComparator)new CombinedTreeNodeSideComparator((ESortOrder)pair.second()));
                    continue;
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
    
    public List getCombinedFunctionTreeNodeComparatorList() {
        final ArrayList<FunctionTreeNodeMatchStateComparator> list = new ArrayList<FunctionTreeNodeMatchStateComparator>();
        for (final Pair pair : this.criteria) {
            switch (TreeNodeMultiSorter$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[((ESortByCriterium)pair.first()).ordinal()]) {
                case 1: {
                    list.add(new CombinedTreeNodeAdressComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 2: {
                    list.add((CombinedTreeNodeAdressComparator)new FunctionTreeNodeMatchStateComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 3: {
                    list.add((CombinedTreeNodeAdressComparator)new TreeNodeVisibilityComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 4: {
                    list.add((CombinedTreeNodeAdressComparator)new TreeNodeSelectionComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 5: {
                    list.add((CombinedTreeNodeAdressComparator)new CombinedTreeNodeSideComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 6: {
                    list.add((CombinedTreeNodeAdressComparator)new FunctionTreeNodeTypeComparator((ESortOrder)pair.second()));
                    continue;
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
    
    public List getSingleBasicblockTreeNodeComparatorList() {
        final ArrayList<BasicBlockTreeNodeMatchStateComparator> list = new ArrayList<BasicBlockTreeNodeMatchStateComparator>();
        for (final Pair pair : this.criteria) {
            switch (TreeNodeMultiSorter$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[((ESortByCriterium)pair.first()).ordinal()]) {
                case 1: {
                    list.add(new SingleTreeNodeAdressComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 2: {
                    list.add((SingleTreeNodeAdressComparator)new BasicBlockTreeNodeMatchStateComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 3: {
                    list.add((SingleTreeNodeAdressComparator)new TreeNodeVisibilityComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 4: {
                    list.add((SingleTreeNodeAdressComparator)new TreeNodeSelectionComparator((ESortOrder)pair.second()));
                    continue;
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
    
    public List getSingleFunctionTreeNodeComparatorList() {
        final ArrayList<FunctionTreeNodeMatchStateComparator> list = new ArrayList<FunctionTreeNodeMatchStateComparator>();
        for (final Pair pair : this.criteria) {
            switch (TreeNodeMultiSorter$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[((ESortByCriterium)pair.first()).ordinal()]) {
                case 1: {
                    list.add(new CombinedTreeNodeAdressComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 2: {
                    list.add((CombinedTreeNodeAdressComparator)new FunctionTreeNodeMatchStateComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 3: {
                    list.add((CombinedTreeNodeAdressComparator)new TreeNodeVisibilityComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 4: {
                    list.add((CombinedTreeNodeAdressComparator)new TreeNodeSelectionComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 6: {
                    list.add((CombinedTreeNodeAdressComparator)new FunctionTreeNodeTypeComparator((ESortOrder)pair.second()));
                    continue;
                }
                case 7: {
                    list.add((CombinedTreeNodeAdressComparator)new FunctionTreeNodeNameComparator((ESortOrder)pair.second()));
                    continue;
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
    
    @Override
    public Iterator iterator() {
        return this.criteria.iterator();
    }
    
    public void notifyListeners() {
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().sortingChanged(this);
        }
    }
    
    public void removeListener(final ITreeNodeSorterListener treeNodeSorterListener) {
        this.listeners.removeListener(treeNodeSorterListener);
    }
    
    public void setCriterium(final ESortByCriterium eSortByCriterium, final ESortOrder eSortOrder, final int n, final boolean b) {
        if (n < 0 || n > 5) {
            Logger.logSevere("Severe: Criterium depth is out of range.", new Object[0]);
            return;
        }
        if (this.criteria.get(n).first() != eSortByCriterium || this.criteria.get(n).second() != eSortOrder) {
            this.criteria.remove(n);
            this.criteria.add(n, new Pair(eSortByCriterium, eSortOrder));
            if (b) {
                this.notifyListeners();
            }
        }
    }
}
