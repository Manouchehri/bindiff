/*
 * Decompiled with CFR 0_115.
 */
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

    ELF$SHeader(ELF eLF) {
        this.this$0 = eLF;
        this.nameidx = ELF.access$300(eLF);
        this.type = ELF.access$300(eLF);
        this.flags = ELF.access$300(eLF);
        this.addr = ELF.access$300(eLF);
        this.offset = ELF.access$300(eLF);
        this.size = ELF.access$300(eLF);
        this.link = ELF.access$300(eLF);
        this.info = ELF.access$300(eLF);
        this.addralign = ELF.access$300(eLF);
        this.entsize = ELF.access$300(eLF);
    }

    public InputStream getInputStream() {
        int n2;
        if (this.type == 8) {
            n2 = 0;
            return new BufferedInputStream(new ELF$SectionInputStream(this.this$0, this.offset, n2));
        }
        n2 = this.offset + this.size;
        return new BufferedInputStream(new ELF$SectionInputStream(this.this$0, this.offset, n2));
    }

    public boolean isText() {
        return this.name.equals(".text");
    }

    public boolean isData() {
        if (this.name.equals(".data")) return true;
        if (this.name.equals(".sdata")) return true;
        if (this.name.equals(".rodata")) return true;
        if (this.name.equals(".ctors")) return true;
        if (this.name.equals(".dtors")) return true;
        return false;
    }

    public boolean isBSS() {
        if (this.name.equals(".bss")) return true;
        if (this.name.equals(".sbss")) return true;
        return false;
    }
}

