/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.io.ZipFiles$1;
import com.google.common.io.ZipFiles$ZipEntryByteSource;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

@GoogleInternal
public final class ZipFiles {
    private ZipFiles() {
    }

    public static ByteSource asByteSource(ZipFile zipFile, ZipEntry zipEntry) {
        return new ZipFiles$ZipEntryByteSource(zipFile, zipEntry);
    }

    public static CharSource asCharSource(ZipFile zipFile, ZipEntry zipEntry, Charset charset) {
        return ZipFiles.asByteSource(zipFile, zipEntry).asCharSource(charset);
    }

    public static FluentIterable entries(ZipFile zipFile) {
        Preconditions.checkNotNull(zipFile);
        return new ZipFiles$1(zipFile);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void unzipFile(File file, File file2) {
        String string;
        block8 : {
            Preconditions.checkNotNull(file);
            Preconditions.checkNotNull(file2);
            Preconditions.checkArgument(file2.isDirectory(), "%s is not a valid directory", file2.getAbsolutePath());
            ZipFile zipFile = new ZipFile(file);
            Iterator iterator = ZipFiles.entries(zipFile).iterator();
            while (iterator.hasNext()) {
                ZipEntry zipEntry = (ZipEntry)iterator.next();
                ZipFiles.checkName(zipEntry.getName());
                File file3 = new File(file2, zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    if (file3.isDirectory() || file3.mkdirs()) continue;
                    String string2 = String.valueOf(file3.getAbsolutePath());
                    if (string2.length() != 0) {
                        string = "Failed to create directory: ".concat(string2);
                        throw new IOException(string);
                    }
                    break block8;
                }
                File file4 = file3.getParentFile();
                if (!file4.isDirectory() && !file4.mkdirs()) {
                    String string3;
                    String string4 = String.valueOf(file4.getAbsolutePath());
                    if (string4.length() != 0) {
                        string3 = "Failed to create directory: ".concat(string4);
                        throw new IOException(string3);
                    }
                    string3 = new String("Failed to create directory: ");
                    throw new IOException(string3);
                }
                ZipFiles.asByteSource(zipFile, zipEntry).copyTo(Files.asByteSink(file3, new FileWriteMode[0]));
            }
            return;
            finally {
                zipFile.close();
            }
        }
        string = new String("Failed to create directory: ");
        throw new IOException(string);
    }

    private static void checkName(String string) {
        String string2;
        String string3;
        block3 : {
            if (!string.contains("..")) return;
            File file = new File(string);
            while (file != null) {
                if (file.getName().equals("..")) {
                    string2 = String.valueOf("Cannot unzip file containing an entry with \"..\" in the name: ");
                    String string4 = String.valueOf(string);
                    if (string4.length() != 0) {
                        string3 = string2.concat(string4);
                        throw new IOException(string3);
                    }
                    break block3;
                }
                file = file.getParentFile();
            }
            return;
        }
        string3 = new String(string2);
        throw new IOException(string3);
    }

    public static void zipDirectory(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(file.isDirectory(), "%s is not a valid directory", file.getAbsolutePath());
        Preconditions.checkArgument(!file2.exists(), "%s does already exist, files are not being overwritten", file2.getAbsolutePath());
        Closer closer = Closer.create();
        try {
            OutputStream outputStream = (OutputStream)closer.register(new BufferedOutputStream(new FileOutputStream(file2)));
            ZipFiles.zipDirectory(file, outputStream);
            return;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public static void zipDirectory(File file, OutputStream outputStream) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(outputStream);
        Preconditions.checkArgument(file.isDirectory(), "%s is not a valid directory", file.getAbsolutePath());
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        File[] arrfile = file.listFiles();
        int n2 = arrfile.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                zipOutputStream.finish();
                return;
            }
            File file2 = arrfile[n3];
            ZipFiles.zipDirectoryInternal(file2, "", zipOutputStream);
            ++n3;
        } while (true);
    }

    private static void zipDirectoryInternal(File file, String string, ZipOutputStream zipOutputStream) {
        Object object;
        String string2;
        if ("".equals(string)) {
            string2 = file.getName();
        } else {
            object = String.valueOf(file.getName());
            string2 = new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(object).length()).append(string).append("/").append((String)object).toString();
        }
        if (!file.isDirectory()) {
            object = new ZipEntry(string2);
            zipOutputStream.putNextEntry((ZipEntry)object);
            Files.asByteSource(file).copyTo(zipOutputStream);
            return;
        }
        if (file.list().length == 0) {
            object = new ZipEntry(String.valueOf(string2).concat("/"));
            zipOutputStream.putNextEntry((ZipEntry)object);
            return;
        }
        object = file.listFiles();
        int n2 = object.length;
        int n3 = 0;
        while (n3 < n2) {
            Object object2 = object[n3];
            ZipFiles.zipDirectoryInternal((File)object2, string2, zipOutputStream);
            ++n3;
        }
    }
}

