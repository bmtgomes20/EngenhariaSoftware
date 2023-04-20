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
            CSVReader reader = new CSVReader(new FileReader(file));
            List<String[]> rows = reader.readAll();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(rows);

            String filename = file.getName().replace(".csv", ".json");
            File file = new File(filename);

            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
            System.out.println("Ler ofhciei");
            return file;
        }
        System.out.println("Tem que ser um ficheiro CSV");
        return null;
    }

    public static File jsonToCsv() throws IOException {

        if(file.getName().endsWith(".json")){

            Gson gson = new Gson();
            String[][] data = gson.fromJson(new FileReader(file), String[][].class);

            String filename = file.getName().replace(".json", ".csv");
            File file = new File(filename);

            CSVWriter writer = new CSVWriter(new FileWriter(file));
            String [] primeira= {"Curso","Unidade Curricular","Turno","Turma","Inscritos no turno","Dia da semana","Hora início da aula","Hora fim da aula","Data da aula","Sala atribuída à aula","Lotação da sala\n"};
            writer.writeNext(primeira);
            writer.writeAll(Arrays.asList(data));
            writer.close();
        
            return file;
        }
        System.out.println("Tem que ser um ficheiro JSON");
        return null;
    }
}
