package org.ibex.nestedvm.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$ELFException;
import org.ibex.nestedvm.util.ELF$SectionInputStream;

public class ELF$PHeader {
   public int type;
   public int offset;
   public int vaddr;
   public int paddr;
   public int filesz;
   public int memsz;
   public int flags;
   public int align;
   private final ELF this$0;

   ELF$PHeader(ELF var1) {
      this.this$0 = var1;
      this.type = ELF.access$300(var1);
      this.offset = ELF.access$300(var1);
      this.vaddr = ELF.access$300(var1);
      this.paddr = ELF.access$300(var1);
      this.filesz = ELF.access$300(var1);
      this.memsz = ELF.access$300(var1);
      this.flags = ELF.access$300(var1);
      this.align = ELF.access$300(var1);
      if(this.filesz > this.memsz) {
         throw new ELF$ELFException(var1, "ELF inconsistency: filesz > memsz (" + ELF.access$400(this.filesz) + " > " + ELF.access$400(this.memsz) + ")");
      }
   }

   public boolean writable() {
      return (this.flags & 2) != 0;
   }

   public InputStream getInputStream() {
      return new BufferedInputStream(new ELF$SectionInputStream(this.this$0, this.offset, this.offset + this.filesz));
   }
}
