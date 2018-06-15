from crawler.utils.DataWriteUtils import DataWriteUtils
from crawler.utils.DataReadUtils import DataReadUtils

data = DataReadUtils.readFile("D:\\L临时数据\\passOrderDetail.html")
print(data)
DataWriteUtils.appendData("D:\\L临时数据\\一亿条数据.txt", "I am append's content")
print("programe over")
