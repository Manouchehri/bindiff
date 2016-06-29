package org.ibex.nestedvm;

import java.net.*;
import org.ibex.nestedvm.util.*;
import java.io.*;

public class UnixRuntime$ResourceFS extends UnixRuntime$FS
{
    final InodeCache inodes;
    
    public UnixRuntime$ResourceFS() {
        this.inodes = new InodeCache(500);
    }
    
    public Runtime$FStat lstat(final UnixRuntime unixRuntime, final String s) {
        return this.stat(unixRuntime, s);
    }
    
    public void mkdir(final UnixRuntime unixRuntime, final String s, final int n) {
        throw new Runtime$ErrnoException(30);
    }
    
    public void unlink(final UnixRuntime unixRuntime, final String s) {
        throw new Runtime$ErrnoException(30);
    }
    
    Runtime$FStat connFStat(final URLConnection urlConnection) {
        return new UnixRuntime$ResourceFS$1(this, urlConnection);
    }
    
    public Runtime$FStat stat(final UnixRuntime unixRuntime, final String s) {
        final URL resource = unixRuntime.getClass().getResource("/" + s);
        if (resource == null) {
            return null;
        }
        try {
            return this.connFStat(resource.openConnection());
        }
        catch (IOException ex) {
            throw new Runtime$ErrnoException(5);
        }
    }
    
    public Runtime$FD open(final UnixRuntime unixRuntime, final String s, final int n, final int n2) {
        if ((n & 0xFFFFFFFC) != 0x0) {
            System.err.println("WARNING: Unsupported flags passed to ResourceFS.open(\"" + s + "\"): " + Runtime.toHex(n & 0xFFFFFFFC));
            throw new Runtime$ErrnoException(134);
        }
        if ((n & 0x3) != 0x0) {
            throw new Runtime$ErrnoException(30);
        }
        final URL resource = unixRuntime.getClass().getResource("/" + s);
        if (resource == null) {
            return null;
        }
        try {
            final URLConnection openConnection = resource.openConnection();
            return new UnixRuntime$ResourceFS$2(this, new Seekable$InputStream(openConnection.getInputStream()), n, openConnection);
        }
        catch (FileNotFoundException ex) {
            if (ex.getMessage() != null && ex.getMessage().indexOf("Permission denied") >= 0) {
                throw new Runtime$ErrnoException(13);
            }
            return null;
        }
        catch (IOException ex2) {
            throw new Runtime$ErrnoException(5);
        }
    }
}
