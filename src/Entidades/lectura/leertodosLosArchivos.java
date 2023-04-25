package Entidades.lectura;

import Entidades.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class leertodosLosArchivos {

    public static void main(String[] args) throws IOException {
        String rutaResultado ="resultado.txt";

        leerArchivos(rutaResultado);
    }

    public static void leerArchivos(String rutaResultaod) throws IOException {
        File archivoResultado = new File(rutaResultaod);
        FileReader frResultado = new FileReader(archivoResultado);
        BufferedReader brResultado = new BufferedReader(frResultado);

        Ronda ronda = new Ronda();

        String linea;
        while ((linea = brResultado.readLine())!=null){
            String[] campo= linea.split("-");
            String nroRonda = campo[0];
            String primerEquipo= campo[1];
            int golesPrimerEquipo= Integer.parseInt(campo[2]);
            int golesSegundoEquipo= Integer.parseInt(campo[3]);
            String segundoEquipo= campo[4];

            ronda.setNumeroRonda(nroRonda);

            Equipo equipoLocal = new Equipo();
            equipoLocal.setNombre(primerEquipo);
            Equipo equipoVisitante = new Equipo();
            equipoVisitante.setNombre(segundoEquipo);

            Partido partido = new Partido();
            partido.setEquipo1(equipoLocal);
            partido.setGolesEquipo1(golesPrimerEquipo);
            partido.setEquipo2(equipoVisitante);
            partido.setGolesEquipo2(golesSegundoEquipo);

            ronda.addPartido(partido);


        }
        System.out.println("Los resultados de los partidos fueron: ");


    }

    public static void leerPronosticoDb(){

        Connection conn = null;
        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/argentina_programa";
            String username = "root";
            String password = "tguerra1994g94";
            conn = DriverManager.getConnection(url, username, password);

            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM pronostico");
            while (resultado.next()){
                System.out.println(resultado.getString("participante"));
                System.out.println(resultado.getString("equipo_Local"));
                System.out.println(resultado.getString("gana_Local"));
                System.out.println(resultado.getString("empate"));
                System.out.println(resultado.getString("gana_Visitante"));
                System.out.println(resultado.getString("equipo_Visitante"));
                System.out.println("-----------------\n");

            }


        } catch (ClassNotFoundException ex) {
            System.out.println("Error: controlador JDBC no encontrado");
        } catch (SQLException ex) {
            System.out.println("Error: no se pudo conectar a la base de datos");

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error: no se pudo cerrar la conexión a la base de datos");
            }
        }
    }

}

