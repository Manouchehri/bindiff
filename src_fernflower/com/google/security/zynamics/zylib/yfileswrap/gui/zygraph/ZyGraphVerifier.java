package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import y.c.q;
import y.h.bu;

public class ZyGraphVerifier {
   public static void verifyMap(bu var0, HashMap var1) {
      boolean var10000 = var0.f() <= var1.size();
      int var2 = var0.f();
      int var3 = var1.size();
      Preconditions.checkArgument(var10000, (new StringBuilder(98)).append("Error: Invalid node map (Graph contains ").append(var2).append(" nodes while nodeMap contains ").append(var3).append(" nodes").toString());
      HashSet var8 = new HashSet();
      HashSet var9 = new HashSet();
      Iterator var4 = var1.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         q var6 = (q)var5.getKey();
         Object var7 = var5.getValue();
         Preconditions.checkArgument(var6 != null && var7 != null, "Error: Invalid node map");
         Preconditions.checkArgument(!var8.contains(var6), "Error: Invalid node map");
         Preconditions.checkArgument(!var9.contains(var7), "Error: Invalid node map");
         var8.add(var6);
         var9.add(var7);
      }

   }
}
