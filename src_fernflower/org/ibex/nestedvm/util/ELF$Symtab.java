package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$Symbol;

public class ELF$Symtab {
   public ELF$Symbol[] symbols;
   private final ELF this$0;

   ELF$Symtab(ELF var1, int var2, int var3, byte[] var4) {
      this.this$0 = var1;
      ELF.access$600(var1).seek(var2);
      int var5 = var3 / 16;
      this.symbols = new ELF$Symbol[var5];

      for(int var6 = 0; var6 < var5; ++var6) {
         this.symbols[var6] = new ELF$Symbol(var1, var4);
      }

   }

   public ELF$Symbol getSymbol(String var1) {
      ELF$Symbol var2 = null;

      for(int var3 = 0; var3 < this.symbols.length; ++var3) {
         if(this.symbols[var3].name.equals(var1)) {
            if(var2 == null) {
               var2 = this.symbols[var3];
            } else {
               System.err.println("WARNING: Multiple symbol matches for " + var1);
            }
         }
      }

      return var2;
   }

   public ELF$Symbol getGlobalSymbol(String var1) {
      for(int var2 = 0; var2 < this.symbols.length; ++var2) {
         if(this.symbols[var2].binding == 1 && this.symbols[var2].name.equals(var1)) {
            return this.symbols[var2];
         }
      }

      return null;
   }
}
