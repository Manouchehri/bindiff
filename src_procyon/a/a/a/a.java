package a.a.a;

import java.util.*;
import org.apache.batik.svggen.*;
import org.w3c.dom.*;

final class a implements SVGSyntax
{
    public static void a(final Node node, final boolean b) {
        final NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            final Element element = (Element)node;
            final StringBuffer sb = new StringBuffer();
            final int length = attributes.getLength();
            final ArrayList list = new ArrayList<String>(length);
            for (int i = 0; i < length; ++i) {
                final Attr attr = (Attr)attributes.item(i);
                final String name = attr.getName();
                if (SVGStylingAttributes.set.contains(name)) {
                    sb.append(name);
                    sb.append(":");
                    final String value = attr.getValue();
                    sb.append(value);
                    if (b && "font-size".equals(name) && Character.isDigit(value.charAt(value.length() - 1))) {
                        sb.append("px");
                    }
                    sb.append(";");
                    sb.append(" ");
                    list.add(attr.getName());
                }
            }
            if (sb.length() > 0) {
                element.setAttributeNS(null, "style", sb.toString().trim());
                for (int j = 0; j < list.size(); ++j) {
                    element.removeAttribute(list.get(j));
                }
            }
        }
        final NodeList childNodes = node.getChildNodes();
        for (int length2 = childNodes.getLength(), k = 0; k < length2; ++k) {
            a(childNodes.item(k), b);
        }
    }
}
