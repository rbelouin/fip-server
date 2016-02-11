package test.data

import models.Song
import models.Show
import models.fip._

object FipData {
  val stringified1 = """
  {
    "steps": {
      "f52f0660057e5c750f3ad467a27e5f6e": {
        "_version": 1,
        "stepId": "f52f0660057e5c750f3ad467a27e5f6e",
        "uuid": "3bab9f2a-7488-4801-9ace-abb90a22cb81",
        "title": "COMMENT A PU T ON EN ARRIVER LA ?",
        "start": 1455201434,
        "end": 1455201455,
        "stationId": 7,
        "embedId": "3596971700720-1-8",
        "embedType": "song",
        "depth": 3,
        "authors": "BO/LES PORTES DE LA GLOIRE",
        "titleSlug": "comment-a-pu-t-on-en-arriver-la",
        "lienYoutube": "https://www.youtube.com/watch?v=zunp_YqNRfg",
        "visuelYoutube": "https://i.ytimg.com/vi/zunp_YqNRfg/hqdefault.jpg",
        "label": "PLAYTIME",
        "anneeEditionMusique": 2001,
        "titreAlbum": "BOF / LES PORTES DE LA GLOIRE"
      },
      "89eebf12759e0e2f237e4d7870108729": {
        "_version": 1,
        "stepId": "89eebf12759e0e2f237e4d7870108729",
        "uuid": "db946b6e-330a-46c8-936a-07389233c242",
        "title": "SYMPHONIE N°4 EN UT MIN D 417 TRAGIQUE : MENUETTO",
        "start": 1455201461,
        "end": 1455201668,
        "stationId": 7,
        "embedId": "0077775421026-1-3",
        "embedType": "song",
        "depth": 3,
        "authors": "CLASSICAL PLAYERS DE LONDRES",
        "titleSlug": "symphonie-ndeg4-en-ut-min-d-417-tragique-menuetto",
        "label": "EMI",
        "anneeEditionMusique": 1992,
        "titreAlbum": "SCHUBERT / SYMPHONIES N° 4 - 6 / NORRINGTON"
      },
      "96bafd73b5710b770ab6b7dc88c6d06e": {
        "_version": 1,
        "stepId": "96bafd73b5710b770ab6b7dc88c6d06e",
        "uuid": "36668472-74df-4db2-9fc5-25b5d6bc607b",
        "title": "HOW LONG",
        "start": 1455201668,
        "end": 1455201902,
        "stationId": 7,
        "embedId": "0887828034123-1-3",
        "embedType": "song",
        "depth": 3,
        "authors": "JULIA HOLTER",
        "titleSlug": "how-long",
        "visual": "http://is1.mzstatic.com/image/thumb/Music3/v4/0e/3c/f8/0e3cf81d-3366-499b-6b6e-db2db07e15df/source/400x400bb.jpg",
        "path": "https://itunes.apple.com/fr/album/how-long/id1046817772?i=1046817784&uo=4",
        "lienYoutube": "https://www.youtube.com/watch?v=kfBBWxM7xIE",
        "visuelYoutube": "https://i.ytimg.com/vi/kfBBWxM7xIE/hqdefault.jpg",
        "label": "DOMINO RECORDING CO LTD",
        "anneeEditionMusique": 2015,
        "titreAlbum": "HAVE YOU IN MY WILDERNESS"
      },
      "61856765234ed5836c84521a1658ff69": {
        "_version": 1,
        "stepId": "61856765234ed5836c84521a1658ff69",
        "uuid": "6dd07647-d86b-403f-85d8-ca117a8cb17e",
        "title": "LAY DOWN",
        "start": 1455201902,
        "end": 1455202086,
        "stationId": 7,
        "embedId": "3596973263124-1-11",
        "embedType": "song",
        "depth": 3,
        "authors": "CARAVAN PALACE",
        "titleSlug": "lay-down",
        "visual": "http://is5.mzstatic.com/image/thumb/Music5/v4/79/9f/90/799f909c-a65a-9122-2656-2a50fe9ca528/source/400x400bb.jpg",
        "path": "https://itunes.apple.com/fr/album/lay-down/id1005692202?i=1005693207&uo=4",
        "lienYoutube": "https://www.youtube.com/watch?v=dKdV4Q-iR4A",
        "visuelYoutube": "https://i.ytimg.com/vi/dKdV4Q-iR4A/hqdefault.jpg",
        "label": "CAFE DE LA DANSE",
        "anneeEditionMusique": 2016,
        "titreAlbum": "|°_°|"
      },
      "92baec78be4988fb6be5fac85f4dc5de": {
        "_version": 1,
        "stepId": "92baec78be4988fb6be5fac85f4dc5de",
        "uuid": "64ad859f-6709-4f39-b236-a989b3fb77b5",
        "title": "THE MAGICAL",
        "start": 1455202086,
        "end": 1455202241,
        "stationId": 7,
        "embedId": "RF00000051147-1-18",
        "embedType": "song",
        "depth": 3,
        "authors": "AL TARBA",
        "titleSlug": "the-magical",
        "visual": "http://is2.mzstatic.com/image/thumb/Music2/v4/3c/c0/83/3cc0832c-7415-9ba2-0066-7e63424f2c59/source/400x400bb.jpg",
        "path": "https://itunes.apple.com/fr/album/the-magical/id661301700?i=661301792&uo=4",
        "lienYoutube": "https://www.youtube.com/watch?v=yMOTQZgd4_8",
        "visuelYoutube": "https://i.ytimg.com/vi/yMOTQZgd4_8/hqdefault.jpg",
        "label": "AUTO PRODUCTION",
        "anneeEditionMusique": 2012,
        "titreAlbum": "LULLABIES FOR INSOMNIACS"
      }
    },
    "levels": [{
      "items": ["f52f0660057e5c750f3ad467a27e5f6e", "89eebf12759e0e2f237e4d7870108729", "96bafd73b5710b770ab6b7dc88c6d06e", "61856765234ed5836c84521a1658ff69", "92baec78be4988fb6be5fac85f4dc5de"],
      "position": 3
    }],
    "stationId": 7
  }
  """

