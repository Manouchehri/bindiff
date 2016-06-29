package org.ibex.nestedvm.util;

import java.util.*;
import java.io.*;

class Platform$Jdk12 extends Platform$Jdk11
{
    boolean _atomicCreateFile(final File file) {
        return file.createNewFile();
    }
    
    String _timeZoneGetDisplayName(final TimeZone timeZone, final boolean b, final boolean b2, final Locale locale) {
        return timeZone.getDisplayName(b, b2 ? 1 : 0, locale);
    }
    
    void _setFileLength(final RandomAccessFile randomAccessFile, final int n) {
        randomAccessFile.setLength(n);
    }
    
    File[] _listRoots() {
        return File.listRoots();
    }
}
