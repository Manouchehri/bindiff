package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$2;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$3;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$4;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$5;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;

public class IteratorFunctions {
   public static void iterateInvisible(AbstractZyGraph var0, IEdgeCallback var1) {
      Preconditions.checkNotNull(var1, "Error: Callback argument can\'t be null");
      var0.iterateEdges(new IteratorFunctions$1(var1));
   }

   public static void iterateInvisible(AbstractZyGraph var0, INodeCallback var1) {
      Preconditions.checkNotNull(var1, "Error: Callback argument can\'t be null");
      var0.iterate((INodeCallback)(new IteratorFunctions$2(var1)));
   }

   public static void iterateSelected(AbstractZyGraph var0, INodeCallback var1) {
      Preconditions.checkNotNull(var1, "Error: Callback argument can\'t be null");
      var0.iterate((INodeCallback)(new IteratorFunctions$3(var1)));
   }

   public static void iterateVisible(AbstractZyGraph var0, IEdgeCallback var1) {
      Preconditions.checkNotNull(var1, "Error: Callback argument can\'t be null");
      var0.iterateEdges(new IteratorFunctions$4(var1));
   }

   public static void iterateVisible(AbstractZyGraph var0, INodeCallback var1) {
      Preconditions.checkNotNull(var1, "Error: Callback argument can\'t be null");
      var0.iterate((INodeCallback)(new IteratorFunctions$5(var1)));
   }
}
