module com.cortex.messagebroker {
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires jackson.annotations;
	requires jms;
	
    requires spring.beans;
	requires spring.context;
	requires spring.jms;
	requires spring.boot;
	requires spring.boot.autoconfigure;
    
	exports com.cortex.messagebroker;
}