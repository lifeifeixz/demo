package org.gongxaing.made;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.gongxaing.model.Field;
import org.gongxaing.model.Modular;

import java.util.List;

/**
 * 生成table类型
 *
 * @author flysLi
 * @date 2018/3/16
 */
public class MadeTable extends AbstractMadeDefault {
    private static final String TYPE = "-table";
    private static final int INDEX = 0;

    @Override
    public String make(Modular modular) {
        Document product = null;
        if (modular.getType().equals(TYPE)) {
            List<Field> fields = modular.getTds();
            Document template = this.getTemplateByType("table");
            /*抽取模板*/
            product = Jsoup.parse(template.outerHtml());
            //产品table
            Element productTable = product.getElementsByClass("operation").get(0);
            /*产品form*/
            Element productForm = product.getElementsByClass("demo-form-inline").get(0);
            /*查询按钮组件*/
            Element queryBtn = product.getElementById("queryBtn");

            /*组件模板*/
            Element tdTemplate = template.getElementsByClass("td-template").get(0);
            /*输入框模板*/
            Element formInputTemplate = template.getElementsByClass("form-input").get(0);
            /*下拉框模板*/
            Element formSelectTemplate = template.getElementsByClass("form-select").get(0);
            /*时间框模板*/
            Element formTimeTemplate = template.getElementsByClass("form-time").get(0);

            /*清除产品form中的组件*/
            product.getElementsByClass("form-input").remove();
            product.getElementsByClass("form-select").remove();
            product.getElementsByClass("form-time").remove();
            /*清空产品table中的td*/
            product.getElementsByClass("td-template").get(0).remove();
            for (Field field : fields) {
                /*如果包含'：'表示是form组件；否则是td*/
                if (field.getName().indexOf("：") > -1) {
                    Element component = null;
                    if (field.getName().indexOf("时间") > -1 || field.getName().indexOf("日期") > -1) {
                        component = formTimeTemplate.attr("label", field.getName().replaceAll("：", ""));
                    } else {
                        component = formInputTemplate.attr("label", field.getName());
                        component.child(0).attr("placeholder", "请输入" + field.getName().replaceAll("：", ""));
                    }
                    queryBtn.before(component.outerHtml());
                } else {
                    Element td = tdTemplate.attr("label", field.getName());
                    productTable.before(td.outerHtml());
                    // TODO: 2018/3/16 因为property字段还没有收到,先待定此功能
                }
            }
            this.out(product.outerHtml());
        } else {
            return this.madeStrategy.make(modular);
        }
        return product.outerHtml();
    }

    @Override
    public void setMadeStrategy(MadeStrategy madeStrategy) {
        this.madeStrategy = madeStrategy;
    }
}
