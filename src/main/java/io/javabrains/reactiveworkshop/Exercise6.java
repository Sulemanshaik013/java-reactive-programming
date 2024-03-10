package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
    	String value = ReactiveSources.unresponsiveMono().timeout(Duration.ofSeconds(5)).block();
    	System.out.println(value);
    	
        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
    	String string = ReactiveSources.unresponsiveMono().timeout(Duration.ofSeconds(5)).block();
    	System.out.println(string);
    	
        System.out.println("Press a key to end");
        System.in.read();
    }

}
