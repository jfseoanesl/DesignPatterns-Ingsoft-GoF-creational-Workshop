package edu.ingsoft.actividad.creacionales.caso05;

public class SentenciaOracle {
    private final String sql;

    public SentenciaOracle(String sql) {
        this.sql = sql;
    }

    public String ejecutar() {
        if (sql.contains(" LIMIT ")) {
            return "[Oracle] ORA-00933: SQL command not properly ended -> " + sql;
        }
        return "[Oracle] " + sql;
    }
}
