# ASE DAM Project

## App Concept
### Conference booking app

#### How to get this Project
Make sure you have Git installed and, in a folder of your preference, run the following in Git Bash:
```bash
git clone https://github.com/codepadawan93/ase-dam-project.git
```
Afterwards open the folder with Android Studio. Remotes should be already set up for you. You can commit and push using the AS built-in functionality in the toolbar: VCS -> Git -> Commit and Push buttons if you don't want to use the CLI. 

If your push is rejected, pull latest changes first and try to push again. If you find conflicts, make a backup of your code in a separate file (just in case) and accept the incoming changes. Test if project compiles and take a note of the latest commit before pushing.

#### User roles
- Professor (provider)
- Student (consumer)

#### Entities
- User - create account, edit/view/delete account, list view account
  - user_id
  - user_name
  - password
  - firstname
  - lastname
  - role
 
- Questionnaire - Professor create/edit/view/delete Questionnaire, list view own questionnaires
    - questionnaire_id
    - title
    - nr_of_questions [EK] 
    - date_start
    - date_end (if they are empty it's always available)
    - hash_code (unique code through which users can access questionnaire)
    - public (true/false)

- Question - Professor create/edit/view/delete by professor when creating Questionnaire
     - question_id
     - title
     - text
     - type (single answer / multiple answer / freeform answer)
     - [EK] remains to be established: will Questions be bound to a Questionnaire, or will we make a m2m table?
     - [AF] nu stiu ce caracteristici ar putea sa aiba in mod deosebt pentru ca practic in questionnaire vom avea un arraylist de intrebari 

- Response - created when a Questionnaire is submitted
     - response_id
     - questionnaire_id
     - completed_on
     - nr_of_correct_answ [EK] not sufficient to remeber the score, we should remember the whole playthrough
     - answers (a LONGTEXT field cotaining a JSON with the playthrough data)
     - user_id 
     //[AF] ?? acesta  va fi folosit pentru history 
       
#### Database
![Database](https://codepadawan93.github.io/assets/dam-ase/database-schema.jpg)

#### Views
- Sign up -[AF]
- Sign in -[AF]
- Main view -[EK]
- Edit/View/Delete User Account form -[AF]
- List view User Accounts - only Professor can see -[EK]
- Add/Edit/View/Delete Questionnaire form - only for Professor -[EK]
- List view all Questionnaires - only for Professor - [EK]
- Add/Edit/View/Delete Question form - only Professor can see -[RG]
- List view all unassigned Questions (all questions that are not associated to a parent Questionnaire) - only for Professor -[RG]
- History - for Student a list of his responses, for Professor a list of all responses grouped by Questionnaire -[RG]
- Question View - only for Student (main game loop)
- Settings -[AG]
- Contact -[AG]
- About -[AG]
- Help [AG]

#### Possible actions
- Student/Professor can create own account
- Only one account per device
- Create Questionnaire with multiple Questions having multiple Answers each
- Question can have one or multiple Answers, and also a max response time, display current score, display feedback if wrong answer was provided, and an attached picture from URL 
- A student will be able to acces a Questionaire on basis of a Code given by Professor
- A Professor will be able to generate a Code providing the Questionnaire he wants to become public and the interval in which itt can be filled out. 
- A flag will control whether a Questionnaire will be traversable at will (a user can go back to previous questions) or only in one way
- Student user can log in to any test if he has the proper code provided by Professor
- Questions are associated to a Category
- Professor must be able to view all instances of a Questionnaire and the Student that participated
- Professor can create a Team
- Each Student can be assigned by a Professor to be part of a Team

### Ideas - Adela
MainActivity:
Menu with 
– Create Account
-	Log in
-	History ( questionnaire and scores for each student) 
-	Settings
-	Contact
-	About
-	Help

-Activities :                       
 - create questionnaire + assign it to a category 
 -	Activity for setting the max response time, display the score and feedback for each questionnaire 
 -	Enter test :  field for the code (if student) 
 -	??? how and where do we generate the codes
  -- [EK] A user of type Professor will receive a hash specific to a questionnaire once he has created it. It will be bound to that specific instance of the questionnaire - if he changes anything, a new code will be generated. In the view where he can edit the questionnaire there will be a field with this code and he can get it from there if he needs it after he created the questionnaire;
 -	??? we need a new activity for each question of a questionnaire or better  use fragments 
  -- [EK] There will only ever be one view, and it will be populated dynamically with different data for each question. We will not create them manually, only the logic behind the display of each field. I am not sure how can this be achieved in Android though, needs more investigation;
 -	Create teams 


## Barem
### Faza 1: (2.5 p)
1. Definirea a minim patru activități/membru echipă; (0.5 p.)
2. Utilizarea de controale variate (Button, TextView, EditView, CheckBox, Spinner, ProgressBar, SeekBar, Switch, RatingBar, ImageView, DatePicker sau TimePicker); (1 p.)
3. Utilizarea a minim un formular de introducere a datelor/membru; (0.5 p.)
4. Transferul de parametri (obiecte proprii și primitive) între minim două activități; (0.5 p.)
5. Toate activitățile aplicației trebuie populate folosind controale vizuale corespunzătoare.

### Faza 2: (2.5 p)
1. Implementarea unui adaptor personalizat (cel puțin trei controale vizuale); (0.5 p.)
2. Implementarea și utilizarea unor operații asincrone; (1 p.)
3. Utilizarea claselor pentru accesul la resurse externe (din rețea); (0.5 p.)
4. Prelucrarea de fișiere JSON sau XML. Fișierele trebuie să conțină cel puțin 3 noduri dispuse pe niveluri diferite. Fiecare nod trebuie sa aibă cel puțin 3 atribute; (0.5 p.)

### Faza 3: (2.5 p)
1. Utilizarea fișierelor de preferințe; (0.5 p.)
2. Crearea unei baze de date SQLite cu minim două tabele cu legături intre ele (o tabelă/membru). Implementarea operațiilor de tip DDL; (0.5 p.)
3. Implementarea operațiilor de tip DML. Pentru fiecare tabela sa se implementeze cel puțin o metoda de insert, update, delete si select. Toate metodele trebuie apelate; (0.5 p.)
4. Definirea a minim două rapoarte pe datele stocate în baza de date. Prin raport, se înțelege afișarea pe ecranul dispozitivului mobil a informațiilor preluate din baza de date. Rapoartele sunt diferite ca si structura. (0.5 p.). Componentele vizuale în care se afișează cele doua rapoarte trebuie sa fie diferite de cele prezentate la faza 1 și 2
5. Salvarea rapoartelor în fișiere normale. (txt, csv etc.) (0.5 p.)

### Final: (2.5 p)
1. Utilizarea bazelor de date la distanță (Firebase) (salvare/restaurare); Afișarea informațiilor din Firebase să se realizeze prin intermediul componentelor vizuale (se pot folosi activitățile deja prezentate în fazele anterioare) (0.75 p.)
2. Utilizarea de elemente de grafică bidimensională, cu valori preluate din baza de date (locală sau la distanță); (0.5 p.)
3. Prelucrarea elementelor de tip imagine din diferite surse (imagini statice, preluate prin rețea, încărcate din galeria dispozitivului mobil, preluate din baze de date locală sau la distanță); Imaginile trebuie preluate din minim două surse. (0.5 p.)
4. Stilizarea aplicației mobile (de exemplu, se creează o temă nouă în fișierul styles.xml sau
modificați fontul, culorile componentelor vizuale) (0.5 p)
5. Implementarea unei funcționalități pe bază de Google Maps; (0.25 p.)

### Componente
- Aplicație mobilă pentru platformele Android - faza I
- Bază de date pentru stocarea datelor utilizatorilor, a testelor și a rezultatelor/rapoartelor - faza
II

### Cerințe funcționale
1. Platforma trebuie să fie cât mai ușor de folosit - număr minim de click-uri și input pentru a
participa la teste
2. Platforma trebuie să permită administrarea a două tipuri de utilizatori: studenți și profesori
3. Aplicația trebuie să permită înregistrarea studenților și a profesorilor cu adresele de
email/conturile instituționale
4. Aplicația trebuie să permită înregistrarea unui singur utilizator (aplicația mobilă nu poate fi
folosită de mai mulți utilizatori în același timp pe același dispozitiv)   AF 
5. Autentificarea utilizatorilor se va face prin serviciul LDAP al ASE (se va folosit REST API-ul
dezvoltat)
6. Platforma mobilă trebuie sa permită crearea de conținut - întrebări de tip grilă cu
  a. număr limitat de opțiuni    facut
  b. timp maxim de răspuns       RG
  c. punctaj                      facut ?
  d. feedback pentru răspuns greșit      
  e. imagine sau video atașat (din sursă locală sau URL)
7. Platforma trebuie să permită evaluarea în timp real a răspunsurilor - cu feedback imediat
pentru profesor și student participant    RG
 8. Platforma trebuie să permită profesorilor să controleze când testul devine activ/inactiv
  a. perioada de vizibilitate a testului   EK
  b. cod de acces la test    facut 
V1.0/20181007
9. Platforma trebuie să permită definirea de teste publice (liber accesibile pe platformă) dar și
private (accesul este controlat de profesor). Alte caracteristici pentru un test       AF  
  a. amestecarea întrebărilor și a răspunsurilor
  b. numărul de încercări de rulare a testului 
  c. furnizare feedback - răspunsul corect sau un text asociat întrebării
  d. afișarea scorului final
  e. alocare timp per test - suprascrie timpul asociat fiecărei întrebări
  f. alocare punctaj unitar pe fiecare întrebare
  g. posibilitatea de a reveni la întrebări anterioare/posibilitatea de a parcurge testul doar într-un sens
10. Platforma trebuie să permită studenților să se înscrie/să participe la un test activ - soluție
recomandată pe baza unui cod dat de profesor facut 
11. Platforma trebuie să permită gestiunea testelor existente
  a. fiecare profesor are un portofoliu de teste și un portofoliu de întrebări ce pot fi clasificate pe diferite categorii (într-o prima fază se poate merge pe o soluție în care întrebările sunt asociate direct unui test)   facut 
  b. profesorii pot partaja teste între ei cu diferite drepturi (utilizare și/sau editare)   ?AF
12. Platforma trebuie să permită gestiunea istoricului unui student: când a dat un test și ce punctaj a obținut    facut ?
13. Platforma trebuie să genereze rapoarte pentru profesor     AG
  a. lista studenților care au dat un test și punctajul acestora
  b. lista răspunsurilor date de un student pentru un test 
14. Platforma trebuie să permită interacțiunea între studenți, acești putând fi incluși în echipe
(generate aleatoriu sau după alte criterii)
15. Platforma trebuie să permită crearea de întrebări diferite (de tip grilă cu răspuns unic sau
multiplu - obligatoriu, cu răspuns deschis)   facut 

### Depunctări
- 2 puncte - nerespectarea cerințelor de predare a proiectului (mod de trimitere a fișierelor,
denumire arhivă, structură arhivă, neștergerea directoarelor build).
- 2 puncte – lipsa documentației sau nerespectarea conform cerințelor de elaborare conform
structurii
- toate șirurile de caractere utilizate la nivelul interfeței trebuie preluate din resurse. Lipsa
acestora duce la o penalizare de 0.5 din fiecare faza.


## Project
### Faza 1: (2.5 p)
1. Definirea a minim patru activități/membru echipă; - 14 activities (good enough)
2. Utilizarea de controale variate:
- [x] Button
- [x] TextView
- [x] EditView
- [x] CheckBox
- [x] Spinner
- [X] ProgressBar
- [ ] SeekBar
- [x] Switch
- [ ] RatingBar
- [x] ImageView
- [x] DatePicker sau TimePicker)
3. Utilizarea a minim un formular de introducere a datelor/membru;
- [x] done
4. Transferul de parametri (obiecte proprii și primitive) între minim două activități;
- [x] done
5. Toate activitățile aplicației trebuie populate folosind controale vizuale corespunzătoare.
- [x] done

### Faza 2: (2.5 p)
1. Implementarea unui adaptor personalizat (cel puțin trei controale vizuale);
- [x] done (Gherghe)
2. Implementarea și utilizarea unor operații asincrone; (1 p.)
- [x] done by Adela
3. Utilizarea claselor pentru accesul la resurse externe (din rețea); (0.5 p.)
- [x] done by Adela
4. Prelucrarea de fișiere JSON sau XML. Fișierele trebuie să conțină cel puțin 3 noduri dispuse pe niveluri diferite. Fiecare nod trebuie sa aibă cel puțin 3 atribute; (0.5 p.)
- [x] done by Adela

### Faza 3: (2.5 p)
1. Utilizarea fișierelor de preferințe; (0.5 p.)
- [x] done (Adela & Erik)
2. Crearea unei baze de date SQLite cu minim două tabele cu legături intre ele (o tabelă/membru). Implementarea operațiilor de tip DDL; (0.5 p.)
- [x] done by Raluca
3. Implementarea operațiilor de tip DML. Pentru fiecare tabela sa se implementeze cel puțin o metoda de insert, update, delete si select. Toate metodele trebuie apelate; (0.5 p.)
- [x] mostly done, will have to be fully tested in Help and Contact (Raluca)
4. Definirea a minim două rapoarte pe datele stocate în baza de date. Prin raport, se înțelege afișarea pe ecranul dispozitivului mobil a informațiilor preluate din baza de date. Rapoartele sunt diferite ca si structura. (0.5 p.). Componentele vizuale în care se afișează cele doua rapoarte trebuie sa fie diferite de cele prezentate la faza 1 și 2
- [x] mostly done, will have to be fully tested in Help (Raluca) - will be serialized and saved in db
5. Salvarea rapoartelor în fișiere normale. (txt, csv etc.) (0.5 p.)
- [ ] pending (Raluca) - parse and create text

### Final: (2.5 p)
1. Utilizarea bazelor de date la distanță (Firebase) (salvare/restaurare); Afișarea informațiilor din Firebase să se realizeze prin intermediul componentelor vizuale (se pot folosi activitățile deja prezentate în fazele anterioare) (0.75 p.)
- [x] done (Erik) for question, questionnaire, user and response
2. Utilizarea de elemente de grafică bidimensională, cu valori preluate din baza de date (locală sau la distanță); (0.5 p.)
- [x] pie chart for questionnaires, mostly done (Erik) - [references](https://stackoverflow.com/questions/20835628/how-to-draw-a-pie-chart-in-android)
3. Prelucrarea elementelor de tip imagine din diferite surse (imagini statice, preluate prin rețea, încărcate din galeria dispozitivului mobil, preluate din baze de date locală sau la distanță); Imaginile trebuie preluate din minim două surse. (0.5 p.)
- [x] done (Gherghe)
4. Stilizarea aplicației mobile (de exemplu, se creează o temă nouă în fișierul styles.xml sau
modificați fontul, culorile componentelor vizuale) (0.5 p)
- [x] done (Gherghe)
5. Implementarea unei funcționalități pe bază de Google Maps; (0.25 p.)
- [ ] pending (Adela) - status on this?

### Misc tasks
1. Toate șirurile de caractere utilizate la nivelul interfeței trebuie preluate din resurse. Lipsa
acestora duce la o penalizare de 0.5 din fiecare faza.
- [x] pending (Erik), mostly done
2. Game should be actally playable
- [x] mostly done (Team - refer to "Specificatii Functionale")

### Functionality tasks
- [x] Implement response list
- [x] Implement [Stats pie chart](https://stackoverflow.com/questions/20835628/how-to-draw-a-pie-chart-in-android)
- [x] Implement dynamic User
- [x] Do not let user go back to a question and increase their score ([reference](https://stackoverflow.com/questions/4779954/disable-back-button-in-android))

### QA Checklist for 19.12.2018
- [x] scos stringuri hardcodate
- [x] fara crashuri
- [x] fara scame, injuraturi etc
- [x] cu date de test in el

### Update 28.12.2018
- Eu [Adela] o sa vad cum se face aia cu inregistragea unui singur utilizator, 
- sa vad cum faci daca testul e public sau privat adica stiu ca atunci cand il creezi e switch ul ala acolo, dar nu stiu daca e functional inca [EK] - este functional, se salveaza in Firebase. Daca ai nevoie o sa iti dau acces si tie insa ar fi destul de dificil pentru ca e pe contul meu de google personal. Cand se construieste un obiect de tip Questionnaire poti apela metoda isIs_Public() (e denumita ampulea pt ca e autogenerata... in fine) si obtii un boolean (public - da/nu)
- si o sa mai incerc sa vad ce imi iese de la pct 9 la cerinte functionale ca e prea mult se scris acum. [EK] Platforma trebuie să permită definirea de teste publice (liber accesibile pe platformă) dar și private (accesul este controlat de profesor). Asta e ok, mai trebuie facuta logica ca testele publice sa apara undeva, iar cele provate sa poata fi abordate doar in urma inserarii codului generat. 
- Si sa vad si cum se face partajarea de teste intre profesori - [EK] deocamdata nu exista diferentiere intre useri, deoarece conceptul de user nu exista inca la nivel de aplicatie. Trebuie intai facuta salvarea in firebase a unui user si de abia dupa aia poate fi facuta partea asta
- Raluca o sa se ocupe in continuare de punctaj timp etc sa vada daca sunt functionale [EK] Punctajul este functional si se salveaza fiecare chestionar completat in baza de date. Se pot accesa la History
- si alex a ramas ca vede cum e cu gestiunea rapoartelor pt profesori care e cerinta 13 [EK] nu exista Useri in platforma inca. Trebuie facuta integrarea cu Firebase la User
- Acuma am vazut ca a mai ramas punctele: 
    - 6 - [EK] realistic vorbind si dat fiind viteza de dezvoltare pe care am avut-o pana acum, vor exista doar cele cu raspuns singular. Ar trebui sa refacem foarte mult pentru a permite si altceva. Ar fi nevoie de o regandire a logicii din jocul propriu-zis si de noi view-uri, etc, etc, pt care nu avem timp. Singurul punct de aici pe care are sens sa il implementam este feedbackul instant (sa aratam userului ca a gresit/a nimerit) 
    - 8 - [EK] se poate face rapid, se face o verificare a timpului curent vs intervalul in care chestionarul e activ si se baga userul in chestionar respectiv se afiseaza un toast cu mesajul "This questionnaire is avaliable only between X and Y", 
    - 10 - [EK] done, 
    - 11 - [EK] se poate teoretic umbla la logica de query dar introducem complexitate inutila. E mai simplu cu "toata lumea vede tot". 
    - 12 - [EK] Nu exista Useri si in concluzie nu exista nici Studenti
    - si 15 [EK] Se pot face cu 4 intrebari si un sg raspuns. Am putea face relativ simplu sa putem adauga cu raspuns multiplu, dar vrem asta? complica lucrurile, stiu ca zice omul ca e obligatoriu, insa chiar mi se pare ca da chestiile un pic peste cap
    
#### Din ideile astea am observat ca lucrurile stau cam asa: 
1. Trebuie de urgenta sa avem o entitite de tip User in program ca de aia depinde tot restul
2. am simplificat unele functionalitati cerute pentru a avea timp sa le implementam. Nu avem cum, realistic, sa implementam TOT
3. exista o serie de cerinte care se pot implementa relativ usor. Eu sugerez ca astea sa faca obiectul urmatorului sprint (vezi [Low-Hanging Fruit](https://github.com/codepadawan93/ase-dam-project#update-28122018))

#### Low-Hanging fruit:
- [x] Raluca o sa se ocupe in continuare de punctaj timp etc sa vada daca sunt functionale [EK] Se poate implementa contorul, deocamdata se poate hardcoda o valoare. Mai tarziu pot eu adapta forma de Question si modelul ca sa poti adauga un timp. Timpul default va fi de 30sec (cel hardcodat) - done (Erik)
- [x] feedbackul instant [EK] sa aratam userului ca a gresit/a nimerit - se inverzeste raspunsul bun si se inroseste raspunsul prost daca a fost ales - done (Erik)
- [x] Platforma trebuie să permită profesorilor să controleze când testul devine activ/inactiv a. perioada de vizibilitate a testului [EK] se poate face rapid, se face o verificare a timpului curent vs intervalul in care chestionarul e activ si se baga userul in chestionar respectiv se afiseaza un toast cu mesajul "This questionnaire is avaliable only between X and Y" daca timpul curent nu e intre valorile specificate in Firebase. Atentie: in firebase am memorat timpul ca timestamp Unix (nr de secunde de la 1 ian 1970) si asa se va face comparatia, timpul curent se va converti la acelasi format - pending (Adela)

#### Implementation of User:
SignUpActivity.java ->
saveInfo()
Save to Firebase

1. Sign In or Sign Up
2. Sign In if you have username/pass in Firebase -> save in shared preferences
3. Sign Up if you don't and want to create -> save in shared preferences and save in Firebase
4. If present in shared preferences, when entering the app the user will be authenticated from Firebase data in shared preferences will be updated. No further requests to Firebase will be made until app exit.
5. In main activity a Log In button will be present if no user exists in shared prefs
6. In main activity a Log Out button will take its place if present

#### Tasks:
1. Save in Firebase - [Erik]
2. The buttons - [Adela]

## Authors
- Frentescu Adela
- Ganea Raluca
- Gherghe Alexandru
- Kovacs Erik
