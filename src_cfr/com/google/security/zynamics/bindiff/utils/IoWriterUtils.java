/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IoWriterUtils {
    public static void writeByteArrary(OutputStream outputStream, byte[] arrby) {
        outputStream.write(arrby);
    }

    public static void writeIntegerValue(OutputStream outputStream, int n2) {
        outputStream.write(n2 & 255);
        outputStream.write(n2 >>> 8 & 255);
        outputStream.write(n2 >>> 16 & 255);
        outputStream.write(n2 >>> 24);
    }

    public static void writeLongValue(OutputStream outputStream, long l2) {
        outputStream.write((int)(l2 & 255));
        outputStream.write((int)(l2 >>> 8 & 255));
        outputStream.write((int)(l2 >>> 16 & 255));
        outputStream.write((int)(l2 >>> 24 & 255));
        outputStream.write((int)(l2 >>> 32 & 255));
        outputStream.write((int)(l2 >>> 40 & 255));
        outputStream.write((int)(l2 >>> 48 & 255));
        outputStream.write((int)(l2 >>> 56));
    }

    public static void writeNewZipFile(String string, List list) {
        byte[] arrby = new byte[1024];
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(string));
        Iterator iterator = list.iterator();
        do {
            int n2;
            if (!iterator.hasNext()) {
                zipOutputStream.finish();
                zipOutputStream.close();
                return;
            }
            File file = (File)iterator.next();
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            while ((n2 = fileInputStream.read(arrby)) > 0) {
                zipOutputStream.write(arrby, 0, n2);
            }
            zipOutputStream.closeEntry();
            fileInputStream.close();
        } while (true);
    }

    public static void writeShortValue(OutputStream outputStream, int n2) {
        if (n2 > 32767) {
            throw new IOException("Value out of range exception.");
        }
        outputStream.write(n2 & 255);
        outputStream.write(n2 >>> 8);
    }

    public static void writeStringValue(OutputStream outputStream, String string) {
        outputStream.write(string.getBytes());
    }
}

