package org.jfree.base.modules;

import org.jfree.util.StackableException;

public class ModuleInitializeException extends StackableException {
   public ModuleInitializeException() {
   }

   public ModuleInitializeException(String var1, Exception var2) {
      super(var1, var2);
   }

   public ModuleInitializeException(String var1) {
      super(var1);
   }
}
