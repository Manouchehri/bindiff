package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import java.io.*;
import y.h.*;
import javax.imageio.*;
import java.util.*;
import y.e.*;

public class GraphExporters
{
    private static void configureExportView(final ch ch) {
        final g g = new g();
        g.a(ch.getGraph2D());
        g.a(y.e.g.a);
        g.b(y.e.g.c);
        g.a(ch);
    }
    
    private static void exportGraphPartToImageFileFormat(final bu bu, final c c, final String s) {
        writeGraphToFile(bu, c, s);
    }
    
    private static void exportGraphToImageFileFormat(final bu bu, final c c, final String s, final ch ch) {
        final ch replaceCurrentWithExportView = replaceCurrentWithExportView(bu, ch);
        configureExportView((ch)bu.S());
        try {
            writeGraphToFile(bu, c, s);
        }
        catch (IOException ex) {
            throw ex;
        }
        finally {
            restoreOriginalView(bu, replaceCurrentWithExportView);
        }
    }
    
    private static ch replaceCurrentWithExportView(final bu bu, final ch ch) {
        final ch ch2 = (ch)bu.S();
        ch.setGraph2DRenderer(ch2.getGraph2DRenderer());
        bu.a(ch);
        return ch2;
    }
    
    private static void restoreOriginalView(final bu bu, final ch ch) {
        bu.c(bu.S());
        bu.a(ch);
    }
    
    private static void writeGraphToFile(final bu bu, final c c, final String s) {
        c.a(bu, s);
    }
    
    public static e createPNGOutputHandler() {
        final Iterator<ImageWriter> imageWritersBySuffix = ImageIO.getImageWritersBySuffix("png");
        final ImageWriter imageWriter = imageWritersBySuffix.hasNext() ? imageWritersBySuffix.next() : null;
        return (imageWriter == null) ? null : new d(imageWriter);
    }
    
    public static void exportAllAsGIF(final AbstractZyGraph abstractZyGraph, final String s) {
        final b b = new b();
        b.a(true);
        final ch view = abstractZyGraph.getView();
        exportGraphToImageFileFormat(view.getGraph2D(), b, s, b.a(view.getGraph2D()));
    }
    
    public static void exportAllAsJPEG(final AbstractZyGraph abstractZyGraph, final String s) {
        final f f = new f();
        f.a(true);
        f.a(0.9f);
        final ch view = abstractZyGraph.getView();
        exportGraphToImageFileFormat(view.getGraph2D(), f, s, f.a(view.getGraph2D()));
    }
    
    public static boolean exportAllAsPNG(final AbstractZyGraph abstractZyGraph, final String s) {
        final ch view = abstractZyGraph.getView();
        final e pngOutputHandler = createPNGOutputHandler();
        exportGraphToImageFileFormat(view.getGraph2D(), pngOutputHandler, s, pngOutputHandler.a(view.getGraph2D()));
        return true;
    }
    
    public static boolean exportAllAsSVG(final AbstractZyGraph abstractZyGraph, final String s) {
        final ch view = abstractZyGraph.getView();
        final a.a.a.g g = new a.a.a.g();
        exportGraphToImageFileFormat(view.getGraph2D(), g, s, g.a(view.getGraph2D()));
        return true;
    }
    
    public static void exportPartAsGIF(final AbstractZyGraph abstractZyGraph, final String s) {
        final ch view = abstractZyGraph.getView();
        final b b = new b();
        b.a(true);
        exportGraphPartToImageFileFormat(view.getGraph2D(), b, s);
    }
    
    public static void exportPartAsJPEG(final AbstractZyGraph abstractZyGraph, final String s) {
        final ch view = abstractZyGraph.getView();
        final f f = new f();
        f.a(true);
        f.a(0.9f);
        exportGraphPartToImageFileFormat(view.getGraph2D(), f, s);
    }
    
    public static void exportPartAsPNG(final AbstractZyGraph abstractZyGraph, final String s) {
        final ch view = abstractZyGraph.getView();
        final e pngOutputHandler = createPNGOutputHandler();
        pngOutputHandler.a(true);
        exportGraphPartToImageFileFormat(view.getGraph2D(), pngOutputHandler, s);
    }
    
    public static void exportPartAsSVG(final AbstractZyGraph abstractZyGraph, final String s) {
        exportGraphPartToImageFileFormat(abstractZyGraph.getView().getGraph2D(), new a.a.a.g(), s);
    }
}
