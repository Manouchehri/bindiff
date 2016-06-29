package a.a.a;

import java.util.ArrayList;
import org.apache.batik.svggen.SVGStylingAttributes;
import org.apache.batik.svggen.SVGSyntax;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

final class a implements SVGSyntax {
   public static void a(Node var0, boolean var1) {
      NamedNodeMap var2 = var0.getAttributes();
      int var5;
      if(var2 != null) {
         Element var3 = (Element)var0;
         StringBuffer var4 = new StringBuffer();
         var5 = var2.getLength();
         ArrayList var6 = new ArrayList(var5);

         int var7;
         for(var7 = 0; var7 < var5; ++var7) {
            Attr var8 = (Attr)var2.item(var7);
            String var9 = var8.getName();
            if(SVGStylingAttributes.set.contains(var9)) {
               var4.append(var9);
               var4.append(":");
               String var10 = var8.getValue();
               var4.append(var10);
               if(var1 && "font-size".equals(var9) && Character.isDigit(var10.charAt(var10.length() - 1))) {
                  var4.append("px");
               }

               var4.append(";");
               var4.append(" ");
               var6.add(var8.getName());
            }
         }

         if(var4.length() > 0) {
            var3.setAttributeNS((String)null, "style", var4.toString().trim());
            var7 = 0;

            for(int var14 = var6.size(); var7 < var14; ++var7) {
               var3.removeAttribute((String)var6.get(var7));
            }
         }
      }

      NodeList var11 = var0.getChildNodes();
      int var12 = var11.getLength();

      for(var5 = 0; var5 < var12; ++var5) {
         Node var13 = var11.item(var5);
         a(var13, var1);
      }

   }
}
