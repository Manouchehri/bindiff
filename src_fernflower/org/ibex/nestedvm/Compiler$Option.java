package org.ibex.nestedvm;

import java.lang.reflect.Field;
import org.ibex.nestedvm.Compiler;

class Compiler$Option {
   private Field field;
   private final Compiler this$0;

   public Compiler$Option(Compiler var1, String var2) {
      this.this$0 = var1;
      this.field = var2 == null?null:(Compiler.class$org$ibex$nestedvm$Compiler == null?(Compiler.class$org$ibex$nestedvm$Compiler = Compiler.class$("org.ibex.nestedvm.Compiler")):Compiler.class$org$ibex$nestedvm$Compiler).getDeclaredField(var2);
   }

   public void set(Object var1) {
      if(this.field != null) {
         try {
            this.field.set(this.this$0, var1);
         } catch (IllegalAccessException var3) {
            System.err.println(var3);
         }

      }
   }

   public Object get() {
      if(this.field == null) {
         return null;
      } else {
         try {
            return this.field.get(this.this$0);
         } catch (IllegalAccessException var2) {
            System.err.println(var2);
            return null;
         }
      }
   }

   public Class getType() {
      return this.field == null?null:this.field.getType();
   }
}
