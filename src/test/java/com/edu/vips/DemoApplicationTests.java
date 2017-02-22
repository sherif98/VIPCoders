package com.edu.vips;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        Path path = Paths.get("C:", "Users", "Admin", "IdeaProjects", "VIPCoders", "src", "main", "resources",
                "static", "tempbinaries");
        Path path2 = Paths.get(path.toString(), "test2.java");
        System.out.println(path2.toFile().getName());
        ProcessBuilder processBuilder = new ProcessBuilder("javac", path2.toFile().getName());
        processBuilder.directory(path.toFile()).redirectErrorStream(true);
        Process p = null;
        try {
            p = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(p.exitValue());
    }
}
