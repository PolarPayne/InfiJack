# Reasoning
Miksi ohjelmasta on testattu vain logic paketin luokkia, sekä kamera?

Koska nämä ovat niitä luokkia joilla on kaikista suurin todennäköisyys rikkoa koko ohjelma jollakin tavalla.
Nämä luokat onkin testattu hyvin kattavasti, eikä niissä pitäisi olla virheitä, ja jos niihin semmoisia ilmestyy testien pitäisi paljastaa ne hyvin tarkasti.
Erittäin kriittisiä ovat luokat Camera, Point ja Rectangle, sen takia niiden testaamiseen onkin käytetty erityistä huomiota.
Myös mm. off-by-one-erroreita on testattu.

Miksei muita luokkia ole testattu?

Niissä olevat mahdolliset virheet on paljon hankalampia testata, ja osa niistä on kokonaan minun ulottumattomuuksissa.

# Manuaalinen testaus
Nappeja on hakattu ja outoja inputteja on koitettu antaa. Yritetty luoda outoja tilanteita jotka voisivat aiheuttaa virhetilanteita.

# Bugs
Mitään bugeja ei ole löytynyt, ja tuskin mitään vakavia ainakaan on.
