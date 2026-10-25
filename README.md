# Energy UI Test Framework

A Selenium/TestNG page-object exercise covering an energy-demo website.

## What is implemented

Page objects for landing, login, registration, and information pages; reusable actions; browser setup; and reporting.

## Build and run

Use JDK 23 or newer and Maven from the repository root. The Maven file is the source of truth for any lower compiler target.

~~~sh
mvn -B test-compile
~~~

## Scope and limitations

Review Configuration/config.properties and TestNG.xml before a live run. The existing setup uses local driver paths under Drivers, so provide compatible browser drivers locally. The demo website may change or be unavailable. This is a learning framework with legacy dependencies, not a production-ready test service.

## Verification

See [verification notes](docs/verification.md) for the exact checks performed. A compile result is not an end-to-end test result.

Local configuration, credentials, browser drivers, generated reports, IDE metadata, and personal data are excluded from new source commits. Existing source notices are retained.