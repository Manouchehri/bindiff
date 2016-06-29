package org.ibex.nestedvm.util;

import java.io.*;

public class ELF$PHeader
{
    public int type;
    public int offset;
    public int vaddr;
    public int paddr;
    public int filesz;
    public int memsz;
    public int flags;
    public int align;
    private final ELF this$0;
    
    ELF$PHeader(final ELF this$0) {
        this.this$0 = this$0;
        this.type = ELF.access$300(this$0);
        this.offset = ELF.access$300(this$0);
        this.vaddr = ELF.access$300(this$0);
        this.paddr = ELF.access$300(this$0);
        this.filesz = ELF.access$300(this$0);
        this.memsz = ELF.access$300(this$0);
        this.flags = ELF.access$300(this$0);
        this.align = ELF.access$300(this$0);
        if (this.filesz > this.memsz) {
            throw new ELF$ELFException(this$0, "ELF inconsistency: filesz > memsz (" + ELF.access$400(this.filesz) + " > " + ELF.access$400(this.memsz) + ")");
        }
    }
    
    public boolean writable() {
        return (this.flags & 0x2) != 0x0;
    }
    
    public InputStream getInputStream() {
        return new BufferedInputStream(new ELF$SectionInputStream(this.this$0, this.offset, this.offset + this.filesz));
    }
}
