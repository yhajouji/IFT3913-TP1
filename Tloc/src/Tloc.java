import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tloc {

    public static void main(String[] args) {

        Path chemin = Paths.get("C:/WorkSpace/fichierTest.txt");
        //String filename = chemin.getFileName().toString();
        System.out.println(tloc(chemin));
        /*
        if (args.length != 1) {
            System.out.println("Error : 1 argument manquant");
        } else {

            //Path chemin = Paths.get(args.toString());
            //String filename = chemin.getFileName().toString();
            //System.out.println(tloc(filename));

        }
        */

    }

    public static int tloc (Path fileName){

        int valeurTloc = 0;
        System.out.println(fileName);

        try  {
            //System.out.println(fileName);

            BufferedReader breader = Files.newBufferedReader(fileName);


            String line;

            while ((line = breader.readLine()) != null){
                line.trim();
                valeurTloc++;
                System.out.println(line);
            }

            breader.close();

        }catch (IOException e){
            System.out.println("Erreur : " + e.getMessage());
        }

        return valeurTloc;
    }
}

