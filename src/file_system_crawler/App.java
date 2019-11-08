package file_system_crawler;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static java.lang.Integer.MAX_VALUE;

public class App {

    public static void main(String[] args) throws IOException {

        String pathString = "C:\\Users\\Oleksandr_Kalinin\\IdeaProjects\\pdf_test\\src\\files";
        String fileName = "pdf";
        Path path = null;
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            Files.walkFileTree(Paths.get(pathString), Collections.singleton(FileVisitOption.FOLLOW_LINKS), MAX_VALUE, new FileSystemCrawler(fileName));
        }

        long finish = System.currentTimeMillis();

        System.out.println("Time consumed: " + (finish - start));
    }
}

