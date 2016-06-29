package org.jfree.data.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class CSV {
   private char fieldDelimiter;
   private char textDelimiter;

   public CSV() {
      this(',', '\"');
   }

   public CSV(char var1, char var2) {
      this.fieldDelimiter = var1;
      this.textDelimiter = var2;
   }

   public CategoryDataset readCategoryDataset(Reader var1) {
      DefaultCategoryDataset var2 = new DefaultCategoryDataset();
      BufferedReader var3 = new BufferedReader(var1);
      List var4 = null;
      int var5 = 0;

      for(String var6 = var3.readLine(); var6 != null; ++var5) {
         if(var5 == 0) {
            var4 = this.extractColumnKeys(var6);
         } else {
            this.extractRowKeyAndData(var6, var2, var4);
         }

         var6 = var3.readLine();
      }

      return var2;
   }

   private List extractColumnKeys(String var1) {
      ArrayList var2 = new ArrayList();
      int var3 = 0;
      int var4 = 0;

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         if(var1.charAt(var5) == this.fieldDelimiter) {
            if(var3 > 0) {
               String var6 = var1.substring(var4, var5);
               var2.add(this.removeStringDelimiters(var6));
            }

            var4 = var5 + 1;
            ++var3;
         }
      }

      String var7 = var1.substring(var4, var1.length());
      var2.add(this.removeStringDelimiters(var7));
      return var2;
   }

   private void extractRowKeyAndData(String var1, DefaultCategoryDataset var2, List var3) {
      String var4 = null;
      int var5 = 0;
      int var6 = 0;

      for(int var7 = 0; var7 < var1.length(); ++var7) {
         if(var1.charAt(var7) == this.fieldDelimiter) {
            if(var5 == 0) {
               String var8 = var1.substring(var6, var7);
               var4 = this.removeStringDelimiters(var8);
            } else {
               Double var10 = Double.valueOf(this.removeStringDelimiters(var1.substring(var6, var7)));
               var2.addValue(var10, var4, (Comparable)var3.get(var5 - 1));
            }

            var6 = var7 + 1;
            ++var5;
         }
      }

      Double var9 = Double.valueOf(this.removeStringDelimiters(var1.substring(var6, var1.length())));
      var2.addValue(var9, var4, (Comparable)var3.get(var5 - 1));
   }

   private String removeStringDelimiters(String var1) {
      String var2 = var1.trim();
      if(var2.charAt(0) == this.textDelimiter) {
         var2 = var2.substring(1);
      }

      if(var2.charAt(var2.length() - 1) == this.textDelimiter) {
         var2 = var2.substring(0, var2.length() - 1);
      }

      return var2;
   }
}
