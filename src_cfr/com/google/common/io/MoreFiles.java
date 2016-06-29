/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.TreeTraverser;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.InsecureRecursiveDeleteException;
import com.google.common.io.MoreFiles$1;
import com.google.common.io.MoreFiles$2;
import com.google.common.io.MoreFiles$DirectoryTreeTraverser;
import com.google.common.io.MoreFiles$PathByteSink;
import com.google.common.io.MoreFiles$PathByteSource;
import com.google.common.io.RecursiveDeleteOption;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GoogleInternal
public final class MoreFiles {
    private MoreFiles() {
    }

    public static /* varargs */ ByteSource asByteSource(Path path, OpenOption ... arropenOption) {
        return new MoreFiles$PathByteSource(path, arropenOption, null);
    }

    public static /* varargs */ ByteSink asByteSink(Path path, OpenOption ... arropenOption) {
        return new MoreFiles$PathByteSink(path, arropenOption, null);
    }

    public static /* varargs */ CharSource asCharSource(Path path, Charset charset, OpenOption ... arropenOption) {
        return MoreFiles.asByteSource(path, arropenOption).asCharSource(charset);
    }

    public static /* varargs */ CharSink asCharSink(Path path, Charset charset, OpenOption ... arropenOption) {
        return MoreFiles.asByteSink(path, arropenOption).asCharSink(charset);
    }

