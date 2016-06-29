package org.jfree.chart.servlet;

import org.jfree.chart.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class ServletUtilities
{
    private static String tempFilePrefix;
    private static String tempOneTimeFilePrefix;
    
    public static String getTempFilePrefix() {
        return ServletUtilities.tempFilePrefix;
    }
    
    public static void setTempFilePrefix(final String tempFilePrefix) {
        if (tempFilePrefix == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        ServletUtilities.tempFilePrefix = tempFilePrefix;
    }
    
    public static String getTempOneTimeFilePrefix() {
        return ServletUtilities.tempOneTimeFilePrefix;
    }
    
    public static void setTempOneTimeFilePrefix(final String tempOneTimeFilePrefix) {
        if (tempOneTimeFilePrefix == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        ServletUtilities.tempOneTimeFilePrefix = tempOneTimeFilePrefix;
    }
    
    public static String saveChartAsPNG(final JFreeChart freeChart, final int n, final int n2, final HttpSession httpSession) {
        return saveChartAsPNG(freeChart, n, n2, null, httpSession);
    }
    
    public static String saveChartAsPNG(final JFreeChart freeChart, final int n, final int n2, final ChartRenderingInfo chartRenderingInfo, final HttpSession httpSession) {
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        createTempDir();
        String s = ServletUtilities.tempFilePrefix;
        if (httpSession == null) {
            s = ServletUtilities.tempOneTimeFilePrefix;
        }
        final File tempFile = File.createTempFile(s, ".png", new File(System.getProperty("java.io.tmpdir")));
        ChartUtilities.saveChartAsPNG(tempFile, freeChart, n, n2, chartRenderingInfo);
        if (httpSession != null) {
            registerChartForDeletion(tempFile, httpSession);
        }
        return tempFile.getName();
    }
    
    public static String saveChartAsJPEG(final JFreeChart freeChart, final int n, final int n2, final HttpSession httpSession) {
        return saveChartAsJPEG(freeChart, n, n2, null, httpSession);
    }
    
    public static String saveChartAsJPEG(final JFreeChart freeChart, final int n, final int n2, final ChartRenderingInfo chartRenderingInfo, final HttpSession httpSession) {
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        createTempDir();
        String s = ServletUtilities.tempFilePrefix;
        if (httpSession == null) {
            s = ServletUtilities.tempOneTimeFilePrefix;
        }
        final File tempFile = File.createTempFile(s, ".jpeg", new File(System.getProperty("java.io.tmpdir")));
        ChartUtilities.saveChartAsJPEG(tempFile, freeChart, n, n2, chartRenderingInfo);
        if (httpSession != null) {
            registerChartForDeletion(tempFile, httpSession);
        }
        return tempFile.getName();
    }
    
    protected static void createTempDir() {
        final String property = System.getProperty("java.io.tmpdir");
        if (property == null) {
            throw new RuntimeException("Temporary directory system property (java.io.tmpdir) is null.");
        }
        final File file = new File(property);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    
    protected static void registerChartForDeletion(final File file, final HttpSession httpSession) {
        if (httpSession != null) {
            ChartDeleter chartDeleter = (ChartDeleter)httpSession.getAttribute("JFreeChart_Deleter");
            if (chartDeleter == null) {
                chartDeleter = new ChartDeleter();
                httpSession.setAttribute("JFreeChart_Deleter", (Object)chartDeleter);
            }
            chartDeleter.addChart(file.getName());
        }
        else {
            System.out.println("Session is null - chart will not be deleted");
        }
    }
    
    public static void sendTempFile(final String s, final HttpServletResponse httpServletResponse) {
        sendTempFile(new File(System.getProperty("java.io.tmpdir"), s), httpServletResponse);
    }
    
    public static void sendTempFile(final File file, final HttpServletResponse httpServletResponse) {
        String s = null;
        final String name = file.getName();
        if (name.length() > 5) {
            if (name.substring(name.length() - 5, name.length()).equals(".jpeg")) {
                s = "image/jpeg";
            }
            else if (name.substring(name.length() - 4, name.length()).equals(".png")) {
                s = "image/png";
            }
        }
        sendTempFile(file, httpServletResponse, s);
    }
    
    public static void sendTempFile(final File file, final HttpServletResponse httpServletResponse, final String s) {
        if (file.exists()) {
            final BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            if (s != null) {
                httpServletResponse.setHeader("Content-Type", s);
            }
            httpServletResponse.setHeader("Content-Length", String.valueOf(file.length()));
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            httpServletResponse.setHeader("Last-Modified", simpleDateFormat.format(new Date(file.lastModified())));
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)httpServletResponse.getOutputStream());
            final byte[] array = new byte[1024];
            int i = 0;
            while (i == 0) {
                final int read = bufferedInputStream.read(array);
                if (read == -1) {
                    i = 1;
                }
                else {
                    bufferedOutputStream.write(array, 0, read);
                }
            }
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            return;
        }
        throw new FileNotFoundException(file.getAbsolutePath());
    }
    
    public static String searchReplace(final String s, final String s2, final String s3) {
        final int index = s.indexOf(s2);
        if (index == -1) {
            return s;
        }
        String s4 = "" + s.substring(0, index) + s3;
        if (index + s2.length() < s.length()) {
            s4 += searchReplace(s.substring(index + s2.length()), s2, s3);
        }
        return s4;
    }
    
    static {
        ServletUtilities.tempFilePrefix = "jfreechart-";
        ServletUtilities.tempOneTimeFilePrefix = "jfreechart-onetime-";
    }
}
