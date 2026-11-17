package edu.ingsoft.actividad.creacionales.caso05;

public class RepositorioClientes {
    private final String motor;
    private final PoolConexiones pool;

    public RepositorioClientes(String motor) {
        this.motor = motor;
        this.pool = new PoolConexiones(motor);
    }

    public String todos(int pagina) {
        int offset = (pagina - 1) * 20;
        Object cx = pool.obtener();
        if (motor.equals("oracle")) {
            String sql = "SELECT * FROM cliente ORDER BY nombre OFFSET " + offset
                    + " ROWS FETCH NEXT 20 ROWS ONLY";
            return ((ConexionOracle) cx).preparar(sql).ejecutar();
        }
        String sql = "SELECT * FROM cliente ORDER BY nombre LIMIT 20 OFFSET " + offset;
        return ((ConexionPostgres) cx).preparar(sql).ejecutar();
    }
}
