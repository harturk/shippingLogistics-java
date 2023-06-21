package application;

import java.util.Locale;

import application.Interface.TelaCarregamentoInicial;
import application.Interface.TelaPrincipal;

public class App {
    public void executar() {
        Locale.setDefault(Locale.ENGLISH);
        new TelaCarregamentoInicial();
    }
}
