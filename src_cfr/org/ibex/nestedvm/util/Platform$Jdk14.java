/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import org.ibex.nestedvm.util.Platform$Jdk13;
import org.ibex.nestedvm.util.Platform$Jdk14FileLock;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

class Platform$Jdk14
extends Platform$Jdk13 {
    Platform$Jdk14() {
    }

    @Override
    InetAddress _inetAddressFromBytes(byte[] arrby) {
        return InetAddress.getByAddress(arrby);
    }

    @Override
    Seekable$Lock _lockFile(Seekable seekable, RandomAccessFile randomAccessFile, long l2, long l3, boolean bl2) {
        FileLock fileLock;
        try {
            fileLock = l2 == 0 && l3 == 0 ? randomAccessFile.getChannel().lock() : randomAccessFile.getChannel().tryLock(l2, l3, bl2);
        }
        catch (OverlappingFileLockException var9_7) {
            return null;
        }
        if (fileLock != null) return new Platform$Jdk14FileLock(seekable, fileLock);
        return null;
    }
}

