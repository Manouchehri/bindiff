package com.google.common.io;

import com.google.common.collect.*;
import java.nio.charset.*;
import com.google.common.annotations.*;
import com.google.common.hash.*;
import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.util.*;
import com.google.common.base.*;

@Beta
public final class Files
{
    private static final int TEMP_DIR_ATTEMPTS = 10000;
    private static final TreeTraverser FILE_TREE_TRAVERSER;
    
    public static BufferedReader newReader(final File file, final Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }
    
    public static BufferedWriter newWriter(final File file, final Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }
    
    public static ByteSource asByteSource(final File file) {
        return new Files$FileByteSource(file, null);
    }
    
    static byte[] readFile(final InputStream inputStream, final long n) {
        if (n > 2147483647L) {
            throw new OutOfMemoryError(new StringBuilder(68).append("file is too large to fit in a byte array: ").append(n).append(" bytes").toString());
        }
        return (n == 0L) ? ByteStreams.toByteArray(inputStream) : ByteStreams.toByteArray(inputStream, (int)n);
    }
    
    public static ByteSink asByteSink(final File file, final FileWriteMode... array) {
        return new Files$FileByteSink(file, array, null);
    }
    
    public static CharSource asCharSource(final File file, final Charset charset) {
        return asByteSource(file).asCharSource(charset);
    }
    
    public static CharSink asCharSink(final File file, final Charset charset, final FileWriteMode... array) {
        return asByteSink(file, array).asCharSink(charset);
    }
    
    private static FileWriteMode[] modes(final boolean b) {
        final FileWriteMode[] array;
        if (b) {
            array = new FileWriteMode[] { FileWriteMode.APPEND };
        }
        else {
            final FileWriteMode[] array2 = new FileWriteMode[0];
        }
        return array;
    }
    
    public static byte[] toByteArray(final File file) {
        return asByteSource(file).read();
    }
    
    public static String toString(final File file, final Charset charset) {
        return asCharSource(file, charset).read();
    }
    
    public static void write(final byte[] array, final File file) {
        asByteSink(file, new FileWriteMode[0]).write(array);
    }
    
    public static void copy(final File file, final OutputStream outputStream) {
        asByteSource(file).copyTo(outputStream);
    }
    
    public static void copy(final File file, final File file2) {
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        asByteSource(file).copyTo(asByteSink(file2, new FileWriteMode[0]));
    }
    
    public static void write(final CharSequence charSequence, final File file, final Charset charset) {
        asCharSink(file, charset, new FileWriteMode[0]).write(charSequence);
    }
    
    public static void append(final CharSequence charSequence, final File file, final Charset charset) {
        write(charSequence, file, charset, true);
    }
    
    private static void write(final CharSequence charSequence, final File file, final Charset charset, final boolean b) {
        asCharSink(file, charset, modes(b)).write(charSequence);
    }
    
    public static void copy(final File file, final Charset charset, final Appendable appendable) {
        asCharSource(file, charset).copyTo(appendable);
    }
    
    public static boolean equal(final File file, final File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        final long length = file.length();
        final long length2 = file2.length();
        return (length == 0L || length2 == 0L || length == length2) && asByteSource(file).contentEquals(asByteSource(file2));
    }
    
    public static File createTempDir() {
        final File file = new File(System.getProperty("java.io.tmpdir"));
        final String string = new StringBuilder(21).append(System.currentTimeMillis()).append("-").toString();
        for (int i = 0; i < 10000; ++i) {
            final File file2 = new File(file, new StringBuilder(11 + String.valueOf(string).length()).append(string).append(i).toString());
            if (file2.mkdir()) {
                return file2;
            }
        }
        final String value = String.valueOf("Failed to create directory within 10000 attempts (tried ");
        throw new IllegalStateException(new StringBuilder(17 + String.valueOf(value).length() + String.valueOf(string).length() + String.valueOf(string).length()).append(value).append(string).append("0 to ").append(string).append(9999).append(")").toString());
    }
    
    public static void touch(final File file) {
        Preconditions.checkNotNull(file);
        if (!file.createNewFile() && !file.setLastModified(System.currentTimeMillis())) {
            final String value = String.valueOf(file);
            throw new IOException(new StringBuilder(38 + String.valueOf(value).length()).append("Unable to update modification time of ").append(value).toString());
        }
    }
    
