package org.ibex.nestedvm;

import org.ibex.nestedvm.util.*;
import java.io.*;

public class UnixRuntime$HostFS extends UnixRuntime$FS
{
    InodeCache inodes;
    protected File root;
    
    public File getRoot() {
        return this.root;
    }
    
    protected File hostFile(String s) {
        final char separatorChar = File.separatorChar;
        if (separatorChar != '/') {
            final char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; ++i) {
                final char c = charArray[i];
                if (c == '/') {
                    charArray[i] = separatorChar;
                }
                else if (c == separatorChar) {
                    charArray[i] = '/';
                }
            }
            s = new String(charArray);
        }
        return new File(this.root, s);
    }
    
    public UnixRuntime$HostFS(final String s) {
        this(new File(s));
    }
    
    public UnixRuntime$HostFS(final File root) {
        this.inodes = new InodeCache(4000);
        this.root = root;
    }
    
    public Runtime$FD open(final UnixRuntime unixRuntime, final String s, final int n, final int n2) {
        return unixRuntime.hostFSOpen(this.hostFile(s), n, n2, this);
    }
    
    public void unlink(final UnixRuntime unixRuntime, final String s) {
        final File hostFile = this.hostFile(s);
        if (unixRuntime.sm != null && !unixRuntime.sm.allowUnlink(hostFile)) {
            throw new Runtime$ErrnoException(1);
        }
        if (!hostFile.exists()) {
            throw new Runtime$ErrnoException(2);
        }
        if (!hostFile.delete()) {
            boolean b = false;
            for (int i = 0; i < 64; ++i) {
                if (unixRuntime.fds[i] != null) {
                    final String normalizedPath = unixRuntime.fds[i].getNormalizedPath();
                    if (normalizedPath != null && normalizedPath.equals(s)) {
                        unixRuntime.fds[i].markDeleteOnClose();
                        b = true;
                    }
                }
            }
            if (!b) {
                throw new Runtime$ErrnoException(1);
            }
        }
    }
    
    public Runtime$FStat stat(final UnixRuntime unixRuntime, final String s) {
        final File hostFile = this.hostFile(s);
        if (unixRuntime.sm != null && !unixRuntime.sm.allowStat(hostFile)) {
            throw new Runtime$ErrnoException(13);
        }
        if (!hostFile.exists()) {
            return null;
        }
        return unixRuntime.hostFStat(hostFile, this);
    }
    
    public void mkdir(final UnixRuntime unixRuntime, final String s, final int n) {
        final File hostFile = this.hostFile(s);
        if (unixRuntime.sm != null && !unixRuntime.sm.allowWrite(hostFile)) {
            throw new Runtime$ErrnoException(13);
        }
        if (hostFile.exists() && hostFile.isDirectory()) {
            throw new Runtime$ErrnoException(17);
        }
        if (hostFile.exists()) {
            throw new Runtime$ErrnoException(20);
        }
        final File parentFile = getParentFile(hostFile);
        if (parentFile != null && (!parentFile.exists() || !parentFile.isDirectory())) {
            throw new Runtime$ErrnoException(20);
        }
        if (!hostFile.mkdir()) {
            throw new Runtime$ErrnoException(5);
        }
    }
    
    private static File getParentFile(final File file) {
        final String parent = file.getParent();
        return (parent == null) ? null : new File(parent);
    }
    
    static File access$400(final File file) {
        return getParentFile(file);
    }
}
