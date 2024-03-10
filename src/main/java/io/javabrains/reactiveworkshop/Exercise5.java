package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

		// Subscribe to a flux using the error and completion hooks
		ReactiveSources.intNumbersFlux().subscribe(x -> System.out.println(x),
				error -> System.out.println(error.getLocalizedMessage()), () -> System.out.println("Completed"));

		// Subscribe to a flux using an implementation of BaseSubscriber
		ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());
		
		System.out.println("Press a key to end");
		System.in.read();
	}

}

class MySubscriber<T> extends BaseSubscriber<T> {

	@Override
	protected void hookOnSubscribe(Subscription subscription) {
		System.out.println("Subscribed!!");
		request(1);
	}

	@Override
	protected void hookOnComplete() {
		System.out.println("Completed!!");
	}

	@Override
	protected void hookOnError(Throwable throwable) {
		System.out.println("error: "+throwable.getLocalizedMessage());
	}

	@Override
	protected void hookOnNext(T value) {
		System.out.println("value: "+value);
		
		request(1);
	}
	
	

}