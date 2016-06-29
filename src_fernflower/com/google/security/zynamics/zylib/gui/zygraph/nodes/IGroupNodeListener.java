package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.util.List;

public interface IGroupNodeListener {
   void appendedGroupNodeComment(Object var1, Object var2);

   void deletedGroupNodeComment(Object var1, Object var2);

   void editedGroupNodeComment(Object var1, Object var2);

   void initializedGroupNodeComment(Object var1, List var2);
}
