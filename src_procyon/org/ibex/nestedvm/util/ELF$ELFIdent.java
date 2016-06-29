package org.ibex.nestedvm.util;

public class ELF$ELFIdent
{
    public byte klass;
    public byte data;
    public byte osabi;
    public byte abiversion;
    private final ELF this$0;
    
    ELF$ELFIdent(final ELF this$0) {
        this.this$0 = this$0;
        if (ELF.access$000(this$0) != 2135247942) {
            throw new ELF$ELFException(this$0, "Bad Magic");
        }
        this.klass = ELF.access$100(this$0);
        if (this.klass != 1) {
            throw new ELF$ELFException(this$0, "org.ibex.nestedvm.util.ELF does not suport 64-bit binaries");
        }
        this.data = ELF.access$100(this$0);
        if (this.data != 1 && this.data != 2) {
            throw new ELF$ELFException(this$0, "Unknown byte order");
        }
        ELF.access$100(this$0);
        this.osabi = ELF.access$100(this$0);
        this.abiversion = ELF.access$100(this$0);
        for (int i = 0; i < 7; ++i) {
            ELF.access$100(this$0);
        }
    }
}
