# -*- coding: utf-8 -*-
import io
import os.path
import urllib.request


# 读取文件、网络内容
class DataReadUtils:
    # 根据文件地址读取文件内容
    @staticmethod
    def readFile(path):
        f = open(path, "r", encoding='utf-8')
        data = f.read()
        f.close()
        return data

    # 远程拉取网络资源
    @staticmethod
    def pullNetData(url):
        data = urllib.request.urlopen(url).read()
        return data
