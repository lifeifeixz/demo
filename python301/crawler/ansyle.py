from bs4 import BeautifulSoup

from crawler.utils.DataReadUtils import DataReadUtils
from crawler.warehouse import warehouse


class ansyle(warehouse):
    base_url = ''

    def __init__(self, url):
        self.base_url = url

    # �ռ������е�url
    def collectLinks(self, dom):
        soup = BeautifulSoup(dom, "html5lib")
        a_tags = soup.find_all("a")
        if len(a_tags) > 0:
            self.addAll(a_tags)
        return a_tags

    # �ֻ�̽��������Դ
    def core(self, url):
        print(url)
        html = DataReadUtils.pullNetData(url)
        self.collectLinks(html)
        self.core(self.next())
