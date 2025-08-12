package utilidades.hack;

public class Util {
    public static boolean isNumero(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String formatOzzyCoin(int valor) {
        return valor + " Ozzy Coins";
    }

    public static void limparTela() {
        for (int i = 0; i < 30; i++) System.out.println();
    }

    // Gera um código aleatório para desafios ou autenticação
    public static String gerarCodigo(int tamanho) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            int idx = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(idx));
        }
        return sb.toString();
    }

    // Pausa o jogo por alguns segundos
    public static void pausa(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            // Ignora
        }
    }

    // Destaca texto para feedback visual
    public static String destaque(String texto) {
        return "*** " + texto + " ***";
    }
}
