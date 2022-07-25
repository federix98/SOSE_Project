import requests
import random

# tt0411008 : LOST
FILM_IDS = ['tt0411008']

def populate_reviews(n_users):
    URL = "http://localhost:8080/ReviewDataService/rest/Review/insertReview?filmID=%s&title=%s&text=%s&userID=%d"
    for film_id in FILM_IDS:
        for i_user in range(n_users):
            res = requests.get(URL % (film_id, "Review title %d" % (random.randint(0, 1000)), "Test auto-generated review for film %s and user %d" % (film_id, i_user), i_user))
            print("[REVIEW] ", "FILM", film_id, "USER", i_user, res.json())

def populate_ratings(n_users):
    URL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/addRatings?userId=%d&filmId=%s&filmDirectionRating=%d&actorsRating=%d&globalScoreRating=%d&dialoguesRating=%d&costumesRating=%d"
    for film_id in FILM_IDS:
        for i_user in range(n_users):
            res = requests.get(URL % (i_user, film_id, random.randint(0, 10), random.randint(0, 10), random.randint(0, 10), random.randint(0, 10), random.randint(0, 10)))
            print("[RATING] ", "FILM", film_id, "USER", i_user, res.json())

def populate_users(n_users):
    return

if __name__ == "__main__":
    populate_users(n_users = 30)
    populate_reviews(n_users = 30)
    populate_ratings(n_users = 30)