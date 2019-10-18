package com.swemel.download;

import org.apache.commons.io.FileUtils;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ImageDownload {

    private static String FILE_URL = "https://kipmu.ru/wp-content/uploads/homyak.jpg";
    private static String FILE_URL2 = "https://img.rg.ru/img/content/165/89/88/kinopoisk.ru-Shrek-2-644132_d_850.jpg";

    public static void main(String[] args) {

        //Download file BufferedImage(долго работает и получаются большие файлы)
        long start = System.currentTimeMillis();
        try {
            BufferedImage image = null;
            URL url = new URL(FILE_URL);
            image = ImageIO.read(url);
            if (image != null) {
                ImageIO.write(image, "jpg", new File("/home/sergey/Projects/MyProject/BufferedImage.jpeg"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("BufferedImage: " + (end - start));


        //Download file IO with buffer
        start = System.currentTimeMillis();
        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("/home/sergey/Projects/MyProject/IO.jpeg")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.currentTimeMillis();
        System.out.println("IO with buffer: " + (end - start));


        //Download file IO without buffer
        start = System.currentTimeMillis();
        try (InputStream in = new URL(FILE_URL).openStream()) {
            Files.copy(in, Paths.get("/home/sergey/Projects/MyProject/IO2.jpeg"), StandardCopyOption.REPLACE_EXISTING);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.currentTimeMillis();
        System.out.println("IO without buffer: " + (end - start));


        //Download file NIO
        start = System.currentTimeMillis();
        try (ReadableByteChannel readableByteChannel = Channels.newChannel(
                new URL(FILE_URL).openStream())) {
            FileOutputStream fileOutputStream = new FileOutputStream("/home/sergey/Projects/MyProject/NIO.jpeg");
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.currentTimeMillis();
        System.out.println("NIO: " + (end - start));


        //Download file Async HTTP Client with chunks
        start = System.currentTimeMillis();
        AsyncHttpClient client = Dsl.asyncHttpClient();
        try {
            FileOutputStream stream = new FileOutputStream("/home/sergey/Projects/MyProject/AsyncHTTPClient.jpeg");
            client.prepareGet(FILE_URL).execute(new AsyncCompletionHandler<FileOutputStream>() {
                @Override
                public FileOutputStream onCompleted(Response response) throws Exception {
                    return stream;
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Async HTTP Client:  " + (end - start));


        //Download file Apache Commons IO
        start = System.currentTimeMillis();
        try {
            FileUtils.copyURLToFile(
                    new URL(FILE_URL),
                    new File("/home/sergey/Projects/MyProject/ApacheCommonsIO.jpeg"),
                    10_000,
                    10_000);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.currentTimeMillis();
        System.out.println("Apache Commons IO:  " + (end - start));


        //Download file with Resumable
        start = System.currentTimeMillis();
        try {
            File file = new File("/home/sergey/Projects/MyProject/ResumableDownload.jpeg");
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            long existingFileSize = file.length();
            URL url = new URL(FILE_URL2);
            long removeFileSize = getRemoveFileSize(url);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            ReadableByteChannel readableByteChannel = null;
            if (file.exists() && existingFileSize < removeFileSize) {
                httpConnection.setRequestProperty(
                        "Range",
                        "bytes=" + existingFileSize + "-" + removeFileSize
                );
                readableByteChannel = Channels.newChannel(httpConnection.getInputStream());
                fileOutputStream.getChannel().transferFrom(readableByteChannel, existingFileSize, removeFileSize);
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.currentTimeMillis();
        System.out.println("Apache Commons IO:  " + (end - start));
    }


    public static long getRemoveFileSize(URL url) {
        if (url != null) {
            HttpURLConnection httpConnection = null;
            try {
                httpConnection = (HttpURLConnection) url.openConnection();
                httpConnection.setRequestMethod("HEAD");
                return httpConnection.getContentLengthLong();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }
}
