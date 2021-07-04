Feature: Timepass

  Scenario:

    Given User is connected to Database "database_name" with datasource as "datasource_name"
    Then Execute query "query_name" using datasource "datasource_name" and store results in "sqlresults"