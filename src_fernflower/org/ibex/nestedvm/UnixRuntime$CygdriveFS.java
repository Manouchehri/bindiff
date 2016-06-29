package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.UnixRuntime$HostFS;

public class UnixRuntime$CygdriveFS extends UnixRuntime$HostFS {
   protected File hostFile(String var1) {
      char var2 = var1.charAt(0);
      if(var2 >= 97 && var2 <= 122 && var1.charAt(1) == 47) {
         var1 = var2 + ":" + var1.substring(1).replace('/', '\\');
         return new File(var1);
      } else {
         return null;
      }
   }

   public UnixRuntime$CygdriveFS() {
      super("/");
   }
}
