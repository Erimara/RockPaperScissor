# Rock,  paper, scissor 
## Markus Andersson

### OOP
Objektorienterad programmering handlar i stort sett om att bygga olika objekt som både innehåller information och metoder.

I mitt program som i huvudsak består av en spelare och flera motståndare har jag skapat fyra olika klasser som ett sorts templat.

Klasserna har fördefinierat hur jag vill att mina instanser av klassen ska se ut. Normalt vis, i "vanlig" OOP, kan du också definiera beteenden i klassen. 
Detta kan dock skilja sig beroende på hur du vill bygga ditt program.

Något annat som också är centralt för OOP är fyra principer:
#### Encapsulation
Encapsulation handlar om att samla ihop data på samma ställe, i fallet av Java, i en klass.

Konkret och kort sagt kan vi göra detta genom att göra sätta alla fält vi kan till private. På detta sätt kan vi kontrollera
hur och vem som får hämta informationen. Detta görs genom så kallade "getters" metoder. 

I mitt projekt har jag följt encapsulation principen så mycket som möjligt för att göra min kod mer hanterbar och mindre benägen
att utsättas för felbeteenden.
#### Abstraction
Genom encapsulation har jag också kunnat arbeta mer med abstraction. Abstraction går ut på att en klass helst ska visa vad den gör istället för hur den gör det.

Konkret har jag gjort detta genom att bryta ut metoder till mindre metoder som kallar på varandra. Ett annat konkret exempel är
att jag har brutit ut beteenden i en klass till flera klasser för att ytterligare abstrahera.
Likt normalisering i relationella databaser så kan detta göras för simplifiera(abstrahera) metoder, vilket både gör det mer
läsbart och trevligare att läsa. 

#### Polymorphism
Polymorphism, vilket jag anser vara den viktigaste principen i detta projekt, handlar om att vi kan anta flera olika former utifrån en specifik.

I mitt fall har detta inneburit att koda mot interfaces. Det mest konkreta exemplet är mitt interface "OpponentMethods",
vilket för att ha samma metoder för tre olika klasser. Genom detta interfacet kan jag sedan kalla på "samma metod" fast med olika
beteenden. Polymorphism är även centralt för strategy pattern vilket är ett av de pattern jag har inkluderat i projektet.
#### Inheritance
Inheritence är handlar om hur någonting ärvs. I detta fallet handlar det om hur klasser kan ärva från varandra, vilket gör att
de kan implementera samma fält och metoder som föräldraklassen har. 

I mitt fall har jag inte använt mig av inheritence då mina klasser inte ärver från något annat än interfaces. 

