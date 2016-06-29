package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GraphConverters {
   public static Collection convert(AbstractZyGraph var0, Collection var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         IViewNode var4 = (IViewNode)var3.next();
         var2.add(var0.getNode((Object)var4));
      }

      return var2;
   }

   public static List convert(Collection var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         ZyGraphNode var3 = (ZyGraphNode)var2.next();
         IViewNode var4 = var3.getRawNode();
         var1.add(var4);
      }

      return var1;
   }
}
