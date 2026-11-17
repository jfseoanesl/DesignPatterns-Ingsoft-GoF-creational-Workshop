package edu.ingsoft.actividad.creacionales.caso05;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        for (String motor : new String[] {"postgres", "oracle"}) {
            RepositorioFacturas facturas = new RepositorioFacturas(motor);
            RepositorioClientes clientes = new RepositorioClientes(motor);
            System.out.println(facturas.buscar("900123", LocalDate.of(2026, 1, 1),
                    LocalDate.of(2026, 6, 30), "PAGADA", null, 2));
            System.out.println(facturas.buscar(null, null, null, null, 1_000_000L, null));
            System.out.println(clientes.todos(1));
        }
        System.out.println("Pools abiertos: " + PoolConexiones.poolsAbiertos);
    }
}
