package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets$SetView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CGraphSelector$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import y.a.b;
import y.c.q;
import y.c.y;

public class CGraphSelector {
   public static void selectNode(AbstractZyGraph var0, ZyGraphNode var1, boolean var2) {
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      Iterator var5 = var0.getNodes().iterator();

      while(true) {
         while(var5.hasNext()) {
            ZyGraphNode var6 = (ZyGraphNode)var5.next();
            if(var6 == var1) {
               if(var1.isSelected()) {
                  var4.add(var6);
               } else {
                  var3.add(var6);
               }
            } else if(var6.isSelected() && var2) {
               var3.add(var6);
            } else {
               var4.add(var6);
            }
         }

         var0.selectNodes(var3, var4);
         return;
      }
   }

   public static void selectPath(AbstractZyGraph var0, ArrayList var1, ZyGraphNode var2) {
      CGraphSelector$1 var3 = new CGraphSelector$1();
      Collection var4 = Collections2.transform(var1, var3);
      y var5 = new y(var4.iterator());
      y var6 = new y(var2.getNode());
      HashSet var7 = new HashSet();
      y[] var8 = b.a(var0.getGraph(), var5, (byte)2, var0.getGraph().t(), 0);
      y[] var9 = var8;
      int var10 = var8.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         y var12 = var9[var11];
         var7.addAll(var12);
      }

      HashSet var20 = new HashSet();
      y[] var21 = b.a(var0.getGraph(), var6, (byte)1, var0.getGraph().t(), 0);
      y[] var22 = var21;
      int var24 = var21.length;

      for(int var13 = 0; var13 < var24; ++var13) {
         y var14 = var22[var13];
         var20.addAll(var14);
      }

      Sets$SetView var23 = Sets.intersection(var7, var20);
      if(!var23.isEmpty()) {
         Iterator var25 = var23.iterator();

         while(var25.hasNext()) {
            q var27 = (q)var25.next();
            var0.getGraph().a(var27, true);
         }
      }

      HashSet var26 = new HashSet();
      y[] var28 = b.a(var0.getGraph(), var5, (byte)1, var0.getGraph().t(), 0);
      y[] var29 = var28;
      int var15 = var28.length;

      for(int var16 = 0; var16 < var15; ++var16) {
         y var17 = var29[var16];
         var26.addAll(var17);
      }

      HashSet var30 = new HashSet();
      y[] var31 = b.a(var0.getGraph(), var6, (byte)2, var0.getGraph().t(), 0);
      y[] var32 = var31;
      int var34 = var31.length;

      for(int var18 = 0; var18 < var34; ++var18) {
         y var19 = var32[var18];
         var30.addAll(var19);
      }

      Sets$SetView var33 = Sets.intersection(var26, var30);
      if(!var33.isEmpty()) {
         Iterator var35 = var33.iterator();

         while(var35.hasNext()) {
            q var36 = (q)var35.next();
            var0.getGraph().a(var36, true);
         }
      }

   }
}
