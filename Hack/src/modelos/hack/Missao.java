package modelos.hack;

public class Missoes {
    private String descricao;
    private Alvo alvo;
    private int dificuldade;
    private int recompensaExp;
    private boolean missaoCompleta;
    public Missoes(String descricao, Alvo alvo, int dificuldade, int recompensaExp, boolean missaoCompleta) {
        this.descricao = descricao;
        this.alvo = alvo;
        this.dificuldade = dificuldade;
        this.recompensaExp = recompensaExp;
        this.missaoCompleta = false;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Alvo getAlvo() {
        return alvo;
    }
    public void setAlvo(Alvo alvo) {
        this.alvo = alvo;
    }
    public int getDificuldade() {
        return dificuldade;
    }
    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
    public int getRecompensaExp() {
        return recompensaExp;
    }
    public void setRecompensaExp(int recompensaExp) {
        this.recompensaExp = recompensaExp;
    }
    public boolean isMissaoCompleta() {
        return missaoCompleta;
    }
    public void setMissaoCompleta(boolean missaoCompleta) {
        this.missaoCompleta = missaoCompleta;
    }
public void exibeMissao() {
    System.out.println("*** MISSÃO ***");
    System.out.println("Descrição: "+descricao);
    System.out.println("Alvo: "+ alvo.getNome()+" Segurança: "+alvo.getSeguranca());
    System.out.println("Dificuldade: "+dificuldade);
    System.err.println("Experiencia: "+recompensaExp);
            System.out.println("Status: " + (missaoCompleta ? "COMPLETA" : "PENDENTE"));

}    



}
