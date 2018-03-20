package cn.jxufe.util;

import java.io.Serializable;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
 
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
 
/**
 * 请求信息封装到对象
 * @author   zhagnpeng
 * @Date     Aug 5, 2014     
 */
public class FormBeanUtil {
 
    static {
        // 在封装之前 注册转换器
        ConvertUtils.register(new DateTimeConverter(), java.util.Date.class);
    }
 
    /**
     * 请求信息封装到对象
     * 
     * @param request
     *            请求信息
     * @param clazz
     *            封装对象
     */
    @SuppressWarnings("unchecked")
    public static <E extends Serializable> E get(HttpServletRequest request, Class<E> clazz) {
        if (request == null)
            throw new IllegalArgumentException("FormBeanUtil.get中的request为空");
        E obj = null;
        try {
            obj = clazz.newInstance();
            Map<String, String[]> parameterMap = request.getParameterMap();
            BeanUtils.populate(obj, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}