    public static ImmutableList listFiles(Path path) {
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            Throwable throwable = null;
            try {
                ImmutableList immutableList = ImmutableList.copyOf(directoryStream);
                return immutableList;
            }
            catch (Throwable var3_5) {
                throwable = var3_5;
                throw var3_5;
            }
            finally {
                if (directoryStream != null) {
                    if (throwable != null) {
                        try {
                            directoryStream.close();
                        }
                        catch (Throwable var4_6) {
                            throwable.addSuppressed(var4_6);
                        }
                    } else {
                        directoryStream.close();
                    }
                }
            }
        }
        catch (DirectoryIteratorException var1_2) {
            throw var1_2.getCause();
        }
    }

    public static TreeTraverser directoryTreeTraverser() {
        return MoreFiles$DirectoryTreeTraverser.access$200();
    }

    public static /* varargs */ Predicate isDirectory(LinkOption ... arrlinkOption) {
        LinkOption[] arrlinkOption2 = (LinkOption[])arrlinkOption.clone();
        return new MoreFiles$1(arrlinkOption2);
    }

    public static /* varargs */ Predicate isRegularFile(LinkOption ... arrlinkOption) {
        LinkOption[] arrlinkOption2 = (LinkOption[])arrlinkOption.clone();
        return new MoreFiles$2(arrlinkOption2);
    }

    public static void touch(Path path) {
        Preconditions.checkNotNull(path);
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));
            return;
        }
        catch (NoSuchFileException var1_1) {
            try {
                Files.createFile(path, new FileAttribute[0]);
                return;
            }
            catch (FileAlreadyExistsException var2_2) {
                // empty catch block
            }
        }
    }

    public static /* varargs */ void createParentDirectories(Path path, FileAttribute ... arrfileAttribute) {
        Path path2 = path.toAbsolutePath().normalize();
        Path path3 = path2.getParent();
        if (path3 == null) {
            return;
        }
        if (Files.isDirectory(path3, new LinkOption[0])) return;
        Files.createDirectories(path3, arrfileAttribute);
        if (Files.isDirectory(path3, new LinkOption[0])) return;
        String string = String.valueOf(path);
        throw new IOException(new StringBuilder(39 + String.valueOf(string).length()).append("Unable to create parent directories of ").append(string).toString());
    }

    public static String getFileExtension(Path path) {
        Path path2 = path.getFileName();
        if (path2 == null) {
            return "";
        }
        String string = path2.toString();
        int n2 = string.lastIndexOf(46);
        if (n2 == -1) {
            return "";
        }
        String string2 = string.substring(n2 + 1);
        return string2;
    }

    public static String getNameWithoutExtension(Path path) {
        String string;
        Path path2 = path.getFileName();
        if (path2 == null) {
            return "";
        }
        String string2 = path2.toString();
        int n2 = string2.lastIndexOf(46);
        if (n2 == -1) {
            string = string2;
            return string;
        }
        string = string2.substring(0, n2);
        return string;
    }

    public static /* varargs */ void deleteRecursively(Path path, RecursiveDeleteOption ... arrrecursiveDeleteOption) {
        Path path2 = MoreFiles.getParentPath(path);
        if (path2 == null) {
            throw new FileSystemException(path.toString(), null, "can't delete recursively");
        }
        Collection collection = null;
        try {
            boolean bl2;
            bl2 = false;
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path2);
            Throwable throwable = null;
            try {
                if (directoryStream instanceof SecureDirectoryStream) {
                    bl2 = true;
                    collection = MoreFiles.deleteRecursivelySecure((SecureDirectoryStream)directoryStream, path.getFileName());
                }
            }
            catch (Throwable var7_9) {
                throwable = var7_9;
                throw var7_9;
            }
            finally {
                if (directoryStream != null) {
                    if (throwable != null) {
                        try {
                            directoryStream.close();
                        }
                        catch (Throwable var7_8) {
                            throwable.addSuppressed(var7_8);
                        }
                    } else {
                        directoryStream.close();
                    }
                }
            }
            if (!bl2) {
                MoreFiles.checkAllowsInsecure(path, arrrecursiveDeleteOption);
                collection = MoreFiles.deleteRecursivelyInsecure(path);
            }
        }
        catch (IOException var4_5) {
            if (collection == null) {
                throw var4_5;
            }
            collection.add(var4_5);
        }
        if (collection == null) return;
        MoreFiles.throwDeleteFailed(path, collection);
    }

    public static /* varargs */ void deleteDirectoryContents(Path path, RecursiveDeleteOption ... arrrecursiveDeleteOption) {
        Collection collection;
        collection = null;
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            Throwable throwable = null;
            try {
                if (directoryStream instanceof SecureDirectoryStream) {
                    SecureDirectoryStream secureDirectoryStream = (SecureDirectoryStream)directoryStream;
                    collection = MoreFiles.deleteDirectoryContentsSecure(secureDirectoryStream);
                } else {
                    MoreFiles.checkAllowsInsecure(path, arrrecursiveDeleteOption);
                    collection = MoreFiles.deleteDirectoryContentsInsecure(directoryStream);
                }
            }
            catch (Throwable var5_8) {
                throwable = var5_8;
                throw var5_8;
            }
            finally {
                if (directoryStream != null) {
                    if (throwable != null) {
                        try {
                            directoryStream.close();
                        }
                        catch (Throwable var5_7) {
                            throwable.addSuppressed(var5_7);
                        }
                    } else {
                        directoryStream.close();
                    }
                }
            }
        }
        catch (IOException var3_4) {
            if (collection == null) {
                throw var3_4;
            }
            collection.add(var3_4);
        }
        if (collection == null) return;
        MoreFiles.throwDeleteFailed(path, collection);
    }

    @Nullable
    private static Collection deleteRecursivelySecure(SecureDirectoryStream secureDirectoryStream, Path path) {
        Collection collection = null;
        try {
            if (!MoreFiles.isDirectory(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
                secureDirectoryStream.deleteFile(path);
                return collection;
            }
            SecureDirectoryStream<Path> secureDirectoryStream2 = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
            Throwable throwable = null;
            try {
                collection = MoreFiles.deleteDirectoryContentsSecure(secureDirectoryStream2);
            }
            catch (Throwable var5_7) {
                throwable = var5_7;
                throw var5_7;
            }
            finally {
                if (secureDirectoryStream2 != null) {
                    if (throwable != null) {
                        try {
                            secureDirectoryStream2.close();
                        }
                        catch (Throwable var5_6) {
                            throwable.addSuppressed(var5_6);
                        }
                    } else {
                        secureDirectoryStream2.close();
                    }
                }
            }
            if (collection != null) return collection;
            secureDirectoryStream.deleteDirectory(path);
            return collection;
        }
        catch (IOException var3_4) {
            return MoreFiles.addException(collection, var3_4);
        }
    }

    @Nullable
    private static Collection deleteDirectoryContentsSecure(SecureDirectoryStream secureDirectoryStream) {
        Collection collection = null;
        try {
            Iterator iterator = secureDirectoryStream.iterator();
            while (iterator.hasNext()) {
                Path path = (Path)iterator.next();
                collection = MoreFiles.concat(collection, MoreFiles.deleteRecursivelySecure(secureDirectoryStream, path.getFileName()));
            }
            return collection;
        }
        catch (DirectoryIteratorException var2_3) {
            return MoreFiles.addException(collection, var2_3.getCause());
        }
    }

    @Nullable
    private static Collection deleteRecursivelyInsecure(Path path) {
        Collection collection = null;
        try {
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                Throwable throwable = null;
                try {
                    collection = MoreFiles.deleteDirectoryContentsInsecure(directoryStream);
                }
                catch (Throwable var4_6) {
                    throwable = var4_6;
                    throw var4_6;
                }
                finally {
                    if (directoryStream != null) {
                        if (throwable != null) {
                            try {
                                directoryStream.close();
                            }
                            catch (Throwable var4_5) {
                                throwable.addSuppressed(var4_5);
                            }
                        } else {
                            directoryStream.close();
                        }
                    }
                }
            }
            if (collection != null) return collection;
            Files.delete(path);
            return collection;
        }
        catch (IOException var2_3) {
            return MoreFiles.addException(collection, var2_3);
        }
    }

    @Nullable
    private static Collection deleteDirectoryContentsInsecure(DirectoryStream directoryStream) {
        Collection collection = null;
        try {
            Iterator iterator = directoryStream.iterator();
            while (iterator.hasNext()) {
                Path path = (Path)iterator.next();
                collection = MoreFiles.concat(collection, MoreFiles.deleteRecursivelyInsecure(path));
            }
            return collection;
        }
        catch (DirectoryIteratorException var2_3) {
            return MoreFiles.addException(collection, var2_3.getCause());
        }
    }

    @Nullable
    private static Path getParentPath(Path path) {
        Path path2 = path.getParent();
        if (path2 != null) {
            return path2;
        }
        if (path.getNameCount() != 0) return path.getFileSystem().getPath(".", new String[0]);
        return null;
    }

    private static void checkAllowsInsecure(Path path, RecursiveDeleteOption[] arrrecursiveDeleteOption) {
        if (Arrays.asList(arrrecursiveDeleteOption).contains((Object)RecursiveDeleteOption.ALLOW_INSECURE)) return;
        throw new InsecureRecursiveDeleteException(path.toString());
    }

    private static /* varargs */ boolean isDirectory(SecureDirectoryStream secureDirectoryStream, Path path, LinkOption ... arrlinkOption) {
        return ((BasicFileAttributeView)secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, arrlinkOption)).readAttributes().isDirectory();
    }

    private static Collection addException(@Nullable Collection arrayList, IOException iOException) {
        if (arrayList == null) {
            arrayList = new ArrayList<IOException>();
        }
        arrayList.add(iOException);
        return arrayList;
    }

    @Nullable
    private static Collection concat(@Nullable Collection collection, @Nullable Collection collection2) {
        if (collection == null) {
            return collection2;
        }
        if (collection2 == null) return collection;
        collection.addAll(collection2);
        return collection;
    }

    private static void throwDeleteFailed(Path path, Collection collection) {
        FileSystemException fileSystemException = new FileSystemException(path.toString(), null, "failed to delete one or more files; see suppressed exceptions for details");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            IOException iOException = (IOException)iterator.next();
            fileSystemException.addSuppressed(iOException);
        }
        throw fileSystemException;
    }
}

