package Entidades;

public class Partido {
    Equipo equipo1;
    Equipo equipo2;

    int golesEquipo1;
    int golesEquipo2;



    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int getGolesEquipo2) {
        this.golesEquipo2 = getGolesEquipo2;
    }
    public ResultadoEnum resultado(Equipo equipo) {
        if (equipo1.equals(equipo)) {
            if (golesEquipo1 > golesEquipo2) {
                return ResultadoEnum.GANADOR;
            } else if (golesEquipo1 < golesEquipo2) {
                return ResultadoEnum.PERDEDOR;
            } else {
                return ResultadoEnum.EMPATE;
            }
        }
        else if (equipo2.equals(equipo)) {
            if (golesEquipo2 > golesEquipo1) {
                return ResultadoEnum.GANADOR;
            } else if (golesEquipo2 < golesEquipo1) {
                return ResultadoEnum.PERDEDOR;
            } else {
                return ResultadoEnum.EMPATE;
            }
        } else {
            throw new IllegalArgumentException("El equipo no participa en este partido");
        }
    }







}


