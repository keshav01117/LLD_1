import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


public class mergeSort implements Callable<List<Integer>> {
    private List<Integer> list;
    private ExecutorService executor;

    public mergeSort(List<Integer> list, ExecutorService executor) {
        this.list = list;
        this.executor = executor;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Integer> left = list.subList(0, mid);
        List<Integer> right = list.subList(mid, list.size());

        mergeSort lefthalf = new mergeSort(left, executor);
        mergeSort righthalf = new mergeSort(right, executor);

        Future<List<Integer>> leftFuture = executor.submit(lefthalf);
        Future<List<Integer>> rightFuture = executor.submit(righthalf);

        List<Integer> sortedLeft = leftFuture.get();
        List<Integer> sortedRight = rightFuture.get();

        return merge(sortedLeft, sortedRight);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add any remaining elements from either list
        while(i< left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while(j< right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }
}