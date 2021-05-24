package com.wayne.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static com.wayne.utils.Print.print;

/**
 * @author wayne
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : result) {
            try {
                System.out.println("future is done? "+fs.isDone());
                print(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

    /*
    输出：
    result of TaskWithResult 0
    result of TaskWithResult 1
    result of TaskWithResult 2
    result of TaskWithResult 3
    result of TaskWithResult 4
    result of TaskWithResult 5
    result of TaskWithResult 6
    result of TaskWithResult 7
    result of TaskWithResult 8
    result of TaskWithResult 9
    */
