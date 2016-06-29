package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$ELFException;

public class ELF$ELFHeader {
   public short type;
   public short machine;
   public int version;
   public int entry;
   public int phoff;
   public int shoff;
   public int flags;
   public short ehsize;
   public short phentsize;
   public short phnum;
   public short shentsize;
   public short shnum;
   public short shstrndx;
   private final ELF this$0;

   ELF$ELFHeader(ELF var1) {
      this.this$0 = var1;
      this.type = ELF.access$200(var1);
      this.machine = ELF.access$200(var1);
      this.version = ELF.access$300(var1);
      if(this.version != 1) {
         throw new ELF$ELFException(var1, "version != 1");
      } else {
         this.entry = ELF.access$300(var1);
         this.phoff = ELF.access$300(var1);
         this.shoff = ELF.access$300(var1);
         this.flags = ELF.access$300(var1);
         this.ehsize = ELF.access$200(var1);
         this.phentsize = ELF.access$200(var1);
         this.phnum = ELF.access$200(var1);
         this.shentsize = ELF.access$200(var1);
         this.shnum = ELF.access$200(var1);
         this.shstrndx = ELF.access$200(var1);
      }
   }
}
