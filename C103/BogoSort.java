import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BogoSort
{
    private static Random random = new Random(42L);

    // cria um vetor com n elementos cujos valores
    // variam de 0 (inclusive) a n^2 (exclusive)
    public static Integer[] generateRandomArray(Integer n)
    {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(n * n);
        return arr;
    }

    // retorna um booleando que indica se o vetor
    // fornecido como parametro esta ordenado ou nao
    public static boolean isOrdered(Integer[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1])
                return false;
        return true;
    }

    // bogo sort: enquanto o vetor nao estiver ordenado,
    // embaralha-o e realiza a verificacao novamente
    public static Integer[] bogoSort(Integer[] arr)
    {
        int iterationCount = 0;
        List<Integer> list = Arrays.asList(arr);
        do
        {
            Collections.shuffle(list);
            arr = list.toArray(new Integer[0]);
            iterationCount++;
        } while (!isOrdered(arr));
        System.out.println(iterationCount + "\t" + Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 1; i < 32; i++)
        {
            System.out.print("<" + i + ">\t->\t");
            Integer[] array = generateRandomArray(i);
            bogoSort(array);
        }
    }
}
