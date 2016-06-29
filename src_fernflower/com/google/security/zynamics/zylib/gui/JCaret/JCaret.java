package com.google.security.zynamics.zylib.gui.JCaret;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret$1;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret$InternalListener;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Timer;

public class JCaret {
   private static final int DEFAULT_BLINK_TIME = 600;
   private static final Color DEFAULT_CARET_COLOR;
   private final List m_listeners;
   private final Timer m_caretTimer;
   private boolean m_isCaretVisible;
   private final Color m_caretColor;
   private final JCaret$InternalListener m_listener;

   public JCaret() {
      this(600, DEFAULT_CARET_COLOR);
   }

   public JCaret(Color var1) {
      this(600, var1);
   }

   public JCaret(int var1) {
      this(var1, DEFAULT_CARET_COLOR);
   }

   public JCaret(int var1, Color var2) {
      this.m_listeners = new ArrayList();
      this.m_isCaretVisible = false;
      this.m_caretColor = Color.RED;
      this.m_listener = new JCaret$InternalListener(this, (JCaret$1)null);
      Preconditions.checkArgument(var1 >= 0, "Error: Blink period can\'t be negative");
      Preconditions.checkNotNull(var2, "Error: Caret color can\'t be null");
      this.m_caretTimer = new Timer(var1, this.m_listener);
      this.m_caretTimer.setRepeats(true);
      this.m_caretTimer.start();
   }

   private void notifyListeners() {
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         ICaretListener var2 = (ICaretListener)var1.next();
         var2.caretStatusChanged(this);
      }

   }

   public void addCaretListener(ICaretListener var1) {
      Preconditions.checkNotNull(var1, "Error: Listener can\'t be null");
      if(!this.m_listeners.contains(var1)) {
         this.m_listeners.add(var1);
      }

   }

   public void draw(Graphics var1, int var2, int var3, int var4) {
      Preconditions.checkNotNull(var1, "Error: Graphics context can\'t be null");
      if(this.isVisible()) {
         Color var5 = var1.getColor();
         var1.setColor(this.m_caretColor);
         var1.drawLine(var2, var3, var2, var3 + var4 - 1);
         var1.setColor(var5);
      }

   }

   public boolean isVisible() {
      return this.m_isCaretVisible;
   }

   public void removeListener(ICaretListener var1) {
      this.m_listeners.remove(var1);
   }

   public void setVisible(boolean var1) {
      this.m_isCaretVisible = var1;
      this.notifyListeners();
   }

   public void stop() {
      this.m_caretTimer.stop();
      this.m_caretTimer.removeActionListener(this.m_listener);
      this.setVisible(false);
   }

   // $FF: synthetic method
   static boolean access$102(JCaret var0, boolean var1) {
      return var0.m_isCaretVisible = var1;
   }

   // $FF: synthetic method
   static boolean access$100(JCaret var0) {
      return var0.m_isCaretVisible;
   }

   // $FF: synthetic method
   static void access$200(JCaret var0) {
      var0.notifyListeners();
   }

   static {
      DEFAULT_CARET_COLOR = Color.RED;
   }
}
