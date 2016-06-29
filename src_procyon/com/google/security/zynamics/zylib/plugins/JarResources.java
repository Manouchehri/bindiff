package com.google.security.zynamics.zylib.plugins;

import java.util.zip.*;
import java.util.*;
import java.io.*;

public final class JarResources
{
    private final Hashtable htSizes;
    private final Hashtable htJarContents;
    private final String jarFileName;
    public boolean debugOn;
    
    public JarResources(final String jarFileName) {
        this.htSizes = new Hashtable();
        this.htJarContents = new Hashtable();
        this.debugOn = false;
        this.jarFileName = jarFileName;
        this.init();
    }
    
    private String dumpZipEntry(final ZipEntry zipEntry) {
        final StringBuffer sb = new StringBuffer();
        if (zipEntry.isDirectory()) {
            sb.append("d ");
        }
        else {
            sb.append("f ");
        }
        if (zipEntry.getMethod() == 0) {
            sb.append("stored   ");
        }
        else {
            sb.append("defalted ");
        }
        sb.append(zipEntry.getName());
        sb.append("\t");
        sb.append(new StringBuilder(20).append(zipEntry.getSize()).toString());
        if (zipEntry.getMethod() == 8) {
            sb.append(new StringBuilder(21).append("/").append(zipEntry.getCompressedSize()).toString());
        }
        return sb.toString();
    }
    
    private void init() {
        try {
            final ZipFile zipFile = new ZipFile(this.jarFileName);
            final Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                final ZipEntry zipEntry = (ZipEntry)entries.nextElement();
                if (this.debugOn) {
                    System.out.println(this.dumpZipEntry(zipEntry));
                }
                this.htSizes.put(zipEntry.getName(), (int)zipEntry.getSize());
            }
            zipFile.close();
            final ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(this.jarFileName)));
            ZipEntry nextEntry;
            while ((nextEntry = zipInputStream.getNextEntry()) != null) {
                if (nextEntry.isDirectory()) {
                    continue;
                }
                if (this.debugOn) {
                    final PrintStream out = System.out;
                    final String value = String.valueOf(nextEntry.getName());
                    out.println(new StringBuilder(44 + String.valueOf(value).length()).append("ze.getName()=").append(value).append(",").append("getSize()=").append(nextEntry.getSize()).toString());
                }
                int intValue = (int)nextEntry.getSize();
                if (intValue == -1) {
                    intValue = this.htSizes.get(nextEntry.getName());
                }
                final byte[] array = new byte[intValue];
                int n;
                int read;
                for (n = 0; intValue - n > 0; n += read) {
                    read = zipInputStream.read(array, n, intValue - n);
                    if (read == -1) {
                        break;
                    }
                }
                this.htJarContents.put(nextEntry.getName(), array);
                if (!this.debugOn) {
                    continue;
                }
                final PrintStream out2 = System.out;
                final String value2 = String.valueOf(nextEntry.getName());
                out2.println(new StringBuilder(60 + String.valueOf(value2).length()).append(value2).append("  rb=").append(n).append(",size=").append(intValue).append(",csize=").append(nextEntry.getCompressedSize()).toString());
            }
            zipInputStream.close();
        }
        catch (NullPointerException ex3) {
            System.out.println("done.");
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex2) {
            ex2.printStackTrace();
        }
    }
    
    public byte[] getResource(final String s) {
        return this.htJarContents.get(s);
    }
}
