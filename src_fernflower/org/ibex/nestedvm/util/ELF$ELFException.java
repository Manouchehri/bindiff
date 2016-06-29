package org.ibex.nestedvm.util;

import java.io.IOException;
import org.ibex.nestedvm.util.ELF;

public class ELF$ELFException extends IOException {
   private final ELF this$0;

   ELF$ELFException(ELF var1, String var2) {
      super(var2);
      this.this$0 = var1;
   }
}
