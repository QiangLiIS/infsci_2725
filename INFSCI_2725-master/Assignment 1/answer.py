# -*- coding: utf-8 -*
import sys
import pymongo
import re
from pymongo import MongoClient
from bson.son import SON

#connect the database
client = MongoClient()
db = client.test
movie = db.movies
rating = db.ratings
tag = db.tags

#1 What genre is the movie CopyCat in?
print "What genre is the movie CopyCat in?"
reExp = re.compile('.*CopyCat.*', re.IGNORECASE)
for genre in movie.find({"Title":reExp},["Genres"]):
	print genre["Genres"]
#2 what genre has the most movies?
print ""
print "what genre has the most movies?"
pipeline = [{"$unwind": "$Genres"},{"$group":{"_id":"$Genres", "count":{"$sum":1}}},{"$sort":SON([("count",-1),("_id",-1)])}]
for temp in movie.aggregate(pipeline):
	print temp['_id']
	break
#3 what tags did user 146 use to describe the movie "2001: A Space Odyssey”
print ""
print "what tags did user 146 use to describe the movie '2001: A Space Odyssey'?"
reExp = re.compile('.*2001: A Space Odyssey.*', re.IGNORECASE)
for mid in movie.find({"Title":reExp },["MovieID"]):
	MovieID = mid['MovieID']
for rate in tag.find({"UserID":"146","MovieID":MovieID},["Tag"]):
	print rate['Tag']
#4 What are the top 5 movies with the highest avg rating?  
print ""
print "What are the top 5 movies with the highest avg rating?"
pipeline = [{"$group":{"_id":"$MovieID", "avgRating":{"$avg":"$Rating"}}},
            {"$sort":SON([("avgRating",-1),("_id",1)])}]
l1 = []
i=0
for temp in rating.aggregate(pipeline):
	l1.append(str(temp['_id']))
	i +=1
	if(i==5):
		break
for name in movie.find({"$or":[{"MovieID":l1[0]},{"MovieID":l1[1]},{"MovieID":l1[2]},{"MovieID":l1[3]},{"MovieID":l1[4]}]},["Title"]):
	print name['Title']

#5 What is the highest avg rating possible?
print ""
print "What is the highest avg rating possible?"
for temp in rating.aggregate(pipeline):
	print temp['avgRating']
	break
#6 Write 3 different queries of your choice to demonstrate that your data storage is working.
print ""
print "Write 3 different queries of your choice to demonstrate that your data storage is working."
print movie.find_one()
print rating.find_one()
print tag.find_one()