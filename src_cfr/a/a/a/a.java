/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.batik.svggen.SVGStylingAttributes
 *  org.apache.batik.svggen.SVGSyntax
 */
package a.a.a;

import java.util.ArrayList;
import java.util.Set;
import org.apache.batik.svggen.SVGStylingAttributes;
import org.apache.batik.svggen.SVGSyntax;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

final class a
implements SVGSyntax {
    public static void a(Node node, boolean bl2) {
        Object object;
        int n2;
        Object object2;
        NamedNodeMap namedNodeMap = node.getAttributes();
        if (namedNodeMap != null) {
            int n3;
            object2 = (Element)node;
            StringBuffer stringBuffer = new StringBuffer();
            n2 = namedNodeMap.getLength();
            object = new ArrayList(n2);
            for (n3 = 0; n3 < n2; ++n3) {
                Attr attr = (Attr)namedNodeMap.item(n3);
                String string = attr.getName();
                if (!SVGStylingAttributes.set.contains(string)) continue;
                stringBuffer.append(string);
                stringBuffer.append(":");
                String string2 = attr.getValue();
                stringBuffer.append(string2);
                if (bl2 && "font-size".equals(string) && Character.isDigit(string2.charAt(string2.length() - 1))) {
                    stringBuffer.append("px");
                }
                stringBuffer.append(";");
                stringBuffer.append(" ");
                object.add(attr.getName());
            }
            if (stringBuffer.length() > 0) {
                object2.setAttributeNS(null, "style", stringBuffer.toString().trim());
                int n4 = object.size();
                for (n3 = 0; n3 < n4; ++n3) {
                    object2.removeAttribute((String)object.get(n3));
                }
            }
        }
        object2 = node.getChildNodes();
        int n5 = object2.getLength();
        n2 = 0;
        while (n2 < n5) {
            object = object2.item(n2);
            a.a((Node)object, bl2);
            ++n2;
        }
    }
}

