package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OwlCounter {
    private List<String> lines = new ArrayList<>();

    public void readFromFile(Path path){
        try {
            lines = Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String region){
        for (String line : lines){
            if (line.startsWith(region)){
                return getNumberOfOwlsFromLine(line);
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls(){
        int numberOfAllOwls = 0;
        for (String line : lines){
            numberOfAllOwls += getNumberOfOwlsFromLine(line);
        }
        return numberOfAllOwls;
    }

    public int getNumberOfOwlsFromLine(String line){
        String[] parts = line.split("=");
        return Integer.parseInt(parts[1]);
    }


}
