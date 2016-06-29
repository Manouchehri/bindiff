package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.sorters.*;

public class GraphSearcher
{
    private boolean isRegEx;
    private boolean isCaseSensitive;
    private boolean onlySelected;
    private boolean onlyVisible;
    private boolean changed;
    private boolean isAfterLast;
    private boolean isBeforeFirst;
    private int currentSearchIndex;
    private String lastSearchString;
    private final List subObjectResults;
    private List objectResults;
    
    public GraphSearcher() {
        this.changed = true;
        this.isAfterLast = false;
        this.isBeforeFirst = false;
        this.currentSearchIndex = -1;
        this.subObjectResults = new ArrayList();
        this.objectResults = new ArrayList();
    }
    
    private List filterValidEdgesNodes(final List list) {
        final ArrayList<ZyGraphEdge> list2 = new ArrayList<ZyGraphEdge>();
        for (final ZyGraphEdge zyGraphEdge : list) {
            if (zyGraphEdge instanceof SingleDiffEdge || zyGraphEdge instanceof CombinedDiffEdge || zyGraphEdge instanceof SuperDiffEdge) {
                list2.add(zyGraphEdge);
            }
        }
        return list2;
    }
    
    private List filterValidNodes(final List list) {
        final ArrayList<ZyGraphNode> list2 = new ArrayList<ZyGraphNode>();
        for (final ZyGraphNode zyGraphNode : list) {
            if (zyGraphNode instanceof SingleDiffNode || zyGraphNode instanceof CombinedDiffNode || zyGraphNode instanceof SuperDiffNode) {
                list2.add(zyGraphNode);
            }
        }
        return list2;
    }
    
    private void searchAll(final List list, final List list2, final String s) {
        final Iterator<ZyGraphNode> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.searchNode(iterator.next(), s);
        }
        final Iterator<ZyGraphEdge> iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            this.searchEdge(iterator2.next(), s);
        }
    }
    
    private void searchEdge(final ZyGraphEdge zyGraphEdge, final String s) {
        this.subObjectResults.addAll(EdgeSearcher.search(zyGraphEdge, s, this.isRegEx, this.isCaseSensitive));
        if (this.subObjectResults.size() != 0) {
            this.currentSearchIndex = 0;
        }
    }
    
    private void searchNode(final ZyGraphNode zyGraphNode, final String s) {
        this.subObjectResults.addAll(NodeSearcher.search(zyGraphNode, s, this.isRegEx, this.isCaseSensitive));
        if (this.subObjectResults.size() != 0) {
            this.currentSearchIndex = 0;
        }
    }
    
    private void searchSelected(final List list, final List list2, final String s) {
        for (final ZyGraphNode zyGraphNode : list) {
            if (zyGraphNode.isSelected()) {
                this.searchNode(zyGraphNode, s);
            }
        }
        for (final ZyGraphEdge zyGraphEdge : list2) {
            if (zyGraphEdge.isSelected()) {
                this.searchEdge(zyGraphEdge, s);
            }
        }
    }
    
    private void searchVisible(final List list, final List list2, final String s) {
        for (final ZyGraphNode zyGraphNode : list) {
            if (zyGraphNode.isVisible()) {
                this.searchNode(zyGraphNode, s);
            }
        }
        for (final ZyGraphEdge zyGraphEdge : list2) {
            if (zyGraphEdge.isVisible()) {
                this.searchEdge(zyGraphEdge, s);
            }
        }
    }
    
    protected void setLastSearchString(final String lastSearchString) {
        this.changed = false;
        this.lastSearchString = lastSearchString;
    }
    
    protected void setObjectResult(final List objectResults) {
        this.objectResults = objectResults;
    }
    
    protected void sortResult() {
        Collections.sort((List<Object>)this.subObjectResults, new SearchResultComparator());
        final HashSet<Object> set = new HashSet<Object>();
        final Iterator<SearchResult> iterator = this.subObjectResults.iterator();
        while (iterator.hasNext()) {
            set.add(iterator.next().getObject());
        }
        this.objectResults = SearchResultSorter.getSortedList(set, ESide.PRIMARY);
    }
    
    public void clearResults() {
        final Iterator<SearchResult> iterator = this.subObjectResults.iterator();
        while (iterator.hasNext()) {
            GraphSeacherFunctions.removeSubObjectHightlighing(iterator.next());
        }
        this.subObjectResults.clear();
        this.objectResults.clear();
        this.currentSearchIndex = 0;
        this.lastSearchString = "";
        this.changed = false;
    }
    
    public Object current() {
        return (this.objectResults.size() == 0) ? null : this.objectResults.get(this.currentSearchIndex);
    }
    
    public boolean getHasChanged(final String s) {
        return this.changed || !s.equals(this.lastSearchString);
    }
    
    public String getLastSearchString() {
        return this.lastSearchString;
    }
    
    public List getObjectResults() {
        return this.objectResults;
    }
    
    public List getSubObjectResults() {
        return this.subObjectResults;
    }
    
    public boolean isAfterLast() {
        return this.isAfterLast;
    }
    
    public boolean isBeforeFirst() {
        return this.isBeforeFirst;
    }
    
    public boolean isCaseSensitive() {
        return this.isCaseSensitive;
    }
    
    public boolean isRegEx() {
        return this.isRegEx;
    }
    
    public boolean isSelectedOnly() {
        return this.onlySelected;
    }
    
    public boolean isVisibleOnly() {
        return this.onlyVisible;
    }
    
    public void next() {
        if (this.current() == null) {
            return;
        }
        ++this.currentSearchIndex;
        this.isBeforeFirst = false;
        this.isAfterLast = false;
        if (this.currentSearchIndex == this.objectResults.size()) {
            this.currentSearchIndex = 0;
            this.isAfterLast = true;
        }
    }
    
    public void previous() {
        if (this.current() == null) {
            return;
        }
        --this.currentSearchIndex;
        this.isBeforeFirst = false;
        this.isAfterLast = false;
        if (this.currentSearchIndex < 0) {
            this.currentSearchIndex = this.objectResults.size() - 1;
            this.isBeforeFirst = true;
        }
    }
    
    public void search(final List list, final List list2, final String lastSearchString) {
        final List filterValidNodes = this.filterValidNodes(list);
        final List filterValidEdgesNodes = this.filterValidEdgesNodes(list2);
        this.setLastSearchString(lastSearchString);
        if (this.onlySelected) {
            this.searchSelected(filterValidNodes, filterValidEdgesNodes, lastSearchString);
        }
        else if (this.onlyVisible) {
            this.searchVisible(filterValidNodes, filterValidEdgesNodes, lastSearchString);
        }
        else {
            this.searchAll(filterValidNodes, filterValidEdgesNodes, lastSearchString);
        }
        this.sortResult();
    }
    
    public void setCaseSensitive(final boolean isCaseSensitive) {
        this.isCaseSensitive = isCaseSensitive;
        this.changed = true;
    }
    
    public void setOnlySelected(final boolean onlySelected) {
        this.onlySelected = onlySelected;
        this.changed = true;
    }
    
    public void setOnlyVisible(final boolean onlyVisible) {
        this.onlyVisible = onlyVisible;
        this.changed = true;
    }
    
    public void setRegEx(final boolean isRegEx) {
        this.isRegEx = isRegEx;
        this.changed = true;
    }
}
