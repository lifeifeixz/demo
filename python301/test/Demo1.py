# coding=UTF-8
import sys
import datetime
import time

from crawler.utils.DataWriteUtils import DataWriteUtils

print(time.strftime("%H:%M:%S"))
arr = []
for i in range(10000):
    DataWriteUtils.appendData("D:\\L临时数据\\一亿条数据.txt","I am append")

print(time.strftime("%H:%M:%S"))
print("game over")
