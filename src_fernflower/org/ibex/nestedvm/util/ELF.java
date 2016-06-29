package org.ibex.nestedvm.util;

import java.io.DataInputStream;
import java.io.IOException;
import org.ibex.nestedvm.util.ELF$ELFException;
import org.ibex.nestedvm.util.ELF$ELFHeader;
import org.ibex.nestedvm.util.ELF$ELFIdent;
import org.ibex.nestedvm.util.ELF$PHeader;
import org.ibex.nestedvm.util.ELF$SHeader;
import org.ibex.nestedvm.util.ELF$Symtab;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public class ELF {
   private static final int ELF_MAGIC = 2135247942;
   public static final int ELFCLASSNONE = 0;
   public static final int ELFCLASS32 = 1;
   public static final int ELFCLASS64 = 2;
   public static final int ELFDATANONE = 0;
   public static final int ELFDATA2LSB = 1;
   public static final int ELFDATA2MSB = 2;
   public static final int SHT_SYMTAB = 2;
   public static final int SHT_STRTAB = 3;
   public static final int SHT_NOBITS = 8;
   public static final int SHF_WRITE = 1;
   public static final int SHF_ALLOC = 2;
   public static final int SHF_EXECINSTR = 4;
   public static final int PF_X = 1;
   public static final int PF_W = 2;
   public static final int PF_R = 4;
   public static final int PT_LOAD = 1;
   public static final short ET_EXEC = 2;
   public static final short EM_MIPS = 8;
   private Seekable data;
   public ELF$ELFIdent ident;
   public ELF$ELFHeader header;
   public ELF$PHeader[] pheaders;
   public ELF$SHeader[] sheaders;
   private byte[] stringTable;
   private boolean sectionReaderActive;
   private ELF$Symtab _symtab;

   private void readFully(byte[] var1) {
      int var2 = var1.length;

      int var4;
      for(int var3 = 0; var2 > 0; var2 -= var4) {
         var4 = this.data.read(var1, var3, var2);
         if(var4 == -1) {
            throw new IOException("EOF");
         }

         var3 += var4;
      }

   }

   private int readIntBE() {
      byte[] var1 = new byte[4];
      this.readFully(var1);
      return (var1[0] & 255) << 24 | (var1[1] & 255) << 16 | (var1[2] & 255) << 8 | (var1[3] & 255) << 0;
   }

   private int readInt() {
      int var1 = this.readIntBE();
      if(this.ident != null && this.ident.data == 1) {
         var1 = var1 << 24 & -16777216 | var1 << 8 & 16711680 | var1 >>> 8 & '\uff00' | var1 >> 24 & 255;
      }

      return var1;
   }

   private short readShortBE() {
      byte[] var1 = new byte[2];
      this.readFully(var1);
      return (short)((var1[0] & 255) << 8 | (var1[1] & 255) << 0);
   }

   private short readShort() {
      short var1 = this.readShortBE();
      if(this.ident != null && this.ident.data == 1) {
         var1 = (short)((var1 << 8 & '\uff00' | var1 >> 8 & 255) & '\uffff');
      }

      return var1;
   }

   private byte readByte() {
      byte[] var1 = new byte[1];
      this.readFully(var1);
      return var1[0];
   }

   public ELF(String var1) {
      this((Seekable)(new Seekable$File(var1, false)));
   }

   public ELF(Seekable var1) {
      this.data = var1;
      this.ident = new ELF$ELFIdent(this);
      this.header = new ELF$ELFHeader(this);
      this.pheaders = new ELF$PHeader[this.header.phnum];

      int var2;
      for(var2 = 0; var2 < this.header.phnum; ++var2) {
         var1.seek(this.header.phoff + var2 * this.header.phentsize);
         this.pheaders[var2] = new ELF$PHeader(this);
      }

      this.sheaders = new ELF$SHeader[this.header.shnum];

      for(var2 = 0; var2 < this.header.shnum; ++var2) {
         var1.seek(this.header.shoff + var2 * this.header.shentsize);
         this.sheaders[var2] = new ELF$SHeader(this);
      }

      if(this.header.shstrndx >= 0 && this.header.shstrndx < this.header.shnum) {
         var1.seek(this.sheaders[this.header.shstrndx].offset);
         this.stringTable = new byte[this.sheaders[this.header.shstrndx].size];
         this.readFully(this.stringTable);

         for(var2 = 0; var2 < this.header.shnum; ++var2) {
            ELF$SHeader var3 = this.sheaders[var2];
            var3.name = this.getString(var3.nameidx);
         }

      } else {
         throw new ELF$ELFException(this, "Bad shstrndx");
      }
   }

   private String getString(int var1) {
      return this.getString(var1, this.stringTable);
   }

   private String getString(int var1, byte[] var2) {
      StringBuffer var3 = new StringBuffer();
      if(var1 >= 0 && var1 < var2.length) {
         while(var1 >= 0 && var1 < var2.length && var2[var1] != 0) {
            var3.append((char)var2[var1++]);
         }

         return var3.toString();
      } else {
         return "<invalid strtab entry>";
      }
   }

   public ELF$SHeader sectionWithName(String var1) {
      for(int var2 = 0; var2 < this.sheaders.length; ++var2) {
         if(this.sheaders[var2].name.equals(var1)) {
            return this.sheaders[var2];
         }
      }

      return null;
   }

   public ELF$Symtab getSymtab() {
      if(this._symtab != null) {
         return this._symtab;
      } else if(this.sectionReaderActive) {
         throw new ELF$ELFException(this, "Can\'t read the symtab while a section reader is active");
      } else {
         ELF$SHeader var1 = this.sectionWithName(".symtab");
         if(var1 != null && var1.type == 2) {
            ELF$SHeader var2 = this.sectionWithName(".strtab");
            if(var2 != null && var2.type == 3) {
               byte[] var3 = new byte[var2.size];
               DataInputStream var4 = new DataInputStream(var2.getInputStream());
               var4.readFully(var3);
               var4.close();
               return this._symtab = new ELF$Symtab(this, var1.offset, var1.size, var3);
            } else {
               return null;
            }
         } else {
            return null;
         }
      }
   }

   private static String toHex(int var0) {
      return "0x" + Long.toString((long)var0 & 4294967295L, 16);
   }

   static int access$000(ELF var0) {
      return var0.readIntBE();
   }

   static byte access$100(ELF var0) {
      return var0.readByte();
   }

   static short access$200(ELF var0) {
      return var0.readShort();
   }

   static int access$300(ELF var0) {
      return var0.readInt();
   }

   static String access$400(int var0) {
      return toHex(var0);
   }

   static boolean access$500(ELF var0) {
      return var0.sectionReaderActive;
   }

   static boolean access$502(ELF var0, boolean var1) {
      return var0.sectionReaderActive = var1;
   }

   static Seekable access$600(ELF var0) {
      return var0.data;
   }

   static String access$700(ELF var0, int var1, byte[] var2) {
      return var0.getString(var1, var2);
   }
}
