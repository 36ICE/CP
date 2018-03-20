package cn.jxufe.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
 
/**
 * 对象转换
 * @author   yangjian1004
 * @Date     Aug 7, 2014     
 */
public class Mapping {
 
    public static Mapping m = new Mapping();
 
    static {
 
        // 在封装之前 注册转换器
        ConvertUtils.register(new DateTimeConverter(), java.util.Date.class);
    }
 
    /**
     * 将Map对象转换成指定对象
     * @param clazz，指定的转换后的对象。
     * @param map，被转换信息的map。
     * @return clazz参数指定的对象。
     * @since 1.0.0
     */
    public <E extends Serializable> E convertObjectFromMap(Class<E> clazz, Map<String, Object> fromMap) {
 
        if (clazz == null || fromMap == null)
            return null;
 
        E obj = null;
        try {
            obj = clazz.newInstance();
            BeanUtils.populate(obj, fromMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
 
    /**
     * 将对象转换成指定的对象。
     * @param clazz，指定转换成的对象。
     * @param obj，被转换的对象。
     * @return clazz参数指定转换成的对象。
     * @since 1.0.0 
     */
    public <E extends Serializable> E convertObjectFromObject(Class<E> clazz, Object obj) {
        if (clazz == null || obj == null)
            return null;
        E dest = null;
        try {
            dest = clazz.newInstance();
            BeanUtils.copyProperties(dest, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dest;
    }
 
    /**
     * 将原始数据的List转换成指定对象的List。
     * @param clazz，指定转换成的对象。
     * @param objList，原始数据List集合。
     * @return List list内每个对象元素为clazz参数指定的对象。
     * @since 1.0.0 
     */
    public <E extends Serializable> List<E> convertObjectListFromObjectList(Class<E> clazz, List<?> objList) {
        List<E> ret = new ArrayList<E>();
        if (clazz == null || objList == null || objList.size() == 0)
            return ret;
 
        for (Object obj : objList) {
            E e = convertObjectFromObject(clazz, obj);
            ret.add(e);
        }
        return ret;
    }
 
    public static void main(String[] args) {
        /*
        Hotel hotel = new Hotel();
        hotel.setAbridgeName("黄山");
        hotel.setDs(new Date());
        hotel.setHotelId(12l);
        hotel.setHotelName("黄山酒店");
 
        Mapping mapping = new Mapping();
        HotelDto hotelDto = mapping.convertObjectFromObject(HotelDto.class, hotel);
        Debug.println(hotelDto.getDs(), hotelDto.getHotelName(), hotelDto.getHotelId(), hotel.getDs());
        Debug.println("==================");
        List<Hotel> list = new ArrayList<Hotel>();
        list.add(hotel);
 
        List<HotelDto> dtoList = mapping.convertObjectListFromObjectList(HotelDto.class, list);
        Debug.println(dtoList.get(0).getDs());*/
    	
    }
    
    
    
}
