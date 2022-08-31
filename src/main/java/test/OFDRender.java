package test;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * OFD页面渲染
 */
public class OFDRender {


    /**
     * user space units per millimeter
     */
    private static final float POINTS_PER_MM = 1 / (10 * 2.54f) * 72;

    public static void convertPdfToOfd(InputStream input, OutputStream output) throws IOException {
        try (PDDocument doc = PDDocument.load(input)) {
            OFDCreator ofdCreator = new OFDCreator();
            for (int i = 0; i < doc.getNumberOfPages(); i++) {
                ofdCreator.addPage(i);
                PDRectangle cropBox = doc.getPage(i).getCropBox();
                float widthPt = cropBox.getWidth();
                float heightPt = cropBox.getHeight();
                OFDPageDrawer ofdPageDrawer = new OFDPageDrawer(i, doc.getPage(i), ofdCreator, 1 / POINTS_PER_MM);
                ofdPageDrawer.drawPage();
                ofdCreator.addPageContent(i, ofdPageDrawer.getCtLayer(), widthPt / POINTS_PER_MM, heightPt / POINTS_PER_MM);
            }
            ofdCreator.jar(output);
        }
    }

    public static byte[] convertPdfToOfd(byte[] pdfBytes) {
        String tempFilePath = generateTempFilePath();
        PDDocument doc = null;
        try {
            FileUtils.writeByteArrayToFile(new File(tempFilePath), pdfBytes);
            doc = PDDocument.load(new File(tempFilePath));
            OFDCreator ofdCreator = new OFDCreator();
            for (int i = 0; i < doc.getNumberOfPages(); i++) {
                ofdCreator.addPage(i);
                PDRectangle cropBox = doc.getPage(i).getCropBox();
                float widthPt = cropBox.getWidth();
                float heightPt = cropBox.getHeight();
                OFDPageDrawer ofdPageDrawer = new OFDPageDrawer(i, doc.getPage(i), ofdCreator, 1 / POINTS_PER_MM);
                ofdPageDrawer.drawPage();
                ofdCreator.addPageContent(i, ofdPageDrawer.getCtLayer(), widthPt / POINTS_PER_MM, heightPt / POINTS_PER_MM);
            }
            byte[] ofdBytes = ofdCreator.jar();
            return ofdBytes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (doc != null) {
                    doc.close();
                }
                FileUtils.forceDeleteOnExit(new File(tempFilePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String generateTempFilePath() {
        return System.getProperty("java.io.tmpdir") + "/" + UUID.randomUUID().toString();
    }
}
