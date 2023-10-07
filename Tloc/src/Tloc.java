import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tloc {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Error : chemin du fichier manquant");
        } else {

            Path chemin = Paths.get(args[0].toString());
            System.out.println(tloc(chemin));

        }

    }

    public static int tloc (Path fileName){

        int valeurTloc = 0;
        //System.out.println(fileName);

        try  {

            BufferedReader breader = Files.newBufferedReader(fileName);

            String line;

            while ((line = breader.readLine()) != null){

                line.trim();

                if (line.startsWith("//")){
                    continue;
                }

                if (line.startsWith("/*")){
                    continue;
                }

                if (line.startsWith("*")){
                    continue;
                }

                if (line.endsWith("*/")){
                    continue;
                }else {
                    valeurTloc++;
                }

            }

            breader.close();

        }catch (IOException e){
            System.out.println("Erreur : " + e.getMessage());
        }

        return valeurTloc;
    }
}

