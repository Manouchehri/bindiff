package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.SwingInvoker;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import y.f.O;
import y.h.dj;

final class LayoutFunctions$1 extends SwingInvoker {
   // $FF: synthetic field
   final dj val$layoutMorpher;
   // $FF: synthetic field
   final AbstractZyGraph val$graph;
   // $FF: synthetic field
   final O val$morpherLayout;

   LayoutFunctions$1(dj var1, AbstractZyGraph var2, O var3) {
      this.val$layoutMorpher = var1;
      this.val$graph = var2;
      this.val$morpherLayout = var3;
   }

   protected void operation() {
      this.val$layoutMorpher.execute(this.val$graph.getView(), this.val$morpherLayout);
   }
}
