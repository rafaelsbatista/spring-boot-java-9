open module com.cortex.main {
	requires java.xml.ws.annotation;
    requires java.instrument;
    requires java.sql;

	requires spring.context;
	requires spring.web;

	requires spring.beans;
	requires spring.core;
	requires spring.webmvc;
	requires spring.boot;
	requires spring.boot.autoconfigure;

	requires com.cortex.cont2;

	exports com.cortex.main;
}