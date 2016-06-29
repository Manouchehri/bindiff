package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import java.util.List;

public interface IFunctionNodeListener extends IViewNodeListener {
   void appendedFunctionNodeComment(Object var1, Object var2);

   void deletedFunctionNodeComment(Object var1, Object var2);

   void editedFunctionNodeComment(Object var1, Object var2);

   void initializedFunctionNodeComment(Object var1, List var2);
}
