package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphMover;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.CombinedGraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.bindiff.graph.searchers.SuperGraphSearcher;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CStyleRunData;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Color;
import java.awt.Window;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;

public class GraphSeacherFunctions {
   private static void markResults(SearchResult var0, boolean var1) {
      Color var2 = var1?Colors.SEARCH_HIGHLIGHT_COLOR:var0.getOriginalBorderColor();
      SingleDiffNode var3 = (SingleDiffNode)var0.getObject();
      if(var1) {
         var3.setBackgroundColor(var0.getLine(), var0.getPosition(), var0.getLength(), Colors.SEARCH_HIGHLIGHT_COLOR);
      } else {
         int var4 = var0.getLine();

         CStyleRunData var6;
         Color var7;
         for(Iterator var5 = var0.getOriginalTextBackgroundStyleRun().iterator(); var5.hasNext(); var3.setBackgroundColor(var4, var6.getStart(), var6.getLength(), var7)) {
            var6 = (CStyleRunData)var5.next();
            var7 = var6.getColor();
            ESide var8 = var3.getSide();
            if(var7 != null) {
               if(!var3.isSelected()) {
                  if(var8 == ESide.PRIMARY && var7.equals(Colors.PRIMARY_BASE.darker())) {
                     var7 = Colors.PRIMARY_BASE;
                  } else if(var8 == ESide.SECONDARY && var7 == Colors.SECONDARY_BASE) {
                     var7 = Colors.SECONDARY_BASE;
                  }
               } else if(var8 == ESide.PRIMARY && var7 == Colors.PRIMARY_BASE || var8 == ESide.SECONDARY && var7 == Colors.SECONDARY_BASE) {
                  var7 = var7.darker();
               }
            }
         }
      }

      var3.getRealizer().getRealizer().setLineColor(var2);
      CombinedDiffNode var9 = var3.getCombinedDiffNode();
      SingleDiffNode var10 = var9.getPrimaryDiffNode();
      SingleDiffNode var11 = var9.getSecondaryDiffNode();
      var9.getRealizer().getRealizer().setLineColor(var2);
      if(var10 != null && var11 != null && !var10.getRealizer().getRealizer().getLineColor().equals(var11.getRealizer().getRealizer().getLineColor())) {
         var9.getRealizer().getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
      }

   }

   public static void clearResults(GraphsContainer var0) {
      Iterator var1 = var0.iterator();

      while(var1.hasNext()) {
         BinDiffGraph var2 = (BinDiffGraph)var1.next();
         var2.getGraphSearcher().clearResults();
      }

   }

   public static boolean getHasChanged(GraphsContainer var0, String var1) {
      Iterator var2 = var0.iterator();

      BinDiffGraph var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (BinDiffGraph)var2.next();
      } while(!var3.getGraphSearcher().getHasChanged(var1));

      return true;
   }

   public static void highlightResults(List var0) {
      Iterator var1 = var0.iterator();

      while(var1.hasNext()) {
         SearchResult var2 = (SearchResult)var1.next();
         markResults(var2, true);
      }

   }

   public static void highlightSubObjectResults(GraphsContainer var0) {
      Iterator var1 = var0.iterator();

      while(true) {
         BinDiffGraph var2;
         do {
            if(!var1.hasNext()) {
               return;
            }

            var2 = (BinDiffGraph)var1.next();
         } while(!(var2 instanceof SingleGraph));

         Iterator var3 = var2.getGraphSearcher().getSubObjectResults().iterator();

         while(var3.hasNext()) {
            SearchResult var4 = (SearchResult)var3.next();
            markResults(var4, true);
         }
      }
   }

   public static boolean isEmpty(GraphsContainer var0) {
      Iterator var1 = var0.iterator();

      BinDiffGraph var2;
      do {
         if(!var1.hasNext()) {
            return true;
         }

         var2 = (BinDiffGraph)var1.next();
      } while(var2.getGraphSearcher().getObjectResults().isEmpty());

      return false;
   }

   public static void iterateObjectResults(GraphsContainer var0, boolean var1, boolean var2) {
      BinDiffGraph var3 = var0.getFocusedGraph();
      GraphSearcher var4 = var3.getGraphSearcher();
      Window var5 = SwingUtilities.getWindowAncestor(var0.getCombinedGraph().getView());
      if(var1) {
         var4.previous();
         if(var4.isBeforeFirst()) {
            CMessageBox.showInformation(var5, "All search results were displayed. Going back to the last one.");
         }
      } else {
         var4.next();
         if(var4.isAfterLast()) {
            CMessageBox.showInformation(var5, "All search results were displayed. Going back to the first one.");
         }
      }

      Object var6 = var4.current();
      if(var6 != null) {
         jumpToResultObject(var3, var6, var2);
      }
   }

   public static void jumpToFirstResultObject(BinDiffGraph var0, boolean var1) {
      List var2 = var0.getGraphSearcher().getObjectResults();
      if(!var2.isEmpty()) {
         Object var3 = var2.get(0);
         jumpToResultObject(var0, var3, var1);
      }

   }

   public static void jumpToResultObject(BinDiffGraph var0, Object var1, boolean var2) {
      if(var1 != null) {
         if(var1 instanceof ZyGraphNode) {
            Object var3 = var0;
            Object var4 = var1;
            if(var0 instanceof SuperGraph) {
               var3 = var0.getPrimaryGraph();
               var4 = ((SuperDiffNode)var1).getPrimaryDiffNode();
               if(var4 == null) {
                  var3 = var0.getSecondaryGraph();
                  var4 = ((SuperDiffNode)var1).getSecondaryDiffNode();
               }
            }

            if(var2) {
               GraphZoomer.zoomToNode((BinDiffGraph)var3, (ZyGraphNode)var4);
            } else {
               GraphMover.moveToNode((BinDiffGraph)var3, (ZyGraphNode)var4);
            }
         }

      }
   }

   public static void removeHightlighing(List var0) {
      Iterator var1 = var0.iterator();

      while(var1.hasNext()) {
         SearchResult var2 = (SearchResult)var1.next();
         removeSubObjectHightlighing(var2);
      }

   }

   public static void removeSubObjectHightlighing(SearchResult var0) {
      markResults(var0, false);
   }

   public static void search(GraphsContainer var0, String var1) {
      clearResults(var0);
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         BinDiffGraph var3 = (BinDiffGraph)var2.next();
         List var4 = GraphHelpers.getNodes(var3);
         List var5 = GraphHelpers.getEdges(var3);
         var3.getGraphSearcher().search(var4, var5, var1);
      }

      List var7 = var0.getPrimaryGraph().getGraphSearcher().getObjectResults();
      List var8 = var0.getSecondaryGraph().getGraphSearcher().getObjectResults();
      SuperGraph var9 = var0.getSuperGraph();
      CombinedGraph var6 = var0.getCombinedGraph();
      ((SuperGraphSearcher)var9.getGraphSearcher()).setObjectResults(var9, var7, var8);
      ((CombinedGraphSearcher)var6.getGraphSearcher()).setObjectResults(var6, var7, var8);
   }
}
