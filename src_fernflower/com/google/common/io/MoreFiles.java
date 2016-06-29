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
import java.nio.file.FileSystemException;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GoogleInternal
public final class MoreFiles {
   public static ByteSource asByteSource(Path var0, OpenOption... var1) {
      return new MoreFiles$PathByteSource(var0, var1, (MoreFiles$1)null);
   }

   public static ByteSink asByteSink(Path var0, OpenOption... var1) {
      return new MoreFiles$PathByteSink(var0, var1, (MoreFiles$1)null);
   }

   public static CharSource asCharSource(Path var0, Charset var1, OpenOption... var2) {
      return asByteSource(var0, var2).asCharSource(var1);
   }

   public static CharSink asCharSink(Path var0, Charset var1, OpenOption... var2) {
      return asByteSink(var0, var2).asCharSink(var1);
   }

   public static ImmutableList listFiles(Path var0) {
      try {
         DirectoryStream var1 = java.nio.file.Files.newDirectoryStream(var0);
         Throwable var2 = null;

         ImmutableList var3;
         try {
            var3 = ImmutableList.copyOf((Iterable)var1);
         } catch (Throwable var13) {
            var2 = var13;
            throw var13;
         } finally {
            if(var1 != null) {
               if(var2 != null) {
                  try {
                     var1.close();
                  } catch (Throwable var12) {
                     var2.addSuppressed(var12);
                  }
               } else {
                  var1.close();
               }
            }

         }

         return var3;
      } catch (DirectoryIteratorException var15) {
         throw var15.getCause();
      }
   }

   public static TreeTraverser directoryTreeTraverser() {
      return MoreFiles$DirectoryTreeTraverser.access$200();
   }

   public static Predicate isDirectory(LinkOption... var0) {
      LinkOption[] var1 = (LinkOption[])var0.clone();
      return new MoreFiles$1(var1);
   }

   public static Predicate isRegularFile(LinkOption... var0) {
      LinkOption[] var1 = (LinkOption[])var0.clone();
      return new MoreFiles$2(var1);
   }

   public static void touch(Path var0) {
      Preconditions.checkNotNull(var0);

      try {
         java.nio.file.Files.setLastModifiedTime(var0, FileTime.fromMillis(System.currentTimeMillis()));
      } catch (NoSuchFileException var4) {
         try {
            java.nio.file.Files.createFile(var0, new FileAttribute[0]);
         } catch (FileAlreadyExistsException var3) {
            ;
         }
      }

   }

   public static void createParentDirectories(Path var0, FileAttribute... var1) {
      Path var2 = var0.toAbsolutePath().normalize();
      Path var3 = var2.getParent();
      if(var3 != null) {
         if(!java.nio.file.Files.isDirectory(var3, new LinkOption[0])) {
            java.nio.file.Files.createDirectories(var3, var1);
            if(!java.nio.file.Files.isDirectory(var3, new LinkOption[0])) {
               String var4 = String.valueOf(var0);
               throw new IOException((new StringBuilder(39 + String.valueOf(var4).length())).append("Unable to create parent directories of ").append(var4).toString());
            }
         }

      }
   }

   public static String getFileExtension(Path var0) {
      Path var1 = var0.getFileName();
      if(var1 == null) {
         return "";
      } else {
         String var2 = var1.toString();
         int var3 = var2.lastIndexOf(46);
         return var3 == -1?"":var2.substring(var3 + 1);
      }
   }

   public static String getNameWithoutExtension(Path var0) {
      Path var1 = var0.getFileName();
      if(var1 == null) {
         return "";
      } else {
         String var2 = var1.toString();
         int var3 = var2.lastIndexOf(46);
         return var3 == -1?var2:var2.substring(0, var3);
      }
   }

   public static void deleteRecursively(Path var0, RecursiveDeleteOption... var1) {
      Path var2 = getParentPath(var0);
      if(var2 == null) {
         throw new FileSystemException(var0.toString(), (String)null, "can\'t delete recursively");
      } else {
         Collection var3 = null;

         try {
            boolean var4 = false;
            DirectoryStream var5 = java.nio.file.Files.newDirectoryStream(var2);
            Throwable var6 = null;

            try {
               if(var5 instanceof SecureDirectoryStream) {
                  var4 = true;
                  var3 = deleteRecursivelySecure((SecureDirectoryStream)var5, var0.getFileName());
               }
            } catch (Throwable var16) {
               var6 = var16;
               throw var16;
            } finally {
               if(var5 != null) {
                  if(var6 != null) {
                     try {
                        var5.close();
                     } catch (Throwable var15) {
                        var6.addSuppressed(var15);
                     }
                  } else {
                     var5.close();
                  }
               }

            }

            if(!var4) {
               checkAllowsInsecure(var0, var1);
               var3 = deleteRecursivelyInsecure(var0);
            }
         } catch (IOException var18) {
            if(var3 == null) {
               throw var18;
            }

            var3.add(var18);
         }

         if(var3 != null) {
            throwDeleteFailed(var0, var3);
         }

      }
   }

