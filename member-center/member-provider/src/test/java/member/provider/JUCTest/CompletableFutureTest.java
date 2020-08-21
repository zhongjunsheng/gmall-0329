package member.provider.JUCTest;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java8 异步编排技术
 */
public class CompletableFutureTest {


    /**
     * CompletableFuture 提供了四个静态方法来创建一个异步操作。
     *
     * static CompletableFuture<Void> runAsync(Runnable runnable)    --- 无返回值 每次执行new 线程
     * public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)  -- 无返回值  执行时采用线程池调度线程
     * public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)  -- 有返回值 每次执行new 线程
     * public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)  ---有返回值  执行 时采用线程池调度线程(推荐)
     */




    /**
     *
     *  线程串行化方法:
     thenApply 方法：当一个线程依赖另一个线程时，获取上一个任务返回的结果，并返回当前任务的返回值。

     thenAccept方法：消费处理结果。接收任务的处理结果，并消费处理，无返回结果。

     thenRun方法：只要上面的任务执行完成，就开始执行thenRun，只是处理完任务后，执行 thenRun的后续操作,无需接受返回值也没有返回值

     带有Async默认是异步执行的。这里所谓的异步指的是不在当前线程内执行。

     public <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)
     public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn)
     public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)

     public CompletionStage<Void> thenAccept(Consumer<? super T> action);
     public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action);
     public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action,Executor executor);

     public CompletionStage<Void> thenRun(Runnable action);
     public CompletionStage<Void> thenRunAsync(Runnable action);
     public CompletionStage<Void> thenRunAsync(Runnable action,Executor executor);
     */


    /**
     * 处理线程返回值-- 如果存在单个业务里需用多处用到上一个线程的处理完的
     * 当CompletableFuture的计算结果完成，或者抛出异常的时候，可以执行特定的Action。主要是下面的方法：
     *
     * public CompletableFuture<T> whenComplete(BiConsumer<? super T,? super Throwable> action);
     * public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action);
     * public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action, Executor executor);
     *
     * public CompletableFuture<T> exceptionally(Function<Throwable,? extends T> fn);
     * whenComplete可以处理正常和异常的计算结果，exceptionally处理异常情况。BiConsumer<? super T,? super Throwable>可以定义处理业务
     *
     * whenComplete 和 whenCompleteAsync 的区别：
     * 		whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。  -- 上一个线程继续执行whenComplete的逻辑
     * 		whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行   -- 线程池调度具体哪个线程来执行之后的逻辑业务
     *
     */



    /**
     *
     * 2.7.   两任务组合 - 都要完成  -- 如 c 线程依赖 a，b 线程结果 只有 a，b线程完成后c拿到他们的结果够才执行这种场景可用任务组合方式

     * 两个任务必须都完成，触发该任务。

     * thenCombine：组合两个future，获取两个future的返回结果，并返回当前任务的返回值

     * thenAcceptBoth：组合两个future，获取两个future任务的返回结果，然后处理任务，没有返回值。

     * runAfterBoth：组合两个future，不需要获取future的结果，只需两个future处理完任务后，处理该任务。
     */


    /**
     * ## 2.9.   多任务组合
     *
     * ```java
     * public static CompletableFuture<Void> allOf(CompletableFuture<?>... cfs);
     *
     * public static CompletableFuture<Object> anyOf(CompletableFuture<?>... cfs);
     * ```
     *
     * allOf：阻塞等待所有任务完成
     *
     * anyOf：只要有一个任务完成即可执行下一步
     *
     * join()
     */

    ExecutorService service = Executors.newFixedThreadPool(5);


    //无返回值线程执行方式1--每次new 一个 线程
    @Test
    public void method1(){
        CompletableFuture.runAsync(() -> {
            //新线程执行这个逻辑
            System.out.println("method1..." + Thread.currentThread().getName());
        });
    }


