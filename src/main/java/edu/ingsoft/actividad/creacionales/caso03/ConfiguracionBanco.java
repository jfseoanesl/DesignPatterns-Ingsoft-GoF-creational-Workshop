package edu.ingsoft.actividad.creacionales.caso03;

public class ConfiguracionBanco {
    public static int lecturas = 0;
    public final String servidorCorreo;
    public final String proveedorSms;

    public ConfiguracionBanco() {
        lecturas++; // simula descifrar y leer canales.cfg
        servidorCorreo = "smtp.bancoagil.co";
        proveedorSms = "sms-gw-2";
    }
}
