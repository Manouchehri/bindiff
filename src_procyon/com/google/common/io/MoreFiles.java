package com.google.common.io;

import com.google.common.annotations.*;
import java.nio.charset.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import java.io.*;
import java.nio.file.*;
import javax.annotation.*;
import java.nio.file.attribute.*;
import java.util.*;

@GoogleInternal
public final class MoreFiles
{
    public static ByteSource asByteSource(final Path path, final OpenOption... array) {
        return new MoreFiles$PathByteSource(path, array, null);
    }
    
    public static ByteSink asByteSink(final Path path, final OpenOption... array) {
        return new MoreFiles$PathByteSink(path, array, null);
    }
    
    public static CharSource asCharSource(final Path path, final Charset charset, final OpenOption... array) {
        return asByteSource(path, array).asCharSource(charset);
    }
    
    public static CharSink asCharSink(final Path path, final Charset charset, final OpenOption... array) {
        return asByteSink(path, array).asCharSink(charset);
    }
    
    public static ImmutableList listFiles(final Path path) {
        try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            return ImmutableList.copyOf(directoryStream);
        }
        catch (DirectoryIteratorException ex) {
            throw ex.getCause();
        }
    }
    
    public static TreeTraverser directoryTreeTraverser() {
        return MoreFiles$DirectoryTreeTraverser.INSTANCE;
    }
    
    public static Predicate isDirectory(final LinkOption... array) {
        return new MoreFiles$1(array.clone());
    }
    
    public static Predicate isRegularFile(final LinkOption... array) {
        return new MoreFiles$2(array.clone());
    }
    
    public static void touch(final Path path) {
        Preconditions.checkNotNull(path);
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));
        }
        catch (NoSuchFileException ex) {
            try {
                Files.createFile(path, (FileAttribute<?>[])new FileAttribute[0]);
            }
            catch (FileAlreadyExistsException ex2) {}
        }
    }
    
    public static void createParentDirectories(final Path path, final FileAttribute... array) {
        final Path parent = path.toAbsolutePath().normalize().getParent();
        if (parent == null) {
            return;
        }
        if (!Files.isDirectory(parent, new LinkOption[0])) {
            Files.createDirectories(parent, (FileAttribute<?>[])array);
            if (!Files.isDirectory(parent, new LinkOption[0])) {
                final String value = String.valueOf(path);
                throw new IOException(new StringBuilder(39 + String.valueOf(value).length()).append("Unable to create parent directories of ").append(value).toString());
            }
        }
    }
    
    public static String getFileExtension(final Path path) {
        final Path fileName = path.getFileName();
        if (fileName == null) {
            return "";
        }
        final String string = fileName.toString();
        final int lastIndex = string.lastIndexOf(46);
        return (lastIndex == -1) ? "" : string.substring(lastIndex + 1);
    }
    
    public static String getNameWithoutExtension(final Path path) {
        final Path fileName = path.getFileName();
        if (fileName == null) {
            return "";
        }
        final String string = fileName.toString();
        final int lastIndex = string.lastIndexOf(46);
        return (lastIndex == -1) ? string : string.substring(0, lastIndex);
    }
    
    public static void deleteRecursively(final Path path, final RecursiveDeleteOption... array) {
        final Path parentPath = getParentPath(path);
        if (parentPath == null) {
            throw new FileSystemException(path.toString(), null, "can't delete recursively");
        }
        Collection<IOException> collection = null;
        try {
            boolean b = false;
            try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(parentPath)) {
                if (directoryStream instanceof SecureDirectoryStream) {
                    b = true;
                    collection = (Collection<IOException>)deleteRecursivelySecure((SecureDirectoryStream)directoryStream, path.getFileName());
                }
            }
            if (!b) {
                checkAllowsInsecure(path, array);
                collection = (Collection<IOException>)deleteRecursivelyInsecure(path);
            }
        }
        catch (IOException ex) {
            if (collection == null) {
                throw ex;
            }
            collection.add(ex);
        }
        if (collection != null) {
            throwDeleteFailed(path, collection);
        }
    }
    
    public static void deleteDirectoryContents(final Path path, final RecursiveDeleteOption... array) {
        Collection<IOException> collection = null;
        try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            if (directoryStream instanceof SecureDirectoryStream) {
                collection = (Collection<IOException>)deleteDirectoryContentsSecure((SecureDirectoryStream)directoryStream);
            }
            else {
                checkAllowsInsecure(path, array);
                collection = (Collection<IOException>)deleteDirectoryContentsInsecure(directoryStream);
            }
        }
        catch (IOException ex) {
            if (collection == null) {
                throw ex;
            }
            collection.add(ex);
        }
        if (collection != null) {
            throwDeleteFailed(path, collection);
        }
    }
    
    @Nullable
    private static Collection deleteRecursivelySecure(final SecureDirectoryStream secureDirectoryStream, final Path path) {
        Collection deleteDirectoryContentsSecure = null;
        try {
            if (isDirectory(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
                try (final SecureDirectoryStream<Path> directoryStream = secureDirectoryStream.newDirectoryStream(path, new LinkOption[] { LinkOption.NOFOLLOW_LINKS })) {
                    deleteDirectoryContentsSecure = deleteDirectoryContentsSecure(directoryStream);
                }
                if (deleteDirectoryContentsSecure == null) {
                    secureDirectoryStream.deleteDirectory(path);
                }
            }
            else {
                secureDirectoryStream.deleteFile(path);
            }
            return deleteDirectoryContentsSecure;
        }
        catch (IOException ex) {
            return addException(deleteDirectoryContentsSecure, ex);
        }
    }
    
    @Nullable
    private static Collection deleteDirectoryContentsSecure(final SecureDirectoryStream secureDirectoryStream) {
        Collection concat = null;
        try {
            final Iterator<Object> iterator = secureDirectoryStream.iterator();
            while (iterator.hasNext()) {
                concat = concat(concat, deleteRecursivelySecure(secureDirectoryStream, iterator.next().getFileName()));
            }
            return concat;
        }
        catch (DirectoryIteratorException ex) {
            return addException(concat, ex.getCause());
        }
    }
    
    @Nullable
    private static Collection deleteRecursivelyInsecure(final Path path) {
        Collection deleteDirectoryContentsInsecure = null;
        try {
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                    deleteDirectoryContentsInsecure = deleteDirectoryContentsInsecure(directoryStream);
                }
            }
            if (deleteDirectoryContentsInsecure == null) {
                Files.delete(path);
            }
            return deleteDirectoryContentsInsecure;
        }
        catch (IOException ex) {
            return addException(deleteDirectoryContentsInsecure, ex);
        }
    }
    
    @Nullable
    private static Collection deleteDirectoryContentsInsecure(final DirectoryStream directoryStream) {
        Collection concat = null;
        try {
            final Iterator<Path> iterator = directoryStream.iterator();
            while (iterator.hasNext()) {
                concat = concat(concat, deleteRecursivelyInsecure(iterator.next()));
            }
            return concat;
        }
        catch (DirectoryIteratorException ex) {
            return addException(concat, ex.getCause());
        }
    }
    
    @Nullable
    private static Path getParentPath(final Path path) {
        final Path parent = path.getParent();
        if (parent != null) {
            return parent;
        }
        if (path.getNameCount() == 0) {
            return null;
        }
        return path.getFileSystem().getPath(".", new String[0]);
    }
    
    private static void checkAllowsInsecure(final Path path, final RecursiveDeleteOption[] array) {
        if (!Arrays.asList(array).contains(RecursiveDeleteOption.ALLOW_INSECURE)) {
            throw new InsecureRecursiveDeleteException(path.toString());
        }
    }
    
    private static boolean isDirectory(final SecureDirectoryStream secureDirectoryStream, final Path path, final LinkOption... array) {
        return secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, array).readAttributes().isDirectory();
    }
    
    private static Collection addException(@Nullable Collection list, final IOException ex) {
        if (list == null) {
            list = new ArrayList<IOException>();
        }
        list.add(ex);
        return list;
    }
    
    @Nullable
    private static Collection concat(@Nullable final Collection collection, @Nullable final Collection collection2) {
        if (collection == null) {
            return collection2;
        }
        if (collection2 != null) {
            collection.addAll(collection2);
        }
        return collection;
    }
    
    private static void throwDeleteFailed(final Path path, final Collection collection) {
        final FileSystemException ex = new FileSystemException(path.toString(), null, "failed to delete one or more files; see suppressed exceptions for details");
        final Iterator<IOException> iterator = collection.iterator();
        while (iterator.hasNext()) {
            ex.addSuppressed(iterator.next());
        }
        throw ex;
    }
}
