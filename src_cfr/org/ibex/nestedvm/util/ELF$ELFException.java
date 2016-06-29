/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.IOException;
import org.ibex.nestedvm.util.ELF;

public class ELF$ELFException
extends IOException {
    private final ELF this$0;

    ELF$ELFException(ELF eLF, String string) {
        super(string);
        this.this$0 = eLF;
    }
}

