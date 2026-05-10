# Story 0: Minimum Lovable Product (MLP) von obwh

Ein MLP von obwh soll designed und implementiert werden.
Es werden Anforderungen und Vereinfachungen definiert und entsprechend dieser 
erste Dokumente für Product Design und System Design erstellt.

Mithilfe dieser Informationen wird eine erste lauffähige Implementierung erzeugt.

## Anforderungen
- Definieren eines Quiz-API für das Quiz mit OpenAPI
- Generieren von Code aus dem Quiz-API (für Frontend und Backend)
- Bauen eines Angular Frontends für das Quiz UI, welches: 
  - das Quiz-API anspricht
  - den aus dem Quiz-API generierten Code verwendet
- Bauen eines Spring Boot Backends, welches 
  - das Quiz-API anbietet
  - den aus dem Quiz-API generierten Code verwendet
- Überlegen einer Verzeichnis-Struktur die tragfähig für zukünftige Entwicklungen ist (siehe Vision)
- Dockerfile(s) für ein Deployment auf Sliplane.io

## Vereinfachungen
- keine Datenbank, Quizfragen kommen aus Mock Service
- keine echten Affiliate-Links
- keine Maßnahmen, um Affiliate-Links zu schützen
- keine Maßnahmen, um das Schummeln zu erschweren
- keine Admin Komponente