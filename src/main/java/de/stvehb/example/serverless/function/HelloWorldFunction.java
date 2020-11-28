package de.stvehb.example.serverless.function;

import io.quarkus.funqy.Funq;

public class HelloWorldFunction {

	@Funq
	public String helloWorld() {
		return "Hello World";
	}

}
