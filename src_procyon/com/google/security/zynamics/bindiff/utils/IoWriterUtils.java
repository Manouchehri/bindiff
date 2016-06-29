package com.google.security.zynamics.bindiff.utils;

import java.util.zip.*;
import java.util.*;
import java.io.*;

public class IoWriterUtils
{
    public static void writeByteArrary(final OutputStream outputStream, final byte[] array) {
        outputStream.write(array);
    }
    
    public static void writeIntegerValue(final OutputStream outputStream, final int n) {
        outputStream.write(n & 0xFF);
        outputStream.write(n >>> 8 & 0xFF);
        outputStream.write(n >>> 16 & 0xFF);
        outputStream.write(n >>> 24);
    }
    
    public static void writeLongValue(final OutputStream outputStream, final long n) {
        outputStream.write((int)(n & 0xFFL));
        outputStream.write((int)(n >>> 8 & 0xFFL));
        outputStream.write((int)(n >>> 16 & 0xFFL));
        outputStream.write((int)(n >>> 24 & 0xFFL));
        outputStream.write((int)(n >>> 32 & 0xFFL));
        outputStream.write((int)(n >>> 40 & 0xFFL));
        outputStream.write((int)(n >>> 48 & 0xFFL));
        outputStream.write((int)(n >>> 56));
    }
    
    public static void writeNewZipFile(final String s, final List list) {
        final byte[] array = new byte[1024];
        final ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(s));
        for (final File file : list) {
            final FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            int read;
            while ((read = fileInputStream.read(array)) > 0) {
                zipOutputStream.write(array, 0, read);
            }
            zipOutputStream.closeEntry();
            fileInputStream.close();
        }
        zipOutputStream.finish();
        zipOutputStream.close();
    }
    
    public static void writeShortValue(final OutputStream outputStream, final int n) {
        if (n > 32767) {
            throw new IOException("Value out of range exception.");
        }
        outputStream.write(n & 0xFF);
        outputStream.write(n >>> 8);
    }
    
    public static void writeStringValue(final OutputStream outputStream, final String s) {
        outputStream.write(s.getBytes());
    }
}
