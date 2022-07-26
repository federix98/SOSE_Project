# Service Oriented Software Engineering - About the project
This repo is for the *Service Oriented Software Engineering* course project. 

University of L'Aquila.

## Getting Started
----
This application consists of a set of services and microservices that have to be started inside a server to run the whole system.

### Prerequisites
In order to run this project, be sure that you have installed:
- Apache Tomcat (Tested with version 8.5.81)
- Java and JAVA_HOME set
- Eclipse IDE for Enterprise Java Developers
- Nginx


### Installations

To install the application follow these steps:
1. Get a free API Key at [https://imdb-api.com/](https://imdb-api.com/)
2. Clone the repo
   ```sh
   git clone https://github.com/federix98/SOSE_Project.git
   ```
3. Enter your API in `FilmSearchProsumer/src/main/java/it/univaq/disim/sose/search/SearchImpl.java`
   ```js
   private String API_KEY = "ENTER YOUR API";
   ```
   and in `FilmDetailsProsumer/src/main/java/it/univaq/disim/sose/filmdetails/data/IMDBRestClient.java`
   ```js
   private static final String APIKey = "k_dm7b3skf";
   ```
5. Open Eclipse IDE, create a new Tomcat instance and run all the services:
   1. AuthService
   2. FilmDetailsProsumer
   3. FilmDetailsAggregator
   4. FilmSearchProsumer
   5. RatingUpdaterRESTService
   6. ReviewDataService
   7. ReviewEditorProsumer
6. Install Android application

## Usage

Opening the android application you can search for movies and tv series and you can open it. Clicking on one result, you will be redirected thru the details page in which you'll see all the film metadata, the averages of the ratings, the summary global score and the reviews of that film.
You can also sign up and sign in and you can rate and write a review for a movie or tv series.

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Contact
This project has been realized for educational purposes.

Authors profiles:
- https://github.com/Scholastiqueuwizeyimana
- https://github.com/GianlucaRea
- https://github.com/alessandrodimatteo97
- https://github.com/federix98
