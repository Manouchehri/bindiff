package com.google.security.zynamics.zylib.strings;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CircularStringBuffer {
   private final Queue m_buffer = new LinkedList();
   private final int m_maxSize;

   public CircularStringBuffer(int var1) {
      this.m_maxSize = var1;
   }

   private void addToBuffer(String[] var1) {
      for(int var3 = 0; var3 < var1.length; ++var3) {
         while(this.m_maxSize - this.m_buffer.size() <= 0) {
            this.m_buffer.remove();
         }

         this.m_buffer.add(var1[0]);
      }

   }

   public void add(String var1) {
      String[] var2 = var1.split("\n");
      if(var2.length > 0) {
         this.addToBuffer(var2);
      } else {
         this.addToBuffer(new String[]{var1});
      }

   }

   public int getSize() {
      return this.m_buffer.size();
   }

   public String getText() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.m_buffer.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.append(var3);
         var1.append('\n');
      }

      return var1.toString();
   }
}
