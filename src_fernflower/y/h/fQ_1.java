package y.h;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import y.h.fR;
import y.h.fS;
import y.h.ga;
import y.h.gb;
import y.h.gc;

public class fQ extends JPanel {
   private Printable g;
   private PageFormat b;
   private gb h;
   private PrinterJob c;
   private JScrollPane e;
   private JComboBox d;
   private JPanel f;
   public static final String ZOOM_TO_FIT = "ZOOM_TO_FIT";
   public static final String ZOOM_TO_FIT_WIDTH = "ZOOM_TO_FIT_WIDTH";
   public static final String PAGE_FORMAT_ACTION = "PAGE_FORMAT_ACTION";
   public static final String PRINT_ACTION = "PRINT_ACTION";
   public static final String ZOOM_IN_ACTION = "ZOOM_IN_ACTION";
   public static final String ZOOM_OUT_ACTION = "ZOOM_OUT_ACTION";
   static ResourceBundle i;
   static Class class$y$view$PrintPreviewPanel;

   public fQ(PrinterJob var1, Printable var2, int var3, int var4, PageFormat var5) {
      super(new BorderLayout());
      this.c = var1;
      var1.setPrintable(var2, var5);
      this.g = var2;
      this.b = var5;
      this.d = new JComboBox(new Object[]{this.getString("ZOOM_TO_FIT"), this.getString("ZOOM_TO_FIT_WIDTH"), "400%", "300%", "200%", "100%", "90%", "80%", "70%", "60%", "50%", "25%", "10%"});
      this.d.setEditable(true);
      this.f = new JPanel(new FlowLayout(3));
      ga var6 = new ga(this);
      this.initAction(var6, "PAGE_FORMAT_ACTION");
      this.f.add(new JButton(var6));
      gc var7 = new gc(this);
      this.initAction(var7, "PRINT_ACTION");
      this.f.add(new JButton(var7));
      JPanel var8 = new JPanel(new BorderLayout());
      this.h = new gb(this, 0, var3, var4, 500);
      Action var9 = this.h.c();
      this.initAction(var9, "ZOOM_IN_ACTION");
      Action var10 = this.h.d();
      this.initAction(var10, "ZOOM_OUT_ACTION");
      this.f.add(new JButton(var9));
      this.f.add(new JButton(var10));
      var8.setBorder(BorderFactory.createEtchedBorder());
      var8.add(this.e = new JScrollPane(this.h), "Center");
      this.e.setPreferredSize(new Dimension(400, 700));
      this.h.addPropertyChangeListener("ZOOM", new fR(this));
      this.d.addActionListener(new fS(this));
      this.h.e(250);
      this.f.add(this.d);
      this.add(var8, "Center");
      this.add(this.f, "North");
   }

   public PageFormat getPageFormat() {
      return this.b;
   }

   public void setPageFormat(PageFormat var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         if(var1 != this.b) {
            this.b = var1;
            this.h.a();
            this.repaint();
         }

      }
   }

   protected String getString(String var1) {
      if(i != null) {
         try {
            return i.getString(var1);
         } catch (MissingResourceException var3) {
            ;
         }
      }

      return var1;
   }

   public void setPages(int var1, int var2, int var3) {
      this.h.a(var1);
      this.h.b(var2);
      this.h.c(var3);
      this.h.a();
   }

   public void zoomToFit() {
      this.h.e(this.h.a(this.e.getViewport().getWidth() - 3, this.e.getViewport().getHeight() - 3));
   }

   public void zoomToFitWidth() {
      this.h.e(this.h.d(this.e.getViewport().getWidth() - 20));
   }

   public void addControlComponent(JComponent var1) {
      this.f.add(var1);
   }

   protected void initAction(Action var1, String var2) {
      var1.putValue("ActionCommandKey", var2);
      var1.putValue("Name", this.getString(var2 + ".NAME"));
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static JComboBox access$000(fQ var0) {
      return var0.d;
   }

   static gb access$100(fQ var0) {
      return var0.h;
   }

   static PageFormat access$300(fQ var0) {
      return var0.b;
   }

   static PrinterJob access$400(fQ var0) {
      return var0.c;
   }

   static Printable access$800(fQ var0) {
      return var0.g;
   }

   static {
      try {
         i = ResourceBundle.getBundle((class$y$view$PrintPreviewPanel == null?(class$y$view$PrintPreviewPanel = class$("y.h.fQ")):class$y$view$PrintPreviewPanel).getName());
      } catch (Exception var1) {
         ;
      }

   }
}
