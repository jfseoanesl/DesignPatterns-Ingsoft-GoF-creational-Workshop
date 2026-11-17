package edu.ingsoft.actividad.creacionales.caso02;

public class ServicioContratos {
    private final CatalogoClausulas catalogo = new CatalogoClausulas();

    public Contrato arrendamiento(String arrendador, String arrendatario, String inmueble,
                                  long canon) {
        Contrato c = new Contrato();
        c.tipo = "ARRENDAMIENTO";
        c.partes = arrendador + " / " + arrendatario;
        c.objeto = inmueble;
        c.valor = canon;
        c.agregarClausula(catalogo.texto("OBJ"));
        c.agregarClausula(catalogo.texto("DUR"));
        c.agregarClausula(catalogo.texto("PAG"));
        c.agregarClausula(catalogo.texto("SER"));
        c.agregarClausula(catalogo.texto("RES"));
        return c;
    }

    public Contrato compraventa(String vendedor, String comprador, String bien, long valor) {
        Contrato c = new Contrato();
        c.tipo = "COMPRAVENTA";
        c.partes = vendedor + " / " + comprador;
        c.objeto = bien;
        c.valor = valor;
        c.agregarClausula(catalogo.texto("OBJ"));
        c.agregarClausula(catalogo.texto("PAG"));
        c.agregarClausula(catalogo.texto("SAN"));
        c.agregarClausula(catalogo.texto("RES"));
        return c;
    }
}
