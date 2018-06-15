import io
import sys
import urllib.request

from crawler.ansyle import ansyle
from crawler.utils.DataReadUtils import DataReadUtils

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='gb18030')

res = DataReadUtils.readFile("C:\\Users\\flysLi\\Desktop\\sina.html")
ale = ansyle(res)
a_tags = ale.collectLinks()
print(len(a_tags))
