# lunatech-application

This is a Java application use 3 different csv files which contain information about the Airports in the world and can be used for two actions `Query` or `Reports` which explained below:

1. Query Option will ask the user for the country name or code and print the airports & runways at each airport. The input can be country code or country name. For bonus points make the test partial/fuzzy. e.g. entering zimb will result in Zimbabwe :)

2. Choosing Reports will print the following:

    10 countries with highest number of airports (with count) and countries with lowest number of airports.
    Type of runways (as indicated in "surface" column) per country
    Bonus: Print the top 10 most common runway identifications (indicated in "le_ident" column)

## Build
You can simply build the project using `mvn clean install`

## Run
Also the project can run using `mvn spring-boot:run`

After run the project all the endpoints can be find in the url below:
`http://localhost:8080/swagger-ui.html`

If you need to look into the h2 database which is used in this project as a cache, it is available in the url below:
`http://localhost:8080/console`

use `jdbc:h2:mem:csv-app` as JDBC URL and `sa` as User Name.  