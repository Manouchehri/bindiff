package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JRegisterView.IMenuProvider;
import com.google.security.zynamics.zylib.gui.JRegisterView.IRegisterModel;
import com.google.security.zynamics.zylib.gui.JRegisterView.JRegisterView$1;
import com.google.security.zynamics.zylib.gui.JRegisterView.JRegisterView$InternalListener;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformationInternal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.math.BigInteger;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.Scrollable;

public class JRegisterView extends JPanel implements Scrollable {
   private static final long serialVersionUID = -918576778293064213L;
   private final Font m_font = new Font(GuiHelper.getMonospaceFont(), 0, 12);
   private final IRegisterModel m_registerModel;
   private int m_longestRegisterName = 0;
   private int m_highlightedRegister = -1;
   private int m_charWidth;
   private final Color m_modifiedColor;
   private final Color m_textColor;
   private static final int m_paddingLeft = 10;
   private final Color m_bgColorEdit;
   private final Color m_bgColorHighlight;
   private int m_editedRegister;
   private final JCaret m_caret;
   private int m_caretPosition;
   private BigInteger m_editValue;
   private final Color m_backgroundColor;
   private final Color m_disabledColor;
   private IMenuProvider m_menuProvider;
   private final JRegisterView$InternalListener m_listener;

   public JRegisterView(IRegisterModel var1) {
      this.m_modifiedColor = Color.RED;
      this.m_textColor = Color.BLACK;
      this.m_bgColorEdit = new Color(16765152);
      this.m_bgColorHighlight = Color.WHITE;
      this.m_editedRegister = -1;
      this.m_caret = new JCaret();
      this.m_caretPosition = 0;
      this.m_editValue = BigInteger.ZERO;
      this.m_backgroundColor = new Color(13421823);
      this.m_disabledColor = Color.GRAY;
      this.m_listener = new JRegisterView$InternalListener(this, (JRegisterView$1)null);
      Preconditions.checkNotNull(var1, "Error: Argument registerModel can\'t be null");
      var1.addListener(this.m_listener);
      this.setFocusable(true);
      this.setOpaque(true);
      this.initializeListeners();
      this.m_registerModel = var1;
      this.updateLongestRegisterName();
      this.setBackground(this.m_backgroundColor);
      this.updatePreferredSize();
   }

   private void drawCaret(Graphics var1) {
      if(this.hasFocus() && this.m_editedRegister != -1) {
         Rectangle var2 = this.getRegisterBounds(this.m_editedRegister);
         int var3 = this.m_font.getSize();
         int var4 = var2.x + this.m_caretPosition * this.m_charWidth + this.m_longestRegisterName * this.m_charWidth + 5 - 1;
         int var5 = var2.y;
         this.m_caret.draw(var1, var4, var5, var3);
      }

   }

   private void drawHighlightedRegister(Graphics var1) {
      if(this.isEnabled()) {
         Rectangle var2;
         if(this.m_editedRegister != -1) {
            var1.setColor(this.m_bgColorEdit);
            var2 = this.getRegisterBounds(this.m_editedRegister);
            var1.fillRect(var2.x, var2.y, var2.width, var2.height);
         } else if(this.m_highlightedRegister != -1) {
            var1.setColor(this.m_bgColorHighlight);
            var2 = this.getRegisterBounds(this.m_highlightedRegister);
            var1.fillRect(var2.x, var2.y, var2.width, var2.height);
         }

      }
   }

