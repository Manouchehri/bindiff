package org.jfree.data.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xml.CategoryDatasetHandler;
import org.jfree.data.xml.PieDatasetHandler;
import org.xml.sax.SAXException;

public class DatasetReader {
   public static PieDataset readPieDatasetFromXML(File var0) {
      FileInputStream var1 = new FileInputStream(var0);
      return readPieDatasetFromXML((InputStream)var1);
   }

   public static PieDataset readPieDatasetFromXML(InputStream var0) {
      PieDataset var1 = null;
      SAXParserFactory var2 = SAXParserFactory.newInstance();

      try {
         SAXParser var3 = var2.newSAXParser();
         PieDatasetHandler var4 = new PieDatasetHandler();
         var3.parse(var0, var4);
         var1 = var4.getDataset();
      } catch (SAXException var5) {
         System.out.println(var5.getMessage());
      } catch (ParserConfigurationException var6) {
         System.out.println(var6.getMessage());
      }

      return var1;
   }

   public static CategoryDataset readCategoryDatasetFromXML(File var0) {
      FileInputStream var1 = new FileInputStream(var0);
      return readCategoryDatasetFromXML((InputStream)var1);
   }

   public static CategoryDataset readCategoryDatasetFromXML(InputStream var0) {
      CategoryDataset var1 = null;
      SAXParserFactory var2 = SAXParserFactory.newInstance();

      try {
         SAXParser var3 = var2.newSAXParser();
         CategoryDatasetHandler var4 = new CategoryDatasetHandler();
         var3.parse(var0, var4);
         var1 = var4.getDataset();
      } catch (SAXException var5) {
         System.out.println(var5.getMessage());
      } catch (ParserConfigurationException var6) {
         System.out.println(var6.getMessage());
      }

      return var1;
   }
}
