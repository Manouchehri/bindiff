package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

enum FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator implements FuturesGetChecked$GetCheckedTypeValidator {
   INSTANCE;

   private static final Set validClasses;

   public void validateClass(Class var1) {
      Iterator var2 = validClasses.iterator();

      WeakReference var3;
      do {
         if(!var2.hasNext()) {
            FuturesGetChecked.checkExceptionClassValidity(var1);
            if(validClasses.size() > 1000) {
               validClasses.clear();
            }

            validClasses.add(new WeakReference(var1));
            return;
         }

         var3 = (WeakReference)var2.next();
      } while(!var1.equals(var3.get()));

   }

   static {
      validClasses = new CopyOnWriteArraySet();
   }
}
