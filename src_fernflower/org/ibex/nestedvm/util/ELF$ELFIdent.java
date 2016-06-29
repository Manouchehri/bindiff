package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$ELFException;

public class ELF$ELFIdent {
   public byte klass;
   public byte data;
   public byte osabi;
   public byte abiversion;
   private final ELF this$0;

   ELF$ELFIdent(ELF var1) {
      this.this$0 = var1;
      if(ELF.access$000(var1) != 2135247942) {
         throw new ELF$ELFException(var1, "Bad Magic");
      } else {
         this.klass = ELF.access$100(var1);
         if(this.klass != 1) {
            throw new ELF$ELFException(var1, "org.ibex.nestedvm.util.ELF does not suport 64-bit binaries");
         } else {
            this.data = ELF.access$100(var1);
            if(this.data != 1 && this.data != 2) {
               throw new ELF$ELFException(var1, "Unknown byte order");
            } else {
               ELF.access$100(var1);
               this.osabi = ELF.access$100(var1);
               this.abiversion = ELF.access$100(var1);

               for(int var2 = 0; var2 < 7; ++var2) {
                  ELF.access$100(var1);
               }

            }
         }
      }
   }
}
