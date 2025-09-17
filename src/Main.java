public class Main {
    public static void main(String[] args) {
        int[] fibTests = {4, 8, 16, 32, 128, 1000, 10000};
        System.out.println("Fibonacci Recursivo");
        for (int n : fibTests) {
            if (n > 32) continue;
            long ini = System.currentTimeMillis();
            long res = ExerciciosPD.fiboRec(n);
            long fim = System.currentTimeMillis();
            System.out.printf("fiboRec(%d) = %d (tempo: %d ms)\n", n, res, fim - ini);
        }
        System.out.println("Fibonacci Iterativo");
        for (int n : fibTests) {
            long ini = System.currentTimeMillis();
            long res = ExerciciosPD.fiboIter(n);
            long fim = System.currentTimeMillis();
            System.out.printf("fiboIter(%d) = %d (tempo: %d ms)\n", n, res, fim - ini);
        }
        System.out.println("Fibonacci Memoized");
        for (int n : fibTests) {
            long ini = System.currentTimeMillis();
            long res = ExerciciosPD.memoizedFibo(n);
            long fim = System.currentTimeMillis();
            System.out.printf("memoizedFibo(%d) = %d (tempo: %d ms)\n", n, res, fim - ini);
        }

        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 6};
        int capacidade = 5;
        ExerciciosPD.iteracoesMochilaFB = 0;
        int resFB = ExerciciosPD.mochilaForcaBruta(pesos, valores, pesos.length, capacidade);
        System.out.printf("\nMochila Força Bruta: valor=%d, iterações=%d\n", resFB, ExerciciosPD.iteracoesMochilaFB);
        ExerciciosPD.iteracoesMochilaPD = 0;
        int resPD = ExerciciosPD.mochilaPD(pesos, valores, pesos.length, capacidade);
        System.out.printf("Mochila PD: valor=%d, iterações=%d\n", resPD, ExerciciosPD.iteracoesMochilaPD);

        String s1 = "Casablanca";
        String s2 = "Portentoso";
        ExerciciosPD.iteracoesDistFB = 0;
        int distFB = ExerciciosPD.distanciaEdicaoFB(s1, s2);
        System.out.printf("\nDistância de Edição Força Bruta: %d, iterações=%d\n", distFB, ExerciciosPD.iteracoesDistFB);
        ExerciciosPD.iteracoesDistPD = 0;
        int distPD = ExerciciosPD.distanciaEdicaoPD(s1, s2);
        System.out.printf("Distância de Edição PD: %d, iterações=%d\n", distPD, ExerciciosPD.iteracoesDistPD);
    }
}
