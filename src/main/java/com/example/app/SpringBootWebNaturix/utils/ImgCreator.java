package com.example.app.SpringBootWebNaturix.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class ImgCreator {

    private static final Logger LOGGER =
            Logger.getLogger(ImgCreator.class.getName());

    public static String createFile(MultipartFile file) throws IOException {
        String fileUpload = createFileName(file);
        String pathname = Paths.get(Constants.URL_FILE_UPLOADS + fileUpload).toString();

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(pathname));
        stream.write(file.getBytes());
        stream.close();

        LOGGER.info("Admin filepath: " + pathname);

        return fileUpload;
    }

    private static String createFileName(MultipartFile file) {
        String imgPrefix = StringGenerator.genStr();
        String fileType = file.getContentType().replace("image/", ".");
        return imgPrefix + "-" + file.getName() + fileType;
    }

}
