package ProducerConsumer;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    private Store store;
    private Semaphore producerSema;
    private Semaphore consumerSema;

    public Producer(Store store, Semaphore producerSema, Semaphore consumerSema) {
        this.producerSema = producerSema;
        this.consumerSema = consumerSema;
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            try {
                producerSema.acquire(); // try to producer--
                store.addItem(new Object());
//                consumerSema.release(); // cons++
                consumerSema.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}