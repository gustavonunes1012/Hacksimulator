package modelos.hack;

public class Jogador {
    private String nome;
    private int nivel;
    private int exp;
    private int energia;
    private int ozzyCoin;

    
    private int hacking = 1;
    private int engenhariaSocial = 1;
    private int criptografia = 1;

    public int getHacking() { return hacking; }
    public int getEngenhariaSocial() { return engenhariaSocial; }
    public int getCriptografia() { return criptografia; }

    public int getCustoEvoluirHabilidade(int nivelAtual) {
        return 20 + nivelAtual * 30;
    }

    public boolean evoluirHabilidade(String habilidade) {
        int custo = 0;
        switch (habilidade) {
            case "hacking":
                custo = getCustoEvoluirHabilidade(hacking);
                if (ozzyCoin >= custo) {
                    hacking++;
                    ozzyCoin -= custo;
                    return true;
                }
                break;
            case "engenhariaSocial":
                custo = getCustoEvoluirHabilidade(engenhariaSocial);
                if (ozzyCoin >= custo) {
                    engenhariaSocial++;
                    ozzyCoin -= custo;
                    return true;
                }
                break;
            case "criptografia":
                custo = getCustoEvoluirHabilidade(criptografia);
                if (ozzyCoin >= custo) {
                    criptografia++;
                    ozzyCoin -= custo;
                    return true;
                }
                break;
        }
        return false;
    }

    public void exibeHabilidades() {
    System.out.println("--- Habilidades ---");
    int custoHacking = getCustoEvoluirHabilidade(hacking);
    int custoEngenharia = getCustoEvoluirHabilidade(engenhariaSocial);
    int custoCripto = getCustoEvoluirHabilidade(criptografia);
    System.out.println("1 - Hacking: " + hacking);
    System.out.println("   Aumenta a chance de sucesso nas missões. Cada nível adiciona +3% de chance.");
    System.out.println("   Próximo nível: " + custoHacking + " Ozzy Coins");
    System.out.println("2 - Engenharia Social: " + engenhariaSocial);
    System.out.println("   Reduz a dificuldade dos desafios intermediários. Cada nível diminui o tamanho do código do desafio.");
    System.out.println("   Próximo nível: " + custoEngenharia + " Ozzy Coins");
    System.out.println("3 - Criptografia: " + criptografia);
    System.out.println("   Reduz a energia perdida em missões avançadas. Cada nível reduz 3 pontos de energia perdida.");
    System.out.println("   Próximo nível: " + custoCripto + " Ozzy Coins");
    System.out.println("Ozzy Coins: " + ozzyCoin);
    }
    public int getOzzyCoin() {
        return ozzyCoin;
    }

    public void setOzzyCoin(int ozzyCoin) {
        this.ozzyCoin = ozzyCoin;
    }
    public Jogador(String nome) {
    this.nome = nome;
    
    this.nivel = 1;
    this.exp = 0;
    this.energia = 100;
    this.ozzyCoin = 0;
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
        System.out.println("Nome: " + nome);
        System.out.println("Nível: " + nivel);
        System.out.println("Experiência: " + exp);
        System.out.println("Energia: " + energia);
        System.out.println("Ozzy Coins: " + ozzyCoin);
    exibeHabilidades();
    }
}
