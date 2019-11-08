package file_system_crawler;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSystemCrawler extends SimpleFileVisitor<Path> {

    private int filesNumber = 0;
    private int directoriesNumber = -1;
    private String fileName;

    FileSystemCrawler(String partOfName) {
        this.fileName = partOfName;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {

        if (basicFileAttributes.isDirectory()) {
            path = Paths.get(basicFileAttributes.toString());

            visitFile(path, basicFileAttributes);
            if (path.getFileName().toString().contains(fileName))
                filesNumber++;
            return FileVisitResult.CONTINUE;
        }
        if (path.getFileName().toString().contains(fileName)) {
            filesNumber++;
        }
        System.out.println("Files - " + filesNumber);

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir,
                                              IOException exc) {
        directoriesNumber++;
        //System.out.format("Directory: %s%n", dir);
        System.out.println("Directories - " + directoriesNumber);

        return FileVisitResult.CONTINUE;
    }

}
