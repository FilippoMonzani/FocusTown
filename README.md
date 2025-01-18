<p align="center">
  <img src="https://private-user-images.githubusercontent.com/126600691/404549304-c9b8fb1e-0cda-41ff-89b5-87aa47081e72.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MzcyMTk4ODIsIm5iZiI6MTczNzIxOTU4MiwicGF0aCI6Ii8xMjY2MDA2OTEvNDA0NTQ5MzA0LWM5YjhmYjFlLTBjZGEtNDFmZi04OWI1LTg3YWE0NzA4MWU3Mi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMTE4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDExOFQxNjU5NDJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0wYjdiYTlhMmUyYzI1NmI0MjZlOWJhNDQwMzI2YTk1ZWYyNWFkNzA4NDBmNGY0ZTY2MzhjOWM3Y2NhOGRjOGM1JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.A0giBz4dqSWCtB6WxaQeDhW6WXI-GTJ_HU9GiQQgn28" alt="Sublime's custom image"/>
</p>

# FocusTown
FocusTown è un'applicazione desktop scritta in Java progettata per aiutare gli studenti a organizzare le loro sessioni di studio in modo coinvolgente.

FocusTown, permette agli utenti di impostare un timer per le sessioni di studio e monitorare i loro progressi nel tempo. Al termine di ogni sessione, viene generato un edificio virtuale la cui dimensione è proporzionale alla durata della sessione. Gli edifici vengono aggiunti a una città virtuale, che rappresenta visivamente i risultati complessivi dello studio.

L'applicazione include inoltre una sezione "Statistiche" per analizzare le sessioni passate, fornendo una panoramica dettagliata del tempo dedicato allo studio.

# Team di sviluppo
- Lorenzo Corbellini (l.corbellini@studenti.unibg.it)
- Christian Miele (c.miele1@studenti.unibg.it)
- Filippo Monzani (f.monzani@studenti.unibg.it)
- Sergio Pedercini (s.pedercini1@studenti.unibg.it)


# Tecnologie utilizzate
Il progetto sfrutta le seguenti tecnologie
- [H2 Database](https://www.h2database.com/html/main.html)
- [Hibernate](https://hibernate.org/)
- [Log4j](https://logging.apache.org/log4j/2.x/index.html)
- [FlatLaf UI](https://www.formdev.com/flatlaf/)

L'utilizzo degli strumenti elencati di seguito ha reso più agevole lo sviluppo
- [JUnit](https://junit.org/junit5/)
- [SonarQube](https://www.sonarsource.com/products/sonarqube/)
- StanIDE
# Utilizzo
Prima di tutto clonare il repo

```shell
git clone https://github.com/FilippoMonzani/FocusTown.git
```

Dopodiché avviare il metodo `main` della classe `FocusApp` nel package `main.controller`.

A questo punto si aprirà l'interfaccia di login. Se si vuole vedere una demo delle funzionalità, si può accedere con l'account già presente nel database embedded. Le credenziali dell'account sono le seguenti:

Username: `Roberto`,
Password: `1234`.

In alternativa si può creare un nuovo account e avviare una sessione di studio.
