#API AVIS RESTAURANTS

## Fonctionnalités 
- Lister les restaurants
- lister les avis d'un restaurant
- créer un avis
- supprimer un avis
- créer un client
## Classes
- RestaurantType: Enum {BURGER, ITALIEN, ASIAT, FRANCAIS,INDIEN}
- Restaurant
    - Nom : String
    - Adresse : String
    - Nbre de couverts: Integer
    - Type : RestaurantType
- Client
    - Nom: String
    - Prénom : String
    - Email: String
- Avis
    - Note: Integer
    - commentaire : String          