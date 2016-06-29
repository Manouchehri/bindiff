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

   private List filterValidEdgesNodes(List var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(true) {
         ZyGraphEdge var4;
         do {
            if(!var3.hasNext()) {
               return var2;
            }

            var4 = (ZyGraphEdge)var3.next();
         } while(!(var4 instanceof SingleDiffEdge) && !(var4 instanceof CombinedDiffEdge) && !(var4 instanceof SuperDiffEdge));

         var2.add(var4);
      }
   }

   private List filterValidNodes(List var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(true) {
         ZyGraphNode var4;
         do {
            if(!var3.hasNext()) {
               return var2;
            }

            var4 = (ZyGraphNode)var3.next();
         } while(!(var4 instanceof SingleDiffNode) && !(var4 instanceof CombinedDiffNode) && !(var4 instanceof SuperDiffNode));

         var2.add(var4);
      }
   }

   private void searchAll(List var1, List var2, String var3) {
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         ZyGraphNode var5 = (ZyGraphNode)var4.next();
         this.searchNode(var5, var3);
      }

      var4 = var2.iterator();

      while(var4.hasNext()) {
         ZyGraphEdge var6 = (ZyGraphEdge)var4.next();
         this.searchEdge(var6, var3);
      }

   }

   private void searchEdge(ZyGraphEdge var1, String var2) {
      this.subObjectResults.addAll(EdgeSearcher.search(var1, var2, this.isRegEx, this.isCaseSensitive));
      if(this.subObjectResults.size() != 0) {
         this.currentSearchIndex = 0;
      }

   }

   private void searchNode(ZyGraphNode var1, String var2) {
      this.subObjectResults.addAll(NodeSearcher.search(var1, var2, this.isRegEx, this.isCaseSensitive));
      if(this.subObjectResults.size() != 0) {
         this.currentSearchIndex = 0;
      }

   }

   private void searchSelected(List var1, List var2, String var3) {
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         ZyGraphNode var5 = (ZyGraphNode)var4.next();
         if(var5.isSelected()) {
            this.searchNode(var5, var3);
         }
      }

      var4 = var2.iterator();

      while(var4.hasNext()) {
         ZyGraphEdge var6 = (ZyGraphEdge)var4.next();
         if(var6.isSelected()) {
            this.searchEdge(var6, var3);
         }
      }

   }

   private void searchVisible(List var1, List var2, String var3) {
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         ZyGraphNode var5 = (ZyGraphNode)var4.next();
         if(var5.isVisible()) {
            this.searchNode(var5, var3);
         }
      }

      var4 = var2.iterator();

      while(var4.hasNext()) {
         ZyGraphEdge var6 = (ZyGraphEdge)var4.next();
         if(var6.isVisible()) {
            this.searchEdge(var6, var3);
         }
      }

   }

   protected void setLastSearchString(String var1) {
      this.changed = false;
      this.lastSearchString = var1;
   }

   protected void setObjectResult(List var1) {
      this.objectResults = var1;
   }

   protected void sortResult() {
      Collections.sort(this.subObjectResults, new SearchResultComparator());
      HashSet var1 = new HashSet();
      Iterator var2 = this.subObjectResults.iterator();

      while(var2.hasNext()) {
         SearchResult var3 = (SearchResult)var2.next();
         var1.add(var3.getObject());
      }

      this.objectResults = SearchResultSorter.getSortedList(var1, ESide.PRIMARY);
   }

   public void clearResults() {
      Iterator var1 = this.subObjectResults.iterator();

      while(var1.hasNext()) {
         SearchResult var2 = (SearchResult)var1.next();
         GraphSeacherFunctions.removeSubObjectHightlighing(var2);
      }

      this.subObjectResults.clear();
      this.objectResults.clear();
      this.currentSearchIndex = 0;
      this.lastSearchString = "";
      this.changed = false;
   }

   public Object current() {
      return this.objectResults.size() == 0?null:this.objectResults.get(this.currentSearchIndex);
   }

   public boolean getHasChanged(String var1) {
      return this.changed || !var1.equals(this.lastSearchString);
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
      if(this.current() != null) {
         ++this.currentSearchIndex;
         this.isBeforeFirst = false;
         this.isAfterLast = false;
         if(this.currentSearchIndex == this.objectResults.size()) {
            this.currentSearchIndex = 0;
            this.isAfterLast = true;
         }

      }
   }

   public void previous() {
      if(this.current() != null) {
         --this.currentSearchIndex;
         this.isBeforeFirst = false;
         this.isAfterLast = false;
         if(this.currentSearchIndex < 0) {
            this.currentSearchIndex = this.objectResults.size() - 1;
            this.isBeforeFirst = true;
         }

      }
   }

   public void search(List var1, List var2, String var3) {
      List var4 = this.filterValidNodes(var1);
      List var5 = this.filterValidEdgesNodes(var2);
      this.setLastSearchString(var3);
      if(this.onlySelected) {
         this.searchSelected(var4, var5, var3);
      } else if(this.onlyVisible) {
         this.searchVisible(var4, var5, var3);
      } else {
         this.searchAll(var4, var5, var3);
      }

      this.sortResult();
   }

   public void setCaseSensitive(boolean var1) {
      this.isCaseSensitive = var1;
      this.changed = true;
   }

   public void setOnlySelected(boolean var1) {
      this.onlySelected = var1;
      this.changed = true;
   }

   public void setOnlyVisible(boolean var1) {
      this.onlyVisible = var1;
      this.changed = true;
   }

   public void setRegEx(boolean var1) {
      this.isRegEx = var1;
      this.changed = true;
   }
}
