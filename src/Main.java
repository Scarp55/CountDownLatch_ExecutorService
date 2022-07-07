import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newFixedThreadPool(3);

		CountDownLatch countDownLatch = new CountDownLatch(3);

		eService.execute(new Runnable() {

			@Override
			public void run() {
				int sum = 0;
				for (int i = 0; i < 1000000; i++) {
					if (i % 2 == 0) {
						sum += i;
					}
				}
				System.out.println(sum);
				countDownLatch.countDown();
			}
		});

		eService.execute(new Runnable() {

			@Override
			public void run() {
				int sum = 0;
				for (int i = 0; i < 1000000; i++) {
					if (i % 7 == 0) {
						sum += i;
					}
				}
				System.out.println(sum);
				countDownLatch.countDown();
			}
		});

		eService.execute(new Runnable() {

			@Override
			public void run() {
				int sum = 0;
				List<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < 1000; i++) {
					list.add((int) (Math.random() * 1000));
				}
				for (int i : list) {
					if (i % 2 == 0 & i != 0) {
						sum++;
					}
				}
				System.out.println(sum);
				countDownLatch.countDown();
			}
		});

		eService.shutdown();

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExecutorService eService2 = Executors.newSingleThreadExecutor();

		CountDownLatch countDownLatch2 = new CountDownLatch(3);

		eService2.execute(new Runnable() {

			@Override
			public void run() {
				int sum = 0;
				for (int i = 0; i < 1000000; i++) {
					if (i % 2 == 0) {
						sum += i;
					}
				}
				System.out.println(sum);
				countDownLatch2.countDown();
			}
		});

		eService2.execute(new Runnable() {

			@Override
			public void run() {
				int sum = 0;
				for (int i = 0; i < 1000000; i++) {
					if (i % 7 == 0) {
						sum += i;
					}
				}
				System.out.println(sum);
				countDownLatch2.countDown();
			}
		});

		eService2.execute(new Runnable() {

			@Override
			public void run() {
				int sum = 0;
				List<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < 1000; i++) {
					list.add((int) (Math.random() * 1000));
				}
				for (int i : list) {
					if (i % 2 == 0 & i != 0) {
						sum++;
					}
				}
				System.out.println(sum);
				countDownLatch2.countDown();
			}
		});

		eService2.shutdown();

		try {
			countDownLatch2.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
