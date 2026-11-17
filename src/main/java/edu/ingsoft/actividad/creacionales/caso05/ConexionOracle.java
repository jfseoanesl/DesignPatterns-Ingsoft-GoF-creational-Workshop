package edu.ingsoft.actividad.creacionales.caso05;

public class ConexionOracle {
    public SentenciaOracle preparar(String sql) {
        return new SentenciaOracle(sql);
    }
}
