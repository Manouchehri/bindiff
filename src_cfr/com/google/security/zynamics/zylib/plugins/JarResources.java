/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.plugins;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public final class JarResources {
    private final Hashtable htSizes = new Hashtable();
    private final Hashtable htJarContents = new Hashtable();
    private final String jarFileName;
    public boolean debugOn = false;

    public JarResources(String string) {
        this.jarFileName = string;
        this.init();
    }

    private String dumpZipEntry(ZipEntry zipEntry) {
        StringBuffer stringBuffer = new StringBuffer();
        if (zipEntry.isDirectory()) {
            stringBuffer.append("d ");
        } else {
            stringBuffer.append("f ");
        }
        if (zipEntry.getMethod() == 0) {
            stringBuffer.append("stored   ");
        } else {
            stringBuffer.append("defalted ");
        }
        stringBuffer.append(zipEntry.getName());
        stringBuffer.append("\t");
        long l2 = zipEntry.getSize();
        stringBuffer.append(new StringBuilder(20).append(l2).toString());
        if (zipEntry.getMethod() != 8) return stringBuffer.toString();
        l2 = zipEntry.getCompressedSize();
        stringBuffer.append(new StringBuilder(21).append("/").append(l2).toString());
        return stringBuffer.toString();
    }

    private void init() {
        try {
            Object object;
            ZipFile zipFile = new ZipFile(this.jarFileName);
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                object = enumeration.nextElement();
                if (this.debugOn) {
                    System.out.println(this.dumpZipEntry((ZipEntry)object));
                }
                this.htSizes.put(object.getName(), (int)object.getSize());
            }
            zipFile.close();
            object = new FileInputStream(this.jarFileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream)object);
            ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
            ZipEntry zipEntry = null;
            do {
                int n2;
                if ((zipEntry = zipInputStream.getNextEntry()) == null) {
                    zipInputStream.close();
                    return;
                }
                if (zipEntry.isDirectory()) continue;
                if (this.debugOn) {
                    String string = String.valueOf(zipEntry.getName());
                    long l2 = zipEntry.getSize();
                    System.out.println(new StringBuilder(44 + String.valueOf(string).length()).append("ze.getName()=").append(string).append(",").append("getSize()=").append(l2).toString());
                }
                if ((n2 = (int)zipEntry.getSize()) == -1) {
                    n2 = (Integer)this.htSizes.get(zipEntry.getName());
                }
                byte[] arrby = new byte[n2];
                int n3 = 0;
                int n4 = 0;
                while (n2 - n3 > 0 && (n4 = zipInputStream.read(arrby, n3, n2 - n3)) != -1) {
                    n3 += n4;
                }
                this.htJarContents.put(zipEntry.getName(), arrby);
                if (!this.debugOn) continue;
                String string = String.valueOf(zipEntry.getName());
                int n5 = n3;
                int n6 = n2;
                long l3 = zipEntry.getCompressedSize();
                System.out.println(new StringBuilder(60 + String.valueOf(string).length()).append(string).append("  rb=").append(n5).append(",size=").append(n6).append(",csize=").append(l3).toString());
            } while (true);
        }
        catch (NullPointerException var1_2) {
            System.out.println("done.");
            return;
        }
        catch (FileNotFoundException var1_3) {
            var1_3.printStackTrace();
            return;
        }
        catch (IOException var1_4) {
            var1_4.printStackTrace();
        }
    }

    public byte[] getResource(String string) {
        return (byte[])this.htJarContents.get(string);
    }
}

