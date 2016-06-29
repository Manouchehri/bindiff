package org.ibex.nestedvm.util;

import java.io.*;

class ELF$SectionInputStream extends InputStream
{
    private int pos;
    private int maxpos;
    private final ELF this$0;
    
    ELF$SectionInputStream(final ELF this$0, final int pos, final int maxpos) {
        this.this$0 = this$0;
        if (ELF.access$500(this$0)) {
            throw new IOException("Section reader already active");
        }
        ELF.access$502(this$0, true);
        this.pos = pos;
        ELF.access$600(this$0).seek(this.pos);
        this.maxpos = maxpos;
    }
    
    private int bytesLeft() {
        return this.maxpos - this.pos;
    }
    
    public int read() {
        final byte[] array = { 0 };
        return (this.read(array, 0, 1) == -1) ? -1 : (array[0] & 0xFF);
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        final int read = ELF.access$600(this.this$0).read(array, n, Math.min(n2, this.bytesLeft()));
        if (read > 0) {
            this.pos += read;
        }
        return read;
    }
    
    public void close() {
        ELF.access$502(this.this$0, false);
    }
}
