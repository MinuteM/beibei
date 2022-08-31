package test;

public class TestMain {

    public static void main(String[] args) {
        pdfToOfd();
        pdfToOfd2();
    }


    /**
     * 测试pdf转ofd
     */
    public static void pdfToOfd() {
        String pdfFileInputPath = "本地pdf路径";
        String ofdFileOutputPath = "输出ofd路径";
        OfdPdfUtil.convertToOfdByStream(pdfFileInputPath, ofdFileOutputPath);
    }

    /**
     * 测试pdf转ofd
     */
    public static void pdfToOfd2() {
        String pdfFileInputPath = "本地pdf路径";
        String ofdFileOutputPath = "输出ofd路径";
        OfdPdfUtil.convertToOfd(pdfFileInputPath, ofdFileOutputPath);
    }
}
