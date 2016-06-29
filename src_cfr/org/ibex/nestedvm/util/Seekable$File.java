/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.File;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

public class Seekable$File
extends Seekable {
    private final File file;
    private final RandomAccessFile raf;

    public Seekable$File(String string) {
        this(string, false);
    }

    public Seekable$File(String string, boolean bl2) {
        this(new File(string), bl2, false);
    }

    public Seekable$File(File file, boolean bl2, boolean bl3) {
        this.file = file;
        String string = bl2 ? "rw" : "r";
        this.raf = new RandomAccessFile(file, string);
        if (!bl3) return;
        Platform.setFileLength(this.raf, 0);
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        return this.raf.read(arrby, n2, n3);
    }

    @Override
    public int write(byte[] arrby, int n2, int n3) {
        this.raf.write(arrby, n2, n3);
        return n3;
    }

    @Override
    public void sync() {
        this.raf.getFD().sync();
    }

    @Override
    public void seek(int n2) {
        this.raf.seek(n2);
    }

    @Override
    public int pos() {
        return (int)this.raf.getFilePointer();
    }

    @Override
    public int length() {
        return (int)this.raf.length();
    }

    @Override
    public void close() {
        this.raf.close();
    }

    @Override
    public void resize(long l2) {
        Platform.setFileLength(this.raf, (int)l2);
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof Seekable$File)) return false;
        if (!this.file.equals(((Seekable$File)object).file)) return false;
        return true;
    }

    @Override
    public Seekable$Lock lock(long l2, long l3, boolean bl2) {
        return Platform.lockFile(this, this.raf, l2, l3, bl2);
    }
}

