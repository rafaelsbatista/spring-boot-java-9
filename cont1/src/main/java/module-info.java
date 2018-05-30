open module com.cortex.main {
    requires java.sql;

	requires spring.context;
	requires spring.web;

	requires spring.beans;
	requires spring.core;
	requires spring.webmvc;
	requires spring.boot;
	requires spring.boot.autoconfigure;

	requires com.cortex.cont2;
	requires com.cortex.messagebroker;

	requires geronimo.j2ee.management;
	
	exports com.cortex.main;
}