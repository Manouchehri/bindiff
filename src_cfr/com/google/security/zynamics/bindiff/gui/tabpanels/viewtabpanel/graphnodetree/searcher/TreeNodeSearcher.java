/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSeacherFunctions;
import com.google.security.zynamics.bindiff.graph.searchers.NodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ITreeNodeSearcherListener;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TreeNodeSearcher {
    private final ListenerProvider listeners = new ListenerProvider();
    private final ArrayList subObjectResults = new ArrayList();
    private final Set resultNodes = new HashSet();
    private boolean isPrimary;
    private boolean isSecondary;
    private boolean isRegEx;
    private boolean isCaseSensitive;
    private boolean highlightGraphNodes;
    private boolean useTemporaryResult;
    private String searchText;

    public TreeNodeSearcher(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.isRegEx = bl2;
        this.isCaseSensitive = bl3;
        this.isPrimary = bl4;
        this.isSecondary = bl5;
        this.useTemporaryResult = bl6;
        this.highlightGraphNodes = bl7;
        this.searchText = "";
    }

    private ArrayList search(ZyGraphNode zyGraphNode) {
        if (zyGraphNode != null) return NodeSearcher.search(zyGraphNode, this.searchText, this.isRegEx, this.isCaseSensitive);
        return new ArrayList();
    }

    public void addListener(ITreeNodeSearcherListener iTreeNodeSearcherListener) {
        this.listeners.addListener(iTreeNodeSearcherListener);
    }

    public boolean getHighlightGraphNodes() {
        return this.highlightGraphNodes;
    }

    public String getSearchString() {
        return this.searchText;
    }

    public boolean getUseTemporaryResults() {
        return this.useTemporaryResult;
    }

    public boolean isSearchHit(ZyGraphNode zyGraphNode) {
        return this.resultNodes.contains(zyGraphNode);
    }

    public void notifyListeners() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ITreeNodeSearcherListener iTreeNodeSearcherListener = (ITreeNodeSearcherListener)iterator.next();
            iTreeNodeSearcherListener.searchStringChanged(this);
        }
    }

    public void removeListener(ITreeNodeSearcherListener iTreeNodeSearcherListener) {
        this.listeners.removeListener(iTreeNodeSearcherListener);
    }

    public List search(List list) {
        if ("".equals(this.searchText) || list == null) {
            GraphSeacherFunctions.removeHightlighing(this.subObjectResults);
            this.subObjectResults.clear();
            return list;
        }
        ArrayList<ISearchableTreeNode> arrayList = new ArrayList<ISearchableTreeNode>();
        Iterator iterator = list.iterator();
        do {
            ArrayList arrayList2;
            if (!iterator.hasNext()) {
                GraphSeacherFunctions.highlightResults(this.subObjectResults);
                return arrayList;
            }
            ISearchableTreeNode iSearchableTreeNode = (ISearchableTreeNode)iterator.next();
            ZyGraphNode zyGraphNode = iSearchableTreeNode.getGraphNode(ESide.PRIMARY);
            ZyGraphNode zyGraphNode2 = iSearchableTreeNode.getGraphNode(ESide.SECONDARY);
            boolean bl2 = false;
            if (this.isPrimary && (arrayList2 = this.search(zyGraphNode)).size() != 0 && !bl2) {
                this.resultNodes.add(iSearchableTreeNode.getGraphNode());
                arrayList.add(iSearchableTreeNode);
                bl2 = true;
            }
            if (!this.isSecondary || (arrayList2 = this.search(zyGraphNode2)).size() == 0 || bl2) continue;
            this.resultNodes.add(iSearchableTreeNode.getGraphNode());
            arrayList.add(iSearchableTreeNode);
            bl2 = true;
        } while (true);
    }

    public void setSearchSettings(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.isRegEx = bl2;
        this.isCaseSensitive = bl3;
        this.isPrimary = bl4;
        this.isSecondary = bl5;
        this.useTemporaryResult = bl6;
        this.highlightGraphNodes = bl7;
    }

    public void setSearchString(String string) {
        this.searchText = string;
        this.notifyListeners();
    }

    public void setUseTemporaryResults(boolean bl2) {
        this.useTemporaryResult = bl2;
    }
}

