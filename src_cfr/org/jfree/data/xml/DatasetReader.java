/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xml.CategoryDatasetHandler;
import org.jfree.data.xml.PieDatasetHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DatasetReader {
    public static PieDataset readPieDatasetFromXML(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        return DatasetReader.readPieDatasetFromXML(fileInputStream);
    }

    public static PieDataset readPieDatasetFromXML(InputStream inputStream) {
        PieDataset pieDataset = null;
        SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser sAXParser = sAXParserFactory.newSAXParser();
            PieDatasetHandler pieDatasetHandler = new PieDatasetHandler();
            sAXParser.parse(inputStream, (DefaultHandler)pieDatasetHandler);
            return pieDatasetHandler.getDataset();
        }
        catch (SAXException var3_4) {
            System.out.println(var3_4.getMessage());
            return pieDataset;
        }
        catch (ParserConfigurationException var3_5) {
            System.out.println(var3_5.getMessage());
        }
        return pieDataset;
    }

    public static CategoryDataset readCategoryDatasetFromXML(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        return DatasetReader.readCategoryDatasetFromXML(fileInputStream);
    }

    public static CategoryDataset readCategoryDatasetFromXML(InputStream inputStream) {
        CategoryDataset categoryDataset = null;
        SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser sAXParser = sAXParserFactory.newSAXParser();
            CategoryDatasetHandler categoryDatasetHandler = new CategoryDatasetHandler();
            sAXParser.parse(inputStream, (DefaultHandler)categoryDatasetHandler);
            return categoryDatasetHandler.getDataset();
        }
        catch (SAXException var3_4) {
            System.out.println(var3_4.getMessage());
            return categoryDataset;
        }
        catch (ParserConfigurationException var3_5) {
            System.out.println(var3_5.getMessage());
        }
        return categoryDataset;
    }
}

