package org.ibex.nestedvm.util;

import java.net.*;
import java.io.*;
import java.nio.channels.*;

class Platform$Jdk14 extends Platform$Jdk13
{
    InetAddress _inetAddressFromBytes(final byte[] array) {
        return InetAddress.getByAddress(array);
    }
    
    Seekable$Lock _lockFile(final Seekable seekable, final RandomAccessFile randomAccessFile, final long n, final long n2, final boolean b) {
        FileLock fileLock;
        try {
            fileLock = ((n == 0L && n2 == 0L) ? randomAccessFile.getChannel().lock() : randomAccessFile.getChannel().tryLock(n, n2, b));
        }
        catch (OverlappingFileLockException ex) {
            fileLock = null;
        }
        if (fileLock == null) {
            return null;
        }
        return new Platform$Jdk14FileLock(seekable, fileLock);
    }
}
