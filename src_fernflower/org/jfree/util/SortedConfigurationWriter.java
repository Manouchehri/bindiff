package org.jfree.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.jfree.util.Configuration;
import org.jfree.util.LineBreakIterator;
import org.jfree.util.StringUtils;

public class SortedConfigurationWriter {
   private static final int ESCAPE_KEY = 0;
   private static final int ESCAPE_VALUE = 1;
   private static final int ESCAPE_COMMENT = 2;
   private static final String END_OF_LINE = StringUtils.getLineSeparator();
   private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

   protected String getDescription(String var1) {
      return null;
   }

   public void save(String var1, Configuration var2) {
      this.save(new File(var1), var2);
   }

   public void save(File var1, Configuration var2) {
      BufferedOutputStream var3 = new BufferedOutputStream(new FileOutputStream(var1));
      this.save((OutputStream)var3, var2);
      var3.close();
   }

   public void save(OutputStream var1, Configuration var2) {
      ArrayList var3 = new ArrayList();
      Iterator var4 = var2.findPropertyKeys("");

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         var3.add(var5);
      }

      Collections.sort(var3);
      OutputStreamWriter var10 = new OutputStreamWriter(var1, "iso-8859-1");

      for(int var6 = 0; var6 < var3.size(); ++var6) {
         String var7 = (String)var3.get(var6);
         String var8 = var2.getConfigProperty(var7);
         String var9 = this.getDescription(var7);
         if(var9 != null) {
            this.writeDescription(var9, var10);
         }

         this.saveConvert(var7, 0, var10);
         var10.write("=");
         this.saveConvert(var8, 1, var10);
         var10.write(END_OF_LINE);
      }

      var10.flush();
   }

   private void writeDescription(String var1, Writer var2) {
      if(var1.length() != 0) {
         var2.write("# ");
         var2.write(END_OF_LINE);
         LineBreakIterator var3 = new LineBreakIterator(var1);

         while(var3.hasNext()) {
            var2.write("# ");
            this.saveConvert((String)var3.next(), 2, var2);
            var2.write(END_OF_LINE);
         }

      }
   }

   private void saveConvert(String var1, int var2, Writer var3) {
      char[] var4 = var1.toCharArray();

      for(int var5 = 0; var5 < var4.length; ++var5) {
         char var6 = var4[var5];
         switch(var6) {
         case '\t':
            if(var2 == 2) {
               var3.write(var6);
            } else {
               var3.write(92);
               var3.write(116);
            }
            break;
         case '\n':
            var3.write(92);
            var3.write(110);
            break;
         case '\f':
            if(var2 == 2) {
               var3.write(var6);
            } else {
               var3.write(92);
               var3.write(102);
            }
            break;
         case '\r':
            var3.write(92);
            var3.write(114);
            break;
         case ' ':
            if(var2 != 2 && (var5 == 0 || var2 == 0)) {
               var3.write(92);
            }

            var3.write(32);
            break;
         case '!':
         case '\"':
         case '#':
         case ':':
         case '=':
            if(var2 == 2) {
               var3.write(var6);
            } else {
               var3.write(92);
               var3.write(var6);
            }
            break;
         case '\\':
            var3.write(92);
            var3.write(92);
            break;
         default:
            if(var6 >= 32 && var6 <= 126) {
               var3.write(var6);
            } else {
               var3.write(92);
               var3.write(117);
               var3.write(HEX_CHARS[var6 >> 12 & 15]);
               var3.write(HEX_CHARS[var6 >> 8 & 15]);
               var3.write(HEX_CHARS[var6 >> 4 & 15]);
               var3.write(HEX_CHARS[var6 & 15]);
            }
         }
      }

   }
}
