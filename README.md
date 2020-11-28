Grails URL shorter.
===

This is an url shortener web project, powered by Grails 4.1.0.M2.

It uses minimal code, thanks to scaffolding.

The database is a simple ram based H2 RDBMS, wiped on every app reload.

It contains specific Heroku's files :
* system.properties : Which jdk version Heroku must use
* Procfile : how Heroku must run the app

Getting Started
---

You need a Java Development Kit (JDK) installed (up to 15).

```sh
./gradlew bootRun
```

==> it runs on http://localhost:8080 in development mode

Deploy with Heroku
---

```
heroku create --region eu
heroku config:set GRADLE_TASK="assemble"
git push heroku master
```
==> it runs on heroku in production mode
