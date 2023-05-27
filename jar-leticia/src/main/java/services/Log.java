/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Log {

    private static final String FILE_NAME = "log.txt";

    public void gerarLog() {

        try {
            File arquivo = new File("log.txt");

            String frase = "ATM 9 ativo";

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            List<String> logs = new ArrayList<>();

            logs.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + frase);
            Files.write(Paths.get(arquivo.getPath()), logs, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
