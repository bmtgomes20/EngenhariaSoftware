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

    public static File csvToJson(File csvFile) throws IOException, CsvException {

        if(csvFile.getName().endsWith(".csv")){
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            List<String[]> rows = reader.readAll();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(rows);

            String filename = csvFile.getName().replace(".csv", ".json");
            File jsonFile = new File(filename);

            FileWriter writer = new FileWriter(jsonFile);
            writer.write(json);
            writer.close();
            return jsonFile;
        }
        return null;
    }

    public static File jsonToCsv(File jsonFile) throws IOException {

        if(jsonFile.getName().endsWith(".json")){

            Gson gson = new Gson();
            String[][] data = gson.fromJson(new FileReader(jsonFile), String[][].class);

            String filename = jsonFile.getName().replace(".json", ".csv");
            File csvFile = new File(filename);

            CSVWriter writer = new CSVWriter(new FileWriter(csvFile));
            String [] primeira= {"Curso","Unidade Curricular","Turno","Turma","Inscritos no turno","Dia da semana","Hora início da aula","Hora fim da aula","Data da aula","Sala atribuída à aula","Lotação da sala\n"};
            writer.writeNext(primeira);
            writer.writeAll(Arrays.asList(data));
            writer.close();
        
            return csvFile;
        }
        return null;
    }
}
