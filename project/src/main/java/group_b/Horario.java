package group_b;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class Horario {
    
    private static List<Aula> aulas;

    public Horario(List<Aula> aulas){
        this.aulas=aulas;
    }

    public static List<Aula> getAulas(){
        return aulas;
    }

    public static File horarioCSV(String nome) throws IOException{
        String fileName= nome + ".csv";
        File csvFile = new File(fileName);
        
        CSVWriter writer = new CSVWriter(new FileWriter(fileName));
        String [] primeira= {"Curso","Unidade Curricular","Turno","Turma","Inscritos no turno","Dia da semana","Hora início da aula","Hora fim da aula","Data da aula","Sala atribuída à aula","Lotação da sala\n"};
        writer.writeNext(primeira);
        for (Aula aula : aulas) {
            writer.writeNext(aula.fromAula());
        }
        writer.close();
        
        return csvFile;
    }

    public static File horarioJSON(String nome) throws IOException{
        String fileName= nome + ".json";
        File jsonFile = new File(fileName);
        List<String[]> lista=new ArrayList<>();
        for (Aula aula : aulas) {
            lista.add(aula.fromAula());
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(lista);

        FileWriter writer = new FileWriter(jsonFile);
        writer.write(json);
        writer.close();
        return jsonFile;
    }


public static void main (String[] args) throws IOException, CsvException{

File csvFile = new File("horario_exemplo.csv");
Conversor a=new Conversor(csvFile);
a.csvToJson();


}

}
