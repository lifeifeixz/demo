import pymongo as pm

client = pm.MongoClient("localhost", 27017)
base = "travel"
db = client.base

stb = db.user

datas = stb.find()
f = open("D:\\user.json", "a", encoding="utf-8")

for data in datas:
    f.write(data["mobile_num"])
    f.write("\n")

print("over")