package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.functions.SelectionFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.ArrayList;

public class SelectionFunctions {
   public static void invertSelection(AbstractZyGraph var0) {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      var0.iterate((INodeCallback)(new SelectionFunctions$1(var2, var1)));
      var0.selectNodes(var1, var2);
   }
}
