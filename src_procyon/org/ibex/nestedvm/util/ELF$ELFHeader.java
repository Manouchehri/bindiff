package org.ibex.nestedvm.util;

public class ELF$ELFHeader
{
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
    
    ELF$ELFHeader(final ELF this$0) {
        this.this$0 = this$0;
        this.type = ELF.access$200(this$0);
        this.machine = ELF.access$200(this$0);
        this.version = ELF.access$300(this$0);
        if (this.version != 1) {
            throw new ELF$ELFException(this$0, "version != 1");
        }
        this.entry = ELF.access$300(this$0);
        this.phoff = ELF.access$300(this$0);
        this.shoff = ELF.access$300(this$0);
        this.flags = ELF.access$300(this$0);
        this.ehsize = ELF.access$200(this$0);
        this.phentsize = ELF.access$200(this$0);
        this.phnum = ELF.access$200(this$0);
        this.shentsize = ELF.access$200(this$0);
        this.shnum = ELF.access$200(this$0);
        this.shstrndx = ELF.access$200(this$0);
    }
}