  val parsed1 = FipInfo(
    steps=Map(
      "f52f0660057e5c750f3ad467a27e5f6e" -> FipStep(
        _version=Some(1),
        stepId=Some("f52f0660057e5c750f3ad467a27e5f6e"),
        uuid=Some("3bab9f2a-7488-4801-9ace-abb90a22cb81"),
        title=Some("COMMENT A PU T ON EN ARRIVER LA ?"),
        start=Some(1455201434),
        end=Some(1455201455),
        stationId=Some(7),
        embedId=Some("3596971700720-1-8"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("BO/LES PORTES DE LA GLOIRE"),
        titleSlug=Some("comment-a-pu-t-on-en-arriver-la"),
        lienYoutube=Some("https://www.youtube.com/watch?v=zunp_YqNRfg"),
        visuelYoutube=Some("https://i.ytimg.com/vi/zunp_YqNRfg/hqdefault.jpg"),
        label=Some("PLAYTIME"),
        anneeEditionMusique=Some(2001),
        titreAlbum=Some("BOF / LES PORTES DE LA GLOIRE")
      ),
      "89eebf12759e0e2f237e4d7870108729" -> FipStep(
        _version=Some(1),
        stepId=Some("89eebf12759e0e2f237e4d7870108729"),
        uuid=Some("db946b6e-330a-46c8-936a-07389233c242"),
        title=Some("SYMPHONIE N°4 EN UT MIN D 417 TRAGIQUE : MENUETTO"),
        start=Some(1455201461),
        end=Some(1455201668),
        stationId=Some(7),
        embedId=Some("0077775421026-1-3"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("CLASSICAL PLAYERS DE LONDRES"),
        titleSlug=Some("symphonie-ndeg4-en-ut-min-d-417-tragique-menuetto"),
        label=Some("EMI"),
        anneeEditionMusique=Some(1992),
        titreAlbum=Some("SCHUBERT / SYMPHONIES N° 4 - 6 / NORRINGTON")
      ),
      "96bafd73b5710b770ab6b7dc88c6d06e" -> FipStep(
        _version=Some(1),
        stepId=Some("96bafd73b5710b770ab6b7dc88c6d06e"),
        uuid=Some("36668472-74df-4db2-9fc5-25b5d6bc607b"),
        title=Some("HOW LONG"),
        start=Some(1455201668),
        end=Some(1455201902),
        stationId=Some(7),
        embedId=Some("0887828034123-1-3"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("JULIA HOLTER"),
        titleSlug=Some("how-long"),
        visual=Some("http://is1.mzstatic.com/image/thumb/Music3/v4/0e/3c/f8/0e3cf81d-3366-499b-6b6e-db2db07e15df/source/400x400bb.jpg"),
        path=Some("https://itunes.apple.com/fr/album/how-long/id1046817772?i=1046817784&uo=4"),
        lienYoutube=Some("https://www.youtube.com/watch?v=kfBBWxM7xIE"),
        visuelYoutube=Some("https://i.ytimg.com/vi/kfBBWxM7xIE/hqdefault.jpg"),
        label=Some("DOMINO RECORDING CO LTD"),
        anneeEditionMusique=Some(2015),
        titreAlbum=Some("HAVE YOU IN MY WILDERNESS")
      ),
      "61856765234ed5836c84521a1658ff69" -> FipStep(
        _version=Some(1),
        stepId=Some("61856765234ed5836c84521a1658ff69"),
        uuid=Some("6dd07647-d86b-403f-85d8-ca117a8cb17e"),
        title=Some("LAY DOWN"),
        start=Some(1455201902),
        end=Some(1455202086),
        stationId=Some(7),
        embedId=Some("3596973263124-1-11"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("CARAVAN PALACE"),
        titleSlug=Some("lay-down"),
        visual=Some("http://is5.mzstatic.com/image/thumb/Music5/v4/79/9f/90/799f909c-a65a-9122-2656-2a50fe9ca528/source/400x400bb.jpg"),
        path=Some("https://itunes.apple.com/fr/album/lay-down/id1005692202?i=1005693207&uo=4"),
        lienYoutube=Some("https://www.youtube.com/watch?v=dKdV4Q-iR4A"),
        visuelYoutube=Some("https://i.ytimg.com/vi/dKdV4Q-iR4A/hqdefault.jpg"),
        label=Some("CAFE DE LA DANSE"),
        anneeEditionMusique=Some(2016),
        titreAlbum=Some("|°_°|")
      ),
      "92baec78be4988fb6be5fac85f4dc5de" -> FipStep(
        _version=Some(1),
        stepId=Some("92baec78be4988fb6be5fac85f4dc5de"),
        uuid=Some("64ad859f-6709-4f39-b236-a989b3fb77b5"),
        title=Some("THE MAGICAL"),
        start=Some(1455202086),
        end=Some(1455202241),
        stationId=Some(7),
        embedId=Some("RF00000051147-1-18"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("AL TARBA"),
        titleSlug=Some("the-magical"),
        visual=Some("http://is2.mzstatic.com/image/thumb/Music2/v4/3c/c0/83/3cc0832c-7415-9ba2-0066-7e63424f2c59/source/400x400bb.jpg"),
        path=Some("https://itunes.apple.com/fr/album/the-magical/id661301700?i=661301792&uo=4"),
        lienYoutube=Some("https://www.youtube.com/watch?v=yMOTQZgd4_8"),
        visuelYoutube=Some("https://i.ytimg.com/vi/yMOTQZgd4_8/hqdefault.jpg"),
        label=Some("AUTO PRODUCTION"),
        anneeEditionMusique=Some(2012),
        titreAlbum=Some("LULLABIES FOR INSOMNIACS")
      )
    ),
    levels=List(FipLevel(
      items=Seq("f52f0660057e5c750f3ad467a27e5f6e", "89eebf12759e0e2f237e4d7870108729", "96bafd73b5710b770ab6b7dc88c6d06e", "61856765234ed5836c84521a1658ff69", "92baec78be4988fb6be5fac85f4dc5de"),
      position=3
    )),
    stationId=7
  )

  val currentSong1 = Song(
    id="6dd07647-d86b-403f-85d8-ca117a8cb17e",
    startTime=1455201902,
    endTime=1455202086,
    title="LAY DOWN",
    album="|°_°|",
    artist="CARAVAN PALACE",
    year=Some("2016"),
    label=Some("CAFE DE LA DANSE"),
    icons=Map("medium" -> "http://is5.mzstatic.com/image/thumb/Music5/v4/79/9f/90/799f909c-a65a-9122-2656-2a50fe9ca528/source/400x400bb.jpg"),
    itunes="https://itunes.apple.com/fr/album/lay-down/id1005692202?i=1005693207&uo=4"
  )

  val stringified2 = """
  {
    "steps": {
      "15257398648406067": {
        "_version": 1,
        "stepId": "15257398648406067",
        "uuid": "7457d53a-78b8-44f1-b2dd-47d256c30ce2",
        "title": "Club Jazzafip",
        "start": 1455127200,
        "end": 1455130800,
        "stationId": 7,
        "embedType": "blank",
        "depth": 1,
        "titleSlug": "club-jazzafip"
      },
      "15257398648406787": {
        "_version": 1,
        "stepId": "15257398648406787",
        "uuid": "dfa50816-6bd1-4a58-9fce-e4331e1a1ae4",
        "title": "Certains l'aiment Fip",
        "start": 1455130800,
        "end": 1455138000,
        "stationId": 7,
        "embedType": "blank",
        "depth": 1,
        "titleSlug": "certains-l-aiment-fip"
      },
      "15257398648407737": {
        "_version": 1,
        "stepId": "15257398648407737",
        "uuid": "93e81e5d-d81b-4148-95f8-30cea016ce77",
        "title": "La nuit sur FIP",
        "start": 1455138000,
        "end": 1455145200,
        "stationId": 7,
        "embedType": "blank",
        "depth": 1,
        "titleSlug": "la-nuit-sur-fip"
      },
      "15258304623149447": {
        "_version": 1,
        "stepId": "15258304623149447",
        "uuid": "665562ac-e1d0-4c68-a824-ebf501a4cdf7",
        "title": "Club Jazzafip",
        "start": 1455213600,
        "end": 1455217200,
        "stationId": 7,
        "embedType": "blank",
        "depth": 1,
        "titleSlug": "club-jazzafip"
      },
      "15258304623150197": {
        "_version": 1,
        "stepId": "15258304623150197",
        "uuid": "0feab380-f42c-4b56-8e8d-82ff2bc6c5f8",
        "title": "Live Ã  Fip",
        "start": 1455217200,
        "end": 1455224400,
        "stationId": 7,
        "embedType": "blank",
        "depth": 1,
        "titleSlug": "live-a-fip"
      },
      "15258304623150907": {
        "_version": 1,
        "stepId": "15258304623150907",
        "uuid": "67d73f26-bf83-47f9-a835-fc187ea8b21c",
        "title": "La nuit sur Fip",
        "start": 1455224400,
        "end": 1455231600,
        "stationId": 7,
        "embedType": "blank",
        "depth": 1,
        "titleSlug": "la-nuit-sur-fip"
      },
      "d4fa814c97d876119d4b690e0590dea1": {
        "_version": 1,
        "stepId": "d4fa814c97d876119d4b690e0590dea1",
        "uuid": "5e5928a8-8e65-4d7d-9f29-cef8e0a32389",
        "title": "ACID ROCK",
        "start": 1455212980,
        "end": 1455213152,
        "stationId": 7,
        "embedId": "0827565035922-1-9",
        "embedType": "song",
        "depth": 3,
        "authors": "THE FUNKEES",
        "titleSlug": "acid-rock",
        "visual": "http://is1.mzstatic.com/image/thumb/Music/v4/ac/62/4a/ac624a67-ea30-6259-909f-d1955240abb4/source/400x400bb.jpg",
        "path": "https://itunes.apple.com/fr/album/acid-rock/id511026610?i=511026889&uo=4",
        "lienYoutube": "https://www.youtube.com/watch?v=M96zt_Pxrvw",
        "visuelYoutube": "https://i.ytimg.com/vi/M96zt_Pxrvw/hqdefault.jpg",
        "label": "SOUNDWAY RECORDS",
        "anneeEditionMusique": 1973,
        "titreAlbum": "NIGERIA ROCK SPECIAL ANNEES 70"
      },
      "4fcb49683eca106acaeab04f8ce05cda": {
        "_version": 1,
        "stepId": "4fcb49683eca106acaeab04f8ce05cda",
        "uuid": "92d93563-f3a2-49c8-8a4b-5c15c8c484ca",
        "title": "COSMIC VORTEX : LOVE YOUR BROTHER",
        "start": 1455213098,
        "end": 1455213413,
        "stationId": 7,
        "embedId": "0664425000122-1-1",
        "embedType": "song",
        "depth": 3,
        "authors": "IRVINE WELDON",
        "titleSlug": "cosmic-vortex-love-your-brother",
        "lienYoutube": "https://www.youtube.com/watch?v=izJH290fBxk",
        "visuelYoutube": "https://i.ytimg.com/vi/izJH290fBxk/hqdefault.jpg",
        "label": "GET ON DOWN",
        "anneeEditionMusique": 1974,
        "titreAlbum": "COSMIC VORTEX / SINBAD / SPIRIT MAN"
      },
      "bba885d463f495689ed0971873f9b616": {
        "_version": 1,
        "stepId": "bba885d463f495689ed0971873f9b616",
        "uuid": "e7e255fd-d2c7-4d40-b0ec-08404a779489",
        "title": "WORK IT OUT",
        "start": 1455213398,
        "end": 1455213629,
        "stationId": 7,
        "embedId": "0602517037663-1-7",
        "embedType": "song",
        "depth": 3,
        "authors": "JURASSIC 5",
        "titleSlug": "work-it-out",
        "visual": "http://is1.mzstatic.com/image/thumb/Music/v4/38/98/2a/38982a7d-ab04-b808-44f2-0eaca98f07fc/source/400x400bb.jpg",
        "path": "https://itunes.apple.com/fr/album/work-it-out/id163422553?i=163422691&uo=4",
        "lienYoutube": "https://www.youtube.com/watch?v=kUw9Ej5VLnM",
        "visuelYoutube": "https://i.ytimg.com/vi/kUw9Ej5VLnM/hqdefault.jpg",
        "anneeEditionMusique": 2006,
        "titreAlbum": "FEEDBACK"
      },
      "d7dcfc85c0fdbcf6ae50c5751709b897": {
        "_version": 1,
        "stepId": "d7dcfc85c0fdbcf6ae50c5751709b897",
        "uuid": "a6bf41c4-af8d-48e4-8a8f-538e060d86b4",
        "title": "SOMEBODY BUY ME A DRINK",
        "start": 1455213694,
        "end": 1455213878,
        "fatherStepId": "15258304623149447",
        "stationId": 7,
        "embedId": "5099706499428-1-6",
        "embedType": "song",
        "depth": 3,
        "authors": "OSCAR BROWN JR",
        "titleSlug": "somebody-buy-me-a-drink",
        "visual": "http://is4.mzstatic.com/image/thumb/Music/v4/eb/73/aa/eb73aa5e-8d69-663a-c109-999b6e8ddfc3/source/400x400bb.jpg",
        "path": "https://itunes.apple.com/fr/album/somebody-buy-me-a-drink/id157413897?i=157414313&uo=4",
        "lienYoutube": "https://www.youtube.com/watch?v=ViV86TQI3ok",
        "visuelYoutube": "https://i.ytimg.com/vi/ViV86TQI3ok/hqdefault.jpg",
        "label": "COLUMBIA",
        "anneeEditionMusique": 1960,
        "titreAlbum": "SIN & SOUL ...AND THEN SOME"
      },
      "90bdee6102109f0e8b2b606b0a7cb6a9": {
        "_version": 1,
        "stepId": "90bdee6102109f0e8b2b606b0a7cb6a9",
        "uuid": "4f24409e-f00b-4855-ac69-eaf65e7acd4f",
        "title": "DRINKIN WINE SLOWLY",
        "start": 1455213871,
        "end": 1455214153,
        "fatherStepId": "15258304623149447",
        "stationId": 7,
        "embedId": "3229265975329-1-7",
        "embedType": "song",
        "depth": 3,
        "authors": "ROLAND HANNA",
        "titleSlug": "drinkin-wine-slowly",
        "visual": "http://is2.mzstatic.com/image/thumb/Music/v4/e8/e6/6b/e8e66b4b-d4c4-4424-a3a4-799801947bd1/source/400x400bb.jpg",
        "path": "https://itunes.apple.com/fr/album/drinkin-wine-slowly/id267386957?i=267387399&uo=4",
        "label": "B BLUE",
        "anneeEditionMusique": 1978,
        "titreAlbum": "IMPRESSIONS"
      },
      "6a1662d282457e57626b5a481a16b643": {
        "_version": 1,
        "stepId": "6a1662d282457e57626b5a481a16b643",
        "uuid": "7474673f-f930-405b-9d3d-804bcfa41256",
        "title": "GOT ME WRONG",
        "start": 1455214146,
        "end": 1455214471,
        "fatherStepId": "15258304623149447",
        "stationId": 7,
        "embedId": "0075597961058-1-1",
        "embedType": "song",
        "depth": 3,
        "authors": "BRAD MEHLDAU TRIO BRAD MEHLDAU LARRY GRENADIER JEFF BALLARD",
        "titleSlug": "got-me-wrong",
        "lienYoutube": "https://www.youtube.com/watch?v=KLUqW-N5l3g",
        "visuelYoutube": "https://i.ytimg.com/vi/KLUqW-N5l3g/hqdefault.jpg",
        "label": "NONESUCH",
        "anneeEditionMusique": 2012,
        "titreAlbum": "WHERE DO YOU START"
      }
    },
    "levels": [{
      "items": ["15257398648406067", "15257398648406787", "15257398648407737", "15258304623149447", "15258304623150197", "15258304623150907"],
      "position": 3
    }, {
      "items": ["d4fa814c97d876119d4b690e0590dea1", "4fcb49683eca106acaeab04f8ce05cda", "bba885d463f495689ed0971873f9b616", "d7dcfc85c0fdbcf6ae50c5751709b897", "90bdee6102109f0e8b2b606b0a7cb6a9", "6a1662d282457e57626b5a481a16b643"],
      "position": 3
    }],
    "stationId": 7
  }
  """

  val parsed2 = FipInfo(
    steps=Map(
      "15257398648406067" -> FipStep(
        _version=Some(1),
        stepId=Some("15257398648406067"),
        uuid=Some("7457d53a-78b8-44f1-b2dd-47d256c30ce2"),
        title=Some("Club Jazzafip"),
        start=Some(1455127200),
        end=Some(1455130800),
        stationId=Some(7),
        embedType=Some("blank"),
        depth=Some(1),
        titleSlug=Some("club-jazzafip")
      ),
      "15257398648406787" -> FipStep(
        _version=Some(1),
        stepId=Some("15257398648406787"),
        uuid=Some("dfa50816-6bd1-4a58-9fce-e4331e1a1ae4"),
        title=Some("Certains l'aiment Fip"),
        start=Some(1455130800),
        end=Some(1455138000),
        stationId=Some(7),
        embedType=Some("blank"),
        depth=Some(1),
        titleSlug=Some("certains-l-aiment-fip")
      ),
      "15257398648407737" -> FipStep(
        _version=Some(1),
        stepId=Some("15257398648407737"),
        uuid=Some("93e81e5d-d81b-4148-95f8-30cea016ce77"),
        title=Some("La nuit sur FIP"),
        start=Some(1455138000),
        end=Some(1455145200),
        stationId=Some(7),
        embedType=Some("blank"),
        depth=Some(1),
        titleSlug=Some("la-nuit-sur-fip")
      ),
      "15258304623149447" -> FipStep(
        _version=Some(1),
        stepId=Some("15258304623149447"),
        uuid=Some("665562ac-e1d0-4c68-a824-ebf501a4cdf7"),
        title=Some("Club Jazzafip"),
        start=Some(1455213600),
        end=Some(1455217200),
        stationId=Some(7),
        embedType=Some("blank"),
        depth=Some(1),
        titleSlug=Some("club-jazzafip")
      ),
      "15258304623150197" -> FipStep(
        _version=Some(1),
        stepId=Some("15258304623150197"),
        uuid=Some("0feab380-f42c-4b56-8e8d-82ff2bc6c5f8"),
        title=Some("Live Ã  Fip"),
        start=Some(1455217200),
        end=Some(1455224400),
        stationId=Some(7),
        embedType=Some("blank"),
        depth=Some(1),
        titleSlug=Some("live-a-fip")
      ),
      "15258304623150907" -> FipStep(
        _version=Some(1),
        stepId=Some("15258304623150907"),
        uuid=Some("67d73f26-bf83-47f9-a835-fc187ea8b21c"),
        title=Some("La nuit sur Fip"),
        start=Some(1455224400),
        end=Some(1455231600),
        stationId=Some(7),
        embedType=Some("blank"),
        depth=Some(1),
        titleSlug=Some("la-nuit-sur-fip")
      ),
      "d4fa814c97d876119d4b690e0590dea1" -> FipStep(
        _version=Some(1),
        stepId=Some("d4fa814c97d876119d4b690e0590dea1"),
        uuid=Some("5e5928a8-8e65-4d7d-9f29-cef8e0a32389"),
        title=Some("ACID ROCK"),
        start=Some(1455212980),
        end=Some(1455213152),
        stationId=Some(7),
        embedId=Some("0827565035922-1-9"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("THE FUNKEES"),
        titleSlug=Some("acid-rock"),
        visual=Some("http://is1.mzstatic.com/image/thumb/Music/v4/ac/62/4a/ac624a67-ea30-6259-909f-d1955240abb4/source/400x400bb.jpg"),
        path=Some("https://itunes.apple.com/fr/album/acid-rock/id511026610?i=511026889&uo=4"),
        lienYoutube=Some("https://www.youtube.com/watch?v=M96zt_Pxrvw"),
        visuelYoutube=Some("https://i.ytimg.com/vi/M96zt_Pxrvw/hqdefault.jpg"),
        label=Some("SOUNDWAY RECORDS"),
        anneeEditionMusique=Some(1973),
        titreAlbum=Some("NIGERIA ROCK SPECIAL ANNEES 70")
      ),
      "4fcb49683eca106acaeab04f8ce05cda" -> FipStep(
        _version=Some(1),
        stepId=Some("4fcb49683eca106acaeab04f8ce05cda"),
        uuid=Some("92d93563-f3a2-49c8-8a4b-5c15c8c484ca"),
        title=Some("COSMIC VORTEX : LOVE YOUR BROTHER"),
        start=Some(1455213098),
        end=Some(1455213413),
        stationId=Some(7),
        embedId=Some("0664425000122-1-1"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("IRVINE WELDON"),
        titleSlug=Some("cosmic-vortex-love-your-brother"),
        lienYoutube=Some("https://www.youtube.com/watch?v=izJH290fBxk"),
        visuelYoutube=Some("https://i.ytimg.com/vi/izJH290fBxk/hqdefault.jpg"),
        label=Some("GET ON DOWN"),
        anneeEditionMusique=Some(1974),
        titreAlbum=Some("COSMIC VORTEX / SINBAD / SPIRIT MAN")
      ),
      "bba885d463f495689ed0971873f9b616" -> FipStep(
        _version=Some(1),
        stepId=Some("bba885d463f495689ed0971873f9b616"),
        uuid=Some("e7e255fd-d2c7-4d40-b0ec-08404a779489"),
        title=Some("WORK IT OUT"),
        start=Some(1455213398),
        end=Some(1455213629),
        stationId=Some(7),
        embedId=Some("0602517037663-1-7"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("JURASSIC 5"),
        titleSlug=Some("work-it-out"),
        visual=Some("http://is1.mzstatic.com/image/thumb/Music/v4/38/98/2a/38982a7d-ab04-b808-44f2-0eaca98f07fc/source/400x400bb.jpg"),
        path=Some("https://itunes.apple.com/fr/album/work-it-out/id163422553?i=163422691&uo=4"),
        lienYoutube=Some("https://www.youtube.com/watch?v=kUw9Ej5VLnM"),
        visuelYoutube=Some("https://i.ytimg.com/vi/kUw9Ej5VLnM/hqdefault.jpg"),
        anneeEditionMusique=Some(2006),
        titreAlbum=Some("FEEDBACK")
      ),
      "d7dcfc85c0fdbcf6ae50c5751709b897" -> FipStep(
        _version=Some(1),
        stepId=Some("d7dcfc85c0fdbcf6ae50c5751709b897"),
        uuid=Some("a6bf41c4-af8d-48e4-8a8f-538e060d86b4"),
        title=Some("SOMEBODY BUY ME A DRINK"),
        start=Some(1455213694),
        end=Some(1455213878),
        fatherStepId=Some("15258304623149447"),
        stationId=Some(7),
        embedId=Some("5099706499428-1-6"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("OSCAR BROWN JR"),
        titleSlug=Some("somebody-buy-me-a-drink"),
        visual=Some("http://is4.mzstatic.com/image/thumb/Music/v4/eb/73/aa/eb73aa5e-8d69-663a-c109-999b6e8ddfc3/source/400x400bb.jpg"),
        path=Some("https://itunes.apple.com/fr/album/somebody-buy-me-a-drink/id157413897?i=157414313&uo=4"),
        lienYoutube=Some("https://www.youtube.com/watch?v=ViV86TQI3ok"),
        visuelYoutube=Some("https://i.ytimg.com/vi/ViV86TQI3ok/hqdefault.jpg"),
        label=Some("COLUMBIA"),
        anneeEditionMusique=Some(1960),
        titreAlbum=Some("SIN & SOUL ...AND THEN SOME")
      ),
      "90bdee6102109f0e8b2b606b0a7cb6a9" -> FipStep(
        _version=Some(1),
        stepId=Some("90bdee6102109f0e8b2b606b0a7cb6a9"),
        uuid=Some("4f24409e-f00b-4855-ac69-eaf65e7acd4f"),
        title=Some("DRINKIN WINE SLOWLY"),
        start=Some(1455213871),
        end=Some(1455214153),
        fatherStepId=Some("15258304623149447"),
        stationId=Some(7),
        embedId=Some("3229265975329-1-7"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("ROLAND HANNA"),
        titleSlug=Some("drinkin-wine-slowly"),
        visual=Some("http://is2.mzstatic.com/image/thumb/Music/v4/e8/e6/6b/e8e66b4b-d4c4-4424-a3a4-799801947bd1/source/400x400bb.jpg"),
        path=Some("https://itunes.apple.com/fr/album/drinkin-wine-slowly/id267386957?i=267387399&uo=4"),
        label=Some("B BLUE"),
        anneeEditionMusique=Some(1978),
        titreAlbum=Some("IMPRESSIONS")
      ),
      "6a1662d282457e57626b5a481a16b643" -> FipStep(
        _version=Some(1),
        stepId=Some("6a1662d282457e57626b5a481a16b643"),
        uuid=Some("7474673f-f930-405b-9d3d-804bcfa41256"),
        title=Some("GOT ME WRONG"),
        start=Some(1455214146),
        end=Some(1455214471),
        fatherStepId=Some("15258304623149447"),
        stationId=Some(7),
        embedId=Some("0075597961058-1-1"),
        embedType=Some("song"),
        depth=Some(3),
        authors=Some("BRAD MEHLDAU TRIO BRAD MEHLDAU LARRY GRENADIER JEFF BALLARD"),
        titleSlug=Some("got-me-wrong"),
        lienYoutube=Some("https://www.youtube.com/watch?v=KLUqW-N5l3g"),
        visuelYoutube=Some("https://i.ytimg.com/vi/KLUqW-N5l3g/hqdefault.jpg"),
        label=Some("NONESUCH"),
        anneeEditionMusique=Some(2012),
        titreAlbum=Some("WHERE DO YOU START")
      )
    ),
    levels=Seq(FipLevel(
      items=Seq("15257398648406067", "15257398648406787", "15257398648407737", "15258304623149447", "15258304623150197", "15258304623150907"),
      position=3
    ), FipLevel(
      items=Seq("d4fa814c97d876119d4b690e0590dea1", "4fcb49683eca106acaeab04f8ce05cda", "bba885d463f495689ed0971873f9b616", "d7dcfc85c0fdbcf6ae50c5751709b897", "90bdee6102109f0e8b2b606b0a7cb6a9", "6a1662d282457e57626b5a481a16b643"),
      position=3
    )),
    stationId=7
  )

  val currentSong2 = Song(
    id="a6bf41c4-af8d-48e4-8a8f-538e060d86b4",
    startTime=1455213694,
    endTime=1455213878,
    title="SOMEBODY BUY ME A DRINK",
    album="SIN & SOUL ...AND THEN SOME",
    artist="OSCAR BROWN JR",
    year=Some("1960"),
    label=Some("COLUMBIA"),
    icons=Map("medium" -> "http://is4.mzstatic.com/image/thumb/Music/v4/eb/73/aa/eb73aa5e-8d69-663a-c109-999b6e8ddfc3/source/400x400bb.jpg"),
    itunes="https://itunes.apple.com/fr/album/somebody-buy-me-a-drink/id157413897?i=157414313&uo=4"
  )
    
  val currentShow2 = Show(
    id="665562ac-e1d0-4c68-a824-ebf501a4cdf7",
    startTime=1455213600,
    endTime=1455217200,
    name="Club Jazzafip",
    icons=Map.empty[String,String]
  )
}