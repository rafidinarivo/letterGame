# Description du binôme
Sami Nueilati et Alexandre Rafidinarivo

# letterGame
Projet 4A

# Rapport

Notre diagramme de séquence qui à guidé notre réflexion pour le projet se trouve dans le répertoire "rapport"

# Pour faire un build du projet

1. Se postionner à la racine du projet

2. executer la commande : mvn clean install

3. executer la commande : java -jar target/LetterGame-0.0.0-SNAPSHOT.jar

# Réponse aux questions

- Pour les designs pattern, nous avons utilisé des singletons lors de l'implémentation de nos interfaces. Cela nous permettait de bien strucurer notre code et d'avoir des fonctionnalités bien définies pour chaque classe.

- Nous avons également utilisé l'injection de dépendance lors de l'appel de notre interface DictionnaryRepo. Cela permettait de ne pas être dépendant du fichier dico qui était passé en mémoire , afin que si nous voulions un jour 
prendre des informations autrement tel que dans une base de donnée par exemple , nous n'aurions pas à changer nos appels dans le code.

- Pour le Principe SOLID , nous avons essentielement pris part au Single Responsibilty Principle , c'est a dire que l'ensemble des classes que nous avons pensé sont uniquement destiné à une seule responsabilité dans leurs interventions au cours du jeu.