    public static void createParentDirs(final File file) {
        Preconditions.checkNotNull(file);
        final File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            final String value = String.valueOf(file);
            throw new IOException(new StringBuilder(39 + String.valueOf(value).length()).append("Unable to create parent directories of ").append(value).toString());
        }
    }
    
    public static void move(final File file, final File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (!file.renameTo(file2)) {
            copy(file, file2);
            if (!file.delete()) {
                if (!file2.delete()) {
                    final String value = String.valueOf(file2);
                    throw new IOException(new StringBuilder(17 + String.valueOf(value).length()).append("Unable to delete ").append(value).toString());
                }
                final String value2 = String.valueOf(file);
                throw new IOException(new StringBuilder(17 + String.valueOf(value2).length()).append("Unable to delete ").append(value2).toString());
            }
        }
    }
    
    @Deprecated
    @GoogleInternal
    public static void deleteDirectoryContents(final File file) {
        Preconditions.checkNotNull(file);
        Preconditions.checkArgument(file.isDirectory(), "Not a directory: %s", file);
        if (!file.getCanonicalPath().equals(file.getAbsolutePath())) {
            return;
        }
        final File[] listFiles = file.listFiles();
        if (listFiles == null) {
            final String value = String.valueOf(file);
            throw new IOException(new StringBuilder(24 + String.valueOf(value).length()).append("Error listing files for ").append(value).toString());
        }
        final File[] array = listFiles;
        for (int length = array.length, i = 0; i < length; ++i) {
            deleteRecursively(array[i]);
        }
    }
    
    @Deprecated
    @GoogleInternal
    public static void deleteRecursively(final File file) {
        Preconditions.checkNotNull(file);
        if (file.isDirectory()) {
            deleteDirectoryContents(file);
        }
        if (!file.delete()) {
            final String value = String.valueOf(file);
            throw new IOException(new StringBuilder(17 + String.valueOf(value).length()).append("Failed to delete ").append(value).toString());
        }
    }
    
    public static String readFirstLine(final File file, final Charset charset) {
        return asCharSource(file, charset).readFirstLine();
    }
    
    public static List readLines(final File file, final Charset charset) {
        return (List)readLines(file, charset, new Files$1());
    }
    
    public static Object readLines(final File file, final Charset charset, final LineProcessor lineProcessor) {
        return asCharSource(file, charset).readLines(lineProcessor);
    }
    
    public static Object readBytes(final File file, final ByteProcessor byteProcessor) {
        return asByteSource(file).read(byteProcessor);
    }
    
    public static HashCode hash(final File file, final HashFunction hashFunction) {
        return asByteSource(file).hash(hashFunction);
    }
    
    public static MappedByteBuffer map(final File file) {
        Preconditions.checkNotNull(file);
        return map(file, FileChannel.MapMode.READ_ONLY);
    }
    
    public static MappedByteBuffer map(final File file, final FileChannel.MapMode mapMode) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        return map(file, mapMode, file.length());
    }
    
    public static MappedByteBuffer map(final File file, final FileChannel.MapMode mapMode, final long n) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        final Closer create = Closer.create();
        try {
            return map((RandomAccessFile)create.register(new RandomAccessFile(file, (mapMode == FileChannel.MapMode.READ_ONLY) ? "r" : "rw")), mapMode, n);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    private static MappedByteBuffer map(final RandomAccessFile randomAccessFile, final FileChannel.MapMode mapMode, final long n) {
        final Closer create = Closer.create();
        try {
            return ((FileChannel)create.register(randomAccessFile.getChannel())).map(mapMode, 0L, n);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public static String simplifyPath(final String s) {
        Preconditions.checkNotNull(s);
        if (s.length() == 0) {
            return ".";
        }
        final Iterable split = Splitter.on('/').omitEmptyStrings().split(s);
        final ArrayList<String> list = new ArrayList<String>();
        for (final String s2 : split) {
            if (s2.equals(".")) {
                continue;
            }
            if (s2.equals("..")) {
                if (list.size() > 0 && !((String)list.get(list.size() - 1)).equals("..")) {
                    list.remove(list.size() - 1);
                }
                else {
                    list.add("..");
                }
            }
            else {
                list.add(s2);
            }
        }
        String s3 = Joiner.on('/').join(list);
        if (s.charAt(0) == '/') {
            final String s4 = "/";
            final String value = String.valueOf(s3);
            s3 = ((value.length() != 0) ? s4.concat(value) : new String(s4));
        }
        while (s3.startsWith("/../")) {
            s3 = s3.substring(3);
        }
        if (s3.equals("/..")) {
            s3 = "/";
        }
        else if ("".equals(s3)) {
            s3 = ".";
        }
        return s3;
    }
    
    public static String getFileExtension(final String s) {
        Preconditions.checkNotNull(s);
        final String name = new File(s).getName();
        final int lastIndex = name.lastIndexOf(46);
        return (lastIndex == -1) ? "" : name.substring(lastIndex + 1);
    }
    
    public static String getNameWithoutExtension(final String s) {
        Preconditions.checkNotNull(s);
        final String name = new File(s).getName();
        final int lastIndex = name.lastIndexOf(46);
        return (lastIndex == -1) ? name : name.substring(0, lastIndex);
    }
    
    public static TreeTraverser fileTreeTraverser() {
        return Files.FILE_TREE_TRAVERSER;
    }
    
    public static Predicate isDirectory() {
        return Files$FilePredicate.IS_DIRECTORY;
    }
    
    public static Predicate isFile() {
        return Files$FilePredicate.IS_FILE;
    }
    
    static {
        FILE_TREE_TRAVERSER = new Files$2();
    }
}
