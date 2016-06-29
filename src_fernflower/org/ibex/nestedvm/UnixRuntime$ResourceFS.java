package org.ibex.nestedvm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$FS;
import org.ibex.nestedvm.UnixRuntime$ResourceFS$1;
import org.ibex.nestedvm.UnixRuntime$ResourceFS$2;
import org.ibex.nestedvm.util.InodeCache;
import org.ibex.nestedvm.util.Seekable$InputStream;

public class UnixRuntime$ResourceFS extends UnixRuntime$FS {
   final InodeCache inodes = new InodeCache(500);

   public Runtime$FStat lstat(UnixRuntime var1, String var2) {
      return this.stat(var1, var2);
   }

   public void mkdir(UnixRuntime var1, String var2, int var3) {
      throw new Runtime$ErrnoException(30);
   }

   public void unlink(UnixRuntime var1, String var2) {
      throw new Runtime$ErrnoException(30);
   }

   Runtime$FStat connFStat(URLConnection var1) {
      return new UnixRuntime$ResourceFS$1(this, var1);
   }

   public Runtime$FStat stat(UnixRuntime var1, String var2) {
      URL var3 = var1.getClass().getResource("/" + var2);
      if(var3 == null) {
         return null;
      } else {
         try {
            return this.connFStat(var3.openConnection());
         } catch (IOException var5) {
            throw new Runtime$ErrnoException(5);
         }
      }
   }

   public Runtime$FD open(UnixRuntime var1, String var2, int var3, int var4) {
      if((var3 & -4) != 0) {
         System.err.println("WARNING: Unsupported flags passed to ResourceFS.open(\"" + var2 + "\"): " + Runtime.toHex(var3 & -4));
         throw new Runtime$ErrnoException(134);
      } else if((var3 & 3) != 0) {
         throw new Runtime$ErrnoException(30);
      } else {
         URL var5 = var1.getClass().getResource("/" + var2);
         if(var5 == null) {
            return null;
         } else {
            try {
               URLConnection var6 = var5.openConnection();
               Seekable$InputStream var7 = new Seekable$InputStream(var6.getInputStream());
               return new UnixRuntime$ResourceFS$2(this, var7, var3, var6);
            } catch (FileNotFoundException var8) {
               if(var8.getMessage() != null && var8.getMessage().indexOf("Permission denied") >= 0) {
                  throw new Runtime$ErrnoException(13);
               } else {
                  return null;
               }
            } catch (IOException var9) {
               throw new Runtime$ErrnoException(5);
            }
         }
      }
   }
}
