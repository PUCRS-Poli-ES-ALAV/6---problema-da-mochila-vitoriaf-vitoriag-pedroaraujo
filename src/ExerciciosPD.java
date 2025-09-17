import java.util.Arrays;

public class ExerciciosPD {
    public static long fiboRec(int n) {
        if (n <= 1) return n;
        return fiboRec(n - 1) + fiboRec(n - 2);
    }
    public static long fiboIter(int n) {
        if (n <= 1) return n;
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    public static long memoizedFibo(int n) {
        long[] f = new long[n + 1];
        Arrays.fill(f, -1);
        return lookupFibo(f, n);
    }
    private static long lookupFibo(long[] f, int n) {
        if (f[n] >= 0) return f[n];
        if (n <= 1) f[n] = n;
        else f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
        return f[n];
    }

    static int iteracoesMochilaFB = 0;
    public static int mochilaForcaBruta(int[] pesos, int[] valores, int n, int capacidade) {
        iteracoesMochilaFB++;
        if (n == 0 || capacidade == 0) return 0;
        if (pesos[n-1] > capacidade) return mochilaForcaBruta(pesos, valores, n-1, capacidade);
        int inclui = valores[n-1] + mochilaForcaBruta(pesos, valores, n-1, capacidade - pesos[n-1]);
        int exclui = mochilaForcaBruta(pesos, valores, n-1, capacidade);
        return Math.max(inclui, exclui);
    }

    static int iteracoesMochilaPD = 0;
    public static int mochilaPD(int[] pesos, int[] valores, int n, int capacidade) {
        int[][] maxTab = new int[n+1][capacidade+1];
        for (int i = 0; i <= n; i++) maxTab[i][0] = 0;
        for (int j = 0; j <= capacidade; j++) maxTab[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacidade; j++) {
                iteracoesMochilaPD++;
                if (pesos[i-1] <= j)
                    maxTab[i][j] = Math.max(maxTab[i-1][j], valores[i-1] + maxTab[i-1][j-pesos[i-1]]);
                else
                    maxTab[i][j] = maxTab[i-1][j];
            }
        }
        return maxTab[n][capacidade];
    }

    static int iteracoesDistFB = 0;
    public static int distanciaEdicaoFB(String a, String b) {
        return distanciaEdicaoFB(a, b, a.length(), b.length());
    }
    private static int distanciaEdicaoFB(String a, String b, int m, int n) {
        iteracoesDistFB++;
        if (m == 0) return n;
        if (n == 0) return m;
        if (a.charAt(m-1) == b.charAt(n-1))
            return distanciaEdicaoFB(a, b, m-1, n-1);
        return 1 + Math.min(
            Math.min(distanciaEdicaoFB(a, b, m, n-1), // inserção
                     distanciaEdicaoFB(a, b, m-1, n)), // remoção
            distanciaEdicaoFB(a, b, m-1, n-1) // substituição
        );
    }

    static int iteracoesDistPD = 0;
    public static int distanciaEdicaoPD(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] matriz = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) matriz[i][0] = i;
        for (int j = 0; j <= n; j++) matriz[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                iteracoesDistPD++;
                int custo = (a.charAt(i-1) == b.charAt(j-1)) ? 0 : 1;
                matriz[i][j] = Math.min(
                    Math.min(matriz[i-1][j] + 1, matriz[i][j-1] + 1),
                    matriz[i-1][j-1] + custo
                );
            }
        }
        return matriz[m][n];
    }
}
