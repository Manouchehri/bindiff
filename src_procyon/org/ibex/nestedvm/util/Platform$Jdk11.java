package org.ibex.nestedvm.util;

import java.net.*;
import java.text.*;
import java.io.*;
import java.util.*;

class Platform$Jdk11 extends Platform
{
    boolean _atomicCreateFile(final File file) {
        if (file.exists()) {
            return false;
        }
        new FileOutputStream(file).close();
        return true;
    }
    
    Seekable$Lock _lockFile(final Seekable seekable, final RandomAccessFile randomAccessFile, final long n, final long n2, final boolean b) {
        throw new IOException("file locking requires jdk 1.4+");
    }
    
    void _socketHalfClose(final Socket socket, final boolean b) {
        throw new IOException("half closing sockets not supported");
    }
    
    InetAddress _inetAddressFromBytes(final byte[] array) {
        if (array.length != 4) {
            throw new UnknownHostException("only ipv4 addrs supported");
        }
        return InetAddress.getByName("" + (array[0] & 0xFF) + "." + (array[1] & 0xFF) + "." + (array[2] & 0xFF) + "." + (array[3] & 0xFF));
    }
    
    void _socketSetKeepAlive(final Socket socket, final boolean b) {
        if (b) {
            throw new SocketException("keepalive not supported");
        }
    }
    
    String _timeZoneGetDisplayName(final TimeZone timeZone, final boolean b, final boolean b2, final Locale locale) {
        final String[][] zoneStrings = new DateFormatSymbols(locale).getZoneStrings();
        final String id = timeZone.getID();
        for (int i = 0; i < zoneStrings.length; ++i) {
            if (zoneStrings[i][0].equals(id)) {
                return zoneStrings[i][b ? (b2 ? 3 : 4) : (b2 ? 1 : 2)];
            }
        }
        final StringBuffer sb = new StringBuffer("GMT");
        int n = timeZone.getRawOffset() / 1000;
        if (n < 0) {
            sb.append("-");
            n = -n;
        }
        else {
            sb.append("+");
        }
        sb.append(n / 3600);
        final int n2 = n % 3600;
        if (n2 > 0) {
            sb.append(":").append(n2 / 60);
        }
        final int n3 = n2 % 60;
        if (n3 > 0) {
            sb.append(":").append(n3);
        }
        return sb.toString();
    }
    
    void _setFileLength(final RandomAccessFile randomAccessFile, int i) {
        final FileInputStream fileInputStream = new FileInputStream(randomAccessFile.getFD());
        final FileOutputStream fileOutputStream = new FileOutputStream(randomAccessFile.getFD());
        final byte[] array = new byte[1024];
        while (i > 0) {
            final int read = fileInputStream.read(array, 0, Math.min(i, array.length));
            if (read == -1) {
                break;
            }
            fileOutputStream.write(array, 0, read);
            i -= read;
        }
        if (i == 0) {
            return;
        }
        for (int j = 0; j < array.length; ++j) {
            array[j] = 0;
        }
        while (i > 0) {
            fileOutputStream.write(array, 0, Math.min(i, array.length));
            i -= array.length;
        }
    }
    
    RandomAccessFile _truncatedRandomAccessFile(final File file, final String s) {
        new FileOutputStream(file).close();
        return new RandomAccessFile(file, s);
    }
    
    File[] _listRoots() {
        final String[] array = { "java.home", "java.class.path", "java.library.path", "java.io.tmpdir", "java.ext.dirs", "user.home", "user.dir" };
        final Hashtable hashtable = new Hashtable<File, Boolean>();
        for (int i = 0; i < array.length; ++i) {
            String s = Platform.getProperty(array[i]);
            if (s != null) {
                int index;
                do {
                    String substring = s;
                    if ((index = s.indexOf(File.pathSeparatorChar)) != -1) {
                        substring = s.substring(0, index);
                        s = s.substring(index + 1);
                    }
                    hashtable.put(Platform.getRoot(new File(substring)), Boolean.TRUE);
                } while (index != -1);
            }
        }
        final File[] array2 = new File[hashtable.size()];
        int n = 0;
        final Enumeration<File> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            array2[n++] = keys.nextElement();
        }
        return array2;
    }
    
    File _getRoot(File file) {
        if (!file.isAbsolute()) {
            file = new File(file.getAbsolutePath());
        }
        String parent;
        while ((parent = file.getParent()) != null) {
            file = new File(parent);
        }
        if (file.getPath().length() == 0) {
            file = new File("/");
        }
        return file;
    }
}
