package edu.ingsoft.actividad.creacionales.caso05;

public class ConexionPostgres {
    public SentenciaPostgres preparar(String sql) {
        return new SentenciaPostgres(sql);
    }
}
