package com.devisv.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = FileSystems.getDefault();

        System.out.println("File Stores:");
        fileSystem.getFileStores()
                  .forEach(System.out::println);

        System.out.println("Root directory:");
        fileSystem.getRootDirectories()
                  .forEach(System.out::println);

        System.out.println("Separator: " + fileSystem.getSeparator());

        new File("index.html");
        Path path = Paths.get("/Users/denisvasilev/devisv/nio/");
        Path path1 = path.resolve("index.html");

        System.out.println(path1.getFileName());
        System.out.println(path1.toAbsolutePath());
        System.out.println(path1.toFile());

        path1.forEach(System.out::println);

    }

}
