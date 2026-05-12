# TutorialsNinja Hybrid Automation Framework

## Overview
This repository contains an industry-grade Hybrid Automation Framework designed to test the [TutorialsNinja](http://tutorialsninja.com/demo/) e-commerce web application. It is built to demonstrate scalable test architecture, robust reporting, and seamless CI/CD integration.

## Technology Stack
* **Language:** Java
* **Automation Tool:** Selenium WebDriver (v4)
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Architecture:** Page Object Model (POM) & Hybrid Framework structure *(In Progress)*
* **Logging & Reporting:** Log4j2 & ExtentReports *(Upcoming)*
* **CI/CD:** Jenkins *(Upcoming)*

## Day 1: Project Foundation
* Initialized Maven Project.
* Configured `pom.xml` with Selenium and TestNG dependencies.
* Added `maven-compiler-plugin` and `maven-surefire-plugin` for future Jenkins integration.
* Configured `.gitignore` to maintain a clean repository.

## Day 2: Base Architecture & Thread-Safe Execution
* Implemented `ConfigReader` to externalize variables using `config.properties`.
* Designed a thread-safe `DriverFactory` using Java's `ThreadLocal` for parallel execution compatibility.
* Created a `BaseTest` class to handle TestNG `@BeforeMethod` and `@AfterMethod` lifecycle hooks.
* Successfully ran a pilot test case from the requirements document utilizing Selenium Manager.
