/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.IOException;
import java.io.InputStream;
import org.ibex.nestedvm.util.ELF;

class ELF$SectionInputStream
extends InputStream {
    private int pos;
    private int maxpos;
    private final ELF this$0;

    ELF$SectionInputStream(ELF eLF, int n2, int n3) {
        this.this$0 = eLF;
        if (ELF.access$500(eLF)) {
            throw new IOException("Section reader already active");
        }
        ELF.access$502(eLF, true);
        this.pos = n2;
        ELF.access$600(eLF).seek(this.pos);
        this.maxpos = n3;
    }

    private int bytesLeft() {
        return this.maxpos - this.pos;
    }

    @Override
    public int read() {
        byte[] arrby = new byte[1];
        if (this.read(arrby, 0, 1) == -1) {
            return -1;
        }
        int n2 = arrby[0] & 255;
        return n2;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        int n4 = ELF.access$600(this.this$0).read(arrby, n2, Math.min(n3, this.bytesLeft()));
        if (n4 <= 0) return n4;
        this.pos += n4;
        return n4;
    }

    @Override
    public void close() {
        ELF.access$502(this.this$0, false);
    }
}

