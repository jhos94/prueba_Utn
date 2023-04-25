package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private String numeroRonda;
    private List<Partido> partidos;

    public String getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(String numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void addPartido(Partido partido){
        if(this.partidos == null){
            this.partidos = new ArrayList<Partido>();
        }
        this.partidos.add(partido);
    }

    public Partido getPartidoXequipos(String equipo1, String equipo2){
        if (this.getPartidos() != null){
            for (Partido p : this.getPartidos()){
                if (p.getEquipo1().getNombre().equals(equipo1) && p.getEquipo2().getNombre().equals(equipo2)){
                    return p;
                }
            }
        }
        return null;
    }
}
