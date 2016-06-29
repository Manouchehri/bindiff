package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import java.util.Collection;

public interface ISelectableGraph {
   void iterateSelected(INodeCallback var1);

   void selectNodes(Collection var1, boolean var2);

   void selectNodes(Collection var1, Collection var2);
}
