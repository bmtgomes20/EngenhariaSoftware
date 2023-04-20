package group_b;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Conversor {

    private static File file;
    

    public Conversor(File file){
        this.file=file;
        
    }

    public static File csvToJson() throws IOException, CsvException {

        if(file.getName().endsWith(".csv")){
            CSVReader reader = new CSVReader(new FileReader(file.getName()));
            List<String[]> rows = reader.readAll();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(rows);

            String filename = file.getName().replace(".csv", ".json");
            File jsonFile = new File(filename);

            FileWriter writer = new FileWriter(jsonFile);
            writer.write(json);
            writer.close();
            System.out.println("Ler ofhciei");
            return jsonFile;
        }
        System.out.println("Tem que ser um ficheiro CSV");
        return null;
    }

    public static File jsonToCsv() throws IOException {

        if(file.getName().endsWith(".json")){

            Gson gson = new Gson();
            String[][] data = gson.fromJson(new FileReader(file), String[][].class);

            String filename = file.getName().replace(".json", ".csv");
            File csvFile  = new File(filename);

            CSVWriter writer = new CSVWriter(new FileWriter(csvFile ));
            String [] primeira= {"Curso","Unidade Curricular","Turno","Turma","Inscritos no turno","Dia da semana","Hora início da aula","Hora fim da aula","Data da aula","Sala atribuída à aula","Lotação da sala\n"};
            writer.writeNext(primeira);
            writer.writeAll(Arrays.asList(data));
            writer.close();
        
            return csvFile ;
        }
        System.out.println("Tem que ser um ficheiro JSON");
        return null;
    }

    
        public static void main(String[] args) {
            // create a file object for the CSV file
            File csvFile = new File("C:/Users/Rodrigo/Documents/GitHub/EngenhariaSoftware/project/horario_ficheiro.csv");
            
            // create a Conversor object with the file
            Conversor conversor = new Conversor(csvFile);
            
            // call csvToJson() method on the Conversor object
            try {
                File jsonFile = conversor.csvToJson();
                if (jsonFile != null) {
                    System.out.println("JSON file created: " + jsonFile.getAbsolutePath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CsvException e) {
                e.printStackTrace();
            }
        }
}
