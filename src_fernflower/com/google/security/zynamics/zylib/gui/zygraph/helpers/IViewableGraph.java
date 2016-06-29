package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;

public interface IViewableGraph {
   void iterateInvisible(INodeCallback var1);

   void iterateVisible(INodeCallback var1);
}
