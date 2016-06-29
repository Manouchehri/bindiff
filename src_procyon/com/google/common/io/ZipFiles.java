package com.google.common.io;

import com.google.common.annotations.*;
import java.nio.charset.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import java.util.*;
import java.io.*;
import java.util.zip.*;

@GoogleInternal
public final class ZipFiles
{
    public static ByteSource asByteSource(final ZipFile zipFile, final ZipEntry zipEntry) {
        return new ZipFiles$ZipEntryByteSource(zipFile, zipEntry);
    }
    
    public static CharSource asCharSource(final ZipFile zipFile, final ZipEntry zipEntry, final Charset charset) {
        return asByteSource(zipFile, zipEntry).asCharSource(charset);
    }
    
    public static FluentIterable entries(final ZipFile zipFile) {
        Preconditions.checkNotNull(zipFile);
        return new ZipFiles$1(zipFile);
    }
    
    public static void unzipFile(final File file, final File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(file2.isDirectory(), "%s is not a valid directory", file2.getAbsolutePath());
        final ZipFile zipFile = new ZipFile(file);
        try {
            for (final ZipEntry zipEntry : entries(zipFile)) {
                checkName(zipEntry.getName());
                final File file3 = new File(file2, zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    if (!file3.isDirectory() && !file3.mkdirs()) {
                        final String s = "Failed to create directory: ";
                        final String value = String.valueOf(file3.getAbsolutePath());
                        throw new IOException((value.length() != 0) ? s.concat(value) : new String(s));
                    }
                    continue;
                }
                else {
                    final File parentFile = file3.getParentFile();
                    if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                        final String s2 = "Failed to create directory: ";
                        final String value2 = String.valueOf(parentFile.getAbsolutePath());
                        throw new IOException((value2.length() != 0) ? s2.concat(value2) : new String(s2));
                    }
                    asByteSource(zipFile, zipEntry).copyTo(Files.asByteSink(file3, new FileWriteMode[0]));
                }
            }
        }
        finally {
            zipFile.close();
        }
    }
    
    private static void checkName(final String s) {
        if (s.contains("..")) {
            for (File parentFile = new File(s); parentFile != null; parentFile = parentFile.getParentFile()) {
                if (parentFile.getName().equals("..")) {
                    final String value = String.valueOf("Cannot unzip file containing an entry with \"..\" in the name: ");
                    final String value2 = String.valueOf(s);
                    throw new IOException((value2.length() != 0) ? value.concat(value2) : new String(value));
                }
            }
        }
    }
    
    public static void zipDirectory(final File file, final File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(file.isDirectory(), "%s is not a valid directory", file.getAbsolutePath());
        Preconditions.checkArgument(!file2.exists(), "%s does already exist, files are not being overwritten", file2.getAbsolutePath());
        final Closer create = Closer.create();
        try {
            zipDirectory(file, (OutputStream)create.register(new BufferedOutputStream(new FileOutputStream(file2))));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public static void zipDirectory(final File file, final OutputStream outputStream) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(outputStream);
        Preconditions.checkArgument(file.isDirectory(), "%s is not a valid directory", file.getAbsolutePath());
        final ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        final File[] listFiles = file.listFiles();
        for (int length = listFiles.length, i = 0; i < length; ++i) {
            zipDirectoryInternal(listFiles[i], "", zipOutputStream);
        }
        zipOutputStream.finish();
    }
    
    private static void zipDirectoryInternal(final File file, final String s, final ZipOutputStream zipOutputStream) {
        String s2;
        if ("".equals(s)) {
            s2 = file.getName();
        }
        else {
            final String value = String.valueOf(file.getName());
            s2 = new StringBuilder(1 + String.valueOf(s).length() + String.valueOf(value).length()).append(s).append("/").append(value).toString();
        }
        if (file.isDirectory()) {
            if (file.list().length == 0) {
                zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(s2).concat("/")));
            }
            else {
                final File[] listFiles = file.listFiles();
                for (int length = listFiles.length, i = 0; i < length; ++i) {
                    zipDirectoryInternal(listFiles[i], s2, zipOutputStream);
                }
            }
        }
        else {
            zipOutputStream.putNextEntry(new ZipEntry(s2));
            Files.asByteSource(file).copyTo(zipOutputStream);
        }
    }
}
