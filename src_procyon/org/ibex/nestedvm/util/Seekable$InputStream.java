package org.ibex.nestedvm.util;

import java.io.*;

public class Seekable$InputStream extends Seekable
{
    private byte[] buffer;
    private int bytesRead;
    private boolean eof;
    private int pos;
    private InputStream is;
    
    public Seekable$InputStream(final InputStream is) {
        this.buffer = new byte[4096];
        this.bytesRead = 0;
        this.eof = false;
        this.is = is;
    }
    
    public int read(final byte[] array, final int n, int min) {
        if (this.pos >= this.bytesRead && !this.eof) {
            this.readTo(this.pos + 1);
        }
        min = Math.min(min, this.bytesRead - this.pos);
        if (min <= 0) {
            return -1;
        }
        System.arraycopy(this.buffer, this.pos, array, n, min);
        this.pos += min;
        return min;
    }
    
    private void readTo(final int n) {
        if (n >= this.buffer.length) {
            final byte[] buffer = new byte[Math.max(this.buffer.length + Math.min(this.buffer.length, 65536), n)];
            System.arraycopy(this.buffer, 0, buffer, 0, this.bytesRead);
            this.buffer = buffer;
        }
        while (this.bytesRead < n) {
            final int read = this.is.read(this.buffer, this.bytesRead, this.buffer.length - this.bytesRead);
            if (read == -1) {
                this.eof = true;
                break;
            }
            this.bytesRead += read;
        }
    }
    
    public int length() {
        while (!this.eof) {
            this.readTo(this.bytesRead + 4096);
        }
        return this.bytesRead;
    }
    
    public int write(final byte[] array, final int n, final int n2) {
        throw new IOException("read-only");
    }
    
    public void seek(final int pos) {
        this.pos = pos;
    }
    
    public int pos() {
        return this.pos;
    }
    
    public void close() {
        this.is.close();
    }
}
