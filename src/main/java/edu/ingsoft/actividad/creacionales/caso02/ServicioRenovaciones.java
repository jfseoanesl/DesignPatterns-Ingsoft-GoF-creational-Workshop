package edu.ingsoft.actividad.creacionales.caso02;

/** Renueva contratos copiando el anterior. */
public class ServicioRenovaciones {
    private final CatalogoClausulas catalogo = new CatalogoClausulas();

    public Contrato renovar(Contrato anterior, long nuevoCanon) {
        Contrato c = new Contrato();
        c.tipo = anterior.tipo;
        c.partes = anterior.partes;
        c.objeto = anterior.objeto;
        c.valor = nuevoCanon;
        c.clausulas = anterior.clausulas; // "copia" rápida
        c.agregarClausula(catalogo.texto("DUR") + " (renovación)");
        return c;
    }
}
