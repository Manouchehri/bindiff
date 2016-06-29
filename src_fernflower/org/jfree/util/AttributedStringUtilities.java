package org.jfree.util;

import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Map;

public class AttributedStringUtilities {
   public static boolean equal(AttributedString var0, AttributedString var1) {
      if(var0 == null) {
         return var1 == null;
      } else if(var1 == null) {
         return false;
      } else {
         AttributedCharacterIterator var2 = var0.getIterator();
         AttributedCharacterIterator var3 = var1.getIterator();
         char var4 = var2.first();
         char var5 = var3.first();

         int var7;
         for(int var6 = 0; var4 != '\uffff'; var6 = var7) {
            var7 = var2.getRunLimit();
            int var8 = var3.getRunLimit();
            if(var7 != var8) {
               return false;
            }

            Map var9 = var2.getAttributes();
            Map var10 = var3.getAttributes();
            if(!var9.equals(var10)) {
               return false;
            }

            for(int var11 = var6; var11 < var7; ++var11) {
               if(var4 != var5) {
                  return false;
               }

               var4 = var2.next();
               var5 = var3.next();
            }
         }

         return var5 == '\uffff';
      }
   }
}
