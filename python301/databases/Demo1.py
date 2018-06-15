#!/usr/bin/python3

import pymysql

db = pymysql.connect(host="localhost", user="root", passwd="123456", db="crawler", port=3306, charset="utf8")

cursor = db.cursor()

cursor.execute("SELECT * FROM uri limit 0,10000")
lists = cursor.fetchall()
for row in lists:
    print(row[2])

db.close()
