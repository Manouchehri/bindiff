/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.io;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class IOUtils {
    private static IOUtils instance;

    private IOUtils() {
    }

    public static IOUtils getInstance() {
        if (instance != null) return instance;
        instance = new IOUtils();
        return instance;
    }

    private boolean isFileStyleProtocol(URL uRL) {
        if (uRL.getProtocol().equals("http")) {
            return true;
        }
        if (uRL.getProtocol().equals("https")) {
            return true;
        }
        if (uRL.getProtocol().equals("ftp")) {
            return true;
        }
        if (uRL.getProtocol().equals("file")) {
            return true;
        }
        if (!uRL.getProtocol().equals("jar")) return false;
        return true;
    }

    private List parseName(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(string, "/");
        while (stringTokenizer.hasMoreElements()) {
            String string2 = (String)stringTokenizer.nextElement();
            if (string2.length() == 0) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    private String formatName(List list, String string) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                if (string == null) return stringBuffer.toString();
                stringBuffer.append('?');
                stringBuffer.append(string);
                return stringBuffer.toString();
            }
            stringBuffer.append(iterator.next());
            if (!iterator.hasNext()) continue;
            stringBuffer.append("/");
        } while (true);
    }

    private int startsWithUntil(List list, List list2) {
        int n2 = Math.min(list2.size(), list.size());
        int n3 = 0;
        while (n3 < n2) {
            String string;
            String string2 = (String)list.get(n3);
            if (!string2.equals(string = (String)list2.get(n3))) {
                return n3;
            }
            ++n3;
        }
        return n2;
    }

    private boolean isSameService(URL uRL, URL uRL2) {
        if (!uRL.getProtocol().equals(uRL2.getProtocol())) {
            return false;
        }
        if (!uRL.getHost().equals(uRL2.getHost())) {
            return false;
        }
        if (uRL.getPort() == uRL2.getPort()) return true;
        return false;
    }

    public String createRelativeURL(URL uRL, URL uRL2) {
        if (uRL == null) {
            throw new NullPointerException("content url must not be null.");
        }
        if (uRL2 == null) {
            throw new NullPointerException("baseURL must not be null.");
        }
        if (!this.isFileStyleProtocol(uRL)) return uRL.toExternalForm();
        if (!this.isSameService(uRL, uRL2)) return uRL.toExternalForm();
        List list = this.parseName(this.getPath(uRL));
        List list2 = this.parseName(this.getPath(uRL2));
        String string = this.getQuery(uRL);
        if (!this.isPath(uRL2)) {
            list2.remove(list2.size() - 1);
        }
        if (uRL.equals(uRL2)) {
            return (String)list.get(list.size() - 1);
        }
        int n2 = this.startsWithUntil(list, list2);
        if (n2 == 0) {
            return uRL.toExternalForm();
        }
        if (n2 == list.size()) {
            --n2;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        if (list2.size() >= list.size()) {
            int n3 = list2.size() - n2;
            for (int i2 = 0; i2 < n3; ++i2) {
                arrayList.add("..");
            }
        }
        arrayList.addAll(list.subList(n2, list.size()));
        return this.formatName(arrayList, string);
    }

    private boolean isPath(URL uRL) {
        if (this.getPath(uRL).endsWith("/")) {
            return true;
        }
        if (!uRL.getProtocol().equals("file")) return false;
        File file = new File(this.getPath(uRL));
        try {
            if (!file.isDirectory()) return false;
            return true;
        }
        catch (SecurityException var3_3) {
            // empty catch block
        }
        return false;
    }

    private String getQuery(URL uRL) {
        String string = uRL.getFile();
        int n2 = string.indexOf(63);
        if (n2 != -1) return string.substring(n2 + 1);
        return null;
    }

    private String getPath(URL uRL) {
        String string = uRL.getFile();
        int n2 = string.indexOf(63);
        if (n2 != -1) return string.substring(0, n2);
        return string;
    }

    public void copyStreams(InputStream inputStream, OutputStream outputStream) {
        this.copyStreams(inputStream, outputStream, 4096);
    }

    public void copyStreams(InputStream inputStream, OutputStream outputStream, int n2) {
        byte[] arrby = new byte[n2];
        int n3 = inputStream.read(arrby);
        while (n3 > -1) {
            outputStream.write(arrby, 0, n3);
            n3 = inputStream.read(arrby);
        }
    }

    public void copyWriter(Reader reader, Writer writer) {
        this.copyWriter(reader, writer, 4096);
    }

    public void copyWriter(Reader reader, Writer writer, int n2) {
        char[] arrc = new char[n2];
        int n3 = reader.read(arrc);
        while (n3 > -1) {
            writer.write(arrc, 0, n3);
            n3 = reader.read(arrc);
        }
    }

    public String getFileName(URL uRL) {
        String string = uRL.getFile();
        int n2 = string.lastIndexOf("/");
        if (n2 >= 0) return string.substring(n2);
        return string;
    }

    public String stripFileExtension(String string) {
        int n2 = string.lastIndexOf(".");
        if (n2 >= 1) return string.substring(0, n2);
        return string;
    }

    public String getFileExtension(String string) {
        int n2 = string.lastIndexOf(".");
        if (n2 >= 1) return string.substring(n2);
        return "";
    }

    public boolean isSubDirectory(File file, File file2) {
        file = file.getCanonicalFile();
        File file3 = file2 = file2.getCanonicalFile();
        while (file3 != null) {
            if (file.equals(file3)) {
                return true;
            }
            file3 = file3.getParentFile();
        }
        return false;
    }
}

