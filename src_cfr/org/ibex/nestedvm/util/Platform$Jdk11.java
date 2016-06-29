/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormatSymbols;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

class Platform$Jdk11
extends Platform {
    Platform$Jdk11() {
    }

    @Override
    boolean _atomicCreateFile(File file) {
        if (file.exists()) {
            return false;
        }
        new FileOutputStream(file).close();
        return true;
    }

    @Override
    Seekable$Lock _lockFile(Seekable seekable, RandomAccessFile randomAccessFile, long l2, long l3, boolean bl2) {
        throw new IOException("file locking requires jdk 1.4+");
    }

    @Override
    void _socketHalfClose(Socket socket, boolean bl2) {
        throw new IOException("half closing sockets not supported");
    }

    @Override
    InetAddress _inetAddressFromBytes(byte[] arrby) {
        if (arrby.length == 4) return InetAddress.getByName(new StringBuffer().append("").append(arrby[0] & 255).append(".").append(arrby[1] & 255).append(".").append(arrby[2] & 255).append(".").append(arrby[3] & 255).toString());
        throw new UnknownHostException("only ipv4 addrs supported");
    }

    @Override
    void _socketSetKeepAlive(Socket socket, boolean bl2) {
        if (!bl2) return;
        throw new SocketException("keepalive not supported");
    }

    @Override
    String _timeZoneGetDisplayName(TimeZone timeZone, boolean bl2, boolean bl3, Locale locale) {
        int n2;
        String[][] arrstring;
        int n3;
        block7 : {
            arrstring = new DateFormatSymbols(locale).getZoneStrings();
            String string = timeZone.getID();
            for (n2 = 0; n2 < arrstring.length; ++n2) {
                if (!arrstring[n2][0].equals(string)) continue;
                if (bl2) {
                    if (bl3) {
                        n3 = 3;
                        return arrstring[n2][n3];
                    }
                    break block7;
                }
                if (bl3) {
                    n3 = 1;
                    return arrstring[n2][n3];
                }
                n3 = 2;
                return arrstring[n2][n3];
            }
            StringBuffer stringBuffer = new StringBuffer("GMT");
            int n4 = timeZone.getRawOffset() / 1000;
            if (n4 < 0) {
                stringBuffer.append("-");
                n4 = - n4;
            } else {
                stringBuffer.append("+");
            }
            stringBuffer.append(n4 / 3600);
            if ((n4 %= 3600) > 0) {
                stringBuffer.append(":").append(n4 / 60);
            }
            if ((n4 %= 60) <= 0) return stringBuffer.toString();
            stringBuffer.append(":").append(n4);
            return stringBuffer.toString();
        }
        n3 = 4;
        return arrstring[n2][n3];
    }

    @Override
    void _setFileLength(RandomAccessFile randomAccessFile, int n2) {
        int n3;
        FileInputStream fileInputStream = new FileInputStream(randomAccessFile.getFD());
        FileOutputStream fileOutputStream = new FileOutputStream(randomAccessFile.getFD());
        byte[] arrby = new byte[1024];
        while (n2 > 0 && (n3 = fileInputStream.read(arrby, 0, Math.min(n2, arrby.length))) != -1) {
            fileOutputStream.write(arrby, 0, n3);
            n2 -= n3;
        }
        if (n2 == 0) {
            return;
        }
        n3 = 0;
        do {
            if (n3 >= arrby.length) {
                while (n2 > 0) {
                    fileOutputStream.write(arrby, 0, Math.min(n2, arrby.length));
                    n2 -= arrby.length;
                }
                return;
            }
            arrby[n3] = 0;
            ++n3;
        } while (true);
    }

    RandomAccessFile _truncatedRandomAccessFile(File file, String string) {
        new FileOutputStream(file).close();
        return new RandomAccessFile(file, string);
    }

    @Override
    File[] _listRoots() {
        Object object;
        String[] arrstring = new String[]{"java.home", "java.class.path", "java.library.path", "java.io.tmpdir", "java.ext.dirs", "user.home", "user.dir"};
        Hashtable<File, Boolean> hashtable = new Hashtable<File, Boolean>();
        for (int i2 = 0; i2 < arrstring.length; ++i2) {
            int n2;
            String string = Platform$Jdk11.getProperty(arrstring[i2]);
            if (string == null) continue;
            do {
                object = string;
                n2 = string.indexOf(File.pathSeparatorChar);
                if (n2 != -1) {
                    object = string.substring(0, n2);
                    string = string.substring(n2 + 1);
                }
                File file = Platform$Jdk11.getRoot(new File((String)object));
                hashtable.put(file, Boolean.TRUE);
            } while (n2 != -1);
        }
        File[] arrfile = new File[hashtable.size()];
        int n3 = 0;
        object = hashtable.keys();
        while (object.hasMoreElements()) {
            arrfile[n3++] = (File)object.nextElement();
        }
        return arrfile;
    }

    @Override
    File _getRoot(File file) {
        if (!file.isAbsolute()) {
            file = new File(file.getAbsolutePath());
        }
        do {
            String string;
            if ((string = file.getParent()) == null) {
                if (file.getPath().length() != 0) return file;
                return new File("/");
            }
            file = new File(string);
        } while (true);
    }
}

