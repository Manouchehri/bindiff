package org.jfree.data.xml;

import java.util.Stack;
import org.jfree.data.xml.DatasetTags;
import org.xml.sax.helpers.DefaultHandler;

public class RootHandler extends DefaultHandler implements DatasetTags {
   private Stack subHandlers = new Stack();

   public Stack getSubHandlers() {
      return this.subHandlers;
   }

   public void characters(char[] var1, int var2, int var3) {
      DefaultHandler var4 = this.getCurrentHandler();
      if(var4 != this) {
         var4.characters(var1, var2, var3);
      }

   }

   public DefaultHandler getCurrentHandler() {
      Object var1 = this;
      if(this.subHandlers != null && this.subHandlers.size() > 0) {
         Object var2 = this.subHandlers.peek();
         if(var2 != null) {
            var1 = (DefaultHandler)var2;
         }
      }

      return (DefaultHandler)var1;
   }

   public void pushSubHandler(DefaultHandler var1) {
      this.subHandlers.push(var1);
   }

   public DefaultHandler popSubHandler() {
      return (DefaultHandler)this.subHandlers.pop();
   }
}
