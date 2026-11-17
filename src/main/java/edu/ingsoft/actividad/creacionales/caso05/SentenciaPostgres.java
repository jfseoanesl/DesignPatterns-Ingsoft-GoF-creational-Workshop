package edu.ingsoft.actividad.creacionales.caso05;

public class SentenciaPostgres {
    private final String sql;

    public SentenciaPostgres(String sql) {
        this.sql = sql;
    }

    public String ejecutar() {
        return "[PostgreSQL] " + sql;
    }
}