### För- och nackdelar
Fördelar med OOP har för mig varit att jag lättare kan bryta ut kod i mindre komponenter för att sedan sätta ihop dem till ett
"stort" program. OOP gör det även lättare att följa andra principer som är generella inom programmering,
så som DRY(Don't repeat yourself). En annan fördel är att det lättare är att bygga vidare på ett OOP baserat program. 
Om jag så skulle vilja lägga till ytterligare en motståndare så kan jag bygga den seperat utan att resterande kod påverkas.
Detta skapar även tillgänglighet för ett team att kunna arbeta i samma program utan att det krockar.

När det gäller nackdelar har jag svårt att se många med OOP, mestadels på grund av att jag inte provat på andra sätt att programmera på.
Däremot finns det en sak jag har tänkt mycket på, och det är minne. När man gång på gång instansierar nya objekt så tänker jag att det kan ta på minnet.
I Java OOP så krävs detta dock, vilket jag tänker kan skapa problem om man inte är familiär med minneshantering. 

En annan sak jag också tänkt på är att det säkerligen kan bli otroligt komplex om man inte har utmärkt förståelse för vad OOP är,
innan man börjar bygga sitt program. OOP som felanvänds i stora program på tusentals rader kod kommer säkerligen stjälpa mer än att hjälpa
programmeraren.

### Strategy pattern och andra patterns
Strategy pattern handlar om att du har ett flertal olika strategier för att exekvera din kod. 
Som jag nämnde ovan kan du bygga ditt beteende för din klass i "huvudklassen". I strategy pattern vill vi ha kvar huvudklassen för att koppla samman strategin med klassen,
men beteendet ligger i en annan klass.

Genom detta kan vi dynamiskt styra vad klassen har för beteende. 

I mitt program har jag skapat ett gemensamt interface, som implementeras av alla motståndare och deras strategiklasser.

Mina mostståndare tar in respektive strategiklass och returnerar det. När min selectOpponent klass sedan kallas på instansierar den alla
motståndare från allOpponents klassen. På detta vis kan jag implementera nya beteenden i motståndarklasserna beroende på behov.

Ett annat designpattern jag hade kunnat nyttja om programmet skulle vara större hade varit factorypattern. Om jag hade skapat flera hundra olika entiteter
hade det varit lättare att implementera detta mönstret för. Anledningen till varför det hade varit bra är att jag då hade kunnat använda
mig av inheritence genom att skapa en huvudklass t ex "Entity" och sedan skapa subklasser som kan förändra vilket typ av objekt som ska skapas. 

I början av projektet tänkte jag även på hur Command pattern hade kunnat användas
Det exemple jag kom på var att om en klass "Move" hade kunnat ha "Rock", "Paper", "Scissor" och med
logik hade respektive val kunnat kallas på. Det kändes däremot mer rörigt än att använda strategy, vilket gjorde att jag tänkte om.

### SOLID
#### Single Responsibility Principle
Denna Solid-princip är något jag använder hyfsat frekvent i mitt arbete.
Den går ut på att en klass ska endast ha en uppgift. Genom detta kan man undvika buggar och det blir lättare att felsöka.

Genomgående i arbetet har jag delat upp mina klasser så att de främst har en uppgift, detta kan vara
ta emot data för att sedan visa datan i en annan klass. Detta går att se i package "data".
#### Open-Closed Principle
Även denna solid-princip har jag försökt följa i mitt arbete. Den handlar om att klasser
ska vara öppna för extensioner men stängda för modifikationer.

För att uppnå detta har jag följt encapsulation, polymorphism och delvis 
lite inheritence, trots att jag inte ärver från någon specifik klass.

Med hjälp av att koda mot interfaces i t ex "Player" och "Opponents" så har jag kunnat hålla klasserna stängda för modifikationer men öppna för extensioner.
#### Liskov Substitution Principle
Det Barbara Liskov kort sagt menade var att en subclass ska kunna vara utbytbar mot sin huvudklass.
Detta är något jag inte har lyckats följa i mitt arbete. Jag har som tidigare sagt, kodat mott ett interface.
Mina "opponent" objekt(Namnis,Slumpis,Klockis) är således av typen "Opponent" vilket är ett interface. 

Det är svårt för mig att uppnå principen i mitt fall. Däremot hade jag kunnat uppnå den om jag skapat en Opponent klass,
där alla olika opponents ärver från den. I denna huvudklassen hade jag t ex kunnat ha mina namn och moves, varpå subklasserna hade kunnat ärva dessa.
Om jag sen hade försäkrat att alla mina subklasser kan göra exakt samma sak som min huvudklass så hade denna principen varit uppnådd.

Detta är säkerligen något jag hade gjort om jag hade börjat om från början.
#### Interface Segregation Principle
När man använder sig av denna principen vill man dela upp sitt interface så mycket som möjligt.
Exempel på detta är om man har ett interface för former, alla former är inte tre dimensionella, vilket betyder att olika uträckningar kan behöva göras, vilket
i sin tur leder till olika metoder. 
Poängen är att dela upp metoder i olika interfaces så metoder som ej används inte tar upp plats eller skapar buggar.

Detta är något jag har försökt följa i  "Player". Jag hade alla mina metoder i ett interface först men tog sedan ur min metod för att hämna spelarens namn
och implementerade den i ett seperat interface.
#### Dependency Inversion Principle
Den sistnämnda bokstaven i SOLID handlar om att klasser ska inte vara beroende på konkreta klasser
utan istället ska de förlita sig på abstraherade klasser eller interfaces.

Detta är något jag har uppnått någorlunda då jag har försökt abstrahera så mycket som möjligt. Både genom att bryta ut i olika klasser samt skapa interfaces.


### Avslutande tankar