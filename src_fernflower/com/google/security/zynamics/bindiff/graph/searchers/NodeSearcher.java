package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NodeSearcher {
   public static ArrayList search(ZyGraphNode var0, String var1, boolean var2, boolean var3) {
      ArrayList var4 = new ArrayList();
      if(var1.isEmpty()) {
         return var4;
      } else {
         IZyNodeRealizer var5 = var0.getRealizer();
         ZyLabelContent var6 = var5.getNodeContent();
         int var7 = 0;

         label57:
         for(Iterator var8 = var6.iterator(); var8.hasNext(); ++var7) {
            ZyLineContent var9 = (ZyLineContent)var8.next();
            String var10 = var9.getText();
            if(!var3) {
               var10 = var10.toLowerCase();
            }

            int var11 = 0;

            Matcher var20;
            do {
               while(!var2) {
                  if(!var3) {
                     var1 = var1.toLowerCase();
                  }

                  int var12 = var10.indexOf(var1, var11);
                  if(var12 == -1) {
                     continue label57;
                  }

                  List var13 = var9.getBackgroundStyleRunData(var12, var12 + var1.length() - 1);
                  Color var14 = var5.getRealizer().getLineColor();
                  var4.add(new SearchResult(var0, var7, var12, var1.length(), var10, var13, var14));
                  var11 = var12 + var1.length();
               }

               Pattern var19;
               if(var3) {
                  var19 = Pattern.compile(var1);
               } else {
                  var19 = Pattern.compile(var1, 2);
               }

               var20 = var19.matcher(var10);
               boolean var21 = var20.find(var11);
               if(!var21) {
                  break;
               }

               int var15 = var20.start();
               int var16 = var20.end();
               if(var15 != var16) {
                  List var17 = var9.getBackgroundStyleRunData(var15, var16);
                  Color var18 = var5.getRealizer().getLineColor();
                  var4.add(new SearchResult(var0, var7, var15, var16 - var15, var10, var17, var18));
               }

               var11 = var16;
               if(var15 == var16) {
                  var11 = var16 + 1;
               }
            } while(var20.end() != var10.length());
         }

         return var4;
      }
   }
}