   public static void deleteDirectoryContents(Path var0, RecursiveDeleteOption... var1) {
      Collection var2 = null;

      try {
         DirectoryStream var3 = java.nio.file.Files.newDirectoryStream(var0);
         Throwable var4 = null;

         try {
            if(var3 instanceof SecureDirectoryStream) {
               SecureDirectoryStream var5 = (SecureDirectoryStream)var3;
               var2 = deleteDirectoryContentsSecure(var5);
            } else {
               checkAllowsInsecure(var0, var1);
               var2 = deleteDirectoryContentsInsecure(var3);
            }
         } catch (Throwable var14) {
            var4 = var14;
            throw var14;
         } finally {
            if(var3 != null) {
               if(var4 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var13) {
                     var4.addSuppressed(var13);
                  }
               } else {
                  var3.close();
               }
            }

         }
      } catch (IOException var16) {
         if(var2 == null) {
            throw var16;
         }

         var2.add(var16);
      }

      if(var2 != null) {
         throwDeleteFailed(var0, var2);
      }

   }

   @Nullable
   private static Collection deleteRecursivelySecure(SecureDirectoryStream var0, Path var1) {
      Collection var2 = null;

      try {
         if(isDirectory(var0, var1, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
            SecureDirectoryStream var3 = var0.newDirectoryStream(var1, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            Throwable var4 = null;

            try {
               var2 = deleteDirectoryContentsSecure(var3);
            } catch (Throwable var14) {
               var4 = var14;
               throw var14;
            } finally {
               if(var3 != null) {
                  if(var4 != null) {
                     try {
                        var3.close();
                     } catch (Throwable var13) {
                        var4.addSuppressed(var13);
                     }
                  } else {
                     var3.close();
                  }
               }

            }

            if(var2 == null) {
               var0.deleteDirectory(var1);
            }
         } else {
            var0.deleteFile(var1);
         }

         return var2;
      } catch (IOException var16) {
         return addException(var2, var16);
      }
   }

   @Nullable
   private static Collection deleteDirectoryContentsSecure(SecureDirectoryStream var0) {
      Collection var1 = null;

      try {
         Path var3;
         for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 = concat(var1, deleteRecursivelySecure(var0, var3.getFileName()))) {
            var3 = (Path)var2.next();
         }

         return var1;
      } catch (DirectoryIteratorException var4) {
         return addException(var1, var4.getCause());
      }
   }

   @Nullable
   private static Collection deleteRecursivelyInsecure(Path var0) {
      Collection var1 = null;

      try {
         if(java.nio.file.Files.isDirectory(var0, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
            DirectoryStream var2 = java.nio.file.Files.newDirectoryStream(var0);
            Throwable var3 = null;

            try {
               var1 = deleteDirectoryContentsInsecure(var2);
            } catch (Throwable var13) {
               var3 = var13;
               throw var13;
            } finally {
               if(var2 != null) {
                  if(var3 != null) {
                     try {
                        var2.close();
                     } catch (Throwable var12) {
                        var3.addSuppressed(var12);
                     }
                  } else {
                     var2.close();
                  }
               }

            }
         }

         if(var1 == null) {
            java.nio.file.Files.delete(var0);
         }

         return var1;
      } catch (IOException var15) {
         return addException(var1, var15);
      }
   }

   @Nullable
   private static Collection deleteDirectoryContentsInsecure(DirectoryStream var0) {
      Collection var1 = null;

      try {
         Path var3;
         for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 = concat(var1, deleteRecursivelyInsecure(var3))) {
            var3 = (Path)var2.next();
         }

         return var1;
      } catch (DirectoryIteratorException var4) {
         return addException(var1, var4.getCause());
      }
   }

   @Nullable
   private static Path getParentPath(Path var0) {
      Path var1 = var0.getParent();
      return var1 != null?var1:(var0.getNameCount() == 0?null:var0.getFileSystem().getPath(".", new String[0]));
   }

   private static void checkAllowsInsecure(Path var0, RecursiveDeleteOption[] var1) {
      if(!Arrays.asList(var1).contains(RecursiveDeleteOption.ALLOW_INSECURE)) {
         throw new InsecureRecursiveDeleteException(var0.toString());
      }
   }

   private static boolean isDirectory(SecureDirectoryStream var0, Path var1, LinkOption... var2) {
      return ((BasicFileAttributeView)var0.getFileAttributeView(var1, BasicFileAttributeView.class, var2)).readAttributes().isDirectory();
   }

   private static Collection addException(@Nullable Collection var0, IOException var1) {
      if(var0 == null) {
         var0 = new ArrayList();
      }

      ((Collection)var0).add(var1);
      return (Collection)var0;
   }

   @Nullable
   private static Collection concat(@Nullable Collection var0, @Nullable Collection var1) {
      if(var0 == null) {
         return var1;
      } else {
         if(var1 != null) {
            var0.addAll(var1);
         }

         return var0;
      }
   }

   private static void throwDeleteFailed(Path var0, Collection var1) {
      FileSystemException var2 = new FileSystemException(var0.toString(), (String)null, "failed to delete one or more files; see suppressed exceptions for details");
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         IOException var4 = (IOException)var3.next();
         var2.addSuppressed(var4);
      }

      throw var2;
   }
}
