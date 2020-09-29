import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csi.domin.Student;

public class DemoFastJson {
    public static void main(String[] args) {
        Student s = new Student("王富贵", "1001");
        Student s1 = new Student("张真人", "1001");
        s.setStudent(s1);
        s1.setStudent(s);
       Object obj = null;
        JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect);
        //进行格式转换
        String st = JSON.toJSONString(s, SerializerFeature.PrettyFormat);
        System.out.println(st);
        String st2 = JSON.toJSONString(s1, SerializerFeature.PrettyFormat);
        System.out.println(st2);


    }

}
