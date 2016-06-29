/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.batik.svggen.ExtensionHandler
 *  org.apache.batik.svggen.SVGGraphics2D
 */
package a.a.a;

import a.a.a.b;
import org.apache.batik.svggen.ExtensionHandler;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.Document;

class h
extends SVGGraphics2D {
    h(Document document) {
        super(document);
        this.setExtensionHandler((ExtensionHandler)new b());
    }
}

