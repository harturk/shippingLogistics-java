package application;

import model.Acervo;

/**
 * Classe da Aplicação. Faz a leitura do csv e imprime os valores solicitados no
 * exercício
 */

public class App {
    private Acervo acervo;

    public App() {
        acervo = new Acervo();
    }

    public void executar() {
        Leitura read = new Leitura("dados.csv", true, this.acervo);
        Escrita write = new Escrita("saida.csv");
        read.leRegistrosTexto();

        String lerAudiovisuais = "1;" + this.acervo.getQuantity();
        write.printOutput(lerAudiovisuais);
        String itemsDetails = this.acervo.getItemsDetails();
        write.printOutput(itemsDetails);
        String rpgCount = "3;" + this.acervo.getQuantityRPG();
        write.printOutput(rpgCount);
        String blurayHigherTax = "4;" + this.acervo.blurayClosestToAverageTax();
        write.printOutput(blurayHigherTax);
        write.closeOutput();
    }
}
