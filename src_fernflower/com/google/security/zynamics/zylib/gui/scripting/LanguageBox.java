package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingLanguage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.swing.JComboBox;

public class LanguageBox extends JComboBox {
   public LanguageBox(ScriptEngineManager var1) {
      this.fillLanguageBox(var1);
   }

   private void fillLanguageBox(ScriptEngineManager var1) {
      List var2 = var1.getEngineFactories();
      ArrayList var3 = new ArrayList();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         ScriptEngineFactory var5 = (ScriptEngineFactory)var4.next();
         if(var5.getLanguageName().equals("python")) {
            var3.add(new ScriptingLanguage(var5.getLanguageName(), var5.getLanguageVersion()));
         }
      }

      Collections.sort(var3);
      var4 = var3.iterator();

      while(var4.hasNext()) {
         ScriptingLanguage var6 = (ScriptingLanguage)var4.next();
         this.addItem(var6);
      }

   }

   public String getSelectedLanguage() {
      return this.getSelectedItem() != null?((ScriptingLanguage)this.getSelectedItem()).getName():null;
   }

   public void setSelectedLanguage(String var1) {
      for(int var2 = 0; var2 < this.getModel().getSize(); ++var2) {
         String var3 = ((ScriptingLanguage)this.getItemAt(var2)).toString();
         if(var3.equals(var1)) {
            this.setSelectedIndex(var2);
            return;
         }
      }

   }
}
