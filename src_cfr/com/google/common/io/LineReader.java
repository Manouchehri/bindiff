/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.io.LineBuffer;
import com.google.common.io.LineReader$1;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

@Beta
public final class LineReader {
    private final Readable readable;
    private final Reader reader;
    private final char[] buf = new char[4096];
    private final CharBuffer cbuf = CharBuffer.wrap(this.buf);
    private final Queue lines = new LinkedList();
    private final LineBuffer lineBuf;

    public LineReader(Readable readable) {
        this.lineBuf = new LineReader$1(this);
        this.readable = (Readable)Preconditions.checkNotNull(readable);
        this.reader = readable instanceof Reader ? (Reader)readable : null;
    }

    public String readLine() {
        while (this.lines.peek() == null) {
            int n2;
            this.cbuf.clear();
            int n3 = n2 = this.reader != null ? this.reader.read(this.buf, 0, this.buf.length) : this.readable.read(this.cbuf);
            if (n2 == -1) {
                this.lineBuf.finish();
                return (String)this.lines.poll();
            }
            this.lineBuf.add(this.buf, 0, n2);
        }
        return (String)this.lines.poll();
    }

    static /* synthetic */ Queue access$000(LineReader lineReader) {
        return lineReader.lines;
    }
}

