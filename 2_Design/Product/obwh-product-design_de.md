# Product Design von "Old Book Wisenheimer"

## Product Vision

Siehe [obwh-product-vision_de.md](../../1_Vision/Product/obwh-product-vision_de.md)

## Spiel Ablauf

Gleich nach dem Öffnen der Oberfläche wird die Spiel-Schleife
mit Runde 1 und der ersten Zitat-Frage gestartet:

1. Zufällige Zitat-Frage, Timer zählt herunter, 1 Minute Zeit zum Raten
2. Buch wird vor Ablauf des Timers erraten
   - Runden-Erfolg (Animation, Meldung)
   - Runde = Runde + 1; gehe zu 1.
3. Timer läuft ab oder Auswahl des falschen Buches
   - Runden-Misserfolg (Animation, Meldung), Anzeige richtige Auswahl
   - Anzeige Gesamtergebnis
   - Einblenden von Schaltfläche "Noch einmal"
4. Klick auf "Noch einmal"
   - Runde = 1; gehe zu 1.

### Ergänzungen zum Spiel Ablauf

Die Zitat-Fragen werden zufällig über alle Sprachen hinweg gewählt.
(Ein echter Wisenheimer beherrscht mehrere Sprachen.)

Darstellung einer Zitat-Frage:
- Zitat
- Schaltflächen für die drei zur Auswahl stehenden Bücher, jeweils mit:
    - Titel sowie (in Klammer) Autor bzw. Autoren oder "Anonym"

Darstellung vom Gesamtergebnis:
- Anzahl der geschafften Runden und der insgesamt benötigten Zeit
- Darstellung jeder Runde:
    - Zeit pro Runde
    - Darstellung der Antwort auf eine Zitat-Frage:
        - Zitat
        - die drei Buch Optionen, wobei:
            - richtiges Buch speziell markiert
            - geratenes Buch speziell markiert
            - Affiliate Links zu jedem Buch

## Zitat-Fragen

Eine Zitat-Frage besteht aus:
- einem Zitat
- einer Auswahl von drei Büchern, von denen:
    - ein Buch richtig ist (das gegebene Zitat enthält)
    - und zwei Bücher falsch sind (das gegebene Zitat nicht enthalten)

Weitere Kriterien für Zitat-Fragen:
- Zitat ist aussagekräftig (lässt Rückschluss auf das zugehörige Buch zu)
- die falschen Optionen sind gute Distraktoren (nicht zu offensichtlich falsch)

Kriterien für die Bücher, aus denen die Zitat-Fragen kommen:
- die Bücher sind gemeinfrei
- es sind nur Originalwerke zugelassen, keine Übersetzungen
- die Bücher stammen aus folgenden drei Sprachen:
    - Deutsch
    - Englisch
    - Latein


