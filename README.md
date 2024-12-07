# **GenerateurConvention**

## **Description**
Application Spring Boot pour gérer la génération de conventions au format PDF, avec une gestion avancée des erreurs et des logs associés.

---

## **Fonctionnalités**
- **Upload de fichiers binaires** : Importation et gestion des modèles de convention.
- **Génération de PDF** : Création de conventions au format PDF basées sur des modèles prédéfinis.
- **Gestion des erreurs** : Ajout et suivi des erreurs associées aux conventions.
- **Gestion des logs** : Suivi des appels, incluant les détails des succès et des erreurs.
- **Documentation API** : Accès et exploration via Swagger.

---

## **Structure des branches**
- **`main`** : Code stable prêt pour la production.
- **`develop`** : Intégration continue et développement en cours.
- **`feature/gestion-binaire`** : Fonctionnalité liée à la gestion des fichiers binaires.
- **`feature/generation-pdf`** : Développement pour la génération de PDF.
- **`feature/gestion-conventions`** : Gestion des conventions, y compris les erreurs et les logs.

---

## **Lancer le projet**
1. **Cloner le projet** :
   ```bash
   git clone https://github.com/<ton-utilisateur>/GenerateurConvention.git
   ```
2. **Accéder au répertoire du projet** :
   ```bash
   cd GenerateurConvention
   ```
3. **Configurer les dépendances** :
   Assurez-vous que Maven est installé, puis exécutez :
   ```bash
   mvn clean install
   ```
4. **Démarrer l'application** :
   Lancez le projet Spring Boot :
   ```bash
   mvn spring-boot:run
   ```

---

## **Utilisation**
1. **Documentation API Swagger** :
   L'API est documentée et accessible via :
   [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

2. **Gestion des conventions** :
   - Liste des conventions : `GET /api/conventions`
   - Ajouter une erreur à une convention : `POST /api/conventions/{id}/errors`
   - Récupérer les logs d'une convention : `GET /api/conventions/{id}/logs`

3. **Exemple d'appel avec Postman** :
   - **URL** : `POST /api/conventions/1/errors`
   - **Body** :
     ```json
     {
       "errorDetails": "Erreur détectée dans la convention."
     }
     ```

---

## **Prérequis**
- **Java 17+**
- **Maven**
- **Base de données PostgreSQL (configurable dans `application.properties`)**

---

## **Contribution**
1. **Créer une branche** pour vos modifications :
   ```bash
   git checkout -b feature/nom-de-votre-fonctionnalité
   ```
2. **Faire une Pull Request** une fois les changements terminés.

---

## **Auteur**
Projet maintenu par **Elsa HADJADJ**.

---