package test;


import org.apache.commons.io.FileUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * pdf转ofd工具类
 * 相互转换
 * @author gblfy
 * @date 2021-12-06
 */
public class OfdPdfUtil {

    /**
     * pdf转ofd
     *
     * @param pdfFileInputPath
     * @param ofdFileOutputPath
     */
    public static void convertToOfdByStream(String pdfFileInputPath, String ofdFileOutputPath) {
        Path input = Paths.get(pdfFileInputPath);
        Path output = Paths.get(ofdFileOutputPath);
        for (int i = 0; i < 1; i++) {
            try {
                OFDRender.convertPdfToOfd(Files.newInputStream(input), Files.newOutputStream(output));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * pdf转ofd
     * @param pdfFileInputPath
     * @param ofdFileOutputPath
     */
    public static void convertToOfd(String pdfFileInputPath, String ofdFileOutputPath) {
        Path input = Paths.get(pdfFileInputPath);
        Path output = Paths.get(ofdFileOutputPath);
        for (int i = 0; i < 1; i++) {
            try {
                byte[] pdfBytes = FileUtils.readFileToByteArray(input.toFile());
                byte[] ofdBytes = OFDRender.convertPdfToOfd(pdfBytes);
                if (Objects.nonNull(ofdBytes)) {
                    FileUtils.writeByteArrayToFile(output.toFile(), ofdBytes);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
