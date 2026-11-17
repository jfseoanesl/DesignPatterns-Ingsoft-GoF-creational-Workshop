package edu.ingsoft.actividad.creacionales.caso05;

import java.time.LocalDate;

public class RepositorioFacturas {
    private final String motor;
    private final PoolConexiones pool;

    public RepositorioFacturas(String motor) {
        this.motor = motor;
        this.pool = new PoolConexiones(motor);
    }

    public String buscar(String cliente, LocalDate desde, LocalDate hasta, String estado,
                         Long valorMinimo, Integer pagina) {
        String sql = "SELECT * FROM factura WHERE 1=1";
        if (cliente != null) {
            sql += " AND cliente = '" + cliente + "'";
        }
        if (desde != null && hasta != null) {
            sql += " AND fecha BETWEEN '" + desde + "' AND '" + hasta + "'";
        }
        if (estado != null) {
            sql += " AND estado = '" + estado + "'";
        }
        if (valorMinimo != null) {
            sql += " AND total >= " + valorMinimo;
        }
        sql += " ORDER BY fecha DESC";
        if (pagina != null) {
            sql += " LIMIT 20 OFFSET " + (pagina - 1) * 20; // sintaxis de PostgreSQL
        }
        Object cx = pool.obtener();
        if (motor.equals("oracle")) {
            return ((ConexionOracle) cx).preparar(sql).ejecutar();
        }
        return ((ConexionPostgres) cx).preparar(sql).ejecutar();
    }
}
