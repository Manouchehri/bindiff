/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$ELFException;

public class ELF$ELFIdent {
    public byte klass;
    public byte data;
    public byte osabi;
    public byte abiversion;
    private final ELF this$0;

    ELF$ELFIdent(ELF eLF) {
        this.this$0 = eLF;
        if (ELF.access$000(eLF) != 2135247942) {
            throw new ELF$ELFException(eLF, "Bad Magic");
        }
        this.klass = ELF.access$100(eLF);
        if (this.klass != 1) {
            throw new ELF$ELFException(eLF, "org.ibex.nestedvm.util.ELF does not suport 64-bit binaries");
        }
        this.data = ELF.access$100(eLF);
        if (this.data != 1 && this.data != 2) {
            throw new ELF$ELFException(eLF, "Unknown byte order");
        }
        ELF.access$100(eLF);
        this.osabi = ELF.access$100(eLF);
        this.abiversion = ELF.access$100(eLF);
        int n2 = 0;
        while (n2 < 7) {
            ELF.access$100(eLF);
            ++n2;
        }
    }
}

