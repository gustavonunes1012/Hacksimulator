package modelos.hack;

public class Jogador {
    private String nome;
    private int nivel;
    private int exp;
    private int energia;
    public Jogador(String nome) {
    this.nome = nome;
    
    this.nivel = 1;
    this.exp = 0;
    this.energia = 100;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public void exibeStatus() {
        System.out.println("***STATUS DO JOGADOR***");
        System.out.println("Nome: "+nome);
        System.out.println("Nivel: "+nivel);
        System.out.println("Experiencia: "+exp);
        System.out.println("Energia: "+energia);
    }
}
