package network.eden.jsoncraft.interpreteur;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileMaker {

    public static void makeBlockFiles(){
        //block model
        //item model
        //blockstate
    }

    public static void makeItemFiles(){
        //item model
    }

    public static void print(List<String> lines, String path){
        Path file = Paths.get(path);
        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (Exception e){
            //TODO
        }
    }
}
