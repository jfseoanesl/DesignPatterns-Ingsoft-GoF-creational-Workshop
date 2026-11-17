package edu.ingsoft.actividad.creacionales.caso04;

public class GeneradorNivel {

    public Nivel generar(String bioma, int cantidadEnemigos) {
        Nivel n = new Nivel();
        if (bioma.equals("selva")) {
            n.fondo = new FondoSelva();
        } else if (bioma.equals("desierto")) {
            n.fondo = new FondoDesierto();
        }
        for (int i = 0; i < 3; i++) {
            if (bioma.equals("desierto") && i < 2) {
                n.obstaculos.add(new Cactus());
            } else {
                n.obstaculos.add(new Liana());
            }
        }
        for (int i = 0; i < cantidadEnemigos; i++) {
            if (bioma.equals("selva")) {
                n.enemigos.add(new Jaguar(i * 40));
            } else {
                n.enemigos.add(new Escorpion(i * 40));
            }
        }
        return n;
    }
}
