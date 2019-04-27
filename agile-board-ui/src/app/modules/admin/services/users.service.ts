import { Injectable } from '@angular/core';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor() { }

  getAll(): User[] {
    return USER_DATA;
  }
}

const USER_DATA: User[] = [
  {
    "id": 1,
    "email": "elit.pretium@sit.ca",
    "firstName": "Jack",
    "lastName": "Kibo",
    "lastLogin": "2018-08-23T10:42:33-07:00"
  },
  {
    "id": 2,
    "email": "pharetra@dignissimpharetraNam.org",
    "firstName": "Zoe",
    "lastName": "Wylie",
    "lastLogin": "2019-04-21T10:20:48-07:00"
  },
  {
    "id": 3,
    "email": "orci@augueeu.net",
    "firstName": "Yardley",
    "lastName": "Micah",
    "lastLogin": "2019-08-08T02:18:32-07:00"
  },
  {
    "id": 4,
    "email": "id@interdumlibero.co.uk",
    "firstName": "Hedwig",
    "lastName": "Tate",
    "lastLogin": "2019-11-12T11:49:25-08:00"
  },
  {
    "id": 5,
    "email": "vitae.sodales@liberonecligula.ca",
    "firstName": "Samuel",
    "lastName": "Kuame",
    "lastLogin": "2020-02-05T08:30:41-08:00"
  },
  {
    "id": 6,
    "email": "Sed.dictum.Proin@inmolestie.co.uk",
    "firstName": "Allegra",
    "lastName": "Cade",
    "lastLogin": "2019-01-22T11:40:43-08:00"
  },
  {
    "id": 7,
    "email": "vitae.erat.Vivamus@massa.edu",
    "firstName": "Felix",
    "lastName": "Dexter",
    "lastLogin": "2019-07-08T02:47:46-07:00"
  },
  {
    "id": 8,
    "email": "adipiscing.enim.mi@sitamet.com",
    "firstName": "Neil",
    "lastName": "Gannon",
    "lastLogin": "2019-08-05T22:23:31-07:00"
  },
  {
    "id": 9,
    "email": "eget.varius.ultrices@arcuet.org",
    "firstName": "Gail",
    "lastName": "Joshua",
    "lastLogin": "2019-01-16T12:37:13-08:00"
  },
  {
    "id": 10,
    "email": "gravida.non@sedturpis.net",
    "firstName": "Phyllis",
    "lastName": "John",
    "lastLogin": "2018-12-26T02:40:22-08:00"
  },
  {
    "id": 11,
    "email": "egestas.a@Cumsociis.ca",
    "firstName": "William",
    "lastName": "Dalton",
    "lastLogin": "2020-02-23T03:17:28-08:00"
  },
  {
    "id": 12,
    "email": "non.feugiat@ridiculusmusProin.edu",
    "firstName": "Aretha",
    "lastName": "Trevor",
    "lastLogin": "2018-08-03T05:27:22-07:00"
  },
  {
    "id": 13,
    "email": "Mauris@tristiquepellentesque.co.uk",
    "firstName": "Edward",
    "lastName": "Ira",
    "lastLogin": "2018-04-28T20:11:03-07:00"
  },
  {
    "id": 14,
    "email": "ut@lectus.net",
    "firstName": "Colt",
    "lastName": "Slade",
    "lastLogin": "2018-09-10T03:37:46-07:00"
  },
  {
    "id": 15,
    "email": "purus.mauris.a@elitEtiamlaoreet.net",
    "firstName": "Julian",
    "lastName": "Camden",
    "lastLogin": "2018-10-21T15:32:18-07:00"
  },
  {
    "id": 16,
    "email": "egestas@Etiamvestibulum.edu",
    "firstName": "Preston",
    "lastName": "Gil",
    "lastLogin": "2019-07-28T13:01:36-07:00"
  },
  {
    "id": 17,
    "email": "nulla.Integer.vulputate@ullamcorpereueuismod.org",
    "firstName": "Maryam",
    "lastName": "Callum",
    "lastLogin": "2019-08-22T20:20:18-07:00"
  },
  {
    "id": 18,
    "email": "lacinia.mattis@ornare.net",
    "firstName": "Reagan",
    "lastName": "Carter",
    "lastLogin": "2019-03-01T13:04:48-08:00"
  },
  {
    "id": 19,
    "email": "egestas@mattisInteger.edu",
    "firstName": "David",
    "lastName": "Melvin",
    "lastLogin": "2018-12-02T17:36:17-08:00"
  },
  {
    "id": 20,
    "email": "mauris.a.nunc@a.org",
    "firstName": "Haviva",
    "lastName": "Callum",
    "lastLogin": "2018-06-14T09:54:42-07:00"
  },
  {
    "id": 21,
    "email": "ullamcorper@nunc.edu",
    "firstName": "Nicole",
    "lastName": "Erasmus",
    "lastLogin": "2018-08-08T01:28:59-07:00"
  },
  {
    "id": 22,
    "email": "ac.facilisis@Aliquam.org",
    "firstName": "Jane",
    "lastName": "Rashad",
    "lastLogin": "2019-09-14T01:05:16-07:00"
  },
  {
    "id": 23,
    "email": "vel.sapien@semconsequatnec.net",
    "firstName": "Kimberly",
    "lastName": "Akeem",
    "lastLogin": "2019-12-12T13:13:23-08:00"
  },
  {
    "id": 24,
    "email": "non.lorem@metusurna.ca",
    "firstName": "Summer",
    "lastName": "Nolan",
    "lastLogin": "2018-12-11T10:49:26-08:00"
  },
  {
    "id": 25,
    "email": "ac@ipsumdolorsit.co.uk",
    "firstName": "Lev",
    "lastName": "Rudyard",
    "lastLogin": "2019-05-16T01:33:35-07:00"
  },
  {
    "id": 26,
    "email": "lorem.vehicula.et@semperNam.org",
    "firstName": "Nita",
    "lastName": "Kennan",
    "lastLogin": "2019-02-13T12:18:51-08:00"
  },
  {
    "id": 27,
    "email": "a.feugiat.tellus@nuncacmattis.com",
    "firstName": "Lance",
    "lastName": "Kadeem",
    "lastLogin": "2019-03-26T19:54:16-07:00"
  },
  {
    "id": 28,
    "email": "morbi.tristique.senectus@liberodui.co.uk",
    "firstName": "Chaim",
    "lastName": "Kenyon",
    "lastLogin": "2018-08-26T13:00:56-07:00"
  },
  {
    "id": 29,
    "email": "Ut@Etiam.org",
    "firstName": "Kirk",
    "lastName": "Julian",
    "lastLogin": "2019-02-17T10:42:05-08:00"
  },
  {
    "id": 30,
    "email": "elit.elit.fermentum@atsem.net",
    "firstName": "Ryder",
    "lastName": "Christopher",
    "lastLogin": "2018-05-16T01:36:12-07:00"
  },
  {
    "id": 31,
    "email": "lacinia.orci@habitantmorbitristique.com",
    "firstName": "Boris",
    "lastName": "Wallace",
    "lastLogin": "2018-06-28T14:49:08-07:00"
  },
  {
    "id": 32,
    "email": "tortor@dictumeleifend.org",
    "firstName": "Jeremy",
    "lastName": "Abdul",
    "lastLogin": "2018-06-23T03:45:07-07:00"
  },
  {
    "id": 33,
    "email": "sit.amet.diam@sedpedeCum.co.uk",
    "firstName": "Wynne",
    "lastName": "Edan",
    "lastLogin": "2020-01-30T03:44:34-08:00"
  },
  {
    "id": 34,
    "email": "vulputate.lacus.Cras@hendrerit.ca",
    "firstName": "Lareina",
    "lastName": "Maxwell",
    "lastLogin": "2019-11-02T06:46:42-07:00"
  },
  {
    "id": 35,
    "email": "sollicitudin.commodo.ipsum@Curae.edu",
    "firstName": "Courtney",
    "lastName": "Plato",
    "lastLogin": "2019-08-07T13:15:50-07:00"
  },
  {
    "id": 36,
    "email": "commodo.ipsum@nibhvulputatemauris.co.uk",
    "firstName": "Simon",
    "lastName": "Ezra",
    "lastLogin": "2019-09-22T15:49:21-07:00"
  },
  {
    "id": 37,
    "email": "ultricies@tempusnonlacinia.ca",
    "firstName": "Hayden",
    "lastName": "Ignatius",
    "lastLogin": "2019-11-24T22:35:46-08:00"
  },
  {
    "id": 38,
    "email": "Nulla@lacusvariuset.org",
    "firstName": "Christen",
    "lastName": "Ian",
    "lastLogin": "2019-07-02T07:36:38-07:00"
  },
  {
    "id": 39,
    "email": "id.sapien.Cras@Namnulla.net",
    "firstName": "Tamekah",
    "lastName": "Chaim",
    "lastLogin": "2019-05-07T17:50:53-07:00"
  },
  {
    "id": 40,
    "email": "ut.cursus.luctus@velitdui.ca",
    "firstName": "Stewart",
    "lastName": "Allen",
    "lastLogin": "2019-10-05T17:08:14-07:00"
  },
  {
    "id": 41,
    "email": "dui.in@vel.net",
    "firstName": "Nell",
    "lastName": "Chadwick",
    "lastLogin": "2019-04-20T02:00:36-07:00"
  },
  {
    "id": 42,
    "email": "sed.leo@Sedauctor.org",
    "firstName": "Cassady",
    "lastName": "Kareem",
    "lastLogin": "2020-04-04T11:58:40-07:00"
  },
  {
    "id": 43,
    "email": "semper.tellus@Nam.co.uk",
    "firstName": "Logan",
    "lastName": "Harrison",
    "lastLogin": "2019-10-15T05:17:25-07:00"
  },
  {
    "id": 44,
    "email": "rhoncus.Donec.est@Phasellusdapibus.com",
    "firstName": "Zorita",
    "lastName": "Demetrius",
    "lastLogin": "2019-01-12T15:53:34-08:00"
  },
  {
    "id": 45,
    "email": "magna.Sed.eu@esttempor.com",
    "firstName": "Laurel",
    "lastName": "Lamar",
    "lastLogin": "2019-06-20T22:48:48-07:00"
  },
  {
    "id": 46,
    "email": "eu.euismod.ac@nonfeugiatnec.co.uk",
    "firstName": "Colby",
    "lastName": "Edward",
    "lastLogin": "2019-09-14T18:31:40-07:00"
  },
  {
    "id": 47,
    "email": "diam.Proin@mollis.co.uk",
    "firstName": "Noble",
    "lastName": "Elton",
    "lastLogin": "2019-05-23T01:25:39-07:00"
  },
  {
    "id": 48,
    "email": "Curae.Donec@arcuacorci.co.uk",
    "firstName": "Zelenia",
    "lastName": "Finn",
    "lastLogin": "2019-11-19T01:14:25-08:00"
  },
  {
    "id": 49,
    "email": "fringilla.purus@quam.com",
    "firstName": "Deirdre",
    "lastName": "Carson",
    "lastLogin": "2019-11-16T12:55:59-08:00"
  },
  {
    "id": 50,
    "email": "ultricies.ligula.Nullam@antedictummi.ca",
    "firstName": "Dora",
    "lastName": "Cooper",
    "lastLogin": "2019-08-19T13:30:36-07:00"
  },
  {
    "id": 51,
    "email": "dui@arcuVestibulumut.edu",
    "firstName": "Plato",
    "lastName": "Abraham",
    "lastLogin": "2019-01-09T18:48:21-08:00"
  },
  {
    "id": 52,
    "email": "nunc.interdum.feugiat@dolorvitaedolor.net",
    "firstName": "Nicole",
    "lastName": "Buckminster",
    "lastLogin": "2018-08-02T10:00:55-07:00"
  },
  {
    "id": 53,
    "email": "odio.Etiam@semper.net",
    "firstName": "Avram",
    "lastName": "Zephania",
    "lastLogin": "2020-03-01T11:50:56-08:00"
  },
  {
    "id": 54,
    "email": "erat.eget.tincidunt@velitinaliquet.net",
    "firstName": "Stacy",
    "lastName": "Kibo",
    "lastLogin": "2018-07-19T13:35:55-07:00"
  },
  {
    "id": 55,
    "email": "aliquet.Proin.velit@purusin.net",
    "firstName": "Ursula",
    "lastName": "Dante",
    "lastLogin": "2018-12-05T18:30:42-08:00"
  },
  {
    "id": 56,
    "email": "Integer.aliquam.adipiscing@quam.com",
    "firstName": "Richard",
    "lastName": "Wyatt",
    "lastLogin": "2019-08-28T07:23:54-07:00"
  },
  {
    "id": 57,
    "email": "tristique.ac.eleifend@sitametmetus.com",
    "firstName": "Curran",
    "lastName": "Grady",
    "lastLogin": "2018-08-27T05:59:46-07:00"
  },
  {
    "id": 58,
    "email": "justo.nec@odioNaminterdum.net",
    "firstName": "Akeem",
    "lastName": "Garrison",
    "lastLogin": "2018-11-08T20:55:28-08:00"
  },
  {
    "id": 59,
    "email": "nostra.per@Cumsociis.co.uk",
    "firstName": "Rowan",
    "lastName": "Joel",
    "lastLogin": "2020-02-04T21:41:37-08:00"
  },
  {
    "id": 60,
    "email": "eros@euodiotristique.net",
    "firstName": "Luke",
    "lastName": "Alfonso",
    "lastLogin": "2018-12-07T21:16:19-08:00"
  },
  {
    "id": 61,
    "email": "magnis.dis@velquam.edu",
    "firstName": "Emmanuel",
    "lastName": "Leo",
    "lastLogin": "2019-09-13T23:27:18-07:00"
  },
  {
    "id": 62,
    "email": "neque.sed.dictum@est.edu",
    "firstName": "Walter",
    "lastName": "Drew",
    "lastLogin": "2019-09-27T17:59:10-07:00"
  },
  {
    "id": 63,
    "email": "tempus.lorem.fringilla@mattisIntegereu.org",
    "firstName": "Erich",
    "lastName": "Jonas",
    "lastLogin": "2018-04-28T05:13:49-07:00"
  },
  {
    "id": 64,
    "email": "sed.facilisis@nonfeugiatnec.edu",
    "firstName": "Madison",
    "lastName": "Noble",
    "lastLogin": "2019-04-06T03:07:53-07:00"
  },
  {
    "id": 65,
    "email": "Nunc.ac@dictum.ca",
    "firstName": "Eaton",
    "lastName": "Amery",
    "lastLogin": "2019-02-18T08:56:48-08:00"
  },
  {
    "id": 66,
    "email": "Suspendisse.aliquet@dignissim.net",
    "firstName": "Isabella",
    "lastName": "Yuli",
    "lastLogin": "2018-10-19T06:19:24-07:00"
  },
  {
    "id": 67,
    "email": "Sed@nisiCum.ca",
    "firstName": "Sean",
    "lastName": "Beau",
    "lastLogin": "2019-07-01T08:34:53-07:00"
  },
  {
    "id": 68,
    "email": "a.dui.Cras@in.edu",
    "firstName": "Eve",
    "lastName": "Hunter",
    "lastLogin": "2019-12-29T19:22:23-08:00"
  },
  {
    "id": 69,
    "email": "mauris.Integer@dolor.ca",
    "firstName": "Howard",
    "lastName": "Geoffrey",
    "lastLogin": "2019-02-03T08:27:46-08:00"
  },
  {
    "id": 70,
    "email": "bibendum.ullamcorper@blanditat.net",
    "firstName": "Kamal",
    "lastName": "Hall",
    "lastLogin": "2019-08-28T00:25:34-07:00"
  },
  {
    "id": 71,
    "email": "eu.turpis@pellentesque.org",
    "firstName": "Sloane",
    "lastName": "Rooney",
    "lastLogin": "2020-01-18T12:21:02-08:00"
  },
  {
    "id": 72,
    "email": "vel.vulputate@Fuscefeugiat.co.uk",
    "firstName": "Janna",
    "lastName": "Simon",
    "lastLogin": "2020-02-15T23:45:50-08:00"
  },
  {
    "id": 73,
    "email": "lobortis.augue@mauriseuelit.net",
    "firstName": "Bevis",
    "lastName": "Fulton",
    "lastLogin": "2020-02-13T23:00:23-08:00"
  },
  {
    "id": 74,
    "email": "quis@Nunc.com",
    "firstName": "Camille",
    "lastName": "Lucas",
    "lastLogin": "2018-08-10T11:37:42-07:00"
  },
  {
    "id": 75,
    "email": "bibendum.ullamcorper.Duis@Sed.ca",
    "firstName": "Alisa",
    "lastName": "Davis",
    "lastLogin": "2020-03-11T05:44:08-07:00"
  },
  {
    "id": 76,
    "email": "scelerisque@Maurisvelturpis.com",
    "firstName": "Martena",
    "lastName": "Jason",
    "lastLogin": "2019-09-08T12:37:23-07:00"
  },
  {
    "id": 77,
    "email": "nec@maurisblandit.net",
    "firstName": "Basia",
    "lastName": "Damon",
    "lastLogin": "2018-09-23T04:10:27-07:00"
  },
  {
    "id": 78,
    "email": "lorem.ut.aliquam@Sed.co.uk",
    "firstName": "Alan",
    "lastName": "Cullen",
    "lastLogin": "2018-06-01T07:02:52-07:00"
  },
  {
    "id": 79,
    "email": "elit@nislQuisquefringilla.co.uk",
    "firstName": "Nayda",
    "lastName": "Buckminster",
    "lastLogin": "2018-06-19T19:56:39-07:00"
  },
  {
    "id": 80,
    "email": "eros.Proin.ultrices@ipsum.co.uk",
    "firstName": "Uta",
    "lastName": "Armando",
    "lastLogin": "2018-08-26T03:09:48-07:00"
  },
  {
    "id": 81,
    "email": "mi.fringilla.mi@estNunclaoreet.net",
    "firstName": "Dustin",
    "lastName": "Gregory",
    "lastLogin": "2018-07-08T11:36:21-07:00"
  },
  {
    "id": 82,
    "email": "et.lacinia@actellusSuspendisse.co.uk",
    "firstName": "Grace",
    "lastName": "Zachery",
    "lastLogin": "2019-09-14T09:31:56-07:00"
  },
  {
    "id": 83,
    "email": "libero.et@ultricies.net",
    "firstName": "Cedric",
    "lastName": "Ralph",
    "lastLogin": "2019-04-23T21:38:13-07:00"
  },
  {
    "id": 84,
    "email": "Aenean@magnaUt.com",
    "firstName": "Winter",
    "lastName": "Brennan",
    "lastLogin": "2019-05-15T16:52:45-07:00"
  },
  {
    "id": 85,
    "email": "turpis.Nulla.aliquet@convallis.com",
    "firstName": "Abraham",
    "lastName": "Carter",
    "lastLogin": "2019-01-22T05:19:15-08:00"
  },
  {
    "id": 86,
    "email": "lorem.fringilla.ornare@eu.edu",
    "firstName": "Asher",
    "lastName": "Stewart",
    "lastLogin": "2019-06-19T00:32:43-07:00"
  },
  {
    "id": 87,
    "email": "Phasellus.fermentum.convallis@massalobortisultrices.edu",
    "firstName": "Eagan",
    "lastName": "Ishmael",
    "lastLogin": "2020-02-02T11:04:27-08:00"
  },
  {
    "id": 88,
    "email": "id.mollis@orci.co.uk",
    "firstName": "Caesar",
    "lastName": "Phelan",
    "lastLogin": "2020-01-11T01:55:07-08:00"
  },
  {
    "id": 89,
    "email": "pharetra@Fusce.ca",
    "firstName": "Gannon",
    "lastName": "Tucker",
    "lastLogin": "2019-05-20T17:12:35-07:00"
  },
  {
    "id": 90,
    "email": "sit.amet@Maecenasmi.net",
    "firstName": "Gannon",
    "lastName": "Cooper",
    "lastLogin": "2019-01-10T21:49:02-08:00"
  },
  {
    "id": 91,
    "email": "euismod.in.dolor@orci.co.uk",
    "firstName": "Ethan",
    "lastName": "Callum",
    "lastLogin": "2019-05-21T09:53:11-07:00"
  },
  {
    "id": 92,
    "email": "sociis.natoque.penatibus@pellentesqueegetdictum.org",
    "firstName": "Mufutau",
    "lastName": "Silas",
    "lastLogin": "2018-09-29T04:10:04-07:00"
  },
  {
    "id": 93,
    "email": "Duis.risus.odio@vulputatelacusCras.net",
    "firstName": "Britanney",
    "lastName": "Cadman",
    "lastLogin": "2020-03-01T22:51:19-08:00"
  },
  {
    "id": 94,
    "email": "et.ultrices.posuere@Quisqueornaretortor.ca",
    "firstName": "Chiquita",
    "lastName": "Clarke",
    "lastLogin": "2019-04-13T06:56:27-07:00"
  },
  {
    "id": 95,
    "email": "dolor.sit.amet@liberoProinmi.co.uk",
    "firstName": "Chandler",
    "lastName": "Sawyer",
    "lastLogin": "2019-08-29T10:09:44-07:00"
  },
  {
    "id": 96,
    "email": "elementum.sem.vitae@esttempor.ca",
    "firstName": "Jana",
    "lastName": "Wayne",
    "lastLogin": "2019-08-16T02:04:29-07:00"
  },
  {
    "id": 97,
    "email": "scelerisque.lorem.ipsum@feugiat.co.uk",
    "firstName": "Logan",
    "lastName": "Eagan",
    "lastLogin": "2019-12-08T20:54:50-08:00"
  },
  {
    "id": 98,
    "email": "nec.tempus@malesuadaInteger.org",
    "firstName": "George",
    "lastName": "Logan",
    "lastLogin": "2019-09-02T22:29:51-07:00"
  },
  {
    "id": 99,
    "email": "a@lacusvariuset.net",
    "firstName": "Ivor",
    "lastName": "Herrod",
    "lastLogin": "2018-12-05T11:25:35-08:00"
  },
  {
    "id": 100,
    "email": "ipsum@esttemporbibendum.edu",
    "firstName": "Mohammad",
    "lastName": "Judah",
    "lastLogin": "2019-12-31T17:57:22-08:00"
  }
];
