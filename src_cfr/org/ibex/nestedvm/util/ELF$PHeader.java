/*
 * Decompiled with CFR 0_115.
 */
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

    ELF$PHeader(ELF eLF) {
        this.this$0 = eLF;
        this.type = ELF.access$300(eLF);
        this.offset = ELF.access$300(eLF);
        this.vaddr = ELF.access$300(eLF);
        this.paddr = ELF.access$300(eLF);
        this.filesz = ELF.access$300(eLF);
        this.memsz = ELF.access$300(eLF);
        this.flags = ELF.access$300(eLF);
        this.align = ELF.access$300(eLF);
        if (this.filesz <= this.memsz) return;
        throw new ELF$ELFException(eLF, new StringBuffer().append("ELF inconsistency: filesz > memsz (").append(ELF.access$400(this.filesz)).append(" > ").append(ELF.access$400(this.memsz)).append(")").toString());
    }

    public boolean writable() {
        if ((this.flags & 2) == 0) return false;
        return true;
    }

    public InputStream getInputStream() {
        return new BufferedInputStream(new ELF$SectionInputStream(this.this$0, this.offset, this.offset + this.filesz));
    }
}

