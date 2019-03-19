package com.devisv.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Main {

    public static void main(String[] args) throws IOException {

        FileSystems.getDefault()
                   .supportedFileAttributeViews()
                   .forEach(System.out::println);

        FileSystems.getDefault()
                   .getFileStores()
                   .forEach(fileStore ->
                           System.out.println(
                                   fileStore.name() + " - " +
                                           fileStore.supportsFileAttributeView(BasicFileAttributeView.class) + " - " +
                                           fileStore.supportsFileAttributeView(DosFileAttributeView.class) + " - " +
                                           fileStore.supportsFileAttributeView(PosixFileAttributeView.class) + " - " +
                                           fileStore.supportsFileAttributeView(FileOwnerAttributeView.class) + " - " +
                                           fileStore.supportsFileAttributeView(AclFileAttributeView.class) + " - " +
                                           fileStore.supportsFileAttributeView(UserDefinedFileAttributeView.class)
                           )
                   );

        new File("index.html");
        Path path = Paths.get("/Users/denisvasilev/devisv/nio/");
        Path path1 = path.resolve("README.md");

        BasicFileAttributes attr = Files.readAttributes(path1, BasicFileAttributes.class);

        System.out.println("File size: " + attr.size());
        System.out.println("File creation time: " + attr.creationTime());
        System.out.println("File was last accessed at: " + attr.lastAccessTime());
        System.out.println("File was last modified at: " + attr.lastModifiedTime());
        System.out.println("Is directory? " + attr.isDirectory());
        System.out.println("Is regular file? " + attr.isRegularFile());
        System.out.println("Is symbolic link? " + attr.isSymbolicLink());
        System.out.println("Is other? " + attr.isOther());
    }

}
