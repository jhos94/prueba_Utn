package Entidades;

public class Pronostico {
    String nombreParticipante;
    Partido partido;
    Equipo equipo;

    ResultadoEnum resultado;


    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public void puntos(){
        int puntos=0;
        if (partido.resultado(equipo) == ResultadoEnum.GANADOR){
            puntos =3;
        } else if (partido.resultado(equipo)== ResultadoEnum.EMPATE){
            puntos=1;
        }
        else {
            puntos=0;
        }
    }

}


