package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.util.List;

public interface ICodeNodeListener {
   void appendedGlobalCodeNodeComment(Object var1, Object var2);

   void appendedLocalCodeNodeComment(Object var1, Object var2);

   void appendedLocalInstructionComment(Object var1, Object var2, Object var3);

   void deletedGlobalCodeNodeComment(Object var1, Object var2);

   void deletedLocalCodeNodeComment(Object var1, Object var2);

   void deletedLocalInstructionComment(Object var1, Object var2, Object var3);

   void editedGlobalCodeNodeComment(Object var1, Object var2);

   void editedLocalCodeNodeComment(Object var1, Object var2);

   void editedLocalInstructionComment(Object var1, Object var2, Object var3);

   void initializedGlobalCodeNodeComment(Object var1, List var2);

   void initializedLocalCodeNodeComment(Object var1, List var2);

   void initializedLocalInstructionComment(Object var1, Object var2, List var3);
}
