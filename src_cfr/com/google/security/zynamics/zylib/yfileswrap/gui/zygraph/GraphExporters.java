/*
 * Decompiled with CFR 0_115.
 */
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
import y.h.cd;
import y.h.ch;
import y.h.gI;

public class GraphExporters {
    private static void configureExportView(ch ch2) {
        g g2 = new g();
        g2.a(ch2.getGraph2D());
        g2.a(g.a);
        g2.b(g.c);
        g2.a(ch2);
    }

    private static void exportGraphPartToImageFileFormat(bu bu2, c c2, String string) {
        GraphExporters.writeGraphToFile(bu2, c2, string);
    }

    private static void exportGraphToImageFileFormat(bu bu2, c c2, String string, ch ch2) {
        ch ch3 = GraphExporters.replaceCurrentWithExportView(bu2, ch2);
        GraphExporters.configureExportView((ch)bu2.S());
        try {
            GraphExporters.writeGraphToFile(bu2, c2, string);
            return;
        }
        catch (IOException var5_5) {
            throw var5_5;
        }
        finally {
            GraphExporters.restoreOriginalView(bu2, ch3);
        }
    }

    private static ch replaceCurrentWithExportView(bu bu2, ch ch2) {
        ch ch3 = (ch)bu2.S();
        ch2.setGraph2DRenderer(ch3.getGraph2DRenderer());
        bu2.a(ch2);
        return ch3;
    }

    private static void restoreOriginalView(bu bu2, ch ch2) {
        bu2.c(bu2.S());
        bu2.a(ch2);
    }

    private static void writeGraphToFile(bu bu2, c c2, String string) {
        c2.a(bu2, string);
    }

    public static e createPNGOutputHandler() {
        Iterator<ImageWriter> iterator = ImageIO.getImageWritersBySuffix("png");
        if (!iterator.hasNext()) return null;
        ImageWriter imageWriter = iterator.next();
        ImageWriter imageWriter2 = imageWriter;
        if (imageWriter2 == null) {
            return null;
        }
        d d2 = new d(imageWriter2);
        return d2;
    }

    public static void exportAllAsGIF(AbstractZyGraph abstractZyGraph, String string) {
        b b2 = new b();
        b2.a(true);
        ch ch2 = abstractZyGraph.getView();
        GraphExporters.exportGraphToImageFileFormat(ch2.getGraph2D(), b2, string, b2.a(ch2.getGraph2D()));
    }

    public static void exportAllAsJPEG(AbstractZyGraph abstractZyGraph, String string) {
        f f2 = new f();
        f2.a(true);
        f2.a(0.9f);
        ch ch2 = abstractZyGraph.getView();
        GraphExporters.exportGraphToImageFileFormat(ch2.getGraph2D(), f2, string, f2.a(ch2.getGraph2D()));
    }

    public static boolean exportAllAsPNG(AbstractZyGraph abstractZyGraph, String string) {
        ch ch2 = abstractZyGraph.getView();
        e e2 = GraphExporters.createPNGOutputHandler();
        GraphExporters.exportGraphToImageFileFormat(ch2.getGraph2D(), e2, string, e2.a(ch2.getGraph2D()));
        return true;
    }

    public static boolean exportAllAsSVG(AbstractZyGraph abstractZyGraph, String string) {
        ch ch2 = abstractZyGraph.getView();
        a.a.a.g g2 = new a.a.a.g();
        GraphExporters.exportGraphToImageFileFormat(ch2.getGraph2D(), g2, string, g2.a(ch2.getGraph2D()));
        return true;
    }

    public static void exportPartAsGIF(AbstractZyGraph abstractZyGraph, String string) {
        ch ch2 = abstractZyGraph.getView();
        b b2 = new b();
        b2.a(true);
        GraphExporters.exportGraphPartToImageFileFormat(ch2.getGraph2D(), b2, string);
    }

    public static void exportPartAsJPEG(AbstractZyGraph abstractZyGraph, String string) {
        ch ch2 = abstractZyGraph.getView();
        f f2 = new f();
        f2.a(true);
        f2.a(0.9f);
        GraphExporters.exportGraphPartToImageFileFormat(ch2.getGraph2D(), f2, string);
    }

    public static void exportPartAsPNG(AbstractZyGraph abstractZyGraph, String string) {
        ch ch2 = abstractZyGraph.getView();
        e e2 = GraphExporters.createPNGOutputHandler();
        e2.a(true);
        GraphExporters.exportGraphPartToImageFileFormat(ch2.getGraph2D(), e2, string);
    }

    public static void exportPartAsSVG(AbstractZyGraph abstractZyGraph, String string) {
        ch ch2 = abstractZyGraph.getView();
        a.a.a.g g2 = new a.a.a.g();
        GraphExporters.exportGraphPartToImageFileFormat(ch2.getGraph2D(), g2, string);
    }
}

