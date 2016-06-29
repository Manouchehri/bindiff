package org.jfree.io;

import java.net.*;
import java.util.*;
import java.io.*;

public class IOUtils
{
    private static IOUtils instance;
    
    public static IOUtils getInstance() {
        if (IOUtils.instance == null) {
            IOUtils.instance = new IOUtils();
        }
        return IOUtils.instance;
    }
    
    private boolean isFileStyleProtocol(final URL url) {
        return url.getProtocol().equals("http") || url.getProtocol().equals("https") || url.getProtocol().equals("ftp") || url.getProtocol().equals("file") || url.getProtocol().equals("jar");
    }
    
    private List parseName(final String s) {
        final ArrayList<String> list = new ArrayList<String>();
        final StringTokenizer stringTokenizer = new StringTokenizer(s, "/");
        while (stringTokenizer.hasMoreElements()) {
            final String s2 = (String)stringTokenizer.nextElement();
            if (s2.length() != 0) {
                list.add(s2);
            }
        }
        return list;
    }
    
    private String formatName(final List list, final String s) {
        final StringBuffer sb = new StringBuffer();
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append("/");
            }
        }
        if (s != null) {
            sb.append('?');
            sb.append(s);
        }
        return sb.toString();
    }
    
    private int startsWithUntil(final List list, final List list2) {
        final int min = Math.min(list2.size(), list.size());
        for (int i = 0; i < min; ++i) {
            if (!list.get(i).equals(list2.get(i))) {
                return i;
            }
        }
        return min;
    }
    
    private boolean isSameService(final URL url, final URL url2) {
        return url.getProtocol().equals(url2.getProtocol()) && url.getHost().equals(url2.getHost()) && url.getPort() == url2.getPort();
    }
    
    public String createRelativeURL(final URL url, final URL url2) {
        if (url == null) {
            throw new NullPointerException("content url must not be null.");
        }
        if (url2 == null) {
            throw new NullPointerException("baseURL must not be null.");
        }
        if (!this.isFileStyleProtocol(url) || !this.isSameService(url, url2)) {
            return url.toExternalForm();
        }
        final List name = this.parseName(this.getPath(url));
        final List name2 = this.parseName(this.getPath(url2));
        final String query = this.getQuery(url);
        if (!this.isPath(url2)) {
            name2.remove(name2.size() - 1);
        }
        if (url.equals(url2)) {
            return name.get(name.size() - 1);
        }
        int startsWithUntil = this.startsWithUntil(name, name2);
        if (startsWithUntil == 0) {
            return url.toExternalForm();
        }
        if (startsWithUntil == name.size()) {
            --startsWithUntil;
        }
        final ArrayList<String> list = new ArrayList<String>();
        if (name2.size() >= name.size()) {
            for (int n = name2.size() - startsWithUntil, i = 0; i < n; ++i) {
                list.add("..");
            }
        }
        list.addAll(name.subList(startsWithUntil, name.size()));
        return this.formatName(list, query);
    }
    
    private boolean isPath(final URL url) {
        if (this.getPath(url).endsWith("/")) {
            return true;
        }
        if (url.getProtocol().equals("file")) {
            final File file = new File(this.getPath(url));
            try {
                if (file.isDirectory()) {
                    return true;
                }
            }
            catch (SecurityException ex) {}
        }
        return false;
    }
    
    private String getQuery(final URL url) {
        final String file = url.getFile();
        final int index = file.indexOf(63);
        if (index == -1) {
            return null;
        }
        return file.substring(index + 1);
    }
    
    private String getPath(final URL url) {
        final String file = url.getFile();
        final int index = file.indexOf(63);
        if (index == -1) {
            return file;
        }
        return file.substring(0, index);
    }
    
    public void copyStreams(final InputStream inputStream, final OutputStream outputStream) {
        this.copyStreams(inputStream, outputStream, 4096);
    }
    
    public void copyStreams(final InputStream inputStream, final OutputStream outputStream, final int n) {
        final byte[] array = new byte[n];
        for (int i = inputStream.read(array); i > -1; i = inputStream.read(array)) {
            outputStream.write(array, 0, i);
        }
    }
    
    public void copyWriter(final Reader reader, final Writer writer) {
        this.copyWriter(reader, writer, 4096);
    }
    
    public void copyWriter(final Reader reader, final Writer writer, final int n) {
        final char[] array = new char[n];
        for (int i = reader.read(array); i > -1; i = reader.read(array)) {
            writer.write(array, 0, i);
        }
    }
    
    public String getFileName(final URL url) {
        final String file = url.getFile();
        final int lastIndex = file.lastIndexOf("/");
        if (lastIndex < 0) {
            return file;
        }
        return file.substring(lastIndex);
    }
    
    public String stripFileExtension(final String s) {
        final int lastIndex = s.lastIndexOf(".");
        if (lastIndex < 1) {
            return s;
        }
        return s.substring(0, lastIndex);
    }
    
    public String getFileExtension(final String s) {
        final int lastIndex = s.lastIndexOf(".");
        if (lastIndex < 1) {
            return "";
        }
        return s.substring(lastIndex);
    }
    
    public boolean isSubDirectory(File canonicalFile, File file) {
        canonicalFile = canonicalFile.getCanonicalFile();
        File file2;
        for (file = (file2 = file.getCanonicalFile()); file2 != null; file2 = file2.getParentFile()) {
            if (canonicalFile.equals(file2)) {
                return true;
            }
        }
        return false;
    }
}
