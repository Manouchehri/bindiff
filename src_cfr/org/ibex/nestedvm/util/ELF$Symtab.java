/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.PrintStream;
import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$Symbol;

public class ELF$Symtab {
    public ELF$Symbol[] symbols;
    private final ELF this$0;

    ELF$Symtab(ELF eLF, int n2, int n3, byte[] arrby) {
        this.this$0 = eLF;
        ELF.access$600(eLF).seek(n2);
        int n4 = n3 / 16;
        this.symbols = new ELF$Symbol[n4];
        int n5 = 0;
        while (n5 < n4) {
            this.symbols[n5] = new ELF$Symbol(eLF, arrby);
            ++n5;
        }
    }

    public ELF$Symbol getSymbol(String string) {
        ELF$Symbol eLF$Symbol = null;
        int n2 = 0;
        while (n2 < this.symbols.length) {
            if (this.symbols[n2].name.equals(string)) {
                if (eLF$Symbol == null) {
                    eLF$Symbol = this.symbols[n2];
                } else {
                    System.err.println(new StringBuffer().append("WARNING: Multiple symbol matches for ").append(string).toString());
                }
            }
            ++n2;
        }
        return eLF$Symbol;
    }

    public ELF$Symbol getGlobalSymbol(String string) {
        int n2 = 0;
        while (n2 < this.symbols.length) {
            if (this.symbols[n2].binding == 1 && this.symbols[n2].name.equals(string)) {
                return this.symbols[n2];
            }
            ++n2;
        }
        return null;
    }
}

