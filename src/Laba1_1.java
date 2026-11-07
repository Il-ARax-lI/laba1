import java.util.Random;

public class Laba1_1
{
    static int N = 1600;
    static int START = 80;
    static int END = 90;
    static int COUNT = 5;

    void main() {
        Random random = new Random();
        int[] num = new int[N];
        int[] count = new int[COUNT];

        for(int i = 0; i < N; i++)
        {
            num[i] = random.nextInt(START, END);
            count[(int)(((float)((num[i]) % START) / ((float)(END - START) / (float)COUNT)))]++;
        }
        printGraf(count);
    }

    private String getStar(int n)
    {
        String s = "";
        for(int i = 0; i < n; i++)
        {
            s += "*";
        }
        return s;
    }

    private void printGraf(int[] num)
    {
        for(int i = 0; i < COUNT; i++)
        {
            System.out.printf("[%.1f..%.1f] %-20s (количество чисел: %d)\n",
                    (float)(START + (float)(END - START) / (float)COUNT * i),
                    (float)(START + (float)(END - START) / (float)COUNT * (i + 1)),
                    getStar(20*num[i]/N),
                    num[i]);
        }
    }
}
