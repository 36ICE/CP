package cn.jxufe.util;

import org.dom4j.io.OutputFormat;
/**
 * 类 描 述：<b>dom4j输出格式化.</b></br>
 * 备      注:  </br>
 * 创  建   人: yanlei.zhao</br>
 * 创建日期: 2011-12-1</br>
 */
public class DomXmlOutputFormat extends OutputFormat {  
 /**
  * 方法描述：<b>dom4j输出格式化..</b></br>
  * 备          注: 保存Document到xml文件时，xml属性中的回车换行需要保留，
  *    可是发现在使用过程中发现dom4j自动把回车换行去掉了。特写此类</br>
  * 创  建   人: yanlei.zhao</br>
  * 创建日期: 2011-12-1</br>
  * @return
  */

    public static OutputFormat createPrettyPrint() {   
        OutputFormat format = new OutputFormat();   
        format.setIndentSize(2);   
        format.setNewlines(true);   
        format.setTrimText(false); // 覆盖 父类的  format.setTrimText(true);  
        format.setPadText(true);  

        return format;   
    }  

} 