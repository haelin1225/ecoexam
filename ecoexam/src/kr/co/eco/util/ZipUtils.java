package kr.co.eco.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

import net.sf.jazzlib.ZipEntry;
import net.sf.jazzlib.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ZipUtils {
    private static final int COMPRESSION_LEVEL = 8;

    private static final int BUFFER_SIZE = 1024 * 2;

    /**
     * ������ ������ Zip ���Ϸ� �����Ѵ�.
     * @param sourcePath - ���� ��� ���丮
     * @param output - ���� zip ���� �̸�
     * @throws Exception
     */
    public static void zip(String sourcePath, String output) throws Exception {

        // ���� ���(sourcePath)�� ���丮�� ������ �ƴϸ� �����Ѵ�.
        File sourceFile = new File(sourcePath);
        if (!sourceFile.isFile() && !sourceFile.isDirectory()) {
            throw new Exception("���� ����� ������ ã�� ���� �����ϴ�.");
        }

        // output �� Ȯ���ڰ� zip�� �ƴϸ� �����Ѵ�.
        if (!(StringUtils.substringAfterLast(output, ".")).equalsIgnoreCase("zip")) {
            throw new Exception("���� �� ���� ���ϸ��� Ȯ���ڸ� Ȯ���ϼ���");
        }

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ZipOutputStream zos = null;

        try {
            fos = new FileOutputStream(output); // FileOutputStream
            bos = new BufferedOutputStream(fos); // BufferedStream
            zos = new ZipOutputStream(bos); // ZipOutputStream
            zos.setLevel(COMPRESSION_LEVEL); // ���� ���� - �ִ� ������� 9, ����Ʈ 8
 //         zipEntry(sourceFile, sourcePath, zos); // Zip ���� ����
            zos.finish(); // ZipOutputStream finish
        } finally {
            if (zos != null) {
                zos.close();
            }
            if (bos != null) {
                bos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
    
    /**
     * Zip ������ ������ Ǭ��.
     *
     * @param zipFile - ���� Ǯ Zip ����
     * @param targetDir - ���� Ǭ ������ �� ���丮
     * @param fileNameToLowerCase - ���ϸ��� �ҹ��ڷ� �ٲ��� ����
     * @throws Exception
     */
    public static void unzip(File zipFile, File targetDir, boolean fileNameToLowerCase) throws Exception {
        FileInputStream fis = null;
        ZipInputStream zis = null;
        ZipEntry zentry = null;
        
        
        try {
            fis = new FileInputStream(zipFile); // FileInputStream
            zis = new ZipInputStream(fis); // ZipInputStream

            while ((zentry = zis.getNextEntry()) != null) {
                String fileNameToUnzip = zentry.getName();
                if (fileNameToLowerCase) { // fileName toLowerCase
                    fileNameToUnzip = fileNameToUnzip.toLowerCase();
                }

                File targetFile = new File(targetDir, fileNameToUnzip);

                if (zentry.isDirectory()) {// Directory �� ���
                 //   FileUtils.makeDir(targetFile.getAbsolutePath()); // ���丮 ����
                	FileUtils.forceMkdir(targetFile);
                } else { // File �� ���
                    // parent Directory ����
                //    FileUtils.makeDir(targetFile.getParent());
                	FileUtils.forceMkdir(targetFile.getParentFile());
                    unzipEntry(zis, targetFile);
                }
            }
        } finally {
            if (zis != null) {
                zis.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }

    /**
     * Zip ������ �� �� ��Ʈ���� ������ Ǭ��.
     *
     * @param zis - Zip Input Stream
     * @param filePath - ���� Ǯ�� ������ ���
     * @return
     * @throws Exception
     */
    protected static File unzipEntry(ZipInputStream zis, File targetFile) throws Exception {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(targetFile);

            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = zis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
        return targetFile;
    }
    
}
