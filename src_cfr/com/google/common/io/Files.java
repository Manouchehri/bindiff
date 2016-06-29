/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.TreeTraverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files$1;
import com.google.common.io.Files$2;
import com.google.common.io.Files$FileByteSink;
import com.google.common.io.Files$FileByteSource;
import com.google.common.io.Files$FilePredicate;
import com.google.common.io.LineProcessor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Beta
public final class Files {
    private static final int TEMP_DIR_ATTEMPTS = 10000;
    private static final TreeTraverser FILE_TREE_TRAVERSER = new Files$2();

    private Files() {
    }

    public static BufferedReader newReader(File file, Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(file), charset));
    }

    public static BufferedWriter newWriter(File file, Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedWriter(new OutputStreamWriter((OutputStream)new FileOutputStream(file), charset));
    }

    public static ByteSource asByteSource(File file) {
        return new Files$FileByteSource(file, null);
    }

    static byte[] readFile(InputStream inputStream, long l2) {
        byte[] arrby;
        if (l2 > Integer.MAX_VALUE) {
            throw new OutOfMemoryError(new StringBuilder(68).append("file is too large to fit in a byte array: ").append(l2).append(" bytes").toString());
        }
        if (l2 == 0) {
            arrby = ByteStreams.toByteArray(inputStream);
            return arrby;
        }
        arrby = ByteStreams.toByteArray(inputStream, (int)l2);
        return arrby;
    }

    public static /* varargs */ ByteSink asByteSink(File file, FileWriteMode ... arrfileWriteMode) {
        return new Files$FileByteSink(file, arrfileWriteMode, null);
    }

    public static CharSource asCharSource(File file, Charset charset) {
        return Files.asByteSource(file).asCharSource(charset);
    }

    public static /* varargs */ CharSink asCharSink(File file, Charset charset, FileWriteMode ... arrfileWriteMode) {
        return Files.asByteSink(file, arrfileWriteMode).asCharSink(charset);
    }

    private static FileWriteMode[] modes(boolean bl2) {
        FileWriteMode[] arrfileWriteMode;
        if (bl2) {
            FileWriteMode[] arrfileWriteMode2 = new FileWriteMode[1];
            arrfileWriteMode = arrfileWriteMode2;
            arrfileWriteMode2[0] = FileWriteMode.APPEND;
            return arrfileWriteMode;
        }
        arrfileWriteMode = new FileWriteMode[]{};
        return arrfileWriteMode;
    }

    public static byte[] toByteArray(File file) {
        return Files.asByteSource(file).read();
    }

    public static String toString(File file, Charset charset) {
        return Files.asCharSource(file, charset).read();
    }

    public static void write(byte[] arrby, File file) {
        Files.asByteSink(file, new FileWriteMode[0]).write(arrby);
    }

    public static void copy(File file, OutputStream outputStream) {
        Files.asByteSource(file).copyTo(outputStream);
    }

    public static void copy(File file, File file2) {
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        Files.asByteSource(file).copyTo(Files.asByteSink(file2, new FileWriteMode[0]));
    }

    public static void write(CharSequence charSequence, File file, Charset charset) {
        Files.asCharSink(file, charset, new FileWriteMode[0]).write(charSequence);
    }

    public static void append(CharSequence charSequence, File file, Charset charset) {
        Files.write(charSequence, file, charset, true);
    }

    private static void write(CharSequence charSequence, File file, Charset charset, boolean bl2) {
        Files.asCharSink(file, charset, Files.modes(bl2)).write(charSequence);
    }

    public static void copy(File file, Charset charset, Appendable appendable) {
        Files.asCharSource(file, charset).copyTo(appendable);
    }

    public static boolean equal(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        if (file == file2) return true;
        if (file.equals(file2)) {
            return true;
        }
        long l2 = file.length();
        long l3 = file2.length();
        if (l2 == 0) return Files.asByteSource(file).contentEquals(Files.asByteSource(file2));
        if (l3 == 0) return Files.asByteSource(file).contentEquals(Files.asByteSource(file2));
        if (l2 == l3) return Files.asByteSource(file).contentEquals(Files.asByteSource(file2));
        return false;
    }

    public static File createTempDir() {
        int n2;
        File file;
        File file2 = new File(System.getProperty("java.io.tmpdir"));
        long l2 = System.currentTimeMillis();
        String string = new StringBuilder(21).append(l2).append("-").toString();
        int n3 = 0;
        do {
            if (n3 >= 10000) {
                String string2 = String.valueOf("Failed to create directory within 10000 attempts (tried ");
                int n4 = 9999;
                throw new IllegalStateException(new StringBuilder(17 + String.valueOf(string2).length() + String.valueOf(string).length() + String.valueOf(string).length()).append(string2).append(string).append("0 to ").append(string).append(n4).append(")").toString());
            }
            n2 = n3++;
        } while (!(file = new File(file2, new StringBuilder(11 + String.valueOf(string).length()).append(string).append(n2).toString())).mkdir());
        return file;
    }

    public static void touch(File file) {
        Preconditions.checkNotNull(file);
        if (file.createNewFile()) return;
        if (file.setLastModified(System.currentTimeMillis())) return;
        String string = String.valueOf(file);
        throw new IOException(new StringBuilder(38 + String.valueOf(string).length()).append("Unable to update modification time of ").append(string).toString());
    }

    public static void createParentDirs(File file) {
        Preconditions.checkNotNull(file);
        File file2 = file.getCanonicalFile().getParentFile();
        if (file2 == null) {
            return;
        }
        file2.mkdirs();
        if (file2.isDirectory()) return;
        String string = String.valueOf(file);
        throw new IOException(new StringBuilder(39 + String.valueOf(string).length()).append("Unable to create parent directories of ").append(string).toString());
    }

    public static void move(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (file.renameTo(file2)) return;
        Files.copy(file, file2);
        if (file.delete()) return;
        if (!file2.delete()) {
            String string = String.valueOf(file2);
            throw new IOException(new StringBuilder(17 + String.valueOf(string).length()).append("Unable to delete ").append(string).toString());
        }
        String string = String.valueOf(file);
        throw new IOException(new StringBuilder(17 + String.valueOf(string).length()).append("Unable to delete ").append(string).toString());
    }

    @Deprecated
    @GoogleInternal
    public static void deleteDirectoryContents(File file) {
        Preconditions.checkNotNull(file);
        Preconditions.checkArgument(file.isDirectory(), "Not a directory: %s", file);
        if (!file.getCanonicalPath().equals(file.getAbsolutePath())) {
            return;
        }
        File[] arrfile = file.listFiles();
        if (arrfile == null) {
            String string = String.valueOf(file);
            throw new IOException(new StringBuilder(24 + String.valueOf(string).length()).append("Error listing files for ").append(string).toString());
        }
        File[] arrfile2 = arrfile;
        int n2 = arrfile2.length;
        int n3 = 0;
        while (n3 < n2) {
            File file2 = arrfile2[n3];
            Files.deleteRecursively(file2);
            ++n3;
        }
    }

    @Deprecated
    @GoogleInternal
    public static void deleteRecursively(File file) {
        Preconditions.checkNotNull(file);
        if (file.isDirectory()) {
            Files.deleteDirectoryContents(file);
        }
        if (file.delete()) return;
        String string = String.valueOf(file);
        throw new IOException(new StringBuilder(17 + String.valueOf(string).length()).append("Failed to delete ").append(string).toString());
    }

    public static String readFirstLine(File file, Charset charset) {
        return Files.asCharSource(file, charset).readFirstLine();
    }

    public static List readLines(File file, Charset charset) {
        return (List)Files.readLines(file, charset, new Files$1());
    }

    public static Object readLines(File file, Charset charset, LineProcessor lineProcessor) {
        return Files.asCharSource(file, charset).readLines(lineProcessor);
    }

    public static Object readBytes(File file, ByteProcessor byteProcessor) {
        return Files.asByteSource(file).read(byteProcessor);
    }

    public static HashCode hash(File file, HashFunction hashFunction) {
        return Files.asByteSource(file).hash(hashFunction);
    }

    public static MappedByteBuffer map(File file) {
        Preconditions.checkNotNull(file);
        return Files.map(file, FileChannel.MapMode.READ_ONLY);
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        if (file.exists()) return Files.map(file, mapMode, file.length());
        throw new FileNotFoundException(file.toString());
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode, long l2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        Closer closer = Closer.create();
        try {
            RandomAccessFile randomAccessFile = (RandomAccessFile)closer.register(new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? "r" : "rw"));
            MappedByteBuffer mappedByteBuffer = Files.map(randomAccessFile, mapMode, l2);
            return mappedByteBuffer;
        }
        catch (Throwable var5_5) {
            throw closer.rethrow(var5_5);
        }
        finally {
            closer.close();
        }
    }

    private static MappedByteBuffer map(RandomAccessFile randomAccessFile, FileChannel.MapMode mapMode, long l2) {
        Closer closer = Closer.create();
        try {
            FileChannel fileChannel = (FileChannel)closer.register(randomAccessFile.getChannel());
            MappedByteBuffer mappedByteBuffer = fileChannel.map(mapMode, 0, l2);
            return mappedByteBuffer;
        }
        catch (Throwable var5_5) {
            throw closer.rethrow(var5_5);
        }
        finally {
            closer.close();
        }
    }

    public static String simplifyPath(String string) {
        Preconditions.checkNotNull(string);
        if (string.length() == 0) {
            return ".";
        }
        Iterable iterable = Splitter.on('/').omitEmptyStrings().split(string);
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : iterable) {
            if (string2.equals(".")) continue;
            if (string2.equals("..")) {
                if (arrayList.size() > 0 && !((String)arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.remove(arrayList.size() - 1);
                    continue;
                }
                arrayList.add("..");
                continue;
            }
            arrayList.add(string2);
        }
        Object object = Joiner.on('/').join(arrayList);
        if (string.charAt(0) == '/') {
            String string3 = String.valueOf(object);
            Object object2 = object = string3.length() != 0 ? "/".concat(string3) : new String("/");
        }
        while (object.startsWith("/../")) {
            object = object.substring(3);
        }
        if (object.equals("/..")) {
            return "/";
        }
        if (!"".equals(object)) return object;
        return ".";
    }

    public static String getFileExtension(String string) {
        Preconditions.checkNotNull(string);
        String string2 = new File(string).getName();
        int n2 = string2.lastIndexOf(46);
        if (n2 == -1) {
            return "";
        }
        String string3 = string2.substring(n2 + 1);
        return string3;
    }

    public static String getNameWithoutExtension(String string) {
        String string2;
        Preconditions.checkNotNull(string);
        String string3 = new File(string).getName();
        int n2 = string3.lastIndexOf(46);
        if (n2 == -1) {
            string2 = string3;
            return string2;
        }
        string2 = string3.substring(0, n2);
        return string2;
    }

    public static TreeTraverser fileTreeTraverser() {
        return FILE_TREE_TRAVERSER;
    }

    public static Predicate isDirectory() {
        return Files$FilePredicate.IS_DIRECTORY;
    }

    public static Predicate isFile() {
        return Files$FilePredicate.IS_FILE;
    }
}

