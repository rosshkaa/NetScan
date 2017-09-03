package netscan;

import java.io.BufferedInputStream;
import java.io.IOException;


public class AlphaScan {

    public static void runScript() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("./netscript.sh");
        processBuilder.inheritIO();
        Process process = processBuilder.start();

        int exitValue = process.waitFor();
        if (exitValue != 0) {
            new BufferedInputStream(process.getErrorStream());
            throw new RuntimeException("Script exec failed!");
        }
    }

    public static void main(String[] args) {
        try {
            AlphaScan.runScript();
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}


