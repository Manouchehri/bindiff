package org.jfree.data.xml;

import org.jfree.data.general.*;
import java.io.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import org.jfree.data.category.*;

public class DatasetReader
{
    public static PieDataset readPieDatasetFromXML(final File file) {
        return readPieDatasetFromXML(new FileInputStream(file));
    }
    
    public static PieDataset readPieDatasetFromXML(final InputStream inputStream) {
        PieDataset dataset = null;
        final SAXParserFactory instance = SAXParserFactory.newInstance();
        try {
            final SAXParser saxParser = instance.newSAXParser();
            final PieDatasetHandler pieDatasetHandler = new PieDatasetHandler();
            saxParser.parse(inputStream, pieDatasetHandler);
            dataset = pieDatasetHandler.getDataset();
        }
        catch (SAXException ex) {
            System.out.println(ex.getMessage());
        }
        catch (ParserConfigurationException ex2) {
            System.out.println(ex2.getMessage());
        }
        return dataset;
    }
    
    public static CategoryDataset readCategoryDatasetFromXML(final File file) {
        return readCategoryDatasetFromXML(new FileInputStream(file));
    }
    
    public static CategoryDataset readCategoryDatasetFromXML(final InputStream inputStream) {
        CategoryDataset dataset = null;
        final SAXParserFactory instance = SAXParserFactory.newInstance();
        try {
            final SAXParser saxParser = instance.newSAXParser();
            final CategoryDatasetHandler categoryDatasetHandler = new CategoryDatasetHandler();
            saxParser.parse(inputStream, categoryDatasetHandler);
            dataset = categoryDatasetHandler.getDataset();
        }
        catch (SAXException ex) {
            System.out.println(ex.getMessage());
        }
        catch (ParserConfigurationException ex2) {
            System.out.println(ex2.getMessage());
        }
        return dataset;
    }
}
