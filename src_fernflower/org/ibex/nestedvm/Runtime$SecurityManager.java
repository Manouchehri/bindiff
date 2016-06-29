package org.ibex.nestedvm;

import java.io.File;

public class Runtime$SecurityManager {
   public boolean allowRead(File var1) {
      return true;
   }

   public boolean allowWrite(File var1) {
      return true;
   }

   public boolean allowStat(File var1) {
      return true;
   }

   public boolean allowUnlink(File var1) {
      return true;
   }
}
