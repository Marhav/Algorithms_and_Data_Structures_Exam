package no.oslomet.cs.algdat.Eksamen;


import java.util.*;

public class EksamenSBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
        //Sjekke at verdi ikke er null
        Objects.requireNonNull(verdi, "Kan ikke legge til nullverdier i binærtreet!");

        //Løkke som sammenlikner verdi med verdier i treet.
        //Brukt Programkode 5.2.3 a) som referanse.
        Node<T> current = rot;
        Node<T> currentLast = null;
        int comparator = 0;
        while (current != null) {                                               //Går ut av løkken når man kommer til en node med child peker som peker på null.
            currentLast = current;
            comparator = comp.compare(verdi, current.verdi);
            current = comparator < 0 ? current.venstre : current.høyre;       //Hopper til høyre om verdi er større enn en nodes verdi, eller til venstre dersom verdi er mindre.
        }

        //Opprett en ny node på plassen man fant i løkken over.
        current = new Node<>(verdi, currentLast);

        if (currentLast == null) rot = current;                                  // Current blir rotnode
        else if (comparator < 0) currentLast.venstre = current;                 // Venstre barn blir current
        else currentLast.høyre = current;                                       // Høyre barn blir currnet

        antall++;
        return true;
    }

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {                //Sjekket hvordan inneholder fungerer, tror ikke den kan brukes her, men en liknende metode som fortsetter å lete, selv etter funn kan fungere.
        int teller = 0;
        //Her har jeg kopiert og modifisert kode fra inneholder(T verdi) metoden.
        if (verdi == null) return teller;       //Sjekker om verdi er null, returnerer evt 0 som oppgaven ber om.

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp == 0) {
                teller++;
                p = p.høyre;
            } else p = cmp < 0 ? p.venstre : p.høyre;
        }
        return teller;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        while (p.venstre != null || p.høyre != null) {
            if (p.venstre != null) p = p.venstre;       //Venstre barn eksisterer.
            else p = p.høyre;                           //Ingen venstre barn, men høyre barn eksisterer.
        }
        return p;                                       //Funnet bladnode lengs til venstre.
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
            Node<T> q = p.forelder;
            if (q == null) {                                         //p er rotnoden(siste i postorden)
                return null;
            }else if (q.høyre == p) {                                //p er høyre barn til sin forelder.
                return q;
            }
            else if (q.venstre == p && q.høyre == null) {            //p venstre barn til sin forelder og enebarn.
                return q;
            }
        return førstePostorden(q.høyre);                             //p er venstre barn til sin forelder, men ikke enebarn.
    }



    public void postorden(Oppgave<? super T> oppgave) {
        Node<T> p = førstePostorden(rot);
        while (p != null) {
            oppgave.utførOppgave(p.verdi);
            p = nestePostorden(p);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if(p.venstre != null) postordenRecursive(p.venstre, oppgave);
        if(p.høyre != null) postordenRecursive(p.høyre, oppgave);

        oppgave.utførOppgave(p.verdi);
    }

    public ArrayList<T> serialize() {
        //Opprette arraylist
        ArrayList<T> list = new ArrayList<>();

        //Opprette deque
        //Traversere binærtreet i nivå orden og flytte verdiene over i en deque.

        //Gå igjennom deque og flytte verdiene inn i arraylist

        //Returnere arraylist
        return list;
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
