package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions;
import com.google.security.zynamics.zylib.gui.zygraph.functions.NodeFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.functions.NodeFunctions$2;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.ArrayList;
import java.util.List;

public class NodeFunctions {
   public static List getInvisibleNodes(AbstractZyGraph var0) {
      ArrayList var1 = new ArrayList();
      IteratorFunctions.iterateInvisible(var0, (INodeCallback)(new NodeFunctions$1(var1)));
      return var1;
   }

   public static List getVisibleNodes(AbstractZyGraph var0) {
      ArrayList var1 = new ArrayList();
      IteratorFunctions.iterateVisible(var0, (INodeCallback)(new NodeFunctions$2(var1)));
      return var1;
   }
}
