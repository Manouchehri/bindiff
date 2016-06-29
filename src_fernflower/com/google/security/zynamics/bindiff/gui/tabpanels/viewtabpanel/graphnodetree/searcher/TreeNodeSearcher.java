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

   public TreeNodeSearcher(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      this.isRegEx = var1;
      this.isCaseSensitive = var2;
      this.isPrimary = var3;
      this.isSecondary = var4;
      this.useTemporaryResult = var5;
      this.highlightGraphNodes = var6;
      this.searchText = "";
   }

   private ArrayList search(ZyGraphNode var1) {
      return var1 == null?new ArrayList():NodeSearcher.search(var1, this.searchText, this.isRegEx, this.isCaseSensitive);
   }

   public void addListener(ITreeNodeSearcherListener var1) {
      this.listeners.addListener(var1);
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

   public boolean isSearchHit(ZyGraphNode var1) {
      return this.resultNodes.contains(var1);
   }

   public void notifyListeners() {
      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         ITreeNodeSearcherListener var2 = (ITreeNodeSearcherListener)var1.next();
         var2.searchStringChanged(this);
      }

   }

   public void removeListener(ITreeNodeSearcherListener var1) {
      this.listeners.removeListener(var1);
   }

   public List search(List var1) {
      if(!"".equals(this.searchText) && var1 != null) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            ISearchableTreeNode var4 = (ISearchableTreeNode)var3.next();
            ZyGraphNode var5 = var4.getGraphNode(ESide.PRIMARY);
            ZyGraphNode var6 = var4.getGraphNode(ESide.SECONDARY);
            boolean var7 = false;
            ArrayList var8;
            if(this.isPrimary) {
               var8 = this.search(var5);
               if(var8.size() != 0 && !var7) {
                  this.resultNodes.add(var4.getGraphNode());
                  var2.add(var4);
                  var7 = true;
               }
            }

            if(this.isSecondary) {
               var8 = this.search(var6);
               if(var8.size() != 0 && !var7) {
                  this.resultNodes.add(var4.getGraphNode());
                  var2.add(var4);
                  var7 = true;
               }
            }
         }

         GraphSeacherFunctions.highlightResults(this.subObjectResults);
         return var2;
      } else {
         GraphSeacherFunctions.removeHightlighing(this.subObjectResults);
         this.subObjectResults.clear();
         return var1;
      }
   }

   public void setSearchSettings(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      this.isRegEx = var1;
      this.isCaseSensitive = var2;
      this.isPrimary = var3;
      this.isSecondary = var4;
      this.useTemporaryResult = var5;
      this.highlightGraphNodes = var6;
   }

   public void setSearchString(String var1) {
      this.searchText = var1;
      this.notifyListeners();
   }

   public void setUseTemporaryResults(boolean var1) {
      this.useTemporaryResult = var1;
   }
}
