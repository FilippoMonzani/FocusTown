
![FocusLogo2](https://github.com/user-attachments/assets/112316de-5f86-426d-acac-98fe63c4409f)

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
