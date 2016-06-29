package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.enums.*;

public class TreeNodeSearcher
{
    private final ListenerProvider listeners;
    private final ArrayList subObjectResults;
    private final Set resultNodes;
    private boolean isPrimary;
    private boolean isSecondary;
    private boolean isRegEx;
    private boolean isCaseSensitive;
    private boolean highlightGraphNodes;
    private boolean useTemporaryResult;
    private String searchText;
    
    public TreeNodeSearcher(final boolean isRegEx, final boolean isCaseSensitive, final boolean isPrimary, final boolean isSecondary, final boolean useTemporaryResult, final boolean highlightGraphNodes) {
        this.listeners = new ListenerProvider();
        this.subObjectResults = new ArrayList();
        this.resultNodes = new HashSet();
        this.isRegEx = isRegEx;
        this.isCaseSensitive = isCaseSensitive;
        this.isPrimary = isPrimary;
        this.isSecondary = isSecondary;
        this.useTemporaryResult = useTemporaryResult;
        this.highlightGraphNodes = highlightGraphNodes;
        this.searchText = "";
    }
    
    private ArrayList search(final ZyGraphNode zyGraphNode) {
        if (zyGraphNode == null) {
            return new ArrayList();
        }
        return NodeSearcher.search(zyGraphNode, this.searchText, this.isRegEx, this.isCaseSensitive);
    }
    
    public void addListener(final ITreeNodeSearcherListener treeNodeSearcherListener) {
        this.listeners.addListener(treeNodeSearcherListener);
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
    
    public boolean isSearchHit(final ZyGraphNode zyGraphNode) {
        return this.resultNodes.contains(zyGraphNode);
    }
    
    public void notifyListeners() {
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().searchStringChanged(this);
        }
    }
    
    public void removeListener(final ITreeNodeSearcherListener treeNodeSearcherListener) {
        this.listeners.removeListener(treeNodeSearcherListener);
    }
    
    public List search(final List list) {
        if ("".equals(this.searchText) || list == null) {
            GraphSeacherFunctions.removeHightlighing(this.subObjectResults);
            this.subObjectResults.clear();
            return list;
        }
        final ArrayList<ISearchableTreeNode> list2 = new ArrayList<ISearchableTreeNode>();
        for (final ISearchableTreeNode searchableTreeNode : list) {
            final ZyGraphNode graphNode = searchableTreeNode.getGraphNode(ESide.PRIMARY);
            final ZyGraphNode graphNode2 = searchableTreeNode.getGraphNode(ESide.SECONDARY);
            int n = 0;
            if (this.isPrimary && this.search(graphNode).size() != 0 && n == 0) {
                this.resultNodes.add(searchableTreeNode.getGraphNode());
                list2.add(searchableTreeNode);
                n = 1;
            }
            if (this.isSecondary && this.search(graphNode2).size() != 0 && n == 0) {
                this.resultNodes.add(searchableTreeNode.getGraphNode());
                list2.add(searchableTreeNode);
            }
        }
        GraphSeacherFunctions.highlightResults(this.subObjectResults);
        return list2;
    }
    
    public void setSearchSettings(final boolean isRegEx, final boolean isCaseSensitive, final boolean isPrimary, final boolean isSecondary, final boolean useTemporaryResult, final boolean highlightGraphNodes) {
        this.isRegEx = isRegEx;
        this.isCaseSensitive = isCaseSensitive;
        this.isPrimary = isPrimary;
        this.isSecondary = isSecondary;
        this.useTemporaryResult = useTemporaryResult;
        this.highlightGraphNodes = highlightGraphNodes;
    }
    
    public void setSearchString(final String searchText) {
        this.searchText = searchText;
        this.notifyListeners();
    }
    
    public void setUseTemporaryResults(final boolean useTemporaryResult) {
        this.useTemporaryResult = useTemporaryResult;
    }
}
