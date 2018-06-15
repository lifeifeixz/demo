# coding=UTF-8
class warehouse:
    links = []
    visiteds = []

    @staticmethod
    def getInstance():
        return warehouse()

    # 在实例化仓库的时候需要传入一个link
    # def __init__(self, link):
    #     self.links.append(link)

    # 重复验证
    def isExist(self, link):
        is_exist = False
        if link in self.links and link in self.visiteds:
            is_exist = True
        return is_exist

    # 添加一个元素
    def add(self, link):
        if self.isExist(link):
            self.links.append(link)

    # 标记一个元素为已访问
    def visited(self, link):
        if link in self.links:
            self.links.remove(link)
            self.visiteds.append(link)

    # 批量入库
    def addAll(self, links):
        for x in links:
            self.add(x)

    # 取出当前第一个元素
    def next(self):
        return self.links[0]