   private void drawRegisters(Graphics var1) {
      int var2 = this.m_font.getSize() + 5;
      int var3 = var2;
      int var4 = this.m_font.getSize();
      int var5 = 0;
      RegisterInformationInternal[] var6 = this.m_registerModel.getRegisterInformation();
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         RegisterInformationInternal var9 = var6[var8];
         if(!this.isEnabled()) {
            var1.setColor(this.m_disabledColor);
         } else {
            var1.setColor(!var9.isModified() && var5 != this.m_editedRegister?this.m_textColor:this.m_modifiedColor);
         }

         var1.drawString(var9.getRegisterName(), 10, var3);
         BigInteger var10 = (var5 == this.m_editedRegister?this.m_editValue:var9.getValue()).and(var9.getRegisterSize() == 8?BigInteger.valueOf(Long.MAX_VALUE):BigInteger.valueOf(4294967295L));
         String var11;
         if(var9.getRegisterSize() != 0) {
            int var13 = 2 * var9.getRegisterSize();
            String var12 = (new StringBuilder(14)).append("%0").append(var13).append("X").toString();
            var11 = String.format(var12, new Object[]{var10});
         } else {
            var11 = String.valueOf(var10.and(BigInteger.ONE));
         }

         var1.drawString(var11, 15 + this.m_charWidth * this.m_longestRegisterName, var3);
         ++var5;
         var3 += var4;
      }

   }

   private void enterEditMode(int var1) {
      this.requestFocusInWindow();
      this.m_caret.setVisible(true);
      this.m_editedRegister = var1;
      this.m_caretPosition = 0;
      this.m_editValue = this.m_registerModel.getRegisterInformation(var1).getValue();
      this.repaint();
   }

   private Rectangle getRegisterBounds(int var1) {
      RegisterInformationInternal var2 = this.m_registerModel.getRegisterInformation(var1);
      int var4 = 7 + var1 * this.m_font.getSize();
      int var5 = 5 + this.m_charWidth * (this.m_longestRegisterName + var2.getRegisterSize() * 2);
      int var6 = this.m_font.getSize() - 1;
      return new Rectangle(10, var4, var5, var6);
   }

   private int getRegisterNumber(int var1, int var2) {
      int var3 = this.m_font.getSize();
      if(var2 >= 7 && var2 <= 7 + var3 * this.m_registerModel.getNumberOfRegisters()) {
         int var4 = (var2 - 7) / var3;
         var4 = Math.min(var4, this.m_registerModel.getNumberOfRegisters() - 1);
         if(var4 == -1) {
            return -1;
         }

         RegisterInformationInternal var5 = this.m_registerModel.getRegisterInformation(var4);
         int var6 = var5.getRegisterSize() == 0?1:var5.getRegisterSize() * 2;
         int var7 = 15 + this.m_charWidth * (this.m_longestRegisterName + var6);
         if(var1 >= 10 && var1 <= var7) {
            return var4;
         }
      }

      return -1;
   }

   private void initializeListeners() {
      this.addMouseListener(this.m_listener);
      this.addMouseMotionListener(this.m_listener);
      this.addKeyListener(this.m_listener);
      this.addFocusListener(this.m_listener);
      this.m_caret.addCaretListener(this.m_listener);
   }

   private void leaveEditMode(boolean var1) {
      if(var1) {
         RegisterInformationInternal var2 = this.m_registerModel.getRegisterInformation(this.m_editedRegister);
         if(!Objects.equals(this.m_editValue, var2.getValue())) {
            this.beginRegisterUpdate();
            this.m_registerModel.setValue(var2.getRegisterName(), this.m_editValue);
            this.endRegisterUpdate();
         }
      }

      this.m_caret.setVisible(false);
      this.m_editedRegister = -1;
      this.m_caretPosition = 0;
      this.repaint();
   }

   private void updateLongestRegisterName() {
      this.m_longestRegisterName = Integer.MIN_VALUE;
      RegisterInformationInternal[] var1 = this.m_registerModel.getRegisterInformation();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         RegisterInformationInternal var4 = var1[var3];
         if(var4.getRegisterName().length() > this.m_longestRegisterName) {
            this.m_longestRegisterName = var4.getRegisterName().length();
         }
      }

   }

   private void updatePreferredSize() {
      int var1 = this.m_font.getSize() + 5;
      int var2 = this.m_font.getSize();
      int var3 = var1 + this.m_registerModel.getNumberOfRegisters() * var2;
      this.setPreferredSize(new Dimension(200, var3));
      this.revalidate();
      this.updateUI();
   }

   protected void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      var1.setFont(this.m_font);
      this.m_charWidth = (int)var1.getFontMetrics().getStringBounds("0", var1).getWidth();
      if(this.m_registerModel != null) {
         this.drawHighlightedRegister(var1);
         this.drawRegisters(var1);
         if(this.m_caret.isVisible()) {
            this.drawCaret(var1);
         }
      }

   }

   public void beginRegisterUpdate() {
      RegisterInformationInternal[] var1 = this.m_registerModel.getRegisterInformation();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         RegisterInformationInternal var4 = var1[var3];
         var4.setModified(false);
      }

   }

   public void dispose() {
      this.removeMouseListener(this.m_listener);
      this.removeMouseMotionListener(this.m_listener);
      this.removeKeyListener(this.m_listener);
      this.removeFocusListener(this.m_listener);
      this.m_caret.removeListener(this.m_listener);
      this.m_caret.stop();
   }

   public void endRegisterUpdate() {
      this.repaint();
   }

   public Dimension getPreferredScrollableViewportSize() {
      return this.getPreferredSize();
   }

   public int getScrollableBlockIncrement(Rectangle var1, int var2, int var3) {
      return 5 * this.m_font.getSize();
   }

   public boolean getScrollableTracksViewportHeight() {
      return false;
   }

   public boolean getScrollableTracksViewportWidth() {
      return false;
   }

   public int getScrollableUnitIncrement(Rectangle var1, int var2, int var3) {
      return this.m_font.getSize();
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.repaint();
   }

   public void setMenuProvider(IMenuProvider var1) {
      this.m_menuProvider = var1;
   }

   // $FF: synthetic method
   static int access$100(JRegisterView var0) {
      return var0.m_editedRegister;
   }

   // $FF: synthetic method
   static void access$200(JRegisterView var0, boolean var1) {
      var0.leaveEditMode(var1);
   }

   // $FF: synthetic method
   static int access$300(JRegisterView var0) {
      return var0.m_caretPosition;
   }

   // $FF: synthetic method
   static IRegisterModel access$400(JRegisterView var0) {
      return var0.m_registerModel;
   }

   // $FF: synthetic method
   static int access$308(JRegisterView var0) {
      return var0.m_caretPosition++;
   }

   // $FF: synthetic method
   static JCaret access$500(JRegisterView var0) {
      return var0.m_caret;
   }

   // $FF: synthetic method
   static int access$310(JRegisterView var0) {
      return var0.m_caretPosition--;
   }

   // $FF: synthetic method
   static int access$600(JRegisterView var0) {
      return var0.m_highlightedRegister;
   }

   // $FF: synthetic method
   static void access$700(JRegisterView var0, int var1) {
      var0.enterEditMode(var1);
   }

   // $FF: synthetic method
   static BigInteger access$802(JRegisterView var0, BigInteger var1) {
      return var0.m_editValue = var1;
   }

   // $FF: synthetic method
   static BigInteger access$800(JRegisterView var0) {
      return var0.m_editValue;
   }

   // $FF: synthetic method
   static int access$900(JRegisterView var0, int var1, int var2) {
      return var0.getRegisterNumber(var1, var2);
   }

   // $FF: synthetic method
   static IMenuProvider access$1000(JRegisterView var0) {
      return var0.m_menuProvider;
   }

   // $FF: synthetic method
   static int access$602(JRegisterView var0, int var1) {
      return var0.m_highlightedRegister = var1;
   }

   // $FF: synthetic method
   static void access$1100(JRegisterView var0) {
      var0.updatePreferredSize();
   }

   // $FF: synthetic method
   static void access$1200(JRegisterView var0) {
      var0.updateLongestRegisterName();
   }
}
