package org.ibex.nestedvm.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$SectionInputStream;

public class ELF$SHeader {
   int nameidx;
   public String name;
   public int type;
   public int flags;
   public int addr;
   public int offset;
   public int size;
   public int link;
   public int info;
   public int addralign;
   public int entsize;
   private final ELF this$0;

   ELF$SHeader(ELF var1) {
      this.this$0 = var1;
      this.nameidx = ELF.access$300(var1);
      this.type = ELF.access$300(var1);
      this.flags = ELF.access$300(var1);
      this.addr = ELF.access$300(var1);
      this.offset = ELF.access$300(var1);
      this.size = ELF.access$300(var1);
      this.link = ELF.access$300(var1);
      this.info = ELF.access$300(var1);
      this.addralign = ELF.access$300(var1);
      this.entsize = ELF.access$300(var1);
   }

   public InputStream getInputStream() {
      return new BufferedInputStream(new ELF$SectionInputStream(this.this$0, this.offset, this.type == 8?0:this.offset + this.size));
   }

   public boolean isText() {
      return this.name.equals(".text");
   }

   public boolean isData() {
      return this.name.equals(".data") || this.name.equals(".sdata") || this.name.equals(".rodata") || this.name.equals(".ctors") || this.name.equals(".dtors");
   }

   public boolean isBSS() {
      return this.name.equals(".bss") || this.name.equals(".sbss");
   }
}
