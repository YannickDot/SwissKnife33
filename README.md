SwissKnife33
============

Une application Android utilisant les données openData de la ville de Bordeaux.

- [Défibrillateurs](http://opendata.bordeaux.fr/defibrillateurs)
- [Toilettes publiques](http://opendata.bordeaux.fr/content/toilettes-publiques)
- [Nichoirs](http://opendata.bordeaux.fr/emplacement-des-nichoirs)
- [Parkings publics](http://opendata.bordeaux.fr/content/parkings-publics)


## Designs & Mockups

Les designs de l'application sont disponibles ici : 
(N'hésitez pas a visiter ces liens depuis votre téléphone ou redimensionner votre navigateur pour switcher entre le layout mobile et tablette)

- [Page principale](https://www.polymer-project.org/tools/designer/preview.html#f4b17c79d57e48bcbf89)


## Répartition des taches  

- Couche Présenter : Interface (Checkboxes, Navigation Drawer) [Idyr, Yannick]
- Couche DAO : Récupération des données en JSON [Yannick]
- Préparer l'architecture [Yvon]
- Configuration et manipulation de Google Map (Afficher des markers, Zoom, position initiale) [Souhaib, Sarah]
- Parsers pour chaque type de data [Sarah]
- Persistence des données (fichier ou SharedPrefences) ... 

Markers : Créer un marker - Utiliser l'architecture en couche similaire pour stocker les marqueurs dans un fichier ou un SharedPrefences 


## Architecture 

- Présenter : ParkingBusiness.getParkings() => Collection de Parking à afficher
- Business : ParkingConverter.getParkings() => Collection de Parking 
- Converter : ParkingDAO.getParkings() => Collection de ParkingDTO
- DAO : Appel au webservice -> JSON String -> ParkingParser -> Collection de ParkingDTO



