package tasks.task8;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * Варіант 1. Обчислення наближеного значення числа Пі методом Монте-Карло
 * У цьому завданні вам слід написати паралельну програму, яка обчислює значення
 * числа Пі. Метод обчислення дуже простий:
 *
 *  Площа квадрата одиничної довжини дорівнює 1
 *  Площа сектора 90 ° для одиничного кола: π/4
 *  «Кидаємо» величезну кількість випадкових точок в
 * одиничний квадрат
 *  Рахуємо кількість точок, що потрапили в межі кола,
 * тобто відстань від яких до (0,0) менше або дорівнює 1
 *  Частка точок, які потрапили в коло дорівнює
 *
 * наближеному значенню π/4
 * Деталі реалізації
 * Ваше завдання написати паралельну реалізацію (ParallelMonteCarloPi.java). При
 * написанні програми дотримуйтесь інструкцій:
 * • Першим і єдиним вхідним аргументом програми є кількість потоків
 * • В результаті програма виводить наступні дані:
 * PI is 3.14221
 * THREADS 8
 * ITERATIONS 1,000,000,000
 * TIME 12.83ms
 */
public class ParallelMonteCarloPi {

    public static Double calc(Integer threads, Integer iterations) throws ExecutionException, InterruptedException {
        Random r = new Random();
        Double from = 0.0, to = 1.0;
        ForkJoinPool pool = new ForkJoinPool(threads);
        long inSqCount = pool.submit(()-> r
                .doubles(iterations, from, to)
                .parallel()
                .boxed()
                .map(x -> {
                    Double y = (r.nextDouble() * (to - from)) + from;
                    Boolean is = Math.sqrt(x * x + y * y) <= 1;
                    return is;
                })
                .filter((t) -> t)
                .count()).get();
        Double pi = 4 * ( new Double(inSqCount) / iterations);
        return pi;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        Integer threads = 4, iterations = 100_000_000;
        Double pi  = ParallelMonteCarloPi.calc(threads, iterations);
        long end   = System.currentTimeMillis();
        System.out.println("PI is "+pi);
        System.out.println("THREADS "+threads);
        System.out.println("ITERATIONS "+iterations);
        System.out.println("TIME "+(end - start) + "ms");
    }
}
