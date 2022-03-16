--venue
insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           1, 'De Roma', 'https://www.deroma.be',
           1500, true, true, false, false, 'Antwerpen', 0.2);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           2, 'TRIX', 'https://www.trixonline.be/',
           1100, true, true, false, false, 'Antwerpen', 0.5);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           3, 'TRIX kelder', 'https://www.trixonline.be/nl/kelder/2/',
           120, true, true, false, false, 'Antwerpen', 0.5);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           4, 'Arenberg', 'https://www.arenberg.be',
           800, false, true, false, false, 'Antwerpen', 4);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           5, 'Reuzenpoort', 'https://www.tilemalines.be',
           180, false, true, true, true, 'Mechelen', 0.3);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           6, 'Zaal Athena', 'https://www.zaalathena.be',
           250, false, true, false, false, 'Antwerpen', 0.1);


insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           7, 'OLT Rivierenhof', 'https://www.oltrivierenhof.be',
           2500, false, false, true, true, 'Antwerpen', 1);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           8, 'Koningin Elisabethzaal', 'https://www.koninginelisabethzaal.be',
           1850, true, true, false, false, 'Antwerpen', 0.1);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           9, 'Sportpaleis', 'https://www.sportpaleis.be',
           23000, true, true, false, true, 'Antwerpen', 1);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           10, 'Lotto Arena', 'https://www.lotto-arena.be/',
           8050, true, true, true, true, 'Antwerpen', 1);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           11, 'Club Cabane', 'https://www.strantwerpen.be',
           200, false, true, true, false, 'Antwerpen', 1.2);