    //无返回值线程执行方式2 -- 线程池方式
    @Test
    public void method2(){
        CompletableFuture.runAsync(() -> {
            //新线程执行这个逻辑  --- 比如是线程 A
            System.out.println("method1..." + Thread.currentThread().getName());
        },service);
    }


    //#################### 有返回值的多线程异步执行方式

    @Test
    public void method3(){
        CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回值的执行方式--new 线程方式" + Thread.currentThread().getName()); //线程A执行
            int a = 1/0;
            return " hello";  //必须有return 值
        }).whenComplete((result,exception) -> {    //这里的r表示上一步骤的执行结果(hello),上一步骤的执行的异常结果
            System.out.println("上一步骤的执行结果:" + result);  //hello,出现异常则不会返回
            System.out.println("上一步骤的执行的异常结果:" + exception); //java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
            System.out.println("有返回值的执行方式--new 线程方式" + Thread.currentThread().getName());  //main线程执行
        });
    }


    @Test
    public void method4(){
        CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回值的执行方式--线程池调度" + Thread.currentThread().getName());//线程A执行
            return " hello2";  //必须有return 值
        }).whenCompleteAsync((r,e) ->{
            System.out.println("上一步骤的执行结果:" +r);
            System.out.println("上一步骤的执行的异常结果:" +e);
            System.out.println("有返回值的执行方式--new 线程方式" + Thread.currentThread().getName()); //线程池选择具体的线程执行
        },service);
    }




    @Test
    public void method5(){
        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回值的执行方式--线程池调度" + Thread.currentThread().getName());//线程A执行
            return " hello2";  //必须有return 值
        }).whenCompleteAsync((r, e) -> {
            System.out.println("上一步骤的执行结果:" + r);
            System.out.println("上一步骤的执行的异常结果:" + e);
            //int a = 1/0;
        }, service).exceptionally(ex -> {
            return "excetion msg" + ex; // 异常时的返回值
        });

        String result = null;
        try {
            result = exceptionally.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("最终结果:" + result); //excetion msg
    }




    //一个业务下可能会在里面多次异步处理业务
    @Test
    public void method6(){
        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回值的执行方式--线程池调度" + Thread.currentThread().getName());//线程A执行
            return " hello1";  //必须有return 值
        },service).thenApplyAsync( r1 -> {
            System.out.println("这是线程一执行步骤1结果:"+r1); //打印上一个步执行结果
            System.out.println("步骤1线程名称" + Thread.currentThread().getName());//线程B执行
            return "hello2";
        },service).thenApplyAsync( r2 -> {
            System.out.println("这是线程一执行步骤2结果:"+r2); //打印上一步骤执行结果
            System.out.println("步骤2线程名称" + Thread.currentThread().getName());//线程c执行
            return "hello3";
        },service).whenCompleteAsync((r,e) -> {
            System.out.println("最终结果:" + r);
        },service).exceptionally( ex -> {
            return "gg";
        });

    }


    //两任务组合  a，b 线程完成后 c线程才基于他们的结果执行
    @Test
    public void method7(){

        //CompletableFuture<String> gg = CompletableFuture.completedFuture("gg");
        CompletableFuture<String>  task1 = CompletableFuture.supplyAsync(() -> {
            return " task1";  //必须有return 值
        },service);

        CompletableFuture<String>  task2 = CompletableFuture.supplyAsync(() -> {
            return " task2";  //必须有return 值
        },service).thenCombine(task1,(t1,t2) ->{ // 组合任务1的结果来执行下一步操作
            System.out.println("t1:"+t1);  //任务1 的结果 task1
            System.out.println("t2:"+t2);  //任务2 的结果 task2

            return  t1+t2;
        }).whenComplete((result,exection) ->{
            System.out.println(result); //task1+task2
        });

        //任务3

        //任务4 ...

        //阻塞等待 task1 和 task2  都完成才会执行下一步
        CompletableFuture.allOf(task1,task2).join();
        //上面2个线程结果返回来才走这一步
        System.out.println("ggggg");

    }

}
