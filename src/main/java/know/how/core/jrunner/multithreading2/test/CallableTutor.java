package know.how.core.jrunner.multithreading2.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * �?нтерфей�? Callable<T> позволяет �?оздавать потоки, возвращающие рез�?льтат
 * выполнения Т.
 *  
 * 1) Попроб�?йте зап�?�?тить кла�?�? и по�?мотреть на рез�?льтаты и время выполнения.
 * 		Замените вызов newSingleThreadExecutor() на  newFixedThreadPool() 
 * 		и �?равните время выполнения.
 * 2) �?�?польз�?йте вме�?то executorService.execute() вызов executorService.submit()
 * 		�? �?охранением рез�?льтата Future в ма�?�?иве results.
 * 3) Попроб�?йте прекратить выполнение первых 3-х потоков, и�?польз�?я метод cancel().
 * 		Добавьте обработк�? CancellationException.
 * 4) Добавьте перед прекращением работы потоков �?он на 150 �?ек�?нд.
 * 		Поэк�?периментир�?йте �? размером п�?ла: �?колько потоков �?�?пеют завер�?ить работ�?,
 * 		а �?колько нет (�?�?тановите, например, значение 2). 
 * 		При прекращении работы потоков добавьте логгирование, 
 * 		�?ообщающее, завер�?ил ли работ�? поток:
 * 			log("cancelling thread "+i+", isDone="+results.get(i).isDone());
 *	5) Добавьте �?ообщение по�?ле завер�?ения �?на StringGenerator:
 *			log("thread is finished: "+allStrings[index]);
 *		Попроб�?йте поэк�?периментировать �?о значениями параметра 
 *      cancel: true или false.
 *
 */
public class CallableTutor {
    static StringBuffer buf = new StringBuffer();
    static void log(String s) {
        buf.append(s+"\n");
    }

	public class StringGenerator implements Callable<String> {

		public String call() throws Exception {
        	String[] allStrings = { "Cow", "Goose", "Cat", "Dog", 
        	        "Elephant", "Rabbit", "Snake", "Chicken", 
        	        "Horse", "Human" };
			int index = (int)(Math.random()*100)/10;

			Thread.sleep(10);
			return allStrings[index];
		}
	}
	
	@Test
	public void testCallable() {
		long start = new Date().getTime();
		List<Thread> threads = new ArrayList<Thread>();

		ArrayList<Future<String>> results = new ArrayList<Future<String>>();

		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		//ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i=0;i<10;i++) {
			results.add(executorService.submit(new StringGenerator()));
		}

        // try to cancel 5 of 10 threads here
		for (int i=0;i<5;i++) {
			log("cancelling thread "+i);
			results.get(i).cancel(true);
		}

		StringBuilder resultStr = new StringBuilder();
		for(Future<String> result: results){
			try {
				// The blocking get call
				if (!result.isCancelled()) {
					resultStr.append(result.get());
					resultStr.append(" ");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(resultStr);

		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long time =new Date().getTime()-start;
		System.out.println("Time of work:"+time);
		
		System.out.println(buf);
	}

}

