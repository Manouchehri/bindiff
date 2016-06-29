/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.net.URL;
import java.net.URLConnection;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$ResourceFS;
import org.ibex.nestedvm.util.InodeCache;

class UnixRuntime$ResourceFS$1
extends Runtime$FStat {
    private final URLConnection val$conn;
    private final UnixRuntime$ResourceFS this$0;

    UnixRuntime$ResourceFS$1(UnixRuntime$ResourceFS unixRuntime$ResourceFS, URLConnection uRLConnection) {
        this.this$0 = unixRuntime$ResourceFS;
        this.val$conn = uRLConnection;
    }

    @Override
    public int type() {
        return 32768;
    }

    @Override
    public int nlink() {
        return 1;
    }

    @Override
    public int mode() {
        return 292;
    }

    @Override
    public int size() {
        return this.val$conn.getContentLength();
    }

    @Override
    public int mtime() {
        return (int)(this.val$conn.getDate() / 1000);
    }

    @Override
    public int inode() {
        return this.this$0.inodes.get(this.val$conn.getURL().toString());
    }

    @Override
    public int dev() {
        return this.this$0.devno;
    }
}

