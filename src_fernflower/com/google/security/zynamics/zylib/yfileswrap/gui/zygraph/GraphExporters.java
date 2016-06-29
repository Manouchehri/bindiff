package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import y.e.b;
import y.e.c;
import y.e.d;
import y.e.e;
import y.e.f;
import y.e.g;
import y.h.bu;
import y.h.ch;
import y.h.gI;

public class GraphExporters {
   private static void configureExportView(ch var0) {
      g var1 = new g();
      var1.a(var0.getGraph2D());
      var1.a(g.a);
      var1.b(g.c);
      var1.a(var0);
   }

   private static void exportGraphPartToImageFileFormat(bu var0, c var1, String var2) {
      writeGraphToFile(var0, var1, var2);
   }

   private static void exportGraphToImageFileFormat(bu var0, c var1, String var2, ch var3) {
      ch var4 = replaceCurrentWithExportView(var0, var3);
      configureExportView((ch)var0.S());

      try {
         writeGraphToFile(var0, var1, var2);
      } catch (IOException var9) {
         throw var9;
      } finally {
         restoreOriginalView(var0, var4);
      }

   }

   private static ch replaceCurrentWithExportView(bu var0, ch var1) {
      ch var2 = (ch)var0.S();
      var1.setGraph2DRenderer(var2.getGraph2DRenderer());
      var0.a((gI)var1);
      return var2;
   }

   private static void restoreOriginalView(bu var0, ch var1) {
      var0.c(var0.S());
      var0.a((gI)var1);
   }

   private static void writeGraphToFile(bu var0, c var1, String var2) {
      var1.a(var0, var2);
   }

   public static e createPNGOutputHandler() {
      Iterator var0 = ImageIO.getImageWritersBySuffix("png");
      ImageWriter var1 = var0.hasNext()?(ImageWriter)var0.next():null;
      return var1 == null?null:new d(var1);
   }

   public static void exportAllAsGIF(AbstractZyGraph var0, String var1) {
      b var2 = new b();
      var2.a(true);
      ch var3 = var0.getView();
      exportGraphToImageFileFormat(var3.getGraph2D(), var2, var1, var2.a(var3.getGraph2D()));
   }

   public static void exportAllAsJPEG(AbstractZyGraph var0, String var1) {
      f var2 = new f();
      var2.a(true);
      var2.a(0.9F);
      ch var3 = var0.getView();
      exportGraphToImageFileFormat(var3.getGraph2D(), var2, var1, var2.a(var3.getGraph2D()));
   }

   public static boolean exportAllAsPNG(AbstractZyGraph var0, String var1) {
      ch var2 = var0.getView();
      e var3 = createPNGOutputHandler();
      exportGraphToImageFileFormat(var2.getGraph2D(), var3, var1, var3.a(var2.getGraph2D()));
      return true;
   }

   public static boolean exportAllAsSVG(AbstractZyGraph var0, String var1) {
      ch var2 = var0.getView();
      a.a.a.g var3 = new a.a.a.g();
      exportGraphToImageFileFormat(var2.getGraph2D(), var3, var1, var3.a(var2.getGraph2D()));
      return true;
   }

   public static void exportPartAsGIF(AbstractZyGraph var0, String var1) {
      ch var2 = var0.getView();
      b var3 = new b();
      var3.a(true);
      exportGraphPartToImageFileFormat(var2.getGraph2D(), var3, var1);
   }

   public static void exportPartAsJPEG(AbstractZyGraph var0, String var1) {
      ch var2 = var0.getView();
      f var3 = new f();
      var3.a(true);
      var3.a(0.9F);
      exportGraphPartToImageFileFormat(var2.getGraph2D(), var3, var1);
   }

   public static void exportPartAsPNG(AbstractZyGraph var0, String var1) {
      ch var2 = var0.getView();
      e var3 = createPNGOutputHandler();
      var3.a(true);
      exportGraphPartToImageFileFormat(var2.getGraph2D(), var3, var1);
   }

   public static void exportPartAsSVG(AbstractZyGraph var0, String var1) {
      ch var2 = var0.getView();
      a.a.a.g var3 = new a.a.a.g();
      exportGraphPartToImageFileFormat(var2.getGraph2D(), var3, var1);
   }
}
