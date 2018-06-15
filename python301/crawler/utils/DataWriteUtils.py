# coding=UTF-8
import sys
import io


class DataWriteUtils:
    # 往某个文件中追加数据
    @staticmethod
    def appendData(path, data):
        f = open(path, "a", encoding='utf-8')
        data = f.write(data)
        f.close()
