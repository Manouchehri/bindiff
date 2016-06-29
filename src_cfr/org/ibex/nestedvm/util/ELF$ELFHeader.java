/*
 * Decompiled with CFR 0_115.
 */
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

    ELF$ELFHeader(ELF eLF) {
        this.this$0 = eLF;
        this.type = ELF.access$200(eLF);
        this.machine = ELF.access$200(eLF);
        this.version = ELF.access$300(eLF);
        if (this.version != 1) {
            throw new ELF$ELFException(eLF, "version != 1");
        }
        this.entry = ELF.access$300(eLF);
        this.phoff = ELF.access$300(eLF);
        this.shoff = ELF.access$300(eLF);
        this.flags = ELF.access$300(eLF);
        this.ehsize = ELF.access$200(eLF);
        this.phentsize = ELF.access$200(eLF);
        this.phnum = ELF.access$200(eLF);
        this.shentsize = ELF.access$200(eLF);
        this.shnum = ELF.access$200(eLF);
        this.shstrndx = ELF.access$200(eLF);
    }
}

