# Zadanie 2 - Veža v bludisku
B-OOP 2021

Vašou úlohou je naprogramovať oknovú aplikáciu v jazyku Java s pomocou knižnice Swing. Používateľské rozhranie aplikácie má pozostávať z:

* canvasu
* bočného menu (jeho umiestnenie si zvoľte sami)

Po spustení aplikácie vygenerujte pomocou algoritmu [náhodného prehľadávania do hĺbky](https://www.baeldung.com/cs/maze-generation#dfs-maze) bludisko a vykreslite ho na canvas.
Mriežka v ktorej generujete bludisko nemôže byť menšia ako 11x11 políčok (vrátane stien), pričom bludisko musí byť obohnané stenou (žiadna cesta v bludisku sa nemôže dotýkať okraju okna).

Vo vygenerovanom bludisku zvoľte ľubovoľným spôsobom jeden začiatočný a jeden cieľový bod. Na začiatočný bod umiestnite hráčovu figúrku. Hráč sa môže v bludisku pohybovať 3 spôsobmi:
* pomocou šípok na klávesnici, vždy o jedno políčko určeným smerom, pričom nemôže vsúpiť na políčko obsahujúce stenu.
* pomocou myši. Po kliknutí na figúrku je ňou možné pohnúť ako vežou v šachu (t.j. ľubovoľný počet políčok zvyslo, alebo vodorovne). Cieľ cesty zvolí hráč druhým kliknutím myši, pričom je potrebné zvýrazniť políčka na ktoré sa hráč môže presunúť keď sa nad nimi nachádza myš. Pri pohybe takýmto spôsobom nie je možné preskočiť stenu bludiska.
* pomocou tlačidiel na bočnom menu, predstavujúcich šípky. Pre tento pohyb platia rovnaké pravidlá, ako pre pohyb pomocou klávesnice

Keď hráč dosiahne cieľ, vygenerujte nové bludisko a hra začína od začiatku.

Bočné menu musí obsahovať:
* počítadlo úspešne vyriešených bludísk
* tlačidlo na reštartovanie hry, ktoré vyresetuje počítadlo a vygeneruje nové bludisko
* tlačidlá reprezentujúce šípky, pomocou ktorých je možné pohybovať hráčovou figúrkov. Tieto tlačidlá musia byť rozmiestnené tak, ako sú rozmiestnené šípky na bežnej klávesnici.



## Hodnotenie

Zadanie je hodnotené 15 bodmi. **Odovzdaný program musí byť skompilovateľný, inak je
hodnotený 0 bodmi**. Skompilovateľnosť zadania kontroluje aj github pipeline. Hlavný dôraz v hodnotení sa kladie na objektový prístup a princípy OOP,
okrem iného:

* vhodné pomenovanie tried, metód a premenných v jednotnom jazyku (názvy tried s veľkým počiatočným písmenom, názvy metód s malým),
* vhodné použitie modifikátorov prístupu (public, private, poprípade protected) na obmedzenie prístupu k metódam a atribútom,
* využitie dedenia a polymorfizmu,
* použitie výnimiek na ošetrenie nedovoleného správania (nehádzať a nezachytávať všeobecnú triedu Exception),
* nepoužívajte nested classy,
* vo vašich triedach nevytvárajte statické metódy ani nekonštantné statické premenné (v zadaní nie sú potrebné),
* v hlavnej triede (main) nevytvárajte žiadnu logiku, iba vytvorte nový objekt,
* vo svojom riešení môžete použiť knižnicu lombok a jej anotácie. Potrebná dependencia je už pridaná v _pom.xml_ súbore.

## Odovzdávanie
Zadanie si naklonujte z repozitára zadania výhradne pomocou poskytnutej linky cez GitHub Classroom (pokiaľ si vygenerujete vlastný repozitár pomocou tlačidla "Use this template" z template repozitára, my váš repozitár neuvidíme a nebudeme ho hodnotiť!). Svoje vypracovanie nahrajte do pre vás vytvoreného repozitára pre toto zadanie pomocou programu Git (git commit + git push).
Skontrolujte si, či sa váš repozitár nachádza pod skupinov **Interes-Group**, inak nemáme prístup ku vášmu repozitáru a zadanie sa nepovažuje za odovzdané. Vypracovanie môžete "pusho-vať" priebežne. Hodnotiť sa bude iba _master_ branch. Zadanie je nutné vypracovať do **23.4.2021 23:00**.

V projekte upravujte iba súbory v priečinku _src/main_ a jeho podpriečinkoch. Ostatné súbory je upravovať zakázané (predovšetkým súbory _pom.xml_ a súbory obsahujúce github pipeline-y).

Vo svojom github účte si nastavte svoje meno (settings > profile > name), aby bolo možné priradiť riešenie ku študentovy. **Pokiaľ nebude možné spárovať študenta s riešením je zadanie hodnotené 0 bodmi!**

# Assignment 2 - Rook in a maze
B-OOP 2021

Your task is to create a java window application with the Swing library. The user interface of the application must consist of:
* canvas
* side menu (you can choose the location of this side menu freely)

When the application starts, generate a maze using the [randomized depth first search](https://www.baeldung.com/cs/maze-generation#dfs-maze) algorithm and draw it onto the canvas.
The grid containing the maze must be at least 11x11 tiles large (including wall tiles). The entire maze must be surrounded by walls (no paths in the maze can touch the borders of the window).

In the generated maze choose in any way a starting and a goal point. Place the player figure on the starting point. The player can move their figure in 3 ways:
* by using the arrows keys on their keyboard. Always by one tile in the specified direction. They cannot enter a tile that contains a wall.
* by using the mouse. When the player figure is clicked, it can be moved like a rook chess piece (i.e. any number of tiles in the horizontal, or vertical directions).
The destination is chosen by a second mouse click. Tiles that can be moved to in this manner must be highlighted, when the mouse hovers over them. When moving in this manner, the player cannot jump over walls.
* by using buttons on the side menu, that represent the arrow keys. The rules for moving in this manner are the same, as for the movement by the arrow keys on the keyboard.

When the player reaches the goal point, the application should generate a new maze and the game starts over.

The side menu must contain:
* a counter of successfully completed mazes
* a button that resets the counter and generates a new maze
* buttons representing the arrow keys, which can be used to move the player. These buttons must be placed in the same way, they are placed on a regular keyboard.



## Grading
You can get 15 points for this assignment. **The program must be able to compile, otherwise 0 points are given for the assigment**.
The github pipeline checks whether the program can be compiled. The main focus during grading is put on object-oriented approach and OOP principles used by the solution.
Including, but not limited to:
* appropriate naming of classes, methods and variables in a single language (class names starting with a capital letter, method names starting with a lowercase letter),
* appropriate use of access modifiers (public, private, or protected) when restricting access to class methods and attributes,
* the use of inheritance and polymorphism,
* usage of exceptions when handling undesired behavior (do not catch or throw the instances of the generic Exception class),
* don't use nested classes,
* don't use static methods, or non-constant static variables (you don't need them to complete the assignment),
* don't put any logic into the main method and its class. The main method should only be used to create a new object,
* you can use the lombok library and its annotations in your solution. The neccessary dependency is already present in the _pom.xml_ file.

## Handing in the assigment
Clone the assignment from the repository created from this template by the provided link trough GitHub Classroom (if you create your own repository with the "use this template" button, we won't be able to see your repository and we won't be able to grade it!). Upload your solutions to your repository using the Git version control system (git commit + git push).
Make sure, that your repository was created under the **Interes-Group** group, otherwise we won't be able to access your repository, and the assignment will not be graded.
You can push commits to the repository while you work - you don't have to push everything at once. Only the code in the _master_ branch will be graded. You have until **23.4.2021 23:00** to complete the assignment.

Only edit files in the _src/main_ folder or its sub-folders. You mustn't change any other files in the repository (especially the _pom.xml_ file, and the github pipeline files).

You have to have your name set in your github account (settings > profile > name), so that we can match students with their assignments. **If we are unable to match a student with their assignment, the student will receive 0 points for the assignment!**
