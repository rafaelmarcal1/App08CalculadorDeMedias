package br.edu.ifsp.dmo.app08version3.controller;

public class DadosCalculo {
    private double[] valores;
    private String tipoMedia;

    public DadosCalculo(double[] valores, String tipoMedia) {
        this.valores = valores;
        this.tipoMedia = tipoMedia;
    }

    public double calcularMedia() {
        double resultado = 0;

        if (tipoMedia.equals("Média Aritmética")) {
            for (double valor : valores) {
                resultado += valor;
            }
            resultado /= valores.length;
        } else if (tipoMedia.equals("Média Ponderada")) {
            double[] pesos = obterPesos();

            if (valores.length == pesos.length) {
                double somaProdutos = 0;
                double somaPesos = 0;

                for (int i = 0; i < valores.length; i++) {
                    somaProdutos += valores[i] * pesos[i];
                    somaPesos += pesos[i];
                }

                if (somaPesos != 0) {
                    resultado = somaProdutos / somaPesos;
                }
            } else {
                // Lidar com um erro se o número de valores e pesos não corresponder
            }
        } else if (tipoMedia.equals("Média Harmônica")) {
            double somaReciprocos = 0;

            for (double valor : valores) {
                if (valor != 0) {
                    somaReciprocos += 1 / valor;
                }
            }

            if (somaReciprocos != 0) {
                resultado = valores.length / somaReciprocos;
            }
        }

        return resultado;
    }

    private double[] obterPesos() {
        // Lógica para obter os pesos
        double[] pesos = new double[valores.length];
        // Defina os pesos com base na média desejada, por exemplo:
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] = 2.0;
        }
        return pesos;
    }
}
