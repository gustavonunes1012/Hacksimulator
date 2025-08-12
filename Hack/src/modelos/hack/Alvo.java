package modelos;

import java.util.Random;

public class Alvo {
    private String nome;
    private String ip;
    private int seguranca;
    public Alvo(String nome, String ip, int seguranca) {
        this.nome = nome;
        this.ip = ip;
        this.seguranca = seguranca;
    }
    public String gerarIp() {
                Random random = new Random();
        return random.nextInt(256) + "." +
               random.nextInt(256) + "." +
               random.nextInt(256) + "." +
               random.nextInt(256);
    }
    public String getNome() {
        return nome;
    }
    public String getIp() {
        return ip;
    }
    public int getSeguranca() {
        return seguranca;
    }
    public void exibeAlvo() {
        System.out.println("Alvo: "+nome);
        System.out.println("IP: "+ip);
        System.out.println("Nível de segurança: "+seguranca);
    }
    

}
