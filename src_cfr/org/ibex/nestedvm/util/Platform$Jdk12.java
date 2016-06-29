/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.TimeZone;
import org.ibex.nestedvm.util.Platform$Jdk11;

class Platform$Jdk12
extends Platform$Jdk11 {
    Platform$Jdk12() {
    }

    @Override
    boolean _atomicCreateFile(File file) {
        return file.createNewFile();
    }

    @Override
    String _timeZoneGetDisplayName(TimeZone timeZone, boolean bl2, boolean bl3, Locale locale) {
        int n2;
        if (bl3) {
            n2 = 1;
            return timeZone.getDisplayName(bl2, n2, locale);
        }
        n2 = 0;
        return timeZone.getDisplayName(bl2, n2, locale);
    }

    @Override
    void _setFileLength(RandomAccessFile randomAccessFile, int n2) {
        randomAccessFile.setLength(n2);
    }

    @Override
    File[] _listRoots() {
        return File.listRoots();
    }
}

