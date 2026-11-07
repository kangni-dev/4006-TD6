# TD6

## Tests composants avec une base de données: `HibernateLibraryRepository`

Implémenter les tests composants pour `HibernateLibraryRepository` avec la base de données H2.

Pourquoi ce sont des tests composants et non des tests unitaires?

## Tests composants avec un API: `LibraryResource`

Utilisez `JerseyTest` pour implémenter les tests permettant de valider la réponse API `POST /books` de LibraryResource.

#### Réponses attendues :

HTTP 201 CREATED

Si la librarie n'existe pas:

HTTP 404 NOT FOUND

```
{
    "error": "LIBRARY_NOT_FOUND",
    "message": PAS À VALIDER DANS LES TESTS
}
```
Si le livre existe déjà dans la librairie:

HTTP 400 BAD REQUEST

```
{
"error": "BOOK_ALREADY_PRESENT",
"message": PAS À VALIDER DANS LES TESTS
}
```

Réfléchissez aux périmètres de vos tests pour que ce soit bien des tests **composants**.

## Tests multi-composants avec Cucumber

Utilisez [Cucumber](https://cucumber.io/docs/guides/10-minute-tutorial) pour implémenter un test multi-composants avec l'API et la base de données en mémoire 
pour la fonctionnalité ci-dessous:

- Lorsqu'un livre est ajouté à la librairie avec `POST /books`, on peut voir le livre dans la librairie avec `GET /books`.
- 
    **Réponse de `GET /books`**
    
    HTTP 200 OK
    ```
    {
    "books": [
      {
        "title": "...",
        "author": "..."
      },
      ...
      ]
    }
    ```

### Critères Cucumber 
* Les tests Cucumber doivent être écrits en français (vous devez utiliser les mots clés en français: Fonctionnalité, Etant donné, Quand, etc).
    * Les ENUM, les noms de champs et les noms d'erreurs peuvent être en anglais.
* Un scénario = Un test
* Les titres des scénarios doivent être clairs et auto-descriptifs.
* Le contenu des scénarios doit être facilement lisible.
* Le contenu des scénarios doit suivre la formule Given, When, Then (ou Étant donné, Quand, Alors).
* Les définitions d'étapes (Step Definitions) ne doivent pas avoir de duplications de code excessives et doivent être réutilisables.

### Comment mettre Cucumber en place
1. Créer le `RunnerTest` pointant vers le dossier des StepDefinitions (`stepDefinitions`)
  ``` java
   @RunWith(Cucumber.class)
   @CucumberOptions(glue = {"td6.multiComponents.stepDefinitions"})
   public class TestRunner {}
  ```
2. Implémenter vos scénarios dans un fichier _.feature_ dans `test/resources/td6/multiComponents/features` ([Comment écrire un scénario](https://cucumber.io/docs/guides/10-minute-tutorial/#write-a-scenario))
3. Implémenter les StepDefinition dans le dossier spécifié au TestRunner (`stepDefinitions`). ([Comment implémenter un StepDefinition](https://cucumber.io/docs/cucumber/step-definitions))
   - Le plus simple est d'utiliser [REST Assured](https://rest-assured.io/) pour appeler l'API et valider les réponses.
4. Ajouter `@Before` et `@After` dans le StepDefinition pour démarrer et fermer le serveur pour les tests.
   - Pour utiliser la base de données en mémoire, utilisez la méthode `ConfigurationServerRest.useInMemoryRepositories()` avant de démarrer le serveur.
5. Lancer vos tests Cucumber à partir du `RunnerTest` et en exécutant `mvn test`.

### Exercices supplémentaires
1. Ajouter un scénario validant que le code de statut est bien 201 si le livre est bien ajouté à la librairie
2. Réusiner vos StepDefinitions en créant une classe utilitaire dédiée aux appels API.
   - Cela permet de garder les StepDefinitions propres, surtout avec l'ajout de nouveaux scénarios.
3. Essayez de séparer vos StepDefinition dans plusieurs fichiers distincts. Vos scénarios doivent toujours passer après cette séparation.
