package org.ibex.nestedvm.util;

public class ELF$Symbol
{
    public String name;
    public int addr;
    public int size;
    public byte info;
    public byte type;
    public byte binding;
    public byte other;
    public short shndx;
    public ELF$SHeader sheader;
    public static final int STT_FUNC = 2;
    public static final int STB_GLOBAL = 1;
    private final ELF this$0;
    
    ELF$Symbol(final ELF this$0, final byte[] array) {
        this.this$0 = this$0;
        this.name = ELF.access$700(this$0, ELF.access$300(this$0), array);
        this.addr = ELF.access$300(this$0);
        this.size = ELF.access$300(this$0);
        this.info = ELF.access$100(this$0);
        this.type = (byte)(this.info & 0xF);
        this.binding = (byte)(this.info >> 4);
        this.other = ELF.access$100(this$0);
        this.shndx = ELF.access$200(this$0);
    }
}
