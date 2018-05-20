import com.alibaba.fastjson.JSON;

public class Test {
    public static void main(String[] args) {
        String json = "{\"i\":100}";
        Config config = JSON.parseObject(json, Config.class);
        System.out.println(config.i);
    }
}
