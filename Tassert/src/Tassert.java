import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tassert {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Error : chemin du fichier manquant");
        } else {

            Path chemin = Paths.get(args[0].toString());
            System.out.println(tassert(chemin));

        }
    }

    public static int tassert (Path fileName){

        int valeurTassert = 0;

        try  {

            BufferedReader breader = Files.newBufferedReader(fileName);

            String line;

            while ((line = breader.readLine()) != null){

                line.trim();

                if (line.startsWith("assert") || line.startsWith("fail")){
                    valeurTassert++;
                }
                /*
                if (line.startsWith("fail")){
                    valeurTassert++;
                } */

            }

            breader.close();

        }catch (IOException e){
            System.out.println("Erreur : " + e.getMessage());
        }

        return valeurTassert;
    }

}
