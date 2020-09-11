package member.provider.common.utils;

import java.text.DecimalFormat;

public class DistanceUtils {


    //地球半径
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：)
     *	longitude:进度  latitude:纬度
     * @param lng1 经度1
     * @param lat1 纬度1
     * @param lng2 经度2
     * @param lat2 纬度2
     * @return 距离
     */
    public static String getDistance( double lng1,double lat1,double lng2,double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);

        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        //s = s * 1000;如果需要返回单位为米
        DecimalFormat df = new DecimalFormat("0.00");//格式化，区小数后两位
        String distance = df.format(s);

        return distance;
    }

    public static void main(String[] args) {


        //广州番禺桔树村
        double lng1 = 113.309140;
        double lat1 = 23.035502;



        //北京
//        double lng2 = 116.483038;
//        double lat2  = 39.990633;
//
//        113.365686,23.190164;

        //植物园地铁站
//        double lng2 = 113.365686;
//        double lat2  = 23.190164;

        double lng2 = 113.309140;
        double lat2 = 23.035502;

        String distance = getDistance(lng1, lat1, lng2, lat2);
        System.out.println(distance +"km");

    }


   //排序
//    List<HashMap<String,Object>> list = userAddressDao.getByItemId(itemId);
//        for(HashMap<String,Object> map : list){
//        //计算距离
//        String addLon = (String)map.get("longitude");    //场地 精度
//        String addLat = (String)map.get("latitude");      //场地 维度
//        String distance = DistanceUtil.getDistance(userLat, userLon, addLat, addLon);
//        map.put("distance",distance);
//
//        //是否包含了已加入的场地id 返回true和false
//        Integer addressId = (Integer)map.get("addressId");
//        boolean result = Arrays.asList(addressIdArray).contains(addressId);
//        map.put("isIn",result);
//    }
//
//    //按照距离排序(由远到近)
//        Collections.sort(list, new Comparator<Map<String, Object>>(){
//        public int compare(Map<String, Object> o1, Map<String, Object> o2) {
//            String distance1 =(String)o1.get("distance");  //name1是从你list里面拿出来的第一个name
//            String distance2= (String)o2.get("distance");  //name2是从你list里面拿出来的第二个name
//            return distance2.compareTo(distance1);
//        }
//    });
//    //倒叙list排序
//        Collections.reverse(list);
}
