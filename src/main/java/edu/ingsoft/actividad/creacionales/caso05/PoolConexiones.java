package edu.ingsoft.actividad.creacionales.caso05;

public class PoolConexiones {
    public static int poolsAbiertos = 0;
    private final String motor;

    public PoolConexiones(String motor) {
        poolsAbiertos++; // abrir 10 conexiones físicas tarda varios segundos
        this.motor = motor;
    }

    public Object obtener() {
        return motor.equals("oracle") ? new ConexionOracle() : new ConexionPostgres();
    }
}
