import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;


public class clientSorter{
    public static void main(String[] args) throws Exception {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(6);
        arr.add(2);
        arr.add(10);
        arr.add(4);

        ExecutorService ex = Executors.newFixedThreadPool(arr.size());
        ExecutorService ex1 = Executors.newCachedThreadPool();
        mergeSort sorter = new mergeSort(arr,ex);

        Future<List<Integer>> future = ex.submit(sorter);

        System.out.println(future.get());
        ex.shutdown();
    }
}