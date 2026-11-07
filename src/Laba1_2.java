public class Laba1_2 {
    static int PLAYER_POINTS = 100;
    static int BOT_POINTS = 100;

    static int MOVE = 0;

    void main()
    {
        while (PLAYER_POINTS > 0 && BOT_POINTS > 0) {
            IO.println("Игра \"21 палочка\"");
            System.out.printf("Игрок %d\tКомпьютер %d\n", PLAYER_POINTS, BOT_POINTS);
            //int a = Integer.parseInt(IO.readln());
            Game();
        }
    }

    private void Game()
    {
        int count_stick = 21;
        PrintSticks(count_stick);
        while (count_stick > 0)
        {
            if (MOVE == 0)
            {
                IO.println("Твой ход");
                IO.println("Введите сколько палочек хотите взять от 1 до 3: ");
                int count = Integer.parseInt(IO.readln());
                while (count <= 0 || count >= 4 || count_stick - count < 0)
                {
                    IO.println("Нельзя взять столько");
                    count = Integer.parseInt(IO.readln());
                }
                count_stick -= count;
                PrintSticks(count_stick);
                MOVE = 1;
            }else
            {
                IO.println("Ход компьютера");
                int take_stick = CalculateStick(count_stick);
                IO.println("Компьютер взял " + take_stick);
                count_stick -= take_stick;
                PrintSticks(count_stick);
                MOVE = 0;
            }
        }
        EndGame();
    }

    private int CalculateStick(int count_stick)
    {
        int t = (count_stick + 3) % 4;
        return t == 0 ? 1 : t;
    }

    private void PrintSticks(int count)
    {
        String s = "|";
        IO.println("Осталось: " + count);
        IO.println(s.repeat(count));
        System.out.flush();
    }

    private void EndGame()
    {
        if(MOVE == 1)
        {
            IO.println("Компьютер выйграл");
            PLAYER_POINTS -= 15;
            BOT_POINTS +=15;
        }else
        {
            IO.println("Игрок выйграл");
            PLAYER_POINTS += 15;
            BOT_POINTS -=15;
        }
    }
}

