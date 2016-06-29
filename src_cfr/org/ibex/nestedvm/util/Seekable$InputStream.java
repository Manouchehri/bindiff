/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.IOException;
import java.io.InputStream;
import org.ibex.nestedvm.util.Seekable;

public class Seekable$InputStream
extends Seekable {
    private byte[] buffer = new byte[4096];
    private int bytesRead = 0;
    private boolean eof = false;
    private int pos;
    private InputStream is;

    public Seekable$InputStream(InputStream inputStream) {
        this.is = inputStream;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if (this.pos >= this.bytesRead && !this.eof) {
            this.readTo(this.pos + 1);
        }
        if ((n3 = Math.min(n3, this.bytesRead - this.pos)) <= 0) {
            return -1;
        }
        System.arraycopy(this.buffer, this.pos, arrby, n2, n3);
        this.pos += n3;
        return n3;
    }

    private void readTo(int n2) {
        if (n2 >= this.buffer.length) {
            byte[] arrby = new byte[Math.max(this.buffer.length + Math.min(this.buffer.length, 65536), n2)];
            System.arraycopy(this.buffer, 0, arrby, 0, this.bytesRead);
            this.buffer = arrby;
        }
        while (this.bytesRead < n2) {
            int n3 = this.is.read(this.buffer, this.bytesRead, this.buffer.length - this.bytesRead);
            if (n3 == -1) {
                this.eof = true;
                return;
            }
            this.bytesRead += n3;
        }
    }

    @Override
    public int length() {
        while (!this.eof) {
            this.readTo(this.bytesRead + 4096);
        }
        return this.bytesRead;
    }

    @Override
    public int write(byte[] arrby, int n2, int n3) {
        throw new IOException("read-only");
    }

    @Override
    public void seek(int n2) {
        this.pos = n2;
    }

    @Override
    public int pos() {
        return this.pos;
    }

    @Override
    public void close() {
        this.is.close();
    }
}