insert into VENUE (
    ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
    FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
    CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (
           12, 'Den Aalmoezenier', 'https://denaalmoezenier.weebly.com/',
           100, true, true, false, false, 'Antwerpen', 1);

--artist
INSERT INTO ARTIST (
    ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES (
           1, 'Discobaar a moeder',
           'Discobaar A Moeder, een ondertussen legendarisch Antwerps fenomeen,
           draait al mee van in 2002. Het begon als een cafégrap van twee bevriende
           vinylfreaks, de grap houden ze er in, van draaien in een café genieten ze
           nog steeds, maar van een groots festival op z''n tijd zijn ze niet vies.',
           'Pop, Soul, Disco', 'http://www.discobaaramoeder.be/', 'Lotto Arena
6/03/2020');

INSERT INTO ARTIST (
    ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES (
           2, 'Radio Botanique', 'Radio Botanique: helemaal geen radio. Eigenlijk
gewoon een discobaar. Vaste Parkpop (Mechelen) dansers en swingers.',
           'voor de lol', 'https://www.facebook.com/radiobotanique/', 'bekend van
Parkpop');

INSERT INTO ARTIST (
    ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES (
           3, 'DJ Koen',
           'Als allround DJ draai ik o.a. genres als de 90s, top 40, feest- en
           clubmuziek. Wekelijks draai ik op o.a. studentenfeesten, bruiloften, in
           kroegen, clubs en meer.',
           '90s, top 40, feest- en clubmuziek',
           'https://www.facebook.com/DJKoenMossink/', '');

INSERT INTO ARTIST (
    ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES (
           4, 'C-Man',
           '- 2nd place MNM Start To DJ 2016 - - Versuz - - Carré - - Sunrise
           Festival - - Ikon (Noxx) - - La Rocca - ... His First single ''Nothing is
           forever'' came out on 2Dutch (A music label from the Netherlands) in the
           summer of 2018.',
           'deephouse, EDM', 'https://www.facebook.com/cmandj/', 'Q-hotspot
17/07/2020');

INSERT INTO ARTIST (
    ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES (
           5, 'Robbe Roels',
           'Wie Mechelen zegt zegt Robbe Roels, waar de 20-jarige dj 3 jaar geleden
           begon op kleine privé feestjes en gelegenheden draait hij nu elk weekend op
           de grootste fuiven in zijn regio. Al blijft het daar echter niet bij,
           andere studentensteden zoals o.a. Leuven maar evengoed de Normandische kust
           zijn al getroffen door zijn prestaties.',
           'Allround, Dance, Techno', 'https://vi.be/platform/robberoels', 'Shake
That Asspi 2020');

INSERT INTO ARTIST (
    ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES (
           6, 'Toloko',
           'My name is Stan, also known as Toloko, the DJ who adds the right amount
           of loco-ness to your party! I am an upcoming DJ talent in the region of
           Zemst, Belgium. I started my career behind the turntables at the age of 20
           at local parties. Entertaining the crowd and making people dance to my
           music, makes me happy. Every gig, I bring my party people a new and
           customized set and I introduce them to the latest tracks.',
           'house, r&b', 'https://www.toloko.be/', '');

INSERT INTO ARTIST (
    ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES (
           7, 'Tough Titty',
           'A Belgian Tribute to 80''s Glam and Heavy Metal',
           '', 'https://www.facebook.com/Tough-Titty-277601302444865', '');

INSERT INTO ARTIST (
    ID, ARTIST_NAME, BIO, GENRE, LINK_MORE_INFO, PORTFOLIO)
VALUES (
           8, 'Kryptonight',
           'Twee kerels die er al vijf jaar van houden om het publiek uit hun dak
           te zien gaan! Onze missie: Het leven is een feest en daar moet gedanst
           worden. Hoe doen we dat? Met onze Latin-, Dancehall- en een vleugje
           Commercialplaten voor alle leeftijden zorgen we voor ieder wat wils.',
           'Moombahton • Dancehall • Commercial',
           'https://vi.be/platform/kryptonight', 'SOME GIG''s: Tomorrowland''s
Dreamville, MnM Start to Dj Finalist Flowtrack Summer Camp Casa Blanca
Festival Sunrise Festival Red ''n Blue Café Local Noxx Publik Vice Festival
KdG TD ...');

--party
INSERT INTO PARTY
(ID, NAME, PRICE_PRESALE_IN_EUR, PRICE_IN_EUR, EXTRA_INFO, DATE, DOORS,
 VENUE_ID)
VALUES
    (nextval('PARTY_SEQ'), 'Big Spring Party', 6, 10, '1 cocktail included',
     '2021-03-21', '10:00', 1);

INSERT INTO PARTY
(ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors,
 venue_Id)
VALUES
    (nextval('PARTY_SEQ'), 'Liberty 2021', 4, 6, 'free vestiaire, viplounge',
     '2021-04-3', '22:00', 2);

INSERT INTO PARTY
(ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors,
 venue_Id)
VALUES
    (nextval('PARTY_SEQ'), 'Uppercuts', null, null, ' ',
     '2021-03-14', '21:00', 4);

INSERT INTO PARTY
(ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors,
 venue_Id)
VALUES
    (nextval('PARTY_SEQ'), 'Zoetzuur', null, null, 'Zoete house / Zure techno',
     '2021-03-21', '21:00', 4);

INSERT INTO PARTY
(ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors,
 venue_Id)
VALUES
    (nextval('PARTY_SEQ'), 'Oldies but Goldies', null, null, 'afterparty@home van THE BOX!',
     '2020-03-28', '21:00', 4);

INSERT INTO PARTY
(ID, name, price_presale_in_eur, price_in_eur, extra_info, date, doors,
 venue_Id)
VALUES
    (nextval('PARTY_SEQ'), 'Tommorowland', 325, 395, 'Zeker de echte tommorowland!',
     '2022-04-01', '16:00', 12);

--party artist
INSERT INTO PARTY_ARTISTS (PARTIES_ID, ARTISTS_ID) VALUES (1, 1);
INSERT INTO PARTY_ARTISTS (PARTIES_ID, ARTISTS_ID) VALUES (1, 2);
INSERT INTO PARTY_ARTISTS (PARTIES_ID, ARTISTS_ID) VALUES (2, 2);
INSERT INTO PARTY_ARTISTS (PARTIES_ID, ARTISTS_ID) VALUES (3, 3);
INSERT INTO PARTY_ARTISTS (PARTIES_ID, ARTISTS_ID) VALUES (3, 5);
INSERT INTO PARTY_ARTISTS (PARTIES_ID, ARTISTS_ID) VALUES (4, 5);

--animal
INSERT INTO ANIMAL (ID, NAME, CITY, BIO)
VALUES (1, 'Gillende Giraf', 'Antwerpen', 'Zit al gans mijn levin in de zoo van Antwerpen :-(');

INSERT INTO ANIMAL (ID, NAME, CITY, BIO)
VALUES (2, 'De Olifant', 'Mechelen', 'Geboren en getogen Mechelenaar!');

INSERT INTO ANIMAL (ID, NAME, CITY, BIO)
VALUES (3, 'Dorstige Dromedaris', 'Mortsel', '');

INSERT INTO ANIMAL (ID, NAME, CITY, BIO)
VALUES (4, 'Dansende Draak', 'Lier', 'Van onder de Zimmertoren');

--party animal
INSERT INTO PARTY_ANIMALS (PARTIES_ID, ANIMALS_ID) VALUES (1, 1);
INSERT INTO PARTY_ANIMALS (PARTIES_ID, ANIMALS_ID) VALUES (2, 1);
INSERT INTO PARTY_ANIMALS (PARTIES_ID, ANIMALS_ID) VALUES (2, 3);
INSERT INTO PARTY_ANIMALS (PARTIES_ID, ANIMALS_ID) VALUES (3, 3);
INSERT INTO PARTY_ANIMALS (PARTIES_ID, ANIMALS_ID) VALUES (4, 3);
INSERT INTO PARTY_ANIMALS (PARTIES_ID, ANIMALS_ID) VALUES (5, 3);
INSERT INTO PARTY_ANIMALS (PARTIES_ID, ANIMALS_ID) VALUES (1, 4);
INSERT INTO PARTY_ANIMALS (PARTIES_ID, ANIMALS_ID) VALUES (2, 4);