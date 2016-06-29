package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.Tokenizer;

import com.google.common.base.Preconditions;

public class CMultiCommentLineTokenizer {
   private final String m_text;
   private final String m_delimiter;
   private int m_pointer = 0;

   public CMultiCommentLineTokenizer(String var1, String var2) {
      this.m_delimiter = (String)Preconditions.checkNotNull(var2, "Error: Text delimiter can\'t be null.");
      Preconditions.checkArgument(!"".equals(var2), "Error: Text delimiter can\'t be empty.");
      this.m_text = (String)Preconditions.checkNotNull(var1, "Error: Text can\'t be null.");
   }

   public boolean hasMoreTokens() {
      return this.m_pointer < this.m_text.length();
   }

   public String nextToken() {
      if(this.m_pointer >= this.m_text.length()) {
         return null;
      } else {
         int var1 = this.m_pointer;
         int var2 = this.m_text.indexOf(this.m_delimiter, var1) + 1;
         if(var2 == 0) {
            var2 = this.m_text.length();
         }

         this.m_pointer = var2;
         String var3 = this.m_text.substring(var1, var2);
         if(!this.hasMoreTokens() && !var3.isEmpty() && !var3.endsWith("\r")) {
            var3 = String.valueOf(var3).concat("\r");
         }

         return var3;
      }
   }
}
