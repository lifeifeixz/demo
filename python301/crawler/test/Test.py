# -*- coding: utf-8 -*-
from crawler.utils.DataReadUtils import DataReadUtils

data = DataReadUtils.pullNetData("http://blog.csdn.net/oscer2016/article/details/70209144")

print(data.decode('utf-8', 'ignore'))
