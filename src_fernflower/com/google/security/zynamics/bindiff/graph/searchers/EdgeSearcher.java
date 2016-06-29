package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EdgeSearcher {
   public static ArrayList search(ZyGraphEdge var0, String var1, boolean var2, boolean var3) {
      ArrayList var4 = new ArrayList();
      if(!var1.isEmpty() && var0.getRealizer().labelCount() == 1) {
         ZyLabelContent var5 = var0.getRealizer().getEdgeLabelContent();
         int var6 = 0;

         label56:
         for(Iterator var7 = var5.iterator(); var7.hasNext(); ++var6) {
            ZyLineContent var8 = (ZyLineContent)var7.next();
            String var9 = var8.getText();
            if(!var3) {
               var9 = var9.toLowerCase();
            }

            int var10 = 0;

            Matcher var18;
            do {
               while(!var2) {
                  if(!var3) {
                     var1 = var1.toLowerCase();
                  }

                  int var11 = var9.indexOf(var1, var10);
                  if(var11 == -1) {
                     continue label56;
                  }

                  List var12 = var8.getBackgroundStyleRunData(var11, var11 + var1.length() - 1);
                  var4.add(new SearchResult(var0, var6, var11, var1.length(), var9, var12, Color.BLACK));
                  var10 = var11 + var1.length();
               }

               Pattern var17;
               if(var3) {
                  var17 = Pattern.compile(var1);
               } else {
                  var17 = Pattern.compile(var1, 2);
               }

               var18 = var17.matcher(var9);
               boolean var13 = var18.find(var10);
               if(!var13) {
                  break;
               }

               int var14 = var18.start();
               int var15 = var18.end();
               if(var14 != var15) {
                  List var16 = var8.getBackgroundStyleRunData(var14, var15);
                  var4.add(new SearchResult(var0, var6, var14, var15 - var14, var9, var16, Color.BLACK));
               }

               var10 = var15;
               if(var14 == var15) {
                  var10 = var15 + 1;
               }
            } while(var18.end() != var9.length());
         }

         return var4;
      } else {
         return var4;
      }
   }
}
