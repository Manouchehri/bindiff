/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$SHeader;

public class ELF$Symbol {
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

    ELF$Symbol(ELF eLF, byte[] arrby) {
        this.this$0 = eLF;
        this.name = ELF.access$700(eLF, ELF.access$300(eLF), arrby);
        this.addr = ELF.access$300(eLF);
        this.size = ELF.access$300(eLF);
        this.info = ELF.access$100(eLF);
        this.type = (byte)(this.info & 15);
        this.binding = (byte)(this.info >> 4);
        this.other = ELF.access$100(eLF);
        this.shndx = ELF.access$200(eLF);
    }
}

