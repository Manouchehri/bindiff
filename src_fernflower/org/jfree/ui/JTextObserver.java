package org.jfree.ui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.text.JTextComponent;

public final class JTextObserver implements FocusListener {
   private static JTextObserver singleton;

   public static JTextObserver getInstance() {
      if(singleton == null) {
         singleton = new JTextObserver();
      }

      return singleton;
   }

   public void focusGained(FocusEvent var1) {
      if(var1.getSource() instanceof JTextComponent) {
         JTextComponent var2 = (JTextComponent)var1.getSource();
         var2.selectAll();
      }

   }

   public void focusLost(FocusEvent var1) {
      if(var1.getSource() instanceof JTextComponent) {
         JTextComponent var2 = (JTextComponent)var1.getSource();
         var2.select(0, 0);
      }

   }

   public static void addTextComponent(JTextComponent var0) {
      if(singleton == null) {
         singleton = new JTextObserver();
      }

      var0.addFocusListener(singleton);
   }

   public static void removeTextComponent(JTextComponent var0) {
      if(singleton == null) {
         singleton = new JTextObserver();
      }

      var0.removeFocusListener(singleton);
   }
}
