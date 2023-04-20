package group_b;

public class Aula {
    private String curso;
    private String unidadeCurricular;
    private String turno;
    private String turma;
    private int inscritos;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;
    private String data;
    private String sala;
    private int lotacaoSala;

    public Aula(String curso, String unidadeCurricular, String turno, String turma, int inscritos, String diaSemana,String horaInicio,String horaFim,String data,String sala, int lotacaoSala){
        this.curso=curso;
        this.unidadeCurricular=unidadeCurricular;
        this.turno=turno;
        this.turma=turma;
        this.inscritos=inscritos;
        this.diaSemana=diaSemana;
        this.horaInicio=horaInicio;
        this.horaFim=horaFim;
        this.data=data;
        this.sala=sala;
        this.lotacaoSala=lotacaoSala;
    }

    public String[] fromAula() {
        String[] line = new String[11];
        line[0] = curso;
        line[1] = unidadeCurricular;
        line[2] = turno;
        line[3] = turma;
        line[4] = Integer.toString(inscritos);
        line[5] = diaSemana.toLowerCase();
        line[6] = horaInicio;
        line[7] = horaFim;
        line[8] = data;
        line[9] = sala;
        line[10] = Integer.toString(lotacaoSala);
        return line;
    }

    public String toString() {
        return curso + "," + unidadeCurricular+ "," + turno+ "," + turma+ "," + inscritos+ "," + diaSemana+ "," + horaInicio+ "," + horaFim+ "," + data+ "," + sala + "," + lotacaoSala;
    }
}

