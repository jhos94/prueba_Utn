package Entidades.lectura;

import Entidades.Equipo;
import Entidades.Partido;
import Entidades.Ronda;

import javax.imageio.IIOException;
import java.io.*;

public class leerArchivo {

    public static void main(String[] args) throws IOException {
        leerArchivosResultados();
    }

    public static void leerArchivosResultados() throws IOException {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        archivo = new File("resultado.txt");
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);

        Ronda ronda = new Ronda();
        // Lectura del fichero
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campo = linea.split("-");
            String nroRonda = campo[0];
            String primerEquipo = campo[1];
            int golesPrimerEquipo = Integer.parseInt(campo[2]);
            int golesSegundEquipo = Integer.parseInt(campo[3]);
            String segundoEquipo = campo[4];

            ronda.setNumeroRonda(nroRonda);
            Equipo equipo1 = new Equipo();
            equipo1.setNombre(primerEquipo);
            Equipo equipo2 = new Equipo();
            equipo2.setNombre(segundoEquipo);

            Partido partido = new Partido();
            partido.setEquipo1(equipo1);
            partido.setGolesEquipo1(golesPrimerEquipo);
            partido.setEquipo2(equipo2);
            partido.setGolesEquipo2(golesSegundEquipo);


            ronda.addPartido(partido);
        }

        for (Partido p: ronda.getPartidos()){
            System.out.println( p.getEquipo1().getNombre() + " vs " + p.getEquipo2().getNombre() );
        }
    }
}
