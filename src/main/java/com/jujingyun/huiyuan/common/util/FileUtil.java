package com.jujingyun.huiyuan.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    public FileUtil() {
    }

    public static void zipFiles(List<File> fileList, File zipFile) {
        byte[] buffer = new byte[1024];

        try {
            ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFile));
            Iterator i$ = fileList.iterator();

            while(i$.hasNext()) {
                File file = (File)i$.next();
                FileInputStream inputStream = new FileInputStream(file);
                outputStream.putNextEntry(new ZipEntry(file.getName()));

                int len;
                while((len = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                }

                outputStream.closeEntry();
                inputStream.close();
            }

            outputStream.close();
        } catch (Exception var8) {
            LOG.error("Zip Failed!", var8);
        }

    }

    public static void zipFiles(Map<File, String> fileMap, File zipFile) {
        byte[] buffer = new byte[1024];

        try {
            ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFile));
            Set<String> nameSet = new HashSet();
            Iterator i$ = fileMap.entrySet().iterator();

            while(i$.hasNext()) {
                Entry<File, String> entry = (Entry)i$.next();
                FileInputStream inputStream = new FileInputStream((File)entry.getKey());
                String name = (String)entry.getValue();
                if (nameSet.contains(name)) {
                    name = System.currentTimeMillis() + name;
                }

                nameSet.add(name);
                outputStream.putNextEntry(new ZipEntry(name));

                int len;
                while((len = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                }

                outputStream.flush();
                outputStream.closeEntry();
                inputStream.close();
            }

            outputStream.close();
        } catch (Exception var10) {
            LOG.error("Zip Failed!", var10);
        }

    }

    public static void uploadFile(MultipartFile file, String uploadPath, String fileName) {
        File path = new File(uploadPath);
        if (!path.exists()) {
            path.mkdirs();
        }

        try {
            File uploadFile = new File(uploadPath + File.separator + fileName);
            file.transferTo(uploadFile);
        } catch (IOException var5) {
            LOG.error("upload file failed!", var5);
        }

    }

    public static void downloadFile(File file, HttpServletResponse response, String fileName) {
        response.setContentType("application/octet-stream");
        response.setContentLength((int)file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        FileInputStream fis = null;
        BufferedInputStream buff = null;

        try {
            fis = new FileInputStream(file);
            buff = new BufferedInputStream(fis);
            byte[] b = new byte[1024];
            long k = 0L;
            ServletOutputStream out = response.getOutputStream();

            while(k < file.length()) {
                int j = buff.read(b, 0, 1024);
                k += (long)j;
                out.write(b, 0, j);
            }

            out.flush();
        } catch (FileNotFoundException var20) {
            LOG.error("file not found: " + fileName, var20);
        } catch (IOException var21) {
            LOG.error("download file: " + fileName + " failed!", var21);
        } finally {
            try {
                if (buff != null) {
                    buff.close();
                }

                if (fis != null) {
                    fis.close();
                }
            } catch (IOException var19) {
                LOG.error("close failed!", var19);
            }

        }

    }

    public List<String> renameFiles(List<String> fileNames, int lengthLimit) {
        List<String> result = new ArrayList();
        Map<String, Integer> fileNamesMap = new HashMap();
        Iterator i$ = fileNames.iterator();

        while(i$.hasNext()) {
            String fileName = (String)i$.next();
            if (fileName.length() > lengthLimit) {
                fileName = fileName.substring(0, lengthLimit) + fileName.substring(fileName.lastIndexOf("."));
            }

            if (!fileNamesMap.containsKey(fileName)) {
                fileNamesMap.put(fileName, 1);
                result.add(fileName);
            } else {
                fileNamesMap.put(fileName, (Integer)fileNamesMap.get(fileName) + 1);
                int suffixIndex = fileName.lastIndexOf(".");
                result.add(fileName.substring(0, suffixIndex) + "(" + ((Integer)fileNamesMap.get(fileName) - 1) + ")" + fileName.substring(suffixIndex));
            }
        }

        return result;
    }

    /**
     * 下载excel
     * @param excel
     * @param response
     * @param excelName
     */
    public static void downloadExcel(Workbook excel, HttpServletResponse response, String excelName) {
        if (excel instanceof XSSFWorkbook) {
            excelName += ".xlsx";
        } else if (excel instanceof HSSFWorkbook) {
            excelName += ".xls";
        } else {
            return;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + excelName);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            excel.write(out);
            out.flush();
        }catch (Exception e) {
            return;
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
