/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.EdgeSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSeacherFunctions;
import com.google.security.zynamics.bindiff.graph.searchers.NodeSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.bindiff.graph.searchers.SearchResultComparator;
import com.google.security.zynamics.bindiff.graph.sorters.SearchResultSorter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GraphSearcher {
    private boolean isRegEx;
    private boolean isCaseSensitive;
    private boolean onlySelected;
    private boolean onlyVisible;
    private boolean changed = true;
    private boolean isAfterLast = false;
    private boolean isBeforeFirst = false;
    private int currentSearchIndex = -1;
    private String lastSearchString;
    private final List subObjectResults = new ArrayList();
    private List objectResults = new ArrayList();

    private List filterValidEdgesNodes(List list) {
        ArrayList<ZyGraphEdge> arrayList = new ArrayList<ZyGraphEdge>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ZyGraphEdge zyGraphEdge = (ZyGraphEdge)iterator.next();
            if (!(zyGraphEdge instanceof SingleDiffEdge) && !(zyGraphEdge instanceof CombinedDiffEdge) && !(zyGraphEdge instanceof SuperDiffEdge)) continue;
            arrayList.add(zyGraphEdge);
        }
        return arrayList;
    }

    private List filterValidNodes(List list) {
        ArrayList<ZyGraphNode> arrayList = new ArrayList<ZyGraphNode>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (!(zyGraphNode instanceof SingleDiffNode) && !(zyGraphNode instanceof CombinedDiffNode) && !(zyGraphNode instanceof SuperDiffNode)) continue;
            arrayList.add(zyGraphNode);
        }
        return arrayList;
    }

    private void searchAll(List list, List list2, String string) {
        for (Object object2 : list) {
            this.searchNode((ZyGraphNode)object2, string);
        }
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (ZyGraphEdge)iterator.next();
            this.searchEdge((ZyGraphEdge)object2, string);
        }
    }

    private void searchEdge(ZyGraphEdge zyGraphEdge, String string) {
        this.subObjectResults.addAll(EdgeSearcher.search(zyGraphEdge, string, this.isRegEx, this.isCaseSensitive));
        if (this.subObjectResults.size() == 0) return;
        this.currentSearchIndex = 0;
    }

    private void searchNode(ZyGraphNode zyGraphNode, String string) {
        this.subObjectResults.addAll(NodeSearcher.search(zyGraphNode, string, this.isRegEx, this.isCaseSensitive));
        if (this.subObjectResults.size() == 0) return;
        this.currentSearchIndex = 0;
    }

    private void searchSelected(List list, List list2, String string) {
        for (Object object2 : list) {
            if (!object2.isSelected()) continue;
            this.searchNode((ZyGraphNode)object2, string);
        }
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (ZyGraphEdge)iterator.next();
            if (!object2.isSelected()) continue;
            this.searchEdge((ZyGraphEdge)object2, string);
        }
    }

    private void searchVisible(List list, List list2, String string) {
        for (Object object2 : list) {
            if (!object2.isVisible()) continue;
            this.searchNode((ZyGraphNode)object2, string);
        }
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (ZyGraphEdge)iterator.next();
            if (!object2.isVisible()) continue;
            this.searchEdge((ZyGraphEdge)object2, string);
        }
    }

    protected void setLastSearchString(String string) {
        this.changed = false;
        this.lastSearchString = string;
    }

    protected void setObjectResult(List list) {
        this.objectResults = list;
    }

    protected void sortResult() {
        Collections.sort(this.subObjectResults, new SearchResultComparator());
        HashSet<Object> hashSet = new HashSet<Object>();
        Iterator iterator = this.subObjectResults.iterator();
        do {
            if (!iterator.hasNext()) {
                this.objectResults = SearchResultSorter.getSortedList(hashSet, ESide.PRIMARY);
                return;
            }
            SearchResult searchResult = (SearchResult)iterator.next();
            hashSet.add(searchResult.getObject());
        } while (true);
    }

    public void clearResults() {
        Iterator iterator = this.subObjectResults.iterator();
        do {
            if (!iterator.hasNext()) {
                this.subObjectResults.clear();
                this.objectResults.clear();
                this.currentSearchIndex = 0;
                this.lastSearchString = "";
                this.changed = false;
                return;
            }
            SearchResult searchResult = (SearchResult)iterator.next();
            GraphSeacherFunctions.removeSubObjectHightlighing(searchResult);
        } while (true);
    }

    public Object current() {
        if (this.objectResults.size() == 0) {
            return null;
        }
        Object v0 = this.objectResults.get(this.currentSearchIndex);
        return v0;
    }

    public boolean getHasChanged(String string) {
        if (this.changed) return true;
        if (!string.equals(this.lastSearchString)) return true;
        return false;
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
        if (this.currentSearchIndex != this.objectResults.size()) return;
        this.currentSearchIndex = 0;
        this.isAfterLast = true;
    }

    public void previous() {
        if (this.current() == null) {
            return;
        }
        --this.currentSearchIndex;
        this.isBeforeFirst = false;
        this.isAfterLast = false;
        if (this.currentSearchIndex >= 0) return;
        this.currentSearchIndex = this.objectResults.size() - 1;
        this.isBeforeFirst = true;
    }

    public void search(List list, List list2, String string) {
        List list3 = this.filterValidNodes(list);
        List list4 = this.filterValidEdgesNodes(list2);
        this.setLastSearchString(string);
        if (this.onlySelected) {
            this.searchSelected(list3, list4, string);
        } else if (this.onlyVisible) {
            this.searchVisible(list3, list4, string);
        } else {
            this.searchAll(list3, list4, string);
        }
        this.sortResult();
    }

    public void setCaseSensitive(boolean bl2) {
        this.isCaseSensitive = bl2;
        this.changed = true;
    }

    public void setOnlySelected(boolean bl2) {
        this.onlySelected = bl2;
        this.changed = true;
    }

    public void setOnlyVisible(boolean bl2) {
        this.onlyVisible = bl2;
        this.changed = true;
    }

    public void setRegEx(boolean bl2) {
        this.isRegEx = bl2;
        this.changed = true;
    }
}

