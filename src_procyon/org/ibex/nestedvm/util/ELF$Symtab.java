package org.ibex.nestedvm.util;

public class ELF$Symtab
{
    public ELF$Symbol[] symbols;
    private final ELF this$0;
    
    ELF$Symtab(final ELF this$0, final int n, final int n2, final byte[] array) {
        this.this$0 = this$0;
        ELF.access$600(this$0).seek(n);
        final int n3 = n2 / 16;
        this.symbols = new ELF$Symbol[n3];
        for (int i = 0; i < n3; ++i) {
            this.symbols[i] = new ELF$Symbol(this$0, array);
        }
    }
    
    public ELF$Symbol getSymbol(final String s) {
        ELF$Symbol elf$Symbol = null;
        for (int i = 0; i < this.symbols.length; ++i) {
            if (this.symbols[i].name.equals(s)) {
                if (elf$Symbol == null) {
                    elf$Symbol = this.symbols[i];
                }
                else {
                    System.err.println("WARNING: Multiple symbol matches for " + s);
                }
            }
        }
        return elf$Symbol;
    }
    
    public ELF$Symbol getGlobalSymbol(final String s) {
        for (int i = 0; i < this.symbols.length; ++i) {
            if (this.symbols[i].binding == 1 && this.symbols[i].name.equals(s)) {
                return this.symbols[i];
            }
        }
        return null;
    }
}
