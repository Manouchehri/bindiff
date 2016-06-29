package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IFunction;
import java.util.List;

public interface IFunctionListener {
   void appendedComment(IFunction var1, Object var2);

   void changedDescription(IFunction var1, String var2);

   void changedName(IFunction var1, String var2);

   void changedForwardedFunction(IFunction var1);

   void closed(IFunction var1);

   void deletedComment(IFunction var1, Object var2);

   void editedComment(IFunction var1, Object var2);

   void initializedComment(IFunction var1, List var2);

   void loadedFunction(IFunction var1);
}
