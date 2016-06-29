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
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Beta
public final class Files {
   private static final int TEMP_DIR_ATTEMPTS = 10000;
   private static final TreeTraverser FILE_TREE_TRAVERSER = new Files$2();

   public static BufferedReader newReader(File var0, Charset var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new BufferedReader(new InputStreamReader(new FileInputStream(var0), var1));
   }

   public static BufferedWriter newWriter(File var0, Charset var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(var0), var1));
   }

   public static ByteSource asByteSource(File var0) {
      return new Files$FileByteSource(var0, (Files$1)null);
   }

   static byte[] readFile(InputStream var0, long var1) {
      if(var1 > 2147483647L) {
         throw new OutOfMemoryError((new StringBuilder(68)).append("file is too large to fit in a byte array: ").append(var1).append(" bytes").toString());
      } else {
         return var1 == 0L?ByteStreams.toByteArray(var0):ByteStreams.toByteArray(var0, (int)var1);
      }
   }

   public static ByteSink asByteSink(File var0, FileWriteMode... var1) {
      return new Files$FileByteSink(var0, var1, (Files$1)null);
   }

   public static CharSource asCharSource(File var0, Charset var1) {
      return asByteSource(var0).asCharSource(var1);
   }

   public static CharSink asCharSink(File var0, Charset var1, FileWriteMode... var2) {
      return asByteSink(var0, var2).asCharSink(var1);
   }

   private static FileWriteMode[] modes(boolean var0) {
      return var0?new FileWriteMode[]{FileWriteMode.APPEND}:new FileWriteMode[0];
   }

   public static byte[] toByteArray(File var0) {
      return asByteSource(var0).read();
   }

   public static String toString(File var0, Charset var1) {
      return asCharSource(var0, var1).read();
   }

   public static void write(byte[] var0, File var1) {
      asByteSink(var1, new FileWriteMode[0]).write(var0);
   }

   public static void copy(File var0, OutputStream var1) {
      asByteSource(var0).copyTo(var1);
   }

   public static void copy(File var0, File var1) {
      Preconditions.checkArgument(!var0.equals(var1), "Source %s and destination %s must be different", new Object[]{var0, var1});
      asByteSource(var0).copyTo(asByteSink(var1, new FileWriteMode[0]));
   }

   public static void write(CharSequence var0, File var1, Charset var2) {
      asCharSink(var1, var2, new FileWriteMode[0]).write(var0);
   }

   public static void append(CharSequence var0, File var1, Charset var2) {
      write(var0, var1, var2, true);
   }

   private static void write(CharSequence var0, File var1, Charset var2, boolean var3) {
      asCharSink(var1, var2, modes(var3)).write(var0);
   }

   public static void copy(File var0, Charset var1, Appendable var2) {
      asCharSource(var0, var1).copyTo(var2);
   }

   public static boolean equal(File var0, File var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      if(var0 != var1 && !var0.equals(var1)) {
         long var2 = var0.length();
         long var4 = var1.length();
         return var2 != 0L && var4 != 0L && var2 != var4?false:asByteSource(var0).contentEquals(asByteSource(var1));
      } else {
         return true;
      }
   }

   public static File createTempDir() {
      File var0 = new File(System.getProperty("java.io.tmpdir"));
      long var2 = System.currentTimeMillis();
      String var1 = (new StringBuilder(21)).append(var2).append("-").toString();

      for(int var5 = 0; var5 < 10000; ++var5) {
         File var3 = new File(var0, (new StringBuilder(11 + String.valueOf(var1).length())).append(var1).append(var5).toString());
         if(var3.mkdir()) {
            return var3;
         }
      }

      String var6 = String.valueOf("Failed to create directory within 10000 attempts (tried ");
      short var7 = 9999;
      throw new IllegalStateException((new StringBuilder(17 + String.valueOf(var6).length() + String.valueOf(var1).length() + String.valueOf(var1).length())).append(var6).append(var1).append("0 to ").append(var1).append(var7).append(")").toString());
   }

   public static void touch(File var0) {
      Preconditions.checkNotNull(var0);
      if(!var0.createNewFile() && !var0.setLastModified(System.currentTimeMillis())) {
         String var1 = String.valueOf(var0);
         throw new IOException((new StringBuilder(38 + String.valueOf(var1).length())).append("Unable to update modification time of ").append(var1).toString());
      }
   }

   public static void createParentDirs(File var0) {
      Preconditions.checkNotNull(var0);
      File var1 = var0.getCanonicalFile().getParentFile();
      if(var1 != null) {
         var1.mkdirs();
         if(!var1.isDirectory()) {
            String var2 = String.valueOf(var0);
            throw new IOException((new StringBuilder(39 + String.valueOf(var2).length())).append("Unable to create parent directories of ").append(var2).toString());
         }
      }
   }

   public static void move(File var0, File var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(!var0.equals(var1), "Source %s and destination %s must be different", new Object[]{var0, var1});
      if(!var0.renameTo(var1)) {
         copy(var0, var1);
         if(!var0.delete()) {
            String var2;
            if(!var1.delete()) {
               var2 = String.valueOf(var1);
               throw new IOException((new StringBuilder(17 + String.valueOf(var2).length())).append("Unable to delete ").append(var2).toString());
            }

            var2 = String.valueOf(var0);
            throw new IOException((new StringBuilder(17 + String.valueOf(var2).length())).append("Unable to delete ").append(var2).toString());
         }
      }

   }

   @Deprecated
   @GoogleInternal
   public static void deleteDirectoryContents(File var0) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var0.isDirectory(), "Not a directory: %s", new Object[]{var0});
      if(var0.getCanonicalPath().equals(var0.getAbsolutePath())) {
         File[] var1 = var0.listFiles();
         if(var1 == null) {
            String var6 = String.valueOf(var0);
            throw new IOException((new StringBuilder(24 + String.valueOf(var6).length())).append("Error listing files for ").append(var6).toString());
         } else {
            File[] var2 = var1;
            int var3 = var1.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               File var5 = var2[var4];
               deleteRecursively(var5);
            }

         }
      }
   }

   @Deprecated
   @GoogleInternal
   public static void deleteRecursively(File var0) {
      Preconditions.checkNotNull(var0);
      if(var0.isDirectory()) {
         deleteDirectoryContents(var0);
      }

      if(!var0.delete()) {
         String var1 = String.valueOf(var0);
         throw new IOException((new StringBuilder(17 + String.valueOf(var1).length())).append("Failed to delete ").append(var1).toString());
      }
   }

   public static String readFirstLine(File var0, Charset var1) {
      return asCharSource(var0, var1).readFirstLine();
   }

   public static List readLines(File var0, Charset var1) {
      return (List)readLines(var0, var1, new Files$1());
   }

   public static Object readLines(File var0, Charset var1, LineProcessor var2) {
      return asCharSource(var0, var1).readLines(var2);
   }

   public static Object readBytes(File var0, ByteProcessor var1) {
      return asByteSource(var0).read(var1);
   }

   public static HashCode hash(File var0, HashFunction var1) {
      return asByteSource(var0).hash(var1);
   }

   public static MappedByteBuffer map(File var0) {
      Preconditions.checkNotNull(var0);
      return map(var0, MapMode.READ_ONLY);
   }

   public static MappedByteBuffer map(File var0, MapMode var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      if(!var0.exists()) {
         throw new FileNotFoundException(var0.toString());
      } else {
         return map(var0, var1, var0.length());
      }
   }

   public static MappedByteBuffer map(File var0, MapMode var1, long var2) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Closer var4 = Closer.create();

      MappedByteBuffer var6;
      try {
         RandomAccessFile var5 = (RandomAccessFile)var4.register(new RandomAccessFile(var0, var1 == MapMode.READ_ONLY?"r":"rw"));
         var6 = map(var5, var1, var2);
      } catch (Throwable var10) {
         throw var4.rethrow(var10);
      } finally {
         var4.close();
      }

      return var6;
   }

   private static MappedByteBuffer map(RandomAccessFile var0, MapMode var1, long var2) {
      Closer var4 = Closer.create();

      MappedByteBuffer var6;
      try {
         FileChannel var5 = (FileChannel)var4.register(var0.getChannel());
         var6 = var5.map(var1, 0L, var2);
      } catch (Throwable var10) {
         throw var4.rethrow(var10);
      } finally {
         var4.close();
      }

      return var6;
   }

   public static String simplifyPath(String var0) {
      // $FF: Couldn't be decompiled
   }

   public static String getFileExtension(String var0) {
      Preconditions.checkNotNull(var0);
      String var1 = (new File(var0)).getName();
      int var2 = var1.lastIndexOf(46);
      return var2 == -1?"":var1.substring(var2 + 1);
   }

   public static String getNameWithoutExtension(String var0) {
      Preconditions.checkNotNull(var0);
      String var1 = (new File(var0)).getName();
      int var2 = var1.lastIndexOf(46);
      return var2 == -1?var1:var1.substring(0, var2);
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
