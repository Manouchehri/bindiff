package org.jfree.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class ApplicationFrame extends JFrame implements WindowListener {
   public ApplicationFrame(String var1) {
      super(var1);
      this.addWindowListener(this);
   }

   public void windowClosing(WindowEvent var1) {
      if(var1.getWindow() == this) {
         this.dispose();
         System.exit(0);
      }

   }

   public void windowClosed(WindowEvent var1) {
   }

   public void windowActivated(WindowEvent var1) {
   }

   public void windowDeactivated(WindowEvent var1) {
   }

   public void windowDeiconified(WindowEvent var1) {
   }

   public void windowIconified(WindowEvent var1) {
   }

   public void windowOpened(WindowEvent var1) {
   }
}
