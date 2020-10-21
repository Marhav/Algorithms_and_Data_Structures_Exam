# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Vi har brukt git til å dokumentere arbeidet vårt. Jeg har 16 commits totalt, og hver logg-melding beskriver det jeg har gjort av endringer.

* Oppgave 1: Forsøkte først å løse denne oppgaven med en node. Ved å forsøke å finne ut når ett av barnepekerene ble null. Dette ble problematisk ifm. while løkken som jeg måtte bruke. Løsningen ble å lage en node som hele tiden husket den forrige noden, slik at jeg kunne jeg referere til foreldrenoden.
* Oppgave 2: Her sjekket jeg først om jeg kunne benytte metoden inneholder(T verdi), det virket ikke som det gikk mtp. at metoden hoppet ut etter ett funn, og det var ikke mulig å sjekke flere noder etter det første funnet. Løsningen ble derfor å kopiere den koden for å modifisere den slik at den løp igjennom hele binærtreet til den kom til null, mens den telte antall matcher. Dette fungerte ikke til å begynne med. Etter ekstensiv feilsøking begynte jeg å mistenke at det kunne være at treet ble bygd feil i oppgave 1 selv om oppgaven bestod testen. Jeg kastet inn håndklet og sjekket Programkode 5.2.3 a) i kompendiet. Riktig nok, jeg hadde glemt å knytte den nye noden jeg opprettet til sin respektive node, men alike vell hadde oppgaven bestått testen. Etter at jeg ordnet dette ble alt grønt uten at jeg trengte å endre noe mer i oppgave 2.
* Oppgave 3: Det var litt vansklig å umiddelbart få grep om akkurat hva man skulle i denne oppgaven. Men det falt på plass etterhvert og det store problemet ble fort å få koden til å fungere. Løsningen ble å tegne opp treet som testen laget og gå debuggeren nøye etter i sømmene for å sjekke at treet virkelig var korrekt laget og sammtidig finne ut hva koden feilet med. Litt frem og tilbake, så ble testen grønn.
