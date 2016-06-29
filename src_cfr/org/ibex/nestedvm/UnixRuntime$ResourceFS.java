/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$FS;
import org.ibex.nestedvm.UnixRuntime$ResourceFS$1;
import org.ibex.nestedvm.UnixRuntime$ResourceFS$2;
import org.ibex.nestedvm.util.InodeCache;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$InputStream;

public class UnixRuntime$ResourceFS
extends UnixRuntime$FS {
    final InodeCache inodes = new InodeCache(500);

    @Override
    public Runtime$FStat lstat(UnixRuntime unixRuntime, String string) {
        return this.stat(unixRuntime, string);
    }

    @Override
    public void mkdir(UnixRuntime unixRuntime, String string, int n2) {
        throw new Runtime$ErrnoException(30);
    }

    @Override
    public void unlink(UnixRuntime unixRuntime, String string) {
        throw new Runtime$ErrnoException(30);
    }

    Runtime$FStat connFStat(URLConnection uRLConnection) {
        return new UnixRuntime$ResourceFS$1(this, uRLConnection);
    }

    @Override
    public Runtime$FStat stat(UnixRuntime unixRuntime, String string) {
        URL uRL = unixRuntime.getClass().getResource(new StringBuffer().append("/").append(string).toString());
        if (uRL == null) {
            return null;
        }
        try {
            return this.connFStat(uRL.openConnection());
        }
        catch (IOException var4_4) {
            throw new Runtime$ErrnoException(5);
        }
    }

    @Override
    public Runtime$FD open(UnixRuntime unixRuntime, String string, int n2, int n3) {
        if ((n2 & -4) != 0) {
            System.err.println(new StringBuffer().append("WARNING: Unsupported flags passed to ResourceFS.open(\"").append(string).append("\"): ").append(Runtime.toHex(n2 & -4)).toString());
            throw new Runtime$ErrnoException(134);
        }
        if ((n2 & 3) != 0) {
            throw new Runtime$ErrnoException(30);
        }
        URL uRL = unixRuntime.getClass().getResource(new StringBuffer().append("/").append(string).toString());
        if (uRL == null) {
            return null;
        }
        try {
            URLConnection uRLConnection = uRL.openConnection();
            Seekable$InputStream seekable$InputStream = new Seekable$InputStream(uRLConnection.getInputStream());
            return new UnixRuntime$ResourceFS$2(this, seekable$InputStream, n2, uRLConnection);
        }
        catch (FileNotFoundException var6_7) {
            if (var6_7.getMessage() == null) return null;
            if (var6_7.getMessage().indexOf("Permission denied") < 0) return null;
            throw new Runtime$ErrnoException(13);
        }
        catch (IOException var6_8) {
            throw new Runtime$ErrnoException(5);
        }
    }
}

