open module com.cortex.messagebroker {
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires jackson.annotations;
	
    requires spring.beans;
	requires spring.context;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires transitive spring.kafka;
	requires transitive kafka.clients;
    
	exports com.cortex.messagebroker;
}