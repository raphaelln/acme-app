
## Synopsis
This is a small web application built with spring mvc, mongodb and angulars to manage basic informations about companies, countries, states and cities. 
## Features
Full list of rest operations:

| Operation | Protocol | Example |
|:--------------------------|:--------|:------------------------------------------------------------------------------------------------------------------|
| /app/country | GET | curl -XGET 'http://localhost:8080/api/country' |
| /app/country | POST | curl -XPOST -H 'Content-type: application/json' -d '{'code':'BR','name':'Brazil'}' 'http://localhost:8080/api/country' |
| /app/country/{id_country} | PUT | curl -XPUT -H 'Content-type: application/json' -d '{'code':'BR','name':'Brazil Updated'}' 'http://localhost:8080/api/country/56c1f3c1182c0d6844c0cf09' |
| /app/country/{id_country} | GET | curl -XGET 'http://localhost:8080/api/country/56c1f3c1182c0d6844c0cf09' |
| /app/country/{id_country} | DELETE | curl -XDELETE 'http://localhost:8080/api/country/56c1f3c1182c0d6844c0cf09' |
| /app/state | GET | curl -XGET 'http://localhost:8080/api/state' |
| /app/state | POST | curl -XPOST -H 'Content-type: application/json' -d '{'country':{'id':'56c1f3c1182c0d6844c0cf09'},'code':'SC','name':'Santa Catarina'}' 'http://localhost:8080/api/state' |
| /app/state/{id_state} | PUT | curl -XPUT -H 'Content-type: application/json' -d '{'country':{'id':'56c1f3c1182c0d6844c0cf09'},'code':'SC','name':'Santa Catarina updated'}' 'http://localhost:8080/api/state/56c1f3c1182c0d6844c0cf09' |
| /app/state/{id_state} | GET | curl -XGET 'http://localhost:8080/api/state/56c1f3c1182c0d6844c0cf09' |
| /app/state/{id_state} | DELETE | curl -XDELETE 'http://localhost:8080/api/state/56c1f3c1182c0d6844c0cf09' |
| /app/city | GET | curl -XGET 'http://localhost:8080/api/city' |
| insert a city | POST | curl -XPOST -H 'Content-type: application/json' -d '{'state':{'id':'56c1f6ff182c0d6844c0cf0a'},'name':'Joinville'}' 'http://localhost:8080/api/city' |
| /app/city/{id_city} | PUT | curl -XPUT -H 'Content-type: application/json' -d '{'state':{'id':'56c1f6ff182c0d6844c0cf0a'},'name':'Joinville updated'}' 'http://localhost:8080/api/city/56c1f3c1182c0d6844c0cf09' |
| /app/city/{id_city} | GET | curl -XGET 'http://localhost:8080/api/city/56c1f3c1182c0d6844c0cf09' |
| app/city/{id_city} | DELETE | curl -XDELETE 'http://localhost:8080/api/city/56c1f3c1182c0d6844c0cf09' |
| /app/company | GET | curl -XGET 'http://localhost:8080/api/company' |
| insert a company | POST | curl -XPOST -H 'Content-type: application/json' -d '{'city':{'id':'56c1f787182c0d6844c0cf0b'},'address':'Test St 52','email':'contact@company.com.br','phoneNumber':'551121555555','owners':['Raphael Luiz Nascimento'],'name':'Company Test'}' 'http://localhost:8080/api/company' |
| /app/company/{id_company} | PUT | curl -XPUT -H 'Content-type: application/json' -d '{'city':{'id':'56c1f787182c0d6844c0cf0b'},'address':'Test St 52','email':'contact@company.com.br','phoneNumber':'551121555555','owners':['Raphael Luiz Nascimento'],'name':'Company Test Update'}' 'http://localhost:8080/api/company/56c1f3c1182c0d6844c0cf09' |
| /app/company/{id_company} | GET | curl -XGET 'http://localhost:8080/api/company/56c1f3c1182c0d6844c0cf09' |
| app/company/{id_company} | DELETE | curl -XDELETE 'http://localhost:8080/api/company/56c1f3c1182c0d6844c0cf09' |
| app/company/{id_company}/owner/add | POST | curl -XPOST -H 'Content-type: application/json' -d '{'John'}'  'http://localhost:8080/api/company/56c200a0182c0d6844c0cf0c/owner/add'|


## Technology Stack

Back-end
: spring-mvc
: spring-boot
: spring-mongodb
: java 8
: mongodb
: maven based project
: webjars

Front-End
:   angularjs 1.5
:   twitter bootstrap 3.3.6
:   font-awesome
:   angular-strap
:   angular-ladda
:   angular-auto-validate
:  angular-ui-bootstrap


## Installation

- Compile the project using maven:  `mvn clean install`

- Download and install mongodb from: https://www.mongodb.org/

## Running
- start a new mongodb instance: 
`%MONGODB_HOME%\bin mongodb --dbpath \path\data\acme-data`
- start the application: 
`mvn spring-boot:run`
- hit the browser at: 
`http://localhost:8080`


## Where to go from where

There is a lot of improvements we could add in this application, following a list of them:

- Security
- Internationalization
- Internationalization

TODO: 

## Contributors

Let people know how they can dive into the project, include important links to things like issue trackers, irc, twitter accounts if applicable.

## License

A short snippet describing the license (MIT, Apache, etc.)






