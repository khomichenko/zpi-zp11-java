package tasks.task8;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

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
        Integer threads = 16, iterations = 1_000_000_000;
        Double pi  = ParallelMonteCarloPi.calc(threads, iterations);
        long end   = System.currentTimeMillis();
        System.out.println("PI is "+pi);
        System.out.println("THREADS "+threads);
        System.out.println("ITERATIONS "+iterations);
        System.out.println("TIME "+(end - start) + "ms");
    }
}
