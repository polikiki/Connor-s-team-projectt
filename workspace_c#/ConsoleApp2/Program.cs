class Program
{
    static void Main(string[] args)
    {
        // 한줄 주석
        /*
        * 범위 주석
        */
        Console.Write("Hello, World!, ");
        Console.WriteLine("Hello, c#");

        int[] p = new int[3];

        p[0] = 10;

        test();

        int[] arr = { 1, 2, 3, 4, 5 };

        foreach (int el in arr)
        {
            Console.Write(el + ",");
        }

    }

    static void test()
    {
        Console.WriteLine("test");
    }
